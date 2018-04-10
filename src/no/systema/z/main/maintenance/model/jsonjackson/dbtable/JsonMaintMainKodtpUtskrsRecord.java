package no.systema.z.main.maintenance.model.jsonjackson.dbtable;
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
 * @date Aug 9, 2016
 * 
 */
public class JsonMaintMainKodtpUtskrsRecord extends JsonAbstractGrandFatherRecord  {
	
	//KODTP table
	private String kopuni = "P"; //always as default                               
	public void setKopuni (String value){ this.kopuni = value;   }   
	public String getKopuni (){ return this.kopuni;   }  
	
	private String kopavd = null;                                
	public void setKopavd (String value){ this.kopavd = value;   }   
	public String getKopavd (){ return this.kopavd;   }  
	
	private String koplnr = null;                                
	public void setKoplnr (String value){ this.koplnr = value;   }   
	public String getKoplnr (){ return this.koplnr;   }  
	
	private String kopnvn = null;                                
	public void setKopnvn (String value){ this.kopnvn = value;   }   
	public String getKopnvn (){ return this.kopnvn;   }  
	
	private String kopty = null;                                
	public void setKopty (String value){ this.kopty = value;   }   
	public String getKopty (){ return this.kopty;   }  
	
	private String kophea = null;                                
	public void setKophea (String value){ this.kophea = value;   }   
	public String getKophea (){ return this.kophea;   }  
	
	private String kopfm = null;                                
	public void setKopfm (String value){ this.kopfm = value;   }   
	public String getKopfm (){ return this.kopfm;   }  
	
	private String koplas = null;                                
	public void setKoplas (String value){ this.koplas = value;   }   
	public String getKoplas (){ return this.koplas;   }  
	
	private String kopcpi = null;                                
	public void setKopcpi (String value){ this.kopcpi = value;   }   
	public String getKopcpi (){ return this.kopcpi;   }  
	
	private String koplpi = null;                                
	public void setKoplpi (String value){ this.koplpi = value;   }   
	public String getKoplpi (){ return this.koplpi;   }  
	
	private String koplpp = null;                                
	public void setKoplpp (String value){ this.koplpp = value;   }   
	public String getKoplpp (){ return this.koplpp;   }  
	
	private String kopcpl = null;                                
	public void setKopcpl (String value){ this.kopcpl = value;   }   
	public String getKopcpl (){ return this.kopcpl;   }  
	
	private String kopdraw = null;                                
	public void setKopdraw (String value){ this.kopdraw = value;   }   
	public String getKopdraw (){ return this.kopdraw;   }  
	
	private String kopoutb = null;                                
	public void setKopoutb (String value){ this.kopoutb = value;   }   
	public String getKopoutb (){ return this.kopoutb;   }  
	
	private String kopfor1 = null;                                
	public void setKopfor1 (String value){ this.kopfor1 = value;   }   
	public String getKopfor1 (){ return this.kopfor1;   }  
	
	private String kopfor2 = null;                                
	public void setKopfor2 (String value){ this.kopfor2 = value;   }   
	public String getKopfor2 (){ return this.kopfor2;   }  
	
	private String kopdupl = null;                                
	public void setKopdupl (String value){ this.kopdupl = value;   }   
	public String getKopdupl (){ return this.kopdupl;   }  
	
	private String kopfov1 = null;                                
	public void setKopfov1 (String value){ this.kopfov1 = value;   }   
	public String getKopfov1 (){ return this.kopfov1;   }  
	
	private String kopfov2 = null;                                
	public void setKopfov2 (String value){ this.kopfov2 = value;   }   
	public String getKopfov2 (){ return this.kopfov2;   }  
	
	private String kopfov3 = null;                                
	public void setKopfov3 (String value){ this.kopfov3 = value;   }   
	public String getKopfov3 (){ return this.kopfov3;   }  
	
	private String kopfov4 = null;                                
	public void setKopfov4 (String value){ this.kopfov4 = value;   }   
	public String getKopfov4 (){ return this.kopfov4;   }  
	
