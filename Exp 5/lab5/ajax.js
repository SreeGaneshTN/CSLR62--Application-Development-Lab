function Display()
{
 if(window.XMLHttpRequest)
  {
    xmlhttp=new XMLHttpRequest();
  }
let j=-1;
 xmlhttp.open("GET","userinfo.xml",false);
 xmlhttp.send();
 xmlDoc=xmlhttp.responseXML;
 var x=xmlDoc.getElementsByTagName("PersonDetails");
 var key_id=document.getElementById("userid").value; 
 let td1=document.getElementById("id");
 let td2=document.getElementById("name");
 let td3=document.getElementById("email");
 let td4=document.getElementById("num");
 let td5=document.getElementById("gender");
 let td6=document.getElementById("year");
 let td7=document.getElementById("city")
 let td8=document.getElementById("branch");
 let container=document.getElementsByClassName('container')[0];
 let table=document.getElementsByClassName('display-details')[0];

 for(i=0;i<x.length;i++)
  {
   if(key_id.match(x[i].getElementsByTagName("id")[0].childNodes[0].nodeValue))
     j=i;
  }
if(j==-1)
{
alert("User Not found");
window.location("index.html");
}  
else
{container.style.display="none";
table.style.display="block";
  td1.innerText=x[j].getElementsByTagName("id")[0].childNodes[0].nodeValue;
 td2.innerText=x[j].getElementsByTagName("name")[0].childNodes[0].nodeValue;
 td3.innerText=x[j].getElementsByTagName("email")[0].childNodes[0].nodeValue;
 td4.innerText=x[j].getElementsByTagName("phoneno")[0].childNodes[0].nodeValue;
 td5.innerText=x[j].getElementsByTagName("gender")[0].childNodes[0].nodeValue;
 td6.innerText=x[j].getElementsByTagName("Year")[0].childNodes[0].nodeValue;
 td7.innerText=x[j].getElementsByTagName("city")[0].childNodes[0].nodeValue;
 td8.innerText=x[j].getElementsByTagName("Branch")[0].childNodes[0].nodeValue;
}
}
