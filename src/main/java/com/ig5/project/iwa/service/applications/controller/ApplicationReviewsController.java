package com.ig5.project.iwa.service.applications.controller;

import com.ig5.project.iwa.service.applications.jpa.entity.Application_review;
import com.ig5.project.iwa.service.applications.jpa.repository.ApplicationReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/applications/reviews")
public class ApplicationReviewsController {
    @Autowired
    private ApplicationReviewRepository applicationReviewRepository;

    @GetMapping
    public Page<Application_review> getAllApplicationReviews(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size) {

        if(page != null & size != null) {
            if(page < 0 || size < 1) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "page must be greater than equl to 0, and size must be greater than 0");
            }
            else {
                return applicationReviewRepository.findAll(PageRequest.of(page, size, Sort.by("lastName")));
            }
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "page and size must be provided");
    }

    @GetMapping("{id}")
    public Application_review getReviewById(@PathVariable("id") int id) {
        return applicationReviewRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Application with id %s not found", id)));
    }

    @PostMapping
    public Application_review createApplicationReview(@RequestBody Application_review application_review) {
        return applicationReviewRepository.save(application_review);
    }

    @PutMapping("{id}")
    public Application_review updateApplicationReviewById(@PathVariable("id") int id, @RequestBody Application_review application) {
        return applicationReviewRepository.findById(id)
                .map(existingApplication -> {
                    existingApplication.setId(application.getId());
                    existingApplication.setApplicant_recruter_grade(application.getApplicant_recruter_grade());
                    existingApplication.setRecruter_applicant_grade(application.getRecruter_applicant_grade());
                    return applicationReviewRepository.save(existingApplication);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Application with id %s not found", id)));
    }

    @DeleteMapping("{id}")
    public void deleteApplicationReview(@PathVariable("id") int id) {
        applicationReviewRepository.deleteById(id);
    }
}
