package com.greedy.dduckleaf.main.dto;

import java.util.List;

import com.greedy.dduckleaf.main.entity.Project;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MainPageDTO {

    private List<ProjectDTO> dduckleafRecommendList;
    private List<ProjectDTO> rankingList;

}
