package br.com.pablo_henrique.trabalho_professorbruno_n2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.pablo_henrique.trabalho_professorbruno_n2.model.PhotosModel;
import br.com.pablo_henrique.trabalho_professorbruno_n2.picasso.PicassoClient;
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

        // chamada do metodo para implantação da imagem, passando a URL daonde se encontra a imagem + o local aonde ela sera colocada
        PicassoClient.downloadImage(photo.getUrl(), holder.url);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }
}