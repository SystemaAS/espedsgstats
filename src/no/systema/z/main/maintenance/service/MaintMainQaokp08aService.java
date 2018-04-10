/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainQaokp08aContainer;

/**
 * 
 * @author oscardelatorre
 * @date May 05, 2017
 * 
 *
 */
public interface MaintMainQaokp08aService {
	public JsonMaintMainQaokp08aContainer getList(String utfPayload);
	
}
