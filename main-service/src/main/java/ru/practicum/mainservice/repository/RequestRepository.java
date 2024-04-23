package ru.practicum.mainservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.practicum.mainservice.model.Request;
import ru.practicum.mainservice.model.RequestStatus;

import java.util.List;
import java.util.Map;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findAllByEventId(long eventId);

    List<Request> findAllByRequesterId(long userId);

    List<Request> findAllByIdIn(List<Long> ids);

    List<Request> findAllByEventIdInAndStatusEquals(List<Long> ids, RequestStatus status);

    int countAllByEventIdAndStatusEquals(long eventId, RequestStatus status);

    @Query("SELECT new map(cast(r.event.id as long) as eventId, count(r) as requestCount) " +
            "FROM Request r WHERE r.event.id IN ?1 AND r.status = ?2 " +
            "GROUP BY r.event.id")
    Map<Long, Integer> findAllConfirmedRequestsByEventIds(List<Long> ids, RequestStatus status);
}
