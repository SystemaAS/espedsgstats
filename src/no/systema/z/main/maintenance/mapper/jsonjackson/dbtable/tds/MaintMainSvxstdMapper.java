/**
 * 
 */
package no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.tds;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
//application library
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds.JsonMaintMainSvxstdContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds.JsonMaintMainSvxstdRecord;
//
import java.util.*;

/**
 * @author oscardelatorre
 * @date Jun 16, 2017
 * 
 */
public class MaintMainSvxstdMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(MaintMainSvxstdMapper.class.getName());
	
	public JsonMaintMainSvxstdContainer getContainer(String utfPayload) throws Exception{
		
		//At this point we now have an UTF-8 payload
		JsonMaintMainSvxstdContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintMainSvxstdContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		//DEBUG
		Collection<JsonMaintMainSvxstdRecord> list = container.getList();
		for(JsonMaintMainSvxstdRecord record : list){
			//logger.info(record.getKlikod());
		}
		return container;
	}
}
