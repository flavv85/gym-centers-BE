package com.flavius.gymcenter.dao;

import com.flavius.gymcenter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
