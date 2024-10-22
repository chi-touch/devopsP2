package devopP2.controllers;

import devopP2.dto.requests.AppUserRequest;
import devopP2.services.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/appUser")
@AllArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;
    @PostMapping("/registerUser")
    public ResponseEntity<?> register(@RequestBody AppUserRequest appUserRequest) {
        return ResponseEntity.status(CREATED)
                .body(appUserService.register(appUserRequest));
    }


}
