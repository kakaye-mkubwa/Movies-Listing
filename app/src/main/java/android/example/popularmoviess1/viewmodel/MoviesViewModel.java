package android.example.popularmoviess1.viewmodel;

import android.app.Application;
import android.example.popularmoviess1.model.MoviesRequestResponseModel;
import android.example.popularmoviess1.repository.MovieFeedsRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MoviesViewModel extends AndroidViewModel {
    private MovieFeedsRepository movieFeedsRepository;
    private LiveData<MoviesRequestResponseModel> popularResponseModelLiveData,topRatedResponseModelLiveData;
    private LiveData<Boolean> internetStatusLiveData;


    public MoviesViewModel(@NonNull Application application) {
        super(application);

        movieFeedsRepository = new MovieFeedsRepository();

        this.popularResponseModelLiveData = movieFeedsRepository.getPopularMovies();
        this.topRatedResponseModelLiveData = movieFeedsRepository.getTopRated();
    }

    public LiveData<MoviesRequestResponseModel> getPopularResponseModelLiveData() {
        return popularResponseModelLiveData;
    }

    public LiveData<MoviesRequestResponseModel> getTopRatedResponseModelLiveData() {
        return topRatedResponseModelLiveData;
    }

}
