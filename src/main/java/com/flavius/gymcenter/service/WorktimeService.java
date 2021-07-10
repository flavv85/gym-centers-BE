package com.flavius.gymcenter.service;

import com.flavius.gymcenter.model.Gym;
import com.flavius.gymcenter.model.Worktime;

public interface WorktimeService {
    Worktime addWorktime(Worktime worktime, Gym gym);

    Worktime editWorktime(Worktime worktime, Worktime existsWorktime, Gym gym);
}
