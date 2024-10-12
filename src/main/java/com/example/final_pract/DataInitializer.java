package com.example.final_pract;

import com.example.final_pract.entity.RoleEntity;
import com.example.final_pract.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findByName("ROLE_ADMIN") == null) {
            RoleEntity adminRole = new RoleEntity();
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);
        }

        if (roleRepository.findByName("ROLE_MANAGER") == null) {
            RoleEntity managerRole = new RoleEntity();
            managerRole.setName("ROLE_MANAGER");
            roleRepository.save(managerRole);
        }

        if (roleRepository.findByName("ROLE_USER") == null) {
            RoleEntity userRole = new RoleEntity();
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);
        }
    }
}
