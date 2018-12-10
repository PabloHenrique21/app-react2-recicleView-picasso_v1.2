package br.com.pablo_henrique.trabalho_professorbruno_n2.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import br.com.pablo_henrique.trabalho_professorbruno_n2.Adapter.Adapter_album;
import br.com.pablo_henrique.trabalho_professorbruno_n2.Adapter.Adapter_todo;
import br.com.pablo_henrique.trabalho_professorbruno_n2.HttpServer.HttpConnect;
import br.com.pablo_henrique.trabalho_professorbruno_n2.Model.AlbumModel;
import br.com.pablo_henrique.trabalho_professorbruno_n2.Model.TodosModel;
import br.com.pablo_henrique.trabalho_professorbruno_n2.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        final RecyclerView recyclerView = findViewById(R.id.recycler);

        HttpConnect conexao = HttpConnect.retrofit.create(HttpConnect.class);
        final Call<List<AlbumModel>> call = conexao.getAlbum("albums");

        call.enqueue(new Callback<List<AlbumModel>>() {
            @Override
            public void onResponse(Call<List<AlbumModel>> call, Response<List<AlbumModel>> response) {
                List<AlbumModel> lista = response.body();

                recyclerView.setAdapter(new Adapter_album(lista, AlbumsActivity.this));

                RecyclerView.LayoutManager layout = new GridLayoutManager(AlbumsActivity.this, 3);

                //RecyclerView.LayoutManager layout = new LinearLayoutManager(TodosActivity.this, LinearLayoutManager.VERTICAL, false);

                recyclerView.setLayoutManager(layout);

            }

            @Override
            public void onFailure(Call<List<AlbumModel>> call, Throwable t) {

            }

        });
    }

    public void onClickPhoto(View view) {
        /*final TextView id;

        id = findViewById(R.id.tvId);

        String codigo = id.getText().toString();*/

        Intent intent = null;

        intent = new Intent(this, PhotosActivity.class);



        startActivity(intent);


    }
}
