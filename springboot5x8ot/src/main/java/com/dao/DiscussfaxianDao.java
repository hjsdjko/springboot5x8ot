package com.dao;

import com.entity.DiscussfaxianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussfaxianVO;
import com.entity.view.DiscussfaxianView;


/**
 * 发现评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
public interface DiscussfaxianDao extends BaseMapper<DiscussfaxianEntity> {
	
	List<DiscussfaxianVO> selectListVO(@Param("ew") Wrapper<DiscussfaxianEntity> wrapper);
	
	DiscussfaxianVO selectVO(@Param("ew") Wrapper<DiscussfaxianEntity> wrapper);
	
	List<DiscussfaxianView> selectListView(@Param("ew") Wrapper<DiscussfaxianEntity> wrapper);

	List<DiscussfaxianView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussfaxianEntity> wrapper);
	
	DiscussfaxianView selectView(@Param("ew") Wrapper<DiscussfaxianEntity> wrapper);
	

}
