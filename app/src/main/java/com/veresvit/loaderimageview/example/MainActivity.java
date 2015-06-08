/*
 * See the file "LICENSE" for the full license governing this code.
 */

package com.veresvit.loaderimageview.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.veresvit.example.R;
import com.veresvit.loaderimageview.LoaderImageView;

public class MainActivity extends AppCompatActivity {

	private LoaderImageView uriImageAtRuntime;
	private LoaderImageView allAtRuntime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
	}

	private void initViews() {
		uriImageAtRuntime = (LoaderImageView) findViewById(R.id.uriImageAtRuntime);
		allAtRuntime = (LoaderImageView) findViewById(R.id.allAtRuntime);

		loadUriImageAtRuntime();
		loadAllAtRuntime();
	}

	private void loadUriImageAtRuntime() {
		uriImageAtRuntime.setUri("http://placekitten.com/g/800/650");

		uriImageAtRuntime.load();
	}

	private void loadAllAtRuntime() {
		allAtRuntime.setError(R.drawable.error);
		allAtRuntime.setPlaceholder(R.drawable.placeholder);
		allAtRuntime.setUri("http://placekitten.com/g/800/660");

		allAtRuntime.load();
	}
}