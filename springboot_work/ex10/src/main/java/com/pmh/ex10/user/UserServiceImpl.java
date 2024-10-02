package com.pmh.ex10.user;

import com.pmh.ex10.error.BizException;
import com.pmh.ex10.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    // email 중복이면 에러코드 .
    // email 중복이 아니면 insert 정상적으로 입력...
    public void insert(UserReqDto userReqDto){

        Optional<User> optionalUser = userRepository.findByEmail(userReqDto.getEmail());
        optionalUser.ifPresent(user -> {
            throw new BizException(ErrorCode.DUPLICATE_USERS);
        });

        System.out.println("실행"+ userReqDto);
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userReqDto, User.class);
        System.out.println("user = "+ user);
        userRepository.save(user);

    }

    @Override
    public void update(UserReqDto userReqDto) {

        User user = modelMapper.map(userReqDto, User.class);
        System.out.println("user = " + user);


    }
}
