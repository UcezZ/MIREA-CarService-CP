package net.sytes.ucezz.mirea.java.carservice.security;

import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import net.sytes.ucezz.mirea.java.carservice.repository.UserRepository;

@Component
public class AuthencationProvider implements AuthenticationProvider {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String passwordHash = new String();

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(authentication.getCredentials().toString().getBytes());
            byte[] digest = messageDigest.digest();
            passwordHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        net.sytes.ucezz.mirea.java.carservice.entity.User user = userRepository.get(userName);
        if (user == null) {
            throw new BadCredentialsException("Unknown user " + userName);
        }
        if (!passwordHash.equals(user.getPasswordHashString())) {
            throw new BadCredentialsException("Bad password");
        }
        UserDetails principal = User.builder()
                .username(user.getUsername())
                .password(user.getPasswordHashString())
                .roles(user.getRole())
                .build();
        return new UsernamePasswordAuthenticationToken(principal, passwordHash, principal.getAuthorities());

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
