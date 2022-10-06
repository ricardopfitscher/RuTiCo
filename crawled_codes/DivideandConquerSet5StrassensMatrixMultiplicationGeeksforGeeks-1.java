//https://www.geeksforgeeks.org/strassens-matrix-multiplication/
//O(n^3)
// java code
static int multiply(int A[][N], int B[][N], int C[][N])
{
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			C[i][j] = 0;
			for (int k = 0; k < N; k++)
			{
				C[i][j] += A[i][k]*B[k][j];
			}
		}
	}
}

// This code is contributed by shivanisinghss2110
