/**
 * 
 */
package no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds;

import java.util.Collection;

/**
 * @author oscardelatorre
 * @date Jun 08, 2017
 *
 */
public class JsonMaintMainSveaContainer {
	private String user = null;
	public void setUser(String value) {  this.user = value; }
	public String getUser() { return this.user;}
	
	private String errMsg = null;
	public void setErrMsg(String value) {  this.errMsg = value; }
	public String getErrMsg() { return this.errMsg;}
	
	private Collection<JsonMaintMainSveaRecord> list;
	public void setList(Collection<JsonMaintMainSveaRecord> value){ this.list = value; }
	public Collection<JsonMaintMainSveaRecord> getList(){ return list; }
	
}
