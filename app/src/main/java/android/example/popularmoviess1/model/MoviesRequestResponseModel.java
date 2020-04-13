package android.example.popularmoviess1.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesRequestResponseModel {
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("results")
    private List<MoviesModel> moviesModelList;

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<MoviesModel> getMoviesModelList() {
        return moviesModelList;
    }

    public void setMoviesModelList(List<MoviesModel> moviesModelList) {
        this.moviesModelList = moviesModelList;
    }
}
