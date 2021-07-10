package com.flavius.gymcenter.dao;

import com.flavius.gymcenter.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDao extends JpaRepository<Instructor, Long> {
}
