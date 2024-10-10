package com.pmh.org.user;

import com.pmh.org.error.BizException;
import com.pmh.org.error.ErrorCode;
import com.pmh.org.freeboard.FreeBoardRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserRepository userRepository;
    private final FreeBoardRepository freeBoardRepository;
    private final UserService userService;

    @GetMapping("select")
    public ResponseEntity<List<User>> select(){
        return ResponseEntity.status(200).body(userRepository.findAll());
    }

    @PostMapping("insert")
    public ResponseEntity<String> insert(@Valid @RequestBody UserReqDto userReqDto){

        userService.insert(userReqDto);

        return ResponseEntity.status(200).body("success insert");
    }


    @PutMapping("update")
    public ResponseEntity<String> update(@Valid @RequestBody UserReqDto userReqDto){
        System.out.println("실행"+ userReqDto);
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userReqDto, User.class);
        System.out.println("user = "+ user);

        User findUser = userRepository.findById(user.getIdx())
                .orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND));


        userRepository.save(findUser);
        return ResponseEntity.status(200).body("success update");
    }

    // delete * from user where idx = ?
    @DeleteMapping("delete/{idx}")
    public ResponseEntity<String> delete(@PathVariable(name = "idx") long idx){
        User dbUser = userRepository.findById(idx).orElseThrow();

        dbUser
                .getList()
                .stream()
                .forEach(freeBoard -> {
                    freeBoard.setUser(null);
                    freeBoardRepository.save(freeBoard);
                });

        dbUser.setList(new ArrayList<>());
        userRepository.delete(dbUser);

        return ResponseEntity.status(200).body("success delete");
    }
}
