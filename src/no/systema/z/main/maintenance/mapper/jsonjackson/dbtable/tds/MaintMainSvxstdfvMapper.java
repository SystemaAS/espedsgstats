/**
 * 
 */
package no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.tds;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
//application library
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds.JsonMaintMainSvxstdfvContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds.JsonMaintMainSvxstdfvRecord;
//
import java.util.*;

/**
 * @author oscardelatorre
 * @date Jun 21, 2017
 * 
 */
public class MaintMainSvxstdfvMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(MaintMainSvxstdfvMapper.class.getName());
	
	public JsonMaintMainSvxstdfvContainer getContainer(String utfPayload) throws Exception{
		
		//At this point we now have an UTF-8 payload
		JsonMaintMainSvxstdfvContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintMainSvxstdfvContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		//DEBUG
		Collection<JsonMaintMainSvxstdfvRecord> list = container.getList();
		for(JsonMaintMainSvxstdfvRecord record : list){
			//logger.info(record.getKlikod());
		}
		return container;
	}
}
