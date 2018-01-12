package com.github.joy.security.admin.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.joy.security.admin.biz.ElementBiz;
import com.github.joy.security.admin.biz.UserBiz;
import com.github.joy.security.admin.common.controller.BaseController;
import com.github.joy.security.admin.common.msg.ObjectRestResponse;
import com.github.joy.security.admin.common.msg.TableResultResponse;
import com.github.joy.security.admin.entity.Element;

import tk.mybatis.mapper.entity.Example;

@Controller
@RequestMapping("/element")
public class ElementController extends BaseController<ElementBiz, Element>
{
    @Autowired
    private UserBiz userBiz;
    
    @GetMapping(value = "list")
    @ResponseBody
    public TableResultResponse<Element> page(@RequestParam(defaultValue = "10") int limit,
        @RequestParam(defaultValue = "1") int offset, String name, @RequestParam(defaultValue = "0") int menuId)
    {
        Example example = new Example(Element.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("menuId", menuId);
        if (StringUtils.isNotBlank(name))
        {
            criteria.andLike("name", "%" + name + "%");
        }
        List<Element> elements = baseBiz.selectByExample(example);
        return new TableResultResponse<>(elements.size(), elements);
    }
    
    @GetMapping(value="/user/menu")
    @ResponseBody
    public ObjectRestResponse<List<Element>> getAuthorityElement(){
        int userId = userBiz.getUserByUsername(getCurrentUser()).getId();
        List<Element> elements = baseBiz.getAuthorityElementByUserId(userId);
        return new ObjectRestResponse<List<Element>>().data(elements);
    }
}
