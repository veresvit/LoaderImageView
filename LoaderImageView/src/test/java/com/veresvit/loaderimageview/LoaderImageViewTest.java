/*
 * See the file "LICENSE" for the full license governing this code.
 */

package com.veresvit.loaderimageview;

import android.content.Context;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LoaderImageViewTest {

	private Context context;
	private String testUri;
	private String testUriFail;
	private int resuourceId;

	@Before
	public void prepare() throws Exception {
		context = RuntimeEnvironment.application.getApplicationContext();
		testUri = "http://placekitten.com/g/500/500";
		testUriFail = "http://placekitten.m/g/500/500";
		resuourceId = 12345679;
	}

	@Test
	public void contextTest() throws Exception {
		LoaderImageView loaderImageView = new LoaderImageView(context);

		boolean isCreated = loaderImageView != null;
		Assert.assertEquals(true, isCreated);
	}

	@Test
	public void testGetUriIsNull() throws Exception {
		LoaderImageView loaderImageView = new LoaderImageView(context);

		String uri = loaderImageView.getUri();

		boolean isNull = uri == null;
		Assert.assertEquals(true, isNull);
	}

	@Test
	public void testGetUriIsSet() throws Exception {
		LoaderImageView loaderImageView = new LoaderImageView(context);
		loaderImageView.setUri(testUri);

		String uri = loaderImageView.getUri();

		boolean isUsed = uri != null;
		Assert.assertEquals(true, isUsed);
	}

	@Test
	public void testSetUriIsSame() throws Exception {
		LoaderImageView loaderImageView = new LoaderImageView(context);
		loaderImageView.setUri(testUri);

		String uri = loaderImageView.getUri();

		boolean isSame = uri.equals(testUri);
		Assert.assertEquals(true, isSame);
	}

	@Test
	public void testSetUriIsDifferent() throws Exception {
		LoaderImageView loaderImageView = new LoaderImageView(context);
		loaderImageView.setUri(testUri);

		String uri = loaderImageView.getUri();

		boolean isSame = uri.equals(testUriFail);
		Assert.assertEquals(false, isSame);
	}

	@Test
	public void testGetPlaceholderNotSet() throws Exception {
		LoaderImageView loaderImageView = new LoaderImageView(context);

		int placeholder = loaderImageView.getPlaceholder();

		boolean isNotSet = placeholder == 0;
		Assert.assertEquals(true, isNotSet);
	}

	@Test
	public void testGetPlaceholderIsSet() throws Exception {
		LoaderImageView loaderImageView = new LoaderImageView(context);
		loaderImageView.setPlaceholder(resuourceId);

		int placeholder = loaderImageView.getPlaceholder();

		boolean isSet = placeholder != 0;
		Assert.assertEquals(true, isSet);
	}

	@Test
	public void testSetPlaceholderIsSame() throws Exception {
		LoaderImageView loaderImageView = new LoaderImageView(context);
		loaderImageView.setPlaceholder(resuourceId);

		int placeholder = loaderImageView.getPlaceholder();

		boolean isSame = placeholder == resuourceId;
		Assert.assertEquals(true, isSame);
	}

	@Test
	public void testSetPlaceholderIsDifferent() throws Exception {
		LoaderImageView loaderImageView = new LoaderImageView(context);
		loaderImageView.setPlaceholder(resuourceId);

		int placeholder = loaderImageView.getPlaceholder();

		boolean isSame = placeholder == 15479;
		Assert.assertEquals(false, isSame);
	}

	@Test
	public void testGetErrorNotSet() throws Exception {
		LoaderImageView loaderImageView = new LoaderImageView(context);

		int error = loaderImageView.getError();

		boolean isSet = error != 0;
		Assert.assertEquals(false, isSet);
	}

	@Test
	public void testGetErrorIsSet() throws Exception {
		LoaderImageView loaderImageView = new LoaderImageView(context);
		loaderImageView.setError(resuourceId);

		int error = loaderImageView.getError();

		boolean isSet = error != 0;
		Assert.assertEquals(true, isSet);
	}

	@Test
	public void testSetErrorIsSame() throws Exception {
		LoaderImageView loaderImageView = new LoaderImageView(context);
		loaderImageView.setPlaceholder(resuourceId);

		int error = loaderImageView.getPlaceholder();

		boolean isSame = error == resuourceId;
		Assert.assertEquals(true, isSame);
	}

	@Test
	public void testSetErrorIsDifferent() throws Exception {
		LoaderImageView loaderImageView = new LoaderImageView(context);
		loaderImageView.setPlaceholder(resuourceId);

		int error = loaderImageView.getPlaceholder();

		boolean isSame = error == 132478;
		Assert.assertEquals(false, isSame);
	}
}