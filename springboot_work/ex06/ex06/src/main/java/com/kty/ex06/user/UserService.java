package com.kty.ex06.user;

import com.kty.ex06.error.BizException;
import com.kty.ex06.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    // email 중복이면 에러코드
    // email 중복이 아니면 insert 정상적으로 입력...

    public void insert(UserReqDto userReqDto) {

        Optional<User> optionalUser = userRepository.findByEmail(userReqDto.getEmail());
        optionalUser.ifPresent(user -> {
                throw new BizException(ErrorCode.DUPLICATE_USERS);
            }
        );

        System.out.println("실행");
        // save insert 실행...
//        User user = User.builder()
//                .name("홍길동")
//                .age(20)
//                .email("aaa@naver.com")
//                .password("password")
//                .wdate(LocalDateTime.now())
//                .build();
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userReqDto, User.class);

        userRepository.save(user);
    }
}
