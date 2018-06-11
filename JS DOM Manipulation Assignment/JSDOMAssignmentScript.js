/*Question 1
For this question I got the elements by name and then set their href attribute
to the link that I wanted them to point too
*/
let google = document.getElementsByName("google")[0];
google.setAttribute("href", "https://www.google.com");
google.innerHTML = "Google";

let twitter = document.getElementsByName("twitter")[0];
twitter.setAttribute("href", "https://www.twitter.com");
twitter.innerHTML = "Twitter";

let slack = document.getElementsByName("slack")[0];
slack.setAttribute("href", "https://www.slack.com");
slack.innerHTML = "Slack";

let javadocs = document.getElementsByName("javadocs")[0];
javadocs.setAttribute("href", "https://docs.oracle.com/javase/8/docs/api/overview-summary.html");
javadocs.innerHTML = "Java Docs";

/*Question 2
This question was similar to 1. I got the element by the id and used the 3
array position to access pluto and then set disabled to true and removed it
from the display by setting it's inner html to an empty string
*/
let pluto =  document.getElementById("planet");
pluto.options[3].disabled = true;
pluto.options[3].innerHTML = "";

/*Question 3
For this question I got the element by ID again and cheched it's value
to see if it was not earth and if it was I went to the 6th p tag and removed
the attribute
*/
document.getElementById("planet").addEventListener("change", alienText);

function alienText()
{
    let residence = document.getElementById("planet");
    if(residence.value !== 'Earth')
    {
       document.getElementsByTagName("p")[5].removeAttribute("hidden");
    }

}
/*Question 4
So I first got all the elements and put them into variables
then I used if statments to check to make sure they weren't empty
and that the all the fields had a somewhat valid input for them.
I used two for loops to iterate through the gender and acitivities and grab
the ones that were checked
*/

document.getElementById("form-sub").addEventListener("click", add);

function add()
{
	let firstName = document.getElementById("firstname").value;
	let lastName = document.getElementById("lastname").value;
	let email = document.getElementById("email").value;
	let phoneNumber = document.getElementById("phone").value;
	let gender = [];
	let favoriteColor = document.getElementById("color").value;
	let favoriteActivites = [];
	let birthday = document.getElementById("bday").value;

	if((firstName && lastname && email && phone && gender && favoriteColor && favoriteActivites && birthday) != false)
	{
		if(firstName.length > 1 && lastName.length > 1)
		{
			if(email.includes("@") && email.includes(".com") && !email.includes(" "))
			{
				if(!isNaN(phoneNumber))
				{
					let row = document.createElement("tr");
					let col1 = document.createElement("td");
					let col2 = document.createElement("td");
					let col3 = document.createElement("td");
					let col4 = document.createElement("td");
					let col5 = document.createElement("td");
					let col6 = document.createElement("td");
					let col7 = document.createElement("td")
					let list = document.createElement("ul");



					row.appendChild(col1);
					row.appendChild(col2);
					row.appendChild(col3);
					row.appendChild(col4);
					row.appendChild(col5);
					row.appendChild(col6);
					row.appendChild(col7);

					col1.innerHTML = firstName;
					col2.innerHTML = email;
					col3.innerHTML = phoneNumber;
					col4.innerHTML = birthday;
					col5.innerHTML = favoriteColor;


					for(i = 0; i < 3; i++)
					{
						gender[i] = document.getElementsByName("gender")[i];
						if(gender[i].checked)
						{
							col6.innerHTML = gender[i].value;
						}
					}

					for(i = 0; i < 4; i++)
					{
						favoriteActivites[i] = document.getElementsByClassName("activity")[i];
						if(favoriteActivites[i].checked)
						{
							let listItem = document.createElement("li");
							listItem.innerHTML = favoriteActivites[i].nextSibling.nodeValue;
							list.appendChild(listItem);
						}

					}
					col7.appendChild(list);
					document.getElementsByTagName("table")[0].appendChild(row);

				}
			}

		}
	}

}

/*Quesion 5
Added event listeners to the nod and created two functions to get the open
on mouse over and close on mouse leave.
*/

document.getElementsByTagName("summary")[0].addEventListener("mouseover", openDetails);
document.getElementsByTagName("summary")[0].addEventListener("mouseleave", closeDetails);

function openDetails()
{
	document.getElementsByTagName("details")[0].open = true;
}

function closeDetails()
{
	document.getElementsByTagName("details")[0].open = false;
}

/*Question 6
Used a for loop to concatinate the spans in the document together
*/

function spanConcat()
{
	let str = "";
	for(i = 0; i < 7; i++)
	{
		str = str.concat(document.getElementsByTagName("span")[i].innerHTML);
	}
	console.log(str);
}

/*Question 7
Created an event listener on the node and in my function I just called a new date
object which displayed the currnte time for me
*/
document.getElementById("earth_time_check").addEventListener("click", currentEarthTime);

function currentEarthTime()
{
	document.getElementById("earth_time").innerHTML = new Date();
}

