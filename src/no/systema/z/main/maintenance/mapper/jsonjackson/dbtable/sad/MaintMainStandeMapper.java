/**
 * 
 */
package no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.sad;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
//application library
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad.JsonMaintMainStandeContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad.JsonMaintMainStandeRecord;
//
import java.util.*;

/**
 * @author oscardelatorre
 * @date Sep 16, 2016
 * 
 */
public class MaintMainStandeMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(MaintMainStandeMapper.class.getName());
	
	public JsonMaintMainStandeContainer getContainer(String utfPayload) throws Exception{
		//At this point we now have an UTF-8 payload
		JsonMaintMainStandeContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintMainStandeContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		//DEBUG
		Collection<JsonMaintMainStandeRecord> list = container.getList();
		for(JsonMaintMainStandeRecord record : list){
			//logger.info(record.getKlikod());
		}
		return container;
	}
}
