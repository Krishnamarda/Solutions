package com.fortinet.solutions;

import java.util.Iterator;
import java.util.List;

public class SplitInGroups {

	public static boolean separate(List<Integer> list, int k) {
		// Your resolution
		// Time complexity:
		// Space complexity:

		// in case only 1 group, whole array is 1 group
		if (k == 1)
			return true;

		// if number of elemenets less than required groups, it is not possible
		if (list.size() < k)
			return false;

		// the sum of array elements must be divisible by number of groups
		// required
		long sumOfElements = 0;
		for (Integer integer : list) {
			sumOfElements += integer;
		}
		if (sumOfElements % k != 0)
			return false;

		// Creating array to store expected sum of each group
		long[] expectedSum = new long[k];

		// calculating sum expected for each group and initialize the array
		for (int i = 0; i < expectedSum.length; i++) {
			expectedSum[i] = sumOfElements / k;
		}

		return isKGroupPossible(list, list.size() - 1, expectedSum, k);
	}

	/**
	 * Check if given arraylist can be divided into k groups
	 * 
	 * @param list
	 *            Interger list to be divided into groups
	 * @param index
	 *            position of last element to be checked
	 * @param expectedSum
	 *            sum expected for each group
	 * @param k
	 *            number of groups
	 * @return
	 */
	public static boolean isKGroupPossible(List<Integer> list, int index, long[] expectedSum, int k) {

		// Check if each have required sums and all elements are grouped.
		// if yes return true else continue building groups
		if (checkGroupsSums(expectedSum, k))
			return true;

		// No more elements, return false
		if (index < 0)
			return false;

		boolean groupPossible = false;

		// Splits elements into groups recursively
		for (int i = 0; i < k; i++) {
			// check if sum can fit in group
			if (expectedSum[i] - list.get(index) >= 0) {
				expectedSum[i] = expectedSum[i] - list.get(index);
				// check recursively for other elements
				groupPossible = isKGroupPossible(list, index - 1, expectedSum, k);

				// if group possible return true
				if (groupPossible)
					return true;
				else // else remove element from current group to try in another
					expectedSum[i] = expectedSum[i] + list.get(index);
			}
		}
		return groupPossible;
	}

	/**
	 * Check if ramaining sum for each group is 0.
	 * 
	 * @param sumExpected
	 *            array to be verified
	 * @param k
	 *            size of group
	 * @return true if expected sum for each group is 0.
	 */
	private static boolean checkGroupsSums(long[] sumExpected, int k) {
		for (int i = 0; i < k; i++) {
			if (sumExpected[i] != 0)
				return false;
		}
		return true;
	}

	// JUnit test cases

}
