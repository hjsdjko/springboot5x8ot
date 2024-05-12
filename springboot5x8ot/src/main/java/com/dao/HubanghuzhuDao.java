package com.dao;

import com.entity.HubanghuzhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HubanghuzhuVO;
import com.entity.view.HubanghuzhuView;


/**
 * 互帮互助
 * 
 * @author 
 * @email 
 * @date 2023-04-10 19:07:53
 */
public interface HubanghuzhuDao extends BaseMapper<HubanghuzhuEntity> {
	
	List<HubanghuzhuVO> selectListVO(@Param("ew") Wrapper<HubanghuzhuEntity> wrapper);
	
	HubanghuzhuVO selectVO(@Param("ew") Wrapper<HubanghuzhuEntity> wrapper);
	
	List<HubanghuzhuView> selectListView(@Param("ew") Wrapper<HubanghuzhuEntity> wrapper);

	List<HubanghuzhuView> selectListView(Pagination page,@Param("ew") Wrapper<HubanghuzhuEntity> wrapper);
	
	HubanghuzhuView selectView(@Param("ew") Wrapper<HubanghuzhuEntity> wrapper);
	

}
