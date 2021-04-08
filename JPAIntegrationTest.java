package com.ul.api.service.repository;

import com.ul.api.BackendApp;
import com.ul.api.repository.ProjectStatusRepository;
import com.ul.api.repository.model.ProjectStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApp.class)
public class JPAIntegrationTest {

    @Autowired
    private ProjectStatusRepository projectStatusRepository;

    @Test
    public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
        ProjectStatus projectStatus = projectStatusRepository
                .save(new ProjectStatus(1, "test", "IN_PROGRESS", LocalDateTime.now(), false));
        Optional<ProjectStatus> foundProjects = projectStatusRepository
                .findById(projectStatus.getId());

        assertNotNull(foundProjects);
        assertNotNull(projectStatus);
        assertEquals(projectStatus.getName(), foundProjects.get().getName());
    }
}
