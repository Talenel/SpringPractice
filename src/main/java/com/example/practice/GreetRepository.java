package com.example.practice;

import org.springframework.data.repository.CrudRepository;

public interface GreetRepository extends CrudRepository<Greeting, Long> {
}
