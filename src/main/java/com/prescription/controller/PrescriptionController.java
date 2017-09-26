package com.prescription.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prescription.domain.DrugMaster;
import com.prescription.domain.MedicineInfo;
import com.prescription.domain.Message;
import com.prescription.domain.Prescription;
import com.prescription.service.Database;



@Controller
public class PrescriptionController {
	PreparedStatement statement;
	ResultSet resultSet;
	
	//insert doctor signUP information
		@RequestMapping("/prescription/insertPrescription")
	    @ResponseBody
		public HashMap<String, Object> insertInfo(
												 String  t_doc_id, 
												 String  t_pat_id,
												 String  t_pres_date,
												 String  t_pres_chief_complaints,
												 String  t_pres_pulse,
												 String  t_pres_bp,
												 String  t_pres_temp,
												 String  t_pres_resp,
												 String  t_pres_other,
												 String  t_analysis_code,
												 String  t_pres_advice,
												 String  t_pres_next_visit,
												 String  t_pres_um,
												 String  t_pres_med_name,
												 String  t_pres_strength,
												 String  t_pres_dose_time,
												 String  t_pres_duration,
												 String  t_pres_hints
												 ){
			
		
			//System.out.println("hit method");
			
			HashMap<String, Object> plr = new HashMap<String, Object>();
			List<Message> testEntities = new ArrayList<Message>();
			Message message = new Message();
			String currentTime=getCurrentTime();
			
	        String sql = "INSERT INTO prescription( t_doc_id, t_pat_id, t_pres_date, "
	        		+ "t_pres_chief_complaints, t_pres_pulse, t_pres_bp, t_pres_temp, t_pres_resp, t_pres_other, "
	        		+ "t_analysis_code,  t_pres_advice, t_pres_next_visit,t_pres_time,t_pres_um,t_pres_med_name,t_pres_strength, "
	        		+ " t_pres_dose_time,t_pres_duration,t_pres_hints) "+
	        		"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	        
	      
			 Connection connection= new Database().getConnection();
			
				//START
				try {
		        	 statement = connection.prepareStatement(sql);
		             statement.setString(1, t_doc_id);
		             statement.setString(2, t_pat_id);
		             statement.setString(3, t_pres_date);
		             statement.setString(4, t_pres_chief_complaints);
		             statement.setString(5, t_pres_pulse);
		             statement.setString(6, t_pres_bp);
		             statement.setString(7, t_pres_temp);
		             statement.setString(8, t_pres_resp);
		             statement.setString(9, t_pres_other);
		             statement.setString(10, t_analysis_code);
		             statement.setString(11, t_pres_advice);
		             statement.setString(12, t_pres_next_visit);
		             statement.setString(13, currentTime);
		             statement.setString(14, t_pres_um);
		             statement.setString(15, t_pres_med_name);
		             statement.setString(16, t_pres_strength);
		             statement.setString(17, t_pres_dose_time);
		             statement.setString(18, t_pres_duration);
		             statement.setString(19, t_pres_hints);
		            
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
		
		
		//update prescription
		@RequestMapping("/prescription/updatePrescription")
	    @ResponseBody
		public HashMap<String, Object> updateInfo(String t_pres_id,
												 String  t_pres_chief_complaints,
												 String  t_pres_pulse,
												 String  t_pres_bp,
												 String  t_pres_temp,
												 String  t_pres_resp,
												 String  t_analysis_code,
												 String  t_pres_advice,
												 String  t_pres_next_visit,
												 String  t_pres_um,
												 String  t_pres_med_name,
												 String  t_pres_strength,
												 String  t_pres_dose_time,
												 String  t_pres_duration,
												 String  t_pres_hints
													){
			
			HashMap<String, Object> plr = new HashMap<String, Object>();
			List<Message> testEntities = new ArrayList<Message>();
			Message message = new Message();
			
	        String sql = "UPDATE  prescription SET  "
    		+ "t_pres_chief_complaints=?, t_pres_pulse=?, t_pres_bp=?, t_pres_temp=?, t_pres_resp=?,"
    		+"t_analysis_code=?,  t_pres_advice=?, t_pres_next_visit=?,"
    		+"t_pres_um=?, t_pres_med_name=?, t_pres_strength=?, t_pres_dose_time=?, t_pres_duration=?, t_pres_hints=?"
    		+"WHERE t_pres_id=?";
	        			
			 Connection connection= new Database().getConnection();
			 PreparedStatement statement = null;
				//START
				try {
		        	 statement = connection.prepareStatement(sql);
		        	 statement.setString(1, t_pres_chief_complaints);
		        	 statement.setString(2, t_pres_pulse);
		        	 statement.setString(3, t_pres_bp);
		        	 statement.setString(4, t_pres_temp);
		        	 statement.setString(5, t_pres_resp);
		        	 statement.setString(6, t_analysis_code);
		        	 statement.setString(7, t_pres_advice);
		        	 statement.setString(8, t_pres_next_visit);
		        	 statement.setString(9, t_pres_um);
		        	 statement.setString(10, t_pres_med_name);
		        	 statement.setString(11, t_pres_strength);
		        	 statement.setString(12, t_pres_dose_time);
		        	 statement.setString(13, t_pres_duration);
		        	 statement.setString(14, t_pres_hints);
		        	 statement.setString(15, t_pres_id);
		        	 
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
		
		
		//delete prescription
				@RequestMapping("/prescription/deletePrescription")
			    @ResponseBody
				public HashMap<String, Object> deleteInfo(String t_pres_id,
															String t_pat_id, 
															String t_doc_id
															){
					
					HashMap<String, Object> plr = new HashMap<String, Object>();
					List<Message> testEntities = new ArrayList<Message>();
					Message message = new Message();
					
			        String sql = "delete from prescription  where t_pres_id=? and t_pat_id=? and t_doc_id=?";
			        			
					 Connection connection= new Database().getConnection();
					 PreparedStatement statement = null;
						//START
						try {
				        	 statement = connection.prepareStatement(sql);
				        	 statement.setString(1, t_pres_id);
				             statement.setString(2, t_pat_id);
				             statement.setString(3, t_doc_id);
				            
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

		
	
	//get  medicine info by doc id information
		@RequestMapping("/prescription/getMedicineInfo")
	    @ResponseBody
		 public HashMap<String, Object> selectInfoByDocId(String t_doc_id){
			HashMap<String, Object> plr = new HashMap<String, Object>();
			List<MedicineInfo> testEntities = new ArrayList<MedicineInfo>();
			MedicineInfo medinfo = new MedicineInfo();
			
			ArrayList<String> umList = new ArrayList<>();
			ArrayList<String> tradeList = new ArrayList<>();
			ArrayList<String> frequencyList = new ArrayList<>();

	        String sql = "SELECT t_lang2_name FROM um where  t_entry_user='5000' or t_entry_user=?";
	        String sql1 = "SELECT t_lang2_name FROM trade where  t_entry_user='5000' or t_entry_user=?";
	        String sql2 = "SELECT t_lang2_name FROM frequency where  t_entry_user='5000' or t_entry_user=?";
	        			
			Connection connection = new Database().getConnection();
			
	         try {
	        	 statement = connection.prepareStatement(sql);
	        	 statement.setString(1, t_doc_id);
	             ResultSet resultSet = statement.executeQuery();
	             
	             if(resultSet!=null){
	            	 while (resultSet.next()) {
	            		 umList.add(resultSet.getString("t_lang2_name"));
	    			 }
	            	 medinfo.setUm(umList);
	             }else{
	            	 System.out.println("not found");
	             }
	             
	             
	             //for trade
	             statement = connection.prepareStatement(sql1);
	        	 statement.setString(1, t_doc_id);
	             resultSet = statement.executeQuery();
	             
	             if(resultSet!=null){
	            	 while (resultSet.next()) {
	            		 tradeList.add(resultSet.getString("t_lang2_name"));
	    			 }
	            	 medinfo.setTrade(tradeList);
	             }else{
	            	 System.out.println("not found");
	             }
	             
	           //for frequency
	             statement = connection.prepareStatement(sql2);
	        	 statement.setString(1, t_doc_id);
	             resultSet = statement.executeQuery();
	             
	             if(resultSet!=null){
	            	 while (resultSet.next()) {
	            		 frequencyList.add(resultSet.getString("t_lang2_name"));
	    			 }
	            	 medinfo.setFrequency(frequencyList);
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
	         
	         if(medinfo != null){
	        	 testEntities.add(medinfo);
	         }
	         if(testEntities != null){
	        	 plr.put("data", testEntities);
	         }
	         return plr;
	     }
		
		
		
		//getPrescriptionListByDocAndPatId
		@RequestMapping("/prescription/getPrescriptionListByDocAndPatId")
	    @ResponseBody
		 public HashMap<String, Object> selectAllInfo( String  t_doc_id,String t_pat_id){
			HashMap<String, Object> plr = new HashMap<String, Object>();
			List<Prescription> testEntities = new ArrayList<Prescription>();
			String sqlForPrescription = "SELECT *  FROM prescription where t_doc_id =? and t_pat_id=? ORDER BY t_pres_date DESC, t_pres_id DESC";
			
			Connection connection = new Database().getConnection();
			PreparedStatement statement = null;
	         try {
	        	 statement = connection.prepareStatement(sqlForPrescription);
	        	 statement.setString(1, t_doc_id);
	        	 statement.setString(2, t_pat_id);
	             ResultSet resultSet = statement.executeQuery();
	             
	             if(resultSet!=null){
	            	 while (resultSet.next()) {
	            		 Prescription prescription = new Prescription();
	            		 prescription.setT_pres_id(resultSet.getString("t_pres_id"));
	            		 prescription.setT_doc_id(resultSet.getString("t_doc_id"));
	            		 prescription.setT_pat_id(resultSet.getString("t_pat_id"));
	            		 prescription.setT_pres_date(resultSet.getString("t_pres_date"));
	            		 prescription.setT_pres_chief_complaints(resultSet.getString("t_pres_chief_complaints"));
	            		 prescription.setT_pres_pulse(resultSet.getString("t_pres_pulse"));
	            		 prescription.setT_pres_bp(resultSet.getString("t_pres_bp"));
	            		 prescription.setT_pres_temp(resultSet.getString("t_pres_temp"));
	            		 prescription.setT_pres_resp(resultSet.getString("t_pres_resp"));
	            		 prescription.setT_pres_other(resultSet.getString("t_pres_other"));
	            		 
	            		 //get analysis name by analysis code
	            		 String code =resultSet.getString("t_analysis_code");
	            		 if(code.equals("")){
	            			 code="0";
	            		 }
	            		 String analysisName=getAnalysisNameByCode(connection,code);
	            		 prescription.setT_analysis_code(analysisName);
	            		 
	            		 prescription.setT_dragmaster_code(resultSet.getString("t_dragmaster_code"));
	            		 prescription.setT_pres_advice(resultSet.getString("t_pres_advice"));
	            		 prescription.setT_pres_next_visit(resultSet.getString("t_pres_next_visit"));
	            		 prescription.setT_pres_time(resultSet.getString("t_pres_time"));
	            		 prescription.setT_pres_um(resultSet.getString("t_pres_um"));
	            		 prescription.setT_pres_med_name(resultSet.getString("t_pres_med_name"));
	            		 prescription.setT_pres_strength(resultSet.getString("t_pres_strength"));
	            		 prescription.setT_pres_dose_time(resultSet.getString("t_pres_dose_time"));
	            		 prescription.setT_pres_duration(resultSet.getString("t_pres_duration"));
	            		 prescription.setT_pres_hints(resultSet.getString("t_pres_hints"));
	            		 
	            		 testEntities.add(prescription);
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
		
		
		private String  getAnalysisNameByCode(Connection connection,String code) throws SQLException{
			//System.out.println("code : "+code);
			String sql = "select t_analysis_name from analysis where t_analysis_code in ("+code+");";
			PreparedStatement statement = null;
			statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            String analysisName ="";
            int count =0;
            if(resultSet!=null){
           	 while (resultSet.next()) {
           		 if(count==0){
           			analysisName+=resultSet.getString("t_analysis_name");
           			count++;
           		 }else{
           			analysisName+="$"+resultSet.getString("t_analysis_name");
           		 }
           	 }
            }
            
            return code+"|||"+analysisName;
		}
		
	
	/*public static void main(String[] args) {
		int m = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
		System.out.println(m);
	}*/
	
		
		
		public String  getCurrentTime() {
	        Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	        return sdf.format(cal.getTime());
	    }
	
	
}
