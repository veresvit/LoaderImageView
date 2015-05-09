/*
 * See the file "LICENSE" for the full license governing this code.
 */

/*
 * See the file "LICENSE" for the full license governing this code.
 */

package com.veresvit.loaderimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class LoaderImageView extends ImageView {
	public static final String TAG = LoaderImageView.class.getSimpleName();

	private Context mContext;

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
	}

	private void parseAttributes(AttributeSet attrs) {
		TypedArray typedAttributes = mContext.obtainStyledAttributes(attrs, R.styleable.LoaderImageView);

		final int attributeCount = typedAttributes.getIndexCount();
		for (int i = 0; i < attributeCount; i++) {
			int attrId = typedAttributes.getIndex(i);
			if (attrId == R.styleable.LoaderImageView_uri) {
				String uri = typedAttributes.getString(attrId);
				loadFromUri(uri);
			}
		}

		typedAttributes.recycle();
	}

	private void loadFromUri(String uri) {
		Picasso.with(mContext).load(uri).into(this);
	}
}
