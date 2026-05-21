package com.example.RestaurantTableBooking.service;


import com.example.RestaurantTableBooking.auth.AuthRequest;
import com.example.RestaurantTableBooking.auth.AuthResponse;
import com.example.RestaurantTableBooking.auth.RegisterRequest;
import com.example.RestaurantTableBooking.entity.User;
import com.example.RestaurantTableBooking.repository.UserRepository;
import com.example.RestaurantTableBooking.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;
    public AuthResponse register(RegisterRequest registerRequest){
        User newUser=new User();
        newUser.setName(registerRequest.getName());
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        newUser.setRole(registerRequest.getRole());
        userRepository.save(newUser);
        String token= jwtUtil.generateToken(registerRequest.getEmail());
        return new AuthResponse(token);
    }
    public AuthResponse login(AuthRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        String token= jwtUtil.generateToken(request.getEmail());
        return new AuthResponse();

    }
}
