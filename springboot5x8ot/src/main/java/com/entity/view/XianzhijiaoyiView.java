package com.entity.view;

import com.entity.XianzhijiaoyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 闲置交易
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
@TableName("xianzhijiaoyi")
public class XianzhijiaoyiView  extends XianzhijiaoyiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XianzhijiaoyiView(){
	}
 
 	public XianzhijiaoyiView(XianzhijiaoyiEntity xianzhijiaoyiEntity){
 	try {
			BeanUtils.copyProperties(this, xianzhijiaoyiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
