package org.motechproject.ghana.national.bean;

import org.apache.xpath.operations.String;
import org.joda.time.DateTime;
import org.motechproject.mobileforms.api.domain.FormBean;
import org.motechproject.mobileforms.api.validator.annotations.RegEx;
import org.motechproject.mobileforms.api.validator.annotations.Required;

import static org.motechproject.ghana.national.FormFieldRegExPatterns.MOTECH_ID_PATTERN;

public class PNCMotherForm extends FormBean {
    public static final String NUMERIC_OR_NOTAPPLICABLE_PATTERN = "([0-9]+(.[0-9]+)?|[nN][aA])";

    @Required
    @RegEx(pattern = NUMERIC_OR_NOTAPPLICABLE_PATTERN)
    private String staffId;
    @Required
    @RegEx(pattern = MOTECH_ID_PATTERN)
    private String motechId;
    @Required
    @RegEx(pattern = NUMERIC_OR_NOTAPPLICABLE_PATTERN)
    private String facilityId;
    private DateTime date;
    @Required
    private int visitNumber;
    @Required
    private String vitaminA;
    @Required
    private String ttDose;
    @Required
    private String location;
    private String house;
    private String community;
    @Required
    private Boolean referred;
    @Required
    private String lochiaColour;
    @Required
    private Boolean lochiaOdourFoul;
    @Required
    private Boolean lochiaAmountExcess;
    private Double temperature;
    private String fht;
    @Required
    private Boolean maleInvolved;
    private String comments;

    private String postpartum;
    private String postpartumCounceled;
    private String postpartumAccepted;
    private String postpartumMethod;
    private String postpartumFirstuse;
    private String postpartumMenstruatedafterdelivery;
    private String DOBChild;
    private String ITNusedpreviousnight;
    private String vvf;


    public String getPostpartum() {
        return postpartum;
    }

    public void setPostpartum(String postpartum) {
        this.postpartum = postpartum;
    }

    public String getPostpartumCounceled() {
        return postpartumCounceled;
    }

    public void setPostpartumCounceled(String postpartumCounceled) {
        this.postpartumCounceled = postpartumCounceled;
    }

    public String getPostpartumAccepted() {
        return postpartumAccepted;
    }

    public void setPostpartumAccepted(String postpartumAccepted) {
        this.postpartumAccepted = postpartumAccepted;
    }

    public String getPostpartumMethod() {
        return postpartumMethod;
    }

    public void setPostpartumMethod(String postpartumMethod) {
        this.postpartumMethod = postpartumMethod;
    }

    public String getPostpartumFirstuse() {
        return postpartumFirstuse;
    }

    public void setPostpartumFirstuse(String postpartumFirstuse) {
        this.postpartumFirstuse = postpartumFirstuse;
    }

    public String getPostpartumMenstruatedafterdelivery() {
        return postpartumMenstruatedafterdelivery;
    }

    public void setPostpartumMenstruatedafterdelivery(String postpartumMenstruatedafterdelivery) {
        this.postpartumMenstruatedafterdelivery = postpartumMenstruatedafterdelivery;
    }

    public String getDOBChild() {
        return DOBChild;
    }

    public void setDOBChild(String DOBChild) {
        this.DOBChild = DOBChild;
    }

    public String getITNusedpreviousnight() {
        return ITNusedpreviousnight;
    }

    public void setITNusedpreviousnight(String ITNusedpreviousnight) {
        this.ITNusedpreviousnight = ITNusedpreviousnight;
    }

    public String getVvf() {
        return vvf;
    }

    public void setVvf(String vvf) {
        this.vvf = vvf;
    }



    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getMotechId() {
        return motechId;
    }

    public void setMotechId(String motechId) {
        this.motechId = motechId;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public Boolean getMaleInvolved() {
        return maleInvolved;
    }

    public void setMaleInvolved(Boolean maleInvolved) {
        this.maleInvolved = maleInvolved;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(String vitaminA) {
        this.vitaminA = vitaminA;
    }

    public String getTtDose() {
        return ttDose;
    }

    public void setTtDose(String ttDose) {
        this.ttDose = ttDose;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public Boolean getReferred() {
        return referred;
    }

    public void setReferred(Boolean referred) {
        this.referred = referred;
    }

    public String getLochiaColour() {
        return lochiaColour;
    }

    public void setLochiaColour(String lochiaColour) {
        this.lochiaColour = lochiaColour;
    }

    public Boolean getLochiaOdourFoul() {
        return lochiaOdourFoul;
    }

    public void setLochiaOdourFoul(Boolean lochiaOdourFoul) {
        this.lochiaOdourFoul = lochiaOdourFoul;
    }

    public Boolean getLochiaAmountExcess() {
        return lochiaAmountExcess;
    }

    public void setLochiaAmountExcess(Boolean lochiaAmountExcess) {
        this.lochiaAmountExcess = lochiaAmountExcess;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getFht() {
        return fht;
    }

    public void setFht(String fht) {
        this.fht = fht;
    }

    public int getVisitNumber() {
        return visitNumber;
    }

    public void setVisitNumber(int visitNumber) {
        this.visitNumber = visitNumber;
    }

    @Override
    public String groupId() {
        return motechId;
    }
}
