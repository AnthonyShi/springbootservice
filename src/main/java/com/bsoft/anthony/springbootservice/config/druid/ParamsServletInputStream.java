package com.bsoft.anthony.springbootservice.config.druid;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * 创建日期 : 2019/10/24
 * 创建人 : 赵太行
 */
public class ParamsServletInputStream extends ServletInputStream {
    private ByteArrayInputStream bis;

    public ParamsServletInputStream(ByteArrayInputStream bis) {
        this.bis = bis;
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setReadListener(ReadListener readListener) {

    }

    @Override
    public int read() throws IOException {
        return bis.read();
    }

}
