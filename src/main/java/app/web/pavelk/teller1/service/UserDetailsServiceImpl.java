package app.web.pavelk.teller1.service;


import app.web.pavelk.teller1.model.user.SecurityUser;
import app.web.pavelk.teller1.model.user.User;
import app.web.pavelk.teller1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService { // реалезуем сервис

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        //ищем юзера
        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exists"));

        System.out.println("user" + user);

        //создаем спрингового юзера
        return SecurityUser.fromUser(user);
    }
}
