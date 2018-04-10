/**
 * 
 */
package no.systema.z.main.maintenance.mapper.jsonjackson.dbtable;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
//application library
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtaTellContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtaTellRecord;
//
import java.util.*;

/**
 * @author oscardelatorre
 * @date Aug 22, 2016
 * 
 */
public class MaintMainKodtaTellMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(MaintMainKodtaTellMapper.class.getName());
	
	public JsonMaintMainKodtaTellContainer getContainer(String utfPayload) throws Exception{
		
		//At this point we now have an UTF-8 payload
		JsonMaintMainKodtaTellContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintMainKodtaTellContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		//DEBUG
		Collection<JsonMaintMainKodtaTellRecord> list = container.getList();
		for(JsonMaintMainKodtaTellRecord record : list){
			//logger.info(record.getKlikod());
		}
		return container;
	}
}
