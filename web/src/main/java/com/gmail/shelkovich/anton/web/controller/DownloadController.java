package com.gmail.shelkovich.anton.web.controller;

import com.gmail.shelkovich.anton.service.FileService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.charset.Charset;

@Controller
public class DownloadController {
    private static final Logger logger = Logger.getLogger(DownloadController.class);

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/download/**", method = RequestMethod.GET)
    public void download(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String matchPattern = req.getContextPath() + "/download/**";
        AntPathMatcher apm = new AntPathMatcher();
        String filePath = apm.extractPathWithinPattern(matchPattern, req.getRequestURI());

        File file = fileService.getByPath(filePath);

        if (!file.exists()) {
            String errorMessage = "Sorry, the file you are looking for does not exist";
            logger.info(errorMessage + ": " + file.getAbsolutePath());
            OutputStream outputStream = resp.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }

        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            logger.info("Mime type is not detectinle, will use default");
            mimeType = "application/octet-stream";
        }

        logger.info("Mime type: " + mimeType);
        resp.setContentType(mimeType);
        resp.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
        try (InputStream fileInputStream = new BufferedInputStream(new FileInputStream(file))) {
            FileCopyUtils.copy(fileInputStream, resp.getOutputStream());
        }
    }

}
