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


import com.dao.HuzhufabuleixingDao;
import com.entity.HuzhufabuleixingEntity;
import com.service.HuzhufabuleixingService;
import com.entity.vo.HuzhufabuleixingVO;
import com.entity.view.HuzhufabuleixingView;

@Service("huzhufabuleixingService")
public class HuzhufabuleixingServiceImpl extends ServiceImpl<HuzhufabuleixingDao, HuzhufabuleixingEntity> implements HuzhufabuleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuzhufabuleixingEntity> page = this.selectPage(
                new Query<HuzhufabuleixingEntity>(params).getPage(),
                new EntityWrapper<HuzhufabuleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuzhufabuleixingEntity> wrapper) {
		  Page<HuzhufabuleixingView> page =new Query<HuzhufabuleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuzhufabuleixingVO> selectListVO(Wrapper<HuzhufabuleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuzhufabuleixingVO selectVO(Wrapper<HuzhufabuleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuzhufabuleixingView> selectListView(Wrapper<HuzhufabuleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuzhufabuleixingView selectView(Wrapper<HuzhufabuleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
