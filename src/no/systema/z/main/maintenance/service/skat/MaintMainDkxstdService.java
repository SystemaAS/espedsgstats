/**
 * 
 */
package no.systema.z.main.maintenance.service.skat;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat.JsonMaintMainDkxstdContainer;

/**
 * 
 * @author oscardelatorre
 * @date Apr 11, 2017
 * 
 *
 */
public interface MaintMainDkxstdService {
	public JsonMaintMainDkxstdContainer getList(String utfPayload);
	public JsonMaintMainDkxstdContainer doUpdate(String utfPayload);
	
}
