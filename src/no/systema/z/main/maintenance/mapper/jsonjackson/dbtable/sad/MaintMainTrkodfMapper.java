/**
 * 
 */
package no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.sad;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
//application library
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad.JsonMaintMainTrkodfContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad.JsonMaintMainTrkodfRecord;
//
import java.util.*;

/**
 * @author oscardelatorre
 * @date Sep 20, 2016
 * 
 */
public class MaintMainTrkodfMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(MaintMainTrkodfMapper.class.getName());
	
	public JsonMaintMainTrkodfContainer getContainer(String utfPayload) throws Exception{
		
		
		//At this point we now have an UTF-8 payload
		JsonMaintMainTrkodfContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintMainTrkodfContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		//DEBUG
		Collection<JsonMaintMainTrkodfRecord> list = container.getList();
		for(JsonMaintMainTrkodfRecord record : list){
			//logger.info(record.getKlikod());
		}
		return container;
	}
}
