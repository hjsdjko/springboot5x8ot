package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZiliaoleibieEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZiliaoleibieVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZiliaoleibieView;


/**
 * 资料类别
 *
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
public interface ZiliaoleibieService extends IService<ZiliaoleibieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZiliaoleibieVO> selectListVO(Wrapper<ZiliaoleibieEntity> wrapper);
   	
   	ZiliaoleibieVO selectVO(@Param("ew") Wrapper<ZiliaoleibieEntity> wrapper);
   	
   	List<ZiliaoleibieView> selectListView(Wrapper<ZiliaoleibieEntity> wrapper);
   	
   	ZiliaoleibieView selectView(@Param("ew") Wrapper<ZiliaoleibieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZiliaoleibieEntity> wrapper);
   	

}

