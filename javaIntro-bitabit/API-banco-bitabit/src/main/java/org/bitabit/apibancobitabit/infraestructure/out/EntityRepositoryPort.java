package org.bitabit.apibancobitabit.infraestructure.out;




import org.bitabit.apibancobitabit.domain.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntityRepositoryPort extends JpaRepository <Empleado, Integer>{
    @Autowired
    JpaRepository <Empleado, Integer> getJpaRepository();
}
