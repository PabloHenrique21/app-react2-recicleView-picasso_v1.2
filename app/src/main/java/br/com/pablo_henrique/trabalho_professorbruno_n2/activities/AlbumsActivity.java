package br.com.pablo_henrique.trabalho_professorbruno_n2.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import br.com.pablo_henrique.trabalho_professorbruno_n2.adapter.Adapter_album;
import br.com.pablo_henrique.trabalho_professorbruno_n2.httpServer.HttpConnect;
import br.com.pablo_henrique.trabalho_professorbruno_n2.model.AlbumModel;
import br.com.pablo_henrique.trabalho_professorbruno_n2.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        // Puxa a refencia recicleView lá da view(tela)
        final RecyclerView recyclerView = findViewById(R.id.recycler);

        // Cria um objeto HttpConect de nome conexão já trazendo a url principal de onde sera consumido serviço
        HttpConnect conexao = HttpConnect.retrofit.create(HttpConnect.class);

        // Declara uma Call/array do tipo AlbumModel de nome call passando o metodos daonde sera pego os itens "conexao.getAlbum"
        // junto com o atributo "url" que será o complemento da url principal
        final Call<List<AlbumModel>> call = conexao.getAlbum("albums");

        // chama o enqueue, um metodo do retrofit para apresentação dos dados de forma assincrona, passando uma Call que vai ser utilizado uma list do tipo "AlbumModel"
        call.enqueue(new Callback<List<AlbumModel>>() {

            //Sobrescrevendo os metodos onResponse e onFailure que o metodo enqueue nos obriga por padrão
            @Override
            public void onResponse(Call<List<AlbumModel>> call, Response<List<AlbumModel>> response) {
                // cria uma list do tipo "AlbumModel" pegando os dados no corpo do response
                List<AlbumModel> lista = response.body();

                // chama o adapter da recyclerView passando o adapter do objeto contendo o objeto a ser empresso(nesse caso a lista) + o contexto da activity
                recyclerView.setAdapter(new Adapter_album(lista, AlbumsActivity.this));

                //o layout da recycleView a ser impresso na tela nesse caso o "GridLayoutManager", passando o contexto + a quantidade de colunas
                RecyclerView.LayoutManager layout = new GridLayoutManager(AlbumsActivity.this, 3);

                // aplicando o layout escolhido anteriormente
                recyclerView.setLayoutManager(layout);

            }

            @Override
            public void onFailure(Call<List<AlbumModel>> call, Throwable t) {

            }

        });
    }

    public void onClickPhoto(View view) {

        // texto comentado ideia falha de fazer o buscar apenas o album requisitado
        /*final TextView id;
        id = findViewById(R.id.tvId);
        String codigo = id.getText().toString();*/


        // chama a proxima tela
        Intent intent = null;
        intent = new Intent(this, PhotosActivity.class);
        startActivity(intent);
    }
}
