package ru.practicum.mainservice.dto.compilation;

import lombok.Builder;
import lombok.Data;
import ru.practicum.mainservice.dto.event.EventShortDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@Builder
public class CompilationDto {
    @Positive
    private int id;

    @NotBlank
    private String title;

    private List<EventShortDto> events;
    private boolean pinned;
}
