package com.dao;

import com.entity.ZiliaoleibieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZiliaoleibieVO;
import com.entity.view.ZiliaoleibieView;


/**
 * 资料类别
 * 
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
public interface ZiliaoleibieDao extends BaseMapper<ZiliaoleibieEntity> {
	
	List<ZiliaoleibieVO> selectListVO(@Param("ew") Wrapper<ZiliaoleibieEntity> wrapper);
	
	ZiliaoleibieVO selectVO(@Param("ew") Wrapper<ZiliaoleibieEntity> wrapper);
	
	List<ZiliaoleibieView> selectListView(@Param("ew") Wrapper<ZiliaoleibieEntity> wrapper);

	List<ZiliaoleibieView> selectListView(Pagination page,@Param("ew") Wrapper<ZiliaoleibieEntity> wrapper);
	
	ZiliaoleibieView selectView(@Param("ew") Wrapper<ZiliaoleibieEntity> wrapper);
	

}
