package KT1;

import java.io.*;
import java.util.Scanner;

public class Counter       {

  public static void main (String[] args)throws FileNotFoundException {

      Scanner reader = new Scanner(new File("numbers.txt"));    
      int count=0;
      int max=0;
      int num1;
      int num2;   

      while (reader.hasNextInt())  {        
         num1=reader.nextInt();
         count++;
         if (!reader.hasNextInt()) {
             System.out.println("The File has an odd number of Integers");
             break;
         }
         num2=reader.nextInt(); 
         count++;        

         if (num1>num2) max = num1;
         else           max = num2;
      }
      System.out.println("The file had " + count + " number(s)");

   }

}