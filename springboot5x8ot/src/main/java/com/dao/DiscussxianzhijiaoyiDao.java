package com.dao;

import com.entity.DiscussxianzhijiaoyiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussxianzhijiaoyiVO;
import com.entity.view.DiscussxianzhijiaoyiView;


/**
 * 闲置交易评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
public interface DiscussxianzhijiaoyiDao extends BaseMapper<DiscussxianzhijiaoyiEntity> {
	
	List<DiscussxianzhijiaoyiVO> selectListVO(@Param("ew") Wrapper<DiscussxianzhijiaoyiEntity> wrapper);
	
	DiscussxianzhijiaoyiVO selectVO(@Param("ew") Wrapper<DiscussxianzhijiaoyiEntity> wrapper);
	
	List<DiscussxianzhijiaoyiView> selectListView(@Param("ew") Wrapper<DiscussxianzhijiaoyiEntity> wrapper);

	List<DiscussxianzhijiaoyiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxianzhijiaoyiEntity> wrapper);
	
	DiscussxianzhijiaoyiView selectView(@Param("ew") Wrapper<DiscussxianzhijiaoyiEntity> wrapper);
	

}
