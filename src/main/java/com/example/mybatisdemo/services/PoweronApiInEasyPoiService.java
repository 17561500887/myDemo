package com.example.mybatisdemo.services;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.example.mybatisdemo.Dao.PoweronApiInEasyPoiMapper;
import com.example.mybatisdemo.domain.PoweronApiInEasyPoi;
import com.example.mybatisdemo.errors.BadRequestAlertException;
import com.example.mybatisdemo.errors.InternalServerErrorException;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileOutputStream;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class PoweronApiInEasyPoiService {

    @Autowired
    PoweronApiInEasyPoiMapper poweronApiInEasyPoiMapper ;

    /**
     * excel导入
     * @param file
     * @return
     */
    public String imExcel(MultipartFile file){
        List<PoweronApiInEasyPoi> list = importExcel(file,0,1,PoweronApiInEasyPoi.class);

        list.stream().forEach(poweronApiInEasyPoi -> {
            poweronApiInEasyPoi.setClassAttribType("C");
            poweronApiInEasyPoiMapper.insert(poweronApiInEasyPoi);
        });

        return "导入成功，共" + list.size() + "条数据！" ;
    }

    public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass){
        if (file == null){
            throw new BadRequestAlertException("请上传文件","","");
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
        }catch (NoSuchElementException e){
            throw new BadRequestAlertException("excel文件不能为空","","");
        } catch (Exception e) {
            throw new BadRequestAlertException(e.getMessage(),"","");
        }
        return list;
    }


    /**
     * excel导入（包含校验）
     * @param file
     * @return
     */
    public String imMoreExcel(MultipartFile file){
        List<PoweronApiInEasyPoi> list = importMoreExcel(file,0,1,PoweronApiInEasyPoi.class);
        if (list.size()>0){
            return "导入成功，共" + list.size() + "条数据！" ;
        }
        return "导入失败！";
    }


    public static <T> List<T> importMoreExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass){
        if (file == null){
            throw new BadRequestAlertException("请上传文件","","");
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        params.setNeedVerfiy(true);
        List<T> list = null;
        try {
            ExcelImportResult<T> result = ExcelImportUtil.importExcelMore(file.getInputStream(), pojoClass, params);
            if (result.isVerfiyFail()){
                FileOutputStream fos = new FileOutputStream("D:/excel/baseModetest.xlsx");
                result.getFailWorkbook().write(fos);
                fos.close();
                throw new InternalServerErrorException ("导入失败！请检查文件内容");
            }
            list = result.getList();
            for (int i = 0; i < result.getList().size(); i++) {
                System.out.println(ReflectionToStringBuilder.toString(result.getList().get(i)));
            }
        } catch (NoSuchElementException e){
            throw new BadRequestAlertException("excel文件不能为空","","");
        }catch (Exception e) {
            throw new BadRequestAlertException(e.getMessage(),"","");
        }
        return list;
    }
}