	private String kopbov1 = null;                                
	public void setKopbov1 (String value){ this.kopbov1 = value;   }   
	public String getKopbov1 (){ return this.kopbov1;   }  
	
	private String kopbov2 = null;                        
	public void setKopbov2 (String value){ this.kopbov2 = value;   }   
	public String getKopbov2 (){ return this.kopbov2;   }  
	
	private String kopbov3 = null;                                
	public void setKopbov3 (String value){ this.kopbov3 = value;   }   
	public String getKopbov3 (){ return this.kopbov3;   }  
	
	private String kopbov4 = null; 
	public void setKopbov4 (String value){ this.kopbov4 = value;   }   
	public String getKopbov4 (){ return this.kopbov4;   }              

	private String kopbov5 = null; 
	public void setKopbov5 (String value){ this.kopbov5 = value;   }   
	public String getKopbov5 (){ return this.kopbov5;   }              

	private String kopcopi = null; 
	public void setKopcopi (String value){ this.kopcopi = value;   }   
	public String getKopcopi (){ return this.kopcopi;   }              

	private String kophold = null; 
	public void setKophold (String value){ this.kophold = value;   }   
	public String getKophold (){ return this.kophold;   }              

	private String kopsave = null; 
	public void setKopsave (String value){ this.kopsave = value;   }   
	public String getKopsave (){ return this.kopsave;   }              

	private String kopfrmp = null; 
	public void setKopfrmp (String value){ this.kopfrmp = value;   }   
	public String getKopfrmp (){ return this.kopfrmp;   }              

	private String kopbamp = null; 
	public void setKopbamp (String value){ this.kopbamp = value;   }   
	public String getKopbamp (){ return this.kopbamp;   }              

	private String kopfrmf = null; 
	public void setKopfrmf (String value){ this.kopfrmf = value;   }   
	public String getKopfrmf (){ return this.kopfrmf;   }              

	private String kopbamf = null; 
	public void setKopbamf (String value){ this.kopbamf = value;   }   
	public String getKopbamf (){ return this.kopbamf;   }              

	//UTSKRS table
	private String utptxt = null;                           
	public void setUtptxt (String value){ this.utptxt = value;   }   
	public String getUtptxt (){ return this.utptxt;   }  
	
	private String utpty = null;                                
	public void setUtpty (String value){ this.utpty = value;   }   
	public String getUtpty (){ return this.utpty;   }  
	
	private String utpnr = null;                                
	public void setUtpnr (String value){ this.utpnr = value;   }   
	public String getUtpnr (){ return this.utpnr;   }  
	
	private String utpl = null;                                
	public void setUtpl (String value){ this.utpl = value;   }   
	public String getUtpl (){ return this.utpl;   }  
	
	private String utpk = null;                                
	public void setUtpk (String value){ this.utpk = value;   }   
	public String getUtpk (){ return this.utpk;   }  
	
	private String uthead = null;                                
	public void setUthead (String value){ this.uthead = value;   }   
	public String getUthead (){ return this.uthead;   }  
	
	private String utpfm = null;                                
	public void setUtpfm (String value){ this.utpfm = value;   }   
	public String getUtpfm (){ return this.utpfm;   }  
	
	private String utplas = null;                                
	public void setUtplas (String value){ this.utplas = value;   }   
	public String getUtplas (){ return this.utplas;   }  
	
	private String utpcpi = null;                                
	public void setUtpcpi (String value){ this.utpcpi = value;   }   
	public String getUtpcpi (){ return this.utpcpi;   }  
	
	private String utplpi = null;                                
	public void setUtplpi (String value){ this.utplpi = value;   }   
	public String getUtplpi (){ return this.utplpi;   }  
	
	private String utplpp = null;                                
	public void setUtplpp (String value){ this.utplpp = value;   }   
	public String getUtplpp (){ return this.utplpp;   }  
	
