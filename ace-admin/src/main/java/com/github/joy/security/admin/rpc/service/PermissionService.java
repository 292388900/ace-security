/*
 * 文 件 名:  PermissionService.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月6日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.admin.rpc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.joy.security.admin.biz.ElementBiz;
import com.github.joy.security.admin.biz.MenuBiz;
import com.github.joy.security.admin.biz.UserBiz;
import com.github.joy.security.admin.common.util.TreeUtil;
import com.github.joy.security.admin.constant.AdminCommonConstant;
import com.github.joy.security.admin.entity.Element;
import com.github.joy.security.admin.entity.Menu;
import com.github.joy.security.admin.entity.User;
import com.github.joy.security.admin.vo.FrontUser;
import com.github.joy.security.admin.vo.MenuTree;
import com.github.joy.security.api.vo.authority.PermissionInfo;
import com.github.joy.security.api.vo.user.UserInfo;
import com.github.joy.security.auth.client.jwt.UserAuthUtil;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author 姓名 工号
 * @version [版本号, 2018年1月6日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
public class PermissionService
{
    @Autowired
    private UserBiz userBiz;
    
    @Autowired
    private MenuBiz menuBiz;
    
    @Autowired
    private ElementBiz elementBiz;
    
    @Autowired
    private UserAuthUtil userAuthUtil;
    
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    
    public UserInfo validate(String username, String password)
    {
        UserInfo userInfo = new UserInfo();
        User user = userBiz.getUserByUsername(username);
        if (encoder.matches(password, user.getPassword()))
        {
            BeanUtils.copyProperties(user, userInfo);
            userInfo.setId(user.getId().toString());
        }
        return userInfo;
    }
    
    public FrontUser getUserInfo(String token)
        throws Exception
    {
        String username = userAuthUtil.getInfoFromToken(token).getUniqueName();
        if (username == null)
        {
            return null;
        }
        UserInfo userInfo = this.getUserByUsername(username);
        FrontUser frontUser = new FrontUser();
        BeanUtils.copyProperties(userInfo, frontUser);
        List<PermissionInfo> permissionInfos = this.getPermissionByUsername(username);
        Stream<PermissionInfo> menus = permissionInfos.parallelStream().filter((permission) -> {
            return permission.getType().equals(AdminCommonConstant.RESOURCE_TYPE.MENU);
        });
        frontUser.setMenus(menus.collect(Collectors.toList()));
        Stream<PermissionInfo> elements = permissionInfos.parallelStream().filter((permission) -> {
            return !permission.getType().equals(AdminCommonConstant.RESOURCE_TYPE.MENU);
        });
        frontUser.setElements(elements.collect(Collectors.toList()));
        return frontUser;
    }
    
    public UserInfo getUserByUsername(String username)
    {
        UserInfo userInfo = new UserInfo();
        User user = userBiz.getUserByUsername(username);
        BeanUtils.copyProperties(user, userInfo);
        userInfo.setId(user.getId().toString());
        return userInfo;
    }
    
    public List<PermissionInfo> getPermissionByUsername(String username)
    {
        User user = userBiz.getUserByUsername(username);
        List<Menu> menus = menuBiz.getUserAuthorityMenuByUserId(user.getId());
        List<PermissionInfo> result = new ArrayList<>();
        menu2permission(menus, result);
        List<Element> elements = elementBiz.getAuthorityElementByUserId(user.getId());
        element2permission(elements, result);
        return result;
    }
    
    private void menu2permission(List<Menu> menus, List<PermissionInfo> result)
    {
        PermissionInfo info;
        for (Menu menu : menus)
        {
            if (StringUtils.isBlank(menu.getHref()))
            {
                menu.setHref("/" + menu.getCode());
            }
            info = new PermissionInfo();
            info.setCode(menu.getCode());
            info.setType(AdminCommonConstant.RESOURCE_TYPE.MENU);
            info.setName(AdminCommonConstant.RESOURCE_ACTION_VISIT);
            String uri = menu.getHref();
            if (!uri.startsWith("/"))
            {
                uri = "/" + uri;
            }
            info.setUri(uri);
            info.setMethod(AdminCommonConstant.RESOURCE_REQUEST_METHOD.GET);
            info.setMenu(menu.getTitle());
            result.add(info);
        }
    }
    
    private void element2permission(List<Element> elements, List<PermissionInfo> result)
    {
        PermissionInfo info;
        for (Element element : elements)
        {
            info = new PermissionInfo();
            BeanUtils.copyProperties(element, info);
            info.setMenu(element.getMenuId());
            result.add(info);
        }
    }
    
    public List<MenuTree> getMenusByUsername(String token) throws Exception{
        String username = userAuthUtil.getInfoFromToken(token).getUniqueName();
        if(username == null){
            return null;
        }
        User user = userBiz.getUserByUsername(username);
        List<Menu> menus = menuBiz.getUserAuthorityMenuByUserId(user.getId());
        return getMenuTree(menus, AdminCommonConstant.ROOT);
    }
    
    private List<MenuTree> getMenuTree(List<Menu> menus, int root){
        List<MenuTree> trees = new ArrayList<MenuTree>();
        MenuTree node = null;
        for(Menu menu : menus){
            node = new MenuTree();
            BeanUtils.copyProperties(menu, node);
            trees.add(node);
        }
        return TreeUtil.build(trees, root);
    }
    
    public List<PermissionInfo> getAllPermission(){
        List<Menu> menus = menuBiz.selectListAll();
        List<PermissionInfo> result = new ArrayList<PermissionInfo>();
        menu2permission(menus, result);
        List<Element> elements = elementBiz.selectListAll();
        element2permission(elements, result);
        return result;
    }
}
