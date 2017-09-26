package com.prescription.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prescription.domain.Analysis;
import com.prescription.domain.Message;
import com.prescription.service.Database;

@Controller
public class AnalysisController {
	
	//insert analysis //t_analysis_code, t_analysis_name, t_entry_user, t_entry_date, t_upd_user, t_upd_date
	@RequestMapping("/prescription/insertAnalysis")
    @ResponseBody
	public HashMap<String, Object> insertInfo(String t_analysis_name,
												String t_entry_user){
		
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<Message> testEntities = new ArrayList<Message>();
		Message message = new Message();
		
		if (isAnalysisNameExist(t_analysis_name)) {
			message.setMsgString("101");
		} else {
			String sql = "INSERT INTO analysis(t_analysis_name,t_entry_user,t_entry_date) "+
	        		"VALUES(?,?,?)";
			 Connection connection= new Database().getConnection();
			 PreparedStatement statement = null;
				//START
				try {
		        	 statement = connection.prepareStatement(sql);
		             statement.setString(1, t_analysis_name);
		             statement.setString(2, t_entry_user);
		             Date date = new Date();
		             statement.setString(3, date.toString());
		            
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

		}
		
        
			testEntities.add(message);
			 plr.put("data", testEntities);
	         return plr;
     }

	
	/*//update Analysis 
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
				
		        String sql = "INSERT INTO doc_clinic(t_doc_id,t_clinic_address,t_clinic_visit_day,t_clinic_visit_time1,t_clinic_visit_time2,t_clinic_mobile,t_clinic_other) "+
		        		"VALUES(?,?,?,?,?,?,?)";
		        
		        
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
		     }*/
			
			
			/*//delete analysis
			@RequestMapping("/prescription/deleteAnalysis")
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
		     }*/
	
	
	
	
	//get analysis by doc code
	@RequestMapping("/prescription/getAnalysisByDocId")
    @ResponseBody
	 public HashMap<String, Object> selectAllInfoByDocId(String t_doc_id){
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<Analysis> testEntities = new ArrayList<Analysis>();

        String sql = "SELECT * FROM analysis where t_entry_user='5000' or t_entry_user=?";
        			
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
        	 statement.setString(1, t_doc_id);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 Analysis entity = new Analysis();
            		 //t_analysis_code, t_analysis_name, t_entry_user, t_entry_date, t_upd_user, t_upd_date
            		 entity.setT_analysis_code(resultSet.getString("t_analysis_code"));
            		 entity.setT_analysis_name(resultSet.getString("t_analysis_name"));
            		 entity.setT_entry_user(resultSet.getString("t_entry_user"));
            		 entity.setT_entry_date(resultSet.getString("t_entry_date"));
            		 
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
	
	public boolean isAnalysisNameExist(String analysisName){
		boolean result=false;
		String sql = "SELECT * FROM analysis where t_analysis_name=?";
		
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
        	 statement.setString(1, analysisName);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 result= true;
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
         
         return result;
	}
	
	/*public static void main(String[] args) {
		;
		System.out.println(new DoctorSingUpController().getMaxColumnValue()+1);
	}
	
	
	*/
	
}
