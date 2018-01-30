/**
 * This function will check the form. All of the inputs have to set data-pattern which we want to control.
 * This pattern is an regular expression. If the pattern is not match then the submit event will disable. 
 * We can set an error container. The class name is form-error. If this container is exists then the error message will show here.
 * Otherwise we show an alert window.
 * 
 * @param form This is the form object which we want to control
 * @param callback Extra event after the control process. This function can change the return value.<br>
 * 					function(form, success){alert(1);};
 * @return true if the vaqlidation was success, otherwise it will be false.
 * */
function checkForm(form, callback){
	var ok = true;
	
	if($(form).length > 0){
		//get submit button
		var submitButton = $(form).find("[type='submit']");
		//get error container
		var errorContainer = $(form).find(".form-error");
		if(errorContainer.length > 0){
			//hide the container
			errorContainer.fadeOut();
		}
		//disable the button
		submitButton.prop("disable", true);
		
		var formItems = $(form).find(":input");
		var msg = null;					// if the variable is null then it isn't error here. The form is valid.
		
		$.each(formItems, function(k, v){
			var pattern;
			if($(v).attr("data-pattern")){			//check if pattern exists or not
				pattern = new RegExp($(v).data("pattern"))
				if(!pattern.test($(v).val())){		//the input value is bad
					ok = false;
					
					if(msg == null) msg = "";
					//get error message
					msg += "- " + $(v).data("pattern_error") + "\n";
					
					$(v).closest("div").addClass("has-error").removeClass("has-success");
				}else{
					$(v).closest("div").addClass("has-success").removeClass("has-error");
				}
			}
		});
		
		if(msg != null){
			//show the error message
			submitButton.prop("disable", false);
			
			if(errorContainer.length > 0){		//isset the container, where we want to show the error message.
				errorContainer.html(msg.replace("\n", "<br />")).fadeIn();
			}else{
				alert(msg);
			}
		}
		//run extra process
		if(typeof callback == "function"){
			ok = callback.call(null, form, ok);
		}
	}
	
	return ok;
}
/**
 * Save login form data into the cookie
 * */
function formRemember(form, success){
	var remember = $(form).find("#remember");
	if(remember.is(":checked")){
		$.cookie("username", $(form).find("#userNameInput").val(), { expires: 20*365 });
	}else{
		$.removeCookie("username");
	}
	return success;
}