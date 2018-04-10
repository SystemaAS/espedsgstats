/**
 * 
 */
package no.systema.z.main.maintenance.service.tds;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds.JsonMaintMainSviaContainer;

/**
 * 
 * @author oscardelatorre
 * @date Jun 13, 2017
 * 
 *
 */
public interface MaintMainSviaService {
	public JsonMaintMainSviaContainer getList(String utfPayload);
	public JsonMaintMainSviaContainer doUpdate(String utfPayload);
	
}
