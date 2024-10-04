package com.pmh.ex10.freeboard.file;

import com.pmh.ex10.freeboard.FreeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, Long> {

    List<FileEntity> findByFreeBoardIdx(Long idx);
}
