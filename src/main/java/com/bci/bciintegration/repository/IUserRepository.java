package com.bci.bciintegration.repository;

import com.bci.bciintegration.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<User,Long> {
    Boolean existsByEmail(String email);
}
