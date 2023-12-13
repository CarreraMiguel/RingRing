package com.example.RingRing.models.dao;

import com.example.RingRing.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDao extends JpaRepository<Post, Integer> {
}
