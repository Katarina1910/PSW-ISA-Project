package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.UserDTO;
import com.softwareComedians.ClinicalCenterApp.exception.ApiRequestException;
import com.softwareComedians.ClinicalCenterApp.model.User;
import com.softwareComedians.ClinicalCenterApp.model.UserTokenState;
import com.softwareComedians.ClinicalCenterApp.security.TokenUtils;
import com.softwareComedians.ClinicalCenterApp.security.auth.JwtAuthenticationRequest;
import com.softwareComedians.ClinicalCenterApp.service.UserService;
import com.softwareComedians.ClinicalCenterApp.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody JwtAuthenticationRequest authenticationRequest,
                                         HttpServletResponse response) throws AuthenticationException, IOException {

        return new ResponseEntity<>(userDetailsService.login(authenticationRequest), HttpStatus.OK);
    }

    @PostMapping("/change-password")
    public ResponseEntity changePassword(@RequestBody PasswordChanger passwordChanger) {
        userDetailsService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword, passwordChanger.email);

        Map<String, String> result = new HashMap<>();
        result.put("result", "success");
        return ResponseEntity.accepted().body(result);
    }

    static class PasswordChanger {
        public String oldPassword;
        public String newPassword;
        public String email;
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    public ResponseEntity<?> refreshAuthenticationToken(HttpServletRequest request) {

        String token = tokenUtils.getToken(request);
        String username = this.tokenUtils.getMailFromToken(token);
        User user = (User) this.userDetailsService.loadUserByUsername(username);

        if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = tokenUtils.refreshToken(token);
            int expiresIn = tokenUtils.getExpiredIn();

            return ResponseEntity.ok(new UserTokenState(refreshedToken, expiresIn));
        } else {
            UserTokenState userTokenState = new UserTokenState();
            return ResponseEntity.badRequest().body(userTokenState);
        }
    }
}
