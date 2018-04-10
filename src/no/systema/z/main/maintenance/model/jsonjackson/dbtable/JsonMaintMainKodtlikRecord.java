package no.systema.z.main.maintenance.model.jsonjackson.dbtable;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import no.systema.main.model.jsonjackson.general.JsonAbstractGrandFatherRecord;

public class JsonMaintMainKodtlikRecord extends JsonAbstractGrandFatherRecord {

	private String klkst = null;
	private String klkuni = null;
	private String klklk = null;
	private String klknvn = null;
	private String klkalf = null;
	private String klkxx1 = null;
	private String klkmin = null;
	private String klkdis = null;
	private String klkpro = null;
	private String klklk2 = null;
	private String klkxx2 = null;
	private String klknve = null;
	private String klknvt = null;

	public String getKlkst() {
		return klkst;
	}

	public void setKlkst(String klkst) {
		this.klkst = klkst;
	}

	public String getKlkuni() {
		return klkuni;
	}

	public void setKlkuni(String klkuni) {
		this.klkuni = klkuni;
	}

	public String getKlklk() {
		return klklk;
	}

	public void setKlklk(String klklk) {
		this.klklk = klklk;
	}

	public String getKlknvn() {
		return klknvn;
	}

	public void setKlknvn(String klknvn) {
		this.klknvn = klknvn;
	}

	public String getKlkalf() {
		return klkalf;
	}

	public void setKlkalf(String klkalf) {
		this.klkalf = klkalf;
	}

	public String getKlkxx1() {
		return klkxx1;
	}

	public void setKlkxx1(String klkxx1) {
		this.klkxx1 = klkxx1;
	}

	public String getKlkmin() {
		return klkmin;
	}

	public void setKlkmin(String klkmin) {
		this.klkmin = klkmin;
	}

	public String getKlkdis() {
		return klkdis;
	}

	public void setKlkdis(String klkdis) {
		this.klkdis = klkdis;
	}

	public String getKlkpro() {
		return klkpro;
	}

	public void setKlkpro(String klkpro) {
		this.klkpro = klkpro;
	}

	public String getKlklk2() {
		return klklk2;
	}

	public void setKlklk2(String klklk2) {
		this.klklk2 = klklk2;
	}

	public String getKlkxx2() {
		return klkxx2;
	}

	public void setKlkxx2(String klkxx2) {
		this.klkxx2 = klkxx2;
	}

	public String getKlknve() {
		return klknve;
	}

	public void setKlknve(String klknve) {
		this.klknve = klknve;
	}

	public String getKlknvt() {
		return klknvt;
	}

	public void setKlknvt(String klknvt) {
		this.klknvt = klknvt;
	}

	@Override
	public List<Field> getFields() throws Exception {
		Class cl = Class.forName(this.getClass().getCanonicalName());
		Field[] fields = cl.getDeclaredFields();
		List<Field> list = Arrays.asList(fields);

		return list;
	}

}
