package com.flavius.gymcenter.manager;

import com.flavius.gymcenter.dto.InstructorDto;

import java.util.List;

public interface InstructorManagerService {
    void addInstructorForSport(long idInstructor, long idSport);
    void deleteInstructor(long id);

    InstructorDto addInstructorForGym(InstructorDto instructorDto, long idGym);
    InstructorDto editInstructor(InstructorDto instructorDto, long id);
    InstructorDto findInstructorById(long id);

    List<InstructorDto> findInstructorForSport(long idSport);
    List<InstructorDto> findInstructorForGym(long id);
    List<InstructorDto> findAllInstructors();

}
