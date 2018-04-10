/**
 * 
 */
package no.systema.z.main.maintenance.mapper.jsonjackson.dbtable;

//jackson library
import org.apache.log4j.Logger;

import no.systema.main.mapper.jsonjackson.general.ObjectMapperAbstractGrandFather;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainSyparfContainer;

/**
 * @author Fredrik Möller
 * @date Nov 3, 2016
 * 
 */
public class MaintMainSyparfMapper extends ObjectMapperAbstractGrandFather {
	private static final Logger logger = Logger.getLogger(MaintMainSyparfMapper.class.getName());
	
	public JsonMaintMainSyparfContainer getContainer(String utfPayload) throws Exception{
		
		//At this point we now have an UTF-8 payload
		JsonMaintMainSyparfContainer container = super.getObjectMapper().readValue(utfPayload.getBytes(), JsonMaintMainSyparfContainer.class); 
		
		return container;
	}
}
