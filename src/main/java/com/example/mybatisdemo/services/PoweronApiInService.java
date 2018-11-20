package com.example.mybatisdemo.services;

import com.example.mybatisdemo.Dao.PoweronApiInMapper;
import com.example.mybatisdemo.domain.PoweronApiIn;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PoweronApiInService {

    @Autowired
    PoweronApiInMapper poweronApiInMapper;

    public PoweronApiIn selectByPrimaryKey(Long id){
        PoweronApiIn poweronApiIn = poweronApiInMapper.selectByPrimaryKey(id);
        return poweronApiIn;
    }

    public List<PoweronApiIn> selectAllPoweronApiIn(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<PoweronApiIn> poweronApiIns = poweronApiInMapper.selectAllPoweron();
        PageInfo pageInfo = new PageInfo(poweronApiIns) ;
        return poweronApiIns;
    }

    /**
     * excel导入
     * @param fileName
     * @param mfile
     * @return
     */
    public String batchImport(String fileName, MultipartFile mfile){


       /* File uploadDir = new  File("E:\\fileupload");
        //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
        if (!uploadDir.exists()) uploadDir.mkdirs();
        //新建一个文件
        File tempFile = new File("E:\\fileupload\\" + new Date().getTime() + ".xlsx");*/
        //初始化输入流
        InputStream is = null;
        try{
       /*     //将上传的文件写入新建的文件中
            mfile.transferTo(tempFile);*/

            //根据新建的文件实例化输入流
            is = mfile.getInputStream();

            //根据版本选择创建Workbook的方式
            Workbook wb = null;
            //根据文件名判断文件是2003版本还是2007版本
            if(ExcelImportUtils.isExcel2007(fileName)){
                wb = new XSSFWorkbook(is);
            }else{
                wb = new HSSFWorkbook(is);
            }
            //根据excel里面的内容读取知识库信息
            return readExcelValue(wb);
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            if(is !=null)
            {
                try{
                    is.close();
                }catch(IOException e){
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return "导入出错！请检查数据格式！";
    }


    private String readExcelValue(Workbook wb) {

        //错误信息接收器
        String errorMsg = "";
        //得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        //得到Excel的行数
        int totalRows = sheet.getPhysicalNumberOfRows();
        //总列数
        int totalCells = 0;
        //得到Excel的列数(前提是有行数)，从第二行算起
        if (totalRows >= 2 && sheet.getRow(1) != null) {
            totalCells = sheet.getRow(1).getPhysicalNumberOfCells();
        }
        List<PoweronApiIn> poweronApiInList = new ArrayList<PoweronApiIn>();
        PoweronApiIn poweronApiIn;

        String br = "<br/>";

        //循环Excel行数,从第二行开始。标题不入库
        for (int r = 1; r < totalRows; r++) {
            String rowMessage = "";
            Row row = sheet.getRow(r);
            if (row == null) {
                errorMsg += br + "第" + (r + 1) + "行数据有问题，请仔细检查！";
                continue;
            }
            poweronApiIn = new PoweronApiIn();

            String keyValue = "";
            String classAttribId = "";
            String valueText = "";

            //循环Excel的列
            for (int c = 0; c < totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {
                    if (c == 0) {
                        keyValue = cell.getStringCellValue();
                        String  keyValue1 = cell.getStringCellValue().trim();
                        if (StringUtils.isEmpty(keyValue1)) {
                            rowMessage += "临时码不能为空；";
                        }
                        poweronApiIn.setKeyValue(keyValue);
                    } else if (c == 1) {
                        classAttribId = cell.getStringCellValue();
                        String classAttribId1 = cell.getStringCellValue().trim();
                        if (StringUtils.isEmpty(classAttribId1)) {
                            rowMessage += "属性名不能为空；";
                        }
                        poweronApiIn.setClassAttribId(classAttribId);
                    }else if(c == 2){
                        valueText = cell.getStringCellValue();
                        String valueText1 = cell.getStringCellValue().trim();
                        if (StringUtils.isEmpty(valueText1)){
                            rowMessage += "属性值不能为空；";
                        }
                        poweronApiIn.setValueText(valueText);
                    }
                } else {
                    rowMessage += "第" + (c + 1) + "列数据有问题，请仔细检查；";
                }
                poweronApiIn.setClassAttribType("C");
            }
            //拼接每行的错误提示
            if (!StringUtils.isEmpty(rowMessage)) {
                errorMsg += br + "第" + (r + 1) + "行，" + rowMessage;
            } else {
                poweronApiInList.add(poweronApiIn);
            }
        }

 /*       //删除上传的临时文件
        if (tempFile.exists()) {
            tempFile.delete();
        }*/

        //全部验证通过才导入到数据库
        if (StringUtils.isEmpty(errorMsg)) {
            for (PoweronApiIn poweronApiIns : poweronApiInList) {
                poweronApiInMapper.insert(poweronApiIns);
            }
            errorMsg = "导入成功，共" + poweronApiInList.size() + "条数据！";
        }
        return errorMsg;
    }
}