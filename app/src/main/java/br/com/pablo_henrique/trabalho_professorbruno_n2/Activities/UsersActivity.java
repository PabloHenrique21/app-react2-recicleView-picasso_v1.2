package br.com.pablo_henrique.trabalho_professorbruno_n2.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.com.pablo_henrique.trabalho_professorbruno_n2.Adapter.Adapter_users;
import br.com.pablo_henrique.trabalho_professorbruno_n2.HttpServer.HttpConnect;
import br.com.pablo_henrique.trabalho_professorbruno_n2.Model.UserModel;
import br.com.pablo_henrique.trabalho_professorbruno_n2.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        final RecyclerView recyclerView = findViewById(R.id.recycler);

        HttpConnect conexao = HttpConnect.retrofit.create(HttpConnect.class);
        final Call<List<UserModel>> call = conexao.getUsers("users");
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                List<UserModel> lista = response.body();

                recyclerView.setAdapter(new Adapter_users(lista, UsersActivity.this));

                //RecyclerView.LayoutManager layout = new GridLayoutManager(UsersActivity.this, 2);

                RecyclerView.LayoutManager layout = new LinearLayoutManager(UsersActivity.this, LinearLayoutManager.VERTICAL, false);

                recyclerView.setLayoutManager(layout);
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {

            }

        });
    }
}
