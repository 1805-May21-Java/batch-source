package com.revature.question2;

//Fibonacci Series using Recursion
class Fibonnaci
{
    static int fib(int n)
    {
    if (n <= 1)
       return n;
    return fib(n-1) + fib(n-2);
    }
      

}