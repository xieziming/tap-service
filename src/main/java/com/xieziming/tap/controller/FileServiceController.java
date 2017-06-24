/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


/**
 * Created by Suny on 5/31/17.
 */
@RestController
@RequestMapping("/file")
public class FileServiceController {

    @ApiOperation(value="Save a file", notes="Save a file via a POST/PUT request")
    @RequestMapping(value = {"", "/"}, method = {RequestMethod.PUT, RequestMethod.POST})
    public String save(@RequestParam("path") String path, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        File dir = new File("files"+File.separator+path);
        if(!dir.exists()) dir.mkdirs();
        File file = new File(dir.getAbsolutePath()+File.separator+multipartFile.getOriginalFilename());
        FileUtils.writeByteArrayToFile(file, multipartFile.getBytes());

        return file.getAbsolutePath();
    }

    @ApiOperation(value="Find a file", notes="Find a file via a GET request")
    @RequestMapping(value = "/**", method = RequestMethod.GET)
    public byte[] find(HttpServletRequest request) throws Exception {
        return FileUtils.readFileToByteArray(new File(getRealFilePath(request.getServletPath())));
    }

    @ApiOperation(value="Delete a file", notes="Delete a file via a GET request")
    @RequestMapping(value = "/**", method = RequestMethod.DELETE)
    public void delete(HttpServletRequest request) throws Exception {
        FileUtils.forceDeleteOnExit(new File(getRealFilePath(request.getServletPath())));
    }

    private String getRealFilePath(String path) throws Exception {
        return path.replaceFirst("/file", "files");
    }
}
