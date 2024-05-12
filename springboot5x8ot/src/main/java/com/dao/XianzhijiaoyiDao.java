package com.dao;

import com.entity.XianzhijiaoyiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XianzhijiaoyiVO;
import com.entity.view.XianzhijiaoyiView;


/**
 * 闲置交易
 * 
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
public interface XianzhijiaoyiDao extends BaseMapper<XianzhijiaoyiEntity> {
	
	List<XianzhijiaoyiVO> selectListVO(@Param("ew") Wrapper<XianzhijiaoyiEntity> wrapper);
	
	XianzhijiaoyiVO selectVO(@Param("ew") Wrapper<XianzhijiaoyiEntity> wrapper);
	
	List<XianzhijiaoyiView> selectListView(@Param("ew") Wrapper<XianzhijiaoyiEntity> wrapper);

	List<XianzhijiaoyiView> selectListView(Pagination page,@Param("ew") Wrapper<XianzhijiaoyiEntity> wrapper);
	
	XianzhijiaoyiView selectView(@Param("ew") Wrapper<XianzhijiaoyiEntity> wrapper);
	

}
