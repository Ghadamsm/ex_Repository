package com.example.ex_repository.Service;


import com.example.ex_repository.API.ApiException;
import com.example.ex_repository.Model.User;
import com.example.ex_repository.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository ;


    public List<User> getAll(){
        return userRepository.findAll();
    }


    public void addUser(User user){
        userRepository.save(user);
    }


    public void updateUser(Integer Id , User user){

        User u = userRepository.findUserByID(Id);

        if (u == null){
            throw new ApiException("Invalid Id");
        }

        u.setName(user.getName());
        u.setAge(user.getAge());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setRole(user.getRole());
        u.setUsername(user.getUsername());

        userRepository.save(u);

    }



    public void deleteUser(Integer Id){

        User u = userRepository.findUserByID(Id);

        if (u == null){
            throw new ApiException("Invalid Id");
        }

        userRepository.delete(u);

    }




    public User findByUsernameAndPassword(String username , String password){

        User u = userRepository.findUserByUsernameAndPassword(username , password);

        if (u == null){
            throw new ApiException("Invalid username or password");
        }

        return u ;
    }



    public List<User> getEmail(String email){
      List<User> u = userRepository.findUserByEmail(email);

      if (u == null){
          throw new ApiException("Invalid email");
      }

      return u ;
    }




    public List<User> getRole(String role){
        List<User> u = userRepository.allUserWithRole(role);

        if (u == null){
            throw new ApiException("Invalid role");
        }

        return u ;
    }



    public List<User> getAge(Integer age){
        List<User> u = userRepository.allUserWithAge(age);

        if (u == null){
            throw new ApiException("Invalid age");
        }

        return u ;
    }


}
