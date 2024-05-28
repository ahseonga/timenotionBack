package com.example.geungeunhanjan.service;

import com.example.geungeunhanjan.domain.dto.InquiryDTO;
import com.example.geungeunhanjan.mapper.InquiryMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryServiceImpe implements InquiryService {

    //주입
    private  final InquiryMapper inquiryMapper;

    public InquiryServiceImpe(InquiryMapper inquiryMapper) {this.inquiryMapper = inquiryMapper;}



    // 문의 전부 다 뿌려주게 하기
    @Override
    public List<InquiryDTO> selectInquiryAll() {
        return inquiryMapper.selectInquiryAll();
    }

    // 각 id별 문의
    @Override
    public InquiryDTO selectInquiryDetail(Long inquiryId) {
        return inquiryMapper.selectInquiryDetail(inquiryId);
    }
}