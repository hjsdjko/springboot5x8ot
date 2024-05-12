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


import com.dao.XianzhijiaoyiDao;
import com.entity.XianzhijiaoyiEntity;
import com.service.XianzhijiaoyiService;
import com.entity.vo.XianzhijiaoyiVO;
import com.entity.view.XianzhijiaoyiView;

@Service("xianzhijiaoyiService")
public class XianzhijiaoyiServiceImpl extends ServiceImpl<XianzhijiaoyiDao, XianzhijiaoyiEntity> implements XianzhijiaoyiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XianzhijiaoyiEntity> page = this.selectPage(
                new Query<XianzhijiaoyiEntity>(params).getPage(),
                new EntityWrapper<XianzhijiaoyiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XianzhijiaoyiEntity> wrapper) {
		  Page<XianzhijiaoyiView> page =new Query<XianzhijiaoyiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XianzhijiaoyiVO> selectListVO(Wrapper<XianzhijiaoyiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XianzhijiaoyiVO selectVO(Wrapper<XianzhijiaoyiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XianzhijiaoyiView> selectListView(Wrapper<XianzhijiaoyiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XianzhijiaoyiView selectView(Wrapper<XianzhijiaoyiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
