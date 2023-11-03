package com.jay.mybatis.spring.boot.bean;

import java.io.Serializable;

/**
 * desc.
 *
 * @author zhongshuo.xwj
 */
public class Fortype implements Serializable {

    private Long id;

    private String detail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
