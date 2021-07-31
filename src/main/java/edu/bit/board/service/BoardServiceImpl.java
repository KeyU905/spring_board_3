package edu.bit.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService{
    
    @Autowired
    private BoardMapper boardMapper;
    
    
    @Override
    public List<BoardVO> getList(){
        System.out.println("getList()..");
        return boardMapper.getList();
    }


    @Override
    public BoardVO get(int bid) {
        log.info("service:get()..");
        hitUpdate(bid);
        return boardMapper.read(bid);
    }


    @Override
    public void modify(BoardVO boardVO) {
        log.info("service:modify()..");
        boardMapper.update(boardVO);
    }


    @Override
    public void delete(BoardVO boardVO) {
        log.info("service:delete()..");
        boardMapper.delete(boardVO);
    }


    @Override
    public void writeBoard(BoardVO boardVO) {
        log.info("service:write()..");
        boardMapper.insertBoard(boardVO);
    }


    @Override
    public void writeReply(BoardVO boardVO) {
        log.info("service:write()..");
        boardMapper.updateShape(boardVO);
        boardMapper.insertReply(boardVO);
        
    }


    @Override
    public void hitUpdate(int bid) {
        log.info("service:hitUpdate()..");
        boardMapper.hitUpdate(bid);
    }


    // 페이징 처리 함수
    @Override
    public int getTotal(Criteria cri) {
        log.info("service.getTotal()..");
        return boardMapper.getTotalCount(cri);
    }

    // 페이징 처리 함수
    @Override
    public List<BoardVO> getList(Criteria criteria) {
        log.info("service.getList()..");
        return boardMapper.getListWithPaging(criteria);
    }
}
