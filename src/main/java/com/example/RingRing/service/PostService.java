package com.example.RingRing.service;

import com.example.RingRing.api.IPostService;
import com.example.RingRing.models.Post;
import com.example.RingRing.models.dao.PostDao;
import com.example.RingRing.models.dto.PostDto;
import com.example.RingRing.models.dto.mappers.PostMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class PostService implements IPostService {
    private final PostDao postDao;
    public PostService(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public List<PostDto> queryAllPosts(){
        return PostMapper.INSTANCE.toDTOList(this.postDao.findAll());
    }

    @Override
    public PostDto queryPost(PostDto postDto){
        Post post = PostMapper.INSTANCE.toEntity(postDto);
        Post finalPost = this.postDao.getReferenceById(post.getId());
        return PostMapper.INSTANCE.toDTO(finalPost);
    }

    @Override
    public int insertPost(PostDto postDto){
        Post post = PostMapper.INSTANCE.toEntity(postDto);
        this.postDao.saveAndFlush(post);
        return post.getId();
    }

    @Override
    public int updatePost (PostDto postDto){
        return this.insertPost(postDto);
    }

    @Override
    public int deletePost(PostDto postDto){
        Post post = PostMapper.INSTANCE.toEntity(postDto);
        this.postDao.delete(post);
        return post.getId();
    }

    @Override
    public PostDto createTextPost(PostDto postDto){
        Post post = PostMapper.INSTANCE.toEntity(postDto);
        Scanner leer = new Scanner(System.in);
        while(true){
            System.out.println("Título: ");
            String title = leer.nextLine();
            if(title != null && !title.isEmpty() && title.matches("^[a-zA-Z0-9 ]+$")){
                post.setTitle(title);
                break;
            } else {
                System.out.println("Introduzca un título válido.");
            }
        } System.out.println("------------------------------");
        while(true){
            System.out.println("Contenido del Post:");
            String body = leer.nextLine();
            if(body != null && !body.isEmpty() && body.matches("^[a-zA-Z0-9 ]+$")){
                post.setBody(body);
                break;
            } else {
                System.out.println("Recuerda escribir correctamente tu Post!");
            }
        }
        return PostMapper.INSTANCE.toDTO(post);
    }

}
