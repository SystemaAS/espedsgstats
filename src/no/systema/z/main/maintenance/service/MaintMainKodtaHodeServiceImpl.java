/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtaHodeContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.MaintMainKodtaHodeMapper;

/**
 * 
 * @author oscardelatorre
 * @date Aug 9, 2016
 * 
 * 
 */
public class MaintMainKodtaHodeServiceImpl implements MaintMainKodtaHodeService {
	/**
	 * 
	 */
	public JsonMaintMainKodtaHodeContainer getList(String utfPayload) {
		JsonMaintMainKodtaHodeContainer container = null;
		try{
			MaintMainKodtaHodeMapper mapper = new MaintMainKodtaHodeMapper();
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
	public JsonMaintMainKodtaHodeContainer doUpdate(String utfPayload) {
		JsonMaintMainKodtaHodeContainer container = null;
		try{
			MaintMainKodtaHodeMapper mapper = new MaintMainKodtaHodeMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}
	
}
