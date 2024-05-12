package com.dao;

import com.entity.HuzhufabuleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuzhufabuleixingVO;
import com.entity.view.HuzhufabuleixingView;


/**
 * 互助发布类型
 * 
 * @author 
 * @email 
 * @date 2023-04-10 19:07:53
 */
public interface HuzhufabuleixingDao extends BaseMapper<HuzhufabuleixingEntity> {
	
	List<HuzhufabuleixingVO> selectListVO(@Param("ew") Wrapper<HuzhufabuleixingEntity> wrapper);
	
	HuzhufabuleixingVO selectVO(@Param("ew") Wrapper<HuzhufabuleixingEntity> wrapper);
	
	List<HuzhufabuleixingView> selectListView(@Param("ew") Wrapper<HuzhufabuleixingEntity> wrapper);

	List<HuzhufabuleixingView> selectListView(Pagination page,@Param("ew") Wrapper<HuzhufabuleixingEntity> wrapper);
	
	HuzhufabuleixingView selectView(@Param("ew") Wrapper<HuzhufabuleixingEntity> wrapper);
	

}
