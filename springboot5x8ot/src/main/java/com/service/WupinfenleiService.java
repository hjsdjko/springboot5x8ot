package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WupinfenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WupinfenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WupinfenleiView;


/**
 * 物品分类
 *
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
public interface WupinfenleiService extends IService<WupinfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WupinfenleiVO> selectListVO(Wrapper<WupinfenleiEntity> wrapper);
   	
   	WupinfenleiVO selectVO(@Param("ew") Wrapper<WupinfenleiEntity> wrapper);
   	
   	List<WupinfenleiView> selectListView(Wrapper<WupinfenleiEntity> wrapper);
   	
   	WupinfenleiView selectView(@Param("ew") Wrapper<WupinfenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WupinfenleiEntity> wrapper);
   	

}

