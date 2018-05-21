package com.zammc.page;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class PageBean {
    private int totalRecorder = 0;//总记录数
    private int pageSize = 10;//每页的记录数
    private int pageNum = 1;//当前第几页
    private int totalPage = 0;//总页数
    private List<Map<String, Object>> data;

    public void load(JdbcTemplate jdbcTemplate, StringBuffer sql, List<Object> param) {
        StringBuffer countSql = new StringBuffer();
        countSql.append("select count(*) from (");
        countSql.append(sql);
        countSql.append(") as total");

        totalRecorder = jdbcTemplate.queryForObject(countSql.toString(), param.toArray(), Integer.class);
        if (totalRecorder > 0) {
            sql.append(" limit ?,?");
            param.add((pageNum - 1) * pageSize);
            param.add(pageSize);
            data = jdbcTemplate.queryForList(sql.toString(), param.toArray());
        }
    }

    @Override
    public String toString() {
        System.out.println("总记录数:" + totalRecorder);
        System.out.println("每页的记录数 :" + pageSize);
        System.out.println("当前第几页:" + pageNum);
        System.out.println("总页数:" + totalPage);
        System.out.println("数据:" + data);
        return null;
    }

    public int getTotalRecorder() {
        return totalRecorder;
    }

    public void setTotalRecorder(int totalRecorder) {
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
        if (totalRecorder % pageSize == 0) {
            totalPage = totalRecorder / pageSize;
        } else {
            totalPage = (totalRecorder / pageSize) + 1;
        }
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }

}
