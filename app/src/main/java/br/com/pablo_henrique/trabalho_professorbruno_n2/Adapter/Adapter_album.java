package br.com.pablo_henrique.trabalho_professorbruno_n2.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.pablo_henrique.trabalho_professorbruno_n2.Model.AlbumModel;
import br.com.pablo_henrique.trabalho_professorbruno_n2.Model.TodosModel;
import br.com.pablo_henrique.trabalho_professorbruno_n2.R;

public class Adapter_album extends RecyclerView.Adapter {

    private List<AlbumModel> albums;
    private Context context;

    public Adapter_album(List<AlbumModel> albums, Context context) {
        this.albums = albums;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_album, parent, false);

        AlbumViewHolder holder = new AlbumViewHolder(view);

        return holder;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        AlbumViewHolder holder = (AlbumViewHolder) viewHolder;

        AlbumModel album = albums.get(position);

        holder.id.setText(Integer.toString(album.getId()));


    }

    @Override
    public int getItemCount() {

        return albums.size();
    }
}