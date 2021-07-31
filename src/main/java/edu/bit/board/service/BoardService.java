package edu.bit.board.service;

import java.util.List;

import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;

public interface BoardService {
    public List<BoardVO> getList();

    BoardVO get(int bid);
    void modify(BoardVO boardVO);

    void delete(BoardVO boardVO);

    void writeBoard(BoardVO boardVO);

    void writeReply(BoardVO boardVO);

    void hitUpdate(int bid);

    int getTotal(Criteria cri);

    Object getList(Criteria cri);
    
}
