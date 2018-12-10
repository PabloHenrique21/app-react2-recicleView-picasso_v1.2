package br.com.pablo_henrique.trabalho_professorbruno_n2.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.pablo_henrique.trabalho_professorbruno_n2.Model.TodosModel;
import br.com.pablo_henrique.trabalho_professorbruno_n2.R;

public class Adapter_todo extends RecyclerView.Adapter {

    private List<TodosModel> todos;
    private Context context;

    public Adapter_todo(List<TodosModel> todos, Context context) {
        this.todos = todos;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_todo, parent, false);

        TodoViewHolder holder = new TodoViewHolder(view);

        return holder;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        TodoViewHolder holder = (TodoViewHolder) viewHolder;

        TodosModel todo = todos.get(position);

        holder.title.setText(todo.getTitle());
        holder.completed.setText(todo.getCompleted());

    }

    @Override
    public int getItemCount() {

        return todos.size();
    }
}