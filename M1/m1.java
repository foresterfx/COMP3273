/*******************************************************************************
* AUTHOR: Joseph Forester Warren
* DATE: 08/2020
* COURSE: COMP3273
* AU ID: JFW0006
* FILE NAME: pa1.java
* COMPILE: g++ project4_jfw0006.cpp -o p4
* RUN: ./p4
*
*******************************************************************************/

import java.io.*;
import java.util.*;

public class m1
{


   public static void print_array(int[][] arr,int n)
   {
      for(int i=0;i<n;i++)
      {
         for(int j=0;j<n;j++)
         {
            System.out.print(arr[i][j]+" ");
         }
         System.out.println("\n");
      }
   }



   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
   
      Random random = new Random();
   
      System.out.print("\n\nEnter n : ");
      int n=sc.nextInt();
   
      int[][] arr=new int[n][n];
   
      int[][] result=new int[n][n];
   
      for(int i=0;i<n;i++)
      {
         for(int j=0;j<n;j++)
         {
            arr[i][j]=random.nextInt(100);
         }
      }
   
   
      System.out.println("\n\nBefore Transpose : \n\n");
      print_array(arr,n);
   
      for(int i=0;i<n;i++)
      {
         for(int j=0;j<n;j++)
         {
            result[i][j]=arr[j][i];
         }
      }
      sc.close();
      System.out.println("\n\nAfter Transpose : \n\n");
      print_array(result,n);
   }
}