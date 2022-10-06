//https://www.geeksforgeeks.org/weighted-job-scheduling/
//O(n*2n)
// JAVA program for weighted job scheduling using Naive Recursive Method
import java.util.*;
class GFG
{

// A job has start time, finish time and profit.
static class Job
{
	int start, finish, profit;
	Job(int start, int finish, int profit)
	{
		this.start = start;
		this.finish = finish;
		this.profit = profit;
	}
}

// Find the latest job (in sorted array) that doesn't
// conflict with the job[i]. If there is no compatible job,
// then it returns -1.
static int latestNonConflict(Job arr[], int i)
{
	for (int j = i - 1; j >= 0; j--)
	{
		if (arr[j].finish <= arr[i - 1].start)
			return j;
	}
	return -1;
}

// A recursive function that returns the maximum possible
// profit from given array of jobs. The array of jobs must
// be sorted according to finish time.
static int findMaxProfitRec(Job arr[], int n)
{
	// Base case
	if (n == 1) return arr[n-1].profit;

	// Find profit when current job is included
	int inclProf = arr[n-1].profit;
	int i = latestNonConflict(arr, n);
	if (i != -1)
	inclProf += findMaxProfitRec(arr, i+1);

	// Find profit when current job is excluded
	int exclProf = findMaxProfitRec(arr, n-1);

	return Math.max(inclProf, exclProf);
}

// The main function that returns the maximum possible
// profit from given array of jobs
static int findMaxProfit(Job arr[], int n)
{
	// Sort jobs according to finish time
	Arrays.sort(arr,new Comparator<Job>(){
	public int compare(Job j1,Job j2)
		{
		return j1.finish-j2.finish;
		}
	});

	return findMaxProfitRec(arr, n);
}

// Driver program
public static void main(String args[])
{
int m = 4;
Job arr[] = new Job[m];
	arr[0] = new Job(3, 10, 20);
	arr[1] = new Job(1, 2, 50);
	arr[2] = new Job(6, 19, 100);
	arr[3] = new Job(2, 100, 200);
	int n =arr.length;
	System.out.println("The optimal profit is " + findMaxProfit(arr, n));
}
}

// This code is contributed by Debojyoti Mandal
