/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtpUtskrsContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.MaintMainKodtpUtskrsMapper;

/**
 * 
 * @author oscardelatorre
 * @date Aug 9, 2016
 * 
 * 
 */
public class MaintMainKodtpUtskrsServiceImpl implements MaintMainKodtpUtskrsService {
	/**
	 * 
	 */
	public JsonMaintMainKodtpUtskrsContainer getList(String utfPayload) {
		JsonMaintMainKodtpUtskrsContainer container = null;
		try{
			MaintMainKodtpUtskrsMapper mapper = new MaintMainKodtpUtskrsMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}
	/**
	 * 
	 * @param utfPayload
	 * @return
	 */
	public JsonMaintMainKodtpUtskrsContainer doUpdate(String utfPayload) {
		JsonMaintMainKodtpUtskrsContainer container = null;
		try{
			MaintMainKodtpUtskrsMapper mapper = new MaintMainKodtpUtskrsMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}
	
}
