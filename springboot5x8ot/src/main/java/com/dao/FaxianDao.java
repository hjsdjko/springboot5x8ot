package com.dao;

import com.entity.FaxianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FaxianVO;
import com.entity.view.FaxianView;


/**
 * 发现
 * 
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
public interface FaxianDao extends BaseMapper<FaxianEntity> {
	
	List<FaxianVO> selectListVO(@Param("ew") Wrapper<FaxianEntity> wrapper);
	
	FaxianVO selectVO(@Param("ew") Wrapper<FaxianEntity> wrapper);
	
	List<FaxianView> selectListView(@Param("ew") Wrapper<FaxianEntity> wrapper);

	List<FaxianView> selectListView(Pagination page,@Param("ew") Wrapper<FaxianEntity> wrapper);
	
	FaxianView selectView(@Param("ew") Wrapper<FaxianEntity> wrapper);
	

}
