package home.money.hmt.movie_movie_db.base.viewmodel;

import android.content.Context;
import android.databinding.ObservableBoolean;

/**
 * Created by hcm-102-0006 on 15/06/2018.
 */

public abstract class BaseDataLoadRefreshViewModel<T> extends BaseDataLoadViewModel {
    public ObservableBoolean isRefreshing = new ObservableBoolean();
    public BaseDataLoadRefreshViewModel(Context context) {
        super(context);
    }
}
