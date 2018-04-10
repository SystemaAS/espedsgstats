<%@ include file="/WEB-INF/views/include.jsp" %>
<!-- ======================= header ===========================-->
<jsp:include page="/WEB-INF/views/headerReportDashboard.jsp" />
<!-- =====================end header ==========================-->

<style>

fieldset { 
    display: inline-block;
    margin-right: 2px;
    padding-top: 0em;
    padding-bottom: 0em;
    padding-left: 1em;
    padding-right: 1em;
    border: 1px solid silver;
    white-space: nowrap;
}

legend {
    display: inline-block;
    width: 100%;
    padding: 0;
    margin-bottom: 0rem;
    font-size: 0rem;
    line-height: inherit;
    padding-left: 2px;
    padding-right: 30px;
    border: none; 
}


</style>



<script type="text/javascript">
"use strict";
var baseUrl = "/syjservicesbcore/syjsFAKT_DB.do?user=${user.user}";
var baseUrl = "/syjservicesbcore/syjsFAKT_DB_DW.do?user=${user.user}";

var jq = jQuery.noConflict();
var BLOCKUI_OVERLAY_MESSAGE_DEFAULT = "Vennligst vent...";

function load_data() {

	var runningUrl = baseUrl;
	var selectedYear = jq('#selectYear').val();
	var selectedYearComp = jq('#selectYearComp').val();
	var selectedAvd = jq('#selectAvd').val();
	var selectedSign = jq('#selectSign').val();
	var selectedKundenr = jq('#selectKundenr').val();
	var selectedVarekode = jq('#selectVarekode').val();
	var selectedVarekode = jq('#selectVarekode').val();
	var doExcludeVarekode = jq('#checkbox-exclude').prop('checked');

	
	runningUrl = runningUrl + "&registreringsdato="+selectedYear;
	
	console.log("selectedAvd="+selectedAvd);
	console.log("selectedSign="+selectedSign);
	console.log("selectedVarekode="+selectedVarekode);
	console.log("doExcludeVarekode="+doExcludeVarekode);
	

	if (selectedAvd != null && selectedAvd != "")	{
		runningUrl = runningUrl + "&avdelings="+selectedAvd; 
	}
	if (selectedSign != null && selectedSign != "")	{
		runningUrl = runningUrl + "&signatur="+selectedSign;
	}	
	if (selectedKundenr != "" && selectedKundenr != "")	{
		runningUrl = runningUrl + "&mottaker="+selectedKundenr;
	}
	if (selectedVarekode != null && selectedVarekode != "")	{
		runningUrl = runningUrl + "&favk="+selectedVarekode;
	}

	if (doExcludeVarekode)	{
		runningUrl = runningUrl + "&favkexcl="+doExcludeVarekode;
	}	
	console.log("runningUrl="+runningUrl); 	
	
    jq.blockUI({message : BLOCKUI_OVERLAY_MESSAGE_DEFAULT});

d3.json(runningUrl, function(error, data) {
	if (error) {
		jq.unblockUI();
		console.log("Error:"+error);
	}
		
	if (data.dtoList == '') {
		jq.unblockUI();
		alert('Ingen data på urvalg.'); 
		return "no data found";
	}	
	
	var faktData = data.dtoList;
   // console.log("faktData="+faktData);  //Tip: View i  Chrome devtool; NetWork-(mark xhr row)-Preview
 
    var fullDateFormat = d3.time.format('%Y%m%d');
    //var fullDateFormatDw = d3.time.format('%Y%m');
    var fullDateFormatDw = NO.timeFormat('%Y%m');
    var yearFormat = d3.time.format('%Y');
    var monthFormat = d3.time.format('%m');
    //var monthNameFormat = d3.time.format('%m.%b');
    
    var monthNameFormat = NO.timeFormat('%m.%b');
    var percentageFormat = d3.format('.2%');
    var numberFormat = d3.format(",.0f")
   
    // normalize/parse data
	 _.each(faktData, function(d) {
	  d.date = fullDateFormatDw.parse(d.registreringsdato);
	  d.year = yearFormat(d.date);
	  d.month = monthNameFormat(d.date);
	 // d.tupro = d.tupro; OK, ta bort
	 // d.tubilk = d.tubilk;
	  d.bilkod = d.bilkod;
	  d.avdeling = d.avdeling;
	 // d.faopd = d.faopd; OK ta bort
	 // d.fabeln = +d.fabeln;
	  d.sumlin = +d.sumlin;
	  d.belop = +d.belop;
	  d.registreringsdato = +d.registreringsdato; 
	 // d.fakda = d.fakda;
	 // d.mottaker =  d.mottaker;
	 // d.fask = d.fask;
	  d.intext = d.intext;
	 // d.favk = d.favk;
	  d.varek = d.varek;
	});
 
	// set crossfilter. Crossfilter runs in the browser and the practical limit is somewhere around half a million to a million rows of data.
	var fakt = crossfilter(faktData);	
	var  all = fakt.groupAll();
	
	//Dimensions
	var  faktAllDim = fakt.dimension(function(d) {return d;});	 
	var  dateDim  = fakt.dimension(function(d) {
		var year = yearFormat(d.date);
		//console.log("year",year);  //http://jsfiddle.net/gordonwoodhull/uy7dqwr5/29/
		if (year == selectedYear) {
			return d.date;			
		}

	});

	var  monthDim = fakt.dimension(function (d) {return d.month;});	
	var  avdDim  = fakt.dimension(function(d) {return d.avdeling;});
	var  tubilkDim  = fakt.dimension(function(d) {return d.bilkod;});
	var  favkDim  = fakt.dimension(function(d) {return d.varek;});
    var  faskDim = fakt.dimension(function (d) {
	        var fask = d.intext;
	        if (fask == 'I') {
	            return 'Intern';
	        } else {
	            return 'Extern';
	        } 
    });
	
	//Groups
	var  avdDimGroup = avdDim.group().reduceSum(function(d) {return d.belop;});
	var  tubilkDimGroup = tubilkDim.group().reduceSum(function(d) {return d.belop;});
	var  favkDimGroup = favkDim.group().reduceSum(function(d) {return d.belop;});
	var  faskDimGroup = faskDim.group().reduceSum(function(d) {return d.belop;});
	//Charts 
	var  avdChart   = dc.pieChart('#chart-ring-avd');
	var  tubilkChart   = dc.pieChart('#chart-ring-tubilk');
	var  favkChart   = dc.pieChart('#chart-ring-favk');
	var  faskChart   = dc.pieChart('#chart-ring-fask');
	var  compositeChart = dc.compositeChart("#chart-composite");
	var  dataCount = dc.dataCount('#data-count')	 
	var  omsetningsDisplay = dc.numberDisplay("#omsetning");	
	var  kostnadsDisplay = dc.numberDisplay("#kostnad");	
	var  resultatDisplay = dc.numberDisplay("#resultat");	
	var  dbDisplay = dc.numberDisplay("#db");	

	var mindate = dateDim.bottom(1)[0].date;
	var maxdate = dateDim.top(1)[0].date;
	
	/*
	var omsKostLineChart = dc.lineChart('#omskost-line-chart');
	var dateChart = dc.barChart('#date-chart');
	*/
	var omsKostLineChart;
	var dateChart;
	var dateDetailsDisplayed = false;
	//Group reduce
	var dateDimGroup =  dateDim.group().reduce(   
            function (p, v) {
                ++p.count;
                if (v.omskost != 'K') {
                	p.omsetning += v.belop;   
                } else {
                	p.kostnad += v.belop; 
                }
                return p;
            },
            function (p, v) {
                --p.count;
                if (v.omskost != 'K') {
                	p.omsetning -= v.belop;   
                } else {
                	p.kostnad -= v.belop; 
                }
                return p;
            },
            function () {
                return {
                    count: 0,
                    omsetning: 0,
                    kostnad: 0,
                };
            }
    );  


    var monthDimGroup =  monthDim.group().reduce(   
            function (p, v) {
                ++p.count;
                if (v.omskost != 'K') {
                	p.omsetning += v.belop;   
                } else {
                	p.kostnad += v.belop; 
                }
                return p;
            },
            function (p, v) {
                --p.count;
                if (v.omskost != 'K') {
                	p.omsetning -= v.belop;   
                } else {
                	p.kostnad -= v.belop; 
                }
                return p;
            },
            function () {
                return {
                    count: 0,
                    omsetning: 0,
                    kostnad: 0,
                };
            }
    );  	
	
    var omsetningsGroup =  faktAllDim.group().reduce(  
            function (p, v) {
                ++p.count;
                if (v.omskost != 'K') {
                	p.omsetning += v.belop;   
                } else {
                	p.kostnad += v.belop; 
                }
                return p;
            },
            function (p, v) {
                --p.count;
                if (v.omskost != 'K') {
                	p.omsetning -= v.belop;   
                } else {
                	p.kostnad -= v.belop; 
                }
                return p;
            },
            function () {
                return {
                    count: 0,
                    omsetning: 0,
                    kostnad: 0,
                };
            }
    );  

	avdChart
	    .width(350)
	    .height(300)
	    .slicesCap(25)
	    .innerRadius(40)
	    .externalRadiusPadding(50)
	    .dimension(avdDim)
	    .group(avdDimGroup)
	    .legend(dc.legend().y(10).itemHeight(8).gap(3));
	
	tubilkChart
	    .width(350)
	    .height(300)
	    .slicesCap(20)
	    .innerRadius(40)
	    .externalRadiusPadding(50)
	    .dimension(tubilkDim)
	    .group(tubilkDimGroup)
	    .legend(dc.legend().y(10).itemHeight(8).gap(3));


    favkChart
		.width(350)
		.height(300)
		.slicesCap(20)
		.innerRadius(40)
		.externalRadiusPadding(50)
		.dimension(favkDim)
		.group(favkDimGroup)
		.legend(dc.legend().y(10).itemHeight(8).gap(3));
		
    faskChart
		.width(350)
		.height(300)
		.slicesCap(20)
		.innerRadius(40)
		.externalRadiusPadding(50)
		.dimension(faskDim)
		.group(faskDimGroup)
		.legend(dc.legend().y(10).itemHeight(8).gap(3));		
		

	omsetningsDisplay
	     .group(omsetningsGroup)  
		 .valueAccessor(function (p) {
			 return p.value.omsetning;
		  })
		  .formatNumber(function(d){ return d3.format(",.0f")(d)});
	    
	kostnadsDisplay
	     .group(omsetningsGroup)  
		 .valueAccessor(function (p) {
			 return p.value.kostnad;
		  })
		 .formatNumber(function(d){ return d3.format(",.0f")(d)});
	    
	resultatDisplay
	     .group(omsetningsGroup)  
		 .valueAccessor(function (p) {
			var resultat = p.value.omsetning + p.value.kostnad;   // + = spooky algo
			return resultat;
		  })
		 .formatNumber(function(d){ return d3.format(",.0f")(d)});

	dbDisplay
	     .group(omsetningsGroup)  
		 .valueAccessor(function (p) {
			var resultat = p.value.omsetning + p.value.kostnad;   // + = spooky algo
			var db = resultat / p.value.omsetning;
			return db;
		  })
		 .formatNumber(d3.format(".2%")); 
	  
	var filterDateDim = dateDim.filterRange([new Date(2016, 1, 1), new Date(2016, 4, 30)]);

	var filterDateDimGroup =  filterDateDim.group().reduce(   
            function (p, v) {
                ++p.count;
                if (v.omskost != 'K') {
                	p.omsetning += v.belop;   
                } else {
                	p.kostnad += v.belop; 
                }
                return p;
            },
            function (p, v) {
                --p.count;
                if (v.omskost != 'K') {
                	p.omsetning -= v.belop;   
                } else {
                	p.kostnad -= v.belop; 
                }
                return p;
            },
            function () {
                return {
                    count: 0,
                    omsetning: 0,
                    kostnad: 0,
                };
            }
    );  
	
	
	
	filterDateDim.filter(mindate);
	
	console.log("filterDateDim.top(5)", filterDateDim.top(5));
	
	
	compositeChart
		    .width(1200)
		    .height(500)
		    .dimension(filterDateDim.filter(mindate))  
		    .group(filterDateDimGroup) 
		   //.filter(dc.filters.RangedFilter(new Date(2017, 1, 1), new Date(2017, 4, 30)))
		   // .replaceFilter(dc.filters.RangedFilter(new Date(2017, 1, 1), new Date(2017, 4, 30)))
		    .margins({top: 40, right: 10, bottom: 30, left: 60})
     		.x(d3.scale.ordinal())  
            .xUnits(dc.units.ordinal)       
	        //.x(d3.time.scale().domain([mindate, maxdate]))
    	    //.round(d3.time.month.round)
        	//.xUnits(d3.time.months)          
            .yAxisPadding('5%')
            .yAxisLabel("NOK")
        	.xAxisLabel("Måned")
            .elasticY(true)
            .elasticX(true)
            .mouseZoomable(false)
            .brushOn(false)
            .renderTitle(true)
	    	.title(function (d) {
            	var resultat = d.value.omsetning + d.value.kostnad;  
            	var db = resultat / d.value.omsetning;
            	 return [
 	                d.key,
 	                'Resultat: ' + numberFormat(resultat) + ':-',
 	                'Dekningsbidrag: ' + percentageFormat(db)
 	            ].join('\n');
			 })	
 
			 .legend( dc.legend().x(1100).y(2).itemHeight(5).gap(20).legendText(function(d, i) { 
        				if (i == 0) {
        					return "Omsetning";
        				}
        				if (i==1) {
        					return "Kostnad";
        				}
        				if (i==2) {
        					return "Resultat";
        				}
        			}) 
        	)   
        	
		    .renderHorizontalGridLines(true)
		  	.compose([
		  		dc.barChart(compositeChart)
		           .colors('lightslategray')  //https://www.w3.org/TR/SVG/types.html#ColorKeywords
		            .gap(30)
		             .dimension(filterDateDim.filter(mindate))  
		             //.filter(dc.filters.RangedFilter(new Date(2017, 1, 1), new Date(2017, 4, 30)))
		            .renderLabel(true)
			        .label(function (d) {
			        	var resultat = d.data.value.omsetning + d.data.value.kostnad;  
		            	var db = resultat / d.data.value.omsetning;
			            return percentageFormat(db);
			        })    
			        .valueAccessor(function (d) {
                		return d.value.omsetning; 
        			}),            
        		dc.barChart(compositeChart)
 					.gap(30)
 					 .dimension(filterDateDim.filter(mindate))  
 					 //.filter(dc.filters.RangedFilter(new Date(2017, 1, 1), new Date(2017, 4, 30)))
 					.colors('coral')
		            .valueAccessor(function (d) {
                   		return d.value.kostnad; 
           			})
			        ,
			    dc.lineChart(compositeChart)
		            .colors('limegreen')
		             .dimension(filterDateDim.filter(mindate))  
		             //.filter(dc.filters.RangedFilter(new Date(2017, 1, 1), new Date(2017, 4, 30)))
					.valueAccessor(function (d) {
						var resultat = d.value.omsetning + d.value.kostnad;   
						return resultat;
					 })
		            .dashStyle([5,3])   
		            .dotRadius(10)
		            .renderDataPoints([{radius: 5, fillOpacity: 1, strokeOpacity: 1}])
		        ])
	
				.on('renderlet', function(_chart, filter){
			       // 	chart.selectAll("rect.bar").on("click", function (d) {
						//chart.filter(null);
						//chart.filter(d.key);
						
					//})	 
					console.log("WTF"); //https://github.com/dc-js/dc.js/issues/657
					console.log("_chart.hasFilter()",_chart.hasFilter());
		       /*
			       if (_chart.hasFilter()) {
		            	_chart.selectAll('rect.bar').classed(dc.constants.SELECTED_CLASS, function (d) {
		                   // return _chart.hasFilter(d.x);
		                });
		            	_chart.selectAll('rect.bar').classed(dc.constants.DESELECTED_CLASS, function (d) {
		                    //return !_chart.hasFilter(d.x);
		                });
		            } else {
		            	_chart.selectAll('rect.bar').classed(dc.constants.SELECTED_CLASS, false);
		            	_chart.selectAll('rect.bar').classed(dc.constants.DESELECTED_CLASS, false);
		            }		
				*/	
					
				//	chart.selectAll('rect.bar')
				//	.classed(dc.constants.DESELECTED_CLASS, false);   //https://github.com/dc-js/dc.js/issues/558  kolla här
	                // .classed('bar-deselected', function(d) {
	                      // display stack faded if the chart has filters AND
	                      // the current stack is not one of them
	                      //var key = multikey(d.x, d.layer);
	                      //return chart.filter() && chart.filters().indexOf(key)===-1;
	                 // })
					
				})
		
	/*
				.on('renderlet.barclicker', function(chart, filter){
    				chart.selectAll('rect.bar').on('click.custom', function(d) {
        			console.log("how to deselect");
    				});
				})		
	*/	
	/*
		       .on('renderlet', function(chart) {
    		        chart.selectAll("rect.bar").on("click", function (d) {
            		    chart.filter(null)
                    	.filter(d.data.key)
                    	.redrawGroup();
            	})
		       })
	*/	
				
			.on('preRender', function(_chart, filter){
				_chart.filter(null);
				//_chart.filter(mindate);
				//filterDateDim.filter(mindate);
				_chart.filter(dc.filters.RangedFilter(new Date(2017, 1, 1), new Date(2017, 4, 30)))  //Denna verkar funka, men vill åt dimension
				console.log("prerender");
			})
	
	
		        .xAxis().tickFormat(NO.timeFormat('%b'));	 
      
	compositeChart.filter(mindate);
	    
   
//Diverse grejer till datum   
//https://jsfiddle.net/pramod24/q4aquukz/4/


   	d3.selectAll('a#all').on('click', function () {
     	dc.filterAll();
     	dc.renderAll();
   	});

	d3.selectAll('a#avd').on('click', function () {
		avdChart.filterAll();
		dc.redrawAll();
	});	 
	d3.selectAll('a#tubilk').on('click', function () {
		tubilkChart.filterAll();
		dc.redrawAll();
	});	

	d3.selectAll('a#fask').on('click', function () {
		faskChart.filterAll();
		dc.redrawAll();
	});		
	
	d3.selectAll('a#favk').on('click', function () {
		favkChart.filterAll();
		dc.redrawAll();
	});		
	
	d3.selectAll('a#composite').on('click', function () {
		compositeChart.filterAll();
		//compositeChart.render();
		dc.redrawAll();
	});	
	
	d3.selectAll('a#omskost-line').on('click', function () {
		omsKostLineChart.filterAll();
		dateChart.filterAll();
		dc.redrawAll();
	});	
	
	d3.selectAll('a#avdfilter').on('click', function () {
		avdChart.filter(jq('#avd-filter').val());
		dc.redrawAll();
		jq('#avd-filter').val("");
	});		

	dataCount
	      .dimension(fakt)
	      .group(all)
	      .html({
            some: '<strong>%filter-count</strong> valgt ut av <strong>%total-count</strong> fakturalinjer' +
                ' | <a href=\'javascript:dc.filterAll(); dc.renderAll();\'>tilbakestill alt</a>',
            all: 'Alle <strong>%total-count</strong> fakturalinjer for utvalg. Vennligst klikk på grafen for å bruke filtre.'
          });  

/*	
	jq('#showDateDetails' ).click(function() {
		if (dateDetailsDisplayed) {
			jq( '#dateDetails').toggle();
			dateDetailsDisplayed = false;
		} else {
		 	jq( '#dateDetails').toggle( "slow", function() {		
		 		
			 	omsKostLineChart = dc.lineChart('#omskost-line-chart');
			 	dateChart = dc.barChart('#date-chart');
	
			 	omsKostLineChart 
			        .renderArea(true)
			        .width(1200)
			        .height(500)
			        .margins({top: 40, right: 10, bottom: 30, left: 60})
			        .dimension(dateDim)
			        .mouseZoomable(false)
			        .rangeChart(dateChart)
			        .yAxisPadding('5%')
			        .yAxisLabel("NOK")
			        .xAxisLabel("Dag")
			        .x(d3.time.scale().domain([mindate, maxdate]))
			        .xUnits(d3.time.months)
			        .elasticY(true)
			        .elasticX(true)
			        .renderHorizontalGridLines(true)
			        .legend(dc.legend().x(1100).y(2).itemHeight(5).gap(20))
			        .brushOn(false)
			        .group(dateDimGroup, 'Kostnad') 
			        .valueAccessor(function (d) {
			            return Math.abs(d.value.kostnad);
			        })
			        .stack(dateDimGroup, 'Omsetning', function (d) {
			            return d.value.omsetning;
			        });
			       
			  	   // omsKostLineChart.xAxis().tickFormat(d3.time.format('%B'));	   
	
			   dateChart.width(1200) 
				    .height(150)
				    .margins({top: 0, right: 0, bottom: 30, left: 70})
				    .dimension(dateDim)
				    .yAxisPadding('5%')
			        .yAxisLabel("NOK")
			        .xAxisLabel("Dag")
				    .group(dateDimGroup, 'Resultat')
				    .valueAccessor(function (d) {
				    	var resultat = d.value.omsetning + d.value.kostnad;  
				    	return resultat;
				     })
				    .centerBar(true)
				    .gap(1)
				    .x(d3.time.scale().domain([mindate, maxdate]))
				    .elasticY(true)
				    .elasticX(true)
				    .renderHorizontalGridLines(true)
				    .legend(dc.legend().x(1100).y(2).itemHeight(5).gap(20))
				    .xUnits(d3.time.days);	    
	
			   //dateChart.xAxis().tickFormat(d3.time.format('%B'));	  
			 		
			   omsKostLineChart.render();	   
			   dateChart.render();	   	
		 		
			   dateDetailsDisplayed = true;
		 	   
		 	});
		}
		
	});	
*/	
	
	dc.renderAll(); 
	
	jq(document).ready(function() {
		dateDetailsDisplayed = false;
		jq('#toggleArea').toggle(true); //default hide
	});	

	jq.unblockUI();
    
});

}
 
