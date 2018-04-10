<%@ include file="/WEB-INF/views/include.jsp" %>
<!-- ======================= header ===========================-->
<jsp:include page="/WEB-INF/views/headerReportDashboard.jsp" />
<!-- =====================end header ==========================-->
<style>
.horizontal-scroll-group > .row {
  width: 1200px;
  overflow-x: scroll;
  white-space: nowrap;
  display: inline-block;
}

.horizontal-scroll-group > .row > .col-md-4 {
  display: inline-block;
  float: none;
  vertical-align: top;
  margin-right: -30px;
  margin-left: 15px;
}

.horizontal-scroll-group > .row > .col-md-3 {
  display: inline-block;
  float: none;
  vertical-align: top;
  margin-right: -60px;
  margin-left: 30px;
}

.horizontal-scroll-group > .row > .col-md-2 {
  display: inline-block;
  float: none;
  margin-right: -30px;
  margin-left: 15px;
}

.col-md-4 { margin-right: -30px; margin-left: 15px;  }

.ui-dialog{font-size:10pt;}
.ui-datepicker { font-size:9pt;}

</style>

<script type="text/javascript">
"use strict";
jq(function() {
	jq("#selectFradato").datepicker({ 
		  dateFormat: 'yymmdd'  
	});
	jq("#selectTildato").datepicker({ 
		  dateFormat: 'yymmdd'  
	});
});
var jq = jQuery.noConflict();
var BLOCKUI_OVERLAY_MESSAGE_DEFAULT = "Vennligst vent...";
var tolldataSize;
var ofs = 0, pag = 20;
var baseUrl = "/syjservicesbcore/syjsFORTOLLING_DB.do?user=${user.user}&httpRootCgi=${httpRootCgi}";
var merknaderDescUrl = "/syjservicestn/syjsTVI99D.do?user=${user.user}";
var avdelingDescUrl = "/syjservicesbcore/syjsSYFA14R.do?user=${user.user}";
var signaturerDescUrl = "/syjservicestn/syjsSYFT10R.do?user=${user.user}";
var avsnittDescUrl = "/syjservicesbcore/syjsSADKAA.do?user=${user.user}";
var baseImportUrl = "/espedsg/report_dashboard_toSadImport.do?action=doFetch";
var baseExportUrl = "/espedsg/report_dashboard_toSadExport.do?action=doFetch";

var merknader;
var avdelinger;
var signaturer;
var avsnitter;

var colorMap = {
        "fortollinger": "#69c",
        "reg_vp":  "#9c6",
        "off_vp": "#f19411"
    };	


// var loaded_data;

//Preload desc for merknader, avdeling, signaturer
d3.queue()
	.defer(function(merknaderDescUrl, callback) {
			d3.json(merknaderDescUrl, function(error, data) {
				if (error) {
					jq.unblockUI();
				}

				callback(error, data);

				if (data.list == '') {
					jq.unblockUI();
					alert('Ingen data for merknader.');  
					return "no data found";
				} else {
					merknader = data.list;
				}
				
				//console.log("Desc 954="+_.findWhere(merknader,{e9705:'954'}).e4440);				
				
			})
	 }, merknaderDescUrl)	
	.defer(function(avdelingDescUrl, callback) {
			d3.json(avdelingDescUrl, function(error, data) {
				if (error) {
					jq.unblockUI();
				}

				callback(error, data);

				if (data.list == '') {
					jq.unblockUI();
					alert('Ingen data for avdelinger.');  
					return "no data found";
				} else {
					avdelinger = data.list;
				}
				
				//console.log("Desc 2790="+_.findWhere(avdelinger,{koaavd:'2790'}).koanvn);		
				
			})
	 }, avdelingDescUrl)	
	.defer(function(signaturerDescUrl, callback) {
			d3.json(signaturerDescUrl, function(error, data) {
				if (error) {
					jq.unblockUI();
				}

				callback(error, data);

				if (data.list == '') {
					jq.unblockUI();
					alert('Ingen data for signaturer.');  
					return "no data found";
				} else {
					signaturer = data.list;
				}
				
				//console.log("Desc FM="+_.findWhere(signaturer,{ksisig:'FM'}).ksinav);		
				
			})
	 }, signaturerDescUrl)	
	.awaitAll(function(error, data) { 
			if (error) console.log("error",error);
	});


function getMerknadDesc(id) {
	var desc =  _.findWhere(merknader,{e9705:id});
	if (desc != null && desc != "") {
		return desc.e4440;
	} else {
		return "["+id+" ikke funnet som funksjonfeil i vedlikehold.]";		
	}

}


function getAvdelingDesc(id) {
	var cadaquienconsucacaenloscalzones = ''+id+'';
	var desc =  _.findWhere(avdelinger,{koaavd:cadaquienconsucacaenloscalzones});
	if (desc != null && desc != "") {
		return desc.koanvn;
	} else {
		return "["+id+" ikke funnet som avdeling i vedlikehold.]";		
	}
}

function getSignaturDesc(id) {
	var desc =  _.findWhere(signaturer,{ksisig:id});
	if (desc != null && desc != "") {
		return desc.ksinav;
	} else {
		return "["+id+" ikke funnet som gyldig tariffør i vedlikehold.]";		
	}

}

function popItUp(url) {
	 var myWindow = window.open(url, "", "top=200px,left=1000px,height=700px,width=1100px,scrollbars=no,status=no,location=no");
	 
}	

