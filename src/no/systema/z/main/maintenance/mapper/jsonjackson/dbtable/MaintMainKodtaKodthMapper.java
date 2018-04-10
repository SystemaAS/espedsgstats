/**
 * 
 */
package no.systema.z.main.maintenance.mapper.jsonjackson.dbtable;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
//application library
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtaKodthContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtaKodthRecord;
//
import java.util.*;

/**
 * @author oscardelatorre
 * @date Aug 19, 2016
 * 
 */
public class MaintMainKodtaKodthMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(MaintMainKodtaKodthMapper.class.getName());
	
	public JsonMaintMainKodtaKodthContainer getContainer(String utfPayload) throws Exception{
		
		//At this point we now have an UTF-8 payload
		JsonMaintMainKodtaKodthContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintMainKodtaKodthContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		//DEBUG
		Collection<JsonMaintMainKodtaKodthRecord> list = container.getList();
		for(JsonMaintMainKodtaKodthRecord record : list){
			//logger.info(record.getKlikod());
		}
		return container;
	}
}
