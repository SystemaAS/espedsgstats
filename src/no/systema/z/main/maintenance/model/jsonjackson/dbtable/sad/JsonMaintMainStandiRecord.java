package no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import no.systema.main.model.jsonjackson.general.JsonAbstractGrandFatherRecord;

/**
 * All variables must be initialized to empty strings and NOT to NULL values
 * This is because the db-inserts that will be done in all fields of the db-table
 * 
 * @author oscardelatorre
 * @date Aug 25, 2016
 * 
 */
public class JsonMaintMainStandiRecord extends JsonAbstractGrandFatherRecord {
	
	private String sist = null;                             
	public void setSist (String value){ this.sist = value;   }   
	public String getSist (){ return this.sist;   }  
	
	private String siavd = null;                                
	public void setSiavd (String value){ this.siavd = value;   }   
	public String getSiavd (){ return this.siavd;   }  
	
	private String koanvn = null;                                
	public void setKoanvn (String value){ this.koanvn = value;   }   
	public String getKoanvn (){ return this.koanvn;   }  
	
	private String koaknr = null;                                
	public void setKoaknr (String value){ this.koaknr = value;   }   
	public String getKoaknr (){ return this.koaknr;   }  
	
	private String syrg = null;                                
	public void setSyrg (String value){ this.syrg = value;   }   
	public String getSyrg (){ return this.syrg;   }  
	
	private String sitdn = null;                                
	public void setSitdn (String value){ this.sitdn = value;   }   
	public String getSitdn (){ return this.sitdn;   }  
	
	private String sidty = null;                                
	public void setSidty (String value){ this.sidty = value;   }   
	public String getSidty (){ return this.sidty;   }  
	
	private String sidp = null;                                
	public void setSidp (String value){ this.sidp = value;   }   
	public String getSidp (){ return this.sidp;   }  
	
	private String sikns = null;                                
	public void setSikns (String value){ this.sikns = value;   }   
	public String getSikns (){ return this.sikns;   }  
	
	private String sinas = null;                                
	public void setSinas (String value){ this.sinas = value;   }   
	public String getSinas (){ return this.sinas;   }  
	
	private String siads1 = null;                                
	public void setSiads1 (String value){ this.siads1 = value;   }   
	public String getSiads1 (){ return this.siads1;   }  
	
	private String siads2 = null;                                
	public void setSiads2 (String value){ this.siads2 = value;   }   
	public String getSiads2 (){ return this.siads2;   }  
	
	private String siads3 = null;                                
	public void setSiads3 (String value){ this.siads3 = value;   }   
	public String getSiads3 (){ return this.siads3;   }  
	
	private String sintk = null;                                
	public void setSintk (String value){ this.sintk = value;   }   
	public String getSintk (){ return this.sintk;   }  
	
	private String siski = null;                                
	public void setSiski (String value){ this.siski = value;   }   
	public String getSiski (){ return this.siski;   }  
	
	private String sikddk = null;                                
	public String getSikddkPropertyName (){ return "sikddk"; }
	public void setSikddk (String value){ this.sikddk = value;   }   
	public String getSikddk (){ return this.sikddk;   }  
	
	private String sivkb = null;                                
	public void setSivkb (String value){ this.sivkb = value;   }   
	public String getSivkb (){ return this.sivkb;   }  
	
	private String sikdc = null;                                
	public void setSikdc (String value){ this.sikdc = value;   }   
	public String getSikdc (){ return this.sikdc;   }  
	
	private String sisg = null;                                
	public void setSisg (String value){ this.sisg = value;   }   
	public String getSisg (){ return this.sisg;   }  
	
	private String siknk = null;                                
	public void setSiknk (String value){ this.siknk = value;   }   
	public String getSiknk (){ return this.siknk;   }  
	
	private String sirg = null;                                
	public void setSirg (String value){ this.sirg = value;   }   
	public String getSirg (){ return this.sirg;   }  
	
	private String sinak = null;                                
	public void setSinak (String value){ this.sinak = value;   }   
	public String getSinak (){ return this.sinak;   }  
	
	private String siadk1 = null;                                
	public void setSiadk1 (String value){ this.siadk1 = value;   }   
	public String getSiadk1 (){ return this.siadk1;   }  
	
