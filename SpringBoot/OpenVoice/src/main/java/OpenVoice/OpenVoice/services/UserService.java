package OpenVoice.OpenVoice.services;

import OpenVoice.OpenVoice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(User user);
    List<User> usersList();
}
