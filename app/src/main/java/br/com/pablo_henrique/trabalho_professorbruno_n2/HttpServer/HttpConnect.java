package br.com.pablo_henrique.trabalho_professorbruno_n2.HttpServer;

import java.util.List;

import br.com.pablo_henrique.trabalho_professorbruno_n2.Model.AlbumModel;
import br.com.pablo_henrique.trabalho_professorbruno_n2.Model.PhotosModel;
import br.com.pablo_henrique.trabalho_professorbruno_n2.Model.TodosModel;
import br.com.pablo_henrique.trabalho_professorbruno_n2.Model.UserModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HttpConnect {

    @GET("/{todos}")
    Call<List<TodosModel>> getTodos(@Path("todos") String todos);

    @GET("/{users}")
    Call<List<UserModel>> getUsers(@Path("users") String users);

    @GET("/{album}")
    Call<List<AlbumModel>> getAlbum(@Path("album") String album);

    @GET("/{photos}")
    Call<List<PhotosModel>> getPhotos(@Path("photos") String photos);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
