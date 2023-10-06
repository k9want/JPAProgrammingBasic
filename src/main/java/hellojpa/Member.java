package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

//@Entity
public class Member {
/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member() {
    }


}
