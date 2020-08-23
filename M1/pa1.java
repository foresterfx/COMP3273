/*******************************************************************************
* AUTHOR: Joseph Forester Warren
* DATE: 08/2020
* COURSE: COMP3273
* AU ID: JFW0006
* FILE NAME: pa1.java
*******************************************************************************/
import java.io.File; // Write to files
import java.util.Scanner; // Scan user input
import java.util.Random; // Random number generator

/*****************************************************************
*************************** OBJECTIVES ***************************
******************************************************************
* EXPLORE TIME COMPLEXITY & "REAL TIME" 
* PRACTICE PROGRAMMING SKILLS 
******************************************************************
****************************** GOALS *****************************
******************************************************************
* TRANSPOSE nXn MATRIX 
* COLLECT EXECUTION TIME T(n) AS A FUNCTION OF n 
* PLOT THE FUNCTIONS T(n)/n, T(n)/n^2, T(n)/n^3*
* ANALYSIS OF TIME COMPLEXITY
*****************************************************************/
public class pa1 {
/*****************************************************************
* Main - prompts user for input then begins transposition.
* @param args Main
*****************************************************************/
   public static void main(String[] args) {
      int dataL = matrixSize(); // prompts user for input - must be valid int
      String file = outputName(); // Allows user to name the file
      stdArray(dataL, file); // Creates Array, Transposes, Times, Files
      System.out.print("\n\nDone.");
   }
    
   /*****************************************************************
   * Prompts user for valid integer input for matrix size.
   * @return - returns LxL size of matrix
   *****************************************************************/
   public static int matrixSize() {
      Scanner scan = new Scanner(System.in);
      System.out.println("*** Forester's Matrix Complexity Program ***\n");
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
   * @return - returns the name of the file chosen by user
   *****************************************************************/
   public static String outputName() {
      Scanner scan = new Scanner(System.in);
      System.out.print("Output Filename: ");
      String retry = null;
      do { // Ensures file has a name.
         retry = scan.nextLine();
         if (retry.isEmpty()) {
            System.out.print("Invalid. Please Try Again.\n"
               + "Output Filename: ");
         }
      } while (retry.isEmpty());
      
      return retry + ".csv"; // appends .csv to the file regardless
   }
   /*****************************************************************
   * Saves time information to CSV.
   * @param time - the time it takes to transpose N->L
   * @param dataFile - the name of the file to write to
   * @param n - the incrementing "n" for this run
   *****************************************************************/
   public static void writeCSV(long time, File dataFile, int n) 
      throws Exception {
      java.io.FileWriter dataSaved = new java.io.FileWriter(dataFile, true);
      java.io.BufferedWriter bufferedWriter 
         = new java.io.BufferedWriter(dataSaved);
      String timeString = Long.toString(time);
      String n1 = Integer.toString(n);
      String n2 = Integer.toString((int) Math.pow(n, 2));
      String n3 = Integer.toString((int) Math.pow(n, 3));
      
      double n2s = (double) (time / Math.pow(n, 2));
      double n3s = (double) (time / Math.pow(n, 3));
      
      bufferedWriter.write(timeString + "," + n + "," + n2 + "," 
         + n3 + "," + Long.toString(time / (long) n) + ","
         + Double.toString(n2s) + "," + Double.toString(n3s)
         + "\n");
      bufferedWriter.close();
   }
   /*****************************************************************
   * Populates array[n][n] with randomly selected numbers.
   * @param dataL - the whole random array
   * @param file - passing file name to next function
   *****************************************************************/    
   public static void stdArray(int dataL, String file) {
      int[][] array = new int[dataL][dataL];
      int n, hundos;
      Random rand = new Random(); // random number generator
   
      for (int i = 0; i < dataL; i++) {
         for (int j = 0; j < dataL; j++) {
            array[i][j] = (int) rand.nextInt(1000);
         }
      } // creates matrix of size LxL with random numbers
      hundos = 100; // current n value
      do { // transposes +=100 until n<=L
         transArray(hundos, array, file);
         hundos += 100; // increment n
      } while (hundos <= dataL); // n <= L
   }
   /*****************************************************************
   * Populates transArray[n][n] with randomly selected numbers.
   * @param n - the size of the transposed array
   * @param array - the non-transposed array
   * @param file - the name of the file to create
   *****************************************************************/
   public static void transArray(int n, int[][] array, String file) {
      int[][] transArray = new int[n][n];
      File dataFile = new File(file);
      try { // catches empty or irregular numbered LxL matrices
         long start = System.nanoTime(); // start of transposition
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               transArray[i][j] = array[j][i];
            }
         } 
         long stop = System.nanoTime(); // end of transposition
         
         //System.out.print("\nExecution Time (Nanoseconds) : "
            //+ (stop - start) + " nanoseconds "); // testing only
            
         writeCSV(stop - start, dataFile, n);
      } catch (Exception e) { }  
      
       
      // output(dataL, array, transArray); // testing only
   }
   /*****************************************************************
   * Prints the arrays for testing purposes only.
   * @param n - size of matrix
   * @param array - the actual matrix
   * @param transpose - the transposed matrix
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