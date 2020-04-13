package android.example.popularmoviess1.views;

import androidx.appcompat.app.AppCompatActivity;

import android.example.popularmoviess1.R;
import android.example.popularmoviess1.model.MoviesParcelable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {

    private TextView titleTextView,releaseDateTextView,voteAverageTextView,plotTextView;
    private ImageView posterImageView;
    private MoviesParcelable mMoviesParcelable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);


        Bundle data = getIntent().getExtras();
        if (data != null){
            if (data.containsKey("movie")){
                mMoviesParcelable = data.getParcelable("movie");
            }
        }

        init();

        if (mMoviesParcelable != null){
            titleTextView.setText(mMoviesParcelable.getMovieTitle());
            releaseDateTextView.setText(mMoviesParcelable.getReleaseDate());
            voteAverageTextView.setText(mMoviesParcelable.getVoteAverage());
            plotTextView.setText(mMoviesParcelable.getPlot());
            Picasso.with(this).load(mMoviesParcelable.getPosterUrl()).fit().into(posterImageView);
        }

    }

    private void init(){
        titleTextView = findViewById(R.id.title_text_view);
        releaseDateTextView = findViewById(R.id.release_date_text_view);
        voteAverageTextView = findViewById(R.id.rating_text_view);
        plotTextView = findViewById(R.id.plot_textview);
        posterImageView = findViewById(R.id.movie_post_image_view);
    }
}
