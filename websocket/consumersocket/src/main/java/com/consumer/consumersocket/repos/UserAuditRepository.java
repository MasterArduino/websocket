package com.consumer.consumersocket.repos;


import com.consumer.consumersocket.domain.UserAudit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserAuditRepository extends JpaRepository<UserAudit, Long> {
    Optional<UserAudit> findByUserId(String userId);
}