package br.com.pedro.crud_mybatis.service;

import br.com.pedro.crud_mybatis.mapper.UserMapper;
import br.com.pedro.crud_mybatis.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;

    public User findById(Long id){
        return userMapper.findById(id);

    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public void insert(User user){
        userMapper.insert(user);
    }

    public void update(User user){
        userMapper.update(user);
    }

    public void delete(Long id){
        userMapper.delete(id);
    }
}
