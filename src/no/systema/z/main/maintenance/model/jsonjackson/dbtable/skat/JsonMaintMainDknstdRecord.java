package no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import no.systema.main.model.jsonjackson.general.JsonAbstractGrandFatherRecord;
import no.systema.main.util.*;

/**
 * 
 * All variables must be initialized to empty strings and NOT to NULL values
 * This is because the db-inserts that will be done in all fields of the db-table
 * 
 * @author oscardelatorre
 * @date Apr 24, 2017
 * 
 */
public class JsonMaintMainDknstdRecord extends JsonAbstractGrandFatherRecord  {
	private NumberFormatterLocaleAware numberFormatter = new NumberFormatterLocaleAware();
	
	private String tist = "";                             
	public String getTistPropertyName (){ return "tist"; }
	public void setTist (String value){ this.tist = value;   }   	
	public String getTist (){ return this.tist;   }  
	
	private String tiavd = "";                                
	public String getTiavdPropertyName (){ return "tiavd"; }
	public void setTiavd (String value){ this.tiavd = value;   }   
	public String getTiavd (){ return this.tiavd;   }  
	
	private String koanvn = "";                                
	public String getKoanvnPropertyName (){ return "koanvn"; }
	public void setKoanvn (String value){ this.koanvn = value;   }   
	public String getKoanvn (){ return this.koanvn;   }  
	
	private String koaknr = "";                                
	public String getKoaknrPropertyName (){ return "koaknr"; }
	public void setKoaknr (String value){ this.koaknr = value;   }   
	public String getKoaknr (){ return this.koaknr;   }  
	
	private String syrg = "";                                
	public String getSyrgPropertyName (){ return "syrg"; }
	public void setSyrg (String value){ this.syrg = value;   }   
	public String getSyrg (){ return this.syrg;   }  
	
	private String tisg = "";                                
	public String getTisgPropertyName (){ return "tisg"; }
	public void setTisg (String value){ this.tisg = value;   }   
	public String getTisg (){ return this.tisg;   }  
	
	private String titdn = "";                                
	public String getTitdnPropertyName (){ return "titdn"; }
	public void setTitdn (String value){ this.titdn = value;   }   
	public String getTitdn (){ return this.titdn;   }  
	
	private String tidt = "";                                
	public String getTidtPropertyName (){ return "tidt"; }
	public void setTidt (String value){ this.tidt = value;   }   
	public String getTidt (){ return this.tidt;   }  
	
	private String tienkl = "";                                
	public String getTienklPropertyName (){ return "tienkl"; }
	public void setTienkl (String value){ this.tienkl = value;   }   
	public String getTienkl (){ return this.tienkl;   }  
	
	private String titrnr = "";                                
	public String getTitrnrPropertyName (){ return "titrnr"; }
	public void setTitrnr (String value){ this.titrnr = value;   }   
	public String getTitrnr (){ return this.titrnr;   }  
	
	private String tign = "";                                
	public String getTignPropertyName (){ return "tign"; }
	public void setTign (String value){ this.tign = value;   }   
	public String getTign (){ return this.tign;   }  
	
	private String tignsk = "";                                
	public String getTignskPropertyName (){ return "tignsk"; }
	public void setTignsk (String value){ this.tignsk = value;   }   
	public String getTignsk (){ return this.tignsk;   }  
	
	private String tialsk = "";                                
	public String getTialskPropertyName (){ return "tialsk"; }
	public void setTialsk (String value){ this.tialsk = value;   }   
	public String getTialsk (){ return this.tialsk;   }  
	
	private String tials = "";                                
	public String getTialsPropertyName (){ return "tials"; }
	public void setTials (String value){ this.tials = value;   }   
	public String getTials (){ return this.tials;   }  
	
	private String tialss = "";                                
	public String getTialssPropertyName (){ return "tialss"; }
	public void setTialss (String value){ this.tialss = value;   }   
	public String getTialss (){ return this.tialss;   }  
	
	private String tiglsk = "";                                
	public String getTiglskPropertyName (){ return "tiglsk"; }
	public void setTiglsk (String value){ this.tiglsk = value;   }   
	public String getTiglsk (){ return this.tiglsk;   }  
	
	private String tiacts = "";                                
	public String getTiactsPropertyName (){ return "tiacts"; }
	public void setTiacts (String value){ this.tiacts = value;   }   
	public String getTiacts (){ return this.tiacts;   }  
	
	private String tiskb = "";                                
	public String getTiskbPropertyName (){ return "tiskb"; }
	public void setTiskb (String value){ this.tiskb = value;   }   
	public String getTiskb (){ return this.tiskb;   }  
	
