package home.money.hmt.movie_movie_db.data;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by hcm-102-0006 on 15/06/2018.
 */

public abstract class AppSubscribe<T> extends DisposableObserver<T> {
    private T object;

    @Override
    public void onComplete() {
        onSuccess(object);
    }

    @Override
    public void onError(Throwable e) {
        onErrorLoad(e);
    }

    @Override
    public void onNext(T t) {
        object = t;
    }

    public abstract void onSuccess(T response);

    public abstract void onErrorLoad(Throwable e);
}
