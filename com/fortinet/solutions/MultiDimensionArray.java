package com.fortinet.solutions;

public class MultiDimensionArray {
	// This is a provided function, Assume it works
	public static Long getValue(int... indexOfDimension) {
		// ...
		return value;
	}

	// lengthOfDeminsion: each dimension's length, assume it is valid:
	// lengthOfDeminsion[i]>0.
	public static Long sum(MultiDimensionArray mArray, int[] lengthOfDeminsion) {
		// Your resolution
		// Time complexity: O(n + mk -m)
		// n -> number of elements in array with length 1
		// m -> number elements in array with length k
		// Space complexity:

		long sum = 0;

		for (int i = 0; i < lengthOfDeminsion.length; i++) {
			if (lengthOfDeminsion[i] != 1) {
				for (int j = 0; j < lengthOfDeminsion[i]; j++) {
					sum += getValue(i, j);
				}
			} else {
				sum += getValue(i);
			}
		}

		return sum;
	}
	// JUnit test cases
}
