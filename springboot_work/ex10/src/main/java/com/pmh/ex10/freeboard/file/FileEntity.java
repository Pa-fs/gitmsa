package com.pmh.ex10.freeboard.file;

import com.pmh.ex10.freeboard.FreeBoard;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "freeBoardFiles")
@Data
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String name;
    private String path;
    private String fileDesc;

    @ManyToOne
//    @JoinColumn(referencedColumnName = "idx")
    private FreeBoard freeBoard;
}
