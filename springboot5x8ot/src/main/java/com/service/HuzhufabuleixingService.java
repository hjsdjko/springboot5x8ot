package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuzhufabuleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuzhufabuleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuzhufabuleixingView;


/**
 * 互助发布类型
 *
 * @author 
 * @email 
 * @date 2023-04-10 19:07:53
 */
public interface HuzhufabuleixingService extends IService<HuzhufabuleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuzhufabuleixingVO> selectListVO(Wrapper<HuzhufabuleixingEntity> wrapper);
   	
   	HuzhufabuleixingVO selectVO(@Param("ew") Wrapper<HuzhufabuleixingEntity> wrapper);
   	
   	List<HuzhufabuleixingView> selectListView(Wrapper<HuzhufabuleixingEntity> wrapper);
   	
   	HuzhufabuleixingView selectView(@Param("ew") Wrapper<HuzhufabuleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuzhufabuleixingEntity> wrapper);
   	

}

