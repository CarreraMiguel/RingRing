package com.example.RingRing.service;

import com.example.RingRing.api.iCommentaryService;
import com.example.RingRing.models.Commentary;
import com.example.RingRing.models.dao.CommentaryDao;
import com.example.RingRing.models.dto.CommentaryDto;
import com.example.RingRing.models.dto.mappers.CommentaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CommentaryService")
@Lazy
public class CommentaryService implements iCommentaryService {
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
}
