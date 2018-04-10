/**
 * 
 */
package no.systema.z.main.maintenance.service.skat;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat.JsonMaintMainDkiaContainer;

/**
 * 
 * @author oscardelatorre
 * @date Apr 26, 2017
 * 
 *
 */
public interface MaintMainDkiaService {
	public JsonMaintMainDkiaContainer getList(String utfPayload);
	public JsonMaintMainDkiaContainer doUpdate(String utfPayload);
	
}
