package OpenVoice.OpenVoice.repository;

import OpenVoice.OpenVoice.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote,Long> {
}
