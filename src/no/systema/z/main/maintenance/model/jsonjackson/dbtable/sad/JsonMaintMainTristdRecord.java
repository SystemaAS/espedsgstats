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
 * @date Sep 20, 2016
 * 
 */
public class JsonMaintMainTristdRecord extends JsonAbstractGrandFatherRecord {
	
	private String tist = null;                             
	public void setTist (String value){ this.tist = value;   }   
	public String getTist (){ return this.tist;   }  
	
	private String tiavd = null;                                
	public void setTiavd (String value){ this.tiavd = value;   }   
	public String getTiavd (){ return this.tiavd;   }  
	
	private String koanvn = null;                                
	public void setKoanvn (String value){ this.koanvn = value;   }   
	public String getKoanvn (){ return this.koanvn;   }  
	
	private String koaknr = null;                                
	public void setKoaknr (String value){ this.koaknr = value;   }   
	public String getKoaknr (){ return this.koaknr;   }  
	
	private String syrg = null;                                
	public void setSyrg (String value){ this.syrg = value;   }   
	public String getSyrg (){ return this.syrg;   }  
	
	private String titdn = null;                                
	public void setTitdn (String value){ this.titdn = value;   }   
	public String getTitdn (){ return this.titdn;   }  
	
	private String tisg = null;                                
	public void setTisg (String value){ this.tisg = value;   }   
	public String getTisg (){ return this.tisg;   }  
	
	private String tidt = null;                                
	public void setTidt (String value){ this.tidt = value;   }   
	public String getTidt (){ return this.tidt;   }  
	
	private String tidtNO = null; 
	public void setTidtNO (String value){ this.tidtNO = value;   }   
	public String getTidtNO() {
		if (tidtNO != null) { // from UI
			return tidtNO;
		} else { 				// from DB
			return this.dateFormatter.convertToDate_NO(this.tidt);
		}
	}
	private String tienkl = null;                                
	public void setTienkl (String value){ this.tienkl = value;   }   
	public String getTienkl (){ return this.tienkl;   }  
	
	private String titrnr = null;                                
	public void setTitrnr (String value){ this.titrnr = value;   }   
	public String getTitrnr (){ return this.titrnr;   }  
	
	private String tign = null;                                
	public void setTign (String value){ this.tign = value;   }   
	public String getTign (){ return this.tign;   }  
	
	private String tignsk = null;                                
	public void setTignsk (String value){ this.tignsk = value;   }   
	public String getTignsk (){ return this.tignsk;   }  
	
	private String tialsk = null;                                
	public void setTialsk (String value){ this.tialsk = value;   }   
	public String getTialsk (){ return this.tialsk;   }  
	
	private String tials = null;                                
	public void setTials (String value){ this.tials = value;   }   
	public String getTials (){ return this.tials;   }  
	
	
	private String tialss = null;                                
	public void setTialss (String value){ this.tialss = value;   }   
	public String getTialss (){ return this.tialss;   }  
	
	private String tiglsk = null;                                
	public void setTiglsk (String value){ this.tiglsk = value;   }   
	public String getTiglsk (){ return this.tiglsk;   }  
	
	private String tiacts = null;                                
	public String getTiactsPropertyName (){ return "tiacts"; }
	public void setTiacts (String value){ this.tiacts = value;   }   
	public String getTiacts (){ return this.tiacts;   }  
	
	private String tiskb = null;                                
	public void setTiskb (String value){ this.tiskb = value;   }   
	public String getTiskb (){ return this.tiskb;   }  
	
	private String titsb = null;     
	public void setTitsb (String value){ this.titsb = value;   }   
	public String gettitsb (){ return this.titsb;   }  
	
	private String titarf = null;                                
	public void setTitarf (String value){ this.titarf = value;   }   
	public String getTitarf (){ return this.titarf;   }  
	
	private String tiws = null;                                
	public void setTiws (String value){ this.tiws = value;   }   
	public String getTiws (){ return this.tiws;   }  
	
	private String tikn = null;                                
	public void setTikn (String value){ this.tikn = value;   }   
	public String getTikn (){ return this.tikn;   }  
	
	private String tina = null;                                
	public void setTina (String value){ this.tina = value;   }   
	public String getTina (){ return this.tina;   }  
		
	private String tiad1 = null;                                
	public void setTiad1 (String value){ this.tiad1 = value;   }   
	public String getTiad1 (){ return this.tiad1;   }  
	
	private String tipn = null;                                
	public void setTipn (String value){ this.tipn = value;   }   
	public String getTipn (){ return this.tipn;   }  
	
	private String tips = null;                                
	public void setTips (String value){ this.tips = value;   }   
	public String getTips (){ return this.tips;   }  
	
	private String tilk = null;                                
	public void setTilk (String value){ this.tilk = value;   }   
	public String getTilk (){ return this.tilk;   }  
	
	private String tisk = null;                                
	public void setTisk (String value){ this.tisk = value;   }   
	public String getTisk (){ return this.tisk;   }  
	
	private String titin = null;                                
	public void setTitin (String value){ this.titin = value;   }   
	public String getTitin (){ return this.titin;   }  
	
	private String s0004 = null;                                
	public void setS0004 (String value){ this.s0004 = value;   }   
	public String getS0004 (){ return this.s0004;   }  
	
	private String s0010 = null;                                
	public void setS0010 (String value){ this.s0010 = value;   }   
	public String getS0010 (){ return this.s0010;   }  
	
	private String s0035 = null;                                
	public void setS0035 (String value){ this.s0035 = value;   }   
	public String getS0035 (){ return this.s0035;   }  
	
	private String s0026 = null;                                
	public void setS0026 (String value){ this.s0026 = value;   }   
	public String getS0026 (){ return this.s0026;   }  
	
	private String tidk = null;                                
	public void setTidk (String value){ this.tidk = value;   }   
	public String getTidk (){ return this.tidk;   }  
	
	private String tialk = null;                                
	public void setTialk (String value){ this.tialk = value;   }   
	public String getTialk (){ return this.tialk;   }  
	
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
