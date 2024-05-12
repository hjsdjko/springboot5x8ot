package com.dao;

import com.entity.DiscusshubanghuzhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusshubanghuzhuVO;
import com.entity.view.DiscusshubanghuzhuView;


/**
 * 互帮互助评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
public interface DiscusshubanghuzhuDao extends BaseMapper<DiscusshubanghuzhuEntity> {
	
	List<DiscusshubanghuzhuVO> selectListVO(@Param("ew") Wrapper<DiscusshubanghuzhuEntity> wrapper);
	
	DiscusshubanghuzhuVO selectVO(@Param("ew") Wrapper<DiscusshubanghuzhuEntity> wrapper);
	
	List<DiscusshubanghuzhuView> selectListView(@Param("ew") Wrapper<DiscusshubanghuzhuEntity> wrapper);

	List<DiscusshubanghuzhuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusshubanghuzhuEntity> wrapper);
	
	DiscusshubanghuzhuView selectView(@Param("ew") Wrapper<DiscusshubanghuzhuEntity> wrapper);
	

}
