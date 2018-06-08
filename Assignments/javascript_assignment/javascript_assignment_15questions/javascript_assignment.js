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
var myNumArray = [1,34,2, 4,65, 7];
var bubbleSort = function(numArray)
    {
        var temp=0;
        for(i=0; i<numArray.length;i++)
        {
            for(j=0; j<numArray.length-1;j++)
            {
                var temp =numArray[j];
                if(numArray[j]>numArray[j+1])
                    {
                    
                        numArray[j]=numArray[j+1];
                        numArray[j+1]=temp;
                    }
            }
        }
        return numArray;
    }

    //9
var isEven = function(someNum)
    {
        if(someNum&1==1)
        {
            return false;
        }
            
        return true;
    }

    //10
var isPalindrome = function (someStr)
    {
        for(i=0, j=someStr.length-1; i<someStr.length/2;i++, j--)
        {
            if(someStr.charAt(i)!=someStr.charAt(j)) return false;
        }
        return true;
    }


    //11
function printShape(shape, height, sym)
{
    
    if(shape=="square")
    {
        for(i=1; i<=height; i++)
        {
            string = "";
            for(j=1; j<=height; j++)
            {
                string+=sym;
               
            }
            console.log(string);
        }
    }
    else if(shape=="triangle")
        {
            for(i=1; i<=height; i++)
            {
                string = "";
                for(j=1; j<=i; j++)
                {
                    string+=sym;
                }
                console.log(string);
            }
        }
    else if(shape=="diamond")
        {
            var key1=(height+1)/2;
            var key2=(height+1)/2;
            var string = "";
            for(i=1; i<=height;i++)
                {
                    string ="";
                    for(j=1;j<=height;j++)
                    {
                        if(key1<=j && key2>=j)
                            {
                                string+=sym;
                            }
                            else
                            {
                                string +=" ";
                            } 
                    }
                    if(i<(height+1)/2)
                    {
                        key1--;
                        key2++;
                    }
                    else if(i>=(height+1)/2)
                    {
                        key1++;
                        key2--;
                    }
                    console.log(string);
                }
                
        }
    

    }

    //12
    function rotate(array, n)
    {
        var number = n%array.length;
        for(i =0; i<number; i++)
        {
            var shift = array.shift();
            array.push(shift);
        }
        return array;
    }

    
    //13
    function balanced(string)
    {
        
        var array = string.split("");
        var stack = [];
        for(i=0; i<array.length;i++)
        {
            var currentSign = array[i];
            if(currentSign=="(" || currentSign=="{" || currentSign=="[")
            {
                stack.push(currentSign);

            }
            if(currentSign=="}" || currentSign==")" || currentSign=="]")
            {
                if(stack.length==0)
                {
                    return false;
                }
                
                peak = stack.pop();
                stack.push(peak);
                if(currentSign=="}" && peak=="{")
                    {
                        stack.pop();
                    } 
                else if(currentSign=="]" && peak=="[")
                {
                    stack.pop();
                }       
                else if(currentSign==")" && peak=="(")
                {
                    stack.pop();
                } 
                else
                {
                    return false;
                }
            }
        }
        if(stack.length==0)
        {
            return true;
        }
            return false;
    }