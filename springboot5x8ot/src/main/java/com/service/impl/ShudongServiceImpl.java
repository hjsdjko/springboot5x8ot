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


import com.dao.ShudongDao;
import com.entity.ShudongEntity;
import com.service.ShudongService;
import com.entity.vo.ShudongVO;
import com.entity.view.ShudongView;

@Service("shudongService")
public class ShudongServiceImpl extends ServiceImpl<ShudongDao, ShudongEntity> implements ShudongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShudongEntity> page = this.selectPage(
                new Query<ShudongEntity>(params).getPage(),
                new EntityWrapper<ShudongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShudongEntity> wrapper) {
		  Page<ShudongView> page =new Query<ShudongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShudongVO> selectListVO(Wrapper<ShudongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShudongVO selectVO(Wrapper<ShudongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShudongView> selectListView(Wrapper<ShudongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShudongView selectView(Wrapper<ShudongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
