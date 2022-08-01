package com.eukolos.arcadeblog.controller;

import com.eukolos.arcadeblog.model.AccountModel;
import com.eukolos.arcadeblog.model.ProjectModel;
import com.eukolos.arcadeblog.service.AccountService;
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

    @Autowired
    private AccountService accountService;

    @GetMapping("/projects/{id}")
    public String getProject(@PathVariable Long id, Model model){
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

    @GetMapping("/projects/new")
    public String createNewProject(Model model) {
        Optional<AccountModel> optionalAccountModel = accountService.findByEmail("user.user@arcade.com");
        if(optionalAccountModel.isPresent()){
            ProjectModel projectModel = new ProjectModel();
            projectModel.setAccountModel(optionalAccountModel.get());
            model.addAttribute("projectModel", projectModel);
            return "project_new";
        } else {
            return "404";
        }
    }
}
