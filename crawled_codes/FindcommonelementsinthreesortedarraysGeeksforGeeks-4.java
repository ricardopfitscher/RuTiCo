//https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/
//O(n1 + n2 + n3)
#include <bits/stdc++.h>
using namespace std;

void findCommon(int a[], int b[], int c[], int n1, int n2,
				int n3)
{
	// three sets to maintain frequency of elements
	unordered_set<int> uset, uset2, uset3;
	for (int i = 0; i < n1; i++) {
		uset.insert(a[i]);
	}
	for (int i = 0; i < n2; i++) {
		uset2.insert(b[i]);
	}
	// checking if elements of 3rd array are present in
	// first 2 sets
	for (int i = 0; i < n3; i++) {
		if (uset.find(c[i]) != uset.end()
			&& uset2.find(c[i]) != uset.end()) {
			// using a 3rd set to prevent duplicates
			if (uset3.find(c[i]) == uset3.end())
				cout << c[i] << " ";
			uset3.insert(c[i]);
		}
	}
}

// Driver code
int main()
{
	int ar1[] = { 1, 5, 10, 20, 40, 80 };
	int ar2[] = { 6, 7, 20, 80, 100 };
	int ar3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };
	int n1 = sizeof(ar1) / sizeof(ar1[0]);
	int n2 = sizeof(ar2) / sizeof(ar2[0]);
	int n3 = sizeof(ar3) / sizeof(ar3[0]);

	cout << "Common Elements are " << endl;
	findCommon(ar1, ar2, ar3, n1, n2, n3);
	return 0;
}
