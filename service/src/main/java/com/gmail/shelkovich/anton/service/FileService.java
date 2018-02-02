package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.model.PieceOfNews;
import com.gmail.shelkovich.anton.repository.model.Product;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FileService extends AbstractService {

    private final static Logger logger = Logger.getLogger(FileService.class);

    @Value("${files.storagePath}")
    private String storagePath;

    public String save(MultipartFile multipartFile, String subPathString) {
        StringBuilder path = new StringBuilder(storagePath);
        StringBuilder subPath = new StringBuilder(subPathString);
        StringBuilder newFileName = new StringBuilder();
        StringBuilder URI = new StringBuilder();

        if (path.charAt(path.length() - 1) != '/') {
            path.append('/');
        }
        if (subPath.charAt(0) == '/') {
            subPath = subPath.deleteCharAt(0);
        }
        if (subPath.charAt(subPath.length() - 1) != '/') {
            subPath.append('/');
        }

        path.append(subPath);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/");
        Date date = new Date();
        path.append(dateFormat.format(date));
        URI.append(dateFormat.format(date));
        File dir = new File(path.toString());
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                logger.error("Could not create dir " + path);
                return null;
            }
        }

        String origFilename = multipartFile.getName();
        if (!multipartFile.getOriginalFilename().equals("")){
            origFilename = multipartFile.getOriginalFilename();
        }

        if (origFilename.contains(".")) {
            int lastDot = origFilename.lastIndexOf(".");
            newFileName.append(origFilename.substring(0, lastDot)).append("_").append(date.getTime()).append(origFilename.substring(lastDot, origFilename.length()));
        } else {
            newFileName.append(origFilename).append("_").append(date.getTime());
        }
        path.append(newFileName);
        URI.append(newFileName);
        File file = new File(path.toString());
        try (OutputStream saveFileStream = new BufferedOutputStream(new FileOutputStream(file))) {
            saveFileStream.write(multipartFile.getBytes());
            logger.info("file " + path + "saved successful");
        } catch (IOException e) {
            logger.error("Could not save file " + path, e);
            return null;
        }
        return URI.toString();
    }

    public File getByPath(String path) {
        StringBuilder localPath = new StringBuilder(storagePath);
        if (localPath.charAt(localPath.length() - 1) != '/') {
            localPath.append('/');
        }
        return new File(localPath + path);
    }

    public boolean deleteFile(String path){
        File file = getByPath(path);
        boolean result = file.delete();
        if(result){
            logger.info("file " + path+ " deleted successful");
        } else{
            logger.info("fail to delete file " + path);
        }

        return result;
    }

    @Transactional(readOnly = true)
    public boolean deleteFileByNewsId(Long id){
        PieceOfNews pieceOfNews = daoList.getNewsDao().getById(id);
        return deleteFile("news/"+pieceOfNews.getPhotoURI());
    }

    @Transactional(readOnly = true)
    public boolean deleteFileByProductId(Long id){
        Product product = daoList.getProductDao().getById(id);
        return deleteFile("products/"+product.getImageURI());
    }
}
