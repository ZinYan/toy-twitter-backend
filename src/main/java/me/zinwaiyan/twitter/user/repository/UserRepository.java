package me.zinwaiyan.twitter.user.repository;

import me.zinwaiyan.twitter.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}