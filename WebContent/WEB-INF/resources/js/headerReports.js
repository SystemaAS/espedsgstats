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