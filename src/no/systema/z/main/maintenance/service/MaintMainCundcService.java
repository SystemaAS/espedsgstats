/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainCundcContainer;

/**
 * 
 * @author Fredrik Möller
 * @date Nov 3, 2016
 * 
 *
 */
public interface MaintMainCundcService {
	public JsonMaintMainCundcContainer getList(String utfPayload);
	public JsonMaintMainCundcContainer doUpdate(String utfPayload);
	
}