function load_data() {

	jq('#detailsTable').toggle(false); //default hide
	
	var runningUrl = baseUrl;
	var selectedFradato = jq('#selectFradato').val();
	var selectedTildato = jq('#selectTildato').val();
	var selectedAvd = jq('#selectAvd').val();
	var selectedSign = jq('#selectSign').val();
	var selectedKundenr = jq('#selectKundenr').val();
	var selectedKundenr_avs = jq('#selectKundenr_avs').val();

	if (selectedAvd != null && selectedAvd != "")	{
		runningUrl = runningUrl + "&avdelings="+selectedAvd; 
	}
	if (selectedSign != null && selectedSign != "")	{
		runningUrl = runningUrl + "&signatur="+selectedSign;
	}	
	if (selectedKundenr != "" )	{
		runningUrl = runningUrl + "&mottaker="+selectedKundenr;
	}
	if (selectedKundenr_avs != "" )	{
		runningUrl = runningUrl + "&avsender="+selectedKundenr_avs;
	}	
	if (selectedFradato != null && selectedFradato != "") {
		runningUrl = runningUrl + "&fradato="+selectedFradato;		
	} else {
		alert('Fra dato er obligatorisk.'); 
		return "no data found";
	}
	if (selectedTildato != null && selectedTildato != "") {
		runningUrl = runningUrl + "&tildato="+selectedTildato;
	} else {
		alert('Til dato er obligatorisk.'); 
		return "no data found";
	}

	console.log("runningUrl="+runningUrl); 		
	
    jq.blockUI({message : BLOCKUI_OVERLAY_MESSAGE_DEFAULT});

	d3.json(runningUrl, function(error, data) {
		if (error) {
			jq.unblockUI();
			throw error;
		}
			
		if (data.dtoList == '') {
			jq.unblockUI();
			alert('Ingen data på urvalg.'); 
			return "no data found";
		}
		
		var tollData = data.dtoList;

	    var NO = d3.locale(no_NO);
	    var fullDateFormat = d3.time.format('%Y%m%d');
	    var yearFormat = d3.time.format('%Y');
	    var monthNameFormat = NO.timeFormat('%m.%b');
	    var percentageFormat = d3.format('.2%');

	    var lang = jq('#language').val();
	    if (lang == '') {
	    	lang = 'NO';
	    }	    
	    
	    // normalize/parse data
		 _.each(tollData, function( d) {
		  d.date = fullDateFormat.parse(d.registreringsdato);
		  d.year = yearFormat(d.date);
		  d.month = monthNameFormat(d.date);
		  d.avdeling = d.avdeling;
		  d.deklarasjonsnr= d.deklarasjonsnr;
		  d.reg_vareposter = +d.reg_vareposter;
		  d.off_vareposter = +d.off_vareposter;
		  d.registreringsdato = +d.registreringsdato; 
		  d.deklarasjonsdato = +d.deklarasjonsdato;
		  d.signatur =   d.signatur;
		  d.mottaker =   d.mottaker;
		  d.avsender =   d.avsender;
		  d.edim =   d.edim;
		  d.inputtype = d.inputtype;
		  d.extern_referanse = d.extern_referanse;
		  d.antall_dager =  d.antall_dager;
		  d.avsender_land = d.avsender_land;
		  d.wai = +d.wai;
		  d.waii = +d.waii;
		  d.waiii = +d.waiii;
		  d.waiv = d.waiv;
		  d.wav = +d.wav;
		  d.wavi = +d.wavi;
		  d.wavii = +d.wavii;
		  d.waviii = +d.waviii;
		  d.waix = +d.waix;
		  d.wax = +d.wax;
		  d.waxi = +d.waxi;
		  d.waxii = +d.waxii;
		  d.waxiii = +d.waxiii;
		  d.waxiv = +d.waxiv;
		  d.waxv = +d.waxv;
		  d.waxvi = +d.waxvi;
		  d.waxvii = +d.waxvii;
		  d.waxviii = +d.waxviii;
		  d.waxvix = +d.waxvix;
		  d.waxx = +d.waxx;
		  d.waxxi = +d.waxxi;
		});

		// set crossfilter. Crossfilter runs in the browser and the practical limit is somewhere around half a million to a million rows of data.
		var toll = crossfilter(tollData);	
		var  all = toll.groupAll();
		tolldataSize = toll.size();
		//Dimensions
		var  tollAllDim = toll.dimension(function(d) {return d;});	
		var  dateDim  = toll.dimension(function(d) {return d.date;});
	    var  monthDim = toll.dimension(function (d) {return d.month;});	
		var  avdDim  = toll.dimension(function(d) {return d.avdeling;});
		var  sisgDim  = toll.dimension(function(d) {return d.signatur;});
		var  typeDim  = toll.dimension(function(d) {return d.type;});
		var  edimDim  = toll.dimension(function(d) {return d.edim;});
		var  avsenderLandDim  = toll.dimension(function(d) {return d.avsender_land;});
	    var  openDaysDim = toll.dimension(function (d) {
			var antallDager = d.antall_dager;
	        if (antallDager <= 1) {   //0-1
	            return '0-1';
	        } else if (antallDager > 1 && antallDager <= 4) { //2-4
	            return '2-4';
	        } else if (antallDager > 4 && antallDager <= 9) { //5-9
	            return '5-9';
	        } else {
	            return 'mer enn 9'; //> 9
	        }
    	});		
	    var  inputTypeDim  = toll.dimension(function(d) {
	        var inputType = d.inputtype;
	        if (inputType != null && inputType != "") {
	        	return 'EDI';
	        } else {
	        	return 'Manuell';
	        }
		});	
		//Charts 
		var  typeChart   = dc.pieChart("#chart-ring-type");
		var  avdChart   = dc.pieChart('#chart-ring-avd');
		var  sisgChart   = dc.pieChart('#chart-ring-sisg');
		var  edimChart   = dc.pieChart('#chart-ring-edim');
		var  inputTypeChart   = dc.pieChart('#chart-ring-inputtype');
		var  openDaysChart   = dc.pieChart('#chart-ring-opendays');
		var  avsenderLandChart   = dc.pieChart('#chart-ring-avsenderland');
		var  varuposterChart = dc.barChart("#chart-varuposter");
		var  dataCount = dc.dataCount('#data-count');	 
		var  antallDisplay = dc.numberDisplay("#antall");	
		var  antallreg_vareposterDisplay = dc.numberDisplay("#antallreg_vareposter");	
		var  antalloff_vareposterDisplay = dc.numberDisplay("#antalloff_vareposter");	
		var  dcDataTable;
 		var  waiDisplay = dc.numberDisplay("#wai");	
 		var  waiiDisplay = dc.numberDisplay("#waii");	
		var  waiiiDisplay = dc.numberDisplay("#waiii");	
		var  waivDisplay = dc.numberDisplay("#waiv");	
		var  wavDisplay = dc.numberDisplay("#wav");	
		var  waviDisplay = dc.numberDisplay("#wavi");	
		var  waviiDisplay = dc.numberDisplay("#wavii");	
		var  waviiiDisplay = dc.numberDisplay("#waviii");	
		var  waixDisplay = dc.numberDisplay("#waix");	
		var  waxDisplay = dc.numberDisplay("#wax");	
		var  waxiDisplay = dc.numberDisplay("#waxi");	
		var  waxiiDisplay = dc.numberDisplay("#waxii");	
		var  waxiiiDisplay = dc.numberDisplay("#waxiii");	
		var  waxivDisplay = dc.numberDisplay("#waxiv");	
		var  waxvDisplay = dc.numberDisplay("#waxv");	
		var  waxviDisplay = dc.numberDisplay("#waxvi");	
		var  waxviiDisplay = dc.numberDisplay("#waxvii");	
		var  waxviiiDisplay = dc.numberDisplay("#waxviii");	
		var  waxvixDisplay = dc.numberDisplay("#waxvix");	
		var  waxxDisplay = dc.numberDisplay("#waxx");	
		var  waxxiDisplay = dc.numberDisplay("#waxxi");	
		//Groups
		var  avdDimGroup = avdDim.group().reduceSum(function(d) {return d.reg_vareposter;});
		var  sisgDimGroup = sisgDim.group().reduceSum(function(d) {return d.reg_vareposter;});
		var  typeDimGroup = typeDim.group().reduceSum(function(d) {return d.reg_vareposter;});
		var  edimDimGroup = edimDim.group().reduceSum(function(d) {return d.reg_vareposter;});
		var  inputTypeDimGroup = inputTypeDim.group().reduceSum(function(d) {return d.reg_vareposter;});
		var  openDaysDimGroup = openDaysDim.group().reduceSum(function(d) {return d.reg_vareposter;});
		var  avsenderLandDimGroup = avsenderLandDim.group().reduceSum(function(d) {return d.reg_vareposter;});
		//Group reduce
	    var dateDimGroup =  dateDim.group().reduce(   
	            /* callback for when data is added to the current filter results */
	            function (p, v) {
	                ++p.count;
	                p.sum_reg_vareposter += v.reg_vareposter;   
	                p.sum_off_vareposter  += v.off_vareposter;    
	                return p;
	            },
	            /* callback for when data is removed from the current filter results */
	            function (p, v) {
	                --p.count;
	                p.sum_reg_vareposter -= v.reg_vareposter;   
	                p.sum_off_vareposter -= v.off_vareposter;   
	                return p;
	            },
	            /* initialize p */
	            function () {
	                return {
	                    count: 0,
	                    sum_reg_vareposter: 0,
	                    sum_off_vareposter: 0
	                };
	            }
	    );  
		
	    var monthDimGroup =  monthDim.group().reduce(   
	            function (p, v) {
	                ++p.count;
	                p.sum_reg_vareposter += v.reg_vareposter;   
	                p.sum_off_vareposter  += v.off_vareposter;     
	                return p;
	            },
	            function (p, v) {
	                --p.count;
	                p.sum_reg_vareposter -= v.reg_vareposter;   
	                p.sum_off_vareposter  -= v.off_vareposter;     
	                return p;
	            },
	            function () {
	                return {
	                    count: 0,
	                    sum_reg_vareposter: 0,
	                    sum_off_vareposter: 0
	                };
	            }
	    );  	
		
	    var omsetningsGroup =  tollAllDim.group().reduce(  
	            /* callback for when data is added to the current filter results */
	            function (p, v) {
	                ++p.count;
	                p.sum_reg_vareposter += v.reg_vareposter;   
	                p.sum_off_vareposter  += v.off_vareposter;
	                p.wai += v.wai;
	                p.waii += v.waii;
	                p.waiii += v.waiii;
	                p.wav += v.wav;
	                p.waiv += v.waiv;
	                p.wavi += v.wavi;
	                p.wavii += v.wavii;
	                p.waviii += v.waviii;
	                p.waix += v.waix;
	                p.wax += v.wax;
	                p.waxi += v.waxi;
	                p.waxii += v.waxii;
	                p.waxiii += v.waxiii;
	                p.waxiv += v.waxiv;
	                p.waxv += v.waxv;
	                p.waxvi += v.waxvi;
	                p.waxvii += v.waxvii;
	                p.waxviii += v.waxviii;
	                p.waxvix += v.waxvix;
	                p.waxx += v.waxx;
	                p.waxxi += v.waxxi;
	                return p;
	            },
	            /* callback for when data is removed from the current filter results */
	            function (p, v) {
	                --p.count;
	                p.sum_reg_vareposter -= v.reg_vareposter; 
	                p.sum_off_vareposter -= v.off_vareposter;   
	                p.wai -= v.wai;
	                p.waii -= v.waii;
	                p.waiii -= v.waiii;
	                p.wav -= v.wav;
	                p.waiv -= v.waiv;
	                p.wavi -= v.wavi;
	                p.wavii -= v.wavii;
	                p.waviii -= v.waviii;
	                p.waix -= v.waix;
	                p.wax -= v.wax;
	                p.waxi -= v.waxi;
	                p.waxii -= v.waxii;
	                p.waxiii -= v.waxiii;
	                p.waxiv -= v.waxiv;
	                p.waxv -= v.waxv;
	                p.waxvi -= v.waxvi;
	                p.waxvii -= v.waxvii;
	                p.waxviii -= v.waxviii;
	                p.waxvix -= v.waxvix;
	                p.waxx -= v.waxx;
	                p.waxxi -= v.waxxi;
	                return p;
	            },
	            /* initialize p */
	            function () {
	                return {
	                    count: 0,
	                    sum_reg_vareposter: 0,
	                    sum_off_vareposter: 0,
	                    wai : 0,
	                    waii : 0,
	                    waiii : 0,
	                    wav : 0,
	                    waiv : 0,
	                    wavi : 0,
	                    wavii : 0,
	                    waviii : 0,
	                    waix : 0,
	                    wax : 0,
	                    waxi : 0,
	                    waxii : 0,
	                    waxiii : 0,
	                    waxiv : 0,
	                    waxv : 0,
	                    waxvi : 0,
	                    waxvii : 0,
	                    waxviii : 0,
	                    waxvix : 0,
	                    waxx : 0,
	                    waxxi : 0
	                };
	            }
	    );  
	    
		typeChart
		    .width(300)
		    .height(300)
		    .dimension(typeDim)
		    .group(typeDimGroup)
		    .externalRadiusPadding(50)
		    .innerRadius(30)
		    .emptyTitle('tom')
		    .title(function (d) {
			  	var percentage;
			  	percentage = d.value / d3.sum(typeDimGroup.all(), function(d){ return d.value; })
	            return [
	                d.key + ':',
	                percentageFormat(percentage)
	            ].join('\n');	
			});	
	
		inputTypeChart 
		    .width(300)
		    .height(300)
		    .dimension(inputTypeDim)
		    .group(inputTypeDimGroup)
		    .externalRadiusPadding(50)
		    .innerRadius(30)
		    .emptyTitle('tom')
		    .title(function (d) {
			  	var percentage;
			  	percentage = d.value / d3.sum(inputTypeDimGroup.all(), function(d){ return d.value; })
	            return [
	                d.key + ':',
	                percentageFormat(percentage)
	            ].join('\n');	
		});			

		openDaysChart 
		    .width(300)
		    .height(300)
		    .dimension(openDaysDim)
		    .group(openDaysDimGroup)
		    .externalRadiusPadding(50)
		    .legend(dc.legend().y(10).itemHeight(8).gap(3))
		    .slicesCap(25)
		    .innerRadius(30)
		    .emptyTitle('tom')
		    .title(function (d) {
			  	var percentage;
			  	percentage = d.value / d3.sum(openDaysDimGroup.all(), function(d){ return d.value; })
	            return [
	                d.key + ':',
	                percentageFormat(percentage)
	            ].join('\n');	
		});			

		avsenderLandChart 
			.width(300)
			.height(300)
			.dimension(avsenderLandDim)
			.group(avsenderLandDimGroup)
			.externalRadiusPadding(50)
			.legend(dc.legend().y(10).itemHeight(8).gap(3))
			.slicesCap(25)
			.innerRadius(30)
			.emptyTitle('tom')
			.title(function (d) {
			  	var percentage;
			  	percentage = d.value / d3.sum(avsenderLandDimGroup.all(), function(d){ return d.value; })
			    return [
			        d.key + ':',
			        percentageFormat(percentage)
			    ].join('\n');	
		});		

		avdChart
		    .width(300)
		    .height(300)
		    .dimension(avdDim)
		    .group(avdDimGroup)
		    .slicesCap(25)
		    .innerRadius(30)
		    .renderLabel(true)
		    .externalRadiusPadding(50)
		    .legend(dc.legend().y(10).itemHeight(8).gap(3))
			.on('renderlet', function (chart) {
					var legends = chart.selectAll(".dc-legend-item");
			   		legends
			   			.append('title').text(function (d) {
						  	var percentage;
						  	percentage = d.data / d3.sum(avdDimGroup.all(), function(d){ return d.value; })
				            return [
				                d.name + ':',
				                getAvdelingDesc(d.name),     
				                percentageFormat(percentage)
				            ].join('\n');	
			   			});
             })	
   			.othersLabel("Andre")     
   			.emptyTitle('tom')
	 		.title(function (d) {
			  	var percentage;
			  	percentage = d.value / d3.sum(avdDimGroup.all(), function(d){ return d.value; })
	            return [
	                d.key + ':',
	                getAvdelingDesc(d.key),
	                percentageFormat(percentage)
	            ].join('\n');	
			});	

		sisgChart
		    .width(300)
		    .height(300)
		    .slicesCap(25)
		    .innerRadius(30)
		    .externalRadiusPadding(50)
		    .legend(dc.legend().y(10).itemHeight(8).gap(3))
		    .dimension(sisgDim)
		    .group(sisgDimGroup)
			.on('renderlet', function (chart) {
					var legends = chart.selectAll(".dc-legend-item");
			   		legends
			   			.append('title').text(function (d) {
						  	var percentage;
						  	percentage = d.data / d3.sum(sisgDimGroup.all(), function(d){ return d.value; })
				            return [
				                d.name + ':',
				                getSignaturDesc(d.name),     
				                percentageFormat(percentage)
				            ].join('\n');	
			   			});
             })	
		    .emptyTitle('tom')
		    .othersLabel("Andre") 
		    .title(function (d) {
			  	var percentage, desc;
			  	percentage = d.value / d3.sum(sisgDimGroup.all(), function(d){ return d.value; })
	            return [
	                d.key + ':',
	                getSignaturDesc(d.key),     
	                percentageFormat(percentage)
	            ].join('\n');	
			});	
	
		edimChart
		    .width(300)
		    .height(300)
		    .slicesCap(25)
		    .innerRadius(30)
		    .externalRadiusPadding(50)
		    .legend(dc.legend().y(10).itemHeight(8).gap(3))
		    .dimension(edimDim)
		    .group(edimDimGroup)
			.renderTitle(true)
			.on('renderlet', function (chart) {
					var legends = chart.selectAll(".dc-legend-item");
			   		legends
			   			.append('title').text(function (d) {
							var name, desc,percentage ;
							percentage = d.data / d3.sum(edimDimGroup.all(), function(d){ return d.value; })
							if (d.name == 'OK') {
								name = 'OK';
								desc = '';
							}  else if (d.name == 'Andre') {
								name = 'Andre';
								desc = '';
							}  else {
								var trailingThree = d.name.slice(-3);
								if (isNaN(trailingThree)) { 
									 name = d.name.slice(0,2);
									 desc = d.name.slice(2,d.name.lenght);
						        } else {
						        	 name = d.name;
									 desc =  getMerknadDesc(trailingThree);	        	 
						        }
							}
				            return [
				                name + ':',
				                desc,
				                percentageFormat(percentage)
				            ].join('\n');				   			
				        });					
			 })
			.othersLabel("Andre")
			.emptyTitle('tom')
			.title(function (d) {
				var key, desc,percentage ;
				percentage = d.value / d3.sum(edimDimGroup.all(), function(d){ return d.value; })
				if (d.key == 'OK') {
					key = 'OK';
					desc = '';
				} else {
					var trailingThree = d.key.slice(-3);
					if (isNaN(trailingThree)) {  //key is a shapeshifter
						 key = d.key.slice(0,2);
						 desc = d.key.slice(2,d.key.lenght);
			        } else {
			        	 key = d.key;
						 desc =  getMerknadDesc(trailingThree);	        	 
			        }
				}
	            return [
	                key + ':',
	                desc,
	                percentageFormat(percentage)
	            ].join('\n');			
			});	    
		
		antallDisplay
		     .group(omsetningsGroup)  
		     .formatNumber(d3.format(".g"))
			 .valueAccessor(function (p) {
				 return p.value.count;
			  });
		
		antallreg_vareposterDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.valueAccessor(function (p) {
					return p.value.sum_reg_vareposter;
			});
		
		antalloff_vareposterDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.valueAccessor(function (p) {
					return p.value.sum_off_vareposter;
			});	

		waiDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.wai;
			});			

		waiiDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.waii;
			});	

		waiiiDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.waiii;
			});	

		waivDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.waiv;
			});	
		
		wavDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.wav;
			});	

		waviDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.wavi;
			});			

		waviiDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.wavii;
			});			

		waviiiDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.waviii;
			});			

		waixDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.waix;
			});			

		waxDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.wax;
			});		
		
		waxiDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.waxi;
			});		

		waxiiDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.waxii;
			});		

		waxiiiDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.waxiii;
			});	

		waxivDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.waxiv;
			});			

		waxvDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.waxv;
			});				

		waxviDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.waxvi;
			});			

		waxviiDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.waxvii;
			});			

		waxviiiDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.waxviii;
			});			

		waxvixDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.waxvix;
			});			
		
		waxxDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.waxx;
			});	

		waxxiDisplay
			.group(omsetningsGroup)  
			.formatNumber(d3.format(".g"))
			.html({
			     one:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     some:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">%number</span>',
			     none:'<span style=\"color:steelblue; font-size: 14px; vertical-align: top;\">-</span>'})		
			.valueAccessor(function (p) {
					return p.value.waxxi;
			});	
		
		varuposterChart
			.width(1200)
			.height(500)
			.dimension(monthDim)   
			.group(monthDimGroup) 
			.margins({top: 40, right: 10, bottom: 40, left: 80})
			.x(d3.scale.ordinal())
			.xUnits(dc.units.ordinal)   
			.yAxisPadding('10%')
			.yAxisLabel("Antall vareposter")
			.xAxisLabel("Måned")      
			.elasticY(true)
			.elasticX(true)
			.mouseZoomable(false)  //true is not working in this context ??
			.legend( dc.legend().x(1020).y(0).itemHeight(10).gap(10).legendText(function(d, i) { 
						if (i == 2) {
							return "Antall registrerte vareposter";
						}
						if (i==1) {
							return "Antall offisielle vareposter";
						}
						if (i==0) {
							return "Antall fortollinger";
						}
					}) 
			)
			.renderHorizontalGridLines(true)
			.renderTitle(true)
			.title(function (d) {
				var diffPercentage = ((d.value.sum_reg_vareposter - d.value.sum_off_vareposter )  / d.value.sum_reg_vareposter );
			   	 return [
			   		 d.key.substr(3) + ':',
			   			'Fortollinger: ' + d.value.count,
			   		    'Offisielle varuposter: ' + d.value.sum_off_vareposter,
			            'Registrerte varuposter: ' + d.value.sum_reg_vareposter ,
			            'Sammenslåtte varuposter: ' + percentageFormat(diffPercentage)
			        ].join('\n');
			})	
			.group(monthDimGroup, 'fortollinger') 
	        //Antall fortollinger
	       .valueAccessor(function (d) {
					return d.value.count; 
			}) 
			//Antall off. varuposter
			.stack(monthDimGroup,'off_vp' ,function (d) {
	         	return d.value.sum_off_vareposter;  //100
	        })
	        //Antall off. varuposter
	        .stack(monthDimGroup, 'reg_vp',function (d) {
	        	var diffRegAndOff =  d.value.sum_reg_vareposter - d.value.sum_off_vareposter;   //ex. 100-80=20
	        	return diffRegAndOff;
	        })
			.on('pretransition', function (chart) {
			    chart.selectAll("g rect").style("fill", function (d) {
			        return colorMap[d.layer];
			    });
			    chart.selectAll('g.dc-legend-item rect').style('fill', function (d) {
			        return colorMap[d.name];
			    });
			    chart.selectAll("g rect.deselected").style("fill", function (d) {
			        return '#ccc';
			    });                  
			})
			.xAxis().tickFormat(function(d) { 
				return d.substr(3); 
			});

	   	d3.selectAll('a#all').on('click', function () {
	     	dc.filterAll();
	     	dc.renderAll();
	   	});
	
		d3.selectAll('a#type').on('click', function () {
			typeChart.filterAll();
			dc.redrawAll();
		});
		d3.selectAll('a#avd').on('click', function () {
			avdChart.filterAll();
			dc.redrawAll();
		});	 
		d3.selectAll('a#sisg').on('click', function () {
			sisgChart.filterAll();
			dc.redrawAll();
		});	
		d3.selectAll('a#edim').on('click', function () {
			edimChart.filterAll();
			dc.redrawAll();
		});	
		d3.selectAll('a#inputtype').on('click', function () {
			inputTypeChart.filterAll();
			dc.redrawAll();
		});			
		d3.selectAll('a#opendays').on('click', function () {
			openDaysChart.filterAll();
			dc.redrawAll();
		});		
		d3.selectAll('a#avsenderland').on('click', function () {
			avsenderLandChart.filterAll();
			dc.redrawAll();
		});	
		
		d3.selectAll('a#varuposter').on('click', function () {
			varuposterChart.filterAll();
			dc.redrawAll();
		});	
		
		d3.selectAll('a#avdfilter').on('click', function () {
			avdChart.filter(jq('#avd-filter').val());
			dc.redrawAll();
			jq('#avd-filter').val("");
		});		
	
		d3.selectAll('a#merknadfilter').on('click', function () {
			edimChart.filter(jq('#merknad-filter').val());
			dc.redrawAll();
			jq('#merknad-filter').val("");
		});		
		
		dataCount
		      .dimension(toll)
		      .group(all)
			  .html({
	            some: '<strong>%filter-count</strong> valgt ut av <strong>%total-count</strong> fortollinger' +
	                ' | <a href=\'javascript:dc.filterAll(); dc.renderAll();\'>tilbakestill alt</a>',
	            all: 'Alle <strong>%total-count</strong> fortollinger for utvalg. Vennligst klikk på grafen for å bruke filtre.'
	          });      
		      
		d3.select('#download').on('click', function() {
			var today = new Date();
	        var data = tollAllDim.top(Infinity);
	        var saveData = data.map(function(obj) {
	            return {avdeling: obj.avdeling, deklarasjonsnr: obj.deklarasjonsnr, reg_vareposter: obj.reg_vareposter, 
	            		off_vareposter: obj.off_vareposter, registreringsdato: obj.registreringsdato,
	            		signatur: obj.signatur, mottaker: obj.mottaker,  avsender: obj.avsender, ext_referanse: obj.extern_referanse,merknad: obj.edim};
	        });
	       
			var blob = new Blob([d3.tsv.format(saveData)], {type: "application/ms-excel;charset=utf-8"});  // text/csv
			
	        saveAs(blob, 'fortolling_no-' + today + '.xls');
	    });	
	
		var dataTable;
	    dcDataTable = dc.dataTable('#data-table');
		dcDataTable
		    .dimension(tollAllDim) 
		    .group(function (d) { return 'dc.js insists on putting a row here so I remove it using JS'; })
		    .size(Infinity) 
		    .columns([
			  function (d) { return d.deklarasjonsnr; },
		      function (d) { return d.avdeling; },
		      function (d) { return d.reg_vareposter; },
		      function (d) { return d.off_vareposter; },
		      function (d) { return d.registreringsdato; },
		      function (d) { return d.signatur ; },
		      function (d) { return d.mottaker ; },
		      function (d) { return d.avsender ; }, 
		      function (d) { return d.type ; },
		      function (d) { return d.extern_referanse ; },
		      function (d) { return d.edim ; }
		    ])
		    .on('renderlet', function (table) {
		      	// each time table is rendered remove nasty extra row dc.js insists on adding
		     	table.select('tr.dc-table-group').remove();
				if (jq( '#detailsTable' ).is(":visible")) {	
					console.log("detailsTable is visible, doing setupDataTable on renderlet.");
 					dataTable = setupDataTable();
  				} 	      	
		      	
	 		});	    
		
		function renderDataTable() {
		    console.log("renderDataTable..");
			dcDataTable.render();
    		dataTable = setupDataTable();
		}

    	
		function setupDataTable() {
			console.log("setupDataTable..");
			var dataTable2 =jq('#data-table').DataTable({
				"dom" : '<"top">t<"bottom"f><"clear">',
				"scrollY" : "200px",
				"scrollCollapse" : false,
				"columns": [
		            { "data": "deklarasjonsnr" },
		            { "data": "avdeling" },
		            { "data": "reg_vareposter" },
		            { "data": "off_vareposter" },		            
		            { "data": "registreringsdato" },
		            { "data": "signatur" },
		            { "data": "mottaker" },
		            { "data": "avsender" },
		            { "data": "type" },
		            { "data": "extern_referanse" },
		            { "data": "edim" }
		        ],			
				destroy : true,
				"columnDefs" : [ 
					{
						"targets" : 0,
					    "render": function ( data, type, row, meta ) {
					    	if (row.type == 'I') {
						    	var url= baseImportUrl+'&avd='+row.avdeling+'&opd='+row.deklarasjonsnr+'&sysg=${user.signatur}';
						    	var href = '<a href="#"'+ ' onclick="javascript:popItUp(\''+url+'\');"'+'>'+data+'</a>';
						    	return href;
					    	} else if (row.type == 'E') {
						    	var url= baseExportUrl+'&avd='+row.avdeling+'&opd='+row.deklarasjonsnr+'&sysg=${user.signatur}';
						    	var href = '<a href="#"'+ ' onclick="javascript:popItUp(\''+url+'\');"'+'>'+data+'</a>';
						    	return href;
					    	} else {
					    		alert('System error: Import/Export-type må vare I eller E.');
					    	}
					    }
					}
				],
				"lengthMenu" : [ 75, 100 ],
				"language": {
					"url": getLanguage(lang)
		        }
			}); 	
			
			return dataTable2;
			
		}

		tolldataSize = toll.size();
		  
		dc.renderAll(); 
		
		jq('#showTable' ).unbind('click').click(function() {  //to avoid multiple definition, hence running load_data() over again.
		//jq('#showTable' ).click(function() {
			if (jq( '#detailsTable' ).is(":visible")) {
				     console.log("detailsTable is visible");
				  } else {
					  console.log("detailsTable is NOT visible, calling renderDataTable();");
					  renderDataTable();
				}
			
			jq( '#detailsTable' ).toggle("slow");
			
		});			
		
		jq(document).ready(function() {
			console.log("jq(document).ready....");
 			jq('#detailsTable').toggle(false); //default hide
			jq('#toggleArea').toggle(true); 
		});
		
		jq.unblockUI();

	});
	


}  //function load_data()
 
