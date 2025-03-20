package com.kriNad.backend.repositories;

import com.kriNad.backend.model.personne.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepositories  extends JpaRepository<Admin, Long> {
}
