package com.example.RingRing.models.dao;

import com.example.RingRing.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
