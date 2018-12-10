package br.com.pablo_henrique.trabalho_professorbruno_n2.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.com.pablo_henrique.trabalho_professorbruno_n2.Adapter.Adapter_photos;
import br.com.pablo_henrique.trabalho_professorbruno_n2.HttpServer.HttpConnect;
import br.com.pablo_henrique.trabalho_professorbruno_n2.Model.PhotosModel;
import br.com.pablo_henrique.trabalho_professorbruno_n2.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        final RecyclerView recyclerView = findViewById(R.id.recycler);

        HttpConnect conexao = HttpConnect.retrofit.create(HttpConnect.class);

        final Call<List<PhotosModel>> call = conexao.getPhotos("photos");

        call.enqueue(new Callback<List<PhotosModel>>() {
            @Override
            public void onResponse(Call<List<PhotosModel>> call, Response<List<PhotosModel>> response) {

                List<PhotosModel> lista = response.body();

                recyclerView.setAdapter(new Adapter_photos(lista, PhotosActivity.this));

                RecyclerView.LayoutManager layout = new GridLayoutManager(PhotosActivity.this, 2);

                //RecyclerView.LayoutManager layout = new LinearLayoutManager(TodosActivity.this, LinearLayoutManager.VERTICAL, false);

                recyclerView.setLayoutManager(layout);
            }

            @Override
            public void onFailure(Call<List<PhotosModel>> call, Throwable t) {

            }
        });


    }
}