	private String titsb = "";     
	public String getTitsbPropertyName (){ return "titsb"; }
	public void setTitsb (String value){ this.titsb = value;   }   
	public String getTitsb (){ return this.titsb;   }  
	
	private String titarf = "";                                
	public String getTitarfPropertyName (){ return "titarf"; }
	public void setTitarf (String value){ this.titarf = value;   }   
	public String getTitarf (){ return this.titarf;   }  
	
	private String tiws = "";                                
	public String getTiwsPropertyName (){ return "tiws"; }
	public void setTiws (String value){ this.tiws = value;   }   
	public String getTiws (){ return this.tiws;   }  
	
	private String tikn = "";                                
	public String getTiknPropertyName (){ return "tikn"; }
	public void setTikn (String value){ this.tikn = value;   }   
	public String getTikn (){ return this.tikn;   }  
	
	private String tina = "";                                
	public String getTinaPropertyName (){ return "tina"; }
	public void setTina (String value){ this.tina = value;   }   
	public String getTina (){ return this.tina;   }  
		
	private String tiad1 = "";                                
	public String getTiad1PropertyName (){ return "tiad1"; }
	public void setTiad1 (String value){ this.tiad1 = value;   }   
	public String getTiad1 (){ return this.tiad1;   }  
	
	private String tipn = "";                                
	public String getTipnPropertyName (){ return "tipn"; }
	public void setTipn (String value){ this.tipn = value;   }   
	public String getTipn (){ return this.tipn;   }  
	
	private String tips = "";                                
	public String getTipsPropertyName (){ return "tips"; }
	public void setTips (String value){ this.tips = value;   }   
	public String getTips (){ return this.tips;   }  
	
	private String tilk = "";                                
	public String getTilkPropertyName (){ return "tilk"; }
	public void setTilk (String value){ this.tilk = value;   }   
	public String getTilk (){ return this.tilk;   }  
	
	private String tisk = "";                                
	public String getTiskPropertyName (){ return "tisk"; }
	public void setTisk (String value){ this.tisk = value;   }   
	public String getTisk (){ return this.tisk;   }  
	
	private String titin = "";                                
	public String getTitinPropertyName (){ return "titin"; }
	public void setTitin (String value){ this.titin = value;   }   
	public String getTitin (){ return this.titin;   }  
	
	private String s0004 = "";                                
	public String getS0004PropertyName (){ return "s0004"; }
	public void setS0004 (String value){ this.s0004 = value;   }   
	public String getS0004 (){ return this.s0004;   }  
	
	private String s0010 = "";                                
	public String getS0010PropertyName (){ return "s0010"; }
	public void setS0010 (String value){ this.s0010 = value;   }   
	public String getS0010 (){ return this.s0010;   }  
	
	private String s0035 = "";                                
	public String getS0035PropertyName (){ return "s0035"; }
	public void setS0035 (String value){ this.s0035 = value;   }   
	public String getS0035 (){ return this.s0035;   }  
	
	private String dkns_0035 = "";                                
	public String getDkns_0035PropertyName (){ return "dkns_0035"; }
	public void setDkns_0035 (String value){ this.dkns_0035 = value;   }   
	public String getDkns_0035(){ return this.dkns_0035;   }  
	
	private String s0026 = "";                                
	public String getS0026PropertyName (){ return "s0026"; }
	public void setS0026 (String value){ this.s0026 = value;   }   
	public String getS0026 (){ return this.s0026;   }  
	
	private String tidk = "";                                
	public String getTidkPropertyName (){ return "tidk"; }
	public void setTidk (String value){ this.tidk = value;   }   
	public String getTidk (){ return this.tidk;   }  

	private String tikna = "";                                
	public String getTiknaPropertyName (){ return "tikna"; }
	public void setTikna (String value){ this.tikna = value;   }   
	public String getTikna (){ return this.tikna;   }  
	
	private String tinaa = "";                                
	public String getTinaaPropertyName (){ return "tinaa"; }
	public void setTinaa (String value){ this.tinaa = value;   }   
	public String getTinaa (){ return this.tinaa;   }  
	
	private String tiada1 = "";                                
	public String getTiada1PropertyName (){ return "tiada1"; }
	public void setTiada1 (String value){ this.tiada1 = value;   }   
	public String getTiada1 (){ return this.tiada1;   }  

	private String tipna = "";                                
	public String getTipnaPropertyName (){ return "tipna"; }
	public void setTipna (String value){ this.tipna = value;   }   
	public String getTipna (){ return this.tipna;   }  
	
	private String tipsa = "";                                
	public String getTipsaPropertyName (){ return "tipsa"; }
	public void setTipsa (String value){ this.tipsa = value;   }   
	public String getTipsa (){ return this.tipsa;   }  
	
