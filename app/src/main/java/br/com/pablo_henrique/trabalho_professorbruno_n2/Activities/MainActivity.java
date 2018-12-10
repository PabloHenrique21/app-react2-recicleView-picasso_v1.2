package br.com.pablo_henrique.trabalho_professorbruno_n2.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.pablo_henrique.trabalho_professorbruno_n2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId()){
            case R.id.btnTodos:
                intent = new Intent(this, TodosActivity.class);

                startActivity(intent);
                break;

            case R.id.btnUsers:
                intent = new Intent(this, UsersActivity.class);

                startActivity(intent);
                break;

            case R.id.btnAlbum:
                intent = new Intent(this, AlbumsActivity.class);

                startActivity(intent);
                break;

            default:
                intent = new Intent(this, PhotosActivity.class);

                startActivity(intent);
        }
    }
}
