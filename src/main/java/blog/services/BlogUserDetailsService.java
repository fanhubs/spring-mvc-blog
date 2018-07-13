package blog.services;

import blog.models.User;
import blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BlogUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {

        User user = userRepository.queryByName(userName).get(0);

        GrantedAuthority authority =
                new SimpleGrantedAuthority("admin");

        UserDetails userDetails = (UserDetails) new
                org.springframework.security.core.userdetails.User(user.getName(),
                user.getPassword_hash(),
                Arrays.asList(authority));


        return userDetails;
    }
}
