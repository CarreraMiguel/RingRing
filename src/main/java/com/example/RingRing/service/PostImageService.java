package com.example.RingRing.service;

import com.example.RingRing.api.IPostImageService;
import com.example.RingRing.models.Post;
import com.example.RingRing.models.PostImage;
import com.example.RingRing.models.dao.PostImageDao;
import com.example.RingRing.models.dto.PostDto;
import com.example.RingRing.models.dto.PostImageDto;
import com.example.RingRing.models.dto.mappers.PostImageMapper;
import com.example.RingRing.models.dto.mappers.PostMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class PostImageService implements IPostImageService {

    private final PostImageDao postImageDao;

    public PostImageService(PostImageDao postImageDao) {
        this.postImageDao = postImageDao;
    }

    @Override
    public List<PostImageDto> queryAllPostImages(){
        return PostImageMapper.INSTANCE.toDTOList(this.postImageDao.findAll());
    }

    @Override
    public PostImageDto queryPostImage(PostImageDto postImageDto){
        PostImage postImage = PostImageMapper.INSTANCE.toEntity(postImageDto);
        PostImage finalPostImage = this.postImageDao.getReferenceById(postImage.getId());
        return PostImageMapper.INSTANCE.toDTO(finalPostImage);
    }

    @Override
    public int insertPostImage(PostImageDto postImageDto){
        PostImage postImage = PostImageMapper.INSTANCE.toEntity(postImageDto);
        this.postImageDao.saveAndFlush(postImage);
        return postImage.getId();
    }

    @Override
    public int updatePostImage (PostImageDto postImageDto){
        return this.insertPostImage(postImageDto);
    }

    @Override
    public int deletePostImage(PostImageDto postImageDto){
        PostImage postImage = PostImageMapper.INSTANCE.toEntity(postImageDto);
        this.postImageDao.delete(postImage);
        return postImage.getId();
    }

        @Override
        public PostImageDto createPostImage(PostImageDto postImageDto, PostDto postDto) {
            PostImage postImage = PostImageMapper.INSTANCE.toEntity(postImageDto);
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
            while (true) {
                System.out.println("Dimensiones de la imagen: ");
                String dimension = leer.nextLine();
                if (dimension != null && !dimension.isEmpty() && dimension.matches("^[a-zA-Z0-9 ]+$")) {
                    postImageDto.setDimension(dimension);
                    break;
                } else {
                    System.out.println("Introduzca dimensiones válidas.");
                }
            }
            return PostImageMapper.INSTANCE.toDTO(postImage);
        }
}
