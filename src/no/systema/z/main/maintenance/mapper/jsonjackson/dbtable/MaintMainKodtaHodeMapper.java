/**
 * 
 */
package no.systema.z.main.maintenance.mapper.jsonjackson.dbtable;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
//application library
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtaHodeContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtaHodeRecord;
//
import java.util.*;

/**
 * @author oscardelatorre
 * @date Aug 17, 2016
 * 
 */
public class MaintMainKodtaHodeMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(MaintMainKodtaHodeMapper.class.getName());
	
	public JsonMaintMainKodtaHodeContainer getContainer(String utfPayload) throws Exception{
		
		//At this point we now have an UTF-8 payload
		JsonMaintMainKodtaHodeContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintMainKodtaHodeContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		//DEBUG
		Collection<JsonMaintMainKodtaHodeRecord> list = container.getList();
		for(JsonMaintMainKodtaHodeRecord record : list){
			//logger.info(record.getKlikod());
		}
		return container;
	}
}