	private String tilka = "";                                
	public String getTilkaPropertyName (){ return "tilka"; }
	public void setTilka (String value){ this.tilka = value;   }   
	public String getTilka (){ return this.tilka;   }  

	private String tiska = "";                                
	public String getTiskaPropertyName (){ return "tiska"; }
	public void setTiska (String value){ this.tiska = value;   }   
	public String getTiska (){ return this.tiska;   }  
	
	private String titina = "";                                
	public String getTitinaPropertyName (){ return "titina"; }
	public void setTitina (String value){ this.titina = value;   }   
	public String getTitina (){ return this.titina;   }  
	
	private String tikns = "";                                
	public String getTiknsPropertyName (){ return "tikns"; }
	public void setTikns (String value){ this.tikns = value;   }   
	public String getTikns (){ return this.tikns;   }  

	private String tinas = "";                                
	public String getTinasPropertyName (){ return "tinas"; }
	public void setTinas (String value){ this.tinas = value;   }   
	public String getTinas (){ return this.tinas;   }  
	
	private String tiads1 = "";                                
	public String getTiads1PropertyName (){ return "tiads1"; }
	public void setTiads1 (String value){ this.tiads1 = value;   }   
	public String getTiads1 (){ return this.tiads1;   }  
	
	private String tipns = "";                                
	public String getTipnsPropertyName (){ return "tipns"; }
	public void setTipns (String value){ this.tipns = value;   }   
	public String getTipns (){ return this.tipns;   }  

	private String tipss = "";                                
	public String getTipssPropertyName (){ return "tipss"; }
	public void setTipss (String value){ this.tipss = value;   }   
	public String getTipss (){ return this.tipss;   }  
	
	private String tilks = "";                                
	public String getTilksPropertyName (){ return "tilks"; }
	public void setTilks (String value){ this.tilks = value;   }   
	public String getTilks (){ return this.tilks;   }  
	
	private String tisks = "";                                
	public String getTisksPropertyName (){ return "tisks"; }
	public void setTisks (String value){ this.tisks = value;   }   
	public String getTisks (){ return this.tisks;   }  

	private String titins = "";                                
	public String getTitinsPropertyName (){ return "titins"; }
	public void setTitins (String value){ this.titins = value;   }   
	public String getTitins (){ return this.titins;   }  
	
	private String tiknk = "";                                
	public String getTiknkPropertyName (){ return "tiknk"; }
	public void setTiknk (String value){ this.tiknk = value;   }   
	public String getTiknk (){ return this.tiknk;   }  
	
	private String tinak = "";                                
	public String getTinakPropertyName (){ return "tinak"; }
	public void setTinak (String value){ this.tinak = value;   }   
	public String getTinak (){ return this.tinak;   }  
	
	private String tiadk1 = "";                                
	public String getTiadk1PropertyName (){ return "tiadk1"; }
	public void setTiadk1 (String value){ this.tiadk1 = value;   }   
	public String getTiadk1 (){ return this.tiadk1;   }  

	private String tipnk = "";                                
	public String getTipnkPropertyName (){ return "tipnk"; }
	public void setTipnk (String value){ this.tipnk = value;   }   
	public String getTipnk (){ return this.tipnk;   }  
	
	private String tipsk = "";                                
	public String getTipskPropertyName (){ return "tipsk"; }
	public void setTipsk (String value){ this.tipsk = value;   }   
	public String getTipsk (){ return this.tipsk;   }  
	
	private String tilkk = "";                                
	public String getTilkkPropertyName (){ return "tilkk"; }
	public void setTilkk (String value){ this.tilkk = value;   }   
	public String getTilkk (){ return this.tilkk;   }  
	
	private String tiskk = "";                                
	public String getTiskkPropertyName (){ return "tiskk"; }
	public void setTiskk (String value){ this.tiskk = value;   }   
	public String getTiskk (){ return this.tiskk;   }  

	private String titink = "";                                
	public String getTitinkPropertyName (){ return "titink"; }
	public void setTitink (String value){ this.titink = value;   }   
	public String getTitink (){ return this.titink;   }  
	
	private String tiblk = "";                                
	public String getTiblkPropertyName (){ return "tiblk"; }
	public void setTiblk (String value){ this.tiblk = value;   }   
	public String getTiblk (){ return this.tiblk;   }  
	
	private String tialk = "";                                
	public String getTialkPropertyName (){ return "tialk"; }
	public void setTialk (String value){ this.tialk = value;   }   
	public String getTialk (){ return this.tialk;   }
	
