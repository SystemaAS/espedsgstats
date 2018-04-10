package no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import no.systema.main.model.jsonjackson.general.JsonAbstractGrandFatherRecord;
import no.systema.main.util.*;

/**
 * All variables must be initialized to empty strings and NOT to NULL values
 * This is because the db-inserts that will be done in all fields of the db-table
 * 
 * @author oscardelatorre
 * @date Sep 16, 2016
 * 
 */
public class JsonMaintMainStandeRecord extends JsonAbstractGrandFatherRecord  {
	private NumberFormatterLocaleAware numberFormatter = new NumberFormatterLocaleAware();
	
	private String sest = null;                             
	public void setSest (String value){ this.sest = value;   }   
	public String getSest (){ return this.sest;   }  
	
	private String seavd = null;                                
	public void setSeavd (String value){ this.seavd = value;   }   
	public String getSeavd (){ return this.seavd;   }  
	
	private String koanvn = null;                                
	public void setKoanvn (String value){ this.koanvn = value;   }   
	public String getKoanvn (){ return this.koanvn;   }  
	
	private String koaknr = null;                                
	public void setKoaknr (String value){ this.koaknr = value;   }   
	public String getKoaknr (){ return this.koaknr;   }  
	
	private String syrg = null;                                
	public void setSyrg (String value){ this.syrg = value;   }   
	public String getSyrg (){ return this.syrg;   }  
	
	private String setdn = null;                                
	public void setSetdn (String value){ this.setdn = value;   }   
	public String getSetdn (){ return this.setdn;   }  
	
	private String sedty = null;                                
	public void setSedty (String value){ this.sedty = value;   }   
	public String getSedty (){ return this.sedty;   }  
	
	private String sedp = null;                                
	public void setSedp (String value){ this.sedp = value;   }   
	public String getSedp (){ return this.sedp;   }  
	
	private String sekns = null;                                
	public void setSekns (String value){ this.sekns = value;   }   
	public String getSekns (){ return this.sekns;   }  
	
	private String senas = null;                                
	public void setSenas (String value){ this.senas = value;   }   
	public String getSenas (){ return this.senas;   }  
	
	private String seads1 = null;                                
	public void setSeads1 (String value){ this.seads1 = value;   }   
	public String getSeads1 (){ return this.seads1;   }  
	
	private String seads2 = null;                                
	public void setSeads2 (String value){ this.seads2 = value;   }   
	public String getSeads2 (){ return this.seads2;   }  
	
	private String seads3 = null;                                
	public void setSeads3 (String value){ this.seads3 = value;   }   
	public String getSeads3 (){ return this.seads3;   }  
	
	private String sentk = null;                                
	public void setSentk (String value){ this.sentk = value;   }   
	public String getSentk (){ return this.sentk;   }  
	
	
	private String sevkb = null;                                
	public void setSevkb (String value){ this.sevkb = value;   }   
	public String getSevkb (){ return this.sevkb;   }  
	
	private String sekdc = null;                                
	public void setSekdc (String value){ this.sekdc = value;   }   
	public String getSekdc (){ return this.sekdc;   }  
	
	private String sesg = null;                                
	public void setSesg (String value){ this.sesg = value;   }   
	public String getSesg (){ return this.sesg;   }  
	
	private String seknk = null;                                
	public void setSeknk (String value){ this.seknk = value;   }   
	public String getSeknk (){ return this.seknk;   }  
	
	private String serg = null;                                
	public void setSerg (String value){ this.serg = value;   }   
	public String getSerg (){ return this.serg;   }  
	
	private String senak = null;                                
	public void setSenak (String value){ this.senak = value;   }   
	public String getSenak (){ return this.senak;   }  
	
	private String seadk1 = null;                                
	public void setSeadk1 (String value){ this.seadk1 = value;   }   
	public String getSeadk1 (){ return this.seadk1;   }  
	
	private String seadk2 = null;                                
	public void setSeadk2 (String value){ this.seadk2 = value;   }   
	public String getSeadk2 (){ return this.seadk2;   }  
	
	private String seadk3 = null;                                
	public void setSeadk3 (String value){ this.seadk3 = value;   }   
	public String getSeadk3 (){ return this.seadk3;   }  
		
	private String selka = null;                                
	public void setSelka (String value){ this.selka = value;   }   
	public String getSelka (){ return this.selka;   }  
	
	private String setlf = null;                                
	public void setSetlf (String value){ this.setlf = value;   }   
	public String getSetlf (){ return this.setlf;   }  
	
	private String senad = null;                                
	public void setSenad (String value){ this.senad = value;   }   
	public String getSenad (){ return this.senad;   }  
	
