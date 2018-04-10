/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtot2Container;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.MaintMainKodtot2Mapper;

/**
 * 
 * @author oscardelatorre
 * @date Sep 8, 2016
 * 
 * 
 */
public class MaintMainKodtot2ServiceImpl implements MaintMainKodtot2Service {
	/**
	 * 
	 */
	public JsonMaintMainKodtot2Container getList(String utfPayload) {
		JsonMaintMainKodtot2Container container = null;
		try{
			MaintMainKodtot2Mapper mapper = new MaintMainKodtot2Mapper();
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
	public JsonMaintMainKodtot2Container doUpdate(String utfPayload) {
		JsonMaintMainKodtot2Container container = null;
		try{
			MaintMainKodtot2Mapper mapper = new MaintMainKodtot2Mapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
