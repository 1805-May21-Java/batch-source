// function makeLink()
// {
//     var vannara = "Vannara's Website";
//     var jersey = "Jersey's Website";
//     result1 = vannara.link("www.ralify.com");





//     document.getElementById("mylink").innerHTML()=result1;
// }

function myFunction() {
    var str = "Free Web Building Tutorials!";
    var result = str.link("https://www.w3schools.com");
    document.getElementById("demo").innerHTML = result;
}

function factorial(number)
{
    var array =[];
    for(i = 1; i<=number;i++)
    if(number==0 || number==1)
    {
        array[i]=i;
    }
    else{
        array[i]=array[i-1]*i
    }
return array[number];
}

function reverseNumber(number)
{
    var string = number.toString();
    var array = string.split("");
    var result =[];
    for (i=0; i<array.length; i++)
    {
        result.push (array.pop());
    }
    return result;
}
