package tech.noetzold.pitacocode.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Entity
public class Post {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Type(type="text")
    private String code;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
    private Set<Answer> answers;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro", nullable = false)
    private Calendar data_cadastro;
}
