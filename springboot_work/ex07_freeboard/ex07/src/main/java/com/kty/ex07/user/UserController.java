package com.kty.ex07.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("select")
    public ResponseEntity<List<User>> select(){
        return ResponseEntity.status(200).body(userRepository.findAll());
    }

    @PostMapping("insert")
    public ResponseEntity<String> insert(@Valid @RequestBody UserReqDto userReqDto
//            ,@RequestParam(name = "aa") String aa
    ){
        userService.insert(userReqDto);
        return ResponseEntity.status(200).body("success insert");
    }

    @PutMapping("update")
    public ResponseEntity<String> update(@Valid @RequestBody UserReqDto userReqDto) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userReqDto, User.class);

        userRepository.save(user);
        return ResponseEntity.status(200).body("success update");
    }

    @DeleteMapping("delete/{idx}")
    public ResponseEntity<String> delete(@PathVariable("idx") Long idx) {
        System.out.println(idx);
        userRepository.deleteById(idx);
        return ResponseEntity.status(200).body("success delete");
    }
}
