package com.greedy.dduckleaf.notice.service;

import com.greedy.dduckleaf.notice.dto.NoticeDTO;
import com.greedy.dduckleaf.notice.entity.Notice;
import com.greedy.dduckleaf.notice.repository.NoticeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public NoticeService(NoticeRepository noticeRepository, ModelMapper modelMapper) {
        this.noticeRepository = noticeRepository;
        this.modelMapper = modelMapper;
    }

    public Page<NoticeDTO> findNoticeList(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("noticeNo").descending());

        return noticeRepository.findAll(pageable).map(notice -> modelMapper.map(notice, NoticeDTO.class));
    }

    @Transactional
    public List<NoticeDTO> searchPosts(String keyword) {

        List<Notice> notices = noticeRepository.findByTitleContaining(keyword);
        List<NoticeDTO> noticeDTOList = new ArrayList<>();

        if(notices.isEmpty()) return noticeDTOList;

        for(Notice notice : notices) {
            noticeDTOList.add(this.convertEntityToDTO(notice));
        }

        return noticeDTOList;
    }

    private NoticeDTO convertEntityToDTO(Notice notice) {

        return NoticeDTO.builder()
                .no(notice.getNoticeNo())
                .categoryNo(notice.getNoticeCategoryNo())
                .name(notice.getNoticeName())
                .adminNo(notice.getAdminNo())
                .registDate(notice.getNoticeRegistDate())
                .count(notice.getNoticeCount())
                .build();
    }
}
