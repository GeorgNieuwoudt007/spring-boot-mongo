package nl.georg.mongo.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import nl.georg.mongo.model.UserDTO;
import nl.georg.mongo.service.UserService;
import nl.georg.mongo.utilities.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        "api/v1/user"
)
@Slf4j
@Tag(
        name = "User API Controller",
        description = "API to retrieve user information"
)
public class UserApiController {

    @Autowired
    private UserService service;

    @PostMapping(
            "ping"
    )
    @Operation(
            summary = "Ping the rest endpoint",
            description = "Ping the rest endpoint"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "User"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "User not found."
            )
    })
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping(
            "key/{publicKey}"
    )
    @Operation(
            summary = "Get user by public key",
            description = "Do a lookup for a user using the publicKey"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "User found"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "User not found."
            )
    })
    public ResponseEntity<UserDTO> findByPublicKey(@PathVariable String publicKey) {
        var user = service.findUserByPublicKey(publicKey);
        var dto = UserMapper.INSTANCE.map(user);

        log.info("PublicKey: {} Result: {}", publicKey, user);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
