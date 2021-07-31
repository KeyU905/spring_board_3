package edu.bit.board.service;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.bit.board.vo.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })

public class BoardServiceTest {

   @Autowired
   private BoardService boardService;
   
   
   @Test
   public void testBoardService() {
      log.info(boardService);   
      
      assertNotNull(boardService);
      
      //assertEquals(999, 999);
      //assertEquals("test", board.getBname());
      

   }
   
   @Test
   public void testGetList() {
       List<BoardVO> list = boardService.getList();
       
       for(BoardVO vo : list) {
           log.info(vo.getBcontent());
       }
       
   }
   
   

}