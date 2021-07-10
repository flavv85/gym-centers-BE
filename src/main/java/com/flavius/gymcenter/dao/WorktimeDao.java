package com.flavius.gymcenter.dao;

import com.flavius.gymcenter.model.Worktime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorktimeDao extends JpaRepository<Worktime, Long> {
}
