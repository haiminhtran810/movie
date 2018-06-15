package home.money.hmt.movie_movie_db.base.viewmodel;

import android.content.Context;
import android.databinding.Observable;
import android.support.v7.app.AppCompatActivity;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by hcm-102-0006 on 15/06/2018.
 */

public abstract class BaseViewModel implements Observable {
    private CompositeDisposable mDisposable;
    protected Context mContext;

    public BaseViewModel(Context context) {
        mContext = ((AppCompatActivity) context).getBaseContext();
        mDisposable = new CompositeDisposable();
    }

    public void addDisposable(Disposable disposable) {
        mDisposable.add(disposable);
    }

    public void onActivityDestroyed() {
        if (mDisposable != null) {
            mDisposable.clear();
            mDisposable.dispose();
            mDisposable = null;
        }
    }
}
