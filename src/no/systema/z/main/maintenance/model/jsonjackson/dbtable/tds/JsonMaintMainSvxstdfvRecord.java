package no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds;
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
 * @date Jun 21, 2017
 * 
 */
public class JsonMaintMainSvxstdfvRecord extends JsonAbstractGrandFatherRecord  {
	private NumberFormatterLocaleAware numberFormatter = new NumberFormatterLocaleAware();
	
	private String thavd = "";                                
	public String getThavdPropertyName (){ return "thavd"; }
	public void setThavd (String value){ this.thavd = value;   }   
	public String getThavd (){ return this.thavd;   }  
	
	
	//Säkerhet
	private String thsik = "";                                
	public String getThsikPropertyName (){ return "thsik"; }
	public void setThsik (String value){ this.thsik = value;   }   
	public String getThsik (){ return this.thsik;   }  
	
	private String thdta = "";                                
	public String getThdtaPropertyName (){ return "thdta"; }
	public void setThdta (String value){ this.thdta = value;   }   
	public String getThdta (){ return this.thdta;   }  
	
	private String thdtaNO = null; 
	public void setThdtaNO (String value){ this.thdtaNO = value;   }   
	public String getThdtaNO() {
		if (thdtaNO != null) { // from UI
			return thdtaNO;
		} else { 				// from DB
			return this.dateFormatter.convertToDate_NO(this.thdta);
		}
	}
	private String thtma = "";                                
	public String getThtmaPropertyName (){ return "thtma"; }
	public void setThtma (String value){ this.thtma = value;   }   
	public String getThtma (){ return this.thtma;   }  
	
	private String thspom= "";                                
	public String getThspomPropertyName (){ return "thspom"; }
	public void setThspom (String value){ this.thspom = value;   }   
	public String getThspom (){ return this.thspom;   }  
	
	private String thtkbm = "";                                
	public String getThtkbmPropertyName (){ return "thtkbm"; }
	public void setThtkbm (String value){ this.thtkbm = value;   }   
	public String getThtkbm (){ return this.thtkbm;   }  
	
	private String thkref = "";                                
	public String getThkrefPropertyName (){ return "thkref"; }
	public void setThkref (String value){ this.thkref = value;   }   
	public String getThkref (){ return this.thkref;   }  
	
	private String thtref = "";                                
	public String getThtrefPropertyName (){ return "thtref"; }
	public void setThtref (String value){ this.thtref = value;   }   
	public String getThtref (){ return this.thtref;   }  
	
	private String thlosd = "";                                
	public String getThlosdPropertyName (){ return "thlosd"; }
	public void setThlosd (String value){ this.thlosd = value;   }   
	public String getThlosd (){ return this.thlosd;   }  
	
	private String thlosdsk = "";                                
	public String getThlosdskPropertyName (){ return "thlosdsk"; }
	public void setThlosdsk (String value){ this.thlosdsk = value;   }   
	public String getThlosdsk (){ return this.thlosdsk;   }  
	
	private String thlkr1 = "";                                
	public String getThlkr1PropertyName (){ return "thlkr1"; }
	public void setThlkr1 (String value){ this.thlkr1 = value;   }   
	public String getThlkr1 (){ return this.thlkr1;   }  
	
	private String thlkr2 = "";                                
	public String getThlkr2PropertyName (){ return "thlkr2"; }
	public void setThlkr2 (String value){ this.thlkr2 = value;   }   
	public String getThlkr2 (){ return this.thlkr2;   }  
	
	private String thlkr3 = "";                                
	public String getThlkr3PropertyName (){ return "thlkr3"; }
	public void setThlkr3 (String value){ this.thlkr3 = value;   }   
	public String getThlkr3 (){ return this.thlkr3;   }  
	
	private String thlkr4 = "";                                
	public String getThlkr4PropertyName (){ return "thlkr4"; }
	public void setThlkr4 (String value){ this.thlkr4 = value;   }   
	public String getThlkr4 (){ return this.thlkr4;   }  
	
	private String thlkr5 = "";                                
	public String getThlkr5PropertyName (){ return "thlkr5"; }
	public void setThlkr5 (String value){ this.thlkr5 = value;   }   
	public String getThlkr5 (){ return this.thlkr5;   }  
	
	private String thlkr6 = "";                                
	public String getThlkr6PropertyName (){ return "thlkr6"; }
	public void setThlkr6 (String value){ this.thlkr6 = value;   }   
	public String getThlkr6 (){ return this.thlkr6;   }  
	
	private String thlkr7 = "";                                
	public String getThlkr7PropertyName (){ return "thlkr7"; }
	public void setThlkr7 (String value){ this.thlkr7 = value;   }   
	public String getThlkr7 (){ return this.thlkr7;   }  
	
	private String thlkr8 = "";                                
	public String getThlkr8PropertyName (){ return "thlkr8"; }
	public void setThlkr8 (String value){ this.thlkr8 = value;   }   
	public String getThlkr8 (){ return this.thlkr8;   }  
	
	private String thknss = "";                                
	public String getThknssPropertyName (){ return "thknss"; }
	public void setThknss (String value){ this.thknss = value;   }   
	public String getThknss (){ return this.thknss;   }  
	
