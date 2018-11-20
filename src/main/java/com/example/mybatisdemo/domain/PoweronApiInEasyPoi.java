package com.example.mybatisdemo.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

public class PoweronApiInEasyPoi implements Serializable {



    @Excel(name = "key_value")
    @NotNull
    private String keyValue;

    @Excel(name = "class_attrib_id")
    @NotNull(message = "class_attrib_id字段不能为空")
    private String classAttribId;

    @Excel(name = "class_attrib_type")
    private String classAttribType;

    @Excel(name = "value_text")
    @Size(max = 20,message = "value_text最大不超过20" )
    private String valueText;

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public String getClassAttribId() {
        return classAttribId;
    }

    public void setClassAttribId(String classAttribId) {
        this.classAttribId = classAttribId;
    }

    public String getClassAttribType() {
        return classAttribType;
    }

    public void setClassAttribType(String classAttribType) {
        this.classAttribType = classAttribType;
    }

    public String getValueText() {
        return valueText;
    }

    public void setValueText(String valueText) {
        this.valueText = valueText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoweronApiInEasyPoi that = (PoweronApiInEasyPoi) o;
        return Objects.equals(keyValue, that.keyValue) &&
                Objects.equals(classAttribId, that.classAttribId) &&
                Objects.equals(classAttribType, that.classAttribType) &&
                Objects.equals(valueText, that.valueText);
    }

    @Override
    public int hashCode() {

        return Objects.hash(keyValue, classAttribId, classAttribType, valueText);
    }

    @Override
    public String toString() {
        return "PoweronApiInEasyPoi{" +
                "keyValue='" + keyValue + '\'' +
                ", classAttribId='" + classAttribId + '\'' +
                ", classAttribType='" + classAttribType + '\'' +
                ", valueText='" + valueText + '\'' +
                '}';
    }
}
