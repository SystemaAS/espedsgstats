/**
 * 
 */
package no.systema.z.main.maintenance.service.sad;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad.JsonMaintMainTristdContainer;

/**
 * 
 * @author oscardelatorre
 * @date Sep 20, 2016
 * 
 *
 */
public interface MaintMainTristdService {
	public JsonMaintMainTristdContainer getList(String utfPayload);
	public JsonMaintMainTristdContainer doUpdate(String utfPayload);
	
}
