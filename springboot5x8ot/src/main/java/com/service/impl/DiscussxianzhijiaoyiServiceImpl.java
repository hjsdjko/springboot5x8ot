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


import com.dao.DiscussxianzhijiaoyiDao;
import com.entity.DiscussxianzhijiaoyiEntity;
import com.service.DiscussxianzhijiaoyiService;
import com.entity.vo.DiscussxianzhijiaoyiVO;
import com.entity.view.DiscussxianzhijiaoyiView;

@Service("discussxianzhijiaoyiService")
public class DiscussxianzhijiaoyiServiceImpl extends ServiceImpl<DiscussxianzhijiaoyiDao, DiscussxianzhijiaoyiEntity> implements DiscussxianzhijiaoyiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxianzhijiaoyiEntity> page = this.selectPage(
                new Query<DiscussxianzhijiaoyiEntity>(params).getPage(),
                new EntityWrapper<DiscussxianzhijiaoyiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxianzhijiaoyiEntity> wrapper) {
		  Page<DiscussxianzhijiaoyiView> page =new Query<DiscussxianzhijiaoyiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussxianzhijiaoyiVO> selectListVO(Wrapper<DiscussxianzhijiaoyiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussxianzhijiaoyiVO selectVO(Wrapper<DiscussxianzhijiaoyiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussxianzhijiaoyiView> selectListView(Wrapper<DiscussxianzhijiaoyiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxianzhijiaoyiView selectView(Wrapper<DiscussxianzhijiaoyiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
