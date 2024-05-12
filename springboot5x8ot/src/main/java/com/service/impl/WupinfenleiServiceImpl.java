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


import com.dao.WupinfenleiDao;
import com.entity.WupinfenleiEntity;
import com.service.WupinfenleiService;
import com.entity.vo.WupinfenleiVO;
import com.entity.view.WupinfenleiView;

@Service("wupinfenleiService")
public class WupinfenleiServiceImpl extends ServiceImpl<WupinfenleiDao, WupinfenleiEntity> implements WupinfenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WupinfenleiEntity> page = this.selectPage(
                new Query<WupinfenleiEntity>(params).getPage(),
                new EntityWrapper<WupinfenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WupinfenleiEntity> wrapper) {
		  Page<WupinfenleiView> page =new Query<WupinfenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WupinfenleiVO> selectListVO(Wrapper<WupinfenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WupinfenleiVO selectVO(Wrapper<WupinfenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WupinfenleiView> selectListView(Wrapper<WupinfenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WupinfenleiView selectView(Wrapper<WupinfenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
