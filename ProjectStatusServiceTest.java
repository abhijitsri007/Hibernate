package com.ul.api.service;

import com.ul.api.mapper.MapStructMapper;
import com.ul.api.repository.model.ProjectStatus;
import com.ul.api.repository.ProjectStatusRepository;
import com.ul.model.ProjectStatusResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProjectStatusServiceTest {

    @InjectMocks
    private ProjectStatusService projectStatusServiceMock;
    @Mock
    private ProjectStatus projectStatusMock;
    @Mock
    private ProjectStatusRepository projectStatusRepositoryMock;
    @Mock
    private MapStructMapper mapStructMapperMock;
    @Mock
    private List<ProjectStatus> projectStatusListMock;

    @Before
    public void init() {
        projectStatusListMock = new ArrayList<>();
        projectStatusMock = new ProjectStatus(1, "test", "IN_PROGRESS", LocalDateTime.now(), false);
        projectStatusListMock.add(projectStatusMock);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllProjectWhenExists() {
        when(projectStatusRepositoryMock.findAll()).thenReturn(projectStatusListMock);
        Assert.assertNotNull(projectStatusServiceMock.getAllProject());
        for (ProjectStatusResponse projectStatusResponseList :
                projectStatusServiceMock.getAllProject()) {
            Assert.assertEquals(projectStatusResponseList.getName(), "test");
        }
    }

    @Test
    public void getAllProjectWhenNotExists() {
        projectStatusListMock = new ArrayList<>();
        when(projectStatusRepositoryMock.findAll()).thenReturn(projectStatusListMock);
        Assert.assertArrayEquals(projectStatusServiceMock.getAllProject().toArray(), projectStatusListMock.toArray());
    }

    @Test
    public void getProject() {

    }

    @Test
    public void setArchivedWhenTrue() {

    }

    @Test
    public void setArchivedWhenFalse() {

    }
}