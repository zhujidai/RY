package com.ruoyi.project.customer.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 客户信息管理对象 customer
 *
 * @author ruoyi
 * @date 2021-07-11
 */
public class Customer extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private String id;

    /**
     *
     */
    @Excel(name = "")
    private String name;

    /**
     *
     */
    @Excel(name = "")
    private String sex;

    /**
     *
     */
    @Excel(name = "")
    private String phone;

    /**
     *
     */
    @Excel(name = "")
    private Long userId;

    private String userName;

    /**
     *
     */
    @Excel(name = "")
    private String intention;

    /**
     *
     */
    @Excel(name = "")
    private BigDecimal prepay;

    /**
     *
     */
    @Excel(name = "")
    private String courseId;

    /**
     *
     */
    @Excel(name = "")
    private String sourceId;

    /**
     *
     */
    @Excel(name = "")
    private String sheng;

    /**
     *
     */
    @Excel(name = "")
    private String shi;

    /**
     *
     */
    @Excel(name = "")
    private String qv;

    /**
     *
     */
    @Excel(name = "")
    private String address;

    /**
     *
     */
    @Excel(name = "")
    private String oaddress;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addDate;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date visitDate;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date nextDate;

    /**
     *
     */
    @Excel(name = "")
    private Long counter;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    public String getIntention() {
        return intention;
    }

    public void setPrepay(BigDecimal prepay) {
        this.prepay = prepay;
    }

    public BigDecimal getPrepay() {
        return prepay;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSheng(String sheng) {
        this.sheng = sheng;
    }

    public String getSheng() {
        return sheng;
    }

    public void setShi(String shi) {
        this.shi = shi;
    }

    public String getShi() {
        return shi;
    }

    public void setQv(String qv) {
        this.qv = qv;
    }

    public String getQv() {
        return qv;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setOaddress(String oaddress) {
        this.oaddress = oaddress;
    }

    public String getOaddress() {
        return oaddress;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setNextDate(Date nextDate) {
        this.nextDate = nextDate;
    }

    public Date getNextDate() {
        return nextDate;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }

    public Long getCounter() {
        return counter;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("sex", getSex())
                .append("phone", getPhone())
                .append("userId", getUserId())
                .append("intention", getIntention())
                .append("prepay", getPrepay())
                .append("courseId", getCourseId())
                .append("sourceId", getSourceId())
                .append("sheng", getSheng())
                .append("shi", getShi())
                .append("qv", getQv())
                .append("address", getAddress())
                .append("oaddress", getOaddress())
                .append("addDate", getAddDate())
                .append("visitDate", getVisitDate())
                .append("nextDate", getNextDate())
                .append("counter", getCounter())
                .append("remark", getRemark())
                .toString();
    }
}
