/*
 * See the file "LICENSE" for the full license governing this code.
 */

package com.veresvit.loaderimageview;

/**
 * Contains checks of the attributes.
 */
class Checker {

	/**
	 * Checks whether the input string is not null and has at least length 1.
	 *
	 * @param input Input string.
	 * @return True when the string is not null and length > 0, false otherwise.
	 */
	static boolean isUsed(String input) {
		return input != null && input.length() > 0;
	}

	/**
	 * Checks whether the input resource ID is valid.
	 *
	 * @param input Resource ID.
	 * @return True when ID is different from zero, false otherwise.
	 */
	static boolean isUsed(int input) {
		return input != 0;
	}
}
