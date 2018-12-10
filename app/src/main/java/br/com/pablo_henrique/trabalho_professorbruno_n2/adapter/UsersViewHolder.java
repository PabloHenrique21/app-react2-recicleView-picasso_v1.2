package br.com.pablo_henrique.trabalho_professorbruno_n2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.pablo_henrique.trabalho_professorbruno_n2.R;

public class UsersViewHolder extends RecyclerView.ViewHolder {
    final TextView name;
    final TextView username;
    final TextView email;
    final TextView phone;
    final TextView website;

    public UsersViewHolder(View view){
        super(view);
        name = view.findViewById(R.id.tvNome);
        username = view.findViewById(R.id.tvUsuario);
        phone = view.findViewById(R.id.tvPhone);
        email = view.findViewById(R.id.tvEmail);
        website = view.findViewById(R.id.tvWebsite);

    }


}
