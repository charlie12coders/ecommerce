package com.charlie.server.repository;

import com.charlie.server.models.UsersDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UsersDto,Integer> {
    UsersDto findByEmail(String email);
}