	private String thnass = "";                                
	public String getThnassPropertyName (){ return "thnass"; }
	public void setThnass (String value){ this.thnass = value;   }   
	public String getThnass (){ return this.thnass;   }  
	
	private String thadss1 = "";                                
	public String getThadss1PropertyName (){ return "thadss1"; }
	public void setThadss1 (String value){ this.thadss1 = value;   }   
	public String getThadss1 (){ return this.thadss1;   }  
	
	private String thpnss = "";                                
	public String getThpnssPropertyName (){ return "thpnss"; }
	public void setThpnss (String value){ this.thpnss = value;   }   
	public String getThpnss (){ return this.thpnss;   }  
	
	private String thpsss = "";                                
	public String getThpsssPropertyName (){ return "thpsss"; }
	public void setThpsss (String value){ this.thpsss = value;   }   
	public String getThpsss (){ return this.thpsss;   }  
	
	private String thlkss = "";                                
	public String getThlkssPropertyName (){ return "thlkss"; }
	public void setThlkss (String value){ this.thlkss = value;   }   
	public String getThlkss (){ return this.thlkss;   }  
	
	private String thskss = "";                                
	public String getThskssPropertyName (){ return "thskss"; }
	public void setThskss (String value){ this.thskss = value;   }   
	public String getThskss (){ return this.thskss;   }  
	
	private String thtinss = "";                                
	public String getThtinssPropertyName (){ return "thtinss"; }
	public void setThtinss (String value){ this.thtinss = value;   }   
	public String getThtinss (){ return this.thtinss;   }  
	
	private String thknks = "";                                
	public String getThknksPropertyName (){ return "thknks"; }
	public void setThknks (String value){ this.thknks = value;   }   
	public String getThknks (){ return this.thknks;   } 
	
	private String thnaks = "";                                
	public String getThnaksPropertyName (){ return "thnaks"; }
	public void setThnaks (String value){ this.thnaks = value;   }   
	public String getThnaks (){ return this.thnaks;   }  
	
	private String thadks1 = "";                                
	public String getThadks1PropertyName (){ return "thadks1"; }
	public void setThadks1 (String value){ this.thadks1 = value;   }   
	public String getThadks1 (){ return this.thadks1;   }  
	
	private String thpnks = "";                                
	public String getThpnksPropertyName (){ return "thpnks"; }
	public void setThpnks (String value){ this.thpnks = value;   }   
	public String getThpnks (){ return this.thpnks;   }  
	
	private String thpsks = "";                                
	public String getThpsksPropertyName (){ return "thpsks"; }
	public void setThpsks (String value){ this.thpsks = value;   }   
	public String getThpsks (){ return this.thpsks;   }  
	
	private String thlkks = "";                                
	public String getThlkksPropertyName (){ return "thlkks"; }
	public void setThlkks (String value){ this.thlkks = value;   }   
	public String getThlkks (){ return this.thlkks;   }  
	
	private String thskks = "";                                
	public String getThskksPropertyName (){ return "thskks"; }
	public void setThskks (String value){ this.thskks = value;   }   
	public String getThskks (){ return this.thskks;   }  
	
	private String thtinks = "";                                
	public String getThtinksPropertyName (){ return "thtinks"; }
	public void setThtinks (String value){ this.thtinks = value;   }   
	public String getThtinks (){ return this.thtinks;   }  
	
	private String thknt = "";                                
	public String getThkntPropertyName (){ return "thknt"; }
	public void setThknt (String value){ this.thknt = value;   }   
	public String getThknt (){ return this.thknt;   }  
	
	private String thnat = "";                                
	public String getThnatPropertyName (){ return "thnat"; }
	public void setThnat (String value){ this.thnat = value;   }   
	public String getThnat (){ return this.thnat;   }  
	
	private String thadt1 = "";                                
	public String getThadt1PropertyName (){ return "thadt1"; }
	public void setThadt1 (String value){ this.thadt1 = value;   }   
	public String getThadt1 (){ return this.thadt1;   }  
	
	private String thpnt = "";                                
	public String getThpntPropertyName (){ return "thpnt"; }
	public void setThpnt (String value){ this.thpnt = value;   }   
	public String getThpnt (){ return this.thpnt;   }  
	
	private String thpst = "";                                
	public String getThpstPropertyName (){ return "thpst"; }
	public void setThpst (String value){ this.thpst = value;   }   
	public String getThpst (){ return this.thpst;   }  
	
	private String thlkt = "";                                
	public String getThlktPropertyName (){ return "thlkt"; }
	public void setThlkt (String value){ this.thlkt = value;   }   
	public String getThlkt (){ return this.thlkt;   }  
	
	private String thskt = "";                                
	public String getThsktPropertyName (){ return "thskt"; }
	public void setThskt (String value){ this.thskt = value;   }   
	public String getThskt (){ return this.thskt;   }  
	
	private String thtint = "";                                
	public String getThtintPropertyName (){ return "thtint"; }
	public void setThtint (String value){ this.thtint = value;   }   
	public String getThtint (){ return this.thtint;   }  
	
	
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
