/**
 * 
 */
package no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat;

import java.util.Collection;

/**
 * @author oscardelatorre
 * @date Apr 26, 2017
 *
 */
public class JsonMaintMainDkiaContainer {
	private String user = null;
	public void setUser(String value) {  this.user = value; }
	public String getUser() { return this.user;}
	
	private String errMsg = null;
	public void setErrMsg(String value) {  this.errMsg = value; }
	public String getErrMsg() { return this.errMsg;}
	
	private Collection<JsonMaintMainDkiaRecord> list;
	public void setList(Collection<JsonMaintMainDkiaRecord> value){ this.list = value; }
	public Collection<JsonMaintMainDkiaRecord> getList(){ return list; }
	
}
