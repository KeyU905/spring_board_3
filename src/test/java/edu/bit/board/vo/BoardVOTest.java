package edu.bit.board.vo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardVOTest {

    private BoardVO boardVO;
    
    public BoardVOTest(){
        boardVO = new BoardVO();
    }
    
    @Test
    public void testSetBName() {
        boardVO = new BoardVO();
        boardVO.setBname("Kim");
        
        System.out.println(boardVO.getBname());
    }
    
        
    @Test
    public void testExist() {
        boardVO = new BoardVO();
        assertNotNull(boardVO);
    }
    
    @Test
    public void test() {
        
        System.out.println("Test");
    }

}
