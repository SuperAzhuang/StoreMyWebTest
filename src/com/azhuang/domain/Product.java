package com.azhuang.domain;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable{
//	  `pid` varchar(32) NOT NULL,
//	  `pname` varchar(50) DEFAULT NULL,
//	  `market_price` double DEFAULT NULL,
//	  `shop_price` double DEFAULT NULL,
//	  `pimage` varchar(200) DEFAULT NULL,
//	  `pdate` date DEFAULT NULL,
//	  `is_hot` int(11) DEFAULT NULL,
//	  `pdesc` varchar(255) DEFAULT NULL,
//	  `pflag` int(11) DEFAULT NULL,
//	  `cid` varchar(32) DEFAULT NULL,
	
	private String pid;
	private String pname;
	private Double market_price;
	private Double shop_price;
	private String pimage;
	private Date date;
	private Integer is_hot;
	private String pdesc;
	private Integer pflag;
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	private String cid;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}
	public Double getShop_price() {
		return shop_price;
	}
	public void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public Integer getPflag() {
		return pflag;
	}
	public void setPflag(Integer pflag) {
		this.pflag = pflag;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	
	
}
