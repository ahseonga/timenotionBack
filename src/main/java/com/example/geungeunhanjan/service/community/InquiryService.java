package com.example.geungeunhanjan.service.community;


import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;
import com.example.geungeunhanjan.domain.dto.community.InquiryPagingDTO;
import com.example.geungeunhanjan.domain.dto.community.InquiryWriteDTO;
import com.example.geungeunhanjan.domain.dto.page.Criteria;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InquiryService {

    // 문의 내용 뿌려주기위한 거
    List<InquiryDTO> selectInquiryAll();

    // 각 id별 문의 상세
    InquiryDTO selectInquiryDetail(Long inquiryId);

    String userNickNamebyInquiryId(Long inquiryId);

    void inquiryDelete(@Param("inquiryId") Long inquiryId, @Param("userId") Long userId);

    void inquiryWrite(InquiryWriteDTO inquiryWriteDTO);

    List<InquiryPagingDTO> selectAllInquiryPage(Criteria criteria);

    int selectInquiryTotal();

}