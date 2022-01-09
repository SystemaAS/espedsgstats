//this variable is a global jQuery var instead of using "$" all the time. Very handy
var jq = jQuery.noConflict();
var BLOCKUI_OVERLAY_MESSAGE_DEFAULT = "Please wait...";

function setBlockUI(element){
  jq.blockUI({ message: BLOCKUI_OVERLAY_MESSAGE_DEFAULT});
}
  

jq(function() {
	jq('a#kundenrLink').click(function() {
		jq('#kundenrLink').attr('target','_blank');
		window.open('report_dashboard_childwindow_codes.do?caller=selectKundenr', "codeWin", "top=300px,left=500px,height=600px,width=800px,scrollbars=no,status=no,location=no");
	});  

	jq('a#kundenr_avsLink').click(function() {
		jq('#kundenr_avsLink').attr('target','_blank');
		window.open('report_dashboard_childwindow_codes.do?caller=selectKundenr_avs', "codeWin", "top=300px,left=500px,height=600px,width=800px,scrollbars=no,status=no,location=no");
	}); 

});


//---------------------------------
  //START Model dialog: "Logger"
  //------------------------------
  //Initialize <div> here
  jq(function() { 
	  jq("#dialogLogger").dialog({
		  autoOpen: false,
		  maxWidth:500,
          maxHeight: 400,
          width: 230,
          height: 250,
		  modal: true
	  });
  });
  
  jq(function() {
	  jq("#alinkLog4jLogger").click(function() {
		  presentPwdDialog();
	  });
  });
  
  
  //---------------------
  //PRESENT PWD DIALOG
  //---------------------
  function presentPwdDialog(){
	  jq('#dialogLogger').dialog( "option", "title", "Logsg logger" );
	  //deal with buttons for this modal window
	  jq('#dialogLogger').dialog({
		 buttons: [ 
            {
			 id: "dialogSaveTU",	
			 text: "Show",
			 click: function(){
				 		if(jq("#pwd").val() == "straffe12"){
				 			window.open('renderLocalLogsg.do?logLevel=' + jq("#logLevel").val() , '_blank');
				 			jq("#loggerStatus").removeClass( "isa_error" );
			  				jq("#loggerStatus").addClass( "isa_success" );
			  				jq("#loggerStatus").text("");
			  				jq("#pwd").val("");
			  				jq("#logLevel").val("");
			  				jq( this ).dialog( "close" ); 
			  				
				 		}else{
				 			jq("#loggerStatus").removeClass( "isa_success" );
			  				jq("#loggerStatus").addClass( "isa_error" );
			  				jq("#loggerStatus").text("...");
			  				jq("#pwd").val("");
			  				jq("#logLevel").val("");
				 		}
		 			}
		 	 },
  			{
		 	 id: "dialogCancelTU",
		 	 text: "Cancel", 
			 click: function(){
				 		jq("#loggerStatus").removeClass( "isa_success" );
				 		jq("#loggerStatus").removeClass( "isa_error" );
				 		jq("#loggerStatus").text("");
				 		jq("#pwd").val("");
				 		jq("#logLevel").val("");
				 		
		  				jq( this ).dialog( "close" ); 
			 		} 
 	 		 } ] 
	  });
	  jq('#dialogLogger').dialog('open');
  }