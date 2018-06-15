package home.money.hmt.movie_movie_db.data.module;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hcm-102-0006 on 15/06/2018.
 */

public class Movie implements Parcelable{
    @SerializedName("id")
    private String mId;
    @SerializedName("vote_average")
    private float mVoteAverage;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("overview")
    private String mOverview;
    @SerializedName("poster_path")
    private String mPosterPath;

    protected Movie(Parcel in) {
        mId = in.readString();
        mVoteAverage = in.readFloat();
        mTitle = in.readString();
        mOverview = in.readString();
        mPosterPath = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mId);
        parcel.writeFloat(mVoteAverage);
        parcel.writeString(mTitle);
        parcel.writeString(mOverview);
        parcel.writeString(mPosterPath);
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public float getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        mVoteAverage = voteAverage;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }
}