	private String selv = null;                                
	public void setSelv (String value){ this.selv = value;   }   
	public String getSelv (){ return this.selv;   }  
	
	private String selvt = null;                                
	public void setSelvt (String value){ this.selvt = value;   }   
	public String getSelvt (){ return this.selvt;   }  
	
	private String setrid = null;                                
	public void setSetrid (String value){ this.setrid = value;   }   
	public String getSetrid (){ return this.setrid;   }  
	
	private String selkt = null;                                
	public void setSelkt (String value){ this.selkt = value;   }   
	public String getSelkt (){ return this.selkt;   }  
	
	private String seval1 = null;                                
	public void setSeval1 (String value){ this.seval1 = value;   }   
	public String getSeval1 (){ return this.seval1;   }  
	
	private String sebel1 = null;                                
	public void setSebel1 (String value){ this.sebel1 = value;   }   
	public String getSebel1 (){ return this.sebel1;   }  
	
	private String sebel1NO = null;                                
	public void setSebel1NO (String value){ this.sebel1NO = value;   }   
	public String getSebel1NO (){
		if(this.sebel1!=null && !"".equals(this.sebel1)){
			this.sebel1NO = this.numberFormatter.getFormattedEU(this.sebel1);
		}
		return this.sebel1NO;  
	} 
	
	private String sebel2 = null;                                
	public void setSebel2 (String value){ this.sebel2 = value;   }   
	public String getSebel2 (){ return this.sebel2;   }  
	
	private String sebel2NO = null;                                
	public void setSebel2NO (String value){ this.sebel2NO = value;   }   
	public String getSebel2NO (){
		if(this.sebel2!=null && !"".equals(this.sebel2)){
			this.sebel2NO = this.numberFormatter.getFormattedEU(this.sebel2);
		}
		return this.sebel2NO;  
	} 
	
	private String sevku = null;                                
	public void setSevku (String value){ this.sevku = value;   }   
	public String getSevku (){ return this.sevku;   }  
	
	private String sevkuNO = null;                                
	public void setSevkuNO (String value){ this.sevkuNO = value;   }   
	public String getSevkuNO (){
		if(this.sevku!=null && !"".equals(this.sevku)){
			this.sevkuNO = this.numberFormatter.getFormattedEU(this.sevku);
		}
		return this.sevkuNO;  
	}  
	
	private String sekdh = null;                                
	public void setSekdh (String value){ this.sekdh = value;   }   
	public String getSekdh (){ return this.sekdh;   }  
	
	private String setst = null;                                
	public void setSetst (String value){ this.setst = value;   }   
	public String getSetst (){ return this.setst;   }  
	
	private String setrt = null;                                
	public void setSetrt (String value){ this.setrt = value;   }   
	public String getSetrt (){ return this.setrt;   }  
	
	private String setrm = null;                                
	public void setSetrm (String value){ this.setrm = value;   }   
	public String getSetrm (){ return this.setrm;   }  
	
	private String sefif = null;                                
	public void setSefif (String value){ this.sefif = value;   }   
	public String getSefif (){ return this.sefif;   }  
	
	private String sefid = null;                                
	public void setSefid (String value){ this.sefid = value;   }   
	public String getSefid (){ return this.sefid;   }  
	
	private String sebelt = null;                                
	public void setSebelt (String value){ this.sebelt = value;   }   
	public String getSebelt (){ return this.sebelt;   }  
	
	private String sekta = null;                                
	public void setSekta (String value){ this.sekta = value;   }   
	public String getSekta (){ return this.sekta;   }  
	
	private String sektb = null;                                
	public void setSektb (String value){ this.sektb = value;   }   
	public String getSektb (){ return this.sektb;   }  
	
	private String segn = null;                                
	public void setSegn (String value){ this.segn = value;   }   
	public String getSegn (){ return this.segn;   }  
	
	private String seft1 = null;                                
	public void setSeft1 (String value){ this.seft1 = value;   }   
	public String getSeft1 (){ return this.seft1;   }  
	
	private String seft2 = null;                                
	public void setSeft2 (String value){ this.seft2 = value;   }   
	public String getSeft2 (){ return this.seft2;   }  
	
	private String seft3 = null;                                
	public void setSeft3 (String value){ this.seft3 = value;   }   
	public String getSeft3 (){ return this.seft3;   }  
	
	private String sedst = null;                                
	public void setSedst (String value){ this.sedst = value;   }   
	public String getSedst (){ return this.sedst;   }  
	
	private String sedtg = null;                                
	public void setSedtg (String value){ this.sedtg = value;   }   
	public String getSedtg (){ return this.sedtg;   }  
	
