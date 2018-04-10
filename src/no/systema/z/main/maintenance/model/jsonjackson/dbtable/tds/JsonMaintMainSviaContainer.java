/**
 * 
 */
package no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds;

import java.util.Collection;

/**
 * @author oscardelatorre
 * @date Jun 13, 2017
 *
 */
public class JsonMaintMainSviaContainer {
	private String user = null;
	public void setUser(String value) {  this.user = value; }
	public String getUser() { return this.user;}
	
	private String errMsg = null;
	public void setErrMsg(String value) {  this.errMsg = value; }
	public String getErrMsg() { return this.errMsg;}
	
	private Collection<JsonMaintMainSviaRecord> list;
	public void setList(Collection<JsonMaintMainSviaRecord> value){ this.list = value; }
	public Collection<JsonMaintMainSviaRecord> getList(){ return list; }
	
}
