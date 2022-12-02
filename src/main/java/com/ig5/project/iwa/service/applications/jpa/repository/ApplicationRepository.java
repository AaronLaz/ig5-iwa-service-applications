package com.ig5.project.iwa.service.applications.jpa.repository;

import com.ig5.project.iwa.service.applications.jpa.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}
