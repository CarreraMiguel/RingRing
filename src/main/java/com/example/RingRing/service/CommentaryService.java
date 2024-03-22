package com.example.RingRing.service;

import com.example.RingRing.api.ICommentaryService;
import com.example.RingRing.models.Commentary;
import com.example.RingRing.models.dao.CommentaryDao;
import com.example.RingRing.models.dto.CommentaryDto;
import com.example.RingRing.models.dto.mappers.CommentaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class CommentaryService implements ICommentaryService {
    @Autowired
    private CommentaryDao commentaryDao;

    @Override
    public List<CommentaryDto> queryAllCommentaries(){
        return CommentaryMapper.INSTANCE.toDTOList(this.commentaryDao.findAll());
    }

    @Override
    public CommentaryDto queryCommentary(CommentaryDto commentaryDto){
        Commentary commentary = CommentaryMapper.INSTANCE.toEntity(commentaryDto);
        Commentary finalCommentary = this.commentaryDao.getReferenceById(commentary.getId());
        return CommentaryMapper.INSTANCE.toDTO(finalCommentary);
    }

    @Override
    public int insertCommentary(CommentaryDto commentaryDto){
        Commentary commentary = CommentaryMapper.INSTANCE.toEntity(commentaryDto);
        this.commentaryDao.saveAndFlush(commentary);
        return commentary.getId();
    }

    @Override
    public int updateCommentary (CommentaryDto commentaryDto){
        return this.insertCommentary(commentaryDto);
    }

    @Override
    public int deleteCommentary(CommentaryDto commentaryDto){
        Commentary commentary = CommentaryMapper.INSTANCE.toEntity(commentaryDto);
        this.commentaryDao.delete(commentary);
        return commentary.getId();
    }

    @Override
    public CommentaryDto createCommentary (CommentaryDto commentaryDto){
        Commentary commentary = CommentaryMapper.INSTANCE.toEntity(commentaryDto);
        Scanner leer = new Scanner(System.in);
        while(true){
            System.out.println("Que piensas sobre este Post?: ");
            String commentarie = leer.nextLine();
            if(commentarie != null && !commentarie.isEmpty() && commentarie.matches("^[a-zA-Z0-9 ]+$")){
                commentary.setBody(commentarie);
                break;
            }else {
                System.out.println("Recuerda escribir un comentario válido");
            }
        } return CommentaryMapper.INSTANCE.toDTO(commentary);
    }
}
