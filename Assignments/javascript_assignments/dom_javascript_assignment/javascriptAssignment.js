
//question 1
document.getElementById("googleid").setAttribute("href", "https://www.google.com");
document.getElementById("twitterid").setAttribute("href", "https://www.twitter.com");
document.getElementById("slackid").setAttribute("href", "http://www.slack.com");
document.getElementById("javadocsid").setAttribute("href", "http://www.javadocs.com");

//question 2
document.getElementById("planet").options[3].setAttribute("disabled", "true");

//question 3
function alienText(name)
{
    if(name != "earth")
    {
        document.getElementsByTagName("p")[5].removeAttribute("hidden");
    }
    else
    {
        document.getElementsByTagName("p")[5].setAttribute("hidden", "true");
    }
}

//question4
document.getElementById("form-sub").addEventListener("click", submitInfo);

function submitInfo()
{
    let firstName = document.getElementById("firstname").value;
    if(!(/^[A-Za-z]{2,20}$/.test(firstName)))
    {
        window.alert("Firstname must be at least 2 characters and only characters ");
        return;
    }
    let lastName = document.getElementById("lastname").value;
    if(!(/^[A-Za-z]{2,20}$/.test(lastName)))
    {
        window.alert("Lastname must be at least 2 characters and only characters ");
        return;
    }
    let email = document.getElementById("email").value;
    if(!(/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/.test(email)))
    {
        window.alert("Invalid email format");
        return;
    }
    let phone = document.getElementById("phone").value;
    if(!(/^\d{10}$/.test(phone)))
    {
        window.alert("Phone number must be 10 digits");
        return;
    }
    
    let birthDay = document.getElementById("bday").value;

    
    let planet = document.getElementById("planet").value;
    let gender = document.getElementsByName("gender");
    let selectedGender = null;
    for(i=0, length=gender.length; i<length; i++)
    {
        if(gender[i].checked)
        {
            selectedGender =gender[i].value;
        }
    }
    let color = document.getElementById("color").value;

    let inputs = document.getElementsByClassName("activity");
    let activityCheckBox=[];
    for(i=0;i<inputs.length; i++)
    {
        if(inputs[i].checked)
        {
            activityCheckBox.push(inputs[i].value);
        }
    }

    let tr = document.createElement("tr");
    tr.setAttribute("scope", "row");
    let td1 = document.createElement("td");
    td1.innerHTML=firstName;
    let td2 = document.createElement("td");
    td2.innerHTML=email;
    let td3 = document.createElement("td");
    td3.innerHTML=phone;
    let td4 = document.createElement("td");
    td4.innerHTML=birthDay;
    let td5 = document.createElement("td");
    td5.innerHTML=color;
    let td6 = document.createElement("td");
    td6.innerHTML=selectedGender;

    let td7 = document.createElement("td");//5//
        let ul = document.createElement("ul");
        for(i = 0, length=activityCheckBox.length; i<length;i++)
        {
            let li = document.createElement("li");
            li.innerHTML=activityCheckBox.pop();
            ul.appendChild(li);
        }
    td7.appendChild(ul);

    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);
    tr.appendChild(td5);
    tr.appendChild(td6);
    tr.appendChild(td7);
    document.getElementsByTagName("tbody")[0].appendChild(tr);
}

//question 5
function openDetails()
{
document.getElementsByTagName("details")[0].setAttribute("open", "true");
}
function closeDetails()
{
document.getElementsByTagName("details")[0].removeAttribute("open");
  
}


document.getElementsByTagName("details")[0].addEventListener("mouseover", openDetails);
document.getElementsByTagName("details")[0].addEventListener("mouseout", closeDetails);

//question 6
function printIt()
{
    let spans = document.getElementsByTagName("span");
    let spanText ="";
    for(i=0; i<spans.length; i++)
    {
        spanText += spans[i].innerHTML;
    }
    console.log(spanText);
}

