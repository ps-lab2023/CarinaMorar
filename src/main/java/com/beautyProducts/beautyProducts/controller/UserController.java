package com.beautyProducts.beautyProducts.controller;

import com.beautyProducts.beautyProducts.DTO.OrdersDTO;
import com.beautyProducts.beautyProducts.DTO.UserDTO;
import com.beautyProducts.beautyProducts.model.Orders;
import com.beautyProducts.beautyProducts.model.User;
import com.beautyProducts.beautyProducts.repository.UserRepository;
import com.beautyProducts.beautyProducts.service.ServiceImplementation.EmailServiceImplementation;
import com.beautyProducts.beautyProducts.service.UserService;
import jakarta.mail.MessagingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmailServiceImplementation emailSenderService;
    @GetMapping("/findAll")
    public List<UserDTO> findAllUsers(){
        List<User> user1 = userService.findAllUsers();
        List<UserDTO> userDTO = user1.stream().map(user ->
                modelMapper.map(user,UserDTO.class)).collect(Collectors.toList());
        return userDTO;
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity findUserById(@PathVariable Long id){
        Optional<User> user = userService.findUserById(id);
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }

    @GetMapping("/findByUsername/{username}")
    public ResponseEntity findUserByName(@PathVariable String username){
        List<User> users = userService.findUserByUsername(username);
        List<UserDTO> userDTO = users.stream().map(user ->
                modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }

    @DeleteMapping("/delete")
    public UserDTO deleteUser(@RequestBody User user){
        User user1 = userService.deleteUser(user);
        UserDTO userDTO = modelMapper.map(user1, UserDTO.class);

        return userDTO;
    }

    @DeleteMapping("/deleteById/{id}")
    public UserDTO deleteUserById(@PathVariable Long id){
        Optional<User> user = userService.findUserById(userService.deleteUserById(id));
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        return userDTO;
    }

    @PutMapping("/updateUsername/{username}")
    public UserDTO updateUsername(@RequestBody User user, @PathVariable String username){
        User user1 = userService.updateUserName(user, username);
        UserDTO userDTO = modelMapper.map(user1, UserDTO.class);
        return userDTO;
    }

    @PutMapping("/create")
    public UserDTO register(@RequestParam String username,@RequestParam String email,@RequestParam String password,
                            @RequestParam String firstName,@RequestParam String lastName) throws MessagingException {
        User u=new User();
        u.setUsername(username);
        u.setEmail(email);
        u.setPassword(password);
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setIsAdmin(false);
        u.setLogged(false);
            User user1 = userService.createUser(u);
            UserDTO userDTO = modelMapper.map(user1, UserDTO.class);

        emailSenderService.sendMailWithAttachment(userDTO.getEmail(),
                "Dear User,\n" +
                        "\n" +
                        "Thank you for signing up for our beauty product store! We are thrilled to have you as part of our community and look forward to providing you with the best beauty products and services.\n" +
                        "\n" +
                        "As a token of appreciation, please use the following coupon code to enjoy 20% off on your next purchase. You can redeem this coupon at checkout to receive the discount.\n" +
                        "\n" +
                        "If you have any questions or need assistance, please do not hesitate to contact us. Our team is always ready to help and guide you through your beauty journey.\n" +
                        "\n" +
                        "Thank you again for joining us, and we hope to see you soon!\n" +
                        "\n" +
                        "Best regards,\n" +
                        "\n" +
                        "Carina\n" +
                        "\n" +
                        "Beauty Products Store",
                "Beauty Products Store Team", "" +
                        "D:\\fac\\PS\\beautyProducts\\src\\main\\resources\\Cupon.txt");

            return userDTO;
    }

    @PostMapping("/login")
    public ResponseEntity logIn(@RequestBody UserDTO userDTO){

        User user1 = userService.logIn(userDTO.getEmail(), userDTO.getPassword());
        UserDTO userDTO1 = modelMapper.map(user1, UserDTO.class);
        return ResponseEntity.status(HttpStatus.OK).body(userDTO1);
    }

    @GetMapping("/findUser") //login used
    public UserDTO findUser(@RequestParam String email,
                                  @RequestParam String password){
        User u=userService.findByEmailAndPassword(email,password);
        u.setLogged(true);
        userRepository.save(u);
     return modelMapper.map(u,UserDTO.class);
    }

    @PostMapping("/logout")
    public ResponseEntity logOut(@RequestBody UserDTO userDTO){

        userService.logOut(userDTO.getEmail());
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
