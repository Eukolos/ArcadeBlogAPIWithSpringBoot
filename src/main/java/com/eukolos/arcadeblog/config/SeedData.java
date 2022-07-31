package com.eukolos.arcadeblog.config;

import com.eukolos.arcadeblog.model.ProjectModel;
import com.eukolos.arcadeblog.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    private ProjectService projectService;

    @Override
    public void run(String... args) throws Exception {
        List<ProjectModel> projects = projectService.getAll();

        if (projects.size() == 0) {
            ProjectModel project1 = new ProjectModel();
            project1.setTitle("title project 1");
            project1.setBody("this is body of project 1");

            ProjectModel project2 = new ProjectModel();
            project2.setTitle("title project 2");
            project2.setBody("this is body of project 2");

            projectService.save(project1);
            projectService.save(project2);
        }
    }
}