jq(document).ready(function() {
	jq('select#selectVarekode').selectList();
	jq('select#selectSign').selectList();
	jq('select#selectAvd').selectList();
	jq('#detailsTable').toggle(false); //default hide
	jq('#toggleArea').toggle(false); //default hide
	
	
});	


window.addEventListener('error', function (e) {
	  var error = e.error;
	  jq.unblockUI();
	  console.log("Event e",e);

	  if (e instanceof TypeError) {
			//what todo  
	  } else {
		  alert('Uforutsett fel har intreffet. Vennligst gør forfrisk på fane Fortolling(NO).');
	  }
	  
});
</script>

<table id="fullTable" width="100%"  cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td>
		<%-- tab container component --%>
		<table style="border-collapse:initial;" width="100%"  cellspacing="0" border="0" cellpadding="0">
			<tr height="2"><td></td></tr>
				<tr height="25"> 
					<td width="20%" valign="bottom" class="tab" align="center" nowrap>
						<font class="tabLink">&nbsp;Fortolling(NO)</font>
						<img  style="vertical-align:middle;" src="resources/images/list.gif" border="0" alt="general list">
					</td>

					<td width="80%" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>	
	
				</tr>
		</table>
		</td>
	</tr>

	<tr>
		<td>
			<!--  
			The Bootstrap 3 grid system has four tiers of classes: xs (phones), sm (tablets), md (desktops), and lg (larger desktops). 
			You can use nearly any combination of these classes to create more dynamic and flexible layouts.
			Each tier of classes scales up, meaning if you plan on setting the same widths for xs and sm, you only need to specify xs.
			-->
	 	 <table width="100%" class="tabThinBorderWhite" border="0" cellspacing="0" cellpadding="0">
	 	    <tr height="20">
		 	    <td width="2%">&nbsp;</td>
		 	    <td>&nbsp;
				<div class="container-fluid">
				  <div class="row">
	  				
					<div class="col-md-1 text12">
						<font class="text12">Avdeling:</font><br>
		        		<select class="inputTextMediumBlue" name="selectAvd" id="selectAvd" multiple="multiple" title="-velg-">
		 				  	<c:forEach var="record" items="${model.avdList}" >
		 				  		<option value="${record.koakon}">${record.koakon}</option>
							</c:forEach>  
						</select>						
					</div>	
						
					<div class="col-md-1 text12">
						<font class="text12">Signatur:</font><br>
		        		<select class="inputTextMediumBlue" name="selectSign" id="selectSign" multiple="multiple" title="-velg-">
	 						<c:forEach var="record" items="${model.signatureList}" >
		 				  		<option value="${record.ksisig}">${record.ksisig}</option>
							</c:forEach>   
						</select>					
					</div>
	
					<div class="col-md-1 text12">
						<font class="text12">Fra dato:</font><br>
						<input type="text" class="inputTextMediumBlueMandatoryField" name="selectFradato" id="selectFradato" size="9" maxlength="8">
	  				</div>	 	
	
					<div class="col-md-1 text12">
						<font class="text12">Til dato:</font><br>
						<input type="text" class="inputTextMediumBlueMandatoryField" name="selectTildato" id="selectTildato" size="9" maxlength="8">
	  				</div>	

					<div class="col-md-1 text12 text-nowrap">
  		    			<font class="text12">Mottaker:</font><br>
						<input type="text" class="inputText" name="selectKundenr" id="selectKundenr" size="9" maxlength="8" >  	
						<a tabindex="-1" id="kundenrLink">
							<img style="cursor:pointer;vertical-align: middle;" src="resources/images/find.png" width="14px" height="14px" border="0">
						</a>&nbsp;	
					</div> 	

					<div class="col-md-2 text12">
  		    			<font class="text12">Avsender:</font><br>
						<input type="text" class="inputText" name="selectKundenr_avs" id="selectKundenr_avs" size="9" maxlength="8" >  	
						<a tabindex="-1" id="kundenr_avsLink">
							<img style="cursor:pointer;vertical-align: middle;" src="resources/images/find.png" width="14px" height="14px" border="0">
						</a>&nbsp;	
					</div> 

	  		    	<div class="col-md-5" align="right">
	  		    		<br>
	   	              	<button class="inputFormSubmit" onclick="load_data()" autofocus>Hent data</button> 
					</div>	
	
				  </div>
  
	  			  <div class="padded-row-small">&nbsp;</div>

