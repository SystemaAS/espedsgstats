	/**
 * 
 */
package no.systema.tvinn.sad.z.maintenance.main.util.manager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import no.systema.main.model.SystemaWebUser;
import no.systema.main.service.UrlCgiProxyService;
import no.systema.main.util.JsonDebugger;
import no.systema.tvinn.sad.z.maintenance.felles.model.jsonjackson.dbtable.JsonMaintSadFellesKodtsiContainer;
import no.systema.tvinn.sad.z.maintenance.felles.model.jsonjackson.dbtable.JsonMaintSadFellesKodtsiRecord;
import no.systema.tvinn.sad.z.maintenance.felles.service.MaintSadFellesKodtsiService;
import no.systema.tvinn.sad.z.maintenance.felles.url.store.TvinnSadMaintenanceFellesUrlDataStore;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtaContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtaRecord;
import no.systema.z.main.maintenance.service.MaintMainKodtaService;
import no.systema.z.main.maintenance.url.store.MaintenanceMainUrlDataStore;


/**
 * The class handles general gui drop downs aspect population for TVINN-SAD Vedlikehold
 *
 * This Manager is not instantiated by the Spring Container at start up. 
 * Instead, it is instantiated by a controller when needed.
 * 
 * 
 * 
 * @author Fredrik Möller
 * @date Sep 15, 2016 / Copied Apr 10, 2018
 * 
 * 	
 */

public class CodeDropDownMgr {
	private static final Logger logger = Logger.getLogger(CodeDropDownMgr.class.getName());
	private static final JsonDebugger jsonDebugger = new JsonDebugger();

	
	/**
	 * Populate avdList with data from MaintenanceMainUrlDataStore.MAINTENANCE_MAIN_BASE_SYFA14R_GET_LIST_URL
	 * 
	 * @param urlCgiProxyService
	 * @param specialListPopulationService
	 * @param model holding avdList
	 * @param appUser
	 */
	public void populateCodesHtmlDropDownsFromJsonAvdelning(UrlCgiProxyService urlCgiProxyService, MaintMainKodtaService specialListPopulationService, Map model, SystemaWebUser appUser) {
		String BASE_URL = MaintenanceMainUrlDataStore.MAINTENANCE_MAIN_BASE_SYFA14R_GET_LIST_URL;
		String urlRequestParams = "user=" + appUser.getUser();
		logger.info(Calendar.getInstance().getTime() + " CGI-start timestamp");
		logger.info("URL: " + BASE_URL);
		logger.info("URL PARAMS: " + urlRequestParams);
		String jsonPayload = urlCgiProxyService.getJsonContent(BASE_URL, urlRequestParams);
		List<JsonMaintMainKodtaRecord> list = new ArrayList();
		if (jsonPayload != null) {
			JsonMaintMainKodtaContainer container = specialListPopulationService.getList(jsonPayload);
			if (container != null) {
				list = (List) container.getList();
			}
		}

		model.put("avdList", list);

	}
	
	/**
	 * Populate signatureList with data from TvinnSadMaintenanceFellesUrlDataStore.TVINN_SAD_MAINTENANCE_FELLES_BASE_SYFT10R_GET_LIST_URL
	 * 
	 * @param urlCgiProxyService
	 * @param maintSadFellesKodtsiService
	 * @param model holding signatureList
	 * @param appUser
	 */
	public void populateCodesHtmlDropDownsFromJsonSignature(UrlCgiProxyService urlCgiProxyService, MaintSadFellesKodtsiService maintSadFellesKodtsiService, Map model, SystemaWebUser appUser) {
		String BASE_URL = TvinnSadMaintenanceFellesUrlDataStore.TVINN_SAD_MAINTENANCE_FELLES_BASE_SYFT10R_GET_LIST_URL;
		String urlRequestParams = "user=" + appUser.getUser();
		logger.info(Calendar.getInstance().getTime() + " CGI-start timestamp");
		logger.info("URL: " + jsonDebugger.getBASE_URL_NoHostName(BASE_URL));
		logger.info("URL PARAMS: " + urlRequestParams);
		String jsonPayload = urlCgiProxyService.getJsonContent(BASE_URL, urlRequestParams);
		List<JsonMaintSadFellesKodtsiRecord> list = new ArrayList();
		if (jsonPayload != null) {
			JsonMaintSadFellesKodtsiContainer container = maintSadFellesKodtsiService.getList(jsonPayload);
			if (container != null) {
				list = (List) container.getList();
			}
		}

		model.put("signatureList", list);

	}
	
}
