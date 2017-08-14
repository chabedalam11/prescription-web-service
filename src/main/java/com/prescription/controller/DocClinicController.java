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

import com.prescription.domain.DocClinic;
import com.prescription.domain.Message;
import com.prescription.service.Database;

@Controller
public class DocClinicController {
	
	//insert doctor Clinic information
	@RequestMapping("/prescription/insertDocClinic")
    @ResponseBody
	public HashMap<String, Object> insertInfo(String t_doc_id,
												String t_clinic_address,
												String t_clinic_visit_day,
												String t_clinic_visit_time1,
												String t_clinic_visit_time2,
												String t_clinic_mobile,
												String t_clinic_other){
		
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<Message> testEntities = new ArrayList<Message>();
		Message message = new Message();
		
        String sql = "INSERT INTO doc_clinic(t_doc_id,t_clinic_address,t_clinic_visit_day,t_clinic_visit_time1,t_clinic_visit_time2,t_clinic_mobile,t_clinic_other) "+
        		"VALUES(?,?,?,?,?,?,?)";
        			
		 Connection connection= new Database().getConnection();
		 PreparedStatement statement = null;
			//START
			try {
	        	 statement = connection.prepareStatement(sql);
	             statement.setString(1, t_doc_id);
	             statement.setString(2, t_clinic_address);
	             statement.setString(3, t_clinic_visit_day);
	             statement.setString(4, t_clinic_visit_time1);
	             statement.setString(5, t_clinic_visit_time2);
	             statement.setString(6, t_clinic_mobile);
	             statement.setString(7, t_clinic_other);
	            
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
	
	
	//update doctor Clinic information
		@RequestMapping("/prescription/upDateDocClinic")
	    @ResponseBody
		public HashMap<String, Object> updateInfo(String t_clinic_id,
													String t_doc_id,
													String t_clinic_address,
													String t_clinic_visit_day,
													String t_clinic_visit_time1,
													String t_clinic_visit_time2,
													String t_clinic_mobile,
													String t_clinic_other){
			
			HashMap<String, Object> plr = new HashMap<String, Object>();
			List<Message> testEntities = new ArrayList<Message>();
			Message message = new Message();
			
	        /*String sql = "INSERT INTO doc_clinic(t_doc_id,t_clinic_address,t_clinic_visit_day,t_clinic_visit_time1,t_clinic_visit_time2,t_clinic_mobile,t_clinic_other) "+
	        		"VALUES(?,?,?,?,?,?,?)";*/
	        
	        
	        String sql = "update doc_clinic set t_clinic_address=?,t_clinic_visit_day=?,t_clinic_visit_time1=?,t_clinic_visit_time2=?,t_clinic_mobile=?,t_clinic_other=? where t_clinic_id=? and t_doc_id=?";
	        			
			 Connection connection= new Database().getConnection();
			 PreparedStatement statement = null;
				//START
				try {
		        	 statement = connection.prepareStatement(sql);
		        	 statement.setString(1, t_clinic_address);
		             statement.setString(2, t_clinic_visit_day);
		             statement.setString(3, t_clinic_visit_time1);
		             statement.setString(4, t_clinic_visit_time2);
		             statement.setString(5, t_clinic_mobile);
		             statement.setString(6, t_clinic_other);
		             statement.setString(7, t_clinic_id);
		             statement.setString(8, t_doc_id);
		            
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
	
		
		//delete doctor Clinic information
				@RequestMapping("/prescription/deleteDocClinic")
			    @ResponseBody
				public HashMap<String, Object> deleteInfo(String t_clinic_id,
															String t_doc_id
															){
					
					HashMap<String, Object> plr = new HashMap<String, Object>();
					List<Message> testEntities = new ArrayList<Message>();
					Message message = new Message();
					
			       
			        
			        String sql = "delete from doc_clinic  where t_clinic_id=? and t_doc_id=?";
			        			
					 Connection connection= new Database().getConnection();
					 PreparedStatement statement = null;
						//START
						try {
				        	 statement = connection.prepareStatement(sql);
				             statement.setString(1, t_clinic_id);
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
			
		
				
	//get all Clinic information
	@RequestMapping("/prescription/getDocClinic")
    @ResponseBody
	 public HashMap<String, Object> selectAllInfo(){
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<DocClinic> testEntities = new ArrayList<DocClinic>();

        String sql = "SELECT * FROM doc_clinic";
        			
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
        	 
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 DocClinic entity = new DocClinic();
            		
            		 entity.setT_clinic_id(resultSet.getString("t_clinic_id"));
            		 entity.setT_doc_id(resultSet.getString("t_doc_id"));
            		 entity.setT_clinic_address(resultSet.getString("t_clinic_address"));
            		 entity.setT_clinic_visit_day(resultSet.getString("t_clinic_visit_day"));
            		 entity.setT_clinic_visit_time1(resultSet.getString("t_clinic_visit_time1"));
            		 entity.setT_clinic_visit_time2(resultSet.getString("t_clinic_visit_time2"));
            		 entity.setT_clinic_mobile(resultSet.getString("t_clinic_mobile"));
            		 entity.setT_clinic_other(resultSet.getString("t_clinic_other"));
            		 
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
	
	
	//get Clinic information by doc id
	@RequestMapping("/prescription/getDocClinicByDocId")
    @ResponseBody
	 public HashMap<String, Object> selectAllInfoByDocCode(String t_doc_id){
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<DocClinic> testEntities = new ArrayList<DocClinic>();

        String sql = "SELECT * FROM doc_clinic WHERE t_doc_id = ?";
        			
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
        	 statement.setString(1, t_doc_id);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 DocClinic entity = new DocClinic();
            		
            		 entity.setT_clinic_id(resultSet.getString("t_clinic_id"));
            		 entity.setT_doc_id(resultSet.getString("t_doc_id"));
            		 entity.setT_clinic_address(resultSet.getString("t_clinic_address"));
            		 entity.setT_clinic_visit_day(resultSet.getString("t_clinic_visit_day"));
            		 entity.setT_clinic_visit_time1(resultSet.getString("t_clinic_visit_time1"));
            		 entity.setT_clinic_visit_time2(resultSet.getString("t_clinic_visit_time2"));
            		 entity.setT_clinic_mobile(resultSet.getString("t_clinic_mobile"));
            		 entity.setT_clinic_other(resultSet.getString("t_clinic_other"));
            		 
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
