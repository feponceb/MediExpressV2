package com.mediexpress.usuarios.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mediexpress.usuarios.model.user;

@Repository
public interface userRepository extends JpaRepository<user, Long> {

}
