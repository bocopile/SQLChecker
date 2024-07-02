package com.example.sqlchecker.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Component
public class FileChecker {

    @Value("${path.input_sql}")
    String InputSqlPath;

    public boolean isFileExists() {
        // Path 객체 생성
        Path path = Paths.get(InputSqlPath);

        // 파일 존재 여부 확인
        return Files.exists(path);
    }
}