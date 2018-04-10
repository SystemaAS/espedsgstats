/**
 * 
 */
package no.systema.z.main.maintenance.mapper.jsonjackson.dbtable;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
//application library
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtot2Container;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtot2Record;
//
import java.util.*;

/**
 * @author oscardelatorre
 * @date Sep 22, 2016
 * 
 */
public class MaintMainKodtot2Mapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(MaintMainKodtot2Mapper.class.getName());
	
	public JsonMaintMainKodtot2Container getContainer(String utfPayload) throws Exception{
		
		//At this point we now have an UTF-8 payload
		JsonMaintMainKodtot2Container container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintMainKodtot2Container.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		//DEBUG
		Collection<JsonMaintMainKodtot2Record> list = container.getList();
		for(JsonMaintMainKodtot2Record record : list){
			//logger.info(record.getKlikod());
		}
		return container;
	}
}
