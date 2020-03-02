package com.springBoot.uSpring;

import com.springBoot.uSpring.Models.AuthenticationRequest;
import com.springBoot.uSpring.Models.AuthenticationResponse;
import com.springBoot.uSpring.Util.JwtUtil;
import com.springBoot.uSpring.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class Resources {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    private List<User> users = usersList();

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public List<User> firstPage() {
        return users;
    }
    public  List<User> usersList(){
        User user_1  = new User();
        user_1.setPassword("1111");
        user_1.setUserName("1111");
        User user_2  = new User();
        user_2.setPassword("2222");
        user_2.setUserName("2222");
        users.add(user_1);
        users.add(user_2);
        return users;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = myUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }


}
