<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>

<div class="container-fluid">
    <div class="col-md-3">

      <div id="sidebar">
        <div class="container-fluid tmargin">
          <div class="input-group">
            <input type="text" class="form-control" placeholder="Search..." />
            <span class="input-group-btn">
              <button class="btn btn-default">
                <span class="glyphicon glyphicon-search"></span>
              </button>
            </span>
          </div>
        </div>
        <br/>
        <ul class="nav navbar-nav side-bar">
          <li class="side-bar tmargin">
            <a href="/admin/quan-ly-tai-nghe">
              <span class="glyphicon glyphicon-folder-open">&nbsp;</span>Quản lý Sản phẩm</a>
          </li>

          <li class="side-bar main-menu">
            <a href="<c:url value='/admin/thong-ke' />">
              <span class="glyphicon glyphicon-signal">&nbsp;</span>Thống kê</a>
          </li>

        </ul>
      </div>
    </div>
    
    <script src="<c:url value='/js/admin.js'/>" ></script>
