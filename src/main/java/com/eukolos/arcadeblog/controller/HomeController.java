package com.eukolos.arcadeblog.controller;

import com.eukolos.arcadeblog.model.ProjectModel;
import com.eukolos.arcadeblog.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    public String home(Model model) {
        List<ProjectModel> projects = projectService.getAll();
        model.addAttribute("projects", projects);
        return "home";

    }
}
