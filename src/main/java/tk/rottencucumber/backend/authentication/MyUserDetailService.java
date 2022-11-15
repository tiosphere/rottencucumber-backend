package tk.rottencucumber.backend.authentication;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import tk.rottencucumber.backend.model.UsersModel;
import tk.rottencucumber.backend.repository.UsersRepository;

@Component
@NoArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersModel user = usersRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        User.UserBuilder builder = User.withUsername(user.getUsername()).password(user.getPassword());
        if (user.is_staff()) {
            return builder.roles("ADMIN").build();
        } else {
            return builder.roles("USER").build();
        }
    }
}