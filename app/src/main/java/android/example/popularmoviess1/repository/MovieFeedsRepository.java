package android.example.popularmoviess1.repository;

import android.example.popularmoviess1.model.MoviesRequestResponseModel;
import android.example.popularmoviess1.retrofit.ApiRequest;
import android.example.popularmoviess1.retrofit.RetrofitRequest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieFeedsRepository {
    private static final String TAG = MovieFeedsRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    private static final String API_KEY = "";

    public MovieFeedsRepository() {
        apiRequest = RetrofitRequest.getRetrofit().create(ApiRequest.class);
    }

    public LiveData<MoviesRequestResponseModel> getPopularMovies(){
        final MutableLiveData<MoviesRequestResponseModel> requestResponseModelMutableLiveData = new MutableLiveData<>();

        apiRequest.getPopularMovies(API_KEY)
                .enqueue(new Callback<MoviesRequestResponseModel>() {
                    @Override
                    public void onResponse(Call<MoviesRequestResponseModel> call, Response<MoviesRequestResponseModel> response) {
                        if (response.body() != null){

                            requestResponseModelMutableLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<MoviesRequestResponseModel> call, Throwable t) {
                        requestResponseModelMutableLiveData.setValue(null);
                    }
                });
        return requestResponseModelMutableLiveData;
    }

    public LiveData<MoviesRequestResponseModel> getTopRated(){
        final MutableLiveData<MoviesRequestResponseModel> requestResponseModelMutableLiveData = new MutableLiveData<>();

        apiRequest.getTopRatedMovies(API_KEY)
                .enqueue(new Callback<MoviesRequestResponseModel>() {
                    @Override
                    public void onResponse(Call<MoviesRequestResponseModel> call, Response<MoviesRequestResponseModel> response) {
                        if (response.body() != null){
                            requestResponseModelMutableLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<MoviesRequestResponseModel> call, Throwable t) {
                        requestResponseModelMutableLiveData.setValue(null);
                    }
                });
        return requestResponseModelMutableLiveData;
    }
}
