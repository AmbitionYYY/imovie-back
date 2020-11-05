package com.offcn.bean;

public class MovieDetail {

	
		private Integer id ;
		private String director;
		private String keyword;
		private String categroy;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getDirector() {
			return director;
		}
		public void setDirector(String director) {
			this.director = director;
		}
		public String getKeyword() {
			return keyword;
		}
		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}
		public String getCategroy() {
			return categroy;
		}
		public void setCategroy(String categroy) {
			this.categroy = categroy;
		}
		public String getDes() {
			return des;
		}
		public void setDes(String des) {
			this.des = des;
		}
		private String des;
		@Override
		public String toString() {
			return "MovieDetail [id=" + id + ", director=" + director + ", keyword=" + keyword + ", categroy="
					+ categroy + ", des=" + des + "]";
		}

}
