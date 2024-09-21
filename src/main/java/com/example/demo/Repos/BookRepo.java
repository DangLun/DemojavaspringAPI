package com.example.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Books;

@Repository
public interface BookRepo extends JpaRepository<Books, Integer> {
}
