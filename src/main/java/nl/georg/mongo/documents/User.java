package nl.georg.mongo.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private Integer id;

    @Field("first_name")
    @NonNull
    private String firstName;

    @Field("last_name")
    @NonNull
    private String lastName;

    @Field("public_key")
    private String publicKey;
}
