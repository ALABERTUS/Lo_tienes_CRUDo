package com.Lo_tienes_CRUDo.infrarepositories;

        import com.Lo_tienes_CRUDo.domain.models.Consulta;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository <Consulta, Long> {
}