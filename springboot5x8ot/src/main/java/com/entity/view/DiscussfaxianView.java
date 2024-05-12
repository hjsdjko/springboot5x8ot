package com.entity.view;

import com.entity.DiscussfaxianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 发现评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
@TableName("discussfaxian")
public class DiscussfaxianView  extends DiscussfaxianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussfaxianView(){
	}
 
 	public DiscussfaxianView(DiscussfaxianEntity discussfaxianEntity){
 	try {
			BeanUtils.copyProperties(this, discussfaxianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
