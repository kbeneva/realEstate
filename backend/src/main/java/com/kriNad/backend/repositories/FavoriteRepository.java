package com.kriNad.backend.repositories;

import com.kriNad.backend.model.property.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
