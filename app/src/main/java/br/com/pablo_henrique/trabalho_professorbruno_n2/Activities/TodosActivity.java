package br.com.pablo_henrique.trabalho_professorbruno_n2.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.com.pablo_henrique.trabalho_professorbruno_n2.Adapter.Adapter_todo;
import br.com.pablo_henrique.trabalho_professorbruno_n2.HttpServer.HttpConnect;
import br.com.pablo_henrique.trabalho_professorbruno_n2.Model.TodosModel;
import br.com.pablo_henrique.trabalho_professorbruno_n2.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TodosActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);

        final RecyclerView recyclerView = findViewById(R.id.recycler);

        HttpConnect conexao = HttpConnect.retrofit.create(HttpConnect.class);
        final Call<List<TodosModel>> call = conexao.getTodos("todos");
        call.enqueue(new Callback<List<TodosModel>>() {
            @Override
            public void onResponse(Call<List<TodosModel>> call, Response<List<TodosModel>> response) {
                List<TodosModel> lista = response.body();

                recyclerView.setAdapter(new Adapter_todo(lista, TodosActivity.this));

                RecyclerView.LayoutManager layout = new GridLayoutManager(TodosActivity.this, 2);

                //RecyclerView.LayoutManager layout = new LinearLayoutManager(TodosActivity.this, LinearLayoutManager.VERTICAL, false);

                recyclerView.setLayoutManager(layout);
            }

            @Override
            public void onFailure(Call<List<TodosModel>> call, Throwable t) {

            }
        });


    }
}
