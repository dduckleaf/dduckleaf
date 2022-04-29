package com.greedy.dduckleaf.project.dto;

import lombok.*;

/**
 * <pre>
 * Class : MemberDTO
 * Comment :
 *
 * History
 * 2022-04-27 username
 * </pre>
 *
 * @author username
 * @version 1.0.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {

    private int memberNo;
    private String memberName;
    private FarmerDTO farmerInfo;
}
