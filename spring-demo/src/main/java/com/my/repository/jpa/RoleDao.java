package com.my.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.my.entity.Role;

public interface RoleDao extends PagingAndSortingRepository<Role, Long> {

}
