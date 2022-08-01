package com.eukolos.arcadeblog.config;

import com.eukolos.arcadeblog.model.AccountModel;
import com.eukolos.arcadeblog.model.ProjectModel;
import com.eukolos.arcadeblog.service.AccountService;
import com.eukolos.arcadeblog.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private AccountService accountService;



    @Override
    public void run(String... args) throws Exception {
        List<ProjectModel> projects = projectService.getAll();

        if (projects.size() == 0) {

            AccountModel account1 = new AccountModel();
            AccountModel account2 = new AccountModel();


            account1.setFirstName("Admin");
            account1.setLastName("Admin");
            account1.setEmail("admin.admin@arcade.com");
            account1.setPassword("password");

            account2.setFirstName("User");
            account2.setLastName("User");
            account2.setEmail("user.user@arcade.com");
            account2.setPassword("password");

            accountService.save(account1);
            accountService.save(account2);


            ProjectModel project1 = new ProjectModel();
            ProjectModel project2 = new ProjectModel();


            project1.setTitle("title project 1");
            project1.setBody("this is body of project 1");
            project1.setAccountModel(account1);

            project2.setTitle("title project 2");
            project2.setBody("this is body of project 2");
            project2.setAccountModel(account2);


            projectService.save(project1);
            projectService.save(project2);
        }
    }
}
