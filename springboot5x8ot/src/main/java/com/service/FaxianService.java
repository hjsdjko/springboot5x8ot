package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FaxianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FaxianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FaxianView;


/**
 * 发现
 *
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
public interface FaxianService extends IService<FaxianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FaxianVO> selectListVO(Wrapper<FaxianEntity> wrapper);
   	
   	FaxianVO selectVO(@Param("ew") Wrapper<FaxianEntity> wrapper);
   	
   	List<FaxianView> selectListView(Wrapper<FaxianEntity> wrapper);
   	
   	FaxianView selectView(@Param("ew") Wrapper<FaxianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FaxianEntity> wrapper);
   	

}

