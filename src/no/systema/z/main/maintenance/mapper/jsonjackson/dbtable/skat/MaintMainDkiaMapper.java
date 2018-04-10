/**
 * 
 */
package no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.skat;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
//application library
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat.JsonMaintMainDkiaContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat.JsonMaintMainDkiaRecord;
//
import java.util.*;

/**
 * @author oscardelatorre
 * @date Apr 26, 2017
 * 
 */
public class MaintMainDkiaMapper extends ObjectMapperAbstractGrandFather{
	private static final Logger logger = Logger.getLogger(MaintMainDkiaMapper.class.getName());
	
	public JsonMaintMainDkiaContainer getContainer(String utfPayload) throws Exception{
		
		//At this point we now have an UTF-8 payload
		JsonMaintMainDkiaContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintMainDkiaContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		//DEBUG
		Collection<JsonMaintMainDkiaRecord> list = container.getList();
		for(JsonMaintMainDkiaRecord record : list){
			//logger.info(record.getTodo());
		}
		return container;
	}
}
