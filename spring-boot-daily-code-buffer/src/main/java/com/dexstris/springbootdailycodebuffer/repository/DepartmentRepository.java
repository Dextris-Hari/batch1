package com.dexstris.springbootdailycodebuffer.repository;

import com.dexstris.springbootdailycodebuffer.entity.DepartmentEntity;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    public DepartmentEntity getByDepartmentAdressIgnoreCase(String name);


}
