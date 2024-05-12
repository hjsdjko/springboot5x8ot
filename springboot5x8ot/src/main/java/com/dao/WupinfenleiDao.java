package com.dao;

import com.entity.WupinfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WupinfenleiVO;
import com.entity.view.WupinfenleiView;


/**
 * 物品分类
 * 
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
public interface WupinfenleiDao extends BaseMapper<WupinfenleiEntity> {
	
	List<WupinfenleiVO> selectListVO(@Param("ew") Wrapper<WupinfenleiEntity> wrapper);
	
	WupinfenleiVO selectVO(@Param("ew") Wrapper<WupinfenleiEntity> wrapper);
	
	List<WupinfenleiView> selectListView(@Param("ew") Wrapper<WupinfenleiEntity> wrapper);

	List<WupinfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<WupinfenleiEntity> wrapper);
	
	WupinfenleiView selectView(@Param("ew") Wrapper<WupinfenleiEntity> wrapper);
	

}
