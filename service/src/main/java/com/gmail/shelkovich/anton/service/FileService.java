package com.gmail.shelkovich.anton.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileService {
    String save(MultipartFile multipartFile, String subPathString);

    File getByPath(String path);

    boolean deleteFile(String path);

    @Transactional(readOnly = true)
    boolean deleteFileByNewsId(Long id);

    @Transactional(readOnly = true)
    boolean deleteFileByProductId(Long id);
}