jq(document).ready(function() {
	jq('select#selectVarekode').selectList();
	jq('select#selectSign').selectList();
	jq('select#selectAvd').selectList();
	//TODO jq('#detailsTable').toggle(false); //default hide
	jq('#toggleArea').toggle(false); //default hide
	jq('#dateDetails').toggle(false); //default hide	
});	
 
window.addEventListener('error', function (e) {
	  var error = e.error;
	  jq.unblockUI();
	  console.log("Event e.error",e.error);

	  if (e instanceof TypeError) {
			//what todo  
	  } else {
		  alert('Uforutsett fel har intreffet. Vennligst gör forfrisk på fane Fortolling(NO).');
	  }
	  
}); 
 
 
 
</script>


<table  width="100%" class="text11" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td>
		<%-- tab container component --%>
		<table style="border-collapse:initial;" width="100%" class="text11" cellspacing="0" border="0" cellpadding="0">
			<tr height="2"><td></td></tr>

				<tr height="25"> 
					<td width="20%" valign="bottom" class="tab" align="center" nowrap>
						<font class="tabLink">&nbsp;Trafikkregnskap</font>
						<img style="vertical-align:middle;" src="resources/images/lorry_green.png"  width="18px" height="18px" border="0" alt="Trafikkregnskap rapport">
					</td>
					<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
 
					<td width="20%" valign="bottom" class="tabDisabled" align="center" nowrap>
						<a class="text14" href="report_dashboard.do?report=report_trafikkregnskap" >
							<font class="tabDisabledLink">&nbsp;Trafikkregnskap - detaljer</font>&nbsp;						
						</a>						
						<img style="vertical-align:middle;" src="resources/images/lorry_green.png"  width="18px" height="18px" border="0" alt="Trafikkregnskap rapport">
					</td>
					<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>
