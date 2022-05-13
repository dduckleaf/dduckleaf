package com.greedy.dduckleaf.notice.service;

import com.greedy.dduckleaf.notice.dto.AdminDTO;
import com.greedy.dduckleaf.notice.dto.NoticeCategoryDTO;
import com.greedy.dduckleaf.notice.dto.NoticeDTO;
import com.greedy.dduckleaf.notice.dto.NoticeForListDTO;
import com.greedy.dduckleaf.notice.entity.Notice;
import com.greedy.dduckleaf.notice.entity.NoticeCategory;
import com.greedy.dduckleaf.notice.repository.NoticeCategoryRepository;
import com.greedy.dduckleaf.notice.repository.NoticeForListRepository;
import com.greedy.dduckleaf.notice.repository.NoticeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : NoticeService
 * Comment : 공지사항
 * History
 * 2022/04/19 (차화응) 처음 작성 / 공지사항 목록조회 메소드 작성
 * 2022/04/21 (차화응) 공지사항 상세조회 메소드 작성
 * 2022/04/23 (차화응) 공지사항 작성하기 메소드 작성
 * 2022/04/25 (차화응) 공지사항 수정하기 메소드 작성
 * </pre>
 * @version 1.0.3
 * @author 차화응
 */
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final NoticeCategoryRepository noticeCategoryRepository;
    private final ModelMapper modelMapper;
    private final NoticeForListRepository noticeForListRepository;

    @Autowired
    public NoticeService(NoticeRepository noticeRepository, NoticeCategoryRepository noticeCategoryRepository, ModelMapper modelMapper, NoticeForListRepository noticeForListRepository) {
        this.noticeRepository = noticeRepository;
        this.noticeCategoryRepository = noticeCategoryRepository;
        this.modelMapper = modelMapper;
        this.noticeForListRepository = noticeForListRepository;
    }

    /**
     * findNoticeList : 공지사항 목록을 조회합니다.
     * @param pageable : 페이징 정보를 담는 객체
     * @return noticeDTO : 공지사항 목록
     *
     * @author 차화응
     */
    @Transactional
    public Page<NoticeForListDTO> findNoticeList(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0: pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("noticeNo").descending());
        Page<NoticeForListDTO> nl = noticeForListRepository.findAll(pageable).map(notice -> {
            NoticeForListDTO noticeDTO = modelMapper.map(notice, NoticeForListDTO.class);
            noticeDTO.setNoticeCategoryDTO(modelMapper.map(notice.getNoticeCategory(), NoticeCategoryDTO.class));
            noticeDTO.setAdmin(modelMapper.map(notice.getAdmin(), AdminDTO.class));

            return noticeDTO;
        });

        return nl;
    }

    /**
     * updateNoticeCount : 공지사항 조회수를 갱신합니다.
     * @param noticeNo : 조회할 공지사항 번호
     *
     * @author 차화응
     */
    @Transactional
    public int updateNoticeCount(int noticeNo) {
        return noticeRepository.updateNoticeCount(noticeNo);
    }

    /**
     * findNoticeDetail : 공지사항 상세정보를 조회합니다.
     * @param noticeNo : 조회할 공지사항 번호
     *
     * @author 차화응
     */
    public NoticeDTO findNoticeDetail(int noticeNo) {

        Notice notice = noticeRepository.findById(noticeNo).get();

        return modelMapper.map(notice, NoticeDTO.class);
    }

    /**
     * findAllNoticeCategory : 공지사항 분류 목록을 조회합니다.
     *
     * @author 차화응
     */
    public List<NoticeCategoryDTO> findAllNoticeCategory() {

        List<NoticeCategory> noticeCategoryList = noticeCategoryRepository.findAllNoticeCategory();

        return noticeCategoryList.stream().map(noticeCategory -> modelMapper.map(noticeCategory, NoticeCategoryDTO.class)).collect(Collectors.toList());
    }

    /**
     * registNewNotice : 공지사항을 등록합니다.
     * @param newNotice : 등록할 공지사항 정보를 담은 객체
     *
     * @author 차화응
     */
    @Transactional
    public void registNewNotice(NoticeDTO newNotice) {

        String registDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new java.sql.Date(System.currentTimeMillis()));
        newNotice.setNoticeRegistDate(registDate);

        noticeRepository.save(modelMapper.map(newNotice, Notice.class));
    }

    /**
     * modifyNotice : 공지사항을 수정합니다.
     * @param updateNotice : 수정할 공지사항 정보를 담은 객체
     *
     * @author 차화응
     */
    @Transactional
    public void modifyNotice(NoticeDTO updateNotice) {

        Notice foundNotice = noticeRepository.findById(updateNotice.getNoticeNo()).get();
        foundNotice.setNoticeCategoryNo(updateNotice.getNoticeCategoryNo());
        foundNotice.setNoticeName(updateNotice.getNoticeName());
        foundNotice.setNoticeContent(updateNotice.getNoticeContent());
    }

    /**
     * removeNotice : 공지사항을 삭제합니다.
     * @param noticeNo : 삭제할 공지사항 번호
     *
     * @author 차화응
     */
    @Transactional
    public void removeNotice(int noticeNo) {

        noticeRepository.deleteById(noticeNo);
    }
}
