package com.example.mybatisdemo.Controller;

import com.example.mybatisdemo.domain.PoweronApiIn;
import com.example.mybatisdemo.errors.BadRequestAlertException;
import com.example.mybatisdemo.services.ExcelImportUtils;
import com.example.mybatisdemo.services.PoweronApiInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
public class PoweronApiInController {
    private static final String ENTITY_NAME = "poweronApiIn";
    @Autowired
    PoweronApiInService poweronApiInService;

    @GetMapping("/poweronapi/{id}")
    public PoweronApiIn selectPoweronApiIn(@PathVariable Long id){
        return poweronApiInService.selectByPrimaryKey(id);
    }

    @GetMapping("/poweronApiIn/{pageNum}/{pageSize}")
    public List<PoweronApiIn> selectAllPoweronApiIn(@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize){
        return poweronApiInService.selectAllPoweronApiIn(pageNum,pageSize);
    }

    /**
     * excel导入
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/poweronApiIn")
    public String importPoweronApiInout(@RequestParam(value="filename") MultipartFile file){
        boolean f = file.isEmpty();
        //判断文件是否为空
        if(file.isEmpty()){
            throw  new BadRequestAlertException("文件不能为空！","popweonApiIn","null");
        }

        //获取文件名
        String fileName= null;
        try {
            fileName = new String((file.getOriginalFilename()).getBytes(),"ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //验证文件名是否合格
        if(!ExcelImportUtils.validateExcel(fileName)){
            throw  new BadRequestAlertException("文件必须是excel格式！",ENTITY_NAME,"excel");
        }

        //进一步判断文件内容是否为空（即判断其大小是否为0或其名称是否为null）
        long size=file.getSize();
        if(StringUtils.isEmpty(fileName) || size==0){
            throw  new BadRequestAlertException("文件不能为空！",ENTITY_NAME,"null");
        }

        //批量导入

           String  message =  poweronApiInService.batchImport(fileName,file);

        return message;

    }
}
