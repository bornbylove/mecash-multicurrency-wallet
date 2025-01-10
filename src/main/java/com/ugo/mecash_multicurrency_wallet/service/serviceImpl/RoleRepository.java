package com.ugo.mecash_multicurrency_wallet.service.serviceImpl;

import com.ugo.mecash_multicurrency_wallet.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
