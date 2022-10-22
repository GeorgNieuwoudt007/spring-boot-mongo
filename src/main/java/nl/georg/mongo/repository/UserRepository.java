package nl.georg.mongo.repository;

import nl.georg.mongo.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

    @Query("{publicKey:'?0'}")
    User findByPublicKey(String publicKey);
}
