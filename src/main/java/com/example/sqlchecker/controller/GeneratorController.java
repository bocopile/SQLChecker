package com.example.sqlchecker.controller;

import com.example.sqlchecker.config.FileChecker;
import com.example.sqlchecker.config.FileGenerator;
import com.example.sqlchecker.repository.information.SchemataRepository;
import com.example.sqlchecker.vo.SchemataVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/generator")
@RequiredArgsConstructor
public class GeneratorController {

    @Autowired
    private final SchemataRepository schemataRepository;

    @Autowired
    private final FileChecker fileChecker;

    @Autowired
    private final FileGenerator fileGenerator;


    @PostMapping("/change")
    public ResponseEntity ChangeController(){

        boolean isFileExist = fileChecker.isFileExists();

        if(!isFileExist){
            throw new IllegalArgumentException("SQL File Not Exist");
        }

        List<SchemataVo> schemataVoList = schemataRepository.findAllExceptSystemSchemas();

        if (schemataVoList == null || schemataVoList.isEmpty()) {
            throw new IllegalArgumentException("Schema list is null or empty");
        } else{
            fileGenerator.createSchemaFiles(schemataVoList);
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
