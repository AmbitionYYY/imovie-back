package com.offcn.bean;

public class ConditionBean {
	private String area;
	private String type;
	private String year;
	private String style;
	private String name;
	
	private String caption;
	private String keyword;
	
	//添加两个条件用来查询演员数据
	
	private String conname="'查询所有'";//保存页面选中项
	private String convalue="";
	public String getConname() {
		return conname;
	}
	public void setConname(String conname) {
		this.conname = conname;
	}
	public String getConvalue() {
		return convalue;
	}
	public void setConvalue(String convalue) {
		this.convalue = convalue;
	}
	
	
	public String getCaption() {
		if(area!=null && area.length()>0) {
			this.caption="地区";
		}else if(type!=null && type.length()>0) {
			this.caption="类型";
		}else if(style!=null && style.length()>0) {
			this.caption="规格";
		}else if(year!=null && year.length()>0) {
			this.caption="我的年代";
		}else if(name!=null && name.length()>0) {
			this.caption="电影名称";
		}
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getKeyword() {
		if(area!=null && area.length()>0) {
			this.keyword=area;
		}else if(type!=null && type.length()>0) {
			this.keyword=type;
		}else if(style!=null && style.length()>0) {
			this.keyword=style;
		}else if(year!=null && year.length()>0) {
			this.keyword=year;
		}else if(name!=null && name.length()>0) {
			this.keyword=name;
		}
		
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ConditionBean [area=" + area + ", type=" + type + ", year=" + year + ", style=" + style + ", name="
				+ name + ", toString()=" + super.toString() + "]";
	}

}
