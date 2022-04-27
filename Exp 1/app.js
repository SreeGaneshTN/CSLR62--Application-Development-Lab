// JavaScript is used for toggling loading state
var form = document.querySelector('form');
form.onsubmit = function (event) {
    event.preventDefault();
    console.log('hello world');
    var valid_name=validate_name();
    var valid_username=validate_username();
    var valid_email=validate_email();
    var valid_password=validate_password();
    var valid_confirm_password=validate_cfrm_password();
    var valid_mobile=validate_mobile();
    var valid_add=validate_address();
    var privacy_policy=validate_policy();
    var valid_gender=validate_gender();
    if (valid_username && valid_name && valid_email && valid_password && valid_confirm_password && privacy_policy && valid_mobile && valid_add && valid_gender)
    {form.classList.add('signed');
    
    }
};

function validate_name()
{
    var name=document.getElementById('Name').value;
    if(name.length<1){alert('Name field is required');return false;}
    var re= /[0-9]/g;
    if((re.test(name))){alert('Name shouldnot contain any Number');return false;}
    var regex=/[~`!#$%\^&*+=\-\[\]\\';,/{}|\\":<>\?]/g;
    if(regex.test(name)){alert("Name shouldnot contain special character");return false};
    return true;
}
function validate_username()
{
    var name=document.getElementById('Username').value;
    if(name.length<1){alert('username field is required');return false;}
    if(name.length>10){alert('username should be Maximum 10 characters');return false;}
    var re= /[0-9]/g;
    if((re.test(name))){alert('username should contain only alphabets');return false;}
    var regex=/[~`!#$%\^&*+=\-\[\]\\';,/{}|\\":<>\?]/g;
    if(regex.test(name)){alert("userName shouldnot contain special character");return false};
    return true;
}
function validate_password()
{
    var pw = document.getElementById("password").value;  
   
  if(pw == "") {  
     alert("**Fill the password!");  
     return false;

  }       
  if(pw.length < 8) {  
     alert("** Password length must be atleast 8 characters");  
     return false;

  }     
  if(pw.length > 15) {  
     alert("** Password length must not exceed 15 characters");  
     return false;
  } 
  var re1=/[0-9]/g;
  if(!(re1.test(pw))){alert('Password should contain atleast 1 number');return false;}
  var re2=/[A-Z]/g;
  if(!(re2.test(pw))){alert('Password should contain atleast 1 Capital Case');return false;}
  return true;
}
function validate_cfrm_password()
{
    var pw = document.getElementById("password").value;  
    var cf_pw =document.getElementById('confirm-passwd').value;
   
  if(pw !=cf_pw) {alert('Passwords didnt match ');
  return false;
}  
     
  return true;
}
function validate_email()
{
    var email=document.getElementById("email").value;
    if(email.length<1){alert('Email field is required');return false;}
    var regexp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(!(regexp.test(email))){alert('Email id is not valid');return false;}
    return true;

}
function validate_mobile()
{
    var number=document.getElementById("number").value;
    if(number.length<1){alert('Mobile field is required');return false;}
    var regexp=/[a-z|A-Z]/g;
    if((regexp.test(number))){alert('Mobile Number should contain only number');return false;}
    var regex=/[~`!#$%\^&*+=\-\[\]\\';,/{}|\\":<>\?]/g;
    if(regex.test(number)){alert("Mobilenumber shouldnot contain special character");return false};
    return true;

}
function validate_address()
{
    var address=document.getElementById("address").value;
    console.log(address)
    if(address.length<1){alert('address is required');return false;}
    return true;

}
function validate_gender()
{
    var gender=document.querySelector('input[name="radio-btn"]:checked');
    console.log(gender)
    if(gender==null){alert('gender is required');return false;}
    return true;

}
function validate_policy()
{
    var policy=document.getElementById("policy");
    if(! policy.checked){
        alert('Please accept the Terms and Conditions');
        return false;
    }
    return true;
}  
