package br.com.pablo_henrique.trabalho_professorbruno_n2.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.pablo_henrique.trabalho_professorbruno_n2.R;

public class PhotosViewHolder extends RecyclerView.ViewHolder {
    final ImageView url;
    final TextView id;

    public PhotosViewHolder(View view){
        super(view);

        id = view.findViewById(R.id.tvId);
        url = view.findViewById(R.id.imgUrl);
    }
}
