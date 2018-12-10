package br.com.pablo_henrique.trabalho_professorbruno_n2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.pablo_henrique.trabalho_professorbruno_n2.R;

public class AlbumViewHolder extends RecyclerView.ViewHolder {
    final TextView id;

    public AlbumViewHolder(View view){
        super(view);
        id = view.findViewById(R.id.tvId);
    }
}
