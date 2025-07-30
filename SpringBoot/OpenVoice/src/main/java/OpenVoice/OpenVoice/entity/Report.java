package OpenVoice.OpenVoice.entity;

import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reports")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 200)
    private String description;

    private String location;

    private LocalDateTime createdAt = LocalDateTime.now();

    private String status = "Pending";

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "report",cascade = CascadeType.ALL)
    private List<Media> mediaList = new ArrayList<>();

    @OneToMany(mappedBy = "report",cascade = CascadeType.ALL)
    private List<Vote> votes = new ArrayList<>();
}