<!-- 
					<td width="20%" valign="bottom" class="tabDisabled" align="center" nowrap>
						<a class="text14" href="report_dashboard.do?report=report_fortolling_no">
							<font class="tabDisabledLink">&nbsp;Fortolling(NO)</font>&nbsp;						
						</a>
						<img  style="vertical-align:middle;" src="resources/images/list.gif" border="0" alt="general list">
			  		</td>
-->			  						
					
					<td width="60%" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>	
	
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
						<font class="text12">År:</font><br>
						<select name="selectYear" id="selectYear">
	  						<option value="">-velg-</option>
		 				  	<c:forEach var="record" items="${model.yearList}" >
		 				  		<option value="${record.value}">${record.value}</option>
							</c:forEach> 
	  					</select>
	  				</div>

					<div class="col-md-2 text12">
						<font class="text12">Sammenlignings år:</font><br>
						<select name="selectYearComp" id="selectYearComp">
							<option value="">-velg-</option>
		 				  	<c:forEach var="record" items="${model.yearList}" >
		 				  		<option value="${record.value}">${record.value}</option>
							</c:forEach> 
	  					</select>
	  				</div>	
	
				
					<div class="col-md-1 text12">
						<font class="text12">Avdeling:</font><br>
		        		<select class="inputTextMediumBlue" name="selectAvd" id="selectAvd" multiple="multiple" title="-velg-">
		 				  	<c:forEach var="record" items="${model.avdList}" >
		 				  		<option value="${record.koakon}">${record.koakon}</option>
		 				  			<option value="2252">2252</option>
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
					
					<div class="col-md-2 text12">
						<fieldset class="form-group">
						  <legend><font class="text12">Varekode: </font></legend>
						 	<!--  <div class="col-md-12"> -->
						 	<div class="form-check form-check-inline">
							 	<select class="inputTextMediumBlue" name="selectVarekode" id="selectVarekode" multiple="multiple" title="-velg-">
						 			<option value="TODO">-todo-</option>
								</select>
							</div>
							<div class="form-check form-check-inline">
							  <label class="form-check-label">
							    <input class="form-check-input" type="checkbox" name="checkboxExclude" id="checkbox-exclude">
							    Ekskluder
							  </label>
							</div>		
 						</fieldset>
					</div>	

					<div class="col-md-2 text12">
  		    			<font class="text12">&nbsp;&nbsp;Mottaker:</font><br>
						<input type="text" class="inputText" name="selectKundenr" id="selectKundenr" size="9" maxlength="8" >  	
						<a tabindex="-1" id="kundenrLink">
							<img style="cursor:pointer;vertical-align: middle;" src="resources/images/find.png" width="14px" height="14px" border="0">
						</a>&nbsp;		
					</div>
					
	  		    	<div class="col-md-3" align="right">
	   	              	<button class="inputFormSubmit" onclick="load_data()" autofocus>Hent data</button> 
					</div>	
				  </div>
	
	  			  <div class="padded-row-small">&nbsp;</div>
	
