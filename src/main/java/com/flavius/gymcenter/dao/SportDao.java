package com.flavius.gymcenter.dao;

import com.flavius.gymcenter.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportDao extends JpaRepository<Sport, Long> {
}
