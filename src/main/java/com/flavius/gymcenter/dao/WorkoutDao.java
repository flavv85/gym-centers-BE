package com.flavius.gymcenter.dao;

import com.flavius.gymcenter.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutDao extends JpaRepository<Workout, Long> {
}
