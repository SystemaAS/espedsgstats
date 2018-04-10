package no.systema.z.main.maintenance.model.jsonjackson.dbtable;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import no.systema.main.model.jsonjackson.general.JsonAbstractGrandFatherRecord;

public class JsonMaintMainCundcRecord extends JsonAbstractGrandFatherRecord {

	private String ccompn = null; // key
	private String cfirma = null; // key
	private String cconta = null; // key
	private String ccontaorg = null; 
	private String ctype = null;
	private String cphone = null;
	private String cmobil = null;
	private String cfax = null;
	private String cemail = null;
	private String clive = null;
	private String cprint = null;
	private String sonavn = null;
	private String cemne = null;
	private String cavd = null; //init with zero's
	private String cavd1 = null; 
	private String cavd2 = null; 
	private String cavd3 = null; 
	private String cavd4 = null; 
	private String cavd5 = null; 
	private String cavd6 = null; 
	private String cavd7 = null; 
	private String cavd8 = null; 
	private String cavd9 = null; 
	private String cavd10 = null; 
	private String cavd11 = null; 
	private String cavd12 = null; 
	private String cavd13 = null; 
	private String cavd14 = null; 
	private String cavd15 = null; 
	private String cavd16 = null; 
	private String cavd17 = null; 
	private String cavd18 = null; 
	private String cavd19 = null; 
	private String cavd20 = null; 
	private String cavdio = null;
	private String copd = null; //no init
	private String copd1 = null;
	private String copd2 = null;
	private String copd3 = null;
	private String copd4 = null;
	private String copd5 = null;
	private String copdio = null;
	private String cmerge = null;
	private String avkved = null; //no init
	private String avkved1 = null;
	private String avkved2 = null;
	private String avkved3 = null;
	private String avkved4 = null;
	private String avkved5 = null;
	private String avkved6 = null;
	private String avkved7 = null;
	private String avkved8 = null;
	private String avkved9 = null;
	private String avkved10 = null;
	private String avkved11 = null;
	private String avkved12 = null;
	private String avkved13 = null;
	private String avkved14 = null;
	private String avkved15 = null;
	private String avkved16 = null;
	private String avkved17 = null;
	private String avkved18 = null;
	private String avkved19 = null;
	private String avkved20 = null;
	private String avkved21 = null;
	private String avkved22 = null;
	private String avkved23 = null;
	private String avkved24 = null;
	private String avkved25 = null;
	private String avkved26 = null;
	private String avkved27 = null;
	private String avkved28 = null;
	private String avkved29 = null;
	private String avkved30 = null;
	
	
	public String getCcompn() {
		return ccompn;
	}

	public void setCcompn(String ccompn) {
		this.ccompn = ccompn;
	}

	public String getCfirma() {
		return cfirma;
	}

	public void setCfirma(String cfirma) {
		this.cfirma = cfirma;
	}

	public String getCconta() {
		return cconta;
	}

	public void setCconta(String cconta) {
		this.cconta = cconta;
	}

	public String getCcontaorg() {
		return ccontaorg;
	}

