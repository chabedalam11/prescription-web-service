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

import com.prescription.domain.Message;
import com.prescription.domain.Patient;
import com.prescription.service.Database;

@Controller
public class PatientController {
	
	//insert patient information
	@RequestMapping("/prescription/insertPatient")
    @ResponseBody
	public HashMap<String, Object> insertInfo(  String t_doc_id, 
												String t_pat_name, 
												String t_pat_age, 
												String t_pat_sex, 
												String t_pat_address, 
												String t_pat_mobile, 
												String t_pat_email, 
												String t_pat_marital,
												String t_pat_entry_date,
												String t_pat_f_name){
		
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<Message> testEntities = new ArrayList<Message>();
		Message message = new Message();
		
        String sql = "INSERT INTO patient(t_doc_id, t_pat_name, t_pat_age, t_pat_sex, t_pat_address, t_pat_mobile, t_pat_email, t_pat_marital,t_pat_entry_date,t_pat_f_name) "+
        		"VALUES(?,?,?,?,?,?,?,?,?,?)";
        			
		 Connection connection= new Database().getConnection();
		 PreparedStatement statement = null;
			//START
			try {
	        	 statement = connection.prepareStatement(sql);
	             statement.setString(1, t_doc_id);
	             statement.setString(2, t_pat_name);
	             statement.setString(3, t_pat_age);
	             statement.setString(4, t_pat_sex);
	             statement.setString(5, t_pat_address);
	             statement.setString(6, t_pat_mobile);
	             statement.setString(7, t_pat_email);
	             statement.setString(8, t_pat_marital);
	             statement.setString(9, t_pat_entry_date);
	             statement.setString(10, t_pat_f_name);
	            
	             int check = statement.executeUpdate();
	             
	             if(check>0){
	            	 //message.setMsgString("1");
	            	 String pid =getPatientIdByPatInfo(connection,
								t_doc_id,t_pat_name ,t_pat_age,
								t_pat_sex,t_pat_mobile,t_pat_marital,t_pat_entry_date);
	            	 message.setMsgString(pid);
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

	
	//update patient information 
			@RequestMapping("/prescription/updatePatient")
		    @ResponseBody
			public HashMap<String, Object> updateInfo(String t_pat_id, 
														String t_doc_id, 
														String t_pat_name, 
														String t_pat_age, 
														String t_pat_sex, 
														String t_pat_address, 
														String t_pat_mobile, 
														String t_pat_email, 
														String t_pat_marital,
														String t_pat_entry_date
														){
				
				HashMap<String, Object> plr = new HashMap<String, Object>();
				List<Message> testEntities = new ArrayList<Message>();
				Message message = new Message();
				
		       
		        String sql = "update patient set t_pat_name=?, t_pat_age=?, t_pat_sex=?, t_pat_address=?, t_pat_mobile=?, t_pat_email=?, t_pat_marital=?, t_pat_entry_date=? where t_pat_id=? and t_doc_id=?";
		       
		        			
				 Connection connection= new Database().getConnection();
				 PreparedStatement statement = null;
					//START
					try {
			        	 statement = connection.prepareStatement(sql);
			        	 statement.setString(1, t_pat_name);
			        	 statement.setString(2, t_pat_age);
			        	 statement.setString(3, t_pat_sex);
			        	 statement.setString(4, t_pat_address);
			        	 statement.setString(5, t_pat_mobile);
			        	 statement.setString(6, t_pat_email);
			        	 statement.setString(7, t_pat_marital);
			             statement.setString(8, t_pat_entry_date);
			             statement.setString(9, t_pat_id);
			             statement.setString(10, t_doc_id);
			            
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
			
			
			//delete patient information
			@RequestMapping("/prescription/deletePatient")
		    @ResponseBody
			public HashMap<String, Object> deleteInfo(String t_pat_id, 
														String t_doc_id
														){
				
				HashMap<String, Object> plr = new HashMap<String, Object>();
				List<Message> testEntities = new ArrayList<Message>();
				Message message = new Message();
				
		        String sql = "delete from patient  where t_pat_id=? and t_doc_id=?";
		        			
				 Connection connection= new Database().getConnection();
				 PreparedStatement statement = null;
					//START
					try {
			        	 statement = connection.prepareStatement(sql);
			             statement.setString(1, t_pat_id);
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
	
	
	//get all patient information
	@RequestMapping("/prescription/getAllPatient")
    @ResponseBody
	 public HashMap<String, Object> selectAllInfo(){
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<Patient> testEntities = new ArrayList<Patient>();

        String sql = "SELECT * FROM patient";
        			
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
        	 
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 Patient entity = new Patient();
            		 	
            		 	
            			
            		 entity.setSl_no(resultSet.getString("sl_no"));
            		 entity.setT_pat_id(resultSet.getString("t_pat_id"));
            		 entity.setT_doc_id(resultSet.getString("t_doc_id"));
            		 entity.setT_pat_name(resultSet.getString("t_pat_name"));
            		 entity.setT_pat_age(resultSet.getString("t_pat_age"));
            		 entity.setT_pat_sex(resultSet.getString("t_pat_sex"));
            		 entity.setT_pat_address(resultSet.getString("t_pat_address"));
            		 entity.setT_pat_mobile(resultSet.getString("t_pat_mobile"));
            		 entity.setT_pat_email(resultSet.getString("t_pat_email"));
            		 entity.setT_pat_marital(resultSet.getString("t_pat_marital"));
            		 entity.setT_pat_entry_date(resultSet.getString("t_pat_entry_date"));
            		 
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
	
	
	
	
	
	//get  patient by doc id information
		@RequestMapping("/prescription/getPatientByDocId")
	    @ResponseBody
		 public HashMap<String, Object> selectInfoByDocId(String t_doc_id){
			HashMap<String, Object> plr = new HashMap<String, Object>();
			List<Patient> testEntities = new ArrayList<Patient>();

	        String sql = "SELECT  LPAD(t_pat_id, 8, '0')  t_pat_id, "
	        		+ "t_doc_id, t_pat_name, t_pat_age, t_pat_sex, t_pat_address, "
	        		+ "t_pat_mobile, t_pat_email, t_pat_marital, t_pat_entry_date, t_pat_f_name "
	        		+ "FROM patient where t_doc_id=?";
	        			
			Connection connection = new Database().getConnection();
			PreparedStatement statement = null;
	         try {
	        	 statement = connection.prepareStatement(sql);
	        	 statement.setString(1, t_doc_id);
	             ResultSet resultSet = statement.executeQuery();
	             
	             if(resultSet!=null){
	            	 while (resultSet.next()) {
	            		 Patient entity = new Patient();
	            		 entity.setT_pat_id(resultSet.getString("t_pat_id"));
	            		 entity.setT_doc_id(resultSet.getString("t_doc_id"));
	            		 entity.setT_pat_name(resultSet.getString("t_pat_name"));
	            		 entity.setT_pat_age(resultSet.getString("t_pat_age"));
	            		 entity.setT_pat_sex(resultSet.getString("t_pat_sex"));
	            		 entity.setT_pat_address(resultSet.getString("t_pat_address"));
	            		 entity.setT_pat_mobile(resultSet.getString("t_pat_mobile"));
	            		 entity.setT_pat_email(resultSet.getString("t_pat_email"));
	            		 entity.setT_pat_marital(resultSet.getString("t_pat_marital"));
	            		 entity.setT_pat_entry_date(resultSet.getString("t_pat_entry_date"));
	            		 entity.setT_pat_f_name(resultSet.getString("t_pat_f_name"));
	            		 
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
		
		//get  patient by doc id and patient id information
				@RequestMapping("/prescription/getPatientByDocIdAndPatId")
			    @ResponseBody
				 public HashMap<String, Object> selectInfoByDocIdAndPatId(String t_doc_id,String t_pat_id){
					HashMap<String, Object> plr = new HashMap<String, Object>();
					List<Patient> testEntities = new ArrayList<Patient>();

			        String sql = "SELECT * FROM patient where t_doc_id=? and t_pat_id =?";
			        			
					Connection connection = new Database().getConnection();
					PreparedStatement statement = null;
			         try {
			        	 statement = connection.prepareStatement(sql);
			        	 statement.setString(1, t_doc_id);
			        	 statement.setString(2, t_pat_id);
			             ResultSet resultSet = statement.executeQuery();
			             
			             if(resultSet!=null){
			            	 while (resultSet.next()) {
			            		 Patient entity = new Patient();
			            		 entity.setSl_no(resultSet.getString("sl_no"));
			            		 entity.setT_pat_id(resultSet.getString("t_pat_id"));
			            		 entity.setT_doc_id(resultSet.getString("t_doc_id"));
			            		 entity.setT_pat_name(resultSet.getString("t_pat_name"));
			            		 entity.setT_pat_age(resultSet.getString("t_pat_age"));
			            		 entity.setT_pat_sex(resultSet.getString("t_pat_sex"));
			            		 entity.setT_pat_address(resultSet.getString("t_pat_address"));
			            		 entity.setT_pat_mobile(resultSet.getString("t_pat_mobile"));
			            		 entity.setT_pat_email(resultSet.getString("t_pat_email"));
			            		 entity.setT_pat_marital(resultSet.getString("t_pat_marital"));
			            		 entity.setT_pat_entry_date(resultSet.getString("t_pat_entry_date"));
			            		 
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
				
				
	public String  getPatientIdByPatInfo(Connection connection,
							String t_doc_id,String  t_pat_name ,String  t_pat_age,
							String t_pat_sex,String  t_pat_mobile,String  t_pat_marital,String  t_pat_entry_date) throws SQLException{
		String pid="";
		String sql = "SELECT LPAD(t_pat_id, 8, '0') t_pat_id FROM patient where t_doc_id=? and t_pat_name =? and t_pat_age=? and t_pat_sex=? and t_pat_mobile=? and t_pat_marital=? and t_pat_entry_date=?";
		
		 PreparedStatement statement = connection.prepareStatement(sql);
        	 statement.setString(1, t_doc_id);
        	 statement.setString(2, t_pat_name);
        	 statement.setString(3, t_pat_age);
        	 statement.setString(4, t_pat_sex);
        	 statement.setString(5, t_pat_mobile);
        	 statement.setString(6, t_pat_marital);
        	 statement.setString(7, t_pat_entry_date);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 
            		 pid = resultSet.getString("t_pat_id");
    			 }
             }else{
            	 System.out.println("not found");
             }
        return pid;
	}
		
	
	/*public static void main(String[] args) {
		;
		System.out.println(new DoctorSingUpController().getMaxColumnValue()+1);
	}
	
	
	*/
	
}
