package com.example.geungeunhanjan.mapper.community;


import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InquiryMapper {

    // 문의 리스트
    List<InquiryDTO> selectInquiryAll();

    // 문의 상세 id별로
    InquiryDTO selectInquiryDetail(Long inquiryId);

    void inquiryWrite(InquiryDTO inquiryDTO);
}