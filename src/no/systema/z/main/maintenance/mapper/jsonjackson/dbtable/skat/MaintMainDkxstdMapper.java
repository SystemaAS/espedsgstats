/**
 * 
 */
package no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.skat;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
//application library
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat.JsonMaintMainDkxstdContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat.JsonMaintMainDkxstdRecord;
//
import java.util.*;

/**
 * @author oscardelatorre
 * @date Apr 11, 2017
 * 
 */
public class MaintMainDkxstdMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(MaintMainDkxstdMapper.class.getName());
	
	public JsonMaintMainDkxstdContainer getContainer(String utfPayload) throws Exception{
		
		//At this point we now have an UTF-8 payload
		JsonMaintMainDkxstdContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintMainDkxstdContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		//DEBUG
		Collection<JsonMaintMainDkxstdRecord> list = container.getList();
		for(JsonMaintMainDkxstdRecord record : list){
			//logger.info(record.getKlikod());
		}
		return container;
	}
}
