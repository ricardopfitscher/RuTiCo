//https://www.geeksforgeeks.org/multiply-two-polynomials-2/
//O(n^2)
// Java program to multiply two polynomials
class GFG
{

	// A[] represents coefficients
	// of first polynomial
	// B[] represents coefficients
	// of second polynomial
	// m and n are sizes of A[] and B[] respectively
	static int[] multiply(int A[], int B[],
							int m, int n)
	{
		int[] prod = new int[m + n - 1];

		// Initialize the product polynomial
		for (int i = 0; i < m + n - 1; i++)
		{
			prod[i] = 0;
		}

		// Multiply two polynomials term by term
		// Take ever term of first polynomial
		for (int i = 0; i < m; i++)
		{
			// Multiply the current term of first polynomial
			// with every term of second polynomial.
			for (int j = 0; j < n; j++)
			{
				prod[i + j] += A[i] * B[j];
			}
		}

		return prod;
	}

	// A utility function to print a polynomial
	static void printPoly(int poly[], int n)
	{
		for (int i = 0; i < n; i++)
		{
			System.out.print(poly[i]);
			if (i != 0)
			{
				System.out.print("x^" + i);
			}
			if (i != n - 1)
			{
				System.out.print(" + ");
			}
		}
	}

	// Driver code
	public static void main(String[] args)
	{
		// The following array represents
		// polynomial 5 + 10x^2 + 6x^3
		int A[] = {5, 0, 10, 6};

		// The following array represents
		// polynomial 1 + 2x + 4x^2
		int B[] = {1, 2, 4};
		int m = A.length;
		int n = B.length;

		System.out.println("First polynomial is n");
		printPoly(A, m);
		System.out.println("nSecond polynomial is n");
		printPoly(B, n);

		int[] prod = multiply(A, B, m, n);

		System.out.println("nProduct polynomial is n");
		printPoly(prod, m + n - 1);
	}
}

// This code contributed by Rajput-Ji
