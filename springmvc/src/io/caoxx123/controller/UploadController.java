package io.caoxx123.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.xwork.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.caoxx123.pojo.UploadedImageFile;

@Controller
public class UploadController {
    @RequestMapping("/uploadImage")
    public ModelAndView upload(HttpServletRequest request, UploadedImageFile file)
            throws IllegalStateException, IOException {
        String name = RandomStringUtils.randomAlphanumeric(10);
        String newFileName = name + ".jpg";
        System.out.println(request.getServletContext().getRealPath("/image"));
        File newFile = new File(request.getServletContext().getRealPath("/image"), newFileName);
        newFile.getParentFile().mkdirs();
        file.getImage().transferTo(newFile);
        ModelAndView mav = new ModelAndView("showUploadedFile");
        mav.addObject("imageName", newFileName);
        return mav;
    }
}
