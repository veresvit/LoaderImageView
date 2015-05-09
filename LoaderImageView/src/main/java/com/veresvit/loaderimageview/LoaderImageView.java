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

/**
 * ImageView extension with support for async loading of images from an URI, with ability to set a placeholder or an error image.
 */
public class LoaderImageView extends ImageView {

	public static final String TAG = LoaderImageView.class.getSimpleName();

	// Inflater
	private Context mContext;

	// Attributes
	private String mUri;
	private int mPlaceholder;
	private int mError;

	/**
	 * Basic constructor.
	 *
	 * @param context Inflater.
	 */
	public LoaderImageView(Context context) {
		this(context, null);
	}

	/**
	 * Constructor with attributes from XML.
	 *
	 * @param context Inflater.
	 * @param attrs   View attributes such as uri or placeholder.
	 */
	public LoaderImageView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	/**
	 * Constructor with attributes from XML and style.
	 *
	 * @param context      Inflater.
	 * @param attrs        View attributes such as uri or placeholder.
	 * @param defStyleAttr Default style of the view.
	 */
	public LoaderImageView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.mContext = context;
		parseAttributes(attrs);
		load();
	}

	/**
	 * Checks whether the URI attribute is set. Loads the image if yes.
	 */
	public void load() {
		if (Checker.isUsed(mUri)) {
			createRequest();
		}
	}

	/**
	 * Invalidates cache for the currently loaded URI.
	 */
	public void invalidateCache() {
		Picasso.with(mContext).invalidate(mUri);
	}

	/**
	 * Creates Picasso request with the given URI. Sets the given attributes.
	 */
	private void createRequest() {
		RequestCreator requestCreator = Picasso.with(mContext).load(mUri);

		if (Checker.isUsed(mPlaceholder))
			requestCreator = requestCreator.placeholder(mPlaceholder);
		if (Checker.isUsed(mError))
			requestCreator = requestCreator.error(mError);

		requestCreator.into(this);
	}

	/**
	 * Parses set attributes.
	 *
	 * @param attrs Attributes from XML.
	 */
	private void parseAttributes(AttributeSet attrs) {
		TypedArray typedAttributes = mContext.obtainStyledAttributes(attrs, R.styleable.LoaderImageView);

		final int attributeCount = typedAttributes.getIndexCount();
		for (int i = 0; i < attributeCount; i++) {
			int attrId = typedAttributes.getIndex(i);

			if (attrId == R.styleable.LoaderImageView_uri) {
				mUri = typedAttributes.getString(attrId);
			} else if (attrId == R.styleable.LoaderImageView_placeholder) {
				mPlaceholder = typedAttributes.getResourceId(attrId, 0);
			} else if (attrId == R.styleable.LoaderImageView_error) {
				mError = typedAttributes.getResourceId(attrId, 0);
			}
		}

		typedAttributes.recycle();
	}

	/**
	 * Gets current URI.
	 *
	 * @return Current URI.
	 */
	public String getUri() {
		return mUri;
	}

	/**
	 * Sets a new URI.
	 *
	 * @param uri String URI to set.
	 */
	public void setUri(String uri) {
		this.mUri = uri;
	}

	/**
	 * Gets current placeholder.
	 *
	 * @return Placeholder resource ID.
	 */
	public int getPlaceholder() {
		return mPlaceholder;
	}

	/**
	 * Sets a new placeholder.
	 *
	 * @param placeholderResource Placeholder resource. Example: R.drawable.placeholder
	 */
	public void setPlaceholder(int placeholderResource) {
		this.mPlaceholder = placeholderResource;
	}

	/**
	 * Gets current loading error.
	 *
	 * @return Loading error resource ID.
	 */
	public int getError() {
		return mError;
	}

	/**
	 * Sets a new loading error.
	 *
	 * @param errorResource Loading error resource. Example: R.drawable.error
	 */
	public void setError(int errorResource) {
		this.mError = errorResource;
	}
}