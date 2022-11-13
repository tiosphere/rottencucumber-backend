package tk.rottencucumber.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "likes")
public class LikesModel {

    @Id
    @Column(name = "id")
    private Long id;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", nullable = false)
    private UsersModel user;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "review_id", nullable = false)
    private ReviewsModel review;
}
