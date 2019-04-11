/*
 *  Copyright (c) 2017 . Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.examples.web.support;

import com.tencent.bk.utils.bean.BeanUtil;
import com.tencent.examples.dto.RespDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 重新封装一些异常的如404的请求的返回内容，避免/error WhiteLabel Error Page 这种不友好的页面
 */
@Controller
public class ErrorPageController implements ErrorController {

    private static Logger LOG = LoggerFactory.getLogger(ErrorPageController.class);

    @Value("${error.path:/err}")
    private String errorPath;

    private ErrorAttributes errorAttributes = new DefaultErrorAttributes();

    @RequestMapping(value = "${error.path:/error}")
    public Object handle(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> attributes = getErrorAttributes(request);
        LOG.error("ErrorRequest: " + attributes);
        attributes.put("code", attributes.get("status"));
        attributes.put("message", attributes.get("error"));

        if (response.getStatus() == 404) {
            request.setAttribute("message", attributes.get("message"));
            ModelAndView mv = new ModelAndView();
            mv.setViewName("/error/404");
            return mv;
        } else if (response.getStatus() == 500) {
            request.setAttribute("message", attributes.get("message"));
            ModelAndView mv = new ModelAndView();
            mv.setViewName("/error/500");
            return mv;
        }
        return BeanUtil.map(attributes, RespDto.class);
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return this.errorAttributes.getErrorAttributes(requestAttributes, false);
    }

    @Override
    public String getErrorPath() {
        return this.errorPath;
    }
}
