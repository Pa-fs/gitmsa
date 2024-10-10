package com.pmh.org.login;

import com.pmh.org.user.User;
import com.pmh.org.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public void join(JoinDto joinDto) {

        User user = modelMapper.map(joinDto, User.class);
//        user.setName(joinDto.getUsername());
        user.setPassword(passwordEncoder.encode(joinDto.getPassword()));

        user.setRole("ROLE_ADMIN");
//        user.setRole("ROLE_USER");

        User dbUser = userRepository.save(user);
        log.info("savedUser in DB : {}", dbUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // password 가 1234이면 ADMIN 으로 로그인해라...
        // username 은 아무렇게 들어와도 된다...
        User user = userRepository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException(username));


        log.info("user : {}", user);

        return org.springframework.security.core.userdetails
                .User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles("ADMIN")
                .build();
    }
}