/*Question 8
This question was a little tricker than the last one. I use the get time function
from the date object to return the amount of miliseonds that have passed since
1970. I then divided it a bunch of times to convert it up into days, and divided
that number by the orbital peroid of each body to get the years that had passed
for them since 1970 jan 1. I also calculated the years for them, but not months,
as our own months aren't even consistant.
*/

document.getElementById('mars_time_check').addEventListener('click', marsTimePassed)

function marsTimePassed()
{
  let since1970 = new Date();

  let miliseconds = since1970.getTime();
  let seconds = miliseconds/1000;
  let minutes = seconds/60;
  let hours = minutes/60;
  let days = hours/24;
  let marsYears = Math.floor(days/687);
  let marsDays = Math.floor(days%687);

  document.getElementById('mars_time').innerHTML = 'Mars Year '+marsYears+' day '+marsDays+' '+since1970.getHours()+':'+since1970.getMinutes()+':'+since1970.getSeconds();
}
let baseUrl = 'http://www.astropical.space/astrodb/';
let urlNotFound = '';

document.getElementById('acb_time_check').addEventListener('click', getAlphaBb)
function getAlphaBb()
{
  sendAjaxGet(baseUrl+ 'api-exo.php?which=name&limit=alf%20Cen%20B%20b&format=json', displayAlphaBbTime);
}

function sendAjaxGet(url, func)
{
    xhr = (new XMLHttpRequest() || new ActiveXObject('Microsoft.HTTPRequest'));
    xhr.onreadystatechange = function () {
        if (this.status == 200 && this.readyState == 4) {
            func(this);
        }
    }

    xhr.open('GET', url);
    xhr.send();
}

function displayAlphaBbTime(xhr)
{
  let response = xhr.response;
  let acbbTime = JSON.parse(response);
  let period = acbbTime.exoplanets[0];

  let since1970 = new Date();
  let miliseconds = since1970.getTime();
  let seconds = miliseconds/1000;
  let minutes = seconds/60;
  let hours = minutes/60;
  let days = hours/24;
  let alphabbDays = Math.floor(days%period.per);
  let alphabbYears = Math.floor(days/period.per);
  document.getElementById('acb_time').innerHTML = 'Alpha Centauri B b Year '+alphabbYears+' day '+alphabbDays+ ' '+since1970.getHours()+':'+since1970.getMinutes()+':'+since1970.getSeconds();
}

/*Question 9
I calculated the random colors for this function by flooring math.random and then
multiplying it by 256 to give me a value between 0-256. Which I then used to
generate a hash code for color and changed the background. I made the delay by
calling set timemout function and creating a function inside of it that would change the color.
I passed in 3000 because set timeout uses miliseconds as it's second parameter.
*/

document.getElementsByTagName('h1')[0].addEventListener('click', changeBg);

function changeBg()
{
  let red = Math.floor(Math.random()*256);
  let green = Math.floor(Math.random()*256);
  let blue = Math.floor(Math.random()*256);
  let hexNumber ='#'+red.toString(16)+green.toString(16)+blue.toString(16);

  if(hexNumber !== '000000')
  {
      setTimeout(function(){ document.getElementsByTagName('body')[0].style.backgroundColor = hexNumber;}, 3000);
  }
}

/*Question 10
This one I had to parse into ints what ever was in the forms for it to do the
operation correctly. Otherwise it would have returned the numbers just
joined together. IE 1+2 would = 12 instead of 3. This is because the input
was being read as a string. I used if statements to check for valid numbers.
*/


document.getElementById('operation').addEventListener('change', operations);

function operations()
{
  let n1 = document.getElementById('n1').value;
  let n2 = document.getElementById('n2').value;

  let result = 0;

  if(!isNaN(n1) && !isNaN(n2))
  {

      let str = document.getElementById('operation').value;
      if(str === 'Add')
      {
        document.getElementById('result').innerHTML = parseInt(n1)+parseInt(n2);
      }
      if(str === 'Subtract')
      {
        document.getElementById('result').innerHTML = parseInt(n1)-parseInt(n2);
      }
      if(str === 'Multiply')
      {
        document.getElementById('result').innerHTML = parseInt(n1) * parseInt(n2);
      }
      if(str === 'Divide')
      {
        if(parseInt(n2) === 0)
        {
          document.getElementById('result').innerHTML = 'Cannot divide by 0.';
        }
        else
        {
            document.getElementById('result').innerHTML = parseInt(n1)/parseInt(n2);
        }
      }
    }
    else
    {
      document.getElementById('result').innerHTML = 'Invalid input, please enter a number.';
    }
}

/*Question 11
This one was intially pretty hard and I struggled with it. But when I was looking
through the documentation for the node methods I came across a special way to use
the get elemnt by tag name function. If you passe in * to it it will return an
array of all the node objects in your document. So in the console I would call that,
then call .length on it and pass that to another variable and finally call my function
and pass in that variable. I am still technically iterating over each node object
as I could just access the node at a particular point in the array. But since the
prompt didn't specify what we had to do, only to iterate, I felt that a simple counter
that increased in my recursive function would be fine.
*/
let counter = 0;
function walkTheDom(count)
{
  if(count <= 0)
  {
    return counter;
  }
  counter++;
  return walkTheDom(count-1);
}
