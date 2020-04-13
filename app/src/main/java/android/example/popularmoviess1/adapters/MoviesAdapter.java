package android.example.popularmoviess1.adapters;

import android.content.Context;
import android.content.Intent;
import android.example.popularmoviess1.R;
import android.example.popularmoviess1.model.MoviesModel;
import android.example.popularmoviess1.model.MoviesParcelable;
import android.example.popularmoviess1.views.MovieDetailsActivity;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviewsViewHolder>{
    private List<MoviesModel> moviesModelList;
    private Context mContext;

    private void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    private Context getmContext() {
        return mContext;
    }

    public MoviesAdapter(List<MoviesModel> moviesModelList) {
        this.moviesModelList = moviesModelList;
    }

    @NonNull
    @Override
    public MoviewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        setmContext(context);
        View view = LayoutInflater.from(context).inflate(R.layout.single_movie_details,parent,false);
        return new MoviewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviewsViewHolder holder, int position) {
        final MoviesModel moviesModel = moviesModelList.get(position);

        final String imageUri = buildUrl(moviesModel.getPosterUrl()).toString();
        Picasso.with(getmContext()).load(imageUri).centerCrop().fit().into(holder.posterImageView);

        holder.posterImageView.setOnClickListener(v -> {
            Intent movieIntent = new Intent(getmContext(),MovieDetailsActivity.class);
            MoviesParcelable moviesParcelable = new MoviesParcelable(moviesModel.getTitle(),moviesModel.getReleaseDate(),imageUri,moviesModel.getVoteAverage(),moviesModel.getOverview());
            movieIntent.putExtra("movie",moviesParcelable);
            getmContext().startActivity(movieIntent);
        });
    }

    @Override
    public int getItemCount() {
        return moviesModelList.size();
    }

    public static class MoviewsViewHolder extends RecyclerView.ViewHolder {
        private ImageView posterImageView;

        MoviewsViewHolder(@NonNull View itemView) {
            super(itemView);

            posterImageView = itemView.findViewById(R.id.post_image_view);
        }
    }

    private static Uri buildUrl(String imagePath){
        final String imageBaseURL = "https://image.tmdb.org/t/p/w185";
        Uri uri =  Uri.parse(imageBaseURL)
                .buildUpon()
                .appendPath(imagePath.substring(1))
                .build();
        Log.e("Image Path", imagePath);
        Log.e("Image Url",uri.toString());
        return uri;
    }
}
