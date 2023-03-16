package com.LayShare.LayShare.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long>
{
Users findByUsername(String username); // arka ğlanda spring data bu metoda karşılık gelebilecek bir query üretip onunla database işlerini haledecek
}
