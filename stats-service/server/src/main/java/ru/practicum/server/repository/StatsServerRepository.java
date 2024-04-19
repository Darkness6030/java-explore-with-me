package ru.practicum.server.repository;

import org.springframework.data.jpa.repository.*;
import ru.practicum.server.model.*;

import java.time.LocalDateTime;
import java.util.List;

public interface StatsServerRepository extends JpaRepository<EndpointHit, Long> {

    @Query("SELECT new ru.practicum.server.model.StatHits(e.app, e.uri, COUNT(e)) " +
            "FROM EndpointHit e WHERE (:uris IS EMPTY OR e.uri IN :uris) " +
            "AND e.timestamp BETWEEN :start AND :end " +
            "GROUP BY e.app, e.uri ORDER BY COUNT(e) DESC")
    List<StatHits> findAllStatsWithUris(List<String> uris, LocalDateTime start, LocalDateTime end);

    @Query("SELECT new ru.practicum.server.model.StatHits(e.app, e.uri, COUNT(DISTINCT e.ip)) " +
            "FROM EndpointHit e WHERE (:uris IS EMPTY OR e.uri IN :uris) " +
            "AND e.timestamp BETWEEN :start AND :end " +
            "GROUP BY e.app, e.uri ORDER BY COUNT(DISTINCT e.ip) DESC")
    List<StatHits> findAllUniqueStatsWithUris(List<String> uris, LocalDateTime start, LocalDateTime end);
}