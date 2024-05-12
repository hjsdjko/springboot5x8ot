package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussxianzhijiaoyiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussxianzhijiaoyiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussxianzhijiaoyiView;


/**
 * 闲置交易评论表
 *
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
public interface DiscussxianzhijiaoyiService extends IService<DiscussxianzhijiaoyiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxianzhijiaoyiVO> selectListVO(Wrapper<DiscussxianzhijiaoyiEntity> wrapper);
   	
   	DiscussxianzhijiaoyiVO selectVO(@Param("ew") Wrapper<DiscussxianzhijiaoyiEntity> wrapper);
   	
   	List<DiscussxianzhijiaoyiView> selectListView(Wrapper<DiscussxianzhijiaoyiEntity> wrapper);
   	
   	DiscussxianzhijiaoyiView selectView(@Param("ew") Wrapper<DiscussxianzhijiaoyiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxianzhijiaoyiEntity> wrapper);
   	

}

