package com.eukolos.arcadeblog.controller;

import com.eukolos.arcadeblog.model.ProjectModel;
import com.eukolos.arcadeblog.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects/{id}")
    public String getPost(@PathVariable Long id, Model model){
        // find project by id
        Optional<ProjectModel> optionalProjectModel = projectService.getById(id);

        if(optionalProjectModel.isPresent()){
            ProjectModel project = optionalProjectModel.get();
            model.addAttribute("project", project);
            return "project";
        } else {
            return "404";
        }

    }
}
