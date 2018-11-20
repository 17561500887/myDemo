package com.example.mybatisdemo.domain;


import java.io.Serializable;
import java.time.LocalDate;

import java.util.List;
import java.util.Objects;


/**
 * POWERON_API_INOUT
 */

public class PoweronApiInout implements Serializable {


    /**
     * POWERON 关键值
     */

    private String key_value;

    /**
     * 编码库名
     */

    private String catalog_id;

    /**
     * 元件类型名
     */

    private String component_type_id;

    /**
     * 尺寸格式名
     */

    private String size_format_id;

    /**
     * part no
     */

    private Integer part_no;

    /**
     * ID 码
     */

    private String part_id;

    /**
     * ID 码描述 1
     */

    private String part_descr1;

    /**
     * ID 码尺寸 1
     */

    private String size_descr1;

    /**
     * ID 码描述 2
     */

    private String part_descr2;

    /**
     * ID 码尺寸 2
     */

    private String size_descr2;

    /**
     * 单位
     */

    private String unit_id;

    /**
     * 状态
     */

    private String stat;


    private LocalDate in_date;


    private LocalDate out_date;

    /**
     * 申请人
     */

    private String applicant;

    /**
     * 申请时间
     */

    private String apply_time;


    private String applicant_name;

    private List<PoweronApiIn> poweronApiIns;

    public String getKey_value() {
        return key_value;
    }

    public void setKey_value(String key_value) {
        this.key_value = key_value;
    }

    public String getCatalog_id() {
        return catalog_id;
    }

    public void setCatalog_id(String catalog_id) {
        this.catalog_id = catalog_id;
    }

    public String getComponent_type_id() {
        return component_type_id;
    }

    public void setComponent_type_id(String component_type_id) {
        this.component_type_id = component_type_id;
    }

    public String getSize_format_id() {
        return size_format_id;
    }

    public void setSize_format_id(String size_format_id) {
        this.size_format_id = size_format_id;
    }

    public Integer getPart_no() {
        return part_no;
    }

    public void setPart_no(Integer part_no) {
        this.part_no = part_no;
    }

    public String getPart_id() {
        return part_id;
    }

    public void setPart_id(String part_id) {
        this.part_id = part_id;
    }

    public String getPart_descr1() {
        return part_descr1;
    }

    public void setPart_descr1(String part_descr1) {
        this.part_descr1 = part_descr1;
    }

    public String getSize_descr1() {
        return size_descr1;
    }

    public void setSize_descr1(String size_descr1) {
        this.size_descr1 = size_descr1;
    }

    public String getPart_descr2() {
        return part_descr2;
    }

    public void setPart_descr2(String part_descr2) {
        this.part_descr2 = part_descr2;
    }

    public String getSize_descr2() {
        return size_descr2;
    }

    public void setSize_descr2(String size_descr2) {
        this.size_descr2 = size_descr2;
    }

    public String getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(String unit_id) {
        this.unit_id = unit_id;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public LocalDate getIn_date() {
        return in_date;
    }

    public void setIn_date(LocalDate in_date) {
        this.in_date = in_date;
    }

    public LocalDate getOut_date() {
        return out_date;
    }

    public void setOut_date(LocalDate out_date) {
        this.out_date = out_date;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApply_time() {
        return apply_time;
    }

    public void setApply_time(String apply_time) {
        this.apply_time = apply_time;
    }

    public String getApplicant_name() {
        return applicant_name;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name;
    }

    public List<PoweronApiIn> getPoweronApiIns() {
        return poweronApiIns;
    }

    public void setPoweronApiIns(List<PoweronApiIn> poweronApiIns) {
        this.poweronApiIns = poweronApiIns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoweronApiInout that = (PoweronApiInout) o;
        return Objects.equals(key_value, that.key_value) &&
                Objects.equals(catalog_id, that.catalog_id) &&
                Objects.equals(component_type_id, that.component_type_id) &&
                Objects.equals(size_format_id, that.size_format_id) &&
                Objects.equals(part_no, that.part_no) &&
                Objects.equals(part_id, that.part_id) &&
                Objects.equals(part_descr1, that.part_descr1) &&
                Objects.equals(size_descr1, that.size_descr1) &&
                Objects.equals(part_descr2, that.part_descr2) &&
                Objects.equals(size_descr2, that.size_descr2) &&
                Objects.equals(unit_id, that.unit_id) &&
                Objects.equals(stat, that.stat) &&
                Objects.equals(in_date, that.in_date) &&
                Objects.equals(out_date, that.out_date) &&
                Objects.equals(applicant, that.applicant) &&
                Objects.equals(apply_time, that.apply_time) &&
                Objects.equals(applicant_name, that.applicant_name) &&
                Objects.equals(poweronApiIns, that.poweronApiIns);
    }

    @Override
    public int hashCode() {

        return Objects.hash(key_value, catalog_id, component_type_id, size_format_id, part_no, part_id, part_descr1, size_descr1, part_descr2, size_descr2, unit_id, stat, in_date, out_date, applicant, apply_time, applicant_name, poweronApiIns);
    }

    @Override
    public String toString() {
        return "PoweronApiInout{" +
                "key_value='" + key_value + '\'' +
                ", catalog_id='" + catalog_id + '\'' +
                ", component_type_id='" + component_type_id + '\'' +
                ", size_format_id='" + size_format_id + '\'' +
                ", part_no=" + part_no +
                ", part_id='" + part_id + '\'' +
                ", part_descr1='" + part_descr1 + '\'' +
                ", size_descr1='" + size_descr1 + '\'' +
                ", part_descr2='" + part_descr2 + '\'' +
                ", size_descr2='" + size_descr2 + '\'' +
                ", unit_id='" + unit_id + '\'' +
                ", stat='" + stat + '\'' +
                ", in_date=" + in_date +
                ", out_date=" + out_date +
                ", applicant='" + applicant + '\'' +
                ", apply_time='" + apply_time + '\'' +
                ", applicant_name='" + applicant_name + '\'' +
                ", poweronApiIns=" + poweronApiIns +
                '}';
    }
}
