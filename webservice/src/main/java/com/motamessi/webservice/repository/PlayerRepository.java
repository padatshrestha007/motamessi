package com.motamessi.webservice.repository;

import com.motamessi.webservice.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    // CRUD
}
