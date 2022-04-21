package com.greedy.dduckleaf.projectnotice.repository;

import com.greedy.dduckleaf.config.BeanConfiguration;
import com.greedy.dduckleaf.config.DduckleafApplication;
import com.greedy.dduckleaf.config.JPAConfiguration;
import com.greedy.dduckleaf.projectnotice.entity.ProjectNotice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;

=======
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

>>>>>>> 1e101362e7c22ff1649529fcd9be5a852352e32f
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
<<<<<<< HEAD
@ContextConfiguration(classes = {DduckleafApplication.class, BeanConfiguration.class, JPAConfiguration.class})
class ProjectNoticeRepositoryTest {
=======
@ContextConfiguration(classes = {
        com.greedy.dduckleaf.config.ContextConfiguration.class,
        DduckleafApplication.class,
        BeanConfiguration.class,
        JPAConfiguration.class})
public class ProjectNoticeRepositoryTest {

>>>>>>> 1e101362e7c22ff1649529fcd9be5a852352e32f

    @Autowired
    private ProjectNoticeRepository projectNoticeRepository;

    @Test
    public void initTest() {
        assertNotNull(projectNoticeRepository);
    }

    @Test
    public void findAllByProjectNo_test() {

<<<<<<< HEAD
        int projectNo = 3;
        Pageable pageable = PageRequest.of(10, 10);
        Page<ProjectNotice> noticeList = projectNoticeRepository.findAllByProjectNo(projectNo, pageable);

        assertNotNull(noticeList);
        noticeList.forEach(System.out::println);
    }


}
=======

        List<ProjectNotice> list = projectNoticeRepository.findAll();
        list.forEach(System.out::println);


    }
}
>>>>>>> 1e101362e7c22ff1649529fcd9be5a852352e32f
