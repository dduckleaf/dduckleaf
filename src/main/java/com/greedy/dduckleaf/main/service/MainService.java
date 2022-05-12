package com.greedy.dduckleaf.main.service;

import com.greedy.dduckleaf.main.dto.MainPageDTO;
import com.greedy.dduckleaf.main.entity.Project;
import com.greedy.dduckleaf.main.entity.ProjectAttachment;
import com.greedy.dduckleaf.main.repository.ProjectAttachmentForMainRepository;
import com.greedy.dduckleaf.main.repository.ProjectForMainRepository;
import com.greedy.dduckleaf.main.dto.ProjectDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : MainService
 * Comment : 실시간 랭킹, 떡잎추천
 * History
 * 2022-05-06 (박상범) 처음 작성 / 떡잎 추천 조회, 실시간 랭킹 조회 관련 메소드 작성
 * 2022-05-12 (박상범) 떡잎 추천 조회, 실시간 랭킹 조회 관련 메소드 수정
 * </pre>
 * @version 1.0.2
 * @author 박상범
 */
@Service
public class MainService {

    private final ProjectForMainRepository projectForMainRepository;
    private final ProjectAttachmentForMainRepository projectAttachmentForMainRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MainService(ProjectForMainRepository projectForMainRepository, ProjectAttachmentForMainRepository projectAttachmentForMainRepository, ModelMapper modelMapper) {
        this.projectForMainRepository = projectForMainRepository;
        this.projectAttachmentForMainRepository = projectAttachmentForMainRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * findMainPage : 실시간 랭킹 리스트, 떡잎 추천 리스트를 조회합니다.
     * @return new MainPageDTO(dduckleafRecommendList, rankingList) : 떡잎추천 리스트, 실시간 랭킹 리스트를 담은 MainPageDTO 객체입니다.
     * @author 박상범
     */
    public MainPageDTO findMainPage() throws ParseException {

        List<Project> foundRankingList = projectForMainRepository.findRankingList();
        List<Project> foundDduckleafRecommendList = projectForMainRepository.findDduckleafRecommendList();


        List<ProjectDTO> rankingList = foundRankingList.stream().map(project ->
                modelMapper.map(project, ProjectDTO.class)).collect(Collectors.toList());

        List<ProjectDTO> dduckleafRecommendList = new ArrayList<>();

        for(int i = 0; i < rankingList.size(); i++) {

            List<ProjectAttachment> projectAttachmentList = projectAttachmentForMainRepository.findByProjectProjectNo(rankingList.get(i).getProjectNo());

            rankingList.get(i).setAttachmentSavedName(projectAttachmentList.get(0).getProjectAttachmentSaveName());
        }

        for(int i = 0; i < foundDduckleafRecommendList.size(); i++) {

            ProjectDTO project = modelMapper.map(foundDduckleafRecommendList.get(i), ProjectDTO.class);

            String endDate = foundDduckleafRecommendList.get(i).getEndDate().replace("-","");
            String nowDate = java.sql.Date.valueOf(LocalDate.now()).toString().replace("-","");

            String format = "yyyyMMdd";

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.KOREA);
            Date end = simpleDateFormat.parse(endDate);
            Date now = simpleDateFormat.parse(nowDate);

            long diffSec = Math.abs(end.getTime() - now.getTime());
            long diffDay = TimeUnit.DAYS.convert(diffSec, TimeUnit.MILLISECONDS);

            project.setDeadLine(diffDay);

            List<ProjectAttachment> projectAttachmentList = projectAttachmentForMainRepository.findByProjectProjectNo(project.getProjectNo());

            project.setAttachmentSavedName(projectAttachmentList.get(0).getProjectAttachmentSaveName());

            dduckleafRecommendList.add(project);
        }

        return new MainPageDTO(dduckleafRecommendList, rankingList);
    }
}
