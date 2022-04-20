//package com.greedy.dduckleaf.projectreport.entity;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity(name = "FarmerInfoForProjectReport")
//@Table(name = "TBL_FARMER_INFO")
//public class FarmerInfo {
//
//    @Id
//    @Column(name = "MEMBER_NO")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int memberNo;
//
//    @Column(name = "FARMER_NAME")
//    private String farmerName;
//
//    @Column(name = "FARMER_EMAIL")
//    private String farmerEmail;
//
//    @Column(name = "FARMER_PHONE")
//    private String farmerPhone;
//
//    @Column(name = "BUSINESS_OWN_TYPE")
//    private String businessOwnType;
//
//    @Column(name = "BUSINESS_OWN_NO")
//    private int businessOwnNo;
//
//    @Column(name = "BUSINESS_NAME")
//    private String businessName;
//
//    @Column(name = "REPRESENTATIVE_NAME")
//    private String representativeName;
//
//    @Column(name = "REPRESENTATIVE_EMAIL")
//    private String representativeEmail;
//
//    @OneToMany(mappedBy = "farmer")
//    private List<ProjectReport> reportList;
//
//    public FarmerInfo() {}
//
//    public FarmerInfo(int memberNo, String farmerName, String farmerEmail, String farmerPhone, String businessOwnType,
//                      int businessOwnNo, String businessName, String representativeName, String representativeEmail, List<ProjectReport> reportList) {
//        this.memberNo = memberNo;
//        this.farmerName = farmerName;
//        this.farmerEmail = farmerEmail;
//        this.farmerPhone = farmerPhone;
//        this.businessOwnType = businessOwnType;
//        this.businessOwnNo = businessOwnNo;
//        this.businessName = businessName;
//        this.representativeName = representativeName;
//        this.representativeEmail = representativeEmail;
//        this.reportList = reportList;
//    }
//
//    public int getMemberNo() {
//        return memberNo;
//    }
//
//    public void setMemberNo(int memberNo) {
//        this.memberNo = memberNo;
//    }
//
//    public String getFarmerName() {
//        return farmerName;
//    }
//
//    public void setFarmerName(String farmerName) {
//        this.farmerName = farmerName;
//    }
//
//    public String getFarmerEmail() {
//        return farmerEmail;
//    }
//
//    public void setFarmerEmail(String farmerEmail) {
//        this.farmerEmail = farmerEmail;
//    }
//
//    public String getFarmerPhone() {
//        return farmerPhone;
//    }
//
//    public void setFarmerPhone(String farmerPhone) {
//        this.farmerPhone = farmerPhone;
//    }
//
//    public String getBusinessOwnType() {
//        return businessOwnType;
//    }
//
//    public void setBusinessOwnType(String businessOwnType) {
//        this.businessOwnType = businessOwnType;
//    }
//
//    public int getBusinessOwnNo() {
//        return businessOwnNo;
//    }
//
//    public void setBusinessOwnNo(int businessOwnNo) {
//        this.businessOwnNo = businessOwnNo;
//    }
//
//    public String getBusinessName() {
//        return businessName;
//    }
//
//    public void setBusinessName(String businessName) {
//        this.businessName = businessName;
//    }
//
//    public String getRepresentativeName() {
//        return representativeName;
//    }
//
//    public void setRepresentativeName(String representativeName) {
//        this.representativeName = representativeName;
//    }
//
//    public String getRepresentativeEmail() {
//        return representativeEmail;
//    }
//
//    public void setRepresentativeEmail(String representativeEmail) {
//        this.representativeEmail = representativeEmail;
//    }
//
//    public List<ProjectReport> getReportList() {
//        return reportList;
//    }
//
//    public void setReportList(List<ProjectReport> reportList) {
//        this.reportList = reportList;
//    }
//
//    @Override
//    public String toString() {
//        return "FarmerInfo{" +
//                "memberNo=" + memberNo +
//                ", farmerName='" + farmerName + '\'' +
//                ", farmerEmail='" + farmerEmail + '\'' +
//                ", farmerPhone='" + farmerPhone + '\'' +
//                ", businessOwnType='" + businessOwnType + '\'' +
//                ", businessOwnNo=" + businessOwnNo +
//                ", businessName='" + businessName + '\'' +
//                ", representativeName='" + representativeName + '\'' +
//                ", representativeEmail='" + representativeEmail + '\'' +
////                ", reportList=" + reportList +
//                '}';
//    }
//}
//
