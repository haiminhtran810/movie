package home.money.hmt.movie_movie_db.screen.main.popular;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import home.money.hmt.movie_movie_db.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment extends Fragment {

    public static PopularFragment newInstance() {
        // Required empty public constructor
        return new PopularFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular, container, false);
    }
}
