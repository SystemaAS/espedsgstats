package no.systema.z.main.maintenance.model.jsonjackson.dbtable;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import no.systema.main.model.jsonjackson.general.JsonAbstractGrandFatherRecord;

public class JsonMaintMainValufRecord extends JsonAbstractGrandFatherRecord {

	private String aktkod = null;
	private String journr = null;
	private String firma = null;
	private String valkod = null;
	private String valtek = null;
	private String valku1 = null;
	private String valku2 = null;
	private String omrfak = null;
	private String valaar = null;
	private String valmnd = null;
	private String valdag = null;
	private String avrkvl = null;
	private String agaavl = null;
	private String agmnvl = null;
	private String agdavl = null;
	private String kur1vl = null;
	private String kur2vl = null;
	private String euvevl = null;
	private String andevl = null;

	public String getAktkod() {
		return aktkod;
	}

	public void setAktkod(String aktkod) {
		this.aktkod = aktkod;
	}

	public String getJournr() {
		return journr;
	}

	public void setJournr(String journr) {
		this.journr = journr;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public String getValkod() {
		return valkod;
	}

	public void setValkod(String valkod) {
		this.valkod = valkod;
	}

	public String getValtek() {
		return valtek;
	}

	public void setValtek(String valtek) {
		this.valtek = valtek;
	}

	public String getValku1() {
		return valku1;
	}

	public void setValku1(String valku1) {
		this.valku1 = valku1;
	}

	public String getValku2() {
		return valku2;
	}

	public void setValku2(String valku2) {
		this.valku2 = valku2;
	}

	public String getOmrfak() {
		return omrfak;
	}

	public void setOmrfak(String omrfak) {
		this.omrfak = omrfak;
	}

	public String getValaar() {
		return valaar;
	}

	public void setValaar(String valaar) {
		this.valaar = valaar;
	}

	public String getValmnd() {
		return valmnd;
	}

	public void setValmnd(String valmnd) {
		this.valmnd = valmnd;
	}

	public String getValdag() {
		return valdag;
	}

	public void setValdag(String valdag) {
		this.valdag = valdag;
	}

	public String getAvrkvl() {
		return avrkvl;
	}

	public void setAvrkvl(String avrkvl) {
		this.avrkvl = avrkvl;
	}

	public String getAgaavl() {
		return agaavl;
	}

	public void setAgaavl(String agaavl) {
		this.agaavl = agaavl;
	}

	public String getAgmnvl() {
		return agmnvl;
	}

	public void setAgmnvl(String agmnvl) {
		this.agmnvl = agmnvl;
	}

	public String getAgdavl() {
		return agdavl;
	}

	public void setAgdavl(String agdavl) {
		this.agdavl = agdavl;
	}

	public String getKur1vl() {
		return kur1vl;
	}

	public void setKur1vl(String kur1vl) {
		this.kur1vl = kur1vl;
	}

	public String getKur2vl() {
		return kur2vl;
	}

	public void setKur2vl(String kur2vl) {
		this.kur2vl = kur2vl;
	}

	public String getEuvevl() {
		return euvevl;
	}

	public void setEuvevl(String euvevl) {
		this.euvevl = euvevl;
	}

	public String getAndevl() {
		return andevl;
	}

	public void setAndevl(String andevl) {
		this.andevl = andevl;
	}

	@Override
	public List<Field> getFields() throws Exception {
		Class cl = Class.forName(this.getClass().getCanonicalName());
		Field[] fields = cl.getDeclaredFields();
		List<Field> list = Arrays.asList(fields);

		return list;
	}

}
