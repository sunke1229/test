/*
 *  Copyright (c) 2017.  Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.examples.demo.web.page;

import com.tencent.bk.api.login.model.BkUser;
import com.tencent.bk.core.BkConsts;
import com.tencent.bk.sdk.web.filter.util.FilterUtil;
import com.tencent.bk.utils.bean.BeanUtil;
import com.tencent.examples.dto.RespDto;
import com.tencent.examples.demo.model.User;
import com.tencent.examples.demo.service.UserService;
import com.tencent.examples.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * 演示如何处理一个带页面的
 */
@Controller
@RequestMapping("/")
public class IndexPageController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView index(ModelAndView view) {

        String lang = FilterUtil.getSessionAttribute(session, BkConsts.SYS_LANGUAGE, String.class);
        if (lang == null) {
            BkUser user = getUser();
            if (user == null) {
                request.setAttribute("message", "没有登录态！");
                view.setViewName("/error/401");
                return view;
            }

            User userDto = BeanUtil.map(user, User.class);//session中的
            RespDto<User> respDto = userService.findByUsername(user.getUsername());
            User data = respDto.getData();//数据库的
            if (data != null) {//更新
                userDto.setId(data.getId());
                userDto.setLang(data.getLang());
                userDto.setCreateTime(data.getCreateTime());
            }
            if (userDto.getLang() == null) {
                userDto.setLang("zh_CN");
            }
            userDto.setLastLoginTime(new Date());
            RespDto<User> saveRsp = userService.save(userDto);
            if (saveRsp.getData() == null) {
                request.setAttribute("message", "用户初始化错误！");
                view.setViewName("/error");
                return view;
            }
            lang = saveRsp.getData().getLang();
            session.setAttribute(BkConsts.SYS_LANGUAGE, lang);

        }

        view.setViewName("/index"); //首页
        return view;
    }

}
