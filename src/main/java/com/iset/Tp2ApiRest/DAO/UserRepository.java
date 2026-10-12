
package com.iset.Tp2ApiRest.DAO;

import com.iset.Tp2ApiRest.entities.User;
import com.iset.Tp2ApiRest.projections.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "users" , excerptProjection = UserProjection.class)
public interface UserRepository extends JpaRepository<User, Long> {

    @RestResource(path = "byName", rel = "byName")
    List<User> findByNameContains(@Param("name") String name);
}
