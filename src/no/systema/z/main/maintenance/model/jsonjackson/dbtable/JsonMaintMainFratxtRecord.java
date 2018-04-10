package no.systema.z.main.maintenance.model.jsonjackson.dbtable;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import no.systema.main.model.jsonjackson.general.JsonAbstractGrandFatherRecord;

public class JsonMaintMainFratxtRecord extends JsonAbstractGrandFatherRecord {

	private String fxknr = null;
	private String fxlnr = null;
	private String fxtxt  = null;
	private String fxxxx  = null;
	private String delsys = null;
	private String fxusr  = null;
	private String fxdt  = null;

	
	public String getFxknr() {
		return fxknr;
	}



	public void setFxknr(String fxknr) {
		this.fxknr = fxknr;
	}



	public String getFxlnr() {
		return fxlnr;
	}



	public void setFxlnr(String fxlnr) {
		this.fxlnr = fxlnr;
	}



	public String getFxtxt() {
		return fxtxt;
	}



	public void setFxtxt(String fxtxt) {
		this.fxtxt = fxtxt;
	}



	public String getFxxxx() {
		return fxxxx;
	}



	public void setFxxxx(String fxxxx) {
		this.fxxxx = fxxxx;
	}



	public String getDelsys() {
		return delsys;
	}



	public void setDelsys(String delsys) {
		this.delsys = delsys;
	}



	public String getFxusr() {
		return fxusr;
	}



	public void setFxusr(String fxusr) {
		this.fxusr = fxusr;
	}



	public String getFxdt() {
		return fxdt;
	}



	public void setFxdt(String fxdt) {
		this.fxdt = fxdt;
	}



	@Override
	public List<Field> getFields() throws Exception {
		Class cl = Class.forName(this.getClass().getCanonicalName());
		Field[] fields = cl.getDeclaredFields();
		List<Field> list = Arrays.asList(fields);
		
		return list;
	}

}
