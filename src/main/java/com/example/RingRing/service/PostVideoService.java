package com.example.RingRing.service;

import com.example.RingRing.api.IPostVideoService;
import com.example.RingRing.models.Post;
import com.example.RingRing.models.PostImage;
import com.example.RingRing.models.PostVideo;
import com.example.RingRing.models.dao.PostVideoDao;
import com.example.RingRing.models.dto.PostDto;
import com.example.RingRing.models.dto.PostVideoDto;
import com.example.RingRing.models.dto.mappers.PostImageMapper;
import com.example.RingRing.models.dto.mappers.PostMapper;
import com.example.RingRing.models.dto.mappers.PostVideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class PostVideoService implements IPostVideoService {

    private final PostVideoDao postVideoDao;
    public PostVideoService(PostVideoDao postVideoDao) {
        this.postVideoDao = postVideoDao;
    }

    @Override
    public List<PostVideoDto> queryAllPostVideos(){
        return PostVideoMapper.INSTANCE.toDTOList(this.postVideoDao.findAll());
    }

    @Override
    public PostVideoDto queryPostVideo(PostVideoDto postVideoDto){
        PostVideo postVideo = PostVideoMapper.INSTANCE.toEntity(postVideoDto);
        PostVideo finalPostVideo = this.postVideoDao.getReferenceById(postVideo.getId());
        return PostVideoMapper.INSTANCE.toDTO(finalPostVideo);
    }

    @Override
    public int insertPostVideo(PostVideoDto postVideoDto){
        PostVideo postVideo = PostVideoMapper.INSTANCE.toEntity(postVideoDto);
        this.postVideoDao.saveAndFlush(postVideo);
        return postVideo.getId();
    }

    @Override
    public int updatePostVideo (PostVideoDto postVideoDto){
        return this.insertPostVideo(postVideoDto);
    }

    @Override
    public int deletePostVideo(PostVideoDto postVideoDto){
        PostVideo postVideo = PostVideoMapper.INSTANCE.toEntity(postVideoDto);
        this.postVideoDao.delete(postVideo);
        return postVideo.getId();
    }

    @Override
    public PostVideoDto createPostVideo(PostVideoDto postVideoDto, PostDto postDto){
        PostVideo postVideo = PostVideoMapper.INSTANCE.toEntity(postVideoDto);
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
            System.out.println("Calidades de video posibles: 480, 720, 1080");
            int quality = leer.nextInt();
            if (quality == 480 || quality == 720 || quality == 1080) {
                postVideoDto.setQuality(quality);
                break;
            } else {
                System.out.println("Introduzca una de las calidades mencionadas con anterioridad.");
            }
        }
        while(true){
            System.out.println("Duración del video:");
            String duration = leer.nextLine();
            if(duration != null && !duration.isEmpty()){
                postVideoDto.setDuration(duration);
                break;
            }else {
                System.out.println("No te olvides de definir una duración para tu video!!");
            }
        }
        return PostVideoMapper.INSTANCE.toDTO(postVideo);
    }
}