<div id="toggleArea">	
	
	
				  <div class="row">
					<div class="col-md-12">
					  <div class="row">
						<div class="col-md-3 padded" id="omsetning" align="center">
 							<h3 class="text14">Omsetning</h3>
						</div>
				        <div class="col-md-3 padded" id="kostnad" align="center">
				        	<h3 class="text14">Kostnad</h3>
				        </div>  
				        <div class="col-md-3 padded" id="resultat" align="center">
				        	<h3 class="text14">Resultat</h3>
				        </div>  
				        <div class="col-md-3 padded" id="db" align="center">
							<h3 class="text14">Dekningsbidrag</h3>
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
						 <div class="col-md-12 dc-chart" id="chart-composite"> 
						 	<h3 class="text11">Omsetning og kostnad / måned</h3>
						    <span class="reset" style="display: none;">filter: <span class="filter"></span></span>
						    <a class="reset" id="composite" style="display: none;"> - <i>tilbakestill filter</i></a>
						 </div>  
				      </div>
				    </div>
				  </div>

<!--  
			  	  <div class="row">
					<div class="col-md-12" id="showDateDetailsXXX">
  						<h3><a id="showDateDetailsXXX"><font class="text12">Vis Omsetning og kostnad / dag BORT</font>
  						&nbsp;<img onMouseOver="showPop('vis_fortoll_info');" onMouseOut="hidePop('vis_fortoll_info');" width="12px" height="12px" src="resources/images/info3.png">
		 				</a></h3>
		 				<div class="text11" style="position: relative;" align="left">
		 				<span style="position:absolute; top:2px; width:250px;" id="vis_fortoll_info" class="popupWithInputText text11"  >
				           		<b>
				           			Vis Omsetning og kostnad / dag
				 	          	</b><br><br>
				           		Bruk dersom det finnes intresse att se spesifike oppdragsposter. Filter på Resultat-vyn.
								<br><br>
						</span>
						</div>
					</div>
				  </div>	

	
				  <div class="row" id="dateDetails">
				    <div class="col-md-12">
				      <div class="row">
						 <div class="col-md-12 dc-chart" id="omskost-line-chart"> 
						 	<h3 class="text11">Omsetning og kostnad / dag</h3>
						    <span class="reset" style="display: none;">filter: <span class="filter"></span></span>
						    <a class="reset" id="omskost-line" style="display: none;"> - <i>tilbakestill filter</i></a>
						 </div>  
				      </div>
					  <div class="row">
					     <div id="date-chart"></div>
					  </div>	
				    </div>
				  </div>	
	
