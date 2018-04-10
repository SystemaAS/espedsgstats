/**
 * 
 */
package no.systema.z.main.maintenance.model.jsonjackson.dbtable;

import java.util.Collection;

/**
 * @author oscardelatorre
 * @date Apr 21, 2017
 *
 */
public class JsonMaintMainKosttContainer {
	private String user = null;
	public void setUser(String value) {  this.user = value; }
	public String getUser() { return this.user;}
	
	private String errMsg = null;
	public void setErrMsg(String value) {  this.errMsg = value; }
	public String getErrMsg() { return this.errMsg;}
	
	private Collection<JsonMaintMainKosttRecord> list;
	public void setList(Collection<JsonMaintMainKosttRecord> value){ this.list = value; }
	public Collection<JsonMaintMainKosttRecord> getList(){ return list; }
	
}
