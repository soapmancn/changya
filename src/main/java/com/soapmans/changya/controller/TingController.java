package com.soapmans.changya.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class TingController {

    @RequestMapping("/ting")
    public void ting(HttpServletResponse response) {
        File file = new File("src/main/resources/hei.txt");
        try {
            BufferedInputStream reader = null;
            FileInputStream inputStream = null;
            ServletOutputStream outw = response.getOutputStream();
            try {
                inputStream = new FileInputStream(file);
                FileInputStream inp = new FileInputStream(file);
                int i;
                byte[] buffer = new byte[1024];
                while ((i = inp.read(buffer)) != -1) {
                    outw.write(buffer, 0, i);
                }
                inp.close();
                outw.flush();
            } finally {
                if (reader != null) {
                    reader.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (IOException e) {
        }
    }

    @RequestMapping("/lwedting")
    public void lwedting(HttpServletResponse response) {
        File file = new File("src/main/resources/ting.txt");
        try {
            BufferedInputStream reader = null;
            FileInputStream inputStream = null;
            response.setHeader("Content-type", "textml;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            ServletOutputStream outw = response.getOutputStream();
            try {
                inputStream = new FileInputStream(file);
                FileInputStream inp = new FileInputStream(file);
                int i;
                byte[] buffer = new byte[1024];
                while ((i = inp.read(buffer)) != -1) {
                    outw.write(buffer, 0, i);
                }
                inp.close();
                outw.flush();
            } finally {
                if (reader != null) {
                    reader.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (IOException e) {
        }
    }

}
