package com.example.RingRing.models.dto;

public class PostDto {
    private int id;
    private String title;
    private String body;
    private UserDto user;
    private CommentaryDto commentary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public CommentaryDto getCommentary() {
        return commentary;
    }

    public void setCommentary(CommentaryDto commentary) {
        this.commentary = commentary;
    }
}
