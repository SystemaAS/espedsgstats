package no.systema.z.main.maintenance.model.jsonjackson.dbtable;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import no.systema.main.model.jsonjackson.general.JsonAbstractGrandFatherRecord;

public class JsonMaintMainKodtotyRecord extends JsonAbstractGrandFatherRecord {

	private String ko1sta = null;
	private String ko1uni = null;
	private String ko1kod = null;
	private String ko1ntx = null;
	private String ko1etx = null;

	public String getKo1sta() {
		return ko1sta;
	}

	public void setKo1sta(String ko1sta) {
		this.ko1sta = ko1sta;
	}

	public String getKo1uni() {
		return ko1uni;
	}

	public void setKo1uni(String ko1uni) {
		this.ko1uni = ko1uni;
	}

	public String getKo1kod() {
		return ko1kod;
	}

	public void setKo1kod(String ko1kod) {
		this.ko1kod = ko1kod;
	}

	public String getKo1ntx() {
		return ko1ntx;
	}

	public void setKo1ntx(String ko1ntx) {
		this.ko1ntx = ko1ntx;
	}

	public String getKo1etx() {
		return ko1etx;
	}

	public void setKo1etx(String ko1etx) {
		this.ko1etx = ko1etx;
	}

	@Override
	public List<Field> getFields() throws Exception {
		Class cl = Class.forName(this.getClass().getCanonicalName());
		Field[] fields = cl.getDeclaredFields();
		List<Field> list = Arrays.asList(fields);

		return list;
	}

}
