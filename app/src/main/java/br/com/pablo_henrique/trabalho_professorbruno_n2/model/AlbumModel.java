package br.com.pablo_henrique.trabalho_professorbruno_n2.model;

public class AlbumModel {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AlbumModel{" +
                "id=" + id +
                '}';
    }
}
