package com.demo.RestApi.dao;

import com.demo.RestApi.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolDao extends JpaRepository<School,Integer> {
}
