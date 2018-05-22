package com.zammc.page;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
<b>版本编号：version2.0</b>
<b>功能：分页</b>
<b>作者：张海峰</b>
<b>日期：2017年2月24日</b>

<b>更新时间：2017年2月24日 上午10:06:54</b>
<b>文件名称：PageBean</b>
<b>包名称：com.ifuturex.manage.common.base</b>
<b>项目名称：ifuturex-manage</b>
<b></b>
 */
public class PageBean {
	private long totalRecorder = 0;//总记录数
	private int pageSize = 10;//每页的记录数   
	private int pageNum = 1;//当前第几页	
	private int totalPage = 0;//总页数    
	private List<?> content;
	private List<Map<String, Object>> data;
	
	public void setPageInfo(long tr,int tp){
		setTotalRecorder(tr);
		setTotalPage(tp);
	}

    @Override
    public String toString() {
        return "PageBean{" +
                "总记录数=" + totalRecorder +
                ", 每页的记录数=" + pageSize +
                ", 当前第几页=" + pageNum +
                ", 总页数=" + totalPage +
                '}';
    }

    public void load(JdbcTemplate jdbcTemplate, StringBuffer sql, List<Object> param){
		StringBuffer countSql = new StringBuffer();
		countSql.append("select count(*) from (");
		countSql.append(sql);
		countSql.append(") as total");
		
		totalRecorder = jdbcTemplate.queryForObject(countSql.toString(), param.toArray(),Integer.class);
		if(totalRecorder > 0){
			sql.append(" limit ?,?");
			param.add((pageNum - 1 ) * pageSize);
			param.add(pageSize);
			data = jdbcTemplate.queryForList(sql.toString(), param.toArray());
		}
	}

	public long getTotalRecorder() {
		return totalRecorder;
	}
	public void setTotalRecorder(long totalRecorder) {
		this.totalRecorder = totalRecorder;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getTotalPage() {
		if(totalRecorder % pageSize == 0){
			totalPage = (int) (totalRecorder / pageSize);
		}else{
			totalPage = (int) ((totalRecorder / pageSize) + 1);
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<?> getContent() {
		return content;
	}

	public void setContent(List<?> content) {
		this.content = content;
	}

	public List<Map<String, Object>> getData() {
		return data;
	}

	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}
	
}
