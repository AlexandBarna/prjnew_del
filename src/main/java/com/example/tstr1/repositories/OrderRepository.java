package com.example.tstr1.repositories;

import com.example.tstr1.models.Order;
import com.example.tstr1.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByPerson(Person person);
}
