 $().ready(function() {
	$("#loginid").validate({
		onfocusout: false,
		onkeyup: false,
		onclick: false,
		rules: {
			"username": {
				required: true
			},
			"password": {
				required: true
			},
			"repassword" : {
				required: true
			}
		},
		
		messages: {
			"username": {
				required: "Email must be filled out"
			},
			"password": {
				required: "Password must be filled out"
			},
			"repassword": {
				requireds: "Repeat password must be filled out"
			}	
		}
		
	});
});
