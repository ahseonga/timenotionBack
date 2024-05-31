package com.example.geungeunhanjan.service.community;

import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;
import com.example.geungeunhanjan.domain.dto.community.InquiryPagingDTO;
import com.example.geungeunhanjan.domain.dto.community.InquiryWriteDTO;
import com.example.geungeunhanjan.domain.dto.page.Criteria;
import com.example.geungeunhanjan.mapper.community.InquiryMapper;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@AllArgsConstructor
public class InquiryServiceImlpe implements InquiryService {

    //주입
    private  final InquiryMapper inquiryMapper;


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

    @Override
    public String userNickNamebyInquiryId(Long inquiryId) {
        return inquiryMapper.userNickNamebyInquiryId(inquiryId);
    }

    @Override
    public void inquiryDelete(@Param("inquiryId") Long inquiryId, @Param("userId") Long userId) {
        inquiryMapper.inquiryDelete(inquiryId, userId);
    }

    @Override
    public void inquiryWrite(InquiryWriteDTO inquiryWriteDTO) {
        inquiryMapper.inquiryWrite(inquiryWriteDTO);
    }

    @Override
    public List<InquiryPagingDTO> selectAllInquiryPage(Criteria criteria){
        return inquiryMapper.selectAllInquiryPage(criteria);
    }

    @Override
    public int selectInquiryTotal () {
        return inquiryMapper.selectInquiryTotal();
    }


}