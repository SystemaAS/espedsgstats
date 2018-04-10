/**
 * 
 */
package no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad;

import java.util.Collection;

/**
 * @author oscardelatorre
 * @date Oct 3, 2016
 *
 */
public class JsonMaintMainTrustdfvContainer {
	private String user = null;
	public void setUser(String value) {  this.user = value; }
	public String getUser() { return this.user;}
	
	private String errMsg = null;
	public void setErrMsg(String value) {  this.errMsg = value; }
	public String getErrMsg() { return this.errMsg;}
	
	private Collection<JsonMaintMainTrustdfvRecord> list;
	public void setList(Collection<JsonMaintMainTrustdfvRecord> value){ this.list = value; }
	public Collection<JsonMaintMainTrustdfvRecord> getList(){ return list; }
	
}
