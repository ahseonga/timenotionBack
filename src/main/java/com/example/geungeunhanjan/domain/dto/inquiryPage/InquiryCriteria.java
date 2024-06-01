package com.example.geungeunhanjan.domain.dto.inquiryPage;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class InquiryCriteria { // 페이징 파라미터 저장
    // 현재 페이지
    private int page;
    // 한 페이지 당 게시물 수
    private int amount;

    // 기본 생성자 통해 기본값 설정
    // 사용자가 별도 값 지정 않았을 때 사용할 기본 값(페이지 번호 1, 한 페이지 당 게시물 9로 설정 등)
    public InquiryCriteria(){
        this(1, 8);
    }

    public InquiryCriteria(int page, int amount){
        this.page = page;
        this.amount = amount;
    }
}