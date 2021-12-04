package com.serhat.web.security.repository;

import com.serhat.web.security.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface UserDetailsRepository extends JpaRepository<User,Long> {

    User findByUserName(String username);
}
