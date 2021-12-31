package artizens.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import artizens.domain.UserProfile;
import artizens.repository.UserProfileRepository;

@Service
@Transactional(readOnly = true)
public class UserProfileService {
	
	@Autowired UserProfileRepository userProfileRepository;

    public UserProfile login(String email, String password) {
        List<UserProfile> info = userProfileRepository.findByEmail(email);
        if (info.isEmpty() || !info.get(0).getPassword().equals(password)) {
            return null;
        }
        return info.get(0);
    }

    @Transactional
    public String join(String email, String password, String userName) {
        boolean emailcheck = alreadyEmailInfo(email);
        boolean namecheck = alreadyNameInfo(userName);
        
        if (emailcheck && namecheck) {
        	UserProfile user = UserProfile.createUser(email, password, userName);
        	userProfileRepository.save(user);
            return "true";
        }
        else if (!emailcheck) {
			return "alreadyEmail";
		}
        return "alreadyName";
    }

    @Transactional
    public void delete(Long userId, String password) {
    	UserProfile user = userProfileRepository.findById(userId).orElse(null);
    	if (user != null && user.getPassword().equals(password)) {
    		userProfileRepository.delete(user);
    	}
    }

    private boolean alreadyEmailInfo(String email) {
        List<UserProfile> findByEmail = userProfileRepository.findByEmail(email);
        return findByEmail.size() == 0;
    }
    
    private boolean alreadyNameInfo(String userName) {
        List<UserProfile> findByName = userProfileRepository.findByName(userName);
        return findByName.size() == 0;
    }
	
}
