package com.example.project.controller;

import com.example.project.controller.request.LoginRequest;
import com.example.project.controller.request.RegisterRequest;
import com.example.project.entity.User;
import com.example.project.security.jwt.JwtTokenUtil;
import com.example.project.service.AuthService;
import com.example.project.service.JwtUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@ResponseBody
@CrossOrigin()
public class AuthController {

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private final AuthService authService;
    @Autowired
    private final JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(AuthService authService, JwtUserDetailsService jwtUserDetailsService) {
        this.authService = authService;
        this.jwtUserDetailsService = jwtUserDetailsService;
    }


    @CrossOrigin(origins = "*")
    @RequestMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        logger.debug("RegistrationForm: " + request.toString());

        HashMap<String, Object> map = new HashMap<>();
            User user = authService.register(request);

            if (user == null) {
                map.put("message", "注册失败，已有该用户！");
                map.put("status", 201);
                return ResponseEntity.ok(map);
            }

            map.put("token", jwtTokenUtil.generateToken(user));
            map.put("user", user);
            map.put("status", 200);

        return ResponseEntity.ok(map);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpServletResponse response) {
        logger.debug("LoginForm: " + request.toString());
        HashMap<String, Object> map = new HashMap<>();

        User user = jwtUserDetailsService.loadUserByUsername(request.getUsername());
        if (user == null) {
            map.put("status",404);
            map.put("message", "用户不存在");
            return ResponseEntity.ok(map);
        } else if (!authService.passwordMach(request.getPassword(), user.getPassword())) {
            map.put("status",201);
            map.put("message", "密码错误");
            return ResponseEntity.ok(map);
        }
        UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword(),
                user.getAuthorities());
        final Authentication authentication = authenticationManager.authenticate(userToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        map.put("token", jwtTokenUtil.generateToken(user));
        map.put("message", "success");
        map.put("user", user);

        return ResponseEntity.ok(map);

    }


    @GetMapping("/welcome")
    public ResponseEntity<?> welcome() {
        Map<String, Object> response = new HashMap<>();
        String message = "Welcome to 哈哈哈";
        response.put("message", message);
        return ResponseEntity.ok(response);
    }

}
