<!DOCTYPE html>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp" %> <!-- generally you will include this in a header.jsp -->

<html>
	<head>
		<link href="resources/${user.cssEspedsg}?ver=${user.versionEspedsg}" rel="stylesheet" type="text/css"/>
		 <link rel="stylesheet" type="text/css" href="resources/selectlist/css/selectlist.css" />
				<%-- datatables grid CSS --%>
		<link type="text/css" href="//cdn.datatables.net/1.10.16/css/jquery.dataTables.css" rel="stylesheet">
		<link type="text/css" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/overcast/jquery-ui.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="https://dc-js.github.io/dc.js/css/dc.css">
  		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" />
		<link rel="SHORTCUT ICON" type="image/png" href="resources/images/systema_logo.png"></link>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>Systema - eSpedsg</title>

	</head>
	<body>
	<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script type="text/javascript" src="resources/js/jquery.blockUI.js"></script>
	<script type="text/javascript" src="resources/js/systemaWebGlobal.js?ver=${user.versionEspedsg}"></script>
	<script type="text/javascript" src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<!-- using dc.js as the driver of upgrading of d3 and crossfilter, hence the https://dc-js.github.io/dc.js/js, NO! They are using latest/createt! Specify d3 version-->
	<!--script type="text/javascript" src="https://dc-js.github.io/dc.js/js/d3.js"></script-->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.17/d3.js"></script>
	<script type="text/javascript" src="https://d3js.org/d3-queue.v3.min.js"></script>
	<script type="text/javascript" src="https://dc-js.github.io/dc.js/js/crossfilter.js"></script>
	<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/dc/2.1.8/dc.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.3/underscore-min.js"></script>
	<script type="text/javascript" src="resources/js/FileSaver.js"></script>
 	<script type="text/javascript" src="resources/selectlist/js/jquery.selectlist.min.js"></script>
	<script type="text/javascript" src="resources/js/headerReports.js?ver=${user.versionEspedsg}"></script>	
	
	<script>
		var no_NO = {
				  "decimal": ".",
				  "thousands": ".",
				  "grouping": [3],
				  "currency": ["NOK", ""],
				  "dateTime": "%a %b %e %X %Y",
				  "date": "%d%m%Y",
				  "time": "%H:%M:%S",
				  "periods": ["AM", "PM"],
				  "days": ["Søndag", "Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag", "Lørdag"],
				  "shortDays": ["Søn", "Man", "Tir", "Ons", "Tor", "Fre", "Lør"],
				  "months": ["Januar", "Februar", "Mars", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Desember"],
				  "shortMonths": ["Jan", "Feb", "Mar", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec"]
				};	
	  	var NO = d3.locale(no_NO);  
	</script>
	<input type="hidden" name="language" id=language value="${user.usrLang}">
	
    <table class="noBg" width="100%" border="0" cellspacing="0" cellpadding="0">
		<%--Banner --%>
	 	<tr class="clazzTdsBanner" id="tdsBanner" style="visibility:visible">
	 	 	<%-- class="grayTitanBg" --%>
		 	<td height="60" class="headerTdsBannerAreaBg" width="100%" align="left" colspan="3"> 
	    			 <table width="100%" border="0" cellspacing="0" cellpadding="0">
	    			 	<tr>
				        	<td>&nbsp;</td>
				        	<td>&nbsp;</td>
					 		<td>&nbsp;</td>
				        </tr>
					 	<tr>
					 		<c:choose>
						 		<c:when test="${not empty user.logo}">
					 				<c:choose>
						 				<c:when test="${fn:contains(user.logo, '/')}">
						 					<td class="text14" width="10%" align="center" valign="middle" >
												<img src="${user.logo}" border="0" width="30px" height="20px">
											</td>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${fn:contains(user.logo, 'systema')}">
												<td class="text14white" width="10%" align=left valign="bottom" >&nbsp;
													<img src="resources/images/${user.logo}" border="0" width=80px height=50px>
												</td>
												</c:when>
												<c:otherwise>
													<c:if test="${fn:contains(user.logo, 'logo')}">
														<td class="text14white" width="10%" align=left valign="bottom" >&nbsp;
															<img src="resources/images/${user.logo}" border="0" >
														</td>
													</c:if>
												</c:otherwise>
											</c:choose>	
										</c:otherwise>
									</c:choose>
	   			 				</c:when> 
	   			 				<c:otherwise>
							 		<td class="text14white" width="10%" align=left valign="bottom" >&nbsp;</td>
							 		<%-- <td class="text14white" width="10%" align=right valign="bottom" >&nbsp;</td>--%>
						 		</c:otherwise>
					 		</c:choose>
					 		
					 		
					 		<td class="text32Bold" width="100%" align="middle" valign="middle" style="color:#778899;" >
					 			eSped<font style="color:#003300;">sg</font> - Analyser
					 		</td>
					 		
					 		<td class="text14" width="10%" align="center" valign="middle" >
					 			<c:if test="${not empty user.systemaLogo && (user.systemaLogo=='Y')}">
					 				<img src="resources/images/systema_logo.png" border="0" width=80px height=50px >
					 			</c:if>
					 		</td>
					 		<%-- <td class="text14white" width="10%" align=right valign="bottom" >&nbsp;</td>--%>
				        </tr>
				        <tr>
				        	<td>&nbsp;</td>
				        	<td>&nbsp;</td>
					 		<td class="text14" width="10%" align=right valign="bottom" >&nbsp;</td>
				        </tr>
				        <tr class="text" height="1"><td></td></tr>
				     </table> 
			</td>
		</tr>
		
		<tr >
			<td height="23" class="tabThinBorderLightGreenLogoutE2" width="100%" align="left" colspan="3"> 
    			 <table width="100%" border="0" cellspacing="0" cellpadding="0">
				 	<tr >
			    		<td class="text12" width="70%" align="left" >&nbsp;&nbsp;
			    			<%-- --------------------------- --%>
			    			<%-- Workflow Shipping trip MENU --%>
			    			<%-- ---------------------------
			    			<a tabindex=-1 href="transportdisp_workflow.do?action=doFind"> --%>
				<%-- 
			    			<a tabindex=-1 href="tror_mainorderlist.do?lang=${user.usrLang}&action=doFind">
			    				&nbsp;<font 
			    				<c:choose>           
		                   			<c:when test="${user.activeMenu=='TROR'}">
		                       			class="headerMenuMediumGreen"
		                   			</c:when>
		                   			<c:otherwise>   
		                       			class="headerMenuLightGreen"
		                   			</c:otherwise>
		               			</c:choose>
			    				
			    				>&nbsp;<spring:message code="systema.tror.title"/>&nbsp;</font>
			    			</a>
			    				<label onClick="showPop('debugPrintlnUrlStore');" >&nbsp;&nbsp; kalle igen</label>
			    				<span style="position:absolute; left:350px; top:100px; width:900px; height:600px;" id="debugPrintlnUrlStore" class="popupWithInputText"  >
						           		<div class="text12" align="left">
						           			<label>${user.urlStoreProps}</label>
						           			<br/>
						           			&nbsp;&nbsp;
						           			<button name="specialInformationButtonClose" class="buttonGrayInsideDivPopup" type="button" onClick="hidePop('debugPrintlnUrlStore');">
						           			Close
						           			</button> 
						           		</div>
					        		</span>
			    	--%>		
			    			</td>		      				
	      				<td class="text12" width="50%" align="right" valign="middle">
	      				
	      					<c:if test="${ empty user.usrLang || user.usrLang == 'NO'}">
			               		<img src="resources/images/countryFlags/Flag_NO.gif" height="12" border="0" alt="country">
			               	</c:if>
			               	<c:if test="${ user.usrLang == 'DA'}">
			               		<img src="resources/images/countryFlags/Flag_DK.gif" height="12" border="0" alt="country">
			               	</c:if>
			               	<c:if test="${ user.usrLang == 'SV'}">
			               		<img src="resources/images/countryFlags/Flag_SE.gif" height="12" border="0" alt="country">
			               	</c:if>
			               	<c:if test="${ user.usrLang == 'EN'}">
			               		<img src="resources/images/countryFlags/Flag_UK.gif" height="12" border="0" alt="country">
			               	</c:if>
		      				&nbsp;
		      				<font class="headerMenuGreenNoPointer">
			    				<img src="resources/images/appUser.gif" border="0" onClick="showPop('specialInformationAdmin');" > 
						        <span style="position:absolute; left:100px; top:150px; width:1000px; height:400px;" id="specialInformationAdmin" class="popupWithInputText"  >
						           		<div class="text12" align="left">
						           			${activeUrlRPG_TODO}
						           			<br/><br/>
						           			<button name="specialInformationButtonClose" class="buttonGrayInsideDivPopup" type="button" onClick="hidePop('specialInformationAdmin');">Close</button> 
						           		</div>
						        </span>   		
			    				<font class="text14User" >${user.user}&nbsp;</font>${user.usrLang}</font>
			    				<font color="#FFFFFF"; style="font-weight: bold;">&nbsp;|&nbsp;&nbsp;</font>
				    			<a tabindex=-1 href="logout.do">
				    				<font class="headerMenuGreen"><img src="resources/images/home.gif" border="0">&nbsp;
				    					<font class="text14User" ><spring:message code="dashboard.menu.button"/>&nbsp;</font>
				    				</font>
				    			</a>
				    			<font color="#FFFFFF"; style="font-weight: bold;">&nbsp;&nbsp;|&nbsp;</font>
				    			<font class="text14LightGreen" style="cursor:pointer;" onClick="showPop('versionInfo');">${user.versionSpring}&nbsp;</font>
				    			<div class="text12" style="position: relative;" align="left">
									<span style="position:absolute; left:5px; top:30px; width:250px" id="versionInfo" class="popupWithInputText"  >	
					           			
					           			&nbsp;<b>${user.versionEspedsg}</b>
					           			<br/><br/>
					           			&nbsp;<a href="renderLocalLog4j.do" target="_blank">log4j</a>
					           			<br/><br/><br/>
					           			<button name="versionInformationButtonClose" class="buttonGrayInsideDivPopup" type="button" onClick="hidePop('versionInfo');">Close</button> 
					           		</span>
								</div>  

				    		</td>
	      					
			        </tr>
			     </table> 
			</td>
	    </tr>
	    	<tr class="text" height="8"><td></td></tr>
		    
	    <%-- Validation Error section --%>
	    <c:if test="${errorMessage!=null}">
		<tr>
			<td colspan=3>
			<table>
					<tr>
					<td class="textError">					
			            <ul>
			                <li >
			                	${errorMessage}
			                </li>
			            
			            </ul>
					</td>
					</tr>
			</table>
			</td>
		</tr>
		</c:if>

	    <tr class="text" height="2"><td></td></tr>
		
		<%-- ------------------------------------
		Content after banner och header menu
		------------------------------------- --%>
		<tr>
    		<td width="100%" align="left" colspan="3"> 
    		     
     