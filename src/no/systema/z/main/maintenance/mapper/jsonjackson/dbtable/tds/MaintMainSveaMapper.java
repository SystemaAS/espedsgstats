/**
 * 
 */
package no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.tds;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
//application library
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds.JsonMaintMainSveaContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds.JsonMaintMainSveaRecord;
//
import java.util.*;

/**
 * @author oscardelatorre
 * @date Jun 08, 2017
 * 
 */
public class MaintMainSveaMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(MaintMainSveaMapper.class.getName());
	
	public JsonMaintMainSveaContainer getContainer(String utfPayload) throws Exception{
		
		//At this point we now have an UTF-8 payload
		JsonMaintMainSveaContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintMainSveaContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		//DEBUG
		Collection<JsonMaintMainSveaRecord> list = container.getList();
		for(JsonMaintMainSveaRecord record : list){
			//logger.info(record.getKlikod());
		}
		return container;
	}
}
