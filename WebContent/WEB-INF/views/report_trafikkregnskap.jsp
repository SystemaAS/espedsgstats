<%@ include file="/WEB-INF/views/include.jsp" %>
<!-- ======================= header ===========================-->
<jsp:include page="/WEB-INF/views/headerReportDashboard.jsp" />
<!-- =====================end header ==========================-->
<script type="text/javascript">
"use strict";
var faktSize;
var ofs = 0, pag = 20;
var baseUrl = "/syjservicesbcore/syjsFAKT_DB.do?user=${user.user}";

var jq = jQuery.noConflict();
var BLOCKUI_OVERLAY_MESSAGE_DEFAULT = "Vennligst vent...";

function load_data() {
	
	var runningUrl = baseUrl;
	var selectedYear = jq('#selectYear').val();
	var selectedMonth = jq('#selectMonth').val();
	var selectedAvd = jq('#selectAvd').val();
	var selectedSign = jq('#selectSign').val();
	var selectedKundenr = jq('#selectKundenr').val();
	var selectedVarekode = jq('#selectVarekode').val();
	var doExcludeVarekode = jq('#checkbox-exclude').prop('checked');
	
	runningUrl = runningUrl + "&registreringsdato="+selectedYear + selectedMonth ;

	console.log("selectedAvd="+selectedAvd);
	console.log("selectedSign="+selectedSign);
	console.log("selectedVarekode="+selectedVarekode);
	console.log("doExcludeVarekode="+doExcludeVarekode);
	
	if (selectedAvd != null && selectedAvd != "")	{
		//runningUrl = runningUrl + "&avdeling="+selectedAvd;
		runningUrl = runningUrl + "&avdelings="+selectedAvd;  //fix when time
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
		//throw error;
	}
		
	if (data.dtoList == '') {
		jq.unblockUI();
		alert('Ingen data på urvalg.');  //TODO bättre UI
	}	
	
	var faktData = data.dtoList;
   // console.log("faktData="+faktData);  //Tip: View i  Chrome devtool; NetWork-(mark xhr row)-Preview
    
    var fullDateFormat = d3.time.format('%Y%m%d');
    var yearFormat = d3.time.format('%Y');
    var monthFormat = d3.time.format('%m');
    var percentageFormat = d3.format('.2%');
    var numberFormat = d3.format(",.0f")
   
    // normalize/parse data
	 _.each(faktData, function(d) {
	  d.date = fullDateFormat.parse(d.registreringsdato);
	  d.year = yearFormat(d.date);
	  d.month = monthFormat(d.date);
	  d.tupro = d.tupro;
	  d.tubilk = d.tubilk;
	  d.avdeling = d.avdeling;
	  d.faopd = d.faopd;
	  d.fabeln = +d.fabeln;
	  d.registreringsdato = +d.registreringsdato; 
	  d.fakda = d.fakda;
	  d.mottaker =  d.mottaker;
	  d.fask = d.fask;
	  d.favk = d.favk;
	});
 
	// set crossfilter. Crossfilter runs in the browser and the practical limit is somewhere around half a million to a million rows of data.
	var fakt = crossfilter(faktData);	
	var  all = fakt.groupAll();
	faktSize = fakt.size();
	
	//Dimensions
	var  faktAllDim = fakt.dimension(function(d) {return d;});	 
	//var  kundeDim  = fakt.dimension(function(d) {return d.mottaker;});
	var  dateDim  = fakt.dimension(function(d) {return d.date;});
	//var  yearDim  = fakt.dimension(function(d) {return d.year;});
    var  monthDim = fakt.dimension(function (d) {
    	return d.month;
    	});	
    //var  monthDim2 = fakt.dimension(d => d3.time.month(d.month));
	var  avdDim  = fakt.dimension(function(d) {return d.avdeling;});
	var  tubilkDim  = fakt.dimension(function(d) {return d.tubilk;});
	var  favkDim  = fakt.dimension(function(d) {return d.favk;});
    var faskDim = fakt.dimension(function (d) {
        var fask = d.fask;
        if (fask == 'I') {
            return 'Intern';
        } else {
            return 'Extern';
        } 
    });
	
	//Groups
	//var  dateDimGroup = dateDim.group().reduceSum(function(d) {return +d.fabeln;});
	//var  monthDimGroup = monthDim.group().reduceSum(function(d) {return d.fabeln;});
	//var  monthDimGroup2 = monthDim2.group().reduceSum(d => d.fabeln);
	
	//var  yearDimGroup = yearDim.group().reduceSum(function(d) {return d.fabeln;});
	var  avdDimGroup = avdDim.group().reduceSum(function(d) {return d.fabeln;});
	var  tubilkDimGroup = tubilkDim.group().reduceSum(function(d) {return d.fabeln;});
	var  favkDimGroup = favkDim.group().reduceSum(function(d) {return d.fabeln;});
	var  faskDimGroup = faskDim.group().reduceSum(function(d) {return d.fabeln;});
	//Charts 
	//var  yearChart   = dc.pieChart("#chart-ring-year");
	var  avdChart   = dc.pieChart('#chart-ring-avd');
	var  tubilkChart   = dc.pieChart('#chart-ring-tubilk');
	var  favkChart   = dc.pieChart('#chart-ring-favk');
	var  faskChart   = dc.pieChart('#chart-ring-fask');
	//var  yearlyBubbleChart = dc.bubbleChart('#yearly-bubble-chart');
	var  compositeChart = dc.compositeChart("#chart-composite");
	//var  compositeStackedChart = dc.compositeChart("#stacked-chart-composite");
	//var  stackedBarChart =  dc.barChart("#stacked-bar-chart"); //dc.compositeChart("#bar-chart-composite"); 
	//var  lineChartDate = dc.lineChart("#line-chart-date");
	var  dataCount = dc.dataCount('#data-count')	 
	var  omsetningsDisplay = dc.numberDisplay("#omsetning");	
	var  kostnadsDisplay = dc.numberDisplay("#kostnad");	
	var  resultatDisplay = dc.numberDisplay("#resultat");	
	var  dbDisplay = dc.numberDisplay("#db");	
	//var dataTable = dc.dataTable('#data-table');

	var mindate = dateDim.bottom(1)[0].date;
	var maxdate = dateDim.top(1)[0].date;
	
	//Group reduce
	var dateDimGroup =  dateDim.group().reduce(   //TESTAR: org=dateDimGroup
            function (p, v) {
                ++p.count;
                if (v.fakda != 'K') {
                	p.omsetning += v.fabeln;   
                } else {
                	p.kostnad += v.fabeln; 
                }
                return p;
            },
            function (p, v) {
                --p.count;
                if (v.fakda != 'K') {
                	p.omsetning -= v.fabeln;   
                } else {
                	p.kostnad -= v.fabeln; 
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
            /* callback for when data is added to the current filter results */
            function (p, v) {
                ++p.count;
                if (v.fakda != 'K') {
                	p.omsetning += v.fabeln;   
                } else {
                	p.kostnad += v.fabeln; 
                }
                return p;
            },
            /* callback for when data is removed from the current filter results */
            function (p, v) {
                --p.count;
                if (v.fakda != 'K') {
                	p.omsetning -= v.fabeln;   
                } else {
                	p.kostnad -= v.fabeln; 
                }
                return p;
            },
            /* initialize p */
            function () {
                return {
                    count: 0,
                    omsetning: 0,
                    kostnad: 0,
                };
            }
    );  	
	
	
	
	
	
/*
	var  kundePerformanceGroup = kundeDim.group().reduce(
           
            function (p, v) {
            	++p.avdeling;
            	++p.faopd;
                ++p.fabeln;
                ++p.count;
                p.sumAvd += p.avdeling;
                p.sumTotal += p.fabeln;
                return p;    
            },
            
            function (p, v) {
            	--p.avdeling;
            	--p.faopd;
                --p.fabeln;
                --p.count;
                p.sumAvd -= p.avdeling;
                p.sumTotal -= p.fabeln;
                return p;
            },
           
            function () {
                return {avdeling: 0,faopd: 0, fabeln: 0, sumTotal: 0, sumAvd: 0,  count: 0};
            }
        );	
 */   
    var omsetningsGroup =  faktAllDim.group().reduce(  
            /* callback for when data is added to the current filter results */
            function (p, v) {
                ++p.count;
                if (v.fakda != 'K') {
                	p.omsetning += v.fabeln;   
                } else {
                	p.kostnad += v.fabeln; 
                }
                return p;
            },
            /* callback for when data is removed from the current filter results */
            function (p, v) {
                --p.count;
                if (v.fakda != 'K') {
                	p.omsetning -= v.fabeln;   
                } else {
                	p.kostnad -= v.fabeln; 
                }
                return p;
            },
            /* initialize p */
            function () {
                return {
                    count: 0,
                    omsetning: 0,
                    kostnad: 0,
                };
            }
    );  

 /*
	yearChart
	    .width(350)
	    .height(300)
	    .dimension(yearDim)
	    .group(yearDimGroup)
	    //.externalLabels(20)
	    .externalRadiusPadding(50)
	    .innerRadius(30)
	    .legend(dc.legend().y(10).itemHeight(8).gap(3));
  */ 
	avdChart
	    .width(350)
	    .height(300)
	    .slicesCap(25)
	    .innerRadius(40)
	    //.externalLabels(20)
	    .externalRadiusPadding(50)
	    .dimension(avdDim)
	    .group(avdDimGroup)
	    .legend(dc.legend().y(10).itemHeight(8).gap(3));
/*	
	avdChart.on('pretransition', function(chart) {
        chart.selectAll('.dc-legend-item text')
            .text('')
          .append('tspan')
            .text(function(d) { return d.name; })
          .append('tspan')
            .attr('x', 100)
            .attr('text-anchor', 'end')
            .text(function(d) { return d.data; });
    });	
*/	
	
	tubilkChart
	    .width(350)
	    .height(300)
	    .slicesCap(20)
	    .innerRadius(40)
	    //.externalLabels(20)
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
			// console.log("p.value.omsetning="+p.value.omsetning);
			 return p.value.omsetning;
		  })
		  .formatNumber(function(d){ return d3.format(",.0f")(d)});
	    
	kostnadsDisplay
	     .group(omsetningsGroup)  
		 .valueAccessor(function (p) {
			// console.log("p.value.kostnad="+p.value.kostnad);
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
//	      .html({
//	        one:"<span style=\"color:green; font-size: 26px;\">%number</span> Monkey",
//	        some:"<span style=\"color:red; font-size: 26px;\">%number</span> Total Monkeys",
//	        none:"<span style=\"color:steelblue; font-size: 26px;\">No</span> Monkeys"
//	      })		  
		  
		 .formatNumber(d3.format(".2%")); 
	  
/*
	yearlyBubbleChart 
	        .width(1000)
	        .height(320)
	        .transitionDuration(1500)
		    .margins({top: 20, right: 10, bottom: 30, left: 90})
		    .dimension(kundeDim)
	        //The bubble chart expects the groups are reduced to multiple values which are used
	        //to generate x, y, and radius for each key (bubble) in the group
	        .group(kundePerformanceGroup)
	        // (_optional_) define color function or array for bubbles: [ColorBrewer](http://colorbrewer2.org/)
	        .colors(colorbrewer.RdYlGn[9])
	        //(optional) define color domain to match your data domain if you want to bind data or color
	        .colorDomain([-500, 500])
	   		 //##### Accessors
	        //Accessor functions are applied to each value returned by the grouping
	        // `.colorAccessor` - the returned value will be passed to the `.colors()` scale to determine a fill color
	        .colorAccessor(function (d) {
	            return d.value.fabeln;
	        })
	        // `.keyAccessor` - the `X` value will be passed to the `.x()` scale to determine pixel location
	        .keyAccessor(function (p) {
	            return p.value.sumTotal;
	        })
	        // `.valueAccessor` - the `Y` value will be passed to the `.y()` scale to determine pixel location
	        .valueAccessor(function (p) {
	            return p.value.fabeln;
	        })
	        // `.radiusValueAccessor` - the value will be passed to the `.r()` scale to determine radius size;
	        //   by default this maps linearly to [0,100]
	        .radiusValueAccessor(function (p) {
	            return p.value.fabeln;
	        })
	        .maxBubbleRelativeSize(0.3)
	        .x(d3.scale.linear().domain([-2500, 2500]))
	        .y(d3.scale.linear().domain([-100, 100]))
	        .r(d3.scale.linear().domain([0, 4000]))
	        //##### Elastic Scaling
	        //`.elasticY` and `.elasticX` determine whether the chart should rescale each axis to fit the data.
	        .elasticY(true)
	        .elasticX(true)
	        //`.yAxisPadding` and `.xAxisPadding` add padding to data above and below their max values in the same unit
	        //domains as the Accessors.
	        .yAxisPadding(100)
	        .xAxisPadding(500)
	        // (_optional_) render horizontal grid lines, `default=false`
	        .renderHorizontalGridLines(true)
	        // (_optional_) render vertical grid lines, `default=false`
	        .renderVerticalGridLines(true)
	        // (_optional_) render an axis label below the x axis
	        .xAxisLabel('Omsetning')
	        // (_optional_) render a vertical axis lable left of the y axis
	        .yAxisLabel('Antall oppdrag')
	        //##### Labels and  Titles
	        //Labels are displayed on the chart for each bubble. Titles displayed on mouseover.
	        // (_optional_) whether chart should render labels, `default = true`
	        .renderLabel(true)
	        .label(function (p) {
	            return p.key;
	        })
	        .renderTitle(true)
	        .title(function (p) {
	            return [
	                p.key,
	                'NOK: ' + p.value.sumTotal,
	                'Antall oppdrag: ' + p.value.fabeln
	            ].join('\n');
	        })	        


*/


	        
	mindate = d3.time.day.offset(mindate, -1);
	maxdate = d3.time.day.offset(maxdate, +1);

	compositeChart
		    .width(1200)
		    .height(500)
		    .margins({top: 40, right: 10, bottom: 30, left: 60})
			.x(d3.time.scale().domain([mindate, maxdate])) 	
			.xUnits(d3.time.days) 	
			//.x(d3.scale.linear().domain([1,31]))
            //.xUnits(d3.time.month)
            
            //.x(d3.scale.ordinal())  //funkar!!, time scale funkar inte!!
           //// .x(d3.scale.linear().domain([0,13])) //Funkar, bara enskilt!!
            //.xUnits(dc.units.ordinal)

            .yAxisPadding('5%')
            .yAxisLabel("NOK")
        	.xAxisLabel("Dag") 
            .elasticY(true)
            .elasticX(true)
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
        	.mouseZoomable(false)
        	.brushOn(false)
        	.legend(dc.legend().x(1100).y(2).itemHeight(5).gap(20))
		    .renderHorizontalGridLines(true)
		  	.compose([
		         dc.barChart(compositeChart)
		            .dimension(dateDim) //monthDim
		            .colors('lightslategray')  //https://www.w3.org/TR/SVG/types.html#ColorKeywords
		            .centerBar(true)
		            .gap(10)
		            .renderLabel(true)
			        .label(function (d) {
			        	var resultat = d.data.value.omsetning + d.data.value.kostnad;  
		            	var db = resultat / d.data.value.omsetning;
		            	//console.log("d.data.value.omsetning="+d.data.value.omsetning);
			            return percentageFormat(db);
			        })    
		            .group(dateDimGroup, "Omsetning") //monthDimGroup
			        .valueAccessor(function (d) {
                		return d.value.omsetning; 
        			}),            
		    	dc.barChart(compositeChart)
		            .dimension(dateDim) 
		            .colors('coral')
		            .centerBar(true)
		            .gap(10)
		            .group(dateDimGroup, "Kostnad")  //dateDimGroup
		            .valueAccessor(function (d) {
                   		return d.value.kostnad; 
           			}),
			    dc.lineChart(compositeChart)
		            .dimension(dateDim) //dateDim
		            .colors('limegreen')
		            .group(dateDimGroup, "Resultat") //dateDimGroup
					.valueAccessor(function (d) {
						var resultat = d.value.omsetning + d.value.kostnad;   // + = spooky algo
						return resultat;
					 })
		            .dashStyle([5,3])     
		            .renderDataPoints([{radius: 5, fillOpacity: 0.8, strokeOpacity: 0.8}])
		     ]);
	        
	        
	    //compositeChart.xAxis().tickFormat(d3.time.format('%B'));	        
	        
	        
	        
/*	   
 var minDate2 = dateDim.bottom(1)[0].month;
 var maxDate2  = dateDim.top(1)[0].month;
 */
 //maxDate2.setMonth(maxDate2.getMonth() + 1 );
 
 //var minDate = new Date(dateDim.bottom(1)[0]["timestamp"]);
 //var maxDate = new Date(dateDim.top(1)[0]["timestamp"]);
 
 //minDate2 = d3.time.month.offset(minDate2, -1);
 //maxDate2 = d3.time.month.offset(maxDate2, 1);

/* 
stackedBarChart
		.width(1200)
		.height(420)
		.margins({top: 20, right: 10, bottom: 30, left: 80})
		//.x(d3.time.scale().domain([minDate2, maxDate2])) 	//scale.linear()
		.x(d3.scale.linear().domain([minDate2, maxDate2])) 	//
		//.x(d3.time.scale().domain([d3.time.day.offset(minDate2, -15), d3.time.day.offset(maxDate2, 15)]))
		//.xUnits(d3.time.month)
		//.round(d3.time.month.round)
		//.alwaysUseRounding(true)
        //.dimension(monthDim) 
 	    //.group(monthDimGroup);

		.xUnits(function(){return 100;})
		
         //.x(d3.scale.ordinal())  //funkar!!, time scale funkar inte!!
         //.x(d3.scale.linear().domain([0,13])) //Funkar, bara enskilt!!
         //.xUnits(d3.time.months) //funkar inte men 
 		 //.x(d3.time.scale().domain([1,12]))  //funkar, inte
 		// .x(d3.time.scale().domain([minDate2, maxDate2]))  //Funkar inte
 		 //.x(d3.scale.linear().domain([minDate2, maxDate2]))  //Funkar inte
         //.xUnits(d3.time.month)        
         
         //.x(d3.scale.ordinal().domain([1,12]))  //Funkar inte, smetar ut fel..
         
         //.xUnits(dc.units.ordinal)
         //.xUnits(d3.time.months)
         .yAxisLabel("NOK")
         .xAxisLabel("Måned")   
         //.ordering(function(d) { 
        //	return d.key; 
         // })	
		 .dimension(monthDim)
		 .group(monthDimGroup, "Kostnad", function (d) {
        	 //console.log("d.value.kostnad="+d.value.kostnad);
             return d.value.kostnad;
         })
         .stack(monthDimGroup, "Resultat", function (d) {
             var resultat = d.value.omsetning + d.value.kostnad;
             //console.log("resultat="+resultat);
             return resultat;
         })
         .stack(monthDimGroup, "Omsetning", function (d) {
             //console.log("omsetningStacked="+omsetningStacked);
             return d.value.omsetning;
         })         
         
         .renderHorizontalGridLines(true)
         .renderVerticalGridLines(true)
         //.renderTitle(true)
         //.title(function(d) {
        //	 	//console.log("title="+d.key + '[' + this.layer + ']: ' + d.value[this.layer]);
         //     return d.key + '[' + this.layer + ']: ' + d.value[this.layer];
         //})        
   		 .renderLabel(true)  
   		 .renderTitle(true)
		 .elasticY(true)
		 .gap(1)
		 .centerBar(true)
		 .xAxisPadding(5000)
		 .xAxisPaddingUnit('month')
//		 .xAxis().tickFormat(function(d){
//        	  console.log("d.key="+d.key);
//        	  console.log("d.data.key="+d.data.key);
//        	  console.log("d.value="+d.value);
//        	  return d3.time.months;
//          })
			
		 .legend(dc.legend().x(1100).y(20).itemHeight(5).gap(20))
		 
		 .brushOn(true);
		// .clipPadding(20);
*/
		
		
	/*	inspiration
         var barChartDateB = dc.barChart("#bar-chart-dateB", "groupB");
         barChartDateB.width(500)
                 .height(150)
                 .dimension(dateDimension)
                 .group(dateIdSumGroup)
                 .stack(dateValueSumGroup)
                 .stack(dateValueSumGroup, function (d) {
                     return 10;
                 })
                 .brushOn(false)
                 .title(function (d) {
                     return d.value;
                 })
                 .x(d3.time.scale().domain([new Date(2012, 4, 20), new Date(2012, 07, 15)]))
                 .xUnits(d3.time.days)
                 .renderHorizontalGridLines(true)
                 .renderVerticalGridLines(true)
                 .gap(0)
                 .xAxis().tickValues([new Date(2012, 3, 1), new Date(2012, 6, 1), new Date(2012, 9, 1)]);
         barChartDateB.yAxis().tickValues([0, 75, 140]);
	*/	
		
		
		
		
        // stackedBarChart.xAxis().tickFormat(d3.time.format('%B'));
		 
 
//        .group(dateDimGroup, "Kostnad")
//    	.valueAccessor(function (d) {
//		       return d.value.kostnad; 
//		});


//Diverse grejer till datum   
//https://jsfiddle.net/pramod24/q4aquukz/4/


   	d3.selectAll('a#all').on('click', function () {
     	dc.filterAll();
     	dc.renderAll();
   	});

/*
	d3.selectAll('a#year').on('click', function () {
		yearChart.filterAll();
		dc.redrawAll();
	});
*/
d3.selectAll('a#intekkt').on('click', function () {
		alert("WTF");
		compositeChart.filterAll();
		dc.redrawAll();
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
		dc.redrawAll();
	});	
	
	d3.selectAll('a#stacked-bar').on('click', function () {
		stackedBarChart.filterAll();
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
	dataTable
	    .dimension(faktAllDim)
	    .group(function (d) { return 'dc.js insists on putting a row here so I remove it using JS'; })
	    .size(Infinity) 
	    .columns([
	      function (d) { return d.tupro; },
	      function (d) { return d.tubilk; },
	      function (d) { return d.registreringsdato; },
	      function (d) { return d.mottaker; },
	      function (d) { return d.avdeling; },
	      function (d) { return d.faopd; },
	      function (d) { return d.fabeln; },
	      function (d) { return d.fakda; }
	    ])
	    .order(d3.descending)
	    .on('renderlet', function (table) {
	      	// each time table is rendered remove nasty extra row dc.js insists on adding
	     	table.select('tr.dc-table-group').remove();
	 });
*/	

/*
	jq(document).ready(function() {
		var lang = jq('#language').val();
		jq('#data-table').dataTable({
			"dom" : '<"top">t<"bottom"flip><"clear">',
			"scrollY" : "200px",
			"scrollCollapse" : true,
			"destroy": true,
			"language": {
				"url": getLanguage(lang)
	        }
		});
	});	
*/	
	
/*	
	jq('#data-table').on('click', '.data-table-col', function() {
		  var column = jq(this).attr("data-col");
		  var faktAllDim2 = fakt.dimension(function(d) {return d[column];});
		  dataTable.dimension(faktAllDim2)
		  dataTable.sortBy(function(d) {
		    return d[column];
		  });
		  dataTable.redraw();
		});
*/	
	
	
	d3.select('#download').on('click', function() {
		var today = new Date();
        var data = faktAllDim.top(Infinity);
		var blob = new Blob([d3.csv.format(data)], {type: "text/csv;charset=utf-8"});
        saveAs(blob, 'trafikkregnskap-' + today + '.csv');
    });	
	
	faktSize = fakt.size();
	//updateDataTable();
	  
	dc.renderAll(); 

	jq.unblockUI();
    
});

}
 
function display() {
    d3.select('#begin').text(ofs);
    d3.select('#end').text(ofs+pag-1);
    d3.select('#last').attr('disabled', ofs-pag<0 ? 'true' : null);
    d3.select('#next').attr('disabled', ofs+pag>=faktSize ? 'true' : null);
    d3.select('#size').text(faktSize);
}
function updateDataTable() {
	dataTable.beginSlice(ofs);
	dataTable.endSlice(ofs+pag);
    display();
}
function next() {
    ofs += pag;
    updateDataTable();
    dataTable.redraw();
}
function last() {
    ofs -= pag;
    updateDataTable();
    dataTable.redraw();
}

jq(document).ready(function() {
	jq('select#selectVarekode').selectList();
	jq('select#selectSign').selectList();
	jq('select#selectAvd').selectList();
	
	console.log("leaving .ready...");
});	

</script>


<table  width="100%" class="text11" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<td>
		<%-- tab container component --%>
		<table style="border-collapse:initial;" width="100%" class="text11" cellspacing="0" border="0" cellpadding="0">
			<tr height="2"><td></td></tr>

				<tr height="25"> 
					<td width="20%" valign="bottom" class="tabDisabled" align="center" nowrap>
						<a class="text14" href="report_dashboard.do?report=report_trafikkregnskap_overview">
							<font class="tabDisabledLink">&nbsp;Trafikkregnskap - oversikt</font>&nbsp;						
						</a>
						<img  style="vertical-align:middle;" src="resources/images/lorry_green.png" width="18px" height="18px" border="0">
			  		</td>		
					<td width="1px" class="tabFantomSpace" align="center" nowrap><font class="tabDisabledLink">&nbsp;</font></td>

					<td width="20%" valign="bottom" class="tab" align="center" nowrap>
						<font class="tabLink">&nbsp;Trafikkregnskap - detaljer</font>
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
	  						<option value="2017">2017</option>
		  					<option value="2016">2016</option>
	  					</select>
					</div>	

					<div class="col-md-1 text12"> 
						<font class="text12">Måned:</font><br>
						<select name="selectMonth" id="selectMonth">
	  						<option value="01">Januar</option>
		  					<option value="02">Februar</option>
		  					<option value="03">Mars</option>
		  					<option value="04">April</option>
		  					<option value="05">Maj</option>
		  					<option value="06">Juni</option>
		  					<option value="07">Juli</option>
		  					<option value="08">August</option>
		  					<option value="09">September</option>
		  					<option value="10">Oktober</option>
		  					<option value="11">November</option>
		  					<option value="12">Desember</option>
	  					</select>					
					</div>

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
					
					<div class="col-md-2 text12">
 						<div class="row">
							<div class="col-md-3 text12">
								<font class="text12">Varekode:</font><br>
				        		<select class="inputTextMediumBlue" name="selectVarekode" id="selectVarekode" multiple="multiple" title="-velg-">
					 						<option value="TODO">-todo-</option>
								</select>	
							</div>
							<div class="col-md-8 text12">
   		 						 <input type="checkbox" name="checkboxExclude" id="checkbox-exclude">				    
								 <label for="checkbox-exclude">Ekskluder</label>
							</div>
 						</div>
					</div>	

					<div class="col-md-2 text12">
  		    			<font class="text12">&nbsp;&nbsp;Mottaker:</font><br>
						<input type="text" class="inputText" name="selectKundenr" id="selectKundenr" size="9" maxlength="8" >  	
						<a tabindex="-1" id="kundenrLink">
							<img style="cursor:pointer;vertical-align: middle;" src="resources/images/find.png" width="14px" height="14px" border="0">
						</a>&nbsp;	
					</div>
					
	  		    	<div class="col-md-4" align="right">
	   	              	<button class="inputFormSubmit" onclick="load_data()" autofocus>Hent data</button> 
					</div>	
				  </div>
	
	  			  <div class="padded-row-small">&nbsp;</div>
	
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
						 	<h3 class="text11">Omsetning og kostnad</h3>
						    <span class="reset" style="display: none;">filter: <span class="filter"></span></span>
						    <a class="reset" id="composite" style="display: none;"> - <i>tilbakestill filter</i></a>
						 </div>  
				      </div>
				    </div>
				  </div>
				  
				  <div class="row">
					<div class="col-md-12">
					  <div class="row">
						   <div class="col-md-12">
						      <h3 class="text14" style="border-bottom-style: solid; border-width: 1px;">&nbsp;</h3>
						   </div>
					  </div>				  
					  <div class="row">
<!--  
						<div class="col-md-3" id="chart-ring-year">
							<h3 class="text11">År</h3>
						    <span class="reset" style="display: none;">filter: <span class="filter"></span></span>
						    <a class="reset" id="year" style="display: none;"> - <i>tilbakestill filter</i></a>
				        </div>
-->	
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
				 
				  <div class="row">
					<div class="col-md-12">
						<h3 class="text14" style="border-bottom-style: solid; border-width: 1px;">&nbsp;</h3>
					</div>
				  </div>	
	
				  <div class="row">
				    <div class="col-md-12">
<!--  
				      <h3 class="text11">Fakturalinjer, filtrert</h3>
				      <div class="padded-row"></div>
				      <table class="display compact cell-border" id="data-table">
				        <thead>
				          <tr class="header">
				            <th class="tableHeaderField">Tupro</th>
				            <th class="tableHeaderField">Tubilk</th>
				            <th class="tableHeaderField">Hedtop</th>
					        <th class="tableHeaderField">mottaker</th>
				            <th class="tableHeaderField">avdeling</th>
				            <th class="tableHeaderField">Faopd</th>
				            <th class="tableHeaderField">Fabeln</th>
				            <th class="tableHeaderField">Fakda</th>
				          </tr>
				        </thead>
				      </table>
	-->			      
			      	  <div>
						<a href="#" id="download">
	                		<img valign="bottom" id="mainListExcel" src="resources/images/excel.gif" width="14" height="14" border="0" alt="excel">
	                		<font class="text12MediumBlue">&nbsp;Excel</font>
	 	        		</a>
  					  </div>
				    </div>
				  </div>
				  
				<div class="padded-row">&nbsp;</div>

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

