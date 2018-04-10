/**
 * 
 */
package no.systema.z.main.maintenance.service.sad;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad.JsonMaintMainTrustdfvContainer;

/**
 * 
 * @author oscardelatorre
 * @date Oct 4, 2016
 * 
 *
 */
public interface MaintMainTrustdfvService {
	public JsonMaintMainTrustdfvContainer getList(String utfPayload);
	public JsonMaintMainTrustdfvContainer doUpdate(String utfPayload);
	
}
