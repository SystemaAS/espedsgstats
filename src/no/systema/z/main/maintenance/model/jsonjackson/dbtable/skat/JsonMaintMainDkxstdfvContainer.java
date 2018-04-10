/**
 * 
 */
package no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat;

import java.util.Collection;

/**
 * @author oscardelatorre
 * @date Apr 11, 2017
 *
 */
public class JsonMaintMainDkxstdfvContainer {
	private String user = null;
	public void setUser(String value) {  this.user = value; }
	public String getUser() { return this.user;}
	
	private String errMsg = null;
	public void setErrMsg(String value) {  this.errMsg = value; }
	public String getErrMsg() { return this.errMsg;}
	
	private Collection<JsonMaintMainDkxstdfvRecord> list;
	public void setList(Collection<JsonMaintMainDkxstdfvRecord> value){ this.list = value; }
	public Collection<JsonMaintMainDkxstdfvRecord> getList(){ return list; }
	
}
