package com.greedy.dduckleaf.myfunding.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "MockFundForMyFunding")
@Table(name = "TBL_MOCK_FUND")
public class MockFund {

    @Id
    @Column(name = "MOCK_FUND_NO")
    private int mockFundNo;

}
