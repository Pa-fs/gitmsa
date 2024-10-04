package com.pmh.ex10.freeboard;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pmh.ex10.freeboard.file.FileEntity;
import com.pmh.ex10.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
//@Table(name = "freeboard")
public class FreeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String title;
    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;

    @CreatedBy
    @Column(updatable = false)
    private String creAuthor;

    @LastModifiedBy
    private String modAuthor;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    private LocalDateTime modDate;

    @Column(columnDefinition = "int default 0")
    private int viewCount;

    @OneToMany(mappedBy = "freeBoard", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FileEntity> list = new ArrayList<>();

    @Override
    public String toString() {
        return "FreeBoard{" +
                "list=" + list +
                ", viewCount=" + viewCount +
                ", modDate=" + modDate +
                ", regDate=" + regDate +
                ", modAuthor='" + modAuthor + '\'' +
                ", creAuthor='" + creAuthor + '\'' +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", idx=" + idx +
                '}';
    }
}
