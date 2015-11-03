//for AddtransportTypeDetails Form to go back to all recods
function goBack() {
	var x = document.getElementById("transportTypeId").value;
	 	 document.addTransportTypeDetailsForm.action="getAllTransportTypeDetails.htm?transId=" + x;
		 document.addTransportTypeDetailsForm.method="GET";
		 document.addTransportTypeDetailsForm.submit();
}
