/**
 * Raj Malekar
 */

newScript = document.createElement('script');
newScript.type = 'text/javascript';
newScript.src = 'resources/Logistic/js/validations.js';

QUnit.test("Check Empty", function(assert){
	var fld = "Raj Malekar";
  assert.equal( Validator.checkEmpty(fld), true, "Test Passed" );
  fld = "";
  assert.equal(  Validator.checkEmpty(fld), false, "Test Passed" );
	
});

QUnit.test("Check Field Length", function(assert){
	var fld = "Raj";
  assert.equal( Validator.checkLength(fld), true, "Test Passed" );
  fld = "R";
  assert.equal(  Validator.checkLength(fld), false, "Test Passed" );
	
});