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


import com.dao.HubanghuzhuDao;
import com.entity.HubanghuzhuEntity;
import com.service.HubanghuzhuService;
import com.entity.vo.HubanghuzhuVO;
import com.entity.view.HubanghuzhuView;

@Service("hubanghuzhuService")
public class HubanghuzhuServiceImpl extends ServiceImpl<HubanghuzhuDao, HubanghuzhuEntity> implements HubanghuzhuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HubanghuzhuEntity> page = this.selectPage(
                new Query<HubanghuzhuEntity>(params).getPage(),
                new EntityWrapper<HubanghuzhuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HubanghuzhuEntity> wrapper) {
		  Page<HubanghuzhuView> page =new Query<HubanghuzhuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HubanghuzhuVO> selectListVO(Wrapper<HubanghuzhuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HubanghuzhuVO selectVO(Wrapper<HubanghuzhuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HubanghuzhuView> selectListView(Wrapper<HubanghuzhuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HubanghuzhuView selectView(Wrapper<HubanghuzhuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
