/**
 * 
 */
package no.systema.z.main.maintenance.service.skat;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat.JsonMaintMainDknstdContainer;

/**
 * 
 * @author oscardelatorre
 * @date Apr 24, 2017
 * 
 *
 */
public interface MaintMainDknstdService {
	public JsonMaintMainDknstdContainer getList(String utfPayload);
	public JsonMaintMainDknstdContainer doUpdate(String utfPayload);
	
}
