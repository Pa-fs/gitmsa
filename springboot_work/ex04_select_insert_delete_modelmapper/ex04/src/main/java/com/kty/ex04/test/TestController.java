package com.kty.ex04.test;

import com.kty.ex04.obj.AA;
import com.kty.ex04.obj.BB;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final AA aa;
    private final BB bb;

    @GetMapping("aa")
    public String aa() {
        aa.doA();
        return "Aaaaaaaaaaa";
    }

    @PostMapping("bb")
    public String bb() {
        bb.doB();
        return "bbbbbbB";
    }
}
