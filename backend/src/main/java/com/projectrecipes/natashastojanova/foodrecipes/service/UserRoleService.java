package com.projectrecipes.natashastojanova.foodrecipes.service;

import com.projectrecipes.natashastojanova.foodrecipes.model.UserRole;

import javax.management.relation.RoleNotFoundException;

/**
 * @author Natasha Stojanova
 */
public interface UserRoleService extends BaseEntityCrudService<UserRole> {
    UserRole findByName(String name) throws RoleNotFoundException;
}