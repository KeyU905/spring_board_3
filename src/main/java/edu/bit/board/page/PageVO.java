package edu.bit.board.page;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter

public class PageVO {
    //페이징 처리 할때 필요한 정보들
    private int startPage; //화면에 보여지는 페이지 시작번호
    private int endPage;   //화면에 보여지는 페이지 끝번호
    private boolean prev, next; //이전 페이지, 다음페이지가 존재하는지 확인

    private int total; 
    private Criteria cri; 

    public PageVO(Criteria cri, int total) {

      this.cri = cri; // 요청 정보
      this.total = total; //전체 게시글 수

      //Math.ceil(.95);    // 1
      //Math.ceil(4);      // 4
      //Math.ceil(7.004);  // 8
      //Math.ceil(-0.95);  // -0
      //Math.ceil(-4);     // -4
      //Math.ceil(-7.004); // -7
      //endPage는 현재의 페이지 번호를 기준으로 계산함.

      //현재 페이지가 3일 경우 : Math.ceil(3/10) * 10 = 10
      //현재 페이지가 1일 경우 : Math.ceil(1/10) * 10 = 10
      //현재 페이지가 10일 경우 : Math.ceil(10/10) * 10 = 10
      //현재 페이지가 11일 경우 : Math.ceil(11/10) * 10 = 20  1.1을 올림함
      //현재 페이지가 20일 경우 : Math.ceil(20/10) * 10 = 20
      //현재 페이지가 21일 경우 : Math.ceil(21/10) * 10 = 30
      // Math.ceil 은 소수점 이하를 올림하는 함수. 
      
      this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;

      this.startPage = this.endPage - 9;
      
      //Total을 통한 endPage의 재계산
      // 10개씩 보여주는 경우 (amount = 10)
      // 전체 데이터 수가 80개라고 가정하면 제일 끝 페이지 번호는 10이 아닌 8이 됨
      int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

      if (realEnd <= this.endPage) {
        this.endPage = realEnd;
      }
      
      //시작번호가 1보다 큰경우 존재
      this.prev = this.startPage > 1; 
      //realEnd가 끝번호(endPage)보다 큰 경우에만 존재
      this.next = this.endPage < realEnd; 
    }
    
     public String makeQuery(int page) {
        UriComponents uriComponentsBuilder = UriComponentsBuilder.newInstance()
              .queryParam("pageNum", page) // pageNum = 3
              .queryParam("amount", cri.getAmount()) // pageNum=3&amount=10
              .build(); // ?pageNum=3&amount=10
        return uriComponentsBuilder.toUriString(); // ?pageNum=3&amount=10 리턴 
     }
    
  }

