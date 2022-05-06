package com.prueba.tecnica.app.main.Repository;

import com.prueba.tecnica.app.main.Model.Merchandise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;

public interface IMerchandiseRepo extends JpaRepository<Merchandise, Long> {
    @Query(value = "select mer from Merchandise mer " +
            "where (:idMerchandise is null or mer.idMerchandise = :idMerchandise) " +
            "and (:idEmployee is null or mer.employee.idEmployee = :idEmployee)" +
            "and (:nameEmployee is null or mer.employee.name like concat('%', :nameEmployee, '%') )" +
            "and (:nameMerchandise is null or mer.productName like concat('%', :nameMerchandise, '%') )")
    public List<Merchandise> filterMerchandise(@Nullable @Param("idEmployee") Long idEmployee, @Nullable @Param("idMerchandise")
                                               Long idMerchandise, @Nullable @Param("nameEmployee") String nameEmployee
                                               , @Nullable @Param("nameMerchandise") String nameMerchandise);
}
