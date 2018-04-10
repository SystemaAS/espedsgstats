/**
 * 
 */
package no.systema.main.mapper.jsonjackson;

//jackson library
import org.apache.log4j.Logger;


import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
//application library
import no.systema.main.model.jsonjackson.JsonSystemaUserContainer;
import no.systema.main.model.jsonjackson.JsonSystemaUserRecord;

//java lib
import java.util.*;

/**
 * General mapper to the main package (Systema Web eSped)
 * 
 * @author oscardelatorre
 * 
 */
public class SystemaUserMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(SystemaUserMapper.class.getName());
	
	public JsonSystemaUserContainer getContainer(String utfPayload) throws Exception{
		
		//At this point we now have an UTF-8 payload
		JsonSystemaUserContainer systemaUserContainer = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonSystemaUserContainer.class); 
		logger.info("Mapping Systema User object from JSON payload...");
		logger.info("[JSON-String payload status=OK]  " + systemaUserContainer.getUser());
		
		//DEBUG
		Collection<JsonSystemaUserRecord> fields = systemaUserContainer.getMenuList();
		for(JsonSystemaUserRecord record : fields){
			//logger.info("Program: " + record.getProg());
			//logger.info("Program text: " + record.getPrTxt());
		}
			
		return systemaUserContainer;
	}
}
