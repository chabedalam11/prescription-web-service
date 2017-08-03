package sa.com.rufaida.controller.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sa.com.rufaida.domain.exam.AndroidExam;
import sa.com.rufaida.service.Database;





@Controller
public class AndroidController {
	
	@RequestMapping("/medisys/insertInfo")
    @ResponseBody
	 public HashMap<String, Object> insertInfo(String  project_name, 
											 String  project_version_name, 
											 String  project_version_code,
											 String  ip_address,
											 String  device_imei,
											 String  device_android_id,
											 String  country_iso,
											 String  device_manufacturer,
											 String  device_brand,
											 String  device_model)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		

        String sql = "INSERT INTO ANDROID_EXAM(PROJECT_NAME,PROJECT_VERSION_NAME,PROJECT_VERSION_CODE, IP_ADDRESS, DEVICE_IMEI,DEVICE_ANDROID_ID,COUNTRY_ISO,DEVICE_MANUFACTURER,DEVICE_BRAND,DEVICE_MODEL) "+
        		"VALUES(?,?,?,?,?,?,?,?,?,?)";
        			
		
		 Connection connection= new Database().getConnection();
		 
		PreparedStatement statement = null;
		
		if(project_name!=null && project_version_name!=null && project_version_code!=null && ip_address!=null && device_imei!=null &&
				device_android_id!=null && country_iso!=null && device_manufacturer!=null && device_brand!=null && device_model!=null){
			
			/*START*/
			
			
			try {
	        	 
	        	 statement = connection.prepareStatement(sql);
	             statement.setString(1, project_name);
	             statement.setString(2, project_version_name);
	             statement.setString(3, project_version_code);
	             statement.setString(4, ip_address);
	             statement.setString(5, device_imei);
	             statement.setString(6, device_android_id);
	             statement.setString(7, country_iso);
	             statement.setString(8, device_manufacturer);
	             statement.setString(9, device_brand);
	             statement.setString(10, device_model);
	            
	             int check = statement.executeUpdate();
	             
	             if(check>0){
	            	 plr.put("message", "your information successfully insert");
	             }else{
	            	 plr.put("message", "information insert failed");
	             }
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(statement!=null){
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(connection!=null){
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
			
			
		/*	END*/
			
			
			
			
		}else{
			plr.put("message", "set value for all parameter");
		}
		
         
         
        
         
         return plr;
     }
	
	
	@RequestMapping("/medisys/retriveInfo")
    @ResponseBody
	 public HashMap<String, Object> selectAllInfo(){
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<AndroidExam> testEntities = new ArrayList<AndroidExam>();

        String sql = "select project_name,project_version_name,project_version_code, ip_address, device_imei,device_android_id,country_iso,device_manufacturer,device_brand,device_model "
        		+ "from android_exam";
        			
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 
            		 
            		 AndroidExam entity = new AndroidExam();
            		 entity.setProject_name(resultSet.getString("project_name"));
            		 entity.setProject_version_name(resultSet.getString("project_version_name"));
            		 entity.setProject_version_code(resultSet.getString("project_version_code"));
            		 entity.setIp_address(resultSet.getString("ip_address"));
            		 entity.setDevice_imei(resultSet.getString("device_imei"));
            		 entity.setDevice_android_id(resultSet.getString("device_android_id"));
            		 entity.setCountry_iso(resultSet.getString("country_iso"));
            		 entity.setDevice_manufacturer(resultSet.getString("device_manufacturer"));
            		 entity.setDevice_brand(resultSet.getString("device_brand"));
            		 entity.setDevice_model(resultSet.getString("device_model"));
            		 
            		 testEntities.add(entity);
    			 }
             }else{
            	 System.out.println("not found");
             }
             
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement!=null){
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
         
         if(testEntities != null){
        	 plr.put("data", testEntities);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	
	
}
