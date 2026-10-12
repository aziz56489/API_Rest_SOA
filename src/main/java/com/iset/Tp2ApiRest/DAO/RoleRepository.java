package com.iset.Tp2ApiRest.DAO;

import com.iset.Tp2ApiRest.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="roles")
public interface RoleRepository extends JpaRepository<Role,Long> {
}
