package com.projectrecipes.natashastojanova.foodrecipes.service.implementation;

import com.projectrecipes.natashastojanova.foodrecipes.model.UserRole;
import com.projectrecipes.natashastojanova.foodrecipes.repository.UserRoleRepository;
import com.projectrecipes.natashastojanova.foodrecipes.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.logging.Logger;

/**
 * @author Natasha Stojanova
 */
@Service
public class UserRoleServiceImpl extends BaseEntityCrudServiceImpl<UserRole, UserRoleRepository> implements UserRoleService {
    private UserRoleRepository repository;
    private Logger logger = Logger.getLogger(UserRoleService.class.getName());

    public UserRoleServiceImpl(UserRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    protected UserRoleRepository getRepository() {
        return repository;
    }

    @Override
    public UserRole findByName(String name) throws RoleNotFoundException {
        logger.info("Get entity by Name");
        return repository.findByName(name).orElseThrow(RoleNotFoundException::new);
    }

}
