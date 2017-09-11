package com.powervision.gcs.glide;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

public abstract class ProgressTarget<T, Z> extends WrappingTarget<Z> implements OkHttpProgressGlideModule.UIProgressListener {
    private T model;
    private boolean ignoreProgress = true;

    public ProgressTarget(T model, Target<Z> target) {
        super(target);
        this.model = model;
    }

    public final T getModel() {
        return model;
    }

    public final void setModel(T model) {
       // Glide.clear(this); // indirectly calls cleanup
        this.model = model;
    }

    /**
     * Convert a model into an Url string that is used to match up the OkHttp requests. For explicit
     * {@link com.bumptech.glide.load.model.GlideUrl GlideUrl} loads this needs to return
     * {@link com.bumptech.glide.load.model.GlideUrl#toStringUrl toStringUrl}. For custom models do the same as your
     * {@link com.bumptech.glide.load.model.stream.BaseGlideUrlLoader BaseGlideUrlLoader} does.
     *
     * @param model return the representation of the given model, DO NOT use {@link #getModel()} inside this method.
     * @return a stable Url representation of the model, otherwise the progress reporting won't work
     */
    protected String toUrlString(T model) {
        return String.valueOf(model);
    }

    @Override
    public float getGranualityPercentage() {
        return 1.0f;
    }

    private void start() {
        OkHttpProgressGlideModule.expect(toUrlString(model), this);
        ignoreProgress = false;
    }

    private void cleanup() {
        ignoreProgress = true;
        T model = this.model; // save in case it gets modified
        OkHttpProgressGlideModule.forget(toUrlString(model));
        this.model = null;
    }

    @Override
    public void onLoadStarted(Drawable placeholder) {
        super.onLoadStarted(placeholder);
        start();
    }

    @Override
    public void onResourceReady(Z resource, Transition<? super Z> transition) {
        cleanup();
        super.onResourceReady(resource, transition);
    }

    @Override
    public void onLoadFailed(Drawable errorDrawable) {
        cleanup();
        super.onLoadFailed(errorDrawable);
    }

    @Override
    public void onLoadCleared(Drawable placeholder) {
        cleanup();
        super.onLoadCleared(placeholder);
    }
}