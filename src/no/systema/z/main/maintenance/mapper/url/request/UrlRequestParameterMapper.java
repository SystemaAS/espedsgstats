/**
 * 
 */
package no.systema.z.main.maintenance.mapper.url.request;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

import no.systema.main.model.jsonjackson.general.JsonAbstractGrandFatherRecord;
import no.systema.z.main.maintenance.util.MainMaintenanceConstants;

/**
 * @author oscardelatorre
 * @param Aug 3, 2014
 * 
 */
public class UrlRequestParameterMapper {
	private static final Logger logger = Logger.getLogger(UrlRequestParameterMapper.class.getName());
	
	/**
	 * Builds the final url parameter list (to send with a GET or POST form method)
	 * @param object JsonAbstractGrandFatherRecord
	 * @return String, in url format.
	 * 
	 */
	public String getUrlParameterValidString(JsonAbstractGrandFatherRecord object){
		StringBuffer sb = new StringBuffer();
		
		try{
			for(Field field: object.getFields()){
				try{
					field.setAccessible(true);//we must do this in order to access private fields
					String value = (String)field.get(object); 
					if(value==null){
						sb.append("");
					}else{
						//CRUCIAL! to encode the value in order to handle all special characters (%,&,",',()...) before JSON-call
						//& will be converted into "%26", %="%25", etc. 
						//Refer to URLEncode special characters for further info)
						value = URLEncoder.encode(value, "UTF-8");
						
						sb.append(MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + field.getName() + "=");
						sb.append(value.trim());
					}
				}catch(Exception e){
					//Try Integer
					if(field.get(object) instanceof Integer){
						Integer value = (Integer)field.get(object); 
						sb.append(MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + field.getName() + "=");
						sb.append(value);
					
					}else if(field.get(object) instanceof Double){
						Double value = (Double)field.get(object); 
						sb.append(MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + field.getName() + "=");
						sb.append(value);
					}else{
						logger.info(" [INFO]data type not yet supported...");
					}
					//add more instances if you need...					
										
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	/**
	 * Builds the final url parameter list (to send with a GET or POST form method)
	 * Handles String, Integer, Double and Float
	 * 
	 * @param object any Object. <b>NOTE:</b> If inherited, the superclass fields will be used. Meaning we assuming it is a DTO that inherits from the DAO.
	 * @return String in url format.
	 * 
	 */
	public String getUrlParameterValidString(Object object){
		StringBuffer sb = new StringBuffer();
		Field[] fields = null;
		if (object.getClass().getSuperclass().equals(Object.class)) {
			fields = object.getClass().getDeclaredFields();
		} else {
			fields = object.getClass().getSuperclass().getDeclaredFields();
		}
		
		try{
			for(Field field: fields){
				try{
					field.setAccessible(true);//we must do this in order to access private fields
					String value = (String)field.get(object); 
					if(value==null){
						sb.append("");
					}else{
						//CRUCIAL! to encode the value in order to handle all special characters (%,&,",',()...) before JSON-call
						//& will be converted into "%26", %="%25", etc. 
						//Refer to URLEncode special characters for further info)
						value = URLEncoder.encode(value, "UTF-8");
						
						sb.append(MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + field.getName() + "=");
						sb.append(value.trim());
					}
				}catch(Exception e){
					
					//Try Integer
					if(field.get(object) instanceof Integer){
						Integer value = (Integer)field.get(object); 
						sb.append(MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + field.getName() + "=");
						sb.append(value);
					
					}else if(field.get(object) instanceof Double){
						Double value = (Double)field.get(object); 
						sb.append(MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + field.getName() + "=");
						sb.append(value);
					} else if(field.get(object) instanceof Float){
						Float value = (Float)field.get(object); 
						sb.append(MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + field.getName() + "=");
						sb.append(value);
					} else if(field.get(object) instanceof BigDecimal){
						BigDecimal value = (BigDecimal)field.get(object); 
						sb.append(MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + field.getName() + "=");
						sb.append(value);
					}
					
					else{
						
						logger.info(" [INFO]data type not yet supported... field:" + field.getName() + " error Message:" + e.getMessage());
					}
					//add more instances if you need...					
										
					
				}
			}
		}catch(Exception e){
			logger.info("Error", e);
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
}
