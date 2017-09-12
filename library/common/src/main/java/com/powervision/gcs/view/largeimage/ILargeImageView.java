package com.powervision.gcs.view.largeimage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;

import com.powervision.gcs.view.largeimage.factory.BitmapDecoderFactory;

/**
 * Created by sundy on 2017/9/12.
 */
interface ILargeImageView {

    int getImageWidth();

    int getImageHeight();

    boolean hasLoad();

    void setOnImageLoadListener(BlockImageLoader.OnImageLoadListener onImageLoadListener);

    void setImage(BitmapDecoderFactory factory);

    void setImage(BitmapDecoderFactory factory, Drawable defaultDrawable);

    void setImage(Bitmap bm);

    void setImage(Drawable drawable);

    void setImage(@DrawableRes int resId);

    void setImageDrawable(Drawable drawable);

    void setScale(float scale);

    float getScale();

    BlockImageLoader.OnImageLoadListener getOnImageLoadListener();
}
