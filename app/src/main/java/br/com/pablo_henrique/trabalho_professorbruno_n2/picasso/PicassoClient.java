package br.com.pablo_henrique.trabalho_professorbruno_n2.picasso;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import br.com.pablo_henrique.trabalho_professorbruno_n2.R;

public class PicassoClient {

    // metodo responsavel por baixar e apresentar a imagem
    public static void downloadImage(String url, ImageView img){
        if(url != null && url.length() > 0){
            Picasso.get().load(url).into(img);
        } else {
            Picasso.get().load(R.drawable.no_foto).into(img);
        }
    }
}
