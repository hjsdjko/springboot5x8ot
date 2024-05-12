package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShudongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShudongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShudongView;


/**
 * 树洞
 *
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
public interface ShudongService extends IService<ShudongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShudongVO> selectListVO(Wrapper<ShudongEntity> wrapper);
   	
   	ShudongVO selectVO(@Param("ew") Wrapper<ShudongEntity> wrapper);
   	
   	List<ShudongView> selectListView(Wrapper<ShudongEntity> wrapper);
   	
   	ShudongView selectView(@Param("ew") Wrapper<ShudongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShudongEntity> wrapper);
   	

}

