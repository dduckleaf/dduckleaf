package com.greedy.dduckleaf.projectreport.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greedy.dduckleaf.authentication.model.dto.CustomUser;
import com.greedy.dduckleaf.common.exception.ProjectReport.ReportRegistException;
import com.greedy.dduckleaf.common.paging.Pagenation;
import com.greedy.dduckleaf.common.paging.PagingButtonInfo;
import com.greedy.dduckleaf.common.utility.DateFormatting;
import com.greedy.dduckleaf.common.utility.PolicyName;
import com.greedy.dduckleaf.projectreport.find.dto.*;
import com.greedy.dduckleaf.projectreport.find.service.ProjectReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.greedy.dduckleaf.common.utility.DateFormatting.getDateAndTime;

/**
 * <pre>
 * Class : FundingRegistController
 * Comment : 프로젝트 신고 프로세스를 담당하는 컨트롤러 클래스입니다.
 * History
 * 2022/04/18 (장민주) findProjectReportListByMemberNo 메소드 작성.
 * 2022/04/22 (장민주) findProjectReportDetail 메소드 작성.
 * 2022/04/23 (장민주) platformManagerDefaultPage 메소드 작성.
 *                    findAllProjectReportList 메소드 작성.
 * 2022/04/24 (장민주) findProjectReportDetail(ModelAndView, int) 메소드 작성.
 *                    findProjectReportListByMemberNo 메소드 작성.
 * 2022/04/25 (장민주) registProjectReportReply(ModelAndView, ProjectReportReplyDTO, CustomUser, RedirectAttributes) 메소드 작성.
 * 2022/04/27 (장민주) findProjectReportListOfOneProject 메소드 작성.
 *                    findProjectReportDetailForProjectManager 메소드 작성.
 * 2022/04/28 (장민주) registProjectReportReply(ModelAndView, ProjectReportReplyDTO, int, CustomUser, RedirectAttributes) 메소드 작성.
 *                    registProjectReportReply(ModelAndView, ProjectReportReplyDTO, int, CustomUser, RedirectAttributes) 리팩토링.
 *                    findProjectReportWaitingList 메소드 작성.
 *                    findProjectReportWaitingList 메소드 리팩토링
 *                    -> findProjectsByProjectReportStatus 로 변경.
 * 2022/05/04 (장민주) registProjectReport 메소드 작성.
 * 2022/05/11 (장민주) findAllProjectReportListForMemberManage 메소드 작성.
 * 2022/05/12 (장민주) findProjectReportListOfOneProject 메소드 수정.
 *            (장민주) findProjectReportDetailForProjectManager 메소드 수정.
 *
 * </pre>
 * @version 1.0.9
 * @author 장민주
 */
@Controller
@RequestMapping("/report")
public class ProjectReportController {

    @Autowired
    private final ProjectReportService service;
    private final ObjectMapper mapper;

