package OpenVoice.OpenVoice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String VoterIp;

    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;
}
