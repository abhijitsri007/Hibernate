package com.ul.api.controller;

import com.ul.api.ProjectStatusApiApi;
import com.ul.api.service.ProjectStatusService;
import com.ul.model.ProjectStatusRequest;
import com.ul.model.ProjectStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class Controller implements ProjectStatusApiApi {

    @Autowired
    private ProjectStatusService projectStatusService;

    @Override
    public ResponseEntity<List<ProjectStatusResponse>> getAllProjectNotArchived() {
        return new ResponseEntity<>(projectStatusService.getAllProject(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProjectStatusResponse> postNewProject(ProjectStatusRequest projectStatusRequest) {
        return new ResponseEntity<>(projectStatusService.getProject(projectStatusRequest), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProjectStatusResponse> putProjectNotArchivedById(Long id) {
        try {
            return new ResponseEntity<>(projectStatusService.setArchived(id), HttpStatus.OK);
        } catch (NoSuchElementException n) {
            return new ResponseEntity<>(new ProjectStatusResponse().id("No Such Id"), HttpStatus.BAD_REQUEST);
        }
    }
}