    public ProjectReportController(ProjectReportService service, ObjectMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    /**
    * findProjectReportListByMemberNo:회원번호로 로그인회원의 프로젝트신고내역 조회 요청 메소드입니다.
    *  @param user 로그인한 사용자 정보
    *  @param mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장하는 객체
    * @return mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
    */
    @GetMapping("/list")
    public ModelAndView findProjectReportListByMemberNo(@AuthenticationPrincipal CustomUser user, ModelAndView mv) {

        int memberNo = user.getMemberNo();

        List<ProjectReportDTO> projectReportList = service.findProjectReportListByMemberNo(memberNo);

        mv.addObject("projectReportList", projectReportList);
        mv.setViewName("report/list");

        return mv;
    }

    /**
     * findProjectReportDetailForMember: 서포터 마이페이지 하위의 신고관리메뉴에서 보내는 프로젝트 신고번호로 프로젝트신고내역 상세조회 요청 메소드입니다.
     * @param projectReportNo 상세조회를 요청할 프로젝트신고번호
     * @param mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장하는 객체
     * @return mv: 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
     */
    @GetMapping("/detail/{projectReportNo}")
    public ModelAndView findProjectReportDetailForMember(ModelAndView mv, @PathVariable int projectReportNo) {

        ReportDetailInfo reportDetailInfo = service.findProjectReportAndReply(projectReportNo);

        mv.addObject("reportDetailInfo", reportDetailInfo);
        mv.setViewName("report/detail");

        return mv;
    }

    /**
    * platformManagerDefaultPage: 관리자페이지 플랫폼관리 메뉴 하위의 신고관리 첫 화면으로 이동하기 위한 getMapping 메소드입니다
    */
    @GetMapping("/platformmanager/default")
    public void platformManagerDefaultPage() {}

    /**
     * findAllProjectReportList: 프로젝트 신고내역 전체조회 요청 메소드입니다.
     * @param mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장하는 객체
     * @param pageable 페이지 정보를 담은 객체
     * @return mv: 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
     */
    @GetMapping("/platformmanager/listAll")
    public ModelAndView findAllProjectReportList(ModelAndView mv,
        @PageableDefault(size=10, sort="projectReportNo", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<ProjectReportDTO> projectReportList = service.findProjectReportList(pageable);

        PagingButtonInfo pagingInfo = Pagenation.getPagingButtonInfo(projectReportList);

        mv.addObject("projectReportList", projectReportList);
        mv.addObject("pagingInfo", pagingInfo);
        mv.addObject("intent", "listAll");

        mv.setViewName("report/platformmanager/list");

        return mv;
    }

    /**
     * findAllProjectReportListForMemberManage: 프로젝트 신고내역 전체조회 요청 메소드입니다.
     * @param mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장하는 객체
     * @param pageable 페이지 정보를 담은 객체
     * @return mv: 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
     */
    @GetMapping("/membermanager/list")
    public ModelAndView findAllProjectReportListForMemberManage(ModelAndView mv,
        @PageableDefault(size=10, sort="projectReportNo", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<ProjectReportDTO> projectReportList = service.findProjectReportList(pageable);

        PagingButtonInfo pagingInfo = Pagenation.getPagingButtonInfo(projectReportList);

        mv.addObject("projectReportList", projectReportList);
        mv.addObject("pagingInfo", pagingInfo);

        mv.setViewName("report/membermanager/list");

        return mv;
    }

    /**
     * findProjectsByProjectReportStatus: 신고 처리 상태에 따른 프로젝트 신고내역 조회 요청 메소드입니다.
     * @param mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장하는 객체
     * @param projectReportStatus 신고 처리 상태
     * @param pageable 페이지 정보를 담은 객체
     * @return mv: 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
     */
    @GetMapping("/platformmanager/{projectReportStatus}")
    public ModelAndView findProjectsByProjectReportStatus(ModelAndView mv, @PathVariable String projectReportStatus,
        @PageableDefault(size=10, sort="projectReportNo", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<ProjectReportDTO> projectReportList = service.findProjectsByProjectReportStatus(pageable, projectReportStatus);

        PagingButtonInfo pagingInfo = Pagenation.getPagingButtonInfo(projectReportList);

        mv.addObject("projectReportList", projectReportList);
        mv.addObject("pagingInfo", pagingInfo);
        mv.addObject("intent", projectReportStatus);

        mv.setViewName("report/platformmanager/list");

        return mv;
    }

    /**
    * findProjectReportDetail: 플랫폼관리 하위의 신고관리메뉴에서 보내는 프로젝트 신고번호로 프로젝트신고내역 상세조회 요청 메소드입니다.
    * @param mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장하는 객체
    * @param projectReportNo 상세조회를 요청할 프로젝트신고번호
    * @return mv: 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
    */
    @GetMapping("/platformmanager/detail/{projectReportNo}")
    public ModelAndView findProjectReportDetail(ModelAndView mv, @PathVariable int projectReportNo) {

        ReportDetailInfo reportDetailInfo = service.findProjectReportAndReply(projectReportNo);

        mv.addObject("reportDetailInfo", reportDetailInfo);
        mv.setViewName("report/platformmanager/detail");

        return mv;
    }

    /**
    * registProjectReportReply: 프로젝트 신고내역에 대한 답변 등록 요청 메소드입니다.
    * @param mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장하는 객체
    * @param projectReportReply 등록해줄 프로젝트 신고 답변 정보
    * @param user 로그인한 관리자 정보
    * @param rttr 등록 성공 시 전송할 일회성 메시지 data를 담은 객체
    * @return mv: 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
    */
    @PostMapping("/platformmanager/regist")
    public ModelAndView registProjectReportReply(ModelAndView mv, @ModelAttribute ProjectReportReplyDTO projectReportReply,
                                           @AuthenticationPrincipal CustomUser user, RedirectAttributes rttr) {

        /* 세션에서 로그인한 관리자의 회원번호 추출 */
        int adminNo = user.getMemberNo();
        /* 데이터베이스에 삽입해줄 현재 날짜, 시간정보 생성 */
        String registDate = getDateAndTime();

        projectReportReply.setAdminNo(adminNo);
        projectReportReply.setProjectReportReplyDate(registDate);

        service.registReply(projectReportReply);

        rttr.addFlashAttribute("registSuccessMessage", "답변 등록에 성공하였습니다.");
        mv.setViewName("redirect:/report/platformmanager/listAll");

        return mv;
    }

    /**
     * registProjectReportReply: 관리자 프로젝트관리 메뉴 하위 신고관리에서 프로젝트 신고내역에 대한 답변 등록 요청하는 메소드입니다.
     * @param mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장하는 객체
     * @param projectReportReply 등록해줄 프로젝트 신고 답변 정보
     * @param projectNo 신고 대상 프로젝트 번호
     * @param user 로그인한 관리자 회원 정보
     * @param rttr 등록 성공 시 전송할 일회성 메시지 data를 담은 객체
     * @return mv: 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
     */
    @PostMapping("/projectmanager/regist/{projectNo}")
    public ModelAndView registProjectReportReply(ModelAndView mv, @ModelAttribute ProjectReportReplyDTO projectReportReply,
                                                 @PathVariable int projectNo, @AuthenticationPrincipal CustomUser user,
                                                 RedirectAttributes rttr) {

        /* 세션에서 로그인한 관리자의 회원번호 추출 */
        int adminNo = user.getMemberNo();
        /* 데이터베이스에 삽입해줄 현재 날짜, 시간정보 생성 */
        String registDate = getDateAndTime();

        projectReportReply.setAdminNo(adminNo);
        projectReportReply.setProjectReportReplyDate(registDate);

        service.registReply(projectReportReply);

        rttr.addFlashAttribute("registSuccessMessage", "답변 등록에 성공하였습니다.");
        mv.setViewName("redirect:/report/projectmanager/list/" + projectNo);

        return mv;
    }

    /**
     * findProjectReportListByProjectNo: 프로젝트 번호로 해당 프로젝트의 신고내역 조회를 요청하는 메소드입니다.
     * @param mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장하는 객체
     * @param projectNo 프로젝트 번호
     * @param pageable 목록 조회시 페이징 처리를 위한 정보를 담는 객체
     * @return mv: 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
     * @author 장민주
     */
    @GetMapping("/projectmanager/list/{projectNo}")
    public ModelAndView findProjectReportListOfOneProject(ModelAndView mv, @PathVariable int projectNo,
           @PageableDefault(size=10, sort="projectReportNo", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<ProjectReportDTO> projectReportList = service.findProjectReportListOfOneProject(projectNo, pageable);

        ProjectDTO project = projectReportList.stream().findFirst().get().getProject();

        PagingButtonInfo pagingInfo = Pagenation.getPagingButtonInfo(projectReportList);

        mv.addObject("projectReportList", projectReportList);
        mv.addObject("pagingInfo", pagingInfo);
        mv.addObject("projectNo", projectNo);
        mv.addObject("project", project);

        System.out.println("project = " + project);

        mv.setViewName("report/projectmanager/list");

        return mv;
    }

    /**
     * findProjectReportDetailForProjectManager: 프로젝트관리 하위의 신고관리메뉴에서 보내는 프로젝트 신고번호로 프로젝트신고내역 상세조회 요청 메소드입니다.
     * @param mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장하는 객체
     * @param projectReportNo 상세조회를 요청할 프로젝트신고번호
     * @return mv: 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
     * @author 장민주
     */
    @GetMapping("/projectmanager/detail/{projectReportNo}")
    public ModelAndView findProjectReportDetailForProjectManager(ModelAndView mv, @PathVariable int projectReportNo) {

        ReportDetailInfo reportDetailInfo = service.findProjectReportAndReply(projectReportNo);

        mv.addObject("reportDetailInfo", reportDetailInfo);
        mv.addObject("project", reportDetailInfo.getProjectReport().getProject());
        mv.addObject("projectReportNo", projectReportNo);
        mv.setViewName("report/projectmanager/detail");

        return mv;
    }

    /**
     * findAllReportCategories: 프로젝트 신고유형 조회를 요청하는 메소드입니다.
     * @return 모든 신고유형 목록
     * @author 장민주
     */
    @GetMapping(value = "/categories", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String findAllReportCategories() throws JsonProcessingException {

        List<ReportCategoryDTO> reportCategories = service.findAllReportCategories();

        /* json 문자열로 parsing 하여 반환 */
        return mapper.writeValueAsString(reportCategories);
    }

    /**
     * findPolicyContents: 약관 상세내용 조회를 요청하는 메소드입니다.
     * @return 약관 상세내용
     * @author 장민주
     */
    @GetMapping(value = "/policies", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String findPolicyContents() throws JsonProcessingException {
        /* 정책명 호출 */
        String policyName = PolicyName.POLICY_NAME_개인정보_수집_및_이용;

        List<PolicyContentDTO> policyContents = service.findPolicyContents(policyName);

        /* json 문자열로 parsing 하여 반환 */
        return mapper.writeValueAsString(policyContents);
    }

    /**
     * registProjectReport: 프로젝트 신고 등록을 요청하는 메소드입니다.
     * @param mv 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장하는 객체
     * @param projectReport 프로젝트 신고 상세내용
     * @param projectNo 프로젝트 번호
     * @param reportCategoryNo 프로젝트 신고유형 번호
     * @param user 로그인한 사용자 정보
     * @param rttr 등록 성공 시 전송할 일회성 메시지 data를 담은 객체
     * @return mv: 브라우저로 전달할 데이터와 브라우저 경로 정보를 저장한 객체
     * @author 장민주
     */
    @PostMapping("/regist/{projectNo}/{reportCategoryNo}")
    public ModelAndView registProjectReport(ModelAndView mv, @ModelAttribute ProjectReportDTO projectReport,
                                    @PathVariable int projectNo, @PathVariable int reportCategoryNo,
                                    @AuthenticationPrincipal CustomUser user, RedirectAttributes rttr) throws ReportRegistException {

        /* 신고자 정보를 담을 MemberDTO 객체 생성 후 로그인 정보에서 회원번호를 호출하여 set */
        MemberDTO member = new MemberDTO();
        member.setMemberNo(user.getMemberNo());

        /* 프로젝트 정보를 담을 ProjectDTO 객체 생성 후 파라미터로 받은 프로젝트번호를 set */
        ProjectDTO project = new ProjectDTO();
        project.setProjectNo(projectNo);

        /* 신고유형 정보를 담을 ReportCategoryDTO 객체 생성 후 파라미터로 받은 신고유형번호를 set */
        ReportCategoryDTO category = new ReportCategoryDTO();
        category.setReportCategoryNo(reportCategoryNo);

        /* 등록일 데이터를 생성 후 set */
        projectReport.setProjectReportDate(getDateAndTime());

        /* projectReport에 필요한 나머지 데이터를 차례로 set */
        projectReport.setProject(project);
        projectReport.setReportCategory(category);
        projectReport.setMember(member);

        service.registProjectReport(projectReport);

        rttr.addFlashAttribute("registSuccessMessage", "신고 등록이 완료되었습니다.");
        mv.setViewName("redirect:/project/projectdetail/" + projectNo);

        return mv;
    }


}
