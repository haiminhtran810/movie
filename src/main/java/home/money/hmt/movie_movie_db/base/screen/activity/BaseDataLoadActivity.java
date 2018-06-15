package home.money.hmt.movie_movie_db.base.screen.activity;

import android.app.ProgressDialog;
import android.databinding.ViewDataBinding;
import home.money.hmt.movie_movie_db.base.viewmodel.BaseDataLoadViewModel;

/**
 * Created by hcm-102-0006 on 15/06/2018.
 */

public abstract class BaseDataLoadActivity<T extends ViewDataBinding, K extends BaseDataLoadViewModel>
        extends BaseDataBindActivity<T, K> {
    protected ProgressDialog mProgressDialog;

}
