package com.admas.property.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LevenshteinDistance {

	/** The logger. */
	static Logger logger = LoggerFactory.getLogger(LevenshteinDistance.class);
	public static int getDistance(String source, String target) {

		// String length should not be null
		if (source == null || target == null) {
			throw new IllegalArgumentException("Strings must not be null");
		}

		// set length of both string in two variables
		int lengthSource = source.length();
		int lengthTarget = target.length();

		int distance[][] = new int[(lengthSource + 1)][(lengthTarget + 1)];
		try {
			// if anyone string is zero return opposite sting lenght
			if (lengthSource == 0) {
				return lengthTarget;
			} else if (lengthTarget == 0) {
				return lengthSource;
			}
			// initial array with initial values
			// initial array with initial values of y co-ordinates
			for (int i = 0; i <= lengthSource; i++) {
				distance[i][0] = i;
			}
			// initial array with initial values of x co-ordinates

			for (int j = 0; j <= lengthTarget; j++) {
				distance[0][j] = j;
			}

			// Fill the measurement in the array

			int editVal = 1;
			for (int i = 1; i <= lengthSource; i++) {
				for (int j = 1; j <= lengthTarget; j++) {
					if (source.charAt(i - 1) == target.charAt(j - 1)) {
						editVal = 0;
					} else {
						editVal = 1;
					}
					//check the min from given tree number of formuls
					//distance[i,j] = Min { distance[i-1,j]+1,distance[i][j - 1] + 1, distance[i - 1][j - 1]+ editVal}
					
					distance[i][j] = getMin(distance[i - 1][j] + 1,
							distance[i][j - 1] + 1, distance[i - 1][j - 1]
									+ editVal);
				}
			}
		} catch (ArithmeticException e) {
			logger.error("Error in LevenshteinDistance ",e);
		}catch (Exception e) {
			logger.error("Error in LevenshteinDistance ",e);
		}
		return distance[lengthSource][lengthTarget];
	}

	public  static int getMin(int firstVal, int bsecondVal, int thirdVal) {
		if (bsecondVal < firstVal) {
			firstVal = bsecondVal;
		}
		if (thirdVal < firstVal) {
			firstVal = thirdVal;
		}
		return firstVal;
	}

	public static void main(String[] args) {
		LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
		System.out.println("Edit distance : -> "
				+ levenshteinDistance.getDistance("Amol", "Asmita"));
	}

}
