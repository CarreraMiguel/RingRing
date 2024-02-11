package com.example.RingRing.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "POST_IMAGES")
public class PostImage extends Post{

    @Column
    private String dimension;

    public PostImage(String title, String body, String dimension) {
        super(title, body);
        this.dimension = dimension;
    }

    public PostImage() {
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
}
