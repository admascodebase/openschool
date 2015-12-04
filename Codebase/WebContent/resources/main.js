$( document ).ready(function() {
    console.log( "ready!" );
//    document.getElementById("errorMessage").hide();
    $("#errorMessage").hide();
    $( "#truckNameId" ).focus();
    
    var x = document.getElementById("selectTransportType").value;
    if(x==0){
    	$("#errorDiv").append("<br />Please Select TransportType First");
    	$("#addButton").hide();
    }
});

//Validations for AddtransportTypeDetails Form
function validateForm() {
    if ($("#truckNameId").val() == null || $("#truckNameId").val()== "") {
    	$("#errorMessage").show();
    	$("#errorMessage").text("Truck Name must be filled out");
    	$( "#truckNameId" ).focus();
        return false;
    }
    if($("#unitId").val() == null || $("#unitId").val() == "") {
    	$("#errorMessage").show();
    	$("#errorMessage").text("Unit must be filled out");
    	$( "#unitId" ).focus();
        return false;
    }
    else if($("#sizeId").val() == null || $("#sizeId").val() == "") {
    	$("#errorMessage").show();
    	$("#errorMessage").text("Size must be filled out");
    	$( "#sizeId" ).focus();
        return false;
    }
    else if($("#widthId").val() == null || $("#widthId").val() == "") {
    	$("#errorMessage").show();
    	$("#errorMessage").text("Width must be filled out");
    	$( "#widthId" ).focus();
        return false;
    }
    else if($("#wheelsId").val() == null || $("#wheelsId").val() == "") {
    	$("#errorMessage").show();
    	$("#errorMessage").text("Wheels must be filled out");
    	$( "#wheelsId" ).focus();
        return false;
    }
    else if($("#maxCapacityId").val() == null || $("#maxCapacityId").val() == "") {
    	$("#errorMessage").show();
    	$("#errorMessage").text("MaxCapacity must be filled out");
    	$( "#maxCapacityId" ).focus();
        return false;
    }
    else if($("#capacityId").val() == null || $("#capacityId").val() == "") {
    	$("#errorMessage").show();
    	$("#errorMessage").text("Capacity must be filled out");
    	$( "#capacityId" ).focus();
        return false;
    }
       
}
/**
 * Validation For Accepting Numaric characters only.
 * Add element id to apply validation.
 * 
*/ 

$(
		"#sizeId,#capacityId,#maxCapacityId,#wheelsId,#widthId,#unitId,#contactNo,#pan,#salary,#contactNo1,#contactNo2,#tinNo,#ownerContact,#loadingStaffContact,#unloadingStaffContact,#amount,#advance,#balance,#distance,#deliveryDays,#buferTime,#loweryNo")
		.keydown(
				function(e) {
					// Allow: backspace, delete, tab, escape, enter and .
					if ($.inArray(e.keyCode, [ 46, 8, 9, 27, 13, 110, 190 ]) !== -1
							||
							// Allow: Ctrl+A, Command+A
							(e.keyCode == 65 && (e.ctrlKey === true || e.metaKey === true))
							||
							// Allow: home, end, left, right, down, up
							(e.keyCode >= 35 && e.keyCode <= 40)) {
						// let it happen, don't do anything
						return;
					}
					// Ensure that it is a number and stop the keypress
					if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57))
							&& (e.keyCode < 96 || e.keyCode > 105)) {
						e.preventDefault();
					}
				});
