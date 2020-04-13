package android.example.popularmoviess1.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MoviesParcelable implements Parcelable {
    private String movieTitle,releaseDate,posterUrl,voteAverage,plot;

    public MoviesParcelable(String movieTitle, String releaseDate, String posterUrl, String voteAverage, String plot) {
        this.movieTitle = movieTitle;
        this.releaseDate = releaseDate;
        this.posterUrl = posterUrl;
        this.voteAverage = voteAverage;
        this.plot = plot;
    }

    private MoviesParcelable(Parcel in) {
        movieTitle = in.readString();
        releaseDate = in.readString();
        posterUrl = in.readString();
        voteAverage = in.readString();
        plot = in.readString();
    }

    public static final Creator<MoviesParcelable> CREATOR = new Creator<MoviesParcelable>() {
        @Override
        public MoviesParcelable createFromParcel(Parcel in) {
            return new MoviesParcelable(in);
        }

        @Override
        public MoviesParcelable[] newArray(int size) {
            return new MoviesParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(movieTitle);
        dest.writeString(releaseDate);
        dest.writeString(posterUrl);
        dest.writeString(voteAverage);
        dest.writeString(plot);
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public String getPlot() {
        return plot;
    }
}
