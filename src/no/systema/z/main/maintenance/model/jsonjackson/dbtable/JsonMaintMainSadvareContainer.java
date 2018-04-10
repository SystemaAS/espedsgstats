/**
 * 
 */
package no.systema.z.main.maintenance.model.jsonjackson.dbtable;

import java.util.Collection;

/**
 * Copy of JsonMaintSadImportSadvareContainer
 * 
 * @author Fredrik Möller
 * @date Mar 17, 2017
 *
 */
public class JsonMaintMainSadvareContainer implements IJsonMaintMainContainer {
	private String user = null;
	public void setUser(String value) {  this.user = value; }
	public String getUser() { return this.user;}
	
	private String errMsg = null;
	public void setErrMsg(String value) {  this.errMsg = value; }
	public String getErrMsg() { return this.errMsg;}
	
	
	private Collection<JsonMaintMainSadvareRecord> dtoList;
	public void setDtoList(Collection<JsonMaintMainSadvareRecord> value){ this.dtoList = value; }
	public Collection<JsonMaintMainSadvareRecord> getDtoList(){ return dtoList; }
	
}
