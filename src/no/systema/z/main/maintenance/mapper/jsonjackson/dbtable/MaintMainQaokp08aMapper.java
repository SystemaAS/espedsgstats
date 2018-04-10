/**
 * 
 */
package no.systema.z.main.maintenance.mapper.jsonjackson.dbtable;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
//application library
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainQaokp08aContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainQaokp08aRecord;
//
import java.util.*;

/**
 * @author oscardelatorre
 * @date May 05, 2017
 * 
 */
public class MaintMainQaokp08aMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(MaintMainQaokp08aMapper.class.getName());
	
	public JsonMaintMainQaokp08aContainer getContainer(String utfPayload) throws Exception{
		
		//At this point we now have an UTF-8 payload
		JsonMaintMainQaokp08aContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintMainQaokp08aContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		//DEBUG
		Collection<JsonMaintMainQaokp08aRecord> list = container.getList();
		for(JsonMaintMainQaokp08aRecord record : list){
			//logger.info(record.getKlikod());
		}
		return container;
	}
}
