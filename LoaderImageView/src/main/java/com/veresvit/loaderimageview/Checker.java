/*
 * See the file "LICENSE" for the full license governing this code.
 */

package com.veresvit.loaderimageview;

class Checker {

	static boolean isUsed(String input) {
		return input != null && input.length() > 0;
	}

	static boolean isUsed(int input) {
		return input > 0;
	}
}
