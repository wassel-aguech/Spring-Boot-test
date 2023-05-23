package com.example.test.Service;

import com.example.test.Entity.AuthenticationRequest;
import com.example.test.Entity.Client;
import com.example.test.Entity.RegisterRequest;
import com.example.test.Entity.Role;
import com.example.test.Repository.ClientRepo;
import com.example.test.Response.AuthenticationResponse;
import com.example.test.Security.Jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Autowired
    private  ClientRepo clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register(RegisterRequest request) {
        var user = Client.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .email(request.getEmail())
                .mot_de_passe(passwordEncoder.encode(request.getMot_de_passe()))
                .role(Role.CLIENT)
                .build();
        if(!clientRepository.existsByEmail(request.getEmail())){
            clientRepository.save(user);
            var jwtToken = jwtService.generateToken((UserDetails) user);
            return AuthenticationResponse.builder().token(jwtToken).build();
        }else{
            throw new RuntimeException("Email already exists !!!!!!! ");
        }

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = clientRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken((UserDetails) user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}


