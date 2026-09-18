package ao.JobKit.jobkit.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.JobKit.jobkit.auth.dto.RegisterRequest;
import ao.JobKit.jobkit.auth.dto.RegisterResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse>   register(@Valid @RequestBody RegisterRequest request) {
        User    user = authService.register(request);

        return ResponseEntity
            .status(201)
            .body(new RegisterResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt()
            )
        );     
    }
}