	private String utpcpl = null;                                
	public void setUtpcpl (String value){ this.utpcpl = value;   }   
	public String getUtpcpl (){ return this.utpcpl;   }  
	
	private String utpdraw = null;                                
	public void setUtpdraw (String value){ this.utpdraw = value;   }   
	public String getUtpdraw (){ return this.utpdraw;   }  
	
	private String utpoutb = null;                                
	public void setUtpoutb (String value){ this.utpoutb = value;   }   
	public String getUtpoutb (){ return this.utpoutb;   }  
	
	private String utpfor1 = null;                                
	public void setUtpfor1 (String value){ this.utpfor1 = value;   }   
	public String getUtpfor1 (){ return this.utpfor1;   }  
	
	private String utpfor2 = null;                                
	public void setUtpfor2 (String value){ this.utpfor2 = value;   }   
	public String getUtpfor2 (){ return this.utpfor2;   }  
	
	private String utpdupl = null;                                
	public void setUtpdupl (String value){ this.utpdupl = value;   }   
	public String getUtpdupl (){ return this.utpdupl;   }  
	
	private String utpfov1 = null;                                
	public void setUtpfov1 (String value){ this.utpfov1 = value;   }   
	public String getUtpfov1 (){ return this.utpfov1;   }  
	
	private String utpfov2 = null;                                
	public void setUtpfov2 (String value){ this.utpfov2 = value;   }   
	public String getUtpfov2 (){ return this.utpfov2;   }  
	
	private String utpfov3 = null;                                
	public void setUtpfov3 (String value){ this.utpfov3 = value;   }   
	public String getUtpfov3 (){ return this.utpfov3;   }  
	
	private String utpfov4 = null;                                
	public void setUtpfov4 (String value){ this.utpfov4 = value;   }   
	public String getUtpfov4 (){ return this.utpfov4;   }  
	
	private String utpbov1 = null;                                
	public void setUtpbov1 (String value){ this.utpbov1 = value;   }   
	public String getUtpbov1 (){ return this.utpbov1;   }  
	
	private String utpbov2 = null;                        
	public void setUtpbov2 (String value){ this.utpbov2 = value;   }   
	public String getUtpbov2 (){ return this.utpbov2;   }  
	
	private String utpbov3 = null;                                
	public void setUtpbov3 (String value){ this.utpbov3 = value;   }   
	public String getUtpbov3 (){ return this.utpbov3;   }  
	
	private String utpbov4 = null; 
	public void setUtpbov4 (String value){ this.utpbov4 = value;   }   
	public String getUtpbov4 (){ return this.utpbov4;   }              

	private String utpbov5 = null; 
	public void setUtpbov5 (String value){ this.utpbov5 = value;   }   
	public String getUtpbov5 (){ return this.utpbov5;   }              

	private String utpcopi = null; 
	public void setUtpcopi (String value){ this.utpcopi = value;   }   
	public String getUtpcopi (){ return this.utpcopi;   }              

	private String utphold = null; 
	public void setUtphold (String value){ this.utphold = value;   }   
	public String getUtphold (){ return this.utphold;   }              

	private String utpsave = null; 
	public void setUtpsave (String value){ this.utpsave = value;   }   
	public String getUtpsave (){ return this.utpsave;   }              

	private String utpfrmp = null; 
	public void setUtpfrmp (String value){ this.utpfrmp = value;   }   
	public String getUtpfrmp (){ return this.utpfrmp;   }              

	private String utpbamp = null; 
	public void setUtpbamp (String value){ this.utpbamp = value;   }   
	public String getUtpbamp (){ return this.utpbamp;   }              

	private String utpfrmf = null; 
	public void setUtpfrmf (String value){ this.utpfrmf = value;   }   
	public String getUtpfrmf (){ return this.utpfrmf;   }              

	private String utpbamf = null; 
	public void setUtpbamf (String value){ this.utpbamf = value;   }   
	public String getUtpbamf (){ return this.utpbamf;   }
	
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
