package home.money.hmt.movie_movie_db.screen.main.toprate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import home.money.hmt.movie_movie_db.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopRateFragment extends Fragment {

    public static TopRateFragment newInstance() {
        // Required empty public constructor
        return new TopRateFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_rate, container, false);
    }
}
