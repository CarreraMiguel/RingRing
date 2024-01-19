package com.example.RingRing.models.dto;

import com.example.RingRing.models.Post;
import com.example.RingRing.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private int id;

    private String name;

    private String surname;

    private List<Post> posts;
    private List<User> friendList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<User> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<User> friendList) {
        this.friendList = friendList;
    }
}
