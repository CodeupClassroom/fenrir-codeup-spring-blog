package com.codeup.fenrircodeupspringblog.repositories;

import com.codeup.fenrircodeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
