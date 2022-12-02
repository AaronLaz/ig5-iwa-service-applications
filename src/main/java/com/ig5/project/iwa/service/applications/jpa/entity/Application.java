package com.ig5.project.iwa.service.applications.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @Column(name="application_id")
    private int id;

    @Column(name="applicant_id")
    private int applicant_id;

    @Column(name="offer_id")
    private int offer_id;

    @Column(name="created_at")
    private Date created;

    @Column(name="status")
    private String status;

    @Column(name="resume")
    private byte[] resume;

    @Column(name="recommendation")
    private int recommendation;

    public Application() {

    }

    public Application(int id, int applicant_id, int offer_id, Date created, String status, byte[] resume, int recommendation){
        this.id = id;
        this.applicant_id = applicant_id;
        this.offer_id = offer_id;
        this.created = created;
        this.status = status;
        this.resume = resume;
        this.recommendation = recommendation;
    }

    public int getApplicationId() {
        return id;
    }

    public void setApplicationId(int id) {
        this.id = id;
    }

    public int getApplicantId() {
        return applicant_id;
    }

    public void setApplicantId(int id) {
        this.applicant_id = id;
    }

    public int getOfferId() {
        return offer_id;
    }

    public void setOfferId(int id) {
        this.offer_id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getResume() {
        return resume;
    }

    public void setResume(byte[] resume) {
        this.resume = resume;
    }

    public int getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(int recommendation) {
        this.recommendation = recommendation;
    }
}
