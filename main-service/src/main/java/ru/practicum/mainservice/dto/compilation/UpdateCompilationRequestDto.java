package ru.practicum.mainservice.dto.compilation;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Builder
public class UpdateCompilationRequestDto {
    @Size(min = 2, max = 50)
    private String title;
    private Boolean pinned;
    private Set<Long> events;
}
