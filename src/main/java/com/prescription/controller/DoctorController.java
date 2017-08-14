package com.prescription.controller;

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

import com.prescription.domain.DoctorInfo;
import com.prescription.domain.Message;
import com.prescription.service.Database;





@Controller
public class DoctorController {
	
	
	//insert doctor signUP information
	@RequestMapping("/prescription/insertSignUpInfo")
    @ResponseBody
	public HashMap<String, Object> insertInfo(String t_doc_first_name, 
											 String  t_doc_middle_name, 
											 String  t_doc_last_name,
											 String  t_doc_birth_day,
											 String  t_doc_gender,
											 String  t_doc_nation,
											 String  t_doc_phone1,
											 String  t_doc_phone2,
											 String  t_doc_phone3,
											 String  t_doc_passphrase,
											 String  t_doc_email,
											 String  t_doc_address){
		
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<Message> testEntities = new ArrayList<Message>();
		Message message = new Message();
		
		if(!isEmailValid(t_doc_email)){
			message.setMsgString("101");
			testEntities.add(message);
			plr.put("data", testEntities);
	        return plr;
		}

        String sql = "INSERT INTO doctor(t_doc_first_name,t_doc_middle_name,t_doc_last_name,t_doc_birth_day,t_doc_gender,t_doc_nation,t_doc_phone1,t_doc_phone2,t_doc_phone3,t_doc_passphrase,t_doc_email,t_doc_address) "+
        		"VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        			
		
		 Connection connection= new Database().getConnection();
		 
		PreparedStatement statement = null;
		
		
			//START
			try {
	        	 statement = connection.prepareStatement(sql);
	             //statement.setString(1, docId);
	             statement.setString(1, t_doc_first_name);
	             statement.setString(2, t_doc_middle_name);
	             statement.setString(3, t_doc_last_name);
	             statement.setString(4, t_doc_birth_day);
	             statement.setString(5, t_doc_gender);
	             statement.setString(6, t_doc_nation);
	             statement.setString(7, t_doc_phone1);
	             statement.setString(8, t_doc_phone2);
	             statement.setString(9, t_doc_phone3);
	             statement.setString(10, t_doc_passphrase);
	             statement.setString(11, t_doc_email);
	             statement.setString(12, t_doc_address);
	            
	             int check = statement.executeUpdate();
	             
	             if(check>0){
	            	 message.setMsgString("1");
	             }else{
	            	 message.setMsgString("0");
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
			//END
		 testEntities.add(message);
		 plr.put("data", testEntities);
         return plr;
     }
	
	
	@RequestMapping("/prescription/doctorLogin")
    @ResponseBody
	 public HashMap<String, Object> selectAllInfo( String  t_doc_email,String  t_doc_passphrase){
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<DoctorInfo> testEntities = new ArrayList<DoctorInfo>();

        String sql = "SELECT * FROM doctor where t_doc_email = ? and t_doc_passphrase=?";
        			
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
        	 statement.setString(1, t_doc_email);
        	 statement.setString(2, t_doc_passphrase);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 DoctorInfo entity = new DoctorInfo();
            		 entity.setT_doc_id(resultSet.getString("t_doc_id"));
            		 entity.setT_doc_first_name(resultSet.getString("t_doc_first_name"));
            		 entity.setT_doc_middle_name(resultSet.getString("t_doc_middle_name"));
            		 entity.setT_doc_last_name(resultSet.getString("t_doc_last_name"));
            		 entity.setT_doc_birth_day(resultSet.getString("t_doc_birth_day"));
            		 entity.setT_doc_gender(resultSet.getString("t_doc_gender"));
            		 entity.setT_doc_nation(resultSet.getString("t_doc_nation"));
            		 entity.setT_doc_phone1(resultSet.getString("t_doc_phone1"));
            		 entity.setT_doc_phone2(resultSet.getString("t_doc_phone2"));
            		 entity.setT_doc_phone3(resultSet.getString("t_doc_phone3"));
            		 entity.setT_doc_passphrase(resultSet.getString("t_doc_passphrase"));
            		 entity.setT_doc_email(resultSet.getString("t_doc_email"));
            		 entity.setT_doc_phone_home(resultSet.getString("t_doc_phone_home"));
            		 entity.setT_doc_phone_office(resultSet.getString("t_doc_phone_office"));
            		 entity.setT_doc_marital(resultSet.getString("t_doc_marital"));
            		 entity.setT_doc_pic(resultSet.getString("t_doc_pic"));
            		 
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
         }
         return plr;
     }
	
	
	
	//check email Address
	public boolean isEmailValid(String t_doc_email){
		boolean res = true;
		String sql = "SELECT t_doc_id FROM doctor WHERE t_doc_email=?";
		Connection connection= new Database().getConnection();
		 
		PreparedStatement statement = null;
			try {
	        	 statement = connection.prepareStatement(sql);
	             statement.setString(1, t_doc_email);
	             ResultSet result = statement.executeQuery();
	             while (result.next()) {
	            	 res = false;
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
		
		return res;
	}
	
	
	/*public static void main(String[] args) {
		;
		System.out.println(new DoctorSingUpController().getMaxColumnValue()+1);
	}
	
	
	*/
	
}
