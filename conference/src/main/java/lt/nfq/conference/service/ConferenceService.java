package lt.nfq.conference.service;

import java.util.Date;
import java.util.List;

import lt.nfq.conference.domain.Conference;
import lt.nfq.conference.service.dao.ConferenceMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConferenceService {
	
    @Autowired
    private ConferenceMapper conferenceMapper;

    public List<Conference> getConferencesByDates(Date start, Date end) {
    	//public List<Conference> getConferencesByDates(Date start, Date end, Integer[] tags) {
//        return conferenceMapper.getConferencesByDates(start, end, tags);
        return conferenceMapper.getConferencesByDates(start, end);
    }
    
    public List<Conference> getConferences() {
        return conferenceMapper.getConferences();
    }
    
    public List<Integer> getConferencesCategories() {
    	return conferenceMapper.getConferencesCategories();
    }

    public Conference getConference(int id) {
        return conferenceMapper.getConference(id);
    }

    public boolean updateConference(Conference conference) {
        return conferenceMapper.updateConference(conference) > 0;
    }

    public boolean saveConference(Conference conference) {
    	if (conference.getId() != null) {
    		return conferenceMapper.updateConference(conference) > 0;
    	} else {
    		boolean ok = conferenceMapper.insertConference(conference) > 0;
    		for(Integer conferenceCategoryId : conference.getTags())
    			if(conferenceMapper.insertConferenceCategories(conference.getId(), conferenceCategoryId) < 0)
    				ok = false;
    		return ok;
    	}
    }
}
