//https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
//O(mn)
// Java program for the above approach
import java.util.*;

class GFG {

static int R = 6 ;
static int C = 5 ;

static void printMaxSubSquare(int M[][])
{
	int S[][] = new int[2][C], Max = 0;

	// set all elements of S to 0 first
	for (int i = 0; i < 2;i++){
	for (int j = 0; j < C;j++){
		S[i][j] =0;
	}
	}

	// Construct the entries
	for (int i = 0; i < R; i++){
	for (int j = 0; j < C; j++){

		// Compute the entrie at the current position
		int Entrie = M[i][j];
		if(Entrie != 0){
		if(j != 0){
			Entrie = 1 + Math.min(S[1][j - 1], Math.min(S[0][j - 1], S[1][j]));}}

		// Save the last entrie and add the new one
		S[0][j] = S[1][j];
		S[1][j] = Entrie;

		// Keep track of the max square length
		Max = Math.max(Max, Entrie);
	}
	}

	// Print the square
	System.out.print("Maximum size sub-matrix is: \n");
	for (int i = 0; i < Max; i++){
	for (int j = 0; j < Max;j++){
		System.out.print( "1 ");}
	System.out.println();
	}
}

// Driver Code
public static void main(String[] args) {
	int M[][] = {{0, 1, 1, 0, 1},
				{1, 1, 0, 1, 0},
				{0, 1, 1, 1, 0},
				{1, 1, 1, 1, 0},
				{1, 1, 1, 1, 1},
				{0, 0, 0, 0, 0}};

	printMaxSubSquare(M);

}
}

// This code is contributed by code_hunt.
