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


import com.dao.GoumaiwupinDao;
import com.entity.GoumaiwupinEntity;
import com.service.GoumaiwupinService;
import com.entity.vo.GoumaiwupinVO;
import com.entity.view.GoumaiwupinView;

@Service("goumaiwupinService")
public class GoumaiwupinServiceImpl extends ServiceImpl<GoumaiwupinDao, GoumaiwupinEntity> implements GoumaiwupinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoumaiwupinEntity> page = this.selectPage(
                new Query<GoumaiwupinEntity>(params).getPage(),
                new EntityWrapper<GoumaiwupinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GoumaiwupinEntity> wrapper) {
		  Page<GoumaiwupinView> page =new Query<GoumaiwupinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GoumaiwupinVO> selectListVO(Wrapper<GoumaiwupinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GoumaiwupinVO selectVO(Wrapper<GoumaiwupinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GoumaiwupinView> selectListView(Wrapper<GoumaiwupinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GoumaiwupinView selectView(Wrapper<GoumaiwupinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
