/**
 * 
 */
package no.systema.z.main.maintenance.service.skat;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat.JsonMaintMainDkxstdfvContainer;

/**
 * 
 * @author oscardelatorre
 * @date Apr 11, 2017
 * 
 *
 */
public interface MaintMainDkxstdfvService {
	public JsonMaintMainDkxstdfvContainer getList(String utfPayload);
	public JsonMaintMainDkxstdfvContainer doUpdate(String utfPayload);
	
}
