package ru.practicum.mainservice.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.mainservice.dto.user.UserFullDto;
import ru.practicum.mainservice.service.UserService;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/admin")
public class UserControllerAdminApi {
    private final UserService userService;

    @PostMapping("/users")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserFullDto addUser(@RequestBody @Valid UserFullDto userFullDto) {
        return userService.addUser(userFullDto);
    }

    @GetMapping("/users")
    public List<UserFullDto> getUsers(@RequestParam(value = "ids", required = false) List<Long> ids,
                                      @RequestParam(value = "from", required = false, defaultValue = "0") @PositiveOrZero Integer from,
                                      @RequestParam(value = "size", required = false, defaultValue = "10") @Positive Integer size) {
        return userService.getUsers(ids, from, size);
    }

    @DeleteMapping("/users/{userId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable @Positive long userId) {
        userService.deleteUser(userId);
    }
}
