package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.FaxianDao;
import com.entity.FaxianEntity;
import com.service.FaxianService;
import com.entity.vo.FaxianVO;
import com.entity.view.FaxianView;

@Service("faxianService")
public class FaxianServiceImpl extends ServiceImpl<FaxianDao, FaxianEntity> implements FaxianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FaxianEntity> page = this.selectPage(
                new Query<FaxianEntity>(params).getPage(),
                new EntityWrapper<FaxianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FaxianEntity> wrapper) {
		  Page<FaxianView> page =new Query<FaxianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FaxianVO> selectListVO(Wrapper<FaxianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FaxianVO selectVO(Wrapper<FaxianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FaxianView> selectListView(Wrapper<FaxianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FaxianView selectView(Wrapper<FaxianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
