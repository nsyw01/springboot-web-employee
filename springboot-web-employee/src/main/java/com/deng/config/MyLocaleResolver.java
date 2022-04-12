package com.deng.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author DengTao
 */
public class MyLocaleResolver implements LocaleResolver {

    /**
     * 国际化
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //解析请求
        String language = request.getParameter("l");

        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(language)){
            String[] split = language.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }


    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
