
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Collection" %>
<%@ page import="ui.ItemInfo" %>
<%@ page import="bo.ItemHandler" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="bo.User" %>


<%
  User auth = (User) request.getSession().getAttribute("auth");
  if (auth != null) {
    request.setAttribute("person", auth);
  }
  Collection<ItemInfo> items = ItemHandler.getItemsWithGroup("frukt");
  Iterator<ItemInfo> it = items.iterator();%>

<html>
<head>
  <%@include file="/includes/head.jsp"%>
  <title>TEST</title>
</head>
<body>
<%@include file="/includes/navbar.jsp"%>

<div class="container">
  <div class="card-header my-3">All Products</div>
  <div class="row">
    <%
      for(; it.hasNext();){
        ItemInfo item = it.next();%>
    <div class="col-md-3 my-3">
      <div class="card w-100" style="width: 18rem;">
        <img class="card-img-top" src="product-image/default-product-image.png" alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title"><%= item.getName()%></h5>
          <h6 class="price">Price: $<%=item.getPrice()%></h6>
          <h6 class="category">Category: <%= item.getDescription()%></h6>
          <div class="mt-3 d-flex justify-content-between">
            <a href="add-to-cart?id=<%=item.getId()%>" class="btn btn-primary" >Add to Cart</a>

          </div>
        </div>
      </div>
    </div>
    <% }%>


  </div>
</div>
</body>
</html>
