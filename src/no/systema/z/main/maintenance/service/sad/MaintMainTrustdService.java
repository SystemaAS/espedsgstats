/**
 * 
 */
package no.systema.z.main.maintenance.service.sad;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad.JsonMaintMainTrustdContainer;

/**
 * 
 * @author oscardelatorre
 * @date Sep 30, 2016
 * 
 *
 */
public interface MaintMainTrustdService {
	public JsonMaintMainTrustdContainer getList(String utfPayload);
	public JsonMaintMainTrustdContainer doUpdate(String utfPayload);
	
}
