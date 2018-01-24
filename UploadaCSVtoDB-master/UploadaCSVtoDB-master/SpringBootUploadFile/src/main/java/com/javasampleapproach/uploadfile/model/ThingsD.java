package com.javasampleapproach.uploadfile.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name="code1")
public class ThingsD {

	@Id
	@Column(name="col1")
	String col1;
	@Column(name="col2")
	String col2;
	@Column(name="col3")
	String col3;
	@Column(name="col4")
	String col4;
	@Column(name="col5")
	String col5;
	@Column(name="col6")
	String col6;
	@Column(name="col7")
	String col7;
	/**
	 * @return the col1
	 */
	public String getCol1() {
		return col1;
	}
	/**
	 * @param col1 the col1 to set
	 */
	public void setCol1(String col1) {
		this.col1 = col1;
	}
	/**
	 * @return the col2
	 */
	public String getCol2() {
		return col2;
	}
	/**
	 * @param col2 the col2 to set
	 */
	public void setCol2(String col2) {
		this.col2 = col2;
	}
	/**
	 * @return the col3
	 */
	public String getCol3() {
		return col3;
	}
	/**
	 * @param col3 the col3 to set
	 */
	public void setCol3(String col3) {
		this.col3 = col3;
	}
	/**
	 * @return the col4
	 */
	public String getCol4() {
		return col4;
	}
	/**
	 * @param col4 the col4 to set
	 */
	public void setCol4(String col4) {
		this.col4 = col4;
	}
	/**
	 * @return the col5
	 */
	public String getCol5() {
		return col5;
	}
	/**
	 * @param col5 the col5 to set
	 */
	public void setCol5(String col5) {
		this.col5 = col5;
	}
	/**
	 * @return the col6
	 */
	public String getCol6() {
		return col6;
	}
	/**
	 * @param col6 the col6 to set
	 */
	public void setCol6(String col6) {
		this.col6 = col6;
	}
	/**
	 * @return the col7
	 */
	public String getCol7() {
		return col7;
	}
	/**
	 * @param col7 the col7 to set
	 */
	public void setCol7(String col7) {
		this.col7 = col7;
	}
	
		// TODO Auto-generated method stub
		
	
	
}
