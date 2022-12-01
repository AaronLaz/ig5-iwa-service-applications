package com.ig5.project.iwa.service.applications.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "application_reviews")
public class Application_review {
    @Id
    @Column(name="application_id")
    private int id;

    @Column(name="applicant_to_recruiter_grade")
    private int applicant_recruiter_grade;

    @Column(name="recruiter_to_applicant_grade")
    private int recruiter_applicant_grade;

    public Application_review() {}

    public Application_review(int id, int applicant_recruter_grade, int recruter_applicant_grade){
        this.id = id;
        this.applicant_recruiter_grade = applicant_recruter_grade;
        this.recruiter_applicant_grade = recruter_applicant_grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApplicant_recruter_grade() {
        return applicant_recruiter_grade;
    }

    public void setApplicant_recruter_grade(int id) {
        this.applicant_recruiter_grade = id;
    }

    public int getRecruter_applicant_grade() {
        return recruiter_applicant_grade;
    }

    public void setRecruter_applicant_grade(int id) {
        this.recruiter_applicant_grade = id;
    }
}
