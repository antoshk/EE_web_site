package com.gmail.shelkovich.anton.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FileService {

    private final static Logger logger = Logger.getLogger(FileService.class);

    @Value("${files.storagePath}")
    private String storagePath;

    public String save(MultipartFile multipartFile){
        StringBuilder path = new StringBuilder(storagePath);
        StringBuilder newFileName = new StringBuilder();
        if(path.charAt(path.length()-1) != '/'){
            path.append('/');
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/");
        Date date = new Date();
        path.append(dateFormat.format(date));
        File dir = new File(path.toString());
        if(!dir.exists()){
            if(!dir.mkdir()){
                logger.error("Could not create dir "+path);
                return null;
            }
        }

        String origFilename = multipartFile.getName();
        if(origFilename.contains(".")){
            int lastDot = origFilename.lastIndexOf(".");
            newFileName.append(origFilename.substring(0, lastDot)).append("_").append(date.getTime()).append(origFilename.substring(lastDot, origFilename.length()));
        } else {
            newFileName.append(origFilename).append("_").append(date.getTime());
        }
        path.append(newFileName);
        File file = new File(path.toString());
        try(OutputStream saveFileStream = new BufferedOutputStream(new FileOutputStream(file))){
            saveFileStream.write(multipartFile.getBytes());
            logger.info("file " + path + "saved successful");
        } catch (IOException e) {
            logger.error("Could not save file " + path, e);
            return null;
        }
        return path.toString();
    }

    public File getByPath(String path){
        return new File(storagePath+path);
    }
}
