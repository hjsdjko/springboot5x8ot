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


import com.dao.DiscussfaxianDao;
import com.entity.DiscussfaxianEntity;
import com.service.DiscussfaxianService;
import com.entity.vo.DiscussfaxianVO;
import com.entity.view.DiscussfaxianView;

@Service("discussfaxianService")
public class DiscussfaxianServiceImpl extends ServiceImpl<DiscussfaxianDao, DiscussfaxianEntity> implements DiscussfaxianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussfaxianEntity> page = this.selectPage(
                new Query<DiscussfaxianEntity>(params).getPage(),
                new EntityWrapper<DiscussfaxianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussfaxianEntity> wrapper) {
		  Page<DiscussfaxianView> page =new Query<DiscussfaxianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussfaxianVO> selectListVO(Wrapper<DiscussfaxianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussfaxianVO selectVO(Wrapper<DiscussfaxianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussfaxianView> selectListView(Wrapper<DiscussfaxianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussfaxianView selectView(Wrapper<DiscussfaxianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
