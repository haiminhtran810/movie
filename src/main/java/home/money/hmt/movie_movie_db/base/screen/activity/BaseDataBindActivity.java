package home.money.hmt.movie_movie_db.base.screen.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import home.money.hmt.movie_movie_db.base.viewmodel.BaseViewModel;

/**
 * Created by hcm-102-0006 on 15/06/2018.
 */

public abstract class BaseDataBindActivity<T extends ViewDataBinding, K extends BaseViewModel>
        extends BaseActivity {
    protected T mBinding;
    protected K mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mViewModel != null) {
            mViewModel.onActivityDestroyed();
        }
    }

    protected abstract int getLayoutId();

    protected abstract void init();
}
