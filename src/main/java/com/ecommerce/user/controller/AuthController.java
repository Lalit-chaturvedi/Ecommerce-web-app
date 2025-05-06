package com.ecommerce.user.controller;


import com.ecommerce.user.mapper.UserMapper;
import com.ecommerce.user.model.UserLoginRequest;
import com.ecommerce.user.model.UserLoginResponse;
import com.ecommerce.user.model.UserRegisterRequest;
import com.ecommerce.user.model.UserRegisterResponse;
import com.ecommerce.user.service.UserService;
import com.ecommerce.user.service.VerificationTokenService;
import com.ecommerce.utils.ApiExampleResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthController{

    Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }


    @Autowired
    private UserService userService;


    @Autowired
    UserMapper userMapper;

    /**
     * POST /api/auth/login : Authenticate an existing user
     *
     * @param  userLoginRequest (required)
     * @return Successfully authenticated (status code 200)
     */
    @Operation(
            operationId = "loginUser",
            summary = "Authenticate an existing user",
            tags = { "Auth" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully authenticated", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserLoginResponse.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/auth/login",
            produces = { "application/json" },
            consumes = { "application/json" }
    )

    public ResponseEntity<?> loginUser(
            @Parameter(name = "UserLoginRequest", description = "", required = true) @Valid @RequestBody UserLoginRequest userLoginRequest
            ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"Login successful\", \"token\" : \"User logged in successfully\" }";
                    ApiExampleResponseUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        String email = userLoginRequest.getEmail();
        String password = userLoginRequest.getPassword();
        return ResponseEntity.ok(userService.login(email, password));
    }


    /**
     * POST /api/auth/register : Register a new user
     *
     * @param userRegisterRequest  (required)
     * @return Successfully registered (status code 200)
     */
    @Operation(
            operationId = "registerUser",
            summary = "Register a new user",
            tags = { "Auth" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully registered", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserRegisterResponse.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/auth/register",
            produces = { "application/json" },
            consumes = { "application/json" }
    )

    public ResponseEntity<?> registerUser(
            @Parameter(name = "UserRegisterRequest", description = "", required = true) @Valid @RequestBody UserRegisterRequest userRegisterRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"Register successful\", \"token\" : \"User registered successfully\" }";
                    ApiExampleResponseUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return ResponseEntity.ok(userService.register(userMapper.fromRegisterDto(userRegisterRequest)));

    }


}