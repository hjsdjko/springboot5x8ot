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

import com.entity.FaxianEntity;
import com.entity.view.FaxianView;

import com.service.FaxianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 发现
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
@RestController
@RequestMapping("/faxian")
public class FaxianController {
    @Autowired
    private FaxianService faxianService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FaxianEntity faxian,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			faxian.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FaxianEntity> ew = new EntityWrapper<FaxianEntity>();

		PageUtils page = faxianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, faxian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FaxianEntity faxian, 
		HttpServletRequest request){
        EntityWrapper<FaxianEntity> ew = new EntityWrapper<FaxianEntity>();

		PageUtils page = faxianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, faxian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FaxianEntity faxian){
       	EntityWrapper<FaxianEntity> ew = new EntityWrapper<FaxianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( faxian, "faxian")); 
        return R.ok().put("data", faxianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FaxianEntity faxian){
        EntityWrapper< FaxianEntity> ew = new EntityWrapper< FaxianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( faxian, "faxian")); 
		FaxianView faxianView =  faxianService.selectView(ew);
		return R.ok("查询发现成功").put("data", faxianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FaxianEntity faxian = faxianService.selectById(id);
		faxian.setClicknum(faxian.getClicknum()+1);
		faxian.setClicktime(new Date());
		faxianService.updateById(faxian);
        return R.ok().put("data", faxian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FaxianEntity faxian = faxianService.selectById(id);
		faxian.setClicknum(faxian.getClicknum()+1);
		faxian.setClicktime(new Date());
		faxianService.updateById(faxian);
        return R.ok().put("data", faxian);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        FaxianEntity faxian = faxianService.selectById(id);
        if(type.equals("1")) {
        	faxian.setThumbsupnum(faxian.getThumbsupnum()+1);
        } else {
        	faxian.setCrazilynum(faxian.getCrazilynum()+1);
        }
        faxianService.updateById(faxian);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FaxianEntity faxian, HttpServletRequest request){
    	faxian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(faxian);
        faxianService.insert(faxian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FaxianEntity faxian, HttpServletRequest request){
    	faxian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(faxian);
        faxianService.insert(faxian);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FaxianEntity faxian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(faxian);
        faxianService.updateById(faxian);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        faxianService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<FaxianEntity> wrapper = new EntityWrapper<FaxianEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = faxianService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,FaxianEntity faxian, HttpServletRequest request,String pre){
        EntityWrapper<FaxianEntity> ew = new EntityWrapper<FaxianEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = faxianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, faxian), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,FaxianEntity faxian, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "wenzhangfenlei";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "faxian").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<FaxianEntity> faxianList = new ArrayList<FaxianEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                faxianList.addAll(faxianService.selectList(new EntityWrapper<FaxianEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<FaxianEntity> ew = new EntityWrapper<FaxianEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = faxianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, faxian), params), params));
        List<FaxianEntity> pageList = (List<FaxianEntity>)page.getList();
        if(faxianList.size()<limit) {
            int toAddNum = (limit-faxianList.size())<=pageList.size()?(limit-faxianList.size()):pageList.size();
            for(FaxianEntity o1 : pageList) {
                boolean addFlag = true;
                for(FaxianEntity o2 : faxianList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    faxianList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(faxianList.size()>limit) {
            faxianList = faxianList.subList(0, limit);
        }
        page.setList(faxianList);
        return R.ok().put("data", page);
    }







}
