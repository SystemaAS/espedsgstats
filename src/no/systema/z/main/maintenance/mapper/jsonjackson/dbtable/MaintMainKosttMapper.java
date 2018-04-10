/**
 * 
 */
package no.systema.z.main.maintenance.mapper.jsonjackson.dbtable;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
//application library
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKosttContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKosttRecord;
//
import java.util.*;

/**
 * @author oscardelatorre
 * @date Apr 21, 2017
 * 
 */
public class MaintMainKosttMapper extends ObjectMapperAbstractGrandFather{
	private static final Logger logger = Logger.getLogger(MaintMainKosttMapper.class.getName());
	
	public JsonMaintMainKosttContainer getContainer(String utfPayload) throws Exception{
		
		//At this point we now have an UTF-8 payload
		JsonMaintMainKosttContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintMainKosttContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		//DEBUG
		Collection<JsonMaintMainKosttRecord> list = container.getList();
		for(JsonMaintMainKosttRecord record : list){
			//logger.info(record.getKlikod());
		}
		return container;
	}
}
