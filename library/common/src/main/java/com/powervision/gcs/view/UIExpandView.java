package com.powervision.gcs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;

import com.powervision.gcs.common.R;

/**
 * 自定义：可以伸展和收缩的view
 * Created by David on 2017/9/16.
 */
public class UIExpandView extends FrameLayout {
    private Button btn;
    private View mView;
    private Animation mExpandAnimation;
    private Animation mCollapseAnimation;
    private boolean mIsExpand;

    public UIExpandView(Context context) {
        this(context, null);
        // TODO Auto-generated constructor stub
    }

    public UIExpandView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        // TODO Auto-generated constructor stub
    }

    public UIExpandView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        initExpandView();
    }

    private void initExpandView() {
        mView = LayoutInflater.from(getContext()).inflate(R.layout.layout_expand, this, true);
        btn = mView.findViewById(R.id.button);
        mExpandAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.expand);
        mExpandAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setVisibility(View.VISIBLE);
            }
        });

        mCollapseAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.collapse);
        mCollapseAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setVisibility(View.GONE);
            }
        });
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isExpand()) {
                    Log.i("wwww", "onClick: 11111111111");
                    collapse();
                } else {
                    Log.i("wwww", "onClick: 222222222");
                    expand();
                }
            }
        });
    }

    public void collapse() {
        if (mIsExpand) {
            mIsExpand = false;
            clearAnimation();
            startAnimation(mExpandAnimation);
        }
    }

    public void expand() {
        if (!mIsExpand) {
            mIsExpand = true;
            clearAnimation();
            startAnimation(mCollapseAnimation);
        }
    }

    public boolean isExpand() {
        return mIsExpand;
    }

    public void setContentView() {
        View view = null;
        view = LayoutInflater.from(getContext()).inflate(R.layout.layout_expand, null);
        removeAllViews();
        addView(view);
    }

}