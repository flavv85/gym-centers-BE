package com.flavius.gymcenter.impl;

import com.flavius.gymcenter.dao.WorktimeDao;
import com.flavius.gymcenter.model.Gym;
import com.flavius.gymcenter.model.Worktime;
import com.flavius.gymcenter.service.WorktimeService;
import org.springframework.stereotype.Component;

@Component
public class WorktimeServiceImpl implements WorktimeService {

    private final WorktimeDao worktimeDao;

    public WorktimeServiceImpl(WorktimeDao worktimeDao){
        this.worktimeDao = worktimeDao;
    }

    @Override
    public Worktime addWorktime(Worktime worktime, Gym gym) {
        gym.addWorktime(worktime);
        return worktimeDao.save(worktime);
    }

    @Override
    public Worktime editWorktime(Worktime worktime, Worktime existsWorktime, Gym gym) {
        existsWorktime.setDay(worktime.getDay());
        existsWorktime.setTimetable(worktime.getTimetable());
        existsWorktime.setStart(worktime.getStart());
        existsWorktime.setEnd(worktime.getEnd());
        gym.addWorktime(existsWorktime);
        return worktimeDao.save(existsWorktime);
    }
}
