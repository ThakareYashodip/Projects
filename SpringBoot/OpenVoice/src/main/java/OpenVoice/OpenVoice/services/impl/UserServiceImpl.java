package OpenVoice.OpenVoice.services.impl;

import OpenVoice.OpenVoice.entity.User;
import OpenVoice.OpenVoice.repository.UserRepository;
import OpenVoice.OpenVoice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> usersList() {
        return userRepository.findAll();
    }
}
