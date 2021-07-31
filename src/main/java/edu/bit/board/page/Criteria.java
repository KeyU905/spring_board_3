package edu.bit.board.page;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter
public class Criteria {
    // 페이징 처리를 위해선 페이지 번호와 한페이지당 몇개의 데이터를 보여줄것인지 결정되어야만 함!!
    private int pageNum; // 페이지 번호
    private int amount; // 한페이지당 데이터의 갯수를 넣어줄 amount변수
    
    public Criteria() {
        this(1,10);
    }
    
    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

   
    
   }
