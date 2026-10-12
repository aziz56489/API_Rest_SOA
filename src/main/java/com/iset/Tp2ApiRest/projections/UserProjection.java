package com.iset.Tp2ApiRest.projections;

import com.iset.Tp2ApiRest.entities.User;
import org.springframework.data.rest.core.config.Projection;

import javax.management.relation.RoleInfo;

@Projection(name = "fullUser" , types = User.class)
public interface UserProjection {
    Long getId();
    String getName();
    String getEmail();
    RoleInfo getRole();
    interface RoleInfo {
        String getName();
    }
}
