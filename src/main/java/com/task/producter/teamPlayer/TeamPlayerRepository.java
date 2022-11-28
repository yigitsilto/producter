package com.task.producter.teamPlayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeamPlayerRepository extends JpaRepository<TeamPlayerEntity,Long> {
    Optional<TeamPlayerEntity> findByTeamIdAndPlayerId(long teamId, long playerId);
    void deleteAllByTeamId(long teamId);
    void deleteAllByPlayerId(long playerId);

}
