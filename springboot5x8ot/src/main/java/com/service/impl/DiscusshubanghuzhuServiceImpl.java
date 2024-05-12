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


import com.dao.DiscusshubanghuzhuDao;
import com.entity.DiscusshubanghuzhuEntity;
import com.service.DiscusshubanghuzhuService;
import com.entity.vo.DiscusshubanghuzhuVO;
import com.entity.view.DiscusshubanghuzhuView;

@Service("discusshubanghuzhuService")
public class DiscusshubanghuzhuServiceImpl extends ServiceImpl<DiscusshubanghuzhuDao, DiscusshubanghuzhuEntity> implements DiscusshubanghuzhuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusshubanghuzhuEntity> page = this.selectPage(
                new Query<DiscusshubanghuzhuEntity>(params).getPage(),
                new EntityWrapper<DiscusshubanghuzhuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusshubanghuzhuEntity> wrapper) {
		  Page<DiscusshubanghuzhuView> page =new Query<DiscusshubanghuzhuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusshubanghuzhuVO> selectListVO(Wrapper<DiscusshubanghuzhuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusshubanghuzhuVO selectVO(Wrapper<DiscusshubanghuzhuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusshubanghuzhuView> selectListView(Wrapper<DiscusshubanghuzhuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusshubanghuzhuView selectView(Wrapper<DiscusshubanghuzhuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
