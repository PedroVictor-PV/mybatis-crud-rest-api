package br.com.pedro.crud_mybatis.mapper;

import br.com.pedro.crud_mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User findById(Long id);

    //@Select("SELECT * FROM user")
    List<User>findAll();


    //@Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    //@Update("UPDATE user SET nome = #{nome}, email = #{email} WHERE id=#{id}")
    void update(User user);

    //@Delete("Delete FROM user WHERE id = #{id}")
    void delete(Long id);
}
