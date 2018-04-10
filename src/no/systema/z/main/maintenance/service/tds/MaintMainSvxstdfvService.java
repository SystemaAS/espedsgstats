/**
 * 
 */
package no.systema.z.main.maintenance.service.tds;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds.JsonMaintMainSvxstdfvContainer;

/**
 * 
 * @author oscardelatorre
 * @date Jun 21, 2017
 * 
 *
 */
public interface MaintMainSvxstdfvService {
	public JsonMaintMainSvxstdfvContainer getList(String utfPayload);
	public JsonMaintMainSvxstdfvContainer doUpdate(String utfPayload);
	
}
