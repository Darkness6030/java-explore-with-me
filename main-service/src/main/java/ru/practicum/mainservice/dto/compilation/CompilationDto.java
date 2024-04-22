package ru.practicum.mainservice.dto.compilation;

import lombok.*;
import ru.practicum.mainservice.dto.event.EventShortDto;

import javax.validation.constraints.*;
import java.util.List;

@Data
@Builder
public class CompilationDto {
    @Positive
    private int id;
    private List<EventShortDto> events;
    private boolean pinned;
    @NotBlank
    private String title;
}
