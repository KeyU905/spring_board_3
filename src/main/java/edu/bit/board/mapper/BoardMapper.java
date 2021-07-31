package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;

@Mapper
public interface BoardMapper {
    List<BoardVO> getList();
    BoardVO read(int bid);

    void update(BoardVO boardVO);
    void delete(BoardVO boardVO);
    void insertBoard(BoardVO boardVO);
    
    void hitUpdate(int bid);
    
    // 댓글 관련
    void insertReply(BoardVO boardVO);
    void updateShape(BoardVO boardVO);
    
    //페이징 처리
    int getTotalCount(Criteria cri);
    List<BoardVO> getListWithPaging(Criteria criteria);
    
    // 얘의 자손을 xml로 구현하는 것. edu.bit.board.mapper.BoardMapper.xml 로.
}