	private String siadk2 = null;                                
	public void setSiadk2 (String value){ this.siadk2 = value;   }   
	public String getSiadk2 (){ return this.siadk2;   }  
	
	private String siadk3 = null;                                
	public void setSiadk3 (String value){ this.siadk3 = value;   }   
	public String getSiadk3 (){ return this.siadk3;   }  
	
	private String sival1 = null;                                
	public void setSival1 (String value){ this.sival1 = value;   }   
	public String getSival1 (){ return this.sival1;   }  
	
	private String sibel1 = null;                                
	public void setSibel1 (String value){ this.sibel1 = value;   }   
	public String getSibel1 (){ return this.sibel1;   }  
	
	private String sibel1NO = null;                                
	public void setSibel1NO (String value){ this.sibel1NO = value;   }   
	public String getSibel1NO (){
		if(this.sibel1!=null && !"".equals(this.sibel1)){
			this.sibel1NO = this.numberFormatter.getFormattedEU(this.sibel1);
		}
		return this.sibel1NO;  
	}  
	
	
	private String sival2 = null;                                
	public void setSival2 (String value){ this.sival2 = value;   }   
	public String getSival2 (){ return this.sival2;   }  
	
	private String sibel2 = null;                                
	public void setSibel2 (String value){ this.sibel2 = value;   }   
	public String getSibel2 (){ return this.sibel2;   }  
	
	private String sibel2NO = null;                                
	public void setSibel2NO (String value){ this.sibel2NO = value;   }   
	public String getSibel2NO (){
		if(this.sibel2!=null && !"".equals(this.sibel2)){
			this.sibel2NO = this.numberFormatter.getFormattedEU(this.sibel2);
		}
		return this.sibel2NO;  
	}  
	
	private String siftg2 = null;                                
	public void setSiftg2 (String value){ this.siftg2 = value;   }   
	public String getSiftg2 (){ return this.siftg2;   }  
	
	private String silka = null;                                
	public void setSilka (String value){ this.silka = value;   }   
	public String getSilka (){ return this.silka;   }  
	
	private String sitlf = null;                                
	public void setSitlf (String value){ this.sitlf = value;   }   
	public String getSitlf (){ return this.sitlf;   }  
	
	private String sinad = null;                                
	public void setSinad (String value){ this.sinad = value;   }   
	public String getSinad (){ return this.sinad;   }  
	
	private String silv = null;                                
	public void setSilv (String value){ this.silv = value;   }   
	public String getSilv (){ return this.silv;   }  
	
	private String silvt = null;                                
	public String getSilvtPropertyName (){ return "silvt"; }
	public void setSilvt (String value){ this.silvt = value;   }   
	public String getSilvt (){ return this.silvt;   }  
	
	private String sitrid = null;                                
	public void setSitrid (String value){ this.sitrid = value;   }   
	public String getSitrid (){ return this.sitrid;   }  
	
	private String silkt = null;                                
	public void setSilkt (String value){ this.silkt = value;   }   
	public String getSilkt (){ return this.silkt;   }  
	
	private String sival3 = null;                                
	public void setSival3 (String value){ this.sival3 = value;   }   
	public String getSival3 (){ return this.sival3;   }  
	
	private String sibel3 = null;                                
	public String getSibel3PropertyName (){ return "sibel3"; }
	public void setSibel3 (String value){ this.sibel3 = value;   }   
	public String getSibel3 (){ return this.sibel3;   }  
	
	
	private String sibel3NO = null;                                
	public void setSibel3NO (String value){ this.sibel3NO = value;   }   
	public String getSibel3NO (){
		if(this.sibel3!=null && !"".equals(this.sibel3)){
			this.sibel3NO = this.numberFormatter.getFormattedEU(this.sibel3);
		}
		return this.sibel3NO;  
	}  
	
	private String sivku = null;                                
	public void setSivku (String value){ this.sivku = value;   }   
	public String getSivku (){ return this.sivku;   }  
	
	private String sivkuNO = null;                                
	public void setSivkuNO (String value){ this.sivkuNO = value;   }   
	public String getSivkuNO (){
		if(this.sivku!=null && !"".equals(this.sivku)){
			this.sivkuNO = this.numberFormatter.getFormattedEU(this.sivku);
		}
		return this.sivkuNO;  
	}  
	
