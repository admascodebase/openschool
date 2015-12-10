/**
 * Raj Malekar
 */
var Validator={

		version:'1.0.0',
		init:function(frm){
			this.form = document.forms[frm];
		},

		errorMsg:{
			error:[]
		},

		validate:function(){		
			var x = this.form.getElementsByTagName("input");
			for(var i=0;i<x.length;i++){
				if(x[i].type==='text'){
					var errorMsg=this.validateFields(x[i]);
					if(errorMsg!=undefined){
					this.errorMsg.error.push(errorMsg);
					}
				}
			}
			document.getElementById("errorMessage").show();
			
			
			this.callAction();
		},

		validateFields:function(fld){
			if(!this.checkEmpty(fld.value)){
				return(fld.name.toString().toUpperCase()+"Field Can Not Be Empty");	
				//this.form.getElementById("bName").backGroundColour="red"
			}
			else if(!this.checkLength(fld.value)){
				return(fld.name.toString().toUpperCase()+"Requires Minimum 3 char");
			}
		},

		checkEmpty:function(fld){
			if(fld.length==0){
				return false;
			}
			else{
				return true;
			}
		},

		checkLength:function(fld){
			if(fld.length<3){
				return false
			}else{
				return true;
			}
		},
		callAction:function(){
			
			if(this.errorMsg.error.length===0){
				alert("call the action from here");
			}
			else{
				alert("Resolve conflicts first");
			}
		}

}