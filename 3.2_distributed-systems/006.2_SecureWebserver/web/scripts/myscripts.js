// Function to show an Ajax call
function loadData()
{
  var xhr = new XMLHttpRequest();
  xhr.addEventListener("load", function(event) {  
    document.getElementById("note").innerHTML = "";	
    var myQuotes = JSON.parse(xhr.responseText);	
	var qouteOfTheDay = myQuotes.quotes[Math.floor(Math.random() * myQuotes.quotes.length)];
	document.getElementById("title").innerHTML = qouteOfTheDay.title;
    document.getElementById("text").innerHTML = qouteOfTheDay.text;
	document.getElementById("author").innerHTML = qouteOfTheDay.author;
   });  
  xhr.open("GET","data/quotes.json");
  xhr.send();
}