package com.flavius.gymcenter.service;

import com.flavius.gymcenter.model.Gym;
import com.flavius.gymcenter.model.Instructor;

public interface InstructorService {

    Instructor addInstructorForGym(Instructor instructor, Gym gym);

    Instructor editInstructor(Instructor instructor, Instructor existsInstructor);
}
