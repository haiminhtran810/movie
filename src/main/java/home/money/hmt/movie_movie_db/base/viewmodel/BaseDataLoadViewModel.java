package home.money.hmt.movie_movie_db.base.viewmodel;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.widget.Toast;

/**
 * Created by hcm-102-0006 on 15/06/2018.
 */

public abstract class BaseDataLoadViewModel extends BaseViewModel {
    public ObservableBoolean isDataLoading = new ObservableBoolean();

    public BaseDataLoadViewModel(Context context) {
        super(context);
    }

    protected abstract void loadData();

    protected abstract void onLoadSuccess();

    protected void showError(Exception e) {
        Toast.makeText(mContext, "Message : " + e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    protected void onLoadFail(Exception e) {
        e.printStackTrace();
        isDataLoading.set(false);
        showError(e);
    }
}
