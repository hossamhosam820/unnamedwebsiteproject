package com.elhackarz.fehu2026.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.elhackarz.fehu2026.dto.LoginRequest;
import com.elhackarz.fehu2026.dto.SignupRequest;
import com.elhackarz.fehu2026.models.User;
import com.elhackarz.fehu2026.repositories.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private SecurityContextLogoutHandler logoutHandler;

    public AuthenticationController(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
            UserRepository userRepository, SecurityContextLogoutHandler logoutHandler) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.logoutHandler = logoutHandler;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        Authentication authenticationRequest = UsernamePasswordAuthenticationToken
                .unauthenticated(loginRequest.getEmail(), loginRequest.getPassword());
        Authentication authenticationResponse = this.authenticationManager.authenticate(authenticationRequest);
        SecurityContextHolder.getContext().setAuthentication(authenticationResponse);
        HttpSession session = request.getSession();
        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
        return new ResponseEntity<>("User signed-in successfully!", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public RedirectView registerUser(@ModelAttribute SignupRequest signupRequest) {
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return new RedirectView("/signup?USED");
        }
        User user = new User();
        user.setName(signupRequest.getName());
        user.setGpa(signupRequest.getGpa());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setUsername(signupRequest.getUsername());
        user.setBirthyear(signupRequest.getBirthyear());
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return new RedirectView("/login?OK");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) {
        logoutHandler.logout(request, response, authentication);
        request.getSession().removeAttribute("SPRING_SECURITY_CONTEXT");
        request.getSession().invalidate();
        SecurityContextHolder.clearContext();
        return new ResponseEntity<>("Logged out successfully", HttpStatus.OK);
    }
}
