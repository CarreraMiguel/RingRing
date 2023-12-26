package com.example.RingRing.api;

import com.example.RingRing.models.dto.CommentaryDto;

import java.util.List;

public interface iCommentaryService {
    List<CommentaryDto> queryAllCommentaries ();
    CommentaryDto queryCommentary(CommentaryDto commentaryDto);
    int insertCommentary (CommentaryDto commentaryDto);
    int updateCommentary (CommentaryDto commentaryDto);
    int deleteCommentary(CommentaryDto commentaryDto);
}
