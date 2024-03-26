package com.example.ex_repository.Controller;


import com.example.ex_repository.API.ApiResponse;
import com.example.ex_repository.Model.User;
import com.example.ex_repository.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService ;


    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(userService.getAll());
    }



    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added"));

    }



    @PutMapping("/update/{Id}")
    public ResponseEntity updateUser(@PathVariable Integer Id , @RequestBody @Valid User user , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        userService.updateUser(Id , user);

        return ResponseEntity.status(200).body(new ApiResponse("user updated"));
    }



    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteUser(@PathVariable Integer Id ){

        userService.deleteUser(Id);

        return ResponseEntity.status(200).body(new ApiResponse("User deleted"));
    }



    @GetMapping("/findNP/{username}/{password}")
    public ResponseEntity findByUsernameAndPassword(@PathVariable String username , @PathVariable String password){

        return ResponseEntity.status(200).body(userService.findByUsernameAndPassword(username , password));
    }


    @GetMapping("/getE/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email){

        return ResponseEntity.status(200).body(userService.getEmail(email));
    }


    @GetMapping("/getRole/{role}")
    public ResponseEntity getUserByRole(@PathVariable String role){

        return ResponseEntity.status(200).body(userService.getRole(role));
    }



    @GetMapping("/getAge/{age}")
    public ResponseEntity getUserByAge(@PathVariable Integer age){

        return ResponseEntity.status(200).body(userService.getAge(age));
    }


}
