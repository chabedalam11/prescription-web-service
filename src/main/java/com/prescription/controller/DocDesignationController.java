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

import com.prescription.domain.DocDesignation;
import com.prescription.domain.Message;
import com.prescription.service.Database;

@Controller
public class DocDesignationController {
	
	//insert doctor Designation information
	@RequestMapping("/prescription/insertDocDesignation")
    @ResponseBody
	public HashMap<String, Object> insertInfo(String t_doc_id,
												String t_desig_name,
												String other){
		
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<Message> testEntities = new ArrayList<Message>();
		Message message = new Message();
		
        String sql = "INSERT INTO doc_designation(t_doc_id,t_desig_name,other) "+
        		"VALUES(?,?,?)";
        			
		 Connection connection= new Database().getConnection();
		 PreparedStatement statement = null;
			//START
			try {
	        	 statement = connection.prepareStatement(sql);
	             statement.setString(1, t_doc_id);
	             statement.setString(2, t_desig_name);
	             statement.setString(3, other);
	            
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

	
	//update doctor Designation information //t_desig_id, t_doc_id, t_desig_name, other
			@RequestMapping("/prescription/updateDocDesignation")
		    @ResponseBody
			public HashMap<String, Object> updateInfo(String t_desig_id,
														String t_doc_id,
														String t_desig_name,
														String other
														){
				
				HashMap<String, Object> plr = new HashMap<String, Object>();
				List<Message> testEntities = new ArrayList<Message>();
				Message message = new Message();
				
		        /*String sql = "INSERT INTO doc_clinic(t_doc_id,t_clinic_address,t_clinic_visit_day,t_clinic_visit_time1,t_clinic_visit_time2,t_clinic_mobile,t_clinic_other) "+
		        		"VALUES(?,?,?,?,?,?,?)";*/
		        
		        
		        String sql = "update doc_designation set t_desig_name=?,other=? where t_desig_id=? and t_doc_id=?";
		        			
				 Connection connection= new Database().getConnection();
				 PreparedStatement statement = null;
					//START
					try {
			        	 statement = connection.prepareStatement(sql);
			        	 statement.setString(1, t_desig_name);
			             statement.setString(2, other);
			             statement.setString(3, t_desig_id);
			             statement.setString(4, t_doc_id);
			            
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
			
			
			//delete doctor Designation information //t_desig_id, t_doc_id, t_desig_name, other
			@RequestMapping("/prescription/deleteDocDesignation")
		    @ResponseBody
			public HashMap<String, Object> deleteInfo(String t_desig_id,
														String t_doc_id
														){
				
				HashMap<String, Object> plr = new HashMap<String, Object>();
				List<Message> testEntities = new ArrayList<Message>();
				Message message = new Message();
				
		        String sql = "delete from doc_designation  where t_desig_id=? and t_doc_id=?";
		        			
				 Connection connection= new Database().getConnection();
				 PreparedStatement statement = null;
					//START
					try {
			        	 statement = connection.prepareStatement(sql);
			             statement.setString(1, t_desig_id);
			             statement.setString(2, t_doc_id);
			            
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
	
	@RequestMapping("/prescription/getDocDesignation")
    @ResponseBody
	 public HashMap<String, Object> selectAllInfo(){
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<DocDesignation> testEntities = new ArrayList<DocDesignation>();

        String sql = "SELECT * FROM doc_designation";
        			
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
        	 
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 DocDesignation entity = new DocDesignation();
            		 
            		 entity.setT_desig_id(resultSet.getString("t_desig_id"));
            		 entity.setT_doc_id(resultSet.getString("t_doc_id"));
            		 entity.setT_desig_name(resultSet.getString("t_desig_name"));
            		 entity.setOther(resultSet.getString("other"));
            		 
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
	
	
	
	@RequestMapping("/prescription/getDocDesignationByDocId")
    @ResponseBody
	 public HashMap<String, Object> selectAllInfoByDocId(String t_doc_id){
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<DocDesignation> testEntities = new ArrayList<DocDesignation>();

        String sql = "SELECT * FROM doc_designation WHERE t_doc_id =?";
        			
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
        	 statement.setString(1, t_doc_id);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 DocDesignation entity = new DocDesignation();
            		 
            		 entity.setT_desig_id(resultSet.getString("t_desig_id"));
            		 entity.setT_doc_id(resultSet.getString("t_doc_id"));
            		 entity.setT_desig_name(resultSet.getString("t_desig_name"));
            		 entity.setOther(resultSet.getString("other"));
            		 
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
	
	/*public static void main(String[] args) {
		;
		System.out.println(new DoctorSingUpController().getMaxColumnValue()+1);
	}
	
	
	*/
	
}
