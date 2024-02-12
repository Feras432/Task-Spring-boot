package com.example.demo.service.auth;

import com.example.demo.bo.auth.AuthenticationResponse;
import com.example.demo.bo.auth.CreateSignupRequest;
import com.example.demo.bo.auth.LogoutResponse;

public interface AuthService {

    void signup (CreateSignupRequest createSignupRequest);
    AuthenticationResponse login(CreateLoginRequest createLoginRequest);

    void logout(LogoutResponse logoutResponse);
}
