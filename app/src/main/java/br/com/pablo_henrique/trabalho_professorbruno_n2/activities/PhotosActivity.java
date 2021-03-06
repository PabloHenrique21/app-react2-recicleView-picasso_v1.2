package br.com.pablo_henrique.trabalho_professorbruno_n2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.com.pablo_henrique.trabalho_professorbruno_n2.adapter.Adapter_photos;
import br.com.pablo_henrique.trabalho_professorbruno_n2.httpServer.HttpConnect;
import br.com.pablo_henrique.trabalho_professorbruno_n2.model.PhotosModel;
import br.com.pablo_henrique.trabalho_professorbruno_n2.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        // Puxa a refencia recicleView lá da view(tela)
        final RecyclerView recyclerView = findViewById(R.id.recycler);

        // Cria um objeto HttpConect de nome conexão já trazendo a url principal de onde sera consumido serviço
        HttpConnect conexao = HttpConnect.retrofit.create(HttpConnect.class);

        // Declara uma Call/array do tipo PhotosModel de nome call passando o metodos daonde sera pego os itens "conexao.getPhotos"
        // junto com o atributo "url" que será o complemento da url principal
        final Call<List<PhotosModel>> call = conexao.getPhotos("photos");

        // chama o enqueue, um metodo do retrofit para apresentação dos dados de forma assincrona, passando uma Call que vai ser utilizado uma list do tipo "PhotosModel"
        call.enqueue(new Callback<List<PhotosModel>>() {

            //Sobrescrevendo os metodos onResponse e onFailure que o metodo enqueue nos obriga por padrão
            @Override
            public void onResponse(Call<List<PhotosModel>> call, Response<List<PhotosModel>> response) {

                // cria uma list do tipo "PhotosModel" pegando os dados no corpo do response
                List<PhotosModel> lista = response.body();

                // chama o adapter da recyclerView passando o adapter do objeto contendo o objeto a ser empresso(nesse caso a lista) + o contexto da activity
                recyclerView.setAdapter(new Adapter_photos(lista, PhotosActivity.this));

                //o layout da recycleView a ser impresso na tela nesse caso o "GridLayoutManager", passando o contexto + a quantidade de colunas
                RecyclerView.LayoutManager layout = new GridLayoutManager(PhotosActivity.this, 2);

                // aplicando o layout escolhido anteriormente
                recyclerView.setLayoutManager(layout);
            }

            @Override
            public void onFailure(Call<List<PhotosModel>> call, Throwable t) {

            }
        });


    }
}
