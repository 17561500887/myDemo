package com.example.mybatisdemo.domain;

public class PoweronApiIn {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String keyValue;

    private String classAttribId;

    private String classAttribType;

    private String valueText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue == null ? null : keyValue.trim();
    }

    public String getClassAttribId() {
        return classAttribId;
    }

    public void setClassAttribId(String classAttribId) {
        this.classAttribId = classAttribId == null ? null : classAttribId.trim();
    }

    public String getClassAttribType() {
        return classAttribType;
    }

    public void setClassAttribType(String classAttribType) {
        this.classAttribType = classAttribType == null ? null : classAttribType.trim();
    }

    public String getValueText() {
        return valueText;
    }

    public void setValueText(String valueText) {
        this.valueText = valueText == null ? null : valueText.trim();
    }
}