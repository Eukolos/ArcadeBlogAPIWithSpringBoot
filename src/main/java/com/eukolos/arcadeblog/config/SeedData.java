package com.eukolos.arcadeblog.config;

import com.eukolos.arcadeblog.model.AccountModel;
import com.eukolos.arcadeblog.model.AuthorityModel;
import com.eukolos.arcadeblog.model.ProjectModel;
import com.eukolos.arcadeblog.repository.AuthorityRepository;
import com.eukolos.arcadeblog.service.AccountService;
import com.eukolos.arcadeblog.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityRepository authorityRepository;


    @Override
    public void run(String... args) throws Exception {
        List<ProjectModel> projects = projectService.getAll();

        if (projects.size() == 0) {

            AuthorityModel user = new AuthorityModel();
            user.setName("ROLE_USER");
            authorityRepository.save(user);

            AuthorityModel admin = new AuthorityModel();
            admin.setName("ROLE_ADMIN");
            authorityRepository.save(admin);

            AccountModel account1 = new AccountModel();
            AccountModel account2 = new AccountModel();

            account1.setFirstName("user_first");
            account1.setLastName("user_last");
            account1.setEmail("user.user@domain.com");
            account1.setPassword("password");
            Set<AuthorityModel> authorities1 = new HashSet<>();
            authorityRepository.findById("ROLE_USER").ifPresent(authorities1::add);
            account1.setAuthorities(authorities1);


            account2.setFirstName("admin_first");
            account2.setLastName("admin_last");
            account2.setEmail("admin.admin@domain.com");
            account2.setPassword("password");

            Set<AuthorityModel> authorities2 = new HashSet<>();
            authorityRepository.findById("ROLE_ADMIN").ifPresent(authorities2::add);
            authorityRepository.findById("ROLE_USER").ifPresent(authorities2::add);
            account2.setAuthorities(authorities2);

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
