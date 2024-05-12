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

import com.entity.GoumaiwupinEntity;
import com.entity.view.GoumaiwupinView;

import com.service.GoumaiwupinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 购买物品
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
@RestController
@RequestMapping("/goumaiwupin")
public class GoumaiwupinController {
    @Autowired
    private GoumaiwupinService goumaiwupinService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GoumaiwupinEntity goumaiwupin,
		HttpServletRequest request){
        EntityWrapper<GoumaiwupinEntity> ew = new EntityWrapper<GoumaiwupinEntity>();

        String tableName = request.getSession().getAttribute("tableName").toString();
        ew.andNew();
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.or();
            ew.eq("maijiazhanghao", (String)request.getSession().getAttribute("username"));
        }
		PageUtils page = goumaiwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, goumaiwupin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GoumaiwupinEntity goumaiwupin, 
		HttpServletRequest request){
        EntityWrapper<GoumaiwupinEntity> ew = new EntityWrapper<GoumaiwupinEntity>();

		PageUtils page = goumaiwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, goumaiwupin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GoumaiwupinEntity goumaiwupin){
       	EntityWrapper<GoumaiwupinEntity> ew = new EntityWrapper<GoumaiwupinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( goumaiwupin, "goumaiwupin")); 
        return R.ok().put("data", goumaiwupinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GoumaiwupinEntity goumaiwupin){
        EntityWrapper< GoumaiwupinEntity> ew = new EntityWrapper< GoumaiwupinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( goumaiwupin, "goumaiwupin")); 
		GoumaiwupinView goumaiwupinView =  goumaiwupinService.selectView(ew);
		return R.ok("查询购买物品成功").put("data", goumaiwupinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GoumaiwupinEntity goumaiwupin = goumaiwupinService.selectById(id);
        return R.ok().put("data", goumaiwupin);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GoumaiwupinEntity goumaiwupin = goumaiwupinService.selectById(id);
        return R.ok().put("data", goumaiwupin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GoumaiwupinEntity goumaiwupin, HttpServletRequest request){
    	goumaiwupin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(goumaiwupin);
        goumaiwupinService.insert(goumaiwupin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GoumaiwupinEntity goumaiwupin, HttpServletRequest request){
    	goumaiwupin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(goumaiwupin);
        goumaiwupinService.insert(goumaiwupin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GoumaiwupinEntity goumaiwupin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(goumaiwupin);
        goumaiwupinService.updateById(goumaiwupin);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        goumaiwupinService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GoumaiwupinEntity> wrapper = new EntityWrapper<GoumaiwupinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = goumaiwupinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
