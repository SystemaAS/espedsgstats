/**
 * 
 */
package no.systema.z.main.maintenance.service.sad;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad.JsonMaintMainStandiContainer;

/**
 * 
 * @author oscardelatorre
 * @date Aug 25, 2016
 * 
 *
 */
public interface MaintMainStandiService {
	public JsonMaintMainStandiContainer getList(String utfPayload);
	public JsonMaintMainStandiContainer doUpdate(String utfPayload);
	
}
