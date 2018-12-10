package br.com.pablo_henrique.trabalho_professorbruno_n2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.com.pablo_henrique.trabalho_professorbruno_n2.adapter.Adapter_users;
import br.com.pablo_henrique.trabalho_professorbruno_n2.httpServer.HttpConnect;
import br.com.pablo_henrique.trabalho_professorbruno_n2.model.UserModel;
import br.com.pablo_henrique.trabalho_professorbruno_n2.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        // Puxa a refencia recicleView lá da view(tela)
        final RecyclerView recyclerView = findViewById(R.id.recycler);

        // Cria um objeto HttpConect de nome conexão já trazendo a url principal de onde sera consumido serviço
        HttpConnect conexao = HttpConnect.retrofit.create(HttpConnect.class);

        // Declara uma Call/array do tipo UserModel de nome call passando o metodos daonde sera pego os itens "conexao.getUsers"
        // junto com o atributo "url" que será o complemento da url principal
        final Call<List<UserModel>> call = conexao.getUsers("users");

        // chama o enqueue, um metodo do retrofit para apresentação dos dados de forma assincrona, passando uma Call que vai ser utilizado uma list do tipo "UserModel"
        call.enqueue(new Callback<List<UserModel>>() {

            //Sobrescrevendo os metodos onResponse e onFailure que o metodo enqueue nos obriga por padrão
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {

                // cria uma list do tipo "UserModel" pegando os dados no corpo do response
                List<UserModel> lista = response.body();

                // chama o adapter da recyclerView passando o adapter do objeto contendo o objeto a ser empresso(nesse caso a lista) + o contexto da activity
                recyclerView.setAdapter(new Adapter_users(lista, UsersActivity.this));

                //o layout da recycleView a ser impresso na tela nesse caso o "LinearLayoutManager", passando o contexto + o tipo de layout padrão a ser impresso
                RecyclerView.LayoutManager layout = new LinearLayoutManager(UsersActivity.this, LinearLayoutManager.VERTICAL, false);

                // aplicando o layout escolhido anteriormente
                recyclerView.setLayoutManager(layout);
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {

            }

        });
    }
}