	private String titaid = "";                                
	public String getTitaidPropertyName (){ return "titaid"; }
	public void setTitaid (String value){ this.titaid = value;   }   
	public String getTitaid (){ return this.titaid;   }  

	private String titask = "";                                
	public String getTitaskPropertyName (){ return "titask"; }
	public void setTitask (String value){ this.titask = value;   }   
	public String getTitask (){ return this.titask;   }  
	
	private String titalk = "";                                
	public String getTitalkPropertyName (){ return "titalk"; }
	public void setTitalk (String value){ this.titalk = value;   }   
	public String getTitalk (){ return this.titalk;   }  
	
	private String tikdc = "";                                
	public String getTikdcPropertyName (){ return "tikdc"; }
	public void setTikdc (String value){ this.tikdc = value;   }   
	public String getTikdc (){ return this.tikdc;   }
	
	private String titrdt = "";                                
	public String getTitrdtPropertyName (){ return "titrdt"; }
	public void setTitrdt (String value){ this.titrdt = value;   }   
	public String getTitrdt (){ return this.titrdt;   }  

	private String tilstl = "";                                
	public String getTilstlPropertyName (){ return "tilstl"; }
	public void setTilstl (String value){ this.tilstl = value;   }   
	public String getTilstl (){ return this.tilstl;   }  
	
	private String tivpos = "";                                
	public String getTivposPropertyName (){ return "tivpos"; }
	public void setTivpos (String value){ this.tivpos = value;   }   
	public String getTivpos (){ return this.tivpos;   }  
	
	private String tintk = "";                                
	public String getTintkPropertyName (){ return "tintk"; }
	public void setTintk (String value){ this.tintk = value;   }   
	public String getTintk (){ return this.tintk;   }
	
	private String tivkb = "";                                
	public String getTivkbPropertyName (){ return "tivkb"; }
	public void setTivkb (String value){ this.tivkb = value;   }   
	public String getTivkb (){ return this.tivkb;   }  

	private String ticats = "";                                
	public String getTicatsPropertyName (){ return "ticats"; }
	public void setTicats (String value){ this.ticats = value;   }   
	public String getTicats (){ return this.ticats;   }  
	
	private String tictl = "";                                
	public String getTictlPropertyName (){ return "tictl"; }
	public void setTictl (String value){ this.tictl = value;   }   
	public String getTictl (){ return this.tictl;   }  
	
	private String tidant = "";                                
	public String getTidantPropertyName (){ return "tidant"; }
	public void setTidant (String value){ this.tidant = value;   }   
	public String getTidant (){ return this.tidant;   }
	
	private String tidfkd = "";                                
	public String getTidfkdPropertyName (){ return "tidfkd"; }
	public void setTidfkd (String value){ this.tidfkd = value;   }   
	public String getTidfkd (){ return this.tidfkd;   }  

	private String tidfsk = "";                                
	public String getTidfskPropertyName (){ return "tidfsk"; }
	public void setTidfsk (String value){ this.tidfsk = value;   }   
	public String getTidfsk (){ return this.tidfsk;   }  
	
	private String tituid = "";                                
	public String getTituidPropertyName (){ return "tituid"; }
	public void setTituid (String value){ this.tituid = value;   }   
	public String getTituid (){ return this.tituid;   }  
	
	private String tisgdk = "";                                
	public String getTisgdkPropertyName (){ return "tisgdk"; }
	public void setTisgdk (String value){ this.tisgdk = value;   }   
	public String getTisgdk (){ return this.tisgdk;   }
	
	private String tisgme = "";                                
	public String getTisgmePropertyName (){ return "tisgme"; }
	public void setTisgme (String value){ this.tisgme = value;   }   
	public String getTisgme (){ return this.tisgme;   }  

	private String tisgut = "";                                
	public String getTisgutPropertyName (){ return "tisgut"; }
	public void setTisgut (String value){ this.tisgut = value;   }   
	public String getTisgut (){ return this.tisgut;   }  
	
	private String tisgid = "";                                
	public String getTisgidPropertyName (){ return "tisgid"; }
	public void setTisgid (String value){ this.tisgid = value;   }   
	public String getTisgid (){ return this.tisgid;   }  
	
	private String tisgdt = "";                                
	public String getTisgdtPropertyName (){ return "tisgdt"; }
	public void setTisgdt (String value){ this.tisgdt = value;   }   
	public String getTisgdt (){ return this.tisgdt;   }
	
	private String tibyte = "";                                
	public String getTibytePropertyName (){ return "tibyte"; }
	public void setTibyte (String value){ this.tibyte = value;   }   
	public String getTibyte (){ return this.tibyte;   }  

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
