package com.dao;

import com.entity.GoumaiwupinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GoumaiwupinVO;
import com.entity.view.GoumaiwupinView;


/**
 * 购买物品
 * 
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
public interface GoumaiwupinDao extends BaseMapper<GoumaiwupinEntity> {
	
	List<GoumaiwupinVO> selectListVO(@Param("ew") Wrapper<GoumaiwupinEntity> wrapper);
	
	GoumaiwupinVO selectVO(@Param("ew") Wrapper<GoumaiwupinEntity> wrapper);
	
	List<GoumaiwupinView> selectListView(@Param("ew") Wrapper<GoumaiwupinEntity> wrapper);

	List<GoumaiwupinView> selectListView(Pagination page,@Param("ew") Wrapper<GoumaiwupinEntity> wrapper);
	
	GoumaiwupinView selectView(@Param("ew") Wrapper<GoumaiwupinEntity> wrapper);
	

}
