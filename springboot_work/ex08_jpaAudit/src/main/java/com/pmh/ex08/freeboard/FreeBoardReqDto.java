package com.pmh.ex08.freeboard;

import com.pmh.ex08.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
public class FreeBoardReqDto {

    private Long idx;

    @Schema(example = "제목을 넣어주세요")
    @Length(min = 2, max = 255)
    private String title;

    @Schema(example = "내용을 넣어주세요")
    @NotEmpty
    private String content;

    @Schema(hidden = true)
    private User user;

    @Schema(hidden = true)
    private LocalDateTime regDate;

    @Schema(hidden = true)
    private LocalDateTime modDate;

    @Schema(hidden = true)
    private int viewCount;
}
