package com.flavius.gymcenter.dao;

import com.flavius.gymcenter.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymDao extends JpaRepository<Gym, Long> {
}
