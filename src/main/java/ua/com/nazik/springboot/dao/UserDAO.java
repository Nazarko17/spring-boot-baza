package ua.com.nazik.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.nazik.springboot.models.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

}
