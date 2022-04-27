let table1=document.getElementById("table-user-wrapper");
let table2=document.getElementById("table-book-wrapper");
let form=document.getElementsByClassName("addbook-form");
let form1=document.querySelector("form");
var modal = document.getElementById("myModal");

var buttons = document.getElementsByClassName("more-info");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
function registered()
{

  if(window.XMLHttpRequest){
				
    request = new XMLHttpRequest();
    
  }else if(window.ActiveXObject){
    
    request = new ActiveXObject("Microsoft.XMLHTTP");
  }
  request.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     table1.innerHTML = this.responseText;
 
    }
  };
  request.open("GET", "user.jsp", true);
  request.send();
  table1.style.display="flex";
  table2.style.display="none";
  form[0].style.display="none";
}

function book()
{

  if(window.XMLHttpRequest){
				
    request = new XMLHttpRequest();
    
  }else if(window.ActiveXObject){
    
    request = new ActiveXObject("Microsoft.XMLHTTP");
  }
  request.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     table2.innerHTML = this.responseText;
 
    }
  };
  request.open("GET", "books.jsp", true);
  request.send();

  table1.style.display="none";
  table2.style.display="flex";
  form[0].style.display="none";
}

function dialog(data)
{
  if(window.XMLHttpRequest){
				
    request = new XMLHttpRequest();
    
  }else if(window.ActiveXObject){
    
    request = new ActiveXObject("Microsoft.XMLHTTP");
  }
  console.log(data);
  url="searchbook.jsp?id="+data;
  try{
    request.onreadystatechange=function() {
      if (this.readyState == 4 && this.status == 200) {
       modal.innerHTML = this.responseText;
   
      }
    };
    request.open("GET", url, true);
    request.send();
  }
  catch(e)
  {
    alert("unable to connect to server");
  }
  modal.style.display = "block";
}

function dialog_user(data)
{
  if(window.XMLHttpRequest){
				
    request = new XMLHttpRequest();
    
  }else if(window.ActiveXObject){
    
    request = new ActiveXObject("Microsoft.XMLHTTP");
  }
  console.log(data);
  url="searchuser.jsp?id="+data;
  try{
    request.onreadystatechange=function() {
      if (this.readyState == 4 && this.status == 200) {
       modal.innerHTML = this.responseText;
   
      }
    };
    request.open("GET", url, true);
    request.send();
  }
  catch(e)
  {
    alert("unable to connect to server");
  }
  modal.style.display = "block";
}


function addbook()
{
  table1.style.display="none";
  table2.style.display="none";
  form[0].style.display="block";
}

function add()
{
  let name=document.getElementsByName('title')[0].value;
  let id=document.getElementsByName('id')[0].value;
  let desc=document.getElementsByName('desc')[0].value;
  let price=document.getElementsByName('price')[0].value;
  let author=document.getElementsByName('author')[0].value;
  let publisher=document.getElementsByName('publisher')[0].value;
  let avail=document.getElementsByName('avail')[0].value;
  if(window.XMLHttpRequest){
				
    request = new XMLHttpRequest();
    
  }else if(window.ActiveXObject){
    
    request = new ActiveXObject("Microsoft.XMLHTTP");
  }
url="addbook.jsp?bookid="+id+"&bookname="+name+"&bookdesc="+desc+"&bookprice="+price+"&bookauthor="+author+"&bookpublisher="+publisher+"&bookqty="+avail;
request.open("POST", url, true); 
request.onreadystatechange = function() {
   if (this.readyState == 4 && this.status == 200) {
     // Response
     alert("Successfully inserted");
     document.getElementsByName('title')[0].value="";
     document.getElementsByName('id')[0].value="";
     document.getElementsByName('desc')[0].value="";
     document.getElementsByName('price')[0].value="";
     document.getElementsByName('author')[0].value="";
     document.getElementsByName('publisher')[0].value="";
     document.getElementsByName('avail')[0].value="";
   }
};
request.send();
}




// When the user clicks on <span> (x), close the modal
function toggle() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}