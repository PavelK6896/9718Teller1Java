package app.web.pavelk.teller1.service;

import app.web.pavelk.teller1.model.user.Role;
import app.web.pavelk.teller1.model.user.User;
import app.web.pavelk.teller1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Role getRole(String name) {
        User user = userRepository.findByEmail(name).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exists"));
        return user.getRole();
    }

    public String getName() {
        return "name";
    }


}
