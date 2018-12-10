package br.com.pablo_henrique.trabalho_professorbruno_n2.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.pablo_henrique.trabalho_professorbruno_n2.Model.PhotosModel;
import br.com.pablo_henrique.trabalho_professorbruno_n2.Model.TodosModel;
import br.com.pablo_henrique.trabalho_professorbruno_n2.Picasso.PicassoClient;
import br.com.pablo_henrique.trabalho_professorbruno_n2.R;

public class Adapter_photos extends RecyclerView.Adapter {

    private List<PhotosModel> photos;
    private Context context;

    public Adapter_photos(List<PhotosModel> photos, Context context) {
        this.photos = photos;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_photos, parent, false);

        PhotosViewHolder holder = new PhotosViewHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        PhotosViewHolder holder = (PhotosViewHolder) viewHolder;

        PhotosModel photo = photos.get(position);

        //holder.id.setText(photo.getId());

        PicassoClient.downloadImage(photo.getUrl(), holder.url);

    }

    @Override
    public int getItemCount() {
        return photos.size();
    }
}