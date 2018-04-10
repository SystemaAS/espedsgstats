/**
 * 
 */
package no.systema.z.main.maintenance.service.sad;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad.JsonMaintMainStandeContainer;

/**
 * 
 * @author oscardelatorre
 * @date Sep 16, 2016
 * 
 *
 */
public interface MaintMainStandeService {
	public JsonMaintMainStandeContainer getList(String utfPayload);
	public JsonMaintMainStandeContainer doUpdate(String utfPayload);
	
}
