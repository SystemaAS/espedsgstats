/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainEdiiContainer;

/**
 * 
 * @author oscardelatorre
 * @date Sep 8, 2016
 * 
 *
 */
public interface MaintMainEdiiService {
	public JsonMaintMainEdiiContainer getList(String utfPayload);
	public JsonMaintMainEdiiContainer doUpdate(String utfPayload);
	
}
