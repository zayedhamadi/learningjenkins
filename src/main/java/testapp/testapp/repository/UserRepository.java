package testapp.testapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import testapp.testapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {}