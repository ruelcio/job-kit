package ao.JobKit.jobkit.auth;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ao.JobKit.jobkit.auth.dto.RegisterRequest;
import ao.JobKit.jobkit.exception.EmailAlreadyExistsException;

@Service 
public class AuthService {
    private final UserRepository    userRepository;
    private final PasswordEncoder   passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public User register(RegisterRequest request) {
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());

        if (existingUser.isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
        String  passwordHash = passwordEncoder.encode(request.getPassword());
        User    user = new User(
            request.getName(),
            request.getEmail(),
            passwordHash
        );
        return userRepository.save(user);
    }
}
