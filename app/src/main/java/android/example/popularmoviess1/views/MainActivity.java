package android.example.popularmoviess1.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.example.popularmoviess1.R;
import android.example.popularmoviess1.adapters.MoviesAdapter;
import android.example.popularmoviess1.model.MoviesModel;
import android.example.popularmoviess1.model.MoviesRequestResponseModel;
import android.example.popularmoviess1.viewmodel.MoviesViewModel;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView titleTextView;
    private MoviesAdapter moviesAdapter;
    private List<MoviesModel> mMoviesModelList;
    private MoviesViewModel moviesViewModel;
    private RecyclerView moviesRecyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        getPopularMovies();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int menuItemId = item.getItemId();
        if (menuItemId == R.id.top_rated_action){
            getTopRatedMovies();
            return true;
        }

        if (menuItemId == R.id.popular_action){
            getPopularMovies();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void init(){
        titleTextView  = findViewById(R.id.recycler_title_textview);

        mMoviesModelList = new ArrayList<>();
        moviesRecyclerView = findViewById(R.id.movies_recycler_view);

        moviesAdapter = new MoviesAdapter(mMoviesModelList);

        layoutManager = new GridLayoutManager(this,2);
        moviesRecyclerView.setLayoutManager(layoutManager);

        moviesRecyclerView.setAdapter(moviesAdapter);

        moviesRecyclerView.setHasFixedSize(true);
        moviesRecyclerView.setNestedScrollingEnabled(false);

        moviesViewModel = new ViewModelProvider(this).get(MoviesViewModel.class);
    }

    private void getPopularMovies(){
        titleTextView.setText(R.string.popular);
        mMoviesModelList.clear();
        moviesViewModel.getPopularResponseModelLiveData().observe(this, moviesRequestResponseModel -> {
            if (moviesRequestResponseModel != null){
                List<MoviesModel> moviesModel = moviesRequestResponseModel.getMoviesModelList();
                mMoviesModelList.addAll(moviesModel);
                moviesAdapter.notifyDataSetChanged();
            }else{
                displaySnackBar();
            }
        });
    }

    private void getTopRatedMovies(){
        titleTextView.setText(R.string.top_rated);
        mMoviesModelList.clear();
        moviesViewModel.getTopRatedResponseModelLiveData().observe(this, moviesRequestResponseModel -> {
            if (moviesRequestResponseModel != null){
                List<MoviesModel> moviesModels = moviesRequestResponseModel.getMoviesModelList();
                mMoviesModelList.addAll(moviesModels);
                moviesAdapter.notifyDataSetChanged();
            }else{
                displaySnackBar();
            }
        });
    }

    private void displaySnackBar(){
        RelativeLayout relativeLayout = findViewById(R.id.constraint_layout_main);
        Snackbar snackbar = Snackbar.make(relativeLayout,"No Internet connection!", Snackbar.LENGTH_LONG)
                .setAction("RETRY", v -> getPopularMovies());
        snackbar.setActionTextColor(Color.RED);
    }

}
