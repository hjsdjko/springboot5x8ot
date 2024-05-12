package com.entity.view;

import com.entity.DiscussxianzhijiaoyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 闲置交易评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
@TableName("discussxianzhijiaoyi")
public class DiscussxianzhijiaoyiView  extends DiscussxianzhijiaoyiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussxianzhijiaoyiView(){
	}
 
 	public DiscussxianzhijiaoyiView(DiscussxianzhijiaoyiEntity discussxianzhijiaoyiEntity){
 	try {
			BeanUtils.copyProperties(this, discussxianzhijiaoyiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