<div id="toggleArea">

				  <div class="row">
					<div class="col-md-12">
					  <div class="row">
						<div class="col-md-4 padded" id="antall" align="center" style="background: #69c; color: #fff; ">
						    <h3 class="text14">Antall fortollinger</h3>
						</div>
				        <div class="col-md-4 padded" id="antalloff_vareposter" align="center" style="background: #f19411; color: #fff; ">
				          <h3 class="text14">Antall offisielle vareposter</h3>
				        </div>  
				        <div class="col-md-4 padded" id="antallreg_vareposter" align="center" style="background: #9c6; color: #fff; ">
				           <h3 class="text14">Antall registrerte vareposter</h3>
				        </div>  
					  </div> 	
					</div>		
				  </div>
	
				  <div class="row">
					   <div class="col-md-12">
					      <h3 class="text14" style="border-bottom-style: solid; border-width: 1px;">&nbsp;</h3>
					   </div>
				  </div>	
	
				  <div class="row">
				    <div class="col-md-12">
				      <div class="row">
						 <div class="col-md-12 dc-chart" id="chart-varuposter"> 
						  	<h3 class="text12">Vareposter</h3>
						    <span class="reset" style="display: none;">filter: <span class="filter"></span></span>
						    <a class="reset" id="varuposter" style="display: none;"> - <i>tilbakestill filter</i></a>
						    <div class="clear"></div>
						 </div>  
				      </div>
				    </div>
				  </div>
				  
				  <div class="row">
				    <div class="col-md-12"></div>
				  </div>
	
				  <div class="row">
					   <div class="col-md-12">
					      <h3 class="text14" style="border-bottom-style: solid; border-width: 1px;">&nbsp;</h3>
					   </div>
				  </div>	
	
				  <div class="horizontal-scroll-group">
				   <div class="row text-center">
				        <div class="col-md-3" id="chart-ring-edim">
				        	<h3 class="text12">Merknader
					        	<font class="text11">&nbsp;&nbsp;&nbsp;merknad:&nbsp;<input id="merknad-filter" type="text" size="5"/>  </font>
					        	 <a id="merknadfilter">legg til</a>	
				        	 </h3>
						    <span class="reset" style="display: none;">filter: <span class="filter"></span></span>
						    <a class="reset" id="edim" style="display: none;"> - <i>tilbakestill filter</i></a>
						    <div class="clear"></div>	
				        </div> 	

				        <div class="col-md-3" id="chart-ring-sisg">
				        	<h3 class="text12" align="center">Signatur</h3>
						    <span class="reset" style="display: none;">filter: <span class="filter"></span></span>
						    <a class="reset" id="sisg" style="display: none;"> - <i>tilbakestill filter</i></a>
						    <div class="clear"></div>	
				        </div> 

					     <div class="col-md-3" id="chart-ring-avd">
				        	<h3 class="text12" align="center">Avdeling
					        	 <font class="text11">&nbsp;&nbsp;&nbsp;avd:&nbsp;<input id="avd-filter" type="text" size="5"/>  </font>
					        	 <a id="avdfilter">legg til</a>	
				        	</h3>
						    <span class="reset" style="display: none;">filter: <span class="filter"></span></span>
						    <a class="reset" id="avd" style="display: none;"> - <i>tilbakestill filter</i></a>
						    <div class="clear"></div>		
				     	</div>
	
						<div class="col-md-3" id="chart-ring-opendays">
							<h3 class="text12" align="center">Antall dager</h3>
						    <span class="reset" style="display: none;">filter: <span class="filter"></span></span>
						    <a class="reset" id="opendays" style="display: none;"> - <i>tilbakestill filter</i></a>
						    <div class="clear"></div>	
				        </div>

						<div class="col-md-3" id="chart-ring-avsenderland">
							<h3 class="text12" align="center">Avsender land</h3>
						    <span class="reset" style="display: none;">filter: <span class="filter"></span></span>
						    <a class="reset" id="avsenderland" style="display: none;"> - <i>tilbakestill filter</i></a>
						    <div class="clear"></div>	
				        </div>

						<div class="col-md-3" id="chart-ring-type">
						 	<h3 class="text12" align="center">Import / Eksport</h3>
						    <span class="reset" style="display: none;">filter: <span class="filter"></span>
						    </span>
						    <a class="reset" id="type" style="display: none;"> - <i>tilbakestill filter</i></a>
  						    <div class="clear"></div>					 	
				        </div>	

						<div class="col-md-3" id="chart-ring-inputtype">
						 	<h3 class="text12" align="center">Manuell / EDI</h3>
						    <span class="reset" style="display: none;">filter: <span class="filter"></span></span>
						    <a class="reset" id="inputtype" style="display: none;"> - <i>tilbakestill filter</i></a>
 							<div class="clear"></div>			
				        </div>

				    </div>
				  </div>  
  
   				  <div class="row">
						<div class="col-md-12">
						   <h3 class="text12">Avsnitt</h3>
					   </div>
				  </div>  				  
			      <div class="row">
			        <div class="col-md-3">
			            <div class="row">
			                <div class="col-md-2">&nbsp;</div>
			                <div class="col-md-2" id="wai" align="center">
			                     <h3 class="text12">I</h3></div>
			                <div class="col-md-2" id="waii" align="center">
			                     <h3 class="text12">II</h3></div>
			                <div class="col-md-2" id="waiii" align="center">
			                     <h3 class="text12">III</h3></div>
			                <div class="col-md-2" id="waiv" align="center">
			                     <h3 class="text12">IV</h3></div>
			                 <div class="col-md-2" id="wav" align="center">
			                     <h3 class="text12">V</h3></div>                   
			            </div>
			        </div>
			        <div class="col-md-3">
			            <div class="row">
			                <div class="col-md-2" id="wavi" align="center">
			                     <h3 class="text12">VI</h3></div>  
			                <div class="col-md-2" id="wavii" align="center">
			                    <h3 class="text12">VII</h3></div>
			                <div class="col-md-2" id="waviii" align="center">
			                    <h3 class="text12">VIII</h3></div>
			                <div class="col-md-2" id="waix" align="center">
			                    <h3 class="text12">IX</h3></div>
			                <div class="col-md-2" id="wax" align="center">
			                    <h3 class="text12">X</h3></div>
			                 <div class="col-md-2" id="waxi" align="center">
			                    <h3 class="text12">XI</h3></div>                   
			            </div>
			        </div>
			        <div class="col-md-3">
			            <div class="row">
			                <div class="col-md-2" id="waxii" align="center">
			                    <h3 class="text12">XII</h3></div>  
			                <div class="col-md-2" id="waxiii" align="center">
			                    <h3 class="text12">XIII</h3></div>
			                <div class="col-md-2" id="waxiv" align="center">
			                    <h3 class="text12">XIV</h3></div>
			                <div class="col-md-2" id="waxv" align="center">
			                    <h3 class="text12">XV</h3></div>
			                <div class="col-md-2" id="waxvi" align="center">
			                    <h3 class="text12">XVI</h3></div>
				            <div class="col-md-2" id="waxvii" align="center">
			                    <h3 class="text12">XVII</h3></div> 			                    
			            </div>
			        </div>
			        <div class="col-md-3">
			            <div class="row">
				            <div class="col-md-2" id="waxviii" align="center">
			                    <h3 class="text12">XVIII</h3></div> 	
			                <div class="col-md-2" id="waxvix" align="center">
			                    <h3 class="text12">XIX</h3></div>
			                <div class="col-md-2" id="waxx" align="center">
			                    <h3 class="text12">XX</h3></div>
			                <div class="col-md-2" id="waxxi" align="center">
			                    <h3 class="text12">XXI</h3></div>
			                <div class="col-md-4">&nbsp;</div>
			            </div>
			        </div>
			      </div>	
	
 				  <div class="row">
				    <div class="col-md-12" id="data-count"></div>
				  </div>  
    
				  <div class="row">
					<div class="col-md-12">
						<h3 class="text14" style="border-bottom-style: solid; border-width: 1px;">&nbsp;</h3>
					</div>
				  </div>	
   
				  <div class="row">
					<div class="col-md-12" id="showTable">
  						<h3><a id="showTable"><font class="text12">Vis Fortollinger, filtrert</font>
  						&nbsp;<img onMouseOver="showPop('vis_fortoll_info');" onMouseOut="hidePop('vis_fortoll_info');" width="12px" height="12px" src="resources/images/info3.png">
		 				</a></h3>
		 				<div class="text11" style="position: relative;" align="left">
		 				<span style="position:absolute; top:2px; width:250px;" id="vis_fortoll_info" class="popupWithInputText text11"  >
				           		<b>
				           			Vis Fortollinger, filtrert
				 	          	</b><br><br>
				           		Bruk detaljer dersom det finnes intresse att se spesifikke fortollinger.
				           		Hvis et stort antall fortollinger er utvalgt, ytelse kan oppleves som mindre bra.
								<br><br>
						</span>
						</div>
					</div>
				  </div>	

				  <div class="row" id="detailsTable">
				    <div class="col-md-12">
				       <table class="display" id="data-table" cellspacing="0" width="100%">
				        <thead>
				          <tr>
				            <th>deklarasjonsnr</th>
				            <th>avdeling</th>
				            <th>reg. vareposter</th>
				            <th>off. vareposter</th>
				            <th>registreringsdato</th>
				            <th>signatur</th>
				            <th>mottaker</th>
				            <th>avsender</th>
				            <th>type</th>
				            <th>ext.referanse</th>
				            <th>merknad</th>
				          </tr>
				        </thead>

				       </table>

				      <div>
						<a href="#" id="download">
	                		<img valign="bottom" id="mainListExcel" src="resources/images/excel.gif" width="14" height="14" border="0" alt="excel">
	                		<font class="text12MediumBlue">&nbsp;Excel</font>
	 	        		</a>
  					  </div>
				    </div>
				  
				  </div>
	
				<div class="padded-row">&nbsp;</div>

</div> <!-- toggleArea -->

         		</div> <!-- container -->
		 	    </td>
	 	    </tr>
	 	 </table>
		</td>
	</tr>
</table>	
<!-- ======================= footer ===========================-->
<jsp:include page="/WEB-INF/views/footer.jsp" />
<!-- =====================end footer ==========================-->
