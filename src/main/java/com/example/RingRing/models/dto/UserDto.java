package com.example.RingRing.models.dto;

import com.example.RingRing.models.*;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private int id;

    private String name;

    private String surname;

    private List<Post> posts = new ArrayList<>();;
    private List<PostImage> postImages = new ArrayList<>();;
    private List<PostVideo> postVideos = new ArrayList<>();;
    private List<User> friendList = new ArrayList<>();
    private List<Commentary> commentary;

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

    public List<PostImage> getPostImages() {
        return postImages;
    }

    public void setPostImages(List<PostImage> postImages) {
        this.postImages = postImages;
    }

    public List<PostVideo> getPostVideos() {
        return postVideos;
    }

    public void setPostVideos(List<PostVideo> postVideos) {
        this.postVideos = postVideos;
    }

    public List<User> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<User> friendList) {
        this.friendList = friendList;
    }

    public List<Commentary> getCommentary() {
        return commentary;
    }

    public void setCommentary(List<Commentary> commentary) {
        this.commentary = commentary;
    }
}
