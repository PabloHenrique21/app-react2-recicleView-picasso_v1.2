package br.com.pablo_henrique.trabalho_professorbruno_n2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.pablo_henrique.trabalho_professorbruno_n2.R;

public class TodoViewHolder extends RecyclerView.ViewHolder {
    final TextView title;
    final TextView completed;

    public TodoViewHolder(View view){
        super(view);
        title = view.findViewById(R.id.tvtitle);
        completed = view.findViewById(R.id.tvCompleted);
    }


}
