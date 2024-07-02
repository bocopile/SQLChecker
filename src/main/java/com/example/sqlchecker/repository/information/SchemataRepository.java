package com.example.sqlchecker.repository.information;

import com.example.sqlchecker.vo.SchemataVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchemataRepository extends JpaRepository<SchemataVo, String> {


    @Query("SELECT s FROM SCHEMATA s WHERE s.schemaName NOT IN ('information_schema', 'mysql', 'sys', 'performance_schema')")
    List<SchemataVo> findAllExceptSystemSchemas();
}