	public void setCcontaorg(String ccontaorg) {
		this.ccontaorg = ccontaorg;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getCphone() {
		return cphone;
	}

	public void setCphone(String cphone) {
		this.cphone = cphone;
	}

	public String getCmobil() {
		return cmobil;
	}

	public void setCmobil(String cmobil) {
		this.cmobil = cmobil;
	}

	public String getCfax() {
		return cfax;
	}

	public void setCfax(String cfax) {
		this.cfax = cfax;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getClive() {
		return clive;
	}

	public void setClive(String clive) {
		this.clive = clive;
	}

	public String getCprint() {
		return cprint;
	}

	public void setCprint(String cprint) {
		this.cprint = cprint;
	}

	public String getSonavn() {
		return sonavn;
	}

	public void setSonavn(String sonavn) {
		this.sonavn = sonavn;
	}

	public String getCemne() {
		return cemne;
	}

	public void setCemne(String cemne) {
		this.cemne = cemne;
	}

	public String getCavd() {
		return cavd;
	}

	public void setCavd(String cavd) {
		this.cavd = cavd;
	}

	public void setCavd1(String value) {
		this.cavd1 = value;
	}

	public String getCavd1() {
		if (cavd1 != null) { // from UI
			return leftPad(cavd1);
		} else {
			if (cavd != null) { // from DB
				String cavd1 = this.cavd.substring(0, 4);
				return cleanZeros(cavd1);
			}
		}
		return "";
	}

	public void setCavd2(String value) {
		this.cavd2 = value;
	}

	public String getCavd2() {
		if (cavd2 != null) { // from UI
			return leftPad(cavd2);
		} else {
			if (cavd != null) { // from DB
				String cavd2 = this.cavd.substring(4,8);
				return cleanZeros(cavd2);
			}
		}
		return "";
	}	
	
	public void setCavd3(String value) {
		this.cavd3 = value;
	}

	public String getCavd3() {
		if (cavd3 != null) { // from UI
			return leftPad(cavd3);
		} else { 
			if (cavd != null) { // from DB
				String cavd3 = this.cavd.substring(8,12);
				return cleanZeros(cavd3);
			}
		}
		return "";
	}	

	public void setCavd4(String value) {
		this.cavd4 = value;
	}

	public String getCavd4() {
		if (cavd4 != null) { // from UI
			return leftPad(cavd4);
		} else { 
			if (cavd != null) { // from DB
				String cavd4 = this.cavd.substring(12,16);
				return cleanZeros(cavd4);
			}
		}
		return "";
	}	
	
	public void setCavd5(String value) {
		this.cavd5 = value;
	}

	public String getCavd5() {
		if (cavd5 != null) { // from UI
			return leftPad(cavd5);
		} else { 
			if (cavd != null) { // from DB
				String cavd5 = this.cavd.substring(16,20);
				return cleanZeros(cavd5);
			}
		}
		return "";
	}	
	
	public String getCavd6() {
		if (cavd6 != null) { // from UI
			return leftPad(cavd6);
		} else { 
			if (cavd != null) { // from DB
				String cavd6 = this.cavd.substring(20,24);
				return cleanZeros(cavd6);
			}
		}
		return "";
	}	
	
	public String getCavd7() {
		if (cavd7 != null) { // from UI
			return leftPad(cavd7);
		} else { 
			if (cavd != null) { // from DB
				String cavd7 = this.cavd.substring(24,28);
				return cleanZeros(cavd7);
			}
		}
		return "";
	}	
	
	public String getCavd8() {
		if (cavd8 != null) { // from UI
			return leftPad(cavd8);
		} else { 
			if (cavd != null) { // from DB
				String cavd8 = this.cavd.substring(28,32);
				return cleanZeros(cavd8);
			}
		}
		return "";
	}	

	public String getCavd9() {
		if (cavd9 != null) { // from UI
			return leftPad(cavd9);
		} else { 
			if (cavd != null) { // from DB
				String cavd9 = this.cavd.substring(32,36);
				return cleanZeros(cavd9);
			}
		}
		return "";
	}	

	public String getCavd10() {
		if (cavd10 != null) { // from UI
			return leftPad(cavd10);
		} else { 
			if (cavd != null) { // from DB
				String cavd10 = this.cavd.substring(36,40);
				return cleanZeros(cavd10);
			}
		}
		return "";
	}	
	
	public String getCavd11() {
		if (cavd11 != null) { // from UI
			return leftPad(cavd11);
		} else { 
			if (cavd != null) { // from DB
				String cavd11 = this.cavd.substring(40,44);
				return cleanZeros(cavd11);
			}
		}
		return "";
	}	
	
	public String getCavd12() {
		if (cavd12 != null) { // from UI
			return leftPad(cavd12);
		} else { 
			if (cavd != null) { // from DB
				String cavd12 = this.cavd.substring(44,48);
				return cleanZeros(cavd12);
			}
		}
		return "";
	}	

	public String getCavd13() {
		if (cavd13 != null) { // from UI
			return leftPad(cavd13);
		} else { 
			if (cavd != null) { // from DB
				String cavd13 = this.cavd.substring(48,52);
				return cleanZeros(cavd13);
			}
		}
		return "";
	}	
	
	public String getCavd14() {
		if (cavd14 != null) { // from UI
			return leftPad(cavd14);
		} else { 
			if (cavd != null) { // from DB
				String cavd14 = this.cavd.substring(52,56);
				return cleanZeros(cavd14);
			}
		}
		return "";
	}	

	public String getCavd15() {
		if (cavd15 != null) { // from UI
			return leftPad(cavd15);
		} else { 
			if (cavd != null) { // from DB
				String cavd15 = this.cavd.substring(56,60);
				return cleanZeros(cavd15);
			}
		}
		return "";
	}	

	public String getCavd16() {
		if (cavd16 != null) { // from UI
			return leftPad(cavd16);
		} else { 
			if (cavd != null) { // from DB
				String cavd16 = this.cavd.substring(60,64);
				return cleanZeros(cavd16);
			}
		}
		return "";
	}	

	public String getCavd17() {
		if (cavd17 != null) { // from UI
			return leftPad(cavd17);
		} else { 
			if (cavd != null) { // from DB
				String cavd17 = this.cavd.substring(64,68);
				return cleanZeros(cavd17);
			}
		}
		return "";
	}	
	
	public String getCavd18() {
		if (cavd18 != null) { // from UI
			return leftPad(cavd18);
		} else { 
			if (cavd != null) { // from DB
				String cavd18 = this.cavd.substring(68,72);
				return cleanZeros(cavd18);
			}
		}
		return "";
	}	

	public String getCavd19() {
		if (cavd19 != null) { // from UI
			return leftPad(cavd19);
		} else { 
			if (cavd != null) { // from DB
				String cavd19 = this.cavd.substring(72,76);
				return cleanZeros(cavd19);
			}
		}
		return "";
	}	
	
	public String getCavd20() {
		if (cavd20 != null) { // from UI
			return leftPad(cavd20);
		} else { 
			if (cavd != null) { // from DB
				String cavd20 = this.cavd.substring(76,80);
				return cleanZeros(cavd20);
			}
		}
		return "";
	}	
	
	public String getCavdio() {
		return cavdio;
	}

	public void setCavdio(String cavdio) {
		this.cavdio = cavdio;
	}

	public String getCopd() {
		return copd;
	}

	public void setCopd(String copd) {
		this.copd = copd;
	}

	public String getCopd1() {
		if (copd1 != null) { // from UI
			return copd1;
		} else { 
			if (copd != null && copd.length() > 1) { // from DB
				return this.copd.substring(0, 2);
			}
		}
		return "";
	}	
	
	public String getCopd2() {
		if (copd2 != null) { // from UI
			return copd2;
		} else { 
			if (copd != null && copd.length() > 3) { // from DB
				return this.copd.substring(2, 4);
			}
		}
		return "";
	}	
	
	public String getCopd3() {
		if (copd3 != null) { // from UI
			return copd3;
		} else { 
			if (copd != null && copd.length() > 5) { // from DB
				return this.copd.substring(4, 6);
			}
		}
		return "";
	}	
	
	public String getCopd4() {
		if (copd4 != null) { // from UI
			return copd4;
		} else { 
			if (copd != null && copd.length() > 7) { // from DB
				return this.copd.substring(6, 8);
			}
		}
		return "";
	}	
	
	public String getCopd5() {
		if (copd5 != null) { // from UI
			return copd5;
		} else { 
			if (copd != null && copd.length() > 9) { // from DB
				return this.copd.substring(8, 10);
			}
		}
		return "";
	}	
	
	
	public String getCopdio() {
		return copdio;
	}

	public void setCopdio(String copdio) {
		this.copdio = copdio;
	}

	public String getCmerge() {
		return cmerge;
	}

	public void setCmerge(String cmerge) {
		this.cmerge = cmerge;
	}


	public void setCavd6(String cavd6) {
		this.cavd6 = cavd6;
	}

	public void setCavd7(String cavd7) {
		this.cavd7 = cavd7;
	}

	public void setCavd8(String cavd8) {
		this.cavd8 = cavd8;
	}

	public void setCavd9(String cavd9) {
		this.cavd9 = cavd9;
	}

	public void setCavd10(String cavd10) {
		this.cavd10 = cavd10;
	}

	public void setCavd11(String cavd11) {
		this.cavd11 = cavd11;
	}

	public void setCavd12(String cavd12) {
		this.cavd12 = cavd12;
	}

	public void setCavd13(String cavd13) {
		this.cavd13 = cavd13;
	}

	public void setCavd14(String cavd14) {
		this.cavd14 = cavd14;
	}

	public void setCavd15(String cavd15) {
		this.cavd15 = cavd15;
	}

	public void setCavd16(String cavd16) {
		this.cavd16 = cavd16;
	}

	public void setCavd17(String cavd17) {
		this.cavd17 = cavd17;
	}

	public void setCavd18(String cavd18) {
		this.cavd18 = cavd18;
	}

	public void setCavd19(String cavd19) {
		this.cavd19 = cavd19;
	}

	public void setCavd20(String cavd20) {
		this.cavd20 = cavd20;
	}

	public void setCopd1(String copd1) {
		this.copd1 = copd1;
	}

	public void setCopd2(String copd2) {
		this.copd2 = copd2;
	}

	public void setCopd3(String copd3) {
		this.copd3 = copd3;
	}

	public void setCopd4(String copd4) {
		this.copd4 = copd4;
	}

	public void setCopd5(String copd5) {
		this.copd5 = copd5;
	}

	public String getAvkved() {
		return avkved;
	}

	public void setAvkved(String avkved) {
		this.avkved = avkved;
	}

	public String getAvkved1() {
		if (avkved1 != null) { // from UI
			return avkved1;
		} else {
			if (avkved != null && avkved.length() > 1) { // from DB
				return this.avkved.substring(0, 2);
			}
		}
		return "";
	}

	public void setAvkved1(String avkved1) {
		this.avkved1 = avkved1;
	}

	public String getAvkved2() {
		if (avkved2 != null) { // from UI
			return avkved2;
		} else {
			if (avkved != null && avkved.length() > 3) { // from DB
				return this.avkved.substring(2, 4);
			}
		}
		return "";
	}

	public void setAvkved2(String avkved2) {
		this.avkved2 = avkved2;
	}

	public String getAvkved3() {
		if (avkved3 != null) { // from UI
			return avkved3;
		} else {
			if (avkved != null && avkved.length() > 5) { // from DB
				return this.avkved.substring(4, 6);
			}
		}
		return "";
	}

	public void setAvkved3(String avkved3) {
		this.avkved3 = avkved3;
	}

	public String getAvkved4() {
		if (avkved4 != null) { // from UI
			return avkved4;
		} else {
			if (avkved != null && avkved.length() > 7) { // from DB
				return this.avkved.substring(6, 8);
			}
		}
		return "";
	}

	public void setAvkved4(String avkved4) {
		this.avkved4 = avkved4;
	}

	public String getAvkved5() {
		if (avkved5 != null) { // from UI
			return avkved5;
		} else {
			if (avkved != null && avkved.length() > 9) { // from DB
				return this.avkved.substring(8, 10);
			}
		}
		return "";
	}

	public void setAvkved5(String avkved5) {
		this.avkved5 = avkved5;
	}

	public String getAvkved6() {
		if (avkved6 != null) { // from UI
			return avkved6;
		} else {
			if (avkved != null && avkved.length() > 11) { // from DB
				return this.avkved.substring(10, 12);
			}
		}
		return "";
	}

	public void setAvkved6(String avkved6) {
		this.avkved6 = avkved6;
	}

	public String getAvkved7() {
		if (avkved7 != null) { // from UI
			return avkved7;
		} else {
			if (avkved != null && avkved.length() > 13) { // from DB
				return this.avkved.substring(12, 14);
			}
		}
		return "";
	}

	public void setAvkved7(String avkved7) {
		this.avkved7 = avkved7;
	}

	public String getAvkved8() {
		if (avkved8 != null) { // from UI
			return avkved8;
		} else {
			if (avkved != null && avkved.length() > 15) { // from DB
				return this.avkved.substring(14, 16);
			}
		}
		return "";
	}

	public void setAvkved8(String avkved8) {
		this.avkved8 = avkved8;
	}

	public String getAvkved9() {
		if (avkved9 != null) { // from UI
			return avkved9;
		} else {
			if (avkved != null && avkved.length() > 17) { // from DB
				return this.avkved.substring(16, 18);
			}
		}
		return "";
	}

	public void setAvkved9(String avkved9) {
		this.avkved9 = avkved9;
	}

	public String getAvkved10() {
		if (avkved10 != null) { // from UI
			return avkved10;
		} else {
			if (avkved != null && avkved.length() > 19) { // from DB
				return this.avkved.substring(18, 20);
			}
		}
		return "";
	}

	public void setAvkved10(String avkved10) {
		this.avkved10 = avkved10;
	}

	public String getAvkved11() {
		if (avkved11 != null) { // from UI
			return avkved11;
		} else {
			if (avkved != null && avkved.length() > 21) { // from DB
				return this.avkved.substring(20, 22);
			}
		}
		return "";
	}

	public void setAvkved11(String avkved11) {
		this.avkved11 = avkved11;
	}

	public String getAvkved12() {
		if (avkved12 != null) { // from UI
			return avkved12;
		} else {
			if (avkved != null && avkved.length() > 23) { // from DB
				return this.avkved.substring(22, 24);
			}
		}
		return "";
	}

	public void setAvkved12(String avkved12) {
		this.avkved12 = avkved12;
	}

	public String getAvkved13() {
		if (avkved13 != null) { // from UI
			return avkved13;
		} else {
			if (avkved != null && avkved.length() > 25) { // from DB
				return this.avkved.substring(24, 26);
			}
		}
		return "";
	}

	public void setAvkved13(String avkved13) {
		this.avkved13 = avkved13;
	}

	public String getAvkved14() {
		if (avkved14 != null) { // from UI
			return avkved14;
		} else {
			if (avkved != null && avkved.length() > 27) { // from DB
				return this.avkved.substring(26, 28);
			}
		}
		return "";
	}

	public void setAvkved14(String avkved14) {
		this.avkved14 = avkved14;
	}

	public String getAvkved15() {
		if (avkved15 != null) { // from UI
			return avkved15;
		} else {
			if (avkved != null && avkved.length() > 29) { // from DB
				return this.avkved.substring(28, 30);
			}
		}
		return "";
	}

	public void setAvkved15(String avkved15) {
		this.avkved15 = avkved15;
	}

	public String getAvkved16() {
		if (avkved16 != null) { // from UI
			return avkved16;
		} else {
			if (avkved != null && avkved.length() > 31) { // from DB
				return this.avkved.substring(30, 32);
			}
		}
		return "";
	}

	public void setAvkved16(String avkved16) {
		this.avkved16 = avkved16;
	}

	public String getAvkved17() {
		if (avkved17 != null) { // from UI
			return avkved17;
		} else {
			if (avkved != null && avkved.length() > 33) { // from DB
				return this.avkved.substring(32, 34);
			}
		}
		return "";
	}

	public void setAvkved17(String avkved17) {
		this.avkved17 = avkved17;
	}

	public String getAvkved18() {
		if (avkved18 != null) { // from UI
			return avkved18;
		} else {
			if (avkved != null && avkved.length() > 35) { // from DB
				return this.avkved.substring(34, 36);
			}
		}
		return "";
	}

	public void setAvkved18(String avkved18) {
		this.avkved18 = avkved18;
	}

	public String getAvkved19() {
		if (avkved19 != null) { // from UI
			return avkved19;
		} else {
			if (avkved != null && avkved.length() > 37) { // from DB
				return this.avkved.substring(36, 38);
			}
		}
		return "";
	}

	public void setAvkved19(String avkved19) {
		this.avkved19 = avkved19;
	}

	public String getAvkved20() {
		if (avkved20 != null) { // from UI
			return avkved20;
		} else {
			if (avkved != null && avkved.length() > 39) { // from DB
				return this.avkved.substring(38, 40);
			}
		}
		return "";
	}

	public void setAvkved20(String avkved20) {
		this.avkved20 = avkved20;
	}

	public String getAvkved21() {
		if (avkved21 != null) { // from UI
			return avkved21;
		} else {
			if (avkved != null && avkved.length() > 41) { // from DB
				return this.avkved.substring(40, 42);
			}
		}
		return "";
	}

	public void setAvkved21(String avkved21) {
		this.avkved21 = avkved21;
	}

	public String getAvkved22() {
		if (avkved22 != null) { // from UI
			return avkved22;
		} else {
			if (avkved != null && avkved.length() > 43) { // from DB
				return this.avkved.substring(42, 44);
			}
		}
		return "";
	}

	public void setAvkved22(String avkved22) {
		this.avkved22 = avkved22;
	}

	public String getAvkved23() {
		if (avkved23 != null) { // from UI
			return avkved23;
		} else {
			if (avkved != null && avkved.length() > 45) { // from DB
				return this.avkved.substring(44, 46);
			}
		}
		return "";
	}

	public void setAvkved23(String avkved23) {
		this.avkved23 = avkved23;
	}

	public String getAvkved24() {
		if (avkved24 != null) { // from UI
			return avkved24;
		} else {
			if (avkved != null && avkved.length() > 47) { // from DB
				return this.avkved.substring(46, 48);
			}
		}
		return "";
	}

	public void setAvkved24(String avkved24) {
		this.avkved24 = avkved24;
	}

	public String getAvkved25() {
		if (avkved25 != null) { // from UI
			return avkved25;
		} else {
			if (avkved != null && avkved.length() > 49) { // from DB
				return this.avkved.substring(48, 50);
			}
		}
		return "";
	}

	public void setAvkved25(String avkved25) {
		this.avkved25 = avkved25;
	}

	public String getAvkved26() {
		if (avkved26 != null) { // from UI
			return avkved26;
		} else {
			if (avkved != null && avkved.length() > 51) { // from DB
				return this.avkved.substring(50, 52);
			}
		}
		return "";
	}

	public void setAvkved26(String avkved26) {
		this.avkved26 = avkved26;
	}

	public String getAvkved27() {
		if (avkved27 != null) { // from UI
			return avkved27;
		} else {
			if (avkved != null && avkved.length() > 53) { // from DB
				return this.avkved.substring(52, 54);
			}
		}
		return "";
	}

	public void setAvkved27(String avkved27) {
		this.avkved27 = avkved27;
	}

	public String getAvkved28() {
		if (avkved28 != null) { // from UI
			return avkved28;
		} else {
			if (avkved != null && avkved.length() > 55) { // from DB
				return this.avkved.substring(54, 56);
			}
		}
		return "";
	}

	public void setAvkved28(String avkved28) {
		this.avkved28 = avkved28;
	}

	public String getAvkved29() {
		if (avkved29 != null) { // from UI
			return avkved29;
		} else {
			if (avkved != null && avkved.length() > 57) { // from DB
				return this.avkved.substring(56, 58);
			}
		}
		return "";
	}

	public void setAvkved29(String avkved29) {
		this.avkved29 = avkved29;
	}

	public String getAvkved30() {
		if (avkved30 != null) { // from UI
			return avkved30;
		} else {
			if (avkved != null && avkved.length() > 59) { // from DB
				return this.avkved.substring(58, 60);
			}
		}
		return "";
	}

	public void setAvkved30(String avkved30) {
		this.avkved30 = avkved30;
	}

	public List<Field> getFields() throws Exception {
		Class cl = Class.forName(this.getClass().getCanonicalName());
		Field[] fields = cl.getDeclaredFields();
		List<Field> list = Arrays.asList(fields);

		return list;
	}


	private String leftPad(String toPad) {
		return StringUtils.leftPad(toPad.trim(), 4, "0");
	}

	private String cleanZeros(String toClean) {
		if (StringUtils.startsWith(toClean, "0000")) {
			return "";
		} else if (StringUtils.startsWith(toClean, "000")) {
			return toClean.substring(3);
		} else if (StringUtils.startsWith(toClean, "00")) {
			return toClean.substring(2);
		} else if (StringUtils.startsWith(toClean, "0")) {
			return toClean.substring(1);
		} else {
			return toClean;
		}
	}
	
	

}
