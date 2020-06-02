package com.example.school.services.interfaces;

import com.example.school.database.entities.Presence;
import com.example.school.viewModels.PresenceViewModel;

public interface IPresenceService {
	
	Presence addPresence(PresenceViewModel presenceModel);
}
