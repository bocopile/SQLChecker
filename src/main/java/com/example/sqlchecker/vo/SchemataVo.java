package com.example.sqlchecker.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "SCHEMATA")
public class SchemataVo {

    @Column(name = "SCHEMA_NAME")
    private String schemaName;
}
