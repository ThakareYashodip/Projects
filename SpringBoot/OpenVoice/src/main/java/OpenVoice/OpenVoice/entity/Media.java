package OpenVoice.OpenVoice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "media")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //uniuque id

    private String image;    // image

    private String url;     // storage url

    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;
}
