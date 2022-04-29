package com.greedy.dduckleaf.project.dto;

import lombok.*;

/**
 * <pre>
 * Class : FarmerDTO
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
public class FarmerDTO {

    private int farmerNo;
    private String farmerName;
    private int memberNo;
    private String businessName;
}
