package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ShudongEntity;
import com.entity.view.ShudongView;

import com.service.ShudongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 树洞
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
@RestController
@RequestMapping("/shudong")
public class ShudongController {
    @Autowired
    private ShudongService shudongService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShudongEntity shudong,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		shudong.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<ShudongEntity> ew = new EntityWrapper<ShudongEntity>();

		PageUtils page = shudongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shudong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShudongEntity shudong, 
		HttpServletRequest request){
        EntityWrapper<ShudongEntity> ew = new EntityWrapper<ShudongEntity>();

		PageUtils page = shudongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shudong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShudongEntity shudong){
       	EntityWrapper<ShudongEntity> ew = new EntityWrapper<ShudongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shudong, "shudong")); 
        return R.ok().put("data", shudongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShudongEntity shudong){
        EntityWrapper< ShudongEntity> ew = new EntityWrapper< ShudongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shudong, "shudong")); 
		ShudongView shudongView =  shudongService.selectView(ew);
		return R.ok("查询树洞成功").put("data", shudongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShudongEntity shudong = shudongService.selectById(id);
        return R.ok().put("data", shudong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShudongEntity shudong = shudongService.selectById(id);
        return R.ok().put("data", shudong);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        ShudongEntity shudong = shudongService.selectById(id);
        if(type.equals("1")) {
        	shudong.setThumbsupnum(shudong.getThumbsupnum()+1);
        } else {
        	shudong.setCrazilynum(shudong.getCrazilynum()+1);
        }
        shudongService.updateById(shudong);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShudongEntity shudong, HttpServletRequest request){
    	shudong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shudong);
    	shudong.setUserid((Long)request.getSession().getAttribute("userId"));
        shudongService.insert(shudong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShudongEntity shudong, HttpServletRequest request){
    	shudong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shudong);
        shudongService.insert(shudong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShudongEntity shudong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shudong);
        shudongService.updateById(shudong);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shudongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ShudongEntity> wrapper = new EntityWrapper<ShudongEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}
		if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		wrapper.eq("userid", (Long)request.getSession().getAttribute("userId"));
    	}


		int count = shudongService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
