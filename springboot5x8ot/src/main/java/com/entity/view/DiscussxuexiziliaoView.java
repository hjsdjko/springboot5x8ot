package com.entity.view;

import com.entity.DiscussxuexiziliaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 学习资料评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
@TableName("discussxuexiziliao")
public class DiscussxuexiziliaoView  extends DiscussxuexiziliaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussxuexiziliaoView(){
	}
 
 	public DiscussxuexiziliaoView(DiscussxuexiziliaoEntity discussxuexiziliaoEntity){
 	try {
			BeanUtils.copyProperties(this, discussxuexiziliaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
