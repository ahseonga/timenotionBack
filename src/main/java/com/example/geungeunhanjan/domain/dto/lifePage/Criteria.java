package com.example.geungeunhanjan.domain.dto.lifePage;

import lombok.Data;
import org.springframework.stereotype.Component;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;

@Data
@Component
public class Criteria {
    //페이징 파라미터 저장
    private int page; //현재 페이지
    private int amount; //한 페이지 당 게시물 수
//    private String boardLifeCycle; //라이프사이클++


    //기본 생성자를 통해 기본 값 설정
    //사용자가 별도의 값을 지정하지 않았을 때 사용할 기본 값(페이지번호 1, 한페이지당 게시물 수를 9로 설정 등)
    public Criteria(){
        this(1, 12);
    }

    public Criteria(int page, int amount) {
        this.page = page;
        this.amount = amount;
//        this.boardLifeCycle = boardLifeCycle;
    }

}
