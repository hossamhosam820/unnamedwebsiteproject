package com.elhackarz.fehu2026.controller;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.elhackarz.fehu2026.dto.LoginRequest;
import com.elhackarz.fehu2026.dto.SignupRequest;
import com.elhackarz.fehu2026.models.Role;
import com.elhackarz.fehu2026.models.User;
import com.elhackarz.fehu2026.repositories.RoleRepository;
import com.elhackarz.fehu2026.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
@Autowired
private AuthenticationManager authenticationManager;
@Autowired
private PasswordEncoder passwordEncoder;
@Autowired
private UserRepository userRepository;
@Autowired
private RoleRepository roleRepository;
private final SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
@PostMapping("/login")
public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
Authentication authenticationRequest =
UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.getEmail(), loginRequest.getPassword());
Authentication authenticationResponse = this.authenticationManager.authenticate(authenticationRequest);
SecurityContextHolder.getContext().setAuthentication(authenticationResponse);
HttpSession session = request.getSession();
session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
return new ResponseEntity<>("User signed-in successfully!", HttpStatus.OK);}
@PostMapping("/signup")
public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
if (userRepository.existsByEmail(signupRequest.getEmail())) {
return new ResponseEntity<>("Email already used!", HttpStatus.BAD_REQUEST);}
User user = new User();
user.setName(signupRequest.getName());
user.setEmail(signupRequest.getEmail());
user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
Role role = roleRepository.findByName("ROLE_USER");
user.setRoles(Set.of(role));
userRepository.save(user);
return new ResponseEntity<>("User registered successfully", HttpStatus.OK);}
@PostMapping("/logout")
public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
logoutHandler.logout(request, response, authentication);
request.getSession().removeAttribute("SPRING_SECURITY_CONTEXT");
request.getSession().invalidate();
SecurityContextHolder.clearContext();
return new ResponseEntity<>("Logged out successfully", HttpStatus.OK);}}