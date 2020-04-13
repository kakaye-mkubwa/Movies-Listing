package android.example.popularmoviess1.retrofit;

import android.example.popularmoviess1.model.MoviesRequestResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {
    @GET("movie/popular")
    Call<MoviesRequestResponseModel> getPopularMovies(@Query("api_key") String apiKey);

    @GET("movie/top_rated")
    Call<MoviesRequestResponseModel> getTopRatedMovies(@Query("api_key") String apiKey);
}
