package com.powervision.gcs.network;

<<<<<<< HEAD
=======
import android.app.ProgressDialog;
>>>>>>> f683a358151577515462e24eae4ba1121c84beff
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

<<<<<<< HEAD
import rx.Subscriber;

/**
 * BaseSubscriber
 * Created by Tamic on 2016-08-03.
 */
public abstract class BaseSubscriber<T> extends Subscriber<T> {

    private Context context;
    private boolean isNeedCahe;

    public BaseSubscriber(Context context) {
        this.context = context;
=======
import com.powervision.gcs.utils.NetworkUtil;

import io.reactivex.subscribers.DisposableSubscriber;


/**
 *
 */
public abstract class BaseSubscriber<T> extends DisposableSubscriber<T> {

    private Context context;
    private ProgressDialog progress;

    public BaseSubscriber(Context context) {
        this.context = context;
        progress = new ProgressDialog(context);
        progress.setMessage("novate拼命加载中....");
>>>>>>> f683a358151577515462e24eae4ba1121c84beff
    }

    @Override
    public void onError(Throwable e) {
        Log.e("Tamic", e.getMessage());
        // todo error somthing
<<<<<<< HEAD

=======
        if (progress != null && progress.isShowing()) {
            progress.dismiss();
        }
>>>>>>> f683a358151577515462e24eae4ba1121c84beff
        if(e instanceof ExceptionHandle.ResponeThrowable){
            onError((ExceptionHandle.ResponeThrowable)e);
        } else {
            onError(new ExceptionHandle.ResponeThrowable(e, ExceptionHandle.ERROR.UNKNOWN));
        }
    }

<<<<<<< HEAD

    @Override
    public void onStart() {
        super.onStart();

=======
    @Override
    public void onComplete() {
        if (progress != null && progress.isShowing()) {
            progress.dismiss();
        }
        Toast.makeText(context, "http is Complete", Toast.LENGTH_SHORT).show();
    }


   @Override
    public void onStart() {
>>>>>>> f683a358151577515462e24eae4ba1121c84beff
        Toast.makeText(context, "http is start", Toast.LENGTH_SHORT).show();

        // todo some common as show loadding  and check netWork is NetworkAvailable
        // if  NetworkAvailable no !   must to call onCompleted
        if (!NetworkUtil.isNetworkAvailable(context)) {
            Toast.makeText(context, "无网络，读取缓存数据", Toast.LENGTH_SHORT).show();
<<<<<<< HEAD
            onCompleted();
        }

    }

    @Override
    public void onCompleted() {

        Toast.makeText(context, "http is Complete", Toast.LENGTH_SHORT).show();
        // todo some common as  dismiss loadding
    }


    public abstract void onError(ExceptionHandle.ResponeThrowable e);
=======
            onComplete();
        }

       if (progress != null){
           if (progress.isShowing()) {
               progress.dismiss();
           }
           progress.show();
       }
    }


   public abstract void onError(ExceptionHandle.ResponeThrowable e);
>>>>>>> f683a358151577515462e24eae4ba1121c84beff

}
