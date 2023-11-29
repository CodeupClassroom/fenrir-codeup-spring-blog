package com.codeup.fenrircodeupspringblog.repositories;

import com.codeup.fenrircodeupspringblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
