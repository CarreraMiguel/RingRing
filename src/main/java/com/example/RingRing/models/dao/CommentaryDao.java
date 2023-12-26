package com.example.RingRing.models.dao;

import com.example.RingRing.models.Commentary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaryDao extends JpaRepository<Commentary, Integer> {
}
