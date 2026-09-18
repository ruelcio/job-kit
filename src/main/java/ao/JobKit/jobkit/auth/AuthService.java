package ao.JobKit.jobkit.auth;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ao.JobKit.jobkit.auth.dto.RegisterRequest;
import ao.JobKit.jobkit.exception.EmailAlreadyExistsException;

@Service 
public class AuthService {
    private final UserRepository    userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User register(RegisterRequest request) {
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());

        if (existingUser.isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
        User user = new User(
            request.getName(),
            request.getEmail(),
            request.getPassword()
        );
        return userRepository.save(user);
    }
}
