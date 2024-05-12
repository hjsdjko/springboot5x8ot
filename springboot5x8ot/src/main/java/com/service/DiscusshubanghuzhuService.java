package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusshubanghuzhuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusshubanghuzhuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusshubanghuzhuView;


/**
 * 互帮互助评论表
 *
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
public interface DiscusshubanghuzhuService extends IService<DiscusshubanghuzhuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusshubanghuzhuVO> selectListVO(Wrapper<DiscusshubanghuzhuEntity> wrapper);
   	
   	DiscusshubanghuzhuVO selectVO(@Param("ew") Wrapper<DiscusshubanghuzhuEntity> wrapper);
   	
   	List<DiscusshubanghuzhuView> selectListView(Wrapper<DiscusshubanghuzhuEntity> wrapper);
   	
   	DiscusshubanghuzhuView selectView(@Param("ew") Wrapper<DiscusshubanghuzhuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusshubanghuzhuEntity> wrapper);
   	

}

