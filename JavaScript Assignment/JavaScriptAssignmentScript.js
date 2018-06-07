
function maxLength(arr)
{
    let x = "";
    let y = "";
    let z = "";
    for(i = 0; i < arr.length-1; i++)
    {
        y = arr[i];
        x = arr[i+1];
        if(x.length > y.length)
        {
            z = x;
        }
        else
        {
            z = y;
        }

    }
    console.log(z);
}

function reverseArray(arr)
{
    let reverse = arr.reverse();
    console.log(reverse);
}

function vowelCount(str)
{
    let vowels = 0;
    str = str.toLowerCase();
    for(i = 0; i<str.length; i++)
    {
        if(str[i] == 'a')
        {
            vowels++;
        }
        if(str[i] == 'e')
        {
            vowels++;
        }
        if(str[i] == 'i')
        {
            vowels++;
        }
        if(str[i] == 'o')
        {
            vowels++;
        }
        if(str[i] == 'u')
        {
            vowels++;
        }
        if(str[i] == 'y')
        {
            vowels++;
        }

    }
    console.log(vowels);
}

function removeScript(str)
{
    let script = 'Script';
    if(str.includes(str))
    {
        str = str.replace('Script', '');
        console.log(str);
    }
}

function isLeapYear(date = new Date )
{
    if(date.getFullYear()%4 == 0)
    {
        if(date.getFullYear()%100 != 0)
        {
            console.log(date.getFullYear()+' is a leap year');
        }
        else
        {
            if(date.getFullYear()%400 == 0)
            {
                console.log(date.getFullYear()+' is a leap year');
            }
            else
            {
                console.log(date.getFullYear()+' is not a leap year');
            }
        }
    }
    else
    {
        console.log(date+' is not a leap year');
    }
}

function isValidEmail(str)
{
    if(str.includes('@') && str.includes('.com'))
    {
        console.log('Email is valid');
    }
    else
    {
        console.log('Email is not valid');
    }
}

function removeChar(str, x)
{
    str = str.replace(str.charAt(x), "");
    console.log(str);
}

function bubbleSort(numArr)
{
    let temp = 0;
    for(i = 0; i<numArr.length; i++)
    {
        for(j = 0; j<numArr.length-1; j++)
        {
            if(numArr[j] > numArr[j+1])
            {
                temp = numArr[j+1];
                numArr[j+1] = numArr[j];
                numArr[j] = temp;
            }
        }
    }
    return numArr;
}

function isEven(num)
{
    let result = num/2;
    let isEven = Math.floor(result)*2;

    if(isEven == num)
    {
        return true;
    }
    else
    {
        return false;
    }
}

function isPalindrome(str)
{
    let palindrome = "";
    let arr = str.split("");
    arr = arr.reverse();
    palindrome = arr.join("");

    if(palindrome == str)
    {
        return true;
    }
    else
    {
        return false;
    }
}

function printShape(shape,height,character)
{
    let temp ="";

    switch(shape)
    {
        case "Triangle":
        {
            for(i = 1; i <=height; i++)
            {
                for(j = i; j > 0 ; j--)
                {
                    temp += character;
                }
                temp += '\n';
            }
            console.log(temp);
            break;
        }
        case "Square":
        {
            for(i = 0; i<height; i++)
            {
                for(j = 0; j<height; j++ )
                {
                    temp += character;
                }
                temp +='\n';
            }
            console.log(temp);
            break;
        }
        case "Diamond":
        {
            for(i = 1; i<= height; i +=2)
            {  
                for(j = 0; j < height-i/2; j++)
                {
                    temp +=" ";
                }
                for(k = 0; k < i; k++)
                {
                    temp += character;
                }
                temp += '\n';
            }

            for(a = height-2; a > 0; a -=2)
            {
                for(b = 0; b < height-a/2; b++)
                {
                    temp += " ";
                }
                for(c = 0; c < a; c++)
                {
                    temp += character;
                }
                temp += "\n";
            }
            console.log(temp);
            break;
        }
    }
}

function rotate(arr, n)
{   
    if(n <= 0)
    {
        return arr;
    }
    else
    {
        let temp = arr.shift();
        arr = arr.concat(temp);
        return rotate(arr, n-1);
    }
}

function balanced(str)
{
    let isBalanced = true;
    
    for(i = 0; i< str.length; i++)
    {
        if(str.charAt(i) == '(' && str.charAt(str.length-1-i) != ')')
        {

            if(str.charAt(i) == '(' && str.charAt(i+1) != ')')
            {
                isBalanced = false;
            } 
        }
        if(str.charAt(i) == '[' && str.charAt(str.length-1-i) != ']')
        {
            if(str.charAt(i) == '[' && str.charAt(i+1) != ']')
            {
                isBalanced = false;
            }
        }
        if(str.charAt(i) == '{' && str.charAt(str.length-1-i) != '}')
        {
            if(str.charAt(i) == '{' && str.charAt(i+1) != '}')
            {
                isBalanced = false;
            }
        }
        
           
    }
    return isBalanced;

}