	//this variable is a global jQuery var instead of using "$" all the time. Very handy
  	var jq = jQuery.noConflict();
  	//----------
  	//functions
  	//----------
	jq(function() {
		jq('#customerList').on('click', 'td', function(){
			  var id = this.id;
			  var record = id.split('@');
			 
			  var knr = record[0].replace("knr", "");
			  var knavn = record[1].replace("knavn", "");
			  var adr1 = record[2].replace("kadr1", "");
			  var adr3 = record[3].replace("kadr3", "");
			  var postnr = record[4].replace("kpostnr", "");
			  var land = record[5].replace("kland", "");
			  var eori = record[6].replace("keori", "");
			  var callerType = record[7].replace("ctype", "");
			  var adr2 = record[8].replace("kadr2", "");
			  var firma = record[9].replace("firma", "");
			  
			  //addressing a parent field from this child window
			  //default on Generella Avd
			  opener.jq('#koaknr').val(knr);
			  
			  //SAD Import - AVD
			  if(callerType == 'sinak'){
				  opener.jq('#siknk').val(knr);
				  opener.jq('#sinak').val(knavn);
				  opener.jq('#sirg').val(eori);
				  opener.jq('#siadk1').val(adr1);
				  opener.jq('#siadk2').val(adr2);
				  opener.jq('#siadk3').val(adr3);
			  }else if(callerType == 'sinas'){
				  opener.jq('#sikns').val(knr);
				  opener.jq('#sinas').val(knavn);
				  opener.jq('#siads1').val(adr1);
				  opener.jq('#siads2').val(adr2);
				  opener.jq('#siads3').val(adr3);
			  
			  //SAD Export - AVD
			  }else if(callerType == 'senak'){
				  opener.jq('#seknk').val(knr);
				  opener.jq('#senak').val(knavn);
				  opener.jq('#serg').val(eori);
				  opener.jq('#seadk1').val(adr1);
				  opener.jq('#seadk2').val(adr2);
				  opener.jq('#seadk3').val(adr3);
			  }else if(callerType == 'senas'){
				  opener.jq('#sekns').val(knr);
				  opener.jq('#senas').val(knavn);
				  opener.jq('#seads1').val(adr1);
				  opener.jq('#seads2').val(adr2);
				  opener.jq('#seads3').val(adr3);
				  
			  //SAD/SKAT NCTS Import	  
			  }else if(callerType == 'tina'){
				  opener.jq('#tikn').val(knr);
				  opener.jq('#tina').val(knavn);
				  opener.jq('#titin').val(eori);
				  opener.jq('#tiad1').val(adr1);
				  opener.jq('#tips').val(adr3);
				  opener.jq('#tipn').val(postnr);
				  opener.jq('#tilk').val(land);
				  
			  //SAD/SKAT NCTS Eksport	  	  
			  }else if(callerType == 'thnas'){
				  opener.jq('#thkns').val(knr);
				  opener.jq('#thnas').val(knavn);
				  opener.jq('#thtins').val(eori);
				  opener.jq('#thads1').val(adr1);
				  opener.jq('#thpss').val(adr3);
				  opener.jq('#thpns').val(postnr);
				  opener.jq('#thlks').val(land);
			  }else if(callerType == 'thnak'){
				  opener.jq('#thknk').val(knr);
				  opener.jq('#thnak').val(knavn);
				  opener.jq('#thtink').val(eori);
				  opener.jq('#thadk1').val(adr1);
				  opener.jq('#thpsk').val(adr3);
				  opener.jq('#thpnk').val(postnr);
				  opener.jq('#thlkk').val(land);
			  }else if(callerType == 'thnaa'){
				  opener.jq('#thkna').val(knr);
				  opener.jq('#thnaa').val(knavn);
				  opener.jq('#thtina').val(eori);
				  opener.jq('#thada1').val(adr1);
				  opener.jq('#thpsa').val(adr3);
				  opener.jq('#thpna').val(postnr);
				  opener.jq('#thlka').val(land);
			  }else if(callerType == 'thnass'){ //AVS- sikkerhed
				  opener.jq('#thknss').val(knr);
				  opener.jq('#thnass').val(knavn);
				  opener.jq('#thtinss').val(eori);
				  opener.jq('#thadss1').val(adr1);
				  opener.jq('#thpsss').val(adr3);
				  opener.jq('#thpnss').val(postnr);
				  opener.jq('#thlkss').val(land);
			  }else if(callerType == 'thnaks'){ //MOTTAK- sikkerhed
				  opener.jq('#thknks').val(knr);
				  opener.jq('#thnaks').val(knavn);
				  opener.jq('#thtinks').val(eori);
				  opener.jq('#thadks1').val(adr1);
				  opener.jq('#thpsks').val(adr3);
				  opener.jq('#thpnks').val(postnr);
				  opener.jq('#thlkks').val(land);
			  }else if(callerType == 'thnat'){ //CARRIER- sikkerhed
				  opener.jq('#thknt').val(knr);
				  opener.jq('#thnat').val(knavn);
				  opener.jq('#thtint').val(eori);
				  opener.jq('#thadt1').val(adr1);
				  opener.jq('#thpst').val(adr3);
				  opener.jq('#thpnt').val(postnr);
				  opener.jq('#thlkt').val(land);
				  
			  //SKAT Import - Certifikatkoder
			  }else if(callerType == 'dkse_knr'){ 
				  opener.jq('#dkse_knr').val(knr);
				  
			  }else if (callerType == 'fmot'){ //Kunderegister, Fakturamottager
				  opener.jq('#fmot').val(knr);
				  opener.jq('#fmot').change();
				  opener.jq('#fmot').focus();
			  } else if(callerType == 'selectKundenr') { //Analyse-view
				  opener.jq('#selectKundenr').val(knr);
				  opener.jq('#selectKundenr').change();
				  opener.jq('#selectKundenr').focus();	  
			  } else if(callerType == 'selectKundenr_avs') { //Analyse-view
				  opener.jq('#selectKundenr_avs').val(knr);
				  opener.jq('#selectKundenr_avs').change();
				  opener.jq('#selectKundenr_avs').focus();	  
			  //Maintenance TDS Export Kunders vareregister		
			  }	else if(callerType == 'mainttdsexport_kundreg'){
				  //must redirect on parent window
				  window.opener.location.href = "mainmaintenancecundf_vareexp_se_from_tdsexportmaint.do?kundnr=" + knr + "&knavn=" + knavn + "&firma=" + firma;

			  //TROR - Oppdragsreg.	  
			  }else if (callerType == 'tror_ag'){ //Agent
				  opener.jq('#hekna').val(knr);
				  opener.jq('#henaa').val(knavn);
			 
			  }else if (callerType == 'tror_se'){ //Seller
				  opener.jq('#hekns').val(knr);
				  var compoundName = knavn + " - " + adr3 + " " + postnr;
				  opener.jq('#whenas').val(compoundName);
				  //?
				  //opener.jq('#todo').val(knr);
				  opener.jq('#henas').val(knavn);
				  //opener.jq('#todo').val(eori);
				  opener.jq('#heads1').val(adr1);
				  opener.jq('#heads2').val(adr2);
				  opener.jq('#heads3').val(adr3 + " " + postnr);
				  //opener.jq('#todo').val(land);
			  
			  }else if (callerType == 'tror_sefm'){ //Seller Fakt.mott.
				  opener.jq('#heknsf').val(knr);
				  var compoundName = knavn + " - " + adr3 + " " + postnr;
				  opener.jq('#whenasf').val(compoundName);
			  
			  }else if (callerType == 'tror_by'){ //Buyer
				  opener.jq('#heknk').val(knr);
				  var compoundName = knavn + " - " + adr3 + " " + postnr;
				  opener.jq('#whenak').val(compoundName);
				  //?
				  //opener.jq('#todo').val(knr);
				  opener.jq('#henak').val(knavn);
				  //opener.jq('#todo').val(eori);
				  opener.jq('#headk1').val(adr1);
				  opener.jq('#headk2').val(adr2);
				  opener.jq('#headk3').val(adr3 + " " + postnr);
				  //opener.jq('#todo').val(land);
				  
			  }else if (callerType == 'tror_byfm'){ //Buyer Faktmott.
				  opener.jq('#heknkf').val(knr);
				  var compoundName = knavn + " - " + adr3 + " " + postnr;
				  opener.jq('#whenakf').val(compoundName);
				  
			  }else if (callerType == 'tror_car'){ //Carrier
				  opener.jq('#heknt').val(knr);
				  var compoundName = knavn + " - " + adr3 + " " + postnr;
				  opener.jq('#ownheknt').val(compoundName);
			  
			  }else if (callerType == 'tror_by_fb'){ //Buyer - fraktbrev
				  opener.jq('#dfknsm').val(knr);
				  var compoundName = knavn + " - " + adr3 + " " + postnr;
				  opener.jq('#whenak').val(compoundName);
				  //?
				  //opener.jq('#todo').val(knr);
				  opener.jq('#dfnavm').val(knavn);
				  //opener.jq('#todo').val(eori);
				  opener.jq('#dfad1m').val(adr1);
				  opener.jq('#dfad2m').val(adr2);
				  opener.jq('#dfad3m').val(adr3 + " " + postnr);
				  //opener.jq('#todo').val(land);
				  
			  }else if (callerType == 'tror_se_fb'){ //Seller fraktbrev
				  opener.jq('#dfknss').val(knr);
				  var compoundName = knavn + " - " + adr3 + " " + postnr;
				  opener.jq('#whenas').val(compoundName);
				  //?
				  //opener.jq('#todo').val(knr);
				  opener.jq('#dfnavs').val(knavn);
				  //opener.jq('#todo').val(eori);
				  opener.jq('#dfad1s').val(adr1);
				  opener.jq('#dfad2s').val(adr2);
				  opener.jq('#dfad3s').val(adr3);
				  opener.jq('#dfpnls').val(postnr);
				  
				  //opener.jq('#todo').val(land);
			  
			  } else if (callerType == 'tror_annen_fb'){ //Annen fraktbetaler fraktbrev
				  opener.jq('#dfknsx').val(knr);
				  //var compoundName = knavn + " - " + adr3 + " " + postnr;
				  //opener.jq('#whenas').val(compoundName);
				  //?
				  //opener.jq('#todo').val(knr);
				  opener.jq('#dfnavx').val(knavn);
				  //opener.jq('#todo').val(eori);
				  opener.jq('#dfad1x').val(adr1);
				  opener.jq('#dfad2x').val(adr2);
				  opener.jq('#dfad3x').val(adr3);
				  // TODO opener.jq('#dfpnls').val(postnr);
				  
				  //opener.jq('#todo').val(land);
			  
			  } else if (callerType =='tror_flyiavs'){
				  opener.jq('#hekns').val(knr);
				  opener.jq('#ownHekns').val(knavn);
				  
			  }
			  
			  
			  
			  //close child window
			  window.close();
		  });
	});
	

	
	//======================
    //Datatables jquery 
    //======================
    //private function [Filters]
    function filterGeneralCode () {
    		jq('#customerList').DataTable().search(
      		jq('#customerList_filter').val()
    		).draw();
    } 
	//Init datatables
    jq(document).ready(function() {
  	  //-----------------------
      //table [General Code List]
  	  //-----------------------
    	  jq('#customerList').dataTable( {
    		  "dom": '<"top"fli>rt<"bottom"p><"clear">',
    		  "lengthMenu": [ 75, 100, 200, 500]
    	  });
      //event on input field for search
      jq('input.customerList_filter').on( 'keyup click', function () {
      		filterGeneralCode();
      });
      
    });   
  	
  	
	