/*
 * See the file "LICENSE" for the full license governing this code.
 */

package com.veresvit.loaderimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class LoaderImageView extends ImageView {

	public static final String TAG = LoaderImageView.class.getSimpleName();

	// Inflater
	private Context mContext;

	// Attributes
	private String mUri;
	private int mPlaceholder;
	private int mError;

	public LoaderImageView(Context context) {
		this(context, null);
	}

	public LoaderImageView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public LoaderImageView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.mContext = context;
		parseAttributes(attrs);
		refresh();
	}

	public void refresh() {
		if (Checker.isUsed(mUri)) {
			createRequest();
		}
	}

	private void createRequest() {
		RequestCreator requestCreator = Picasso.with(mContext).load(mUri);

		if (Checker.isUsed(mPlaceholder))
			requestCreator = requestCreator.placeholder(mPlaceholder);
		if (Checker.isUsed(mError))
			requestCreator = requestCreator.error(mError);

		requestCreator.into(this);
	}

	private void parseAttributes(AttributeSet attrs) {
		TypedArray typedAttributes = mContext.obtainStyledAttributes(attrs, R.styleable.LoaderImageView);

		final int attributeCount = typedAttributes.getIndexCount();
		for (int i = 0; i < attributeCount; i++) {
			int attrId = typedAttributes.getIndex(i);

			if (attrId == R.styleable.LoaderImageView_uri) {
				mUri = typedAttributes.getString(attrId);
			} else if (attrId == R.styleable.LoaderImageView_placeholder) {
				mPlaceholder = typedAttributes.getResourceId(attrId, -1);
			} else if (attrId == R.styleable.LoaderImageView_error) {
				mError = typedAttributes.getResourceId(attrId, -1);
			}
		}

		typedAttributes.recycle();
	}
}