	private String sitst = null;                                
	public void setSitst (String value){ this.sitst = value;   }   
	public String getSitst (){ return this.sitst;   }  
	
	private String sitrt = null;                                
	public void setSitrt (String value){ this.sitrt = value;   }   
	public String getSitrt (){ return this.sitrt;   }  
	
	private String sitrm = null;                                
	public void setSitrm (String value){ this.sitrm = value;   }   
	public String getSitrm (){ return this.sitrm;   }  
	
	private String sifif = null;                                
	public void setSifif (String value){ this.sifif = value;   }   
	public String getSifif (){ return this.sifif;   }  
	
	private String sifid = null;                                
	public void setSifid (String value){ this.sifid = value;   }   
	public String getSifid (){ return this.sifid;   }  
	
	private String sibelt = null;                                
	public void setSibelt (String value){ this.sibelt = value;   }   
	public String getSibelt (){ return this.sibelt;   }  
	
	private String si07 = null;                                
	public void setSi07 (String value){ this.si07 = value;   }   
	public String getSi07 (){ return this.si07;   }  
	
	
	private String sikta = null;                                
	public void setSikta (String value){ this.sikta = value;   }   
	public String getSikta (){ return this.sikta;   }  
	
	private String siktb = null;                                
	public void setSiktb (String value){ this.siktb = value;   }   
	public String getSiktb (){ return this.siktb;   }  
	
	private String sign = null;                                
	public void setSign (String value){ this.sign = value;   }   
	public String getSign (){ return this.sign;   }  
	
	private String sift1 = null;                                
	public String getSift1PropertyName (){ return "sift1"; }
	public void setSift1 (String value){ this.sift1 = value;   }   
	public String getSift1 (){ return this.sift1;   }  
	
	private String sift2 = null;                                
	public void setSift2 (String value){ this.sift2 = value;   }   
	public String getSift2 (){ return this.sift2;   }  
	
	private String sift3 = null;                                
	public void setSift3 (String value){ this.sift3 = value;   }   
	public String getSift3 (){ return this.sift3;   }  
	
	private String sift4 = null;                                
	public void setSift4 (String value){ this.sift4 = value;   }   
	public String getSift4 (){ return this.sift4;   }  
	
	private String sidst = null;                                
	public void setSidst (String value){ this.sidst = value;   }   
	public String getSidst (){ return this.sidst;   }  
	
	private String sibel4 = null;                                
	public void setSibel4 (String value){ this.sibel4 = value;   }   
	public String getSibel4 (){ return this.sibel4;   }  
	
	private String sidtg = null;                                
	public void setSidtg (String value){ this.sidtg = value;   }   
	public String getSidtg (){ return this.sidtg;   }  
	
	private String sitll = null;                                
	public void setSitll (String value){ this.sitll = value;   }   
	public String getSitll (){ return this.sitll;   }  
	
	private String sitle = null;                                
	public void setSitle (String value){ this.sitle = value;   }   
	public String getSitle (){ return this.sitle;   }  
	
	private String sils = null;                                
	public void setSils (String value){ this.sils = value;   }   
	public String getSils (){ return this.sils;   }  
	
	
	private String sikdls = null;                                
	public void setSikdls (String value){ this.sikdls = value;   }   
	public String getSikdls (){ return this.sikdls;   }  
	
	private String sikdh = null;                                
	public void setSikdh (String value){ this.sikdh = value;   }   
	public String getSikdh (){ return this.sikdh;   }  
	
	private String sikdtr = null;                                
	public void setSikdtr (String value){ this.sikdtr = value;   }   
	public String getSikdtr (){ return this.sikdtr;   }  
	
	private String sias = null;                                
	public void setSias (String value){ this.sias = value;   }   
	public String getSias (){ return this.sias;   }  
	
	private String sidt = null;                                
	public void setSidt (String value){ this.sidt = value;   }   
	public String getSidt (){ return this.sidt;   }  
	
	
	private String sidtNO = null; 
	public void setSidtNO (String value){ this.sidtNO = value;   }   
	public String getSidtNO() {
		if (sidtNO != null) { // from UI
			return sidtNO;
		} else { 				// from DB
			return this.dateFormatter.convertToDate_NO(this.sidt);
		}
	}
	
	
	private String sibel5 = null;                                
	public void setSibel5 (String value){ this.sibel5 = value;   }   
	public String getSibel5 (){ return this.sibel5;   }  
	
	private String sibel6 = null;                                
	public void setSibel6 (String value){ this.sibel6 = value;   }   
	public String getSibel6 (){ return this.sibel6;   }  
	
	private String sibel7 = null;                                
	public void setSibel7 (String value){ this.sibel7 = value;   }   
	public String getSibel7 (){ return this.sibel7;   }  
	
	private String sibel8 = null;                                
	public void setSibel8 (String value){ this.sibel8 = value;   }   
	public String getSibel8 (){ return this.sibel8;   }  
	
	private String sibel9 = null;                                
	public void setSibel9 (String value){ this.sibel9 = value;   }   
	public String getSibel9 (){ return this.sibel9;   }  
	
	private String sibela = null;                                
	public void setSibela (String value){ this.sibela = value;   }   
	public String getSibela (){ return this.sibela;   }  
	
	
	private String sibel8a = null;                                
	public void setSibel8a (String value){ this.sibel8a = value;   }   
	public String getSibel8a (){ return this.sibel8a;   }  
	
	private String silv2 = null;                                
	public void setSilv2 (String value){ this.silv2 = value;   }   
	public String getSilv2 (){ return this.silv2;   }  
	
	private String sipos = null;                                
	public void setSipos (String value){ this.sipos = value;   }   
	public String getSipos (){ return this.sipos;   }  
	
	private String sitarf = null;                                
	public void setSitarf (String value){ this.sitarf = value;   }   
	public String getSitarf (){ return this.sitarf;   }  
	
	private String sivalb = null;                                
	public void setSivalb (String value){ this.sivalb = value;   }   
	public String getSivalb (){ return this.sivalb;   }  
	
	private String sibelb = null;                                
	public void setSibelb (String value){ this.sibelb = value;   }   
	public String getSibelb (){ return this.sibelb;   }  
	
	private String simid = null;                                
	public void setSimid (String value){ this.simid = value;   }   
	public String getSimid (){ return this.simid;   }  
	
	private String simdk = null;                                
	public void setSimdk (String value){ this.simdk = value;   }   
	public String getSimdk (){ return this.simdk;   }  
	
	private String simf = null;                                
	public void setSimf (String value){ this.simf = value;   }   
	public String getSimf (){ return this.simf;   }  
	
	
	private String simp = null;                                
	public void setSimp (String value){ this.simp = value;   }   
	public String getSimp (){ return this.simp;   }  
	
	private String sidto = null;                                
	public void setSidto (String value){ this.sidto = value;   }   
	public String getSidto (){ return this.sidto;   }  
	
	private String simi = null;                                
	public void setSimi (String value){ this.simi = value;   }   
	public String getSimi (){ return this.simi;   }  
	
	private String sibeld = null;                                
	public void setSibeld (String value){ this.sibeld = value;   }   
	public String getSibeld (){ return this.sibeld;   }  
	
	private String sipkl = null;                                
	public void setSipkl (String value){ this.sipkl = value;   }   
	public String getSipkl (){ return this.sipkl;   }  
	
	private String sikdv = null;                                
	public void setSikdv (String value){ this.sikdv = value;   }   
	public String getSikdv (){ return this.sikdv;   }  
	
	private String si28 = null;                                
	public void setSi28 (String value){ this.si28 = value;   }   
	public String getSi28 (){ return this.si28;   }  
	
	private String siopd = null;                                
	public void setSiopd (String value){ this.siopd = value;   }   
	public String getSiopd (){ return this.siopd;   }  
	
	private String sifrbn = null;                                
	public void setSifrbn (String value){ this.sifrbn = value;   }   
	public String getSifrbn (){ return this.sifrbn;   }  
	
	private String siws = null;                                
	public void setSiws (String value){ this.siws = value;   }   
	public String getSiws (){ return this.siws;   }  
	
	private String sivalr = null;                                
	public void setSivalr (String value){ this.sivalr = value;   }   
	public String getSivalr (){ return this.sivalr;   }  
	
