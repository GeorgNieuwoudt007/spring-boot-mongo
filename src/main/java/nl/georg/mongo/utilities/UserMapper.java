package nl.georg.mongo.utilities;

import nl.georg.mongo.documents.User;
import nl.georg.mongo.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO map(User user);
}
