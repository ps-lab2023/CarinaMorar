package com.beautyProducts.beautyProducts.repository;

import com.beautyProducts.beautyProducts.model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Long> {

    List<Admin> findAdminByAdminName(String name);

}
