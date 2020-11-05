package com.offcn.bean;
//此类和movietable对应
public class Movie {

private Integer	id; 
private String	moviename;
private String	time;
private String	url;
private String	imagepath;
private String  saveimagepath; 
private Float	score;
private Integer	status;
private String	source;

//详情属性
private MovieDetail moviedetail;

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getMoviename() {
	return moviename;
}
public void setMoviename(String moviename) {
	this.moviename = moviename;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getImagepath() {
	return imagepath;
}
public void setImagepath(String imagepath) {
	this.imagepath = imagepath;
}
public String getSaveimagepath() {
	return saveimagepath;
}
public void setSaveimagepath(String saveimagepath) {
	this.saveimagepath = saveimagepath;
}
public Float getScore() {
	return score;
}
public void setScore(Float score) {
	this.score = score;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
@Override
public String toString() {
	return "Movie [id=" + id + ", moviename=" + moviename + ", time=" + time + ", url=" + url + ", imagepath="
			+ imagepath + ", saveimagepath=" + saveimagepath + ", score=" + score + ", status=" + status + ", source="
			+ source + "]";
}
public MovieDetail getMoviedetail() {
	return moviedetail;
}
public void setMoviedetail(MovieDetail moviedetail) {
	this.moviedetail = moviedetail;
}
	
	
	
}
