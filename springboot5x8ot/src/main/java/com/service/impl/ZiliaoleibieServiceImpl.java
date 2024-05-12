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


import com.dao.ZiliaoleibieDao;
import com.entity.ZiliaoleibieEntity;
import com.service.ZiliaoleibieService;
import com.entity.vo.ZiliaoleibieVO;
import com.entity.view.ZiliaoleibieView;

@Service("ziliaoleibieService")
public class ZiliaoleibieServiceImpl extends ServiceImpl<ZiliaoleibieDao, ZiliaoleibieEntity> implements ZiliaoleibieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZiliaoleibieEntity> page = this.selectPage(
                new Query<ZiliaoleibieEntity>(params).getPage(),
                new EntityWrapper<ZiliaoleibieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZiliaoleibieEntity> wrapper) {
		  Page<ZiliaoleibieView> page =new Query<ZiliaoleibieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZiliaoleibieVO> selectListVO(Wrapper<ZiliaoleibieEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZiliaoleibieVO selectVO(Wrapper<ZiliaoleibieEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZiliaoleibieView> selectListView(Wrapper<ZiliaoleibieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZiliaoleibieView selectView(Wrapper<ZiliaoleibieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
