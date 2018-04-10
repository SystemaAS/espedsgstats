/**
 * 
 */
package no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.sad;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
//application library
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad.JsonMaintMainStandiContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad.JsonMaintMainStandiRecord;
//
import java.util.*;

/**
 * @author oscardelatorre
 * @date Aug 25, 2016
 * 
 */
public class MaintMainStandiMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(MaintMainStandiMapper.class.getName());
	
	public JsonMaintMainStandiContainer getContainer(String utfPayload) throws Exception{
		
		//At this point we now have an UTF-8 payload
		JsonMaintMainStandiContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintMainStandiContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		//DEBUG
		Collection<JsonMaintMainStandiRecord> list = container.getList();
		for(JsonMaintMainStandiRecord record : list){
			//logger.info(record.getKlikod());
		}
		return container;
	}
}
