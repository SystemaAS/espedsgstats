/**
 * 
 */
package no.systema.z.main.maintenance.mapper.jsonjackson.dbtable;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
//application library
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainEdiiContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainEdiiRecord;
//
import java.util.*;

/**
 * @author oscardelatorre
 * @date Sep 8, 2016
 * 
 */
public class MaintMainEdiiMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(MaintMainEdiiMapper.class.getName());
	
	public JsonMaintMainEdiiContainer getContainer(String utfPayload) throws Exception{
	
		//At this point we now have an UTF-8 payload
		JsonMaintMainEdiiContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintMainEdiiContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		//DEBUG
		Collection<JsonMaintMainEdiiRecord> list = container.getList();
		for(JsonMaintMainEdiiRecord record : list){
			//logger.info(record.getKlikod());
		}
		return container;
	}
}