	private String sibelr = null;                                
	public void setSibelr (String value){ this.sibelr = value;   }   
	public String getSibelr (){ return this.sibelr;   }  
	
	private String sidl = null;                                
	public void setSidl (String value){ this.sidl = value;   }   
	public String getSidl (){ return this.sidl;   }  
	
	private String sitolk = null;                                
	public void setSitolk (String value){ this.sitolk = value;   }   
	public String getSitolk (){ return this.sitolk;   }  
	
	private String sidlk = null;                                
	public void setSidlk (String value){ this.sidlk = value;   }   
	public String getSidlk (){ return this.sidlk;   }  
	
	private String s0004 = null;                                
	public void setS0004 (String value){ this.s0004 = value;   }   
	public String getS0004 (){ return this.s0004;   }  
	
	private String s0010 = null;                                
	public void setS0010 (String value){ this.s0010 = value;   }   
	public String getS0010 (){ return this.s0010;   }  
	
	private String s0035 = null;                                
	public void setS0035 (String value){ this.s0035 = value;   }   
	public String getS0035 (){ return this.s0035;   }  
	
	private String s3039d = null;                                
	public void setS3039d (String value){ this.s3039d = value;   }   
	public String getS3039d (){ return this.s3039d;   }  
	
	private String s3039e = null;                                
	public void setS3039e (String value){ this.s3039e = value;   }   
	public String getS3039e (){ return this.s3039e;   }  
	
	private String s3039eo1 = null;                                
	public void setS3039eo1 (String value){ this.s3039eo1 = value;   }   
	public String getS3039eo1 (){ return this.s3039eo1;   }  
	
	private String s3039eo2 = null;                                
	public void setS3039eo2 (String value){ this.s3039eo2 = value;   }   
	public String getS3039eo2 (){ return this.s3039eo2;   }  
	
	private String sia4 = null;                                
	public void setSia4 (String value){ this.sia4 = value;   }   
	public String getSia4 (){ return this.sia4;   }  
	
	private String s0026 = null;                                
	public void setS0026 (String value){ this.s0026 = value;   }   
	public String getS0026 (){ return this.s0026;   }  
	
	private String siktc = null;                                
	public void setSiktc (String value){ this.siktc = value;   }   
	public String getSiktc (){ return this.siktc;   }  
	
	private String siekst = null;                                
	public void setSiekst (String value){ this.siekst = value;   }   
	public String getSiekst (){ return this.siekst;   }  
	
	//Rabatt (other table)
	private String sirab = null; 
	public void setSirab (String value){ this.sirab = value;   }   
	public String getSirab (){ return this.sirab;   }              
    
	
	//DUP
	private String kodus1 = null; 
	public void setKodus1 (String value){ this.kodus1 = value;   }   
	public String getKodus1 (){ return this.kodus1;   }              
    
	private String kodus2 = null; 
	public void setKodus2 (String value){ this.kodus2 = value;   }   
	public String getKodus2 (){ return this.kodus2;   }              
    
	private String kodus3 = null; 
	public void setKodus3 (String value){ this.kodus3 = value;   }   
	public String getKodus3 (){ return this.kodus3;   }              
    
	private String kodus4 = null; 
	public void setKodus4 (String value){ this.kodus4 = value;   }   
	public String getKodus4 (){ return this.kodus4;   }              
    
	private String kodus5 = null; 
	public void setKodus5 (String value){ this.kodus5 = value;   }   
	public String getKodus5 (){ return this.kodus5;   }              
    
	private String kodus6 = null; 
	public void setKodus6 (String value){ this.kodus6 = value;   }   
	public String getKodus6 (){ return this.kodus6;   }              
    
	public boolean dup = false;
	public void setDup (boolean value){ this.dup = value;   }
	public boolean isDup(){
		if(this.koanvn!=null && !"".equals(koanvn)){ 
			if(this.koanvn.toUpperCase().contains("DUP")){
				dup = true;
			}
		}
		return this.dup;
	}
	    
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Field> getFields() throws Exception{
		Class cl = Class.forName(this.getClass().getCanonicalName());
		Field[] fields = cl.getDeclaredFields();
		List<Field> list = Arrays.asList(fields);
		
		return list;
	}
	
}
