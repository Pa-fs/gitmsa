package com.pmh.org.freeboard;

import com.pmh.org.error.BizException;
import com.pmh.org.error.ErrorCode;
import com.pmh.org.freeboard.file.FileEntity;
import com.pmh.org.freeboard.file.FileRepository;
import com.pmh.org.user.User;
import com.pmh.org.user.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("freeboard")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class FreeBoardController {

    private final FreeBoardRepository freeBoardRepository;
    private final FileRepository fileRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Value("${my.value}")
    private String welcome;

    @GetMapping("test")
    public String test() {
        return welcome;
    }

    @GetMapping
    public ResponseEntity<FreeBoardResponsePageDto> findAll(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum
                                                            , @RequestParam(name = "size", defaultValue = "5") int size){

        Sort sort = Sort.by(Sort.Direction.DESC, "regDate");

        Pageable pageable = PageRequest.of(pageNum, size, sort);

        Page<FreeBoard> page = freeBoardRepository.findAll(pageable);

        System.out.println("elements = " + page.getTotalElements());
        System.out.println("pages = " + page.getTotalPages());

        FreeBoardResponsePageDto freeboardResponsePageDto = modelMapper.map(page, FreeBoardResponsePageDto.class);

        List<FreeBoardResponseDto> list = new ArrayList<>();
        for (FreeBoard freeBoard : freeboardResponsePageDto.getContent()) {
            FreeBoardResponseDto freeBoardResponseDto
                    = modelMapper.map(freeBoard, FreeBoardResponseDto.class);

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd hh:mm");
            freeBoardResponseDto.setRegDate(dateTimeFormatter.format(freeBoard.getRegDate()));
            freeBoardResponseDto.setModDate(dateTimeFormatter.format(freeBoard.getModDate()));

            if(freeBoard.getUser()!=null) {
                freeBoardResponseDto.setCreAuthor(freeBoard.getUser().getName());
                freeBoardResponseDto.setModAuthor(freeBoard.getUser().getName());
                freeBoardResponseDto.setUserIdx(freeBoard.getUser().getIdx());
            }else{
                freeBoardResponseDto.setCreAuthor("탈퇴한 회원");
                freeBoardResponseDto.setModAuthor("탈퇴한 회원");
            }

            list.add(freeBoardResponseDto);
        }

        freeboardResponsePageDto.setList(list);

        return ResponseEntity.ok(freeboardResponsePageDto);
    }

    @GetMapping("view/{idx}")
    public ResponseEntity<FreeBoardResponseDto> findOne(@PathVariable(name = "idx") long idx) {

        FreeBoard freeBoard = freeBoardRepository.findById(idx)
                .orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND));
        freeBoard.setViewCount(freeBoard.getViewCount() + 1);


        System.out.println(freeBoard.getList().toString());

        FreeBoardResponseDto freeBoardResponseDto = modelMapper.map(freeBoard, FreeBoardResponseDto.class);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd hh:mm");
        freeBoardResponseDto.setRegDate(dateTimeFormatter.format(freeBoard.getRegDate()));
        freeBoardResponseDto.setModDate(dateTimeFormatter.format(freeBoard.getModDate()));

        log.info("idx = {}", idx);
        if(freeBoard.getUser()!=null) {
            freeBoardResponseDto.setCreAuthor(freeBoard.getUser().getName());
            freeBoardResponseDto.setModAuthor(freeBoard.getUser().getName());
            freeBoardResponseDto.setUserIdx(freeBoard.getUser().getIdx());
        }else{
            freeBoardResponseDto.setCreAuthor("탈퇴한 회원");
            freeBoardResponseDto.setModAuthor("탈퇴한 회원");
        }

        freeBoardRepository.save(freeBoard);

        return ResponseEntity.ok(freeBoardResponseDto);
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    @Transactional
    public ResponseEntity<FreeBoard> save(
            @Valid @RequestPart(name = "data") FreeBoardReqDto freeBoardReqDto,
            @RequestPart(name = "file", required = false) MultipartFile file) {

        FreeBoard freeBoard = modelMapper.map(freeBoardReqDto, FreeBoard.class);

        // insert 가 될 때는 idx -> 자동 증가 1,2,3,4
        if (freeBoardReqDto.getIdx() == null) {
            freeBoardRepository.save(freeBoard);
        } else {
            // idx 가 있으면 수정 부분
//            FreeBoard dbFreeboard = freeBoardRepository.findById(freeBoard.getIdx()).orElseThrow();
            FreeBoard dbFreeboard = modelMapper.map(freeBoardReqDto, FreeBoard.class);
            freeBoardRepository.save(dbFreeboard);
        }
        // Todo...
        // 1번 사용자가 무조건 작성 한걸로..
        // jwt 로그인 하면 ... 로그인한 사용자를 넣을꺼예요
        // freeBoard entity 와 user entity 연결
        User user = userRepository.findById(1l).orElse(null);
        freeBoard.setUser(user);

        if (file != null) {
            // 경로 생성
            String myFilePath = Paths.get("images/file/").toAbsolutePath() + File.separator + file.getOriginalFilename();
            try {
                // 파일 생성
                File destFile = new File(myFilePath);
                // 프론트에서 업로드한 파일을 destFile 경로가 지정되어 있는 곳으로 transfer
                file.transferTo(destFile);
            } catch (Exception e) {
                // I/O 커넥션 비정상적 종료 or 이상한 파일명 or 용량이 부족한 상황 등 여러 예외상황이 있을 수 있음
                e.printStackTrace();
            }

            FileEntity fileEntity = new FileEntity();
            fileEntity.setName(file.getOriginalFilename());
            fileEntity.setPath(Paths.get("images/file/").toAbsolutePath().toString());
            fileEntity.setFreeBoard(freeBoard);
            fileRepository.save(fileEntity);

            freeBoard.setList(List.of(fileEntity));
            freeBoardRepository.save(freeBoard);
        }else{
            List<FileEntity> list = fileRepository.findByFreeBoardIdx(freeBoard.getIdx());
            list.forEach(fileEntity -> {
                // delete * from free_board_file where idx = ?
                fileRepository.deleteById(fileEntity.getIdx());
                fileRepository.flush();
            });
            freeBoard.setList(List.of());
            freeBoardRepository.save(freeBoard);
        }
        return ResponseEntity.status(200).body(freeBoard);
    }

    @DeleteMapping("delete/{idx}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "idx") Long idx) {
        FreeBoard freeBoard = freeBoardRepository.findById(idx)
                .orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND));

//        freeBoard.setList(new ArrayList<>());
        freeBoard.setUser(null);
        freeBoardRepository.save(freeBoard);
        freeBoardRepository.delete(freeBoard);

//        fileRepository.findByFreeBoardIdx(
//                freeBoard.getIdx()).forEach(fileEntity -> {
//            fileRepository.deleteById(fileEntity.getIdx());
//        });
//        freeBoardRepository.cusDeleteByIdx(idx);
        return ResponseEntity.ok("삭제되었습니다.");
    }
}
