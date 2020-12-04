package com.bsoft.anthony.springbootservice.config.druid;

import com.alibaba.fastjson.JSON;
import com.bsoft.anthony.springbootservice.utils.TextUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 创建日期 : 2019/10/24
 * 创建人 : 赵太行
 */
public class ParamsRequestWrapper extends HttpServletRequestWrapper {
    private Map<String, String[]> params = new HashMap<>();
    private static final String ENCODING = "UTF-8";
    private static final String CLASSTYPE = "java.lang.String";
    public ParamsRequestWrapper(HttpServletRequest request) {
        super(request);
        Map<String, String[]> requestMap = request.getParameterMap();
        this.params.putAll(requestMap);
        this.modifyParameters();
    }
    @Override
    public ServletInputStream getInputStream() throws IOException {

        ServletInputStream stream = super.getInputStream();

        //非json类型，直接返回
        if (!MediaType.APPLICATION_JSON_VALUE.equalsIgnoreCase(super.getHeader(HttpHeaders.CONTENT_TYPE))) {
            return stream;
        }
        String json = IOUtils.toString(stream, ENCODING);

        if (TextUtils.isBlank(json)) {
            return stream;
        }

       System.out.println("转化前参数：" + json);
        Map<String, Object> map = modifyParams(json);
       System.out.println("转化后参数：" + JSON.toJSONString(map));
        String jgid= (String) map.get("organizationId");
        if (!TextUtils.isEmpty(jgid)){
            Pattern pattern = Pattern.compile("^-?[0-9]+");
            Matcher isNum = pattern.matcher(jgid);
            if (!isNum.matches()){
                return stream;
            }
        }
        ByteArrayInputStream bis = new ByteArrayInputStream(JSON.toJSONString(map).getBytes(ENCODING));

        return new ParamsServletInputStream(bis);
    }
    /**
     * 将parameter的值去除空格后重写回去
     */
    private void modifyParameters() {
        Set<String> set = params.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            String[] values = params.get(key);
            values[0] = values[0].trim();
            params.put(key, values);
        }
    }
    private static Map<String, Object> modifyParams(String json) {

        Map<String, Object> params = JSON.parseObject(json);
        Map<String, Object> maps = new HashMap<>(params.size());
        for (String key : params.keySet()) {
            Object value = getValue(params.get(key));
            maps.put(key, value);
        }
        return maps;
    }
    private static Object getValue(Object obj) {

        if (obj == null) {
            return null;
        }
        String type = obj.getClass().getName();
        // 对字符串的处理
        if (CLASSTYPE.equals(type)) {
            obj =TextUtils.filtration(obj.toString().trim());

        }
        return obj;
    }
    /**
     * 重写getParameter 参数从当前类中的map获取
     */
    @Override
    public String getParameter(String name) {
        String[] values = params.get(name);
        if (values == null || values.length == 0) {
            return null;
        }
        return values[0];
    }
}
