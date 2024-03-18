package com.example.riichi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.riichi.model.AddressModel;
 
 
@Repository
public interface AddressRepository extends JpaRepository<AddressModel, Long> {
}