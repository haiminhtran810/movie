package home.money.hmt.movie_movie_db.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by hcm-102-0006 on 15/06/2018.
 */

public class ActivityUtils {
    public static void startActivity(Context context, Class activity, Bundle bundle, int flag) {
        Intent intent = new Intent(context, activity);
        if (flag != 0) {
            intent.setFlags(flag);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    public static void startActivityForResult(@NonNull Activity activity,
            @NonNull Class activityClass, Bundle bundle, int code) {
        Intent intent = new Intent(activity, activityClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        activity.startActivityForResult(intent, code);
    }

    public static void replaceFragment(@NonNull FragmentManager fragmentManager,
            @NonNull Fragment fragment, int frameId, boolean addToBackStack) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment, fragment.getClass().getSimpleName());
        if (addToBackStack) {
            transaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        transaction.commit();
    }

    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
            @NonNull Fragment fragment, int frameId) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(frameId, fragment);
                transaction.commit();
            }
        });
    }
}
