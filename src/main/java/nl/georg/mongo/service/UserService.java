package nl.georg.mongo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.georg.mongo.documents.User;
import nl.georg.mongo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User findUserByPublicKey(String publicKey) {
        return repository.findByPublicKey(publicKey);
    }
}
