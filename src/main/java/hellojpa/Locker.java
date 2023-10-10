package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Locker {

    @Id
    @GeneratedValue
    private Long id;


    private String name;

    //양방향 만들고 싶다면?
//    @OneToOne(mappedBy = "locker")
//    private Member member;
}
