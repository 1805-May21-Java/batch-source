// 1
var fruits = ["Banana", "Orange", "Apple", "Mango"];
maxLength = function(arr)
    {
        var max =0;
        for(i=0; i<arr.length;i++)
        {
            if(max<arr[i].length)
            {
                max=arr[i].length;
            }
        }
        return max;
    }
//2
var apple =["a", "b", "c", "d"];
var reverseArray = function(arr)
    {
        var temp=[];
        for(i=arr.length-1; i>=0;i--)
        {
            temp.push(arr[i]);
        }
        return temp;
        //return arr.reverse();
    }
//3
var coconut = "coconut";

var vowelCount = function(string)
    {
    var count=0, newString = string.toLowerCase();
    for(i=0; i<string.length;i++)
        {
            if(newString[i]=='a' ||  newString[i]=='e' || newString[i]=='i' ||  newString[i]=='o'||newString[i]=='u')
                count++;
        }
        return count;
    }
//4
var removeScript = function(myString)
    {
        while(myString.includes("Script"))
        {
            myString = myString.replace("Script", "");
        }
        return myString;
    }

//5
//var mydate = new Date('4000-10-29');
var isLeapYear= function(mydate)
    {
        if((mydate.getFullYear()%4==0 && mydate.getFullYear()%100!=0) || mydate.getFullYear()%400==0)
            return true;
        return false;
    }

//6
var isValidEmail = function (email)
{
    var rex = /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
    return rex.test(email);
}
var email1="evannara@gmail.com";
var email2="evannara@gmail.ca.edu";
var email3="evannara@gmail.org";
var email4="evannara@gmail.ca";
var email5="evannara.houth@utexas.edu";
var email0="evannara+ra@gmail.com";


var email6="evannara@gmail.ca.edu.edu";
var email7="evannara@gmail.ca._du";
var email8="eva#nnara@gmail.com";
var email9="eva*nnara@gmail.com";
var email10="evannara@gm$ail.com";
//7
var removeChar = function(string, index)
    {
          return string.substring(0,index)+string.substring(index+1,string.length);

    }

//8
var bubbleSort = function(numArray)
    {
        var temp=0;
        for(i=0; i<numArray.length;i++)
        {
            for(j=0; j<numArray.length-1;j++)
            {
                if(numArray[i]>numArray[j])
                    {
                        temp=numArray[j];
                        numArray[j]=numArray[i];
                        numArray[i]=temp;
                    }
            }
        }
    }