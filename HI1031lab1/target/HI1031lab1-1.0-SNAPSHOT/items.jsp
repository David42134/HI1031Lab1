<%@ page import="java.util.Collection" %>
<%@ page import="ui.ItemInfo" %>
<%@ page import="bo.ItemHandler" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: david
  Date: 2024-10-01
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% Collection<ItemInfo> items = ItemHandler.getItemsWithGroup("frukt");
    Iterator<ItemInfo> it = items.iterator();
    for(; it.hasNext();){
      ItemInfo item = it.next();%>
    <%= item.getName()%> :
  <%= item.getDescription()%><br>

  <% }%>

</body>
</html>
