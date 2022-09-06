package Service;

import Model.User;
import Repository.UserRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    private UserRepository userRepository;

    public UserService(){
        this.userRepository = new UserRepository();

    }

    public User findUserByEmailAndPass(String email, String pass){
        for(User user:this.userRepository.getUsers()){
            if(user.getEmail().equals(email) && user.getPassword().equals(pass))
                return user;
        }
        return null;
    }

    public void createUser(User user){
        this.userRepository.getUsers().add(user);
        this.userRepository.saveUsers();

    }

    public void deleteUser(User user){
        this.userRepository.getUsers().remove(user);
        this.userRepository.saveUsers();
    }

}
