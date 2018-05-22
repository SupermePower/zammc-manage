<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="./taglib.jsp" %>
<link rel="stylesheet" href='${rootURL}resources/css/page.css'/>
<div class="paging">
    <div class=""></div>
    <div class="paging-box"><p class="paging-text">共有${page.totalRecorder }条，每页显示${page.pageSize }条</p>
        <ul class="paging-list">
            <li id="firstpage" ${page.pageNum == 1 ? 'class="disabled"':''}><img src="${rootURL}/resources/images/paging-01.png"/></li>
            <li id="prevpage" ${page.pageNum == 1 ? 'class="disabled"':''}><img src="${rootURL}/resources/images/paging-02.png"/></li>
            <c:forEach var="pageIndex" begin="1" end="${page.totalPage}"><c:choose><c:when
                    test="${pageIndex==1 }"><c:choose><c:when test="${page.pageNum == pageIndex}">
                <li class="paging-bg page">${pageIndex}</li>
            </c:when><c:otherwise>
                <li class="page">${pageIndex}</li>
            </c:otherwise></c:choose></c:when><c:otherwise><c:choose><c:when
                    test="${pageIndex==page.totalPage}"><c:choose><c:when test="${page.pageNum == pageIndex}">
                <li class="paging-bg page">${pageIndex}</li>
            </c:when><c:otherwise><%-- <li>${pageIndex}</li>   --%>
                <li class="page">${pageIndex}</li>
            </c:otherwise></c:choose></c:when><c:otherwise><c:choose><c:when
                    test="${page.totalPage<=10 }"><c:choose><c:when test="${page.pageNum== pageIndex}">
                <li class="paging-bg page">${pageIndex}</li>
            </c:when><c:otherwise>
                <li class="page">${pageIndex}</li>
            </c:otherwise></c:choose></c:when><c:otherwise><c:choose><c:when
                    test="${page.pageNum - pageIndex <= 3&&page.pageNum-pageIndex >= -3 }"><c:choose><c:when
                    test="${page.pageNum == pageIndex}">
                <li class="paging-bg page">${pageIndex}</li>
            </c:when><c:otherwise>
                <li class="page">${pageIndex}</li>
            </c:otherwise></c:choose></c:when><c:otherwise><c:choose><c:when test="${pageIndex==2 }">
                <li>...</li>
            </c:when><c:when test="${pageIndex == page.totalPage - 1 }">
                <li>...</li>
            </c:when></c:choose></c:otherwise></c:choose></c:otherwise></c:choose></c:otherwise></c:choose></c:otherwise></c:choose></c:forEach>
            <li id="nextpage" ${page.pageNum == page.totalPage ? 'class="disabled"':''}><img
                    src="${rootURL}/resources/images/paging-22.png"/></li>
            <li id="lastpage" ${page.pageNum == page.totalPage ? 'class="disabled"':''}><img
                    src="${rootURL}/resources/images/paging-11.png"/></li>
        </ul>
        <input id="pageNum" class="paging-input" type="text" value="${page.pageNum}"/>
        <p id="gopage" class="paging-btn">GO</p></div>
</div>