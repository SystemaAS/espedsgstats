/**
 * 
 */
package no.systema.z.main.maintenance.mapper.jsonjackson.dbtable;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
//application library
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtvKodtwContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtvKodtwRecord;
//
import java.util.*;

/**
 * @author oscardelatorre
 * @date Aug 5, 2016
 * 
 */
public class MaintMainKodtvKodtwMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(MaintMainKodtvKodtwMapper.class.getName());
	
	public JsonMaintMainKodtvKodtwContainer getContainer(String utfPayload) throws Exception{
		
		//At this point we now have an UTF-8 payload
		JsonMaintMainKodtvKodtwContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintMainKodtvKodtwContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		//DEBUG
		Collection<JsonMaintMainKodtvKodtwRecord> list = container.getList();
		for(JsonMaintMainKodtvKodtwRecord record : list){
			//logger.info(record.getKlikod());
		}
		return container;
	}
}
