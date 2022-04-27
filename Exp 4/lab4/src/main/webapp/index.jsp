<html>
<head>
	<title>AJAX REQUEST IN JSP</title>
	<script type="text/javascript">
		function loadAjax(){
			var username= document.getElementById("username").value;
			var email= document.getElementById("email").value;

			
			
			var url="ajax.jsp?username="+username +"&email="+email;
			alert(url);

			if(window.XMLHttpRequest){
				
				request = new XMLHttpRequest();
				
			}else if(window.ActiveXObject){
				
				request = new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			try{
				request.onreadystatechange=sendInfo;
				request.open("POST",url,true);
				request.send();
				
			}catch(e){
				alert("Unable to connect server");
			}
			
		}

		function sendInfo(){
			var p =		document.getElementById("print");

			if(request.readyState ==1){
				var text = request.responseText;
				p.innerHTML="Please Wait.....";
				console.log("1");
			}

			if(request.readyState ==2){
				var text = request.responseText;
				console.log("2");
				
			}
			if(request.readyState ==3){
				var text = request.responseText;
				console.log("3");
				
			}
			if(request.readyState ==4){
				var text = request.responseText;			
				p.innerHTML=" Request Processed  "+text;
			}
		}
	</script>
</head>
<body>
	<h1>AJAX REQUEST IN JSP</h1>
	<form>
		<p><label>YOUR NAME</label>
		<input type="text" name="username" id="username" required="required"></p>
		<p><label>YOUR EMAIL</label>
		<input type="email" name="email" id="email" required="required"></p>
		<button type="button" onclick="loadAjax()">REGISTER</button>
	</form>
	<p id="print"></p>
</body>
</html>
