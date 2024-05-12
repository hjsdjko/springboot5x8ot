package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GoumaiwupinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GoumaiwupinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GoumaiwupinView;


/**
 * 购买物品
 *
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
public interface GoumaiwupinService extends IService<GoumaiwupinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GoumaiwupinVO> selectListVO(Wrapper<GoumaiwupinEntity> wrapper);
   	
   	GoumaiwupinVO selectVO(@Param("ew") Wrapper<GoumaiwupinEntity> wrapper);
   	
   	List<GoumaiwupinView> selectListView(Wrapper<GoumaiwupinEntity> wrapper);
   	
   	GoumaiwupinView selectView(@Param("ew") Wrapper<GoumaiwupinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GoumaiwupinEntity> wrapper);
   	

}