-->	
	
				  <div class="row">
					<div class="col-md-12">
					  <div class="row">
						   <div class="col-md-12">
						      <h3 class="text14" style="border-bottom-style: solid; border-width: 1px;">&nbsp;</h3>
						   </div>
					  </div>				  
					  <div class="row">
					    <div class="col-md-3" id="chart-ring-fask">
				       		<h3 class="text11">Intern / Ekstern oms.</h3>
						    <span class="reset" style="display: none;">filter: <span class="filter"></span></span>
						    <a class="reset" id="fask" style="display: none;"> - <i>tilbakestill filter</i></a>
				        </div>	
		
				        <div class="col-md-3" id="chart-ring-avd">
				       		 <h3 class="text11">Avdeling
					        	 <font class="text10">&nbsp;&nbsp;&nbsp;avd:&nbsp;<input id="avd-filter" type="text" size="5"/>  </font>
					        	 <a id="avdfilter">&nbsp;legg til filter</a>	
				       		 </h3>
						    <span class="reset" style="display: none;">filter: <span class="filter"></span></span>
						    <a class="reset" id="avd" style="display: none;"> - <i>tilbakestill filter</i></a>
				        </div>
				        <div class="col-md-3" id="chart-ring-tubilk">
				       		<h3 class="text11">Bilkode</h3>
						    <span class="reset" style="display: none;">filter: <span class="filter"></span></span>
						    <a class="reset" id="tubilk" style="display: none;"> - <i>tilbakestill filter</i></a>
				        </div>  
 
				        <div class="col-md-3" id="chart-ring-favk">
				       		<h3 class="text11">Varukode</h3>
						    <span class="reset" style="display: none;">filter: <span class="filter"></span></span>
						    <a class="reset" id="favk" style="display: none;"> - <i>tilbakestill filter</i></a>
				        </div> 

					  </div> 					  
					</div>		
				  </div>	
	
				  <div class="row">
				    <div class="col-md-12" id="data-count"></div>
				  </div>
	
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

