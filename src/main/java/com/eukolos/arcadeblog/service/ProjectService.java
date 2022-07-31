package com.eukolos.arcadeblog.service;

import com.eukolos.arcadeblog.model.ProjectModel;
import com.eukolos.arcadeblog.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Optional<ProjectModel> getById(Long id) {
        return projectRepository.findById(id);
    }

    public List<ProjectModel> getAll() {
        return projectRepository.findAll();
    }

    public ProjectModel save(ProjectModel projectModel) {
        if (projectModel.getId() == null) {
            projectModel.setCreatedAt(LocalDateTime.now());
        }

        return projectRepository.save(projectModel);
    }
}
