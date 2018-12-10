package br.com.pablo_henrique.trabalho_professorbruno_n2.Model;

public class PhotosModel {

    private Integer id;
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PhotosModel{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
