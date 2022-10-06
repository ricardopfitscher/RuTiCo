//https://www.geeksforgeeks.org/write-a-function-to-generate-3-numbers-according-to-given-probabilities/
//O(1)
// This function generates 'x' with probability px/100, 'y'
// with probability py/100 and 'z' with probability pz/100:
// Assumption: px + py + pz = 100 where px, py and pz lie
// between 0 to 100
static int random(int x, int y, int z, int px, int py,
				int pz)
{
	// Generate a number from 1 to 100
	int r = (int)(Math.random() * 100);

	// r is smaller than px with probability px/100
	if (r <= px)
		return x;

	// r is greater than px and smaller than or equal to
	// px+py with probability py/100
	if (r <= (px + py))
		return y;

	// r is greater than px+py and smaller than or equal to
	// 100 with probability pz/100
	else
		return z;
}

// This code is contributed by subhammahato348.
