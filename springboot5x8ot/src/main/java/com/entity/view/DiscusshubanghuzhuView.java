package com.entity.view;

import com.entity.DiscusshubanghuzhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 互帮互助评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
@TableName("discusshubanghuzhu")
public class DiscusshubanghuzhuView  extends DiscusshubanghuzhuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusshubanghuzhuView(){
	}
 
 	public DiscusshubanghuzhuView(DiscusshubanghuzhuEntity discusshubanghuzhuEntity){
 	try {
			BeanUtils.copyProperties(this, discusshubanghuzhuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
