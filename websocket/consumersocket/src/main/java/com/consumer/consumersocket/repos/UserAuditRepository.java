package com.consumer.consumersocket.repos;


import com.consumer.consumersocket.domain.UserAudit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAuditRepository extends JpaRepository<UserAudit, Long> {

    List<UserAudit> findByUserId(String userId);
}
