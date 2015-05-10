/*
 * See the file "LICENSE" for the full license governing this code.
 */

package com.veresvit.loaderimageview;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CheckerTest {

	@Test
	public void testIsUsedStringUsed() throws Exception {
		String usedString = "testString";
		boolean isUsed = Checker.isUsed(usedString);
		Assert.assertEquals(true, isUsed);
	}

	@Test
	public void testIsUsedStringNull() throws Exception {
		String nullString = null;
		boolean isUsed = Checker.isUsed(nullString);
		Assert.assertEquals(false, isUsed);
	}

	@Test
	public void testIsUsedStringEmpty() throws Exception {
		String emptyString = "";
		boolean isUsed = Checker.isUsed(emptyString);
		Assert.assertEquals(false, isUsed);
	}

	@Test
	public void testIsUsedReferenceUsedPositive() throws Exception {
		int usedRefId = 123456789;
		boolean isUsed = Checker.isUsed(usedRefId);
		Assert.assertEquals(true, isUsed);
	}

	@Test
	public void testIsUsedReferenceUsedNegative() throws Exception {
		int usedRefId = -165;
		boolean isUsed = Checker.isUsed(usedRefId);
		Assert.assertEquals(true, isUsed);
	}

	@Test
	public void testIsUsedReferenceNotUsed() throws Exception {
		int usedRefId = 0;
		boolean isUsed = Checker.isUsed(usedRefId);
		Assert.assertEquals(false, isUsed);
	}
}