package ru.practicum.server.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "endpoint_hits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EndpointHit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "app")
    private String app;

    @Column(name = "uri")
    private String uri;

    @Column(name = "ip")
    private String ip;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (id == null)
            return false;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        EndpointHit other = (EndpointHit) obj;
        return id.equals(other.id);
    }
}
