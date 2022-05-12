package net.sytes.ucezz.mirea.java.carservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.sytes.ucezz.mirea.java.carservice.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        net.sytes.ucezz.mirea.java.carservice.entity.UserEntity user = userRepository.get(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Unknown user: " + userName);
        }
        UserDetails userDetails = User.builder()
                .username(user.getUsername())
                .password(user.getPasswordHashString())
                .roles(user.getRole())
                .build();
        return userDetails;
    }
}
