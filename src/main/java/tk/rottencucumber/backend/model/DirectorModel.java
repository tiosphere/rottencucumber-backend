package tk.rottencucumber.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "directors")
@NoArgsConstructor
public class DirectorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "slug", nullable = false, unique = true)
    private String slug;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Column(name = "type")
    private String type;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "birth_place")
    private String birthPlace;
    @Column(name = "description", columnDefinition = "mediumtext")
    private String description;
    //Reverse relations
    @ManyToMany(mappedBy = "directors", cascade = CascadeType.REMOVE)
    private Set<MovieModel> movies;

    public DirectorModel(String name, String slug, String type, byte[] image, String birthPlace, LocalDate birthday, String description) {
        this.name = name;
        this.slug = slug;
        this.type = type;
        this.image = image;
        this.birthPlace = birthPlace;
        this.birthday = birthday;
        this.description = description;
    }
}
