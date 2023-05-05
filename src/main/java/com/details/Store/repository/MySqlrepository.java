package com.details.Store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.details.Store.model.userpersonaldetails;

public interface MySqlrepository extends JpaRepository <userpersonaldetails,Integer>{
    
}
