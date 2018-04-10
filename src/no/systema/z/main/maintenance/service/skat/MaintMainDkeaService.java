/**
 * 
 */
package no.systema.z.main.maintenance.service.skat;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat.JsonMaintMainDkeaContainer;

/**
 * 
 * @author oscardelatorre
 * @date Apr 26, 2017
 * 
 *
 */
public interface MaintMainDkeaService {
	public JsonMaintMainDkeaContainer getList(String utfPayload);
	public JsonMaintMainDkeaContainer doUpdate(String utfPayload);
	
}
