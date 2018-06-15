package home.money.hmt.movie_movie_db.screen.main;

import android.support.v4.app.Fragment;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import home.money.hmt.movie_movie_db.R;
import home.money.hmt.movie_movie_db.base.screen.activity.BaseDataLoadActivity;
import home.money.hmt.movie_movie_db.databinding.ActivityMainBinding;
import home.money.hmt.movie_movie_db.screen.main.favorite.FavoriteFragment;
import home.money.hmt.movie_movie_db.screen.main.popular.PopularFragment;
import home.money.hmt.movie_movie_db.screen.main.profile.ProfileFragment;
import home.money.hmt.movie_movie_db.screen.main.toprate.TopRateFragment;
import home.money.hmt.movie_movie_db.utils.ActivityUtils;

public class MainActivity extends BaseDataLoadActivity<ActivityMainBinding, MainViewModel> {

    private AHBottomNavigation mAHBottomNavigation;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        if (mViewModel == null) {
            mViewModel = new MainViewModel(this);
        }
        setupBotNavigation();
    }

    private void setupBotNavigation() {
        mAHBottomNavigation = mBinding.tabBarMovie;
        AHBottomNavigationAdapter navigationAdapter =
                new AHBottomNavigationAdapter(this, R.menu.menu_tab_bar);
        navigationAdapter.setupWithBottomNavigation(mAHBottomNavigation);
        mAHBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        mAHBottomNavigation.setDefaultBackgroundColor(
                getResources().getColor(android.R.color.holo_blue_bright));
        mAHBottomNavigation.setOnTabSelectedListener(
                new AHBottomNavigation.OnTabSelectedListener() {
                    @Override
                    public boolean onTabSelected(int position, boolean wasSelected) {
                        onClickBottomNavigation(position);
                        return true;
                    }
                });
        mAHBottomNavigation.setCurrentItem(0);
    }

    private boolean onClickBottomNavigation(int position) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container_content);
        if (fragment == null) {
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    PopularFragment.newInstance(), R.id.container_content);
            return true;
        } else {
            switch (position) {
                case Tab_Position.TAB_POPULAR:
                    ActivityUtils.replaceFragment(getSupportFragmentManager(),
                            PopularFragment.newInstance(), R.id.container_content, false);
                    return true;
                case Tab_Position.TAB_TOP_RATE:
                    ActivityUtils.replaceFragment(getSupportFragmentManager(),
                            TopRateFragment.newInstance(), R.id.container_content, false);
                    return true;
                case Tab_Position.TAB_TOP_FAVORITE:
                    ActivityUtils.replaceFragment(getSupportFragmentManager(),
                            FavoriteFragment.newInstance(), R.id.container_content, false);
                    return true;
                case Tab_Position.TAB_TOP_PROFILE:
                    ActivityUtils.replaceFragment(getSupportFragmentManager(),
                            ProfileFragment.newInstance(), R.id.container_content, false);
                    return true;
            }
        }
        return true;
    }

    interface Tab_Position {
        int TAB_POPULAR = 0;
        int TAB_TOP_RATE = 1;
        int TAB_TOP_FAVORITE = 2;
        int TAB_TOP_PROFILE = 3;
    }
}