//question 7
function showEarthTime()
{
    let timeNow = new Date();
    timeNow.setMonth(timeNow.getMonth()+1)
    var myTime = timeNow.getFullYear()+"-"+timeNow.getMonth()+"-"+timeNow.getDate();
    document.getElementById("earth_time").innerHTML = myTime;
}

document.getElementById("earth_time_check").addEventListener("click", showEarthTime);

//question 8
function showMarsTime()
{
    let timeNow = new Date();
    let per =687;
    let earthDays = timeNow.getTime()/1000/60/60/24;
    let marsYearsArray = String((1970+ earthDays/per)).split(".");
    let marsYears = marsYearsArray[0];
    let marsDaysNumber = Number("0."+ marsYears[1] );
    let marsDaysArray = String(marsDaysNumber*per).split(".");
    let marsDays = marsDaysArray[0];
    document.getElementById("mars_time").innerHTML="Years: "+marsYears+", Days: "+marsDays; 

}
document.getElementById("mars_time_check").addEventListener("click", showMarsTime);

function showAlphTime()
{
    sendAdjaxGet("http://www.astropical.space/astrodb/api-exo.php?limit=alf Cen&format=json&which=name", displayAlphTime )

}

function sendAdjaxGet(url, func)
{
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"))
    xhr.onreadystatechange = function()
    {
        if(this.status==200 && this.readyState==4)
        {
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function displayAlphTime(xhr)
{
    timeNow =new Date();
    let response = xhr.response;
    let data = JSON.parse(response);
    let per =data.exoplanets[0].per;
    let earthDays = timeNow.getTime()/1000/60/60/24;
    let alphYearsArray = String((1970+ earthDays/per)).split(".");
    let alphYears = alphYearsArray[0];
    let alphDaysNumber = Number("0."+ alphYears[1] );
    let alphDaysArray = String(alphDaysNumber*per).split(".");
    let alphDays = alphDaysArray[0];
    document.getElementById("acb_time").innerHTML="Years: "+alphYears+", Days: "+alphDays; 

}
document.getElementById("acb_time_check").addEventListener("click", showAlphTime);

//Questions 9

function changeColorBackground()
{
    
    let r = (125+Math.floor(Math.random() * 125)).toString(16);
    let g = (125+Math.floor(Math.random() * 125)).toString(16);
    let b = (125+Math.floor(Math.random() * 125)).toString(16);
    let mycolor = "#" + r + g + b;
    //console.log(mycolor);
   document.getElementsByTagName("body")[0].style.backgroundColor =mycolor;
   
}

function changeThreeSeconds()
{
    window.setTimeout(changeColorBackground, 3000);
}
document.getElementsByTagName("h1")[0].addEventListener("click", changeThreeSeconds);

//Questions 10

window.onload = function(){calculate();}
function calculate()
{
    n1= document.getElementById("n1").value;
    n2= document.getElementById("n2").value;
    value = document.getElementById("operation").value;


    if(!isNaN(n1) && !isNaN(n2) )
    {
        if(value=="Add")
        {
            document.getElementById("result").innerHTML= Number(n1)+Number(n2);
        }
    else if(value=="Subtract")
        {
            document.getElementById("result").innerHTML= Number(n1)-Number(n2);
        }
    else if(value=="Divide")
        {
            if(Number(n2)!=0)
            {
                document.getElementById("result").innerHTML= Number(n1)/Number(n2);
            }
            else{
                document.getElementById("result").innerHTML= "Your Second Number Can't be Zero";
            }
            
        }
    else if(value=="Multiply")
        {
            document.getElementById("result").innerHTML= Number(n1)*Number(n2);
        }
    }
    else{
        document.getElementById("result").innerHTML= "Inputs must be number";
    }

    window.setTimeout(calculate, 500);
}
//quesiton11
function walkTheDom(node, func){
    
    let kids = node.children;
    for(let i=0; i<kids.length; i++)
    {
        walkTheDom(kids[i], func);
    }
    func(node);

}

function printNode(node)
{
    console.log(node.nodeName);
}



