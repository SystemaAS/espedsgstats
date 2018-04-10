package no.systema.z.main.maintenance.model.jsonjackson.dbtable;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import no.systema.main.model.jsonjackson.general.JsonAbstractGrandFatherRecord;

public class JsonMaintMainSyparfRecord extends JsonAbstractGrandFatherRecord {


	private String syrecn = null;
	private String syuser = null;
	private String sykunr = null;
	private String syavd  = null;
	private String sypaid = null;
	private String sypaidDesc = null;
	private String sysort  = null;
	private String syvrdn  = null;
	private String syvrda = null;
	
	
	public String getSyrecn() {
		return syrecn;
	}


	public void setSyrecn(String syrecn) {
		this.syrecn = syrecn;
	}


	public String getSyuser() {
		return syuser;
	}


	public void setSyuser(String syuser) {
		this.syuser = syuser;
	}


	public String getSykunr() {
		return sykunr;
	}


	public void setSykunr(String sykunr) {
		this.sykunr = sykunr;
	}


	public String getSyavd() {
		return syavd;
	}


	public void setSyavd(String syavd) {
		this.syavd = syavd;
	}


	public String getSypaid() {
		return sypaid;
	}


	public void setSypaid(String sypaid) {
		this.sypaid = sypaid;
	}


	public String getSypaidDesc() {
		return sypaidDesc;
	}


	public void setSypaidDesc(String sypaidDesc) {
		this.sypaidDesc = sypaidDesc;
	}


	public String getSysort() {
		return sysort;
	}


	public void setSysort(String sysort) {
		this.sysort = sysort;
	}


	public String getSyvrdn() {
		if(syvrdn!=null){
			syvrdn = syvrdn.replace(".", ",");
		}
		
		return syvrdn;
	}


	public void setSyvrdn(String syvrdn) {
		this.syvrdn = syvrdn;
	}


	public String getSyvrda() {
		return syvrda;
	}


	public void setSyvrda(String syvrda) {
		this.syvrda = syvrda;
	}


	@Override
	public List<Field> getFields() throws Exception {
		Class cl = Class.forName(this.getClass().getCanonicalName());
		Field[] fields = cl.getDeclaredFields();
		List<Field> list = Arrays.asList(fields);
		
		return list;
	}

}
