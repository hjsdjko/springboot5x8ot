package com.dao;

import com.entity.ShudongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShudongVO;
import com.entity.view.ShudongView;


/**
 * 树洞
 * 
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
public interface ShudongDao extends BaseMapper<ShudongEntity> {
	
	List<ShudongVO> selectListVO(@Param("ew") Wrapper<ShudongEntity> wrapper);
	
	ShudongVO selectVO(@Param("ew") Wrapper<ShudongEntity> wrapper);
	
	List<ShudongView> selectListView(@Param("ew") Wrapper<ShudongEntity> wrapper);

	List<ShudongView> selectListView(Pagination page,@Param("ew") Wrapper<ShudongEntity> wrapper);
	
	ShudongView selectView(@Param("ew") Wrapper<ShudongEntity> wrapper);
	

}
