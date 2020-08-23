/*******************************************************************************
* AUTHOR: Joseph Forester Warren
* DATE: 08/2020
* COURSE: COMP3273
* AU ID: JFW0006
* FILE NAME: pa1.java
*******************************************************************************/
//import java.io.*;
//import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

/*****************************************************************
* 
*****************************************************************/
public class pa1 {
/*****************************************************************
* 
*****************************************************************/
   public static void main(String args[]) {
   
      Scanner scan = new Scanner(System.in);
   
      System.out.println("*** Welcome to Forester's Matrix Complexity Program ***");
      int n = getN(); // prompts user for input - must be valid integer
   
      int arr[][] = new int[n][n]; // initial matrix initialized
   
      Random rand = new Random(); // random number generator
   
   /*****************************************************************
   * Populates array[n][n] with randomly selected numbers
   *****************************************************************/
      // for(int i=0;i<n;i++) {
         // for(int j=0;j<n;j++) {
            // arr[i][j] = (int)rand.nextInt(1000);
         // }
      // }
      arr = stdArray(n);
   
      int transpose[][] = new int[n][n];   
   
      long start = System.nanoTime();
   
      for(int i=0;i<n;i++) {
         for(int j =0;j<n;j++) {
            transpose[i][j] = arr[j][i];
         }
      }
   
      long stop = System.nanoTime();
   
      long milliseconds = (stop - start) / 1000000;
   
      System.out.println("\nExecution Time (In nanoseconds) : " + (stop - start) + " nanoseconds ");
   
      System.out.println("\nExecution Time (In milliseconds) : " + milliseconds + " milliseconds ");
   
      System.out.println("\nBefore Transpose:\n\n");
      for(int i=0;i<n;i++) {
         for(int j=0;j< n;j++) {
            System.out.print(arr[i][j]+" ");
         }
         System.out.println("\n");
      }
   
      System.out.println("\nAfter Transpose:\n\n");
      for(int i=0;i<n;i++) {
         for(int j=0;j<n;j++) {
            System.out.print(transpose[i][j]+" ");
         }
         System.out.println("\n");
      }
   }
   
   /*****************************************************************
   * Prompts user for valid integer input.
   *****************************************************************/
   public static int getN() {
      Scanner scan = new Scanner(System.in);
      String prompt = "Enter the square dimension of the array(n): ";
      Integer retry = null;
      do {
         System.out.print("* Enter the square dimension of the array (n): ");
         String str = scan.nextLine();
         try {
            retry = Integer.parseInt(str);
         }
         catch(IllegalArgumentException e) { // invalid
            System.out.println("Invalid Input. Please try again with an integer.");
         }
      } while(retry == null);
      
      return retry;
   }
   
   public static int[][] stdArray(int n) {
      int array2[][] = new int[n][n];
      
      Random rand = new Random(); // random number generator
   
      for(int i=0;i<n;i++) {
         for(int j=0;j<n;j++) {
            array2[i][j] = (int)rand.nextInt(1000);
         }
      }
      return array2;
   }
}