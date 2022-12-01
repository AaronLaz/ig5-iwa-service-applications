package com.ig5.project.iwa.service.applications.controller;

import com.ig5.project.iwa.service.applications.jpa.entity.Application;
import com.ig5.project.iwa.service.applications.jpa.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping
    public Page<Application> getAllApplications(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size) {

        if(page != null & size != null) {
            if(page < 0 || size < 1) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "page must be greater than equl to 0, and size must be greater than 0");
            }
            else {
                return applicationRepository.findAll(PageRequest.of(page, size, Sort.by("lastName")));
            }
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "page and size must be provided");
    }

    @GetMapping("{id}")
    public Application getById(@PathVariable("id") int id) {
        return applicationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Application with id %s not found", id)));
    }

    @PostMapping
    public Application createApplication(@RequestBody Application application) {
        return applicationRepository.save(application);
    }

    @PutMapping("{id}")
    public Application updateApplicationById(@PathVariable("id") int id, @RequestBody Application application) {
        return applicationRepository.findById(id)
                .map(existingApplication -> {
                    existingApplication.setApplicationId(application.getApplicationId());
                    existingApplication.setApplicantId(application.getApplicantId());
                    existingApplication.setOfferId(application.getOfferId());
                    existingApplication.setCreated(application.getCreated());
                    existingApplication.setStatus(application.getStatus());
                    existingApplication.setResume(application.getResume());
                    existingApplication.setRecommendation(application.getRecommendation());
                    return applicationRepository.save(existingApplication);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Application with id %s not found", id)));
    }

    @DeleteMapping("{id}")
    public void deleteApplication(@PathVariable("id") int id) {
        applicationRepository.deleteById(id);
    }

}
