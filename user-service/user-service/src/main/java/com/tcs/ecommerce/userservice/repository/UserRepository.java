package com.tcs.ecommerce.userservice.repository;

import com.tcs.ecommerce.userservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long>
{
}