	private String setll = null;                                
	public void setSetll (String value){ this.setll = value;   }   
	public String getSetll (){ return this.setll;   }  
	
	private String setle = null;                                
	public void setSetle (String value){ this.setle = value;   }   
	public String getSetle (){ return this.setle;   }  
	
	private String seski = null;                                
	public void setSeski (String value){ this.seski = value;   }   
	public String getSeski (){ return this.seski;   }  
	
	private String sels = null;                                
	public void setSels (String value){ this.sels = value;   }   
	public String getSels (){ return this.sels;   }  
	
	
	private String sekdls = null;                                
	public void setSekdls (String value){ this.sekdls = value;   }   
	public String getSekdls (){ return this.sekdls;   }  
	
	private String sedt = null;                                
	public void setSedt (String value){ this.sedt = value;   }   
	public String getSedt (){ return this.sedt;   }  
	
	
	private String sedtNO = null; 
	public void setSedtNO (String value){ this.sedtNO = value;   }   
	public String getSedtNO() {
		if (sedtNO != null) { // from UI
			return sedtNO;
		} else { 				// from DB
			return this.dateFormatter.convertToDate_NO(this.sedt);
		}
	}
	
	
	private String selv2 = null;                                
	public void setSelv2 (String value){ this.selv2 = value;   }   
	public String getSelv2 (){ return this.selv2;   }  
	
	private String sekddk = null;                                
	public void setSekddk (String value){ this.sekddk = value;   }   
	public String getSekddk (){ return this.sekddk;   }  
	
	private String segkd = null;                                
	public void setSegkd (String value){ this.segkd = value;   }   
	public String getSegkd (){ return this.segkd;   }  
	
	
	private String segft1 = null;                                
	public void setSegft1 (String value){ this.segft1 = value;   }   
	public String getSegft1 (){ return this.segft1;   }  
	
	private String segft2 = null;                                
	public void setSegft2 (String value){ this.segft2 = value;   }   
	public String getSegft2 (){ return this.segft2;   }  
	
	private String sepos = null;                                
	public void setSepos (String value){ this.sepos = value;   }   
	public String getSepos (){ return this.sepos;   }  
	
	private String seftb = null;                                
	public void setSeftb (String value){ this.seftb = value;   }   
	public String getSeftb (){ return this.seftb;   }  
	
	private String selkb = null;                                
	public void setSelkb (String value){ this.selkb = value;   }   
	public String getSelkb (){ return this.selkb;   }  
	
	private String seftm = null;                                
	public void setSeftm (String value){ this.seftm = value;   }   
	public String getSeftm (){ return this.seftm;   }  
	
	private String selkm = null;                                
	public void setSelkm (String value){ this.selkm = value;   }   
	public String getSelkm (){ return this.selkm;   }  
	
	private String sekdft = null;                                
	public void setSekdft (String value){ this.sekdft = value;   }   
	public String getSekdft (){ return this.sekdft;   }  
	
	private String setarf = null;                                
	public void setSetarf (String value){ this.setarf = value;   }   
	public String getSetarf (){ return this.setarf;   }  
	
	
	private String selkat = null;                                
	public void setSelkat (String value){ this.selkat = value;   }   
	public String getSelkat (){ return this.selkat;   }  
	
	private String seval2 = null;                                
	public void setSeval2 (String value){ this.seval2 = value;   }   
	public String getSeval2 (){ return this.seval2;   }  
	
	private String sebel3 = null;                                
	public void setSebel3 (String value){ this.sebel3 = value;   }   
	public String getSebel3 (){ return this.sebel3;   }  
	
	private String sews = null;                                
	public void setSews (String value){ this.sews = value;   }   
	public String getSews (){ return this.sews;   }  
	
	private String sedl = null;                                
	public void setSedl (String value){ this.sedl = value;   }   
	public String getSedl (){ return this.sedl;   }  
	
	private String setolk = null;                                
	public void setSetolk (String value){ this.setolk = value;   }   
	public String getSetolk (){ return this.setolk;   }  
	
	private String sea4 = null;                                
	public void setSea4 (String value){ this.sea4 = value;   }   
	public String getSea4 (){ return this.sea4;   }  
	
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
	
	private String s0026 = null;                                
	public void setS0026 (String value){ this.s0026 = value;   }   
	public String getS0026 (){ return this.s0026;   }  
	
	private String sektc = null;                                
	public void setSektc (String value){ this.sektc = value;   }   
	public String getSektc (){ return this.sektc;   }  
	
	private String seekst = null;                                
	public void setSeekst (String value){ this.seekst = value;   }   
	public String getSeekst (){ return this.seekst;   }  
	
	
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
