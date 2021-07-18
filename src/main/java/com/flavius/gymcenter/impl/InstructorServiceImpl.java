package com.flavius.gymcenter.impl;

import com.flavius.gymcenter.dao.InstructorDao;
import com.flavius.gymcenter.model.Gym;
import com.flavius.gymcenter.model.Instructor;
import com.flavius.gymcenter.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstructorServiceImpl implements InstructorService {

    private final InstructorDao instructorDao;

    public InstructorServiceImpl(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }

    @Override
    public Instructor addInstructorForGym(Instructor instructor, Gym gym) {
        gym.addInstructor(instructor);
        return instructorDao.save(instructor);
    }

    @Override
    public Instructor editInstructor(Instructor instructor, Instructor existsInstructor) {
        existsInstructor.setName(instructor.getName());
        return instructorDao.save(existsInstructor);
    }

}
