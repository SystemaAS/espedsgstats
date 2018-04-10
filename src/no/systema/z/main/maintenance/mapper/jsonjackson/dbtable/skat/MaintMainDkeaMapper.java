/**
 * 
 */
package no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.skat;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
//application library
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat.JsonMaintMainDkeaContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat.JsonMaintMainDkeaRecord;
//
import java.util.*;

/**
 * @author oscardelatorre
 * @date Apr 26, 2017
 * 
 */
public class MaintMainDkeaMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(MaintMainDkeaMapper.class.getName());
	
	public JsonMaintMainDkeaContainer getContainer(String utfPayload) throws Exception{
		
		//At this point we now have an UTF-8 payload
		JsonMaintMainDkeaContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintMainDkeaContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		//DEBUG
		Collection<JsonMaintMainDkeaRecord> list = container.getList();
		for(JsonMaintMainDkeaRecord record : list){
			//logger.info(record.getKlikod());
		}
		return container;
	}
}
