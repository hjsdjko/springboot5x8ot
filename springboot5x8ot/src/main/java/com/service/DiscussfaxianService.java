package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussfaxianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussfaxianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussfaxianView;


/**
 * 发现评论表
 *
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
public interface DiscussfaxianService extends IService<DiscussfaxianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussfaxianVO> selectListVO(Wrapper<DiscussfaxianEntity> wrapper);
   	
   	DiscussfaxianVO selectVO(@Param("ew") Wrapper<DiscussfaxianEntity> wrapper);
   	
   	List<DiscussfaxianView> selectListView(Wrapper<DiscussfaxianEntity> wrapper);
   	
   	DiscussfaxianView selectView(@Param("ew") Wrapper<DiscussfaxianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussfaxianEntity> wrapper);
   	

}

