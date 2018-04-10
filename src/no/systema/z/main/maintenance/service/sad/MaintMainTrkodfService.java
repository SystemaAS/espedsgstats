/**
 * 
 */
package no.systema.z.main.maintenance.service.sad;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad.JsonMaintMainTrkodfContainer;

/**
 * 
 * @author oscardelatorre
 * @date Sep 21, 2016
 * 
 *
 */
public interface MaintMainTrkodfService {
	public JsonMaintMainTrkodfContainer getList(String utfPayload);
	public JsonMaintMainTrkodfContainer doUpdate(String utfPayload);
	
}
