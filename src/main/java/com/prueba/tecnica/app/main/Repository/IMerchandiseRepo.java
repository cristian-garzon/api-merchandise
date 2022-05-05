package com.prueba.tecnica.app.main.Repository;

import com.prueba.tecnica.app.main.Model.Merchandise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMerchandiseRepo extends JpaRepository<Merchandise, Long> {
}
