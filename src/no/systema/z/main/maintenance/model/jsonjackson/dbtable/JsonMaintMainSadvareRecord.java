/**
 * 
 */
package no.systema.z.main.maintenance.model.jsonjackson.dbtable;

import no.systema.main.model.jsonjackson.general.JsonAbstractGrandFatherRecord;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Copy of JsonMaintSadImportSadvareRecord
 * 
 * @author Fredrik Möller
 * @date Mar 17, 2017
 *
 */
public class JsonMaintMainSadvareRecord extends JsonAbstractGrandFatherRecord {

	private String varenr = null;
	private String varebe = null;
	private String levenr = null;
	private String w2vf = null;
	private String w2lk = null;
	private String w2vnti = null;
	private String w2tn = null;
	private String w2pre = null;
	private String w2pva = null;
	private String w2as = null;
	private String w2mfr = null;
	private String w2belt = null;
	private String w2vktb = null;
	private String w2ntm = null;
	private String w2beln = null;
	private String w2pros = null;
	private String w2val = null;

	public String getVarenr() {
		return varenr;
	}

	public void setVarenr(String varenr) {
		this.varenr = varenr;
	}

	public String getVarebe() {
		return varebe;
	}

	public void setVarebe(String varebe) {
		this.varebe = varebe;
	}

	public String getLevenr() {
		return levenr;
	}

	public void setLevenr(String levenr) {
		this.levenr = levenr;
	}

	public String getW2vf() {
		return w2vf;
	}

	public void setW2vf(String w2vf) {
		this.w2vf = w2vf;
	}

	public String getW2lk() {
		return w2lk;
	}

	public void setW2lk(String w2lk) {
		this.w2lk = w2lk;
	}

	public String getW2vnti() {
		return w2vnti;
	}

	public void setW2vnti(String w2vnti) {
		this.w2vnti = w2vnti;
	}

	public String getW2tn() {
		return w2tn;
	}

	public void setW2tn(String w2tn) {
		this.w2tn = w2tn;
	}

	public String getW2pre() {
		return w2pre;
	}

	public void setW2pre(String w2pre) {
		this.w2pre = w2pre;
	}

	public String getW2pva() {
		return w2pva;
	}

	public void setW2pva(String w2pva) {
		this.w2pva = w2pva;
	}

	public String getW2as() {
		return w2as;
	}

	public void setW2as(String w2as) {
		this.w2as = w2as;
	}

	public String getW2mfr() {
		return w2mfr;
	}

	public void setW2mfr(String w2mfr) {
		this.w2mfr = w2mfr;
	}

	public String getW2belt() {
		return w2belt;
	}

	public void setW2belt(String w2belt) {
		this.w2belt = w2belt;
	}

	public String getW2vktb() {
		return w2vktb;
	}

	public void setW2vktb(String w2vktb) {
		this.w2vktb = w2vktb;
	}

	public String getW2ntm() {
		return w2ntm;
	}

	public void setW2ntm(String w2ntm) {
		this.w2ntm = w2ntm;
	}

	public String getW2beln() {
		return w2beln;
	}

	public void setW2beln(String w2beln) {
		this.w2beln = w2beln;
	}

	public String getW2pros() {
		return w2pros;
	}

	public void setW2pros(String w2pros) {
		this.w2pros = w2pros;
	}

	public String getW2val() {
		return w2val;
	}

	public void setW2val(String w2val) {
		this.w2val = w2val;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Field> getFields() throws Exception {
		Class cl = Class.forName(this.getClass().getCanonicalName());
		Field[] fields = cl.getDeclaredFields();
		List<Field> list = Arrays.asList(fields);

		return list;
	}

}
