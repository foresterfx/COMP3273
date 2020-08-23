/*******************************************************************************
* AUTHOR: Joseph Forester Warren
* DATE: 08/2020
* COURSE: COMP3273
* AU ID: JFW0006
* FILE NAME: pa1_jfw0006.cpp
* COMPILE: g++ pa1_jfw0006.cpp -o pa1
* RUN: ./pa1
*
*******************************************************************************/

#include <iostream> // input from user
#include <fstream> // file creation
#include <cstdlib> // for exit()
#include <ctime> // local time

using namespace std;

/*****************************************************************
* FUNCTION PROTOTYPES ********************************************
******************************************************************
* sort(int[], int, int[], int)
*		sorts the file arrays into one array
* writeFile(int[][] trans, int)
*		creates output file of new sorted array
*****************************************************************/
int sort(int array1[], int a1Size, int array2[], int a2Size, int output[]);
void writeFile(int output[], int outputSize);


/*****************************************************************
* MAIN - Function for entire program's output. *******************
*****************************************************************/
int main() {
/*****************************************************************
* VARIABLE INITIALIZATION ****************************************
*****************************************************************/
	ifstream inStream;
	int n;
	int outputSize;
	int output[50];
	srand(time(0)); // random numbers
	/*****************************************************************
	* STANDARD INPUT/OUTPUT AND FUNCTION CALLING BEGINS HERE *********
	*****************************************************************/
	cout << "\n*** Welcome to Forester's Matrix Transpose Program ***\n";
	// first file input
	cout << "Enter the square dimensions of the array: ";
	cin >> n;
	cout << n << "\n";

	int arr[n][n];
	int trans[n][n];
	/*****************************************************************
	* GENERATING RANDOM NUMBERS FOR ARRAY OF SIZE N STARTS ***********
	*****************************************************************/
	for(int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			arr[i][j] = rand() %100;
		}
	}
	/*****************************************************************
	* PRINTING NUMBERS FOR ARRAY OF SIZE N STARTS ********************
	*****************************************************************/
	cout << "****************\n*Standard Array*\n****************\n";
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << arr[i][j] << " ";
		}
		cout << "\n";
	}
	/*****************************************************************
	* TRANSPOSING NUMBERS FOR T_ARRAY OF SIZE N STARTS ***************
	*****************************************************************/
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			trans[i][j] = arr[j][i];
		}
	}
	/*****************************************************************
	* PRINTING NUMBERS FOR T_ARRAY OF SIZE N STARTS ******************
	*****************************************************************/
	cout << "******************\n*Transposed Array*\n******************\n";
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << trans[i][j] << " ";
		}
		cout << "\n";
	}

	outputSize = n;
	string outputFile; // local variable for output file name
	cout << "\nEnter the output file name: ";
	cin >> outputFile; // user picks file name
	ofstream finalFile(outputFile.c_str());
    for (int i = 0; i < n; i++)
    {
		for (int j = 0; j < n; j++) {
			finalFile << arr[i][j] << " ";
		}
    } // adds output array numbers to new file
	cout << "*** Please check the new file - " << outputFile << " ***\n"
				<< "*** Goodbye ***\n";
	
}

/*****************************************************************
* writeFile(int[], int)
* 	Writes the sorted data into a new single output file.
*****************************************************************/
// void writeFile(int output[], int outputSize) {
// 	string outputFile; // local variable for output file name
// 	cout << "\nEnter the output file name: ";
// 	cin >> outputFile; // user picks file name
// 	ofstream finalFile(outputFile.c_str());
//     for (int i = 0; i < outputSize; i++)
//     {
//       finalFile << output[i] << endl;
//     } // adds output array numbers to new file
// 	cout << "*** Please check the new file - " << outputFile << " ***\n"
// 				<< "*** Goodbye ***\n";
// }