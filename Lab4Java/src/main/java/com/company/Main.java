package com.company;

import java.util.Scanner;
class Polynom{
    float[] polynom;
    Polynom(float[] polynom){
        this.polynom=polynom;
    }
    Polynom(){
    }
}
class Division
{
    Polynom quotient;
    Polynom remainder;
    Division(){
        remainder=new Polynom();
        quotient=new Polynom();
    }
    public void divide(boolean flag,Polynom dividend,Polynom divisor)
    {


        if (dividend.polynom[dividend.polynom.length-1] == 0)
        {
            throw new ArithmeticException("Старший член многочлена діленого не може бути 0");
        }
        if (divisor.polynom[divisor.polynom.length-1] == 0)
        {
            throw new ArithmeticException("Старший член многочлена дільника не може бути 0");
        }
        remainder.polynom = (float[])dividend.polynom.clone();
        quotient.polynom = new float[remainder.polynom.length - divisor.polynom.length + 1];
        for (int i = 0; i < quotient.polynom.length; i++)
        {
            float multiplier = remainder.polynom[remainder.polynom.length - i - 1] / divisor.polynom[divisor.polynom.length-1];
            quotient.polynom[quotient.polynom.length - i - 1] = multiplier;
            if(flag){
                System.out.print("Крок № "+(i+1)+"\nМножник:\n");
                System.out.print(quotient.polynom[quotient.polynom.length - i - 1]+"x^"+(quotient.polynom.length - i - 1));

                System.out.println("\nОстача:");
            }

            for (int j = 0; j < divisor.polynom.length; j++)
            {
                remainder.polynom[remainder.polynom.length - i - j - 1] -= multiplier * divisor.polynom[divisor.polynom.length - j - 1];
                if(flag){

                    System.out.print( (remainder.polynom[remainder.polynom.length - i - j - 1] >= 0 ? "+" : "")+(remainder.polynom[remainder.polynom.length - i - j - 1])+"x^"+(remainder.polynom.length - i - j - 1));
                }

            }
            if(flag){
                System.out.println();
            }

        }
    }
}

public class Main{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        boolean flag=true;


        float[] dividendArr = { 5, 7, -5, 6, -1};
        float[] divisorArr = { 5, 2 ,1};

        Division m=new Division();
        Polynom dividend =new Polynom(dividendArr);
        Polynom divisor =new Polynom(divisorArr);
        flag=sc.nextBoolean();
        m.divide(flag,dividend,divisor);
        System.out.println("Ціла частина:");
        for (int i = 0; i < m.quotient.polynom.length; i++)
        {
            if (m.quotient.polynom[m.quotient.polynom.length - i - 1] != 0)
            {
                System.out.print((m.quotient.polynom[m.quotient.polynom.length - i - 1] >= 0 ? "+" : "")+m.quotient.polynom[m.quotient.polynom.length - i - 1]+"x^"+(m.quotient.polynom.length - i - 1));
                //Console.WriteLine("{0}{1}*x^{2}", quotient[quotient.length - i - 1] >= 0 ? "+" : "", quotient[quotient.length - i - 1], quotient.length - i - 1);
            }
        }
        System.out.println();
        System.out.println("Остача:");
        for (int i = 0; i < m.remainder.polynom.length; i++)
        {
            if (m.remainder.polynom[m.remainder.polynom.length - i - 1] != 0)
            {
                System.out.print((m.remainder.polynom[m.remainder.polynom.length - i - 1] >= 0 ? "+" : "")+(m.remainder.polynom[m.remainder.polynom.length - i - 1])+("x^")+(m.remainder.polynom.length - i - 1));
                //Console.WriteLine("{0}{1}*x^{2}", remainder[remainder.Length - i - 1] >= 0 ? "+" : "", remainder[remainder.Length - i - 1], remainder.Length - i - 1);
            }
        }
        System.out.println();
    }
}
