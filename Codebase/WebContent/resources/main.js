$( document ).ready(function() {
    console.log( "ready!" );
//    document.getElementById("errorMessage").hide();
    $("#errorMessage").hide();
    $( "#truckNameId" ).focus();
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
