/**
 * 
 */
package no.systema.z.main.maintenance.mapper.jsonjackson.dbtable;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
//application library
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtpUtskrsContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtpUtskrsRecord;
//
import java.util.*;

/**
 * @author oscardelatorre
 * @date Aug 9, 2016
 * 
 */
public class MaintMainKodtpUtskrsMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(MaintMainKodtpUtskrsMapper.class.getName());
	
	public JsonMaintMainKodtpUtskrsContainer getContainer(String utfPayload) throws Exception{
		
		//At this point we now have an UTF-8 payload
		JsonMaintMainKodtpUtskrsContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintMainKodtpUtskrsContainer.class); 
		//logger.info("[JSON-String payload status=OK]  " + container.getUser());
		//DEBUG
		Collection<JsonMaintMainKodtpUtskrsRecord> list = container.getList();
		for(JsonMaintMainKodtpUtskrsRecord record : list){
			//logger.info(record.getKlikod());
		}
		return container;
	}
}
