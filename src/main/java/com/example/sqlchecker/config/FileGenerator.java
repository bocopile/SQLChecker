package com.example.sqlchecker.config;

import com.example.sqlchecker.vo.SchemataVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Component
public class FileGenerator {

    @Value("${path.output_sql}")
    String OutputSqlPath;

    public void createSchemaFiles(List<SchemataVo> schemaNames) {
        schemaNames.forEach(schema -> {
            try {
                // SQL 파일 경로
                Path sqlFilePath = Paths.get(OutputSqlPath, "template.sql");
                String content = new String(Files.readAllBytes(sqlFilePath));

                // 파일 내용의 패턴을 스키마 이름으로 대체
                String replacedContent = content.replaceAll("@projectId_@randomString", schema.getSchemaName());

                // 새 파일 경로 생성
                Path newFilePath = Paths.get(OutputSqlPath, schema.getSchemaName() + ".sql");

                // 새로운 파일에 내용 쓰기
                Files.write(newFilePath, replacedContent.getBytes());

                System.out.println("File created: " + newFilePath.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
