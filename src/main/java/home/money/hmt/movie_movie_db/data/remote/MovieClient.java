package home.money.hmt.movie_movie_db.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import home.money.hmt.movie_movie_db.BuildConfig;
import home.money.hmt.movie_movie_db.data.constants.Constants;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hcm-102-0006 on 15/06/2018.
 */

public class MovieClient {
    private static Retrofit retrofit = null;

    public static MovieAPI getApiInstance() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(Constants.TIME_OUT, TimeUnit.SECONDS);
        httpClient.readTimeout(Constants.TIME_OUT, TimeUnit.SECONDS);
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build();
        }
        return retrofit.create(MovieAPI.class);
    }
}
