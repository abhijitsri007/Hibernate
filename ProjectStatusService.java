package com.ul.api.service;

import com.ul.api.mapper.MapStructMapper;
import com.ul.api.repository.ProjectStatusRepository;
import com.ul.api.repository.model.ProjectStatus;
import com.ul.model.ProjectStatusRequest;
import com.ul.model.ProjectStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProjectStatusService {

    @Autowired
    private ProjectStatusRepository projectStatusRepository;
    @Autowired
    private MapStructMapper mapStructMapper;

    public List<ProjectStatusResponse> getAllProject() {
        List<ProjectStatus> projectStatusList = new ArrayList<>();
        List<ProjectStatusResponse> projectStatusResponseList = new ArrayList<>();
        projectStatusRepository.findAll().forEach(projectStatusList::add);
        for (ProjectStatus temp : projectStatusList) {
            if (Objects.nonNull(temp) && !temp.getArchived()) {
                projectStatusResponseList.add(mapStructMapper.setProjectStatusToProjectStatusResponseMapper(temp));
            }
        }
        return projectStatusResponseList;
    }

    public ProjectStatusResponse getProject(ProjectStatusRequest projectStatusRequest) {
        ProjectStatus projectStatus = mapStructMapper.setProjectStatusRequestToProjectStatusMapper(projectStatusRequest);
        List<ProjectStatus> projectStatusList = new ArrayList<>();
        projectStatusRepository.findAll().forEach(projectStatusList::add);
        if (Objects.isNull(getProject(projectStatusList, projectStatus))) {
            saveOrUpdate(projectStatus);
            projectStatusRepository.findAll().forEach(projectStatusList::add);
        }
        return mapStructMapper.setProjectStatusToProjectStatusResponseMapper(getProject(projectStatusList, projectStatus));
    }

    public ProjectStatusResponse setArchived(Long id) {
        ProjectStatus projectStatus = getProjectStatusById(id);
        if (Objects.nonNull(projectStatus)) {
            projectStatus.setArchived(Boolean.TRUE);
            projectStatusRepository.save(projectStatus);
            return mapStructMapper.setProjectStatusToProjectStatusResponseMapper(Objects.requireNonNull(getProjectStatusById(id)));
        } else
            return new ProjectStatusResponse();
    }

    private ProjectStatus getProjectStatusById(Long id) {
        return projectStatusRepository.findById(Math.toIntExact(id)).isPresent()
                ? projectStatusRepository.findById(Math.toIntExact(id)).get() : null;
    }

    private void saveOrUpdate(ProjectStatus projectStatus) {
        projectStatus.setDateCreated(LocalDateTime.now());
        projectStatus.setArchived(Boolean.FALSE);
        projectStatusRepository.save(projectStatus);
    }

    private ProjectStatus getProject(List<ProjectStatus> projectStatusList, ProjectStatus projectStatus) {
        ProjectStatus result = null;
        for (ProjectStatus temp : projectStatusList) {
            if (projectStatus.getName().equals(temp.getName())) {
                result = temp;
            }
        }
        return result;
    }
}
