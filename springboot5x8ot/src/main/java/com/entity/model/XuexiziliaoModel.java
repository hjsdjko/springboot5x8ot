package com.entity.model;

import com.entity.XuexiziliaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 学习资料
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-04-10 19:07:54
 */
public class XuexiziliaoModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 资料类别
	 */
	
	private String ziliaoleibie;
		
	/**
	 * 资料图片
	 */
	
	private String ziliaotupian;
		
	/**
	 * 资料内容
	 */
	
	private String ziliaoneirong;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fabushijian;
				
	
	/**
	 * 设置：资料类别
	 */
	 
	public void setZiliaoleibie(String ziliaoleibie) {
		this.ziliaoleibie = ziliaoleibie;
	}
	
	/**
	 * 获取：资料类别
	 */
	public String getZiliaoleibie() {
		return ziliaoleibie;
	}
				
	
	/**
	 * 设置：资料图片
	 */
	 
	public void setZiliaotupian(String ziliaotupian) {
		this.ziliaotupian = ziliaotupian;
	}
	
	/**
	 * 获取：资料图片
	 */
	public String getZiliaotupian() {
		return ziliaotupian;
	}
				
	
	/**
	 * 设置：资料内容
	 */
	 
	public void setZiliaoneirong(String ziliaoneirong) {
		this.ziliaoneirong = ziliaoneirong;
	}
	
	/**
	 * 获取：资料内容
	 */
	public String getZiliaoneirong() {
		return ziliaoneirong;
	}
				
	
	/**
	 * 设置：用户账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：发布时间
	 */
	 
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
			
}
