package com.example.lenovo.myapplication;

/**
 * Created by lenovo on 10/24/2016.
 */

public class ItemModel {

    String image_path, film_name ;

    public ItemModel(String overView, String film_name) {
        this.film_name= film_name;
        this.image_path = overView;
    }

    public String getOverView() {
        return image_path;
    }

    public void setOverView(String overView) {
        this.image_path = overView;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }
}
