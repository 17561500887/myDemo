package com.example.mybatisdemo.Controller;

import com.example.mybatisdemo.services.PoweronApiInEasyPoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PoweronApiInEasyPoiController {

    @Autowired
    PoweronApiInEasyPoiService poweronApiInEasyPoiService;

    /**
     * excel导入
     * @param file
     * @return
     */
    @PostMapping("/importExcel")
    public String importExcel(@RequestParam(value="filename") MultipartFile file){
        String str = poweronApiInEasyPoiService.imExcel(file);
        return str;
    }

    /**
     * excel导入（包含校验）
     * @param file
     * @return
     */
    @PostMapping("/importMoreExcel")
    public String importMoreExcel(@RequestParam(value="filename") MultipartFile file){
        String str = poweronApiInEasyPoiService.imMoreExcel(file);
        return str;
    }

}
