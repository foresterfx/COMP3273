/*******************************************************************************
* AUTHOR: Joseph Forester Warren
* DATE: 08/2020
* COURSE: COMP3273
* AU ID: JFW0006
* FILE NAME: pa1.java
*******************************************************************************/
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;

/*****************************************************************
* 
*****************************************************************/
public class pa1 {
/*****************************************************************
* 
*****************************************************************/
   public static void main(String[] args) {
      int dataL = matrixSize(); // prompts user for input - must be valid int
      String file = outputName();
      stdArray(dataL, file);
      
   }
    
   /*****************************************************************
   * Prompts user for valid integer input for matrix size.
   *****************************************************************/
   public static int matrixSize() {
      Scanner scan = new Scanner(System.in);
      System.out.println("*** Forester's Matrix Complexity Program ***");
      Integer retry = null;
      do {
         System.out.print("Enter the square dimension of the array (L): ");
         String str = scan.nextLine();
         try {
            retry = Integer.parseInt(str);
         }
         catch (IllegalArgumentException e) { // invalid
            System.out.println("Invalid. Please Try Again.");
         }
      } while (retry == null);
      
      return retry;
   }
   /*****************************************************************
   * Prompts user for output file name.
   *****************************************************************/
   public static String outputName() {
      Scanner scan = new Scanner(System.in);
      System.out.print("Output Filename: ");
      String retry = null;
      do {
         retry = scan.nextLine();
         if (retry.isEmpty()) {
            System.out.print("Invalid. Please Try Again.\n"
               + "Output Filename: ");
         }
      } while (retry.isEmpty());
      
      return retry + ".csv";
   }
   /*****************************************************************
   * Saves time information to CSV.
   *****************************************************************/
   public static void writeCSV(long time, File dataFile) throws Exception {
      java.io.FileWriter dataSaved = new java.io.FileWriter(dataFile, true);
      java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(dataSaved);
      bufferedWriter.write(Long.toString(time) + "\n");
      bufferedWriter.close();
   }
   /*****************************************************************
   * Populates array[n][n] with randomly selected numbers.
   *****************************************************************/    
   public static void stdArray(int dataL, String file) {
      int[][] array = new int[dataL][dataL];
      int n, hundos;
      Random rand = new Random(); // random number generator
   
      for (int i = 0; i < dataL; i++) {
         for (int j = 0; j < dataL; j++) {
            array[i][j] = (int) rand.nextInt(1000);
         }
      }
      hundos = 100;
      n = 0;
      do {
         transArray(n, hundos, array, file);
         hundos += 100;
         n += 100;
      } while (n < dataL && n < hundos);
   }
   /*****************************************************************
   * Populates transArray[n][n] with randomly selected numbers.
   *****************************************************************/
   public static void transArray(int n, int dataL, int[][] array, String file) {
      int[][] transArray = new int[100][100];
      File dataFile = new File(file);
      try {
         long start = System.nanoTime(); // start of transposition
         for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
               transArray[i][j] = array[j+n][i+n];
            }
         }
         long stop = System.nanoTime(); // end of transposition
         System.out.print("\nExecution Time (Nanoseconds) : " 
            + (stop - start) + " nanoseconds "); //same
         writeCSV(stop - start, dataFile);
      } catch (Exception e) { }   
   }
   
   
   // public static void transArray(int n, int[][] array) {
      // long start = System.nanoTime(); // 
      // int[][] transArray = new int[n][n];
      // for (int i = 0; i < n; i++) {
         // for (int j = i + 1; j < n; j++) {
            // transArray[i][j] = array[j][i];
         // }
      // }
      // long stop = System.nanoTime(); // 
      // long milliseconds = (stop - start) / 1000000; // same
   //    //output(n, array, transArray);   
      // System.out.print("\nExecution Time (In nanoseconds) : " 
         // + (stop - start) + " nanoseconds "); //same
      // System.out.print("\nExecution Time (In milliseconds) : " 
         // + milliseconds + " milliseconds "); //same
      // System.out.print("\nExecution Time (In milliseconds) : " 
         // + milliseconds + " milliseconds "); //same
   //         
   // }
   /*****************************************************************
   * Prints the arrays.
   *****************************************************************/
   public static void output(int n, int[][] array, int[][] transpose) {
      System.out.println("\nBefore Transpose:\n");
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            System.out.print(array[i][j] + " ");
         }
         System.out.print("\n");
      }
   
      System.out.println("\nAfter Transpose:\n");
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            System.out.print(transpose[i][j] + " ");
         }
         System.out.print("\n");
      }
   }   
}