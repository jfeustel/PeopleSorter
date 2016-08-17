import java.io.*;
import java.util.*;
import java.math.*; 
/**
 * Reads people's names and eating preference from a given file. 
 * Sorts the valid people into text files based on their eating preference.
 * Writes invalid input to invalid file.
 * 
 * @author J Feustel
 * @version 4/8/2014
 */
public class Lab7
{
   public static void main (String[] args)
   {
      BufferedReader in = null;
      PrintWriter outNormal = null;
      PrintWriter outVegetarian = null;
      PrintWriter outPescetarian = null;
      PrintWriter outInvalid = null;
      BigInteger bigZero = new BigInteger("0");
      BigInteger bigOne = new BigInteger("1");
      BigInteger bigTwo = new BigInteger("2");
      try
      {
         in = new BufferedReader(new FileReader("lab7input.txt"));
         
         outNormal = new PrintWriter(new File("normal.txt"));
         outVegetarian = new PrintWriter(new File("vegetarian.txt"));
         outPescetarian = new PrintWriter(new File("pescetarian.txt"));
         outInvalid = new PrintWriter(new File("invalid.txt"));
         
         String line = in.readLine();
         while (line != null)
         {
            String[] splitArray = line.split(" ");
            if(splitArray.length == 3 && isNumber(splitArray[2]))
            {
               BigInteger foodNumber = new BigInteger(splitArray[2]);
               if(foodNumber.equals(bigZero))
               {
                  outNormal.println(splitArray[0] + " " + splitArray[1]);
               }
               else if(foodNumber.equals(bigOne))
               {
                   outVegetarian.println(splitArray[0] + " " + splitArray[1]);
               }
               else if(foodNumber.equals(bigTwo))
               {
                   outPescetarian.println(splitArray[0] + " " + splitArray[1]);
               }
               else
               {
                   outInvalid.println(splitArray[0] + " " + splitArray[1]);
               }
            }  
            else if(splitArray.length == 4 && isNumber(splitArray[3]))
            {
               BigInteger foodNumber = new BigInteger(splitArray[3]);
               if(foodNumber.equals(bigZero))
               {
                  outNormal.println(splitArray[0] + " " + splitArray[1] + " " + splitArray[2]);
               }
               else if(foodNumber.equals(bigOne))
               {
                  outVegetarian.println(splitArray[0] + " " + splitArray[1] + " " + splitArray[2]);
               }
               else if(foodNumber.equals(bigTwo))
               {
                  outPescetarian.println(splitArray[0] + " " + splitArray[1] + " " + splitArray[2]);
               }
               else
               {
                  outInvalid.println(splitArray[0] + " " + splitArray[1] + " " + splitArray[2]);
               }
            }
            else
            {
               for(int i = 0; i < splitArray.length - 1; i++)
               {
                  outInvalid.print(splitArray[i] + " ");
               }
               outInvalid.println("");
            }
            line = in.readLine();
         }
         outNormal.close();
         outVegetarian.close();
         outPescetarian.close();
         outInvalid.close();
      }
      
      catch (FileNotFoundException ex)
      {
         System.out.println("A file was not found: " + ex);
      }
      catch (IOException ex)
      {
         System.out.println("Something bad happened while reading the input file: " + ex);
      }
      catch (Exception ex)
      {
         System.out.println("Something bad happened: " + ex);
      }
      finally
      {
         try
         {
            if (in != null)
               in.close();
         }
         catch (IOException ex)
         {
            System.out.println("There was a problem closing the input file: " + ex);
         }
      }
   }
   
   public static boolean isNumber(String inString)
   {
      return inString.matches("-?\\d+(\\.\\d+)?");
   }
}
