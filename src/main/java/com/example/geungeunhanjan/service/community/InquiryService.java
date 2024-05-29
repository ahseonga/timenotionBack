package com.example.geungeunhanjan.service.community;


import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InquiryService {

    // 문의 내용 뿌려주기위한 거
    List<InquiryDTO> selectInquiryAll();

    // 각 id별 문의 상세
    InquiryDTO selectInquiryDetail(Long inquiryId);

    String userNickNamebyInquiryId(Long inquiryId);

}