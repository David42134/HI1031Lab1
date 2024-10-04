
<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page import="bo.Cart" %>
<%@ page import="db.CartDB" %>
<%@ page import="db.DBManager" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    if (cart_list != null) {
        CartDB c = new CartDB(cart_list);
        cartProduct = c.getCartProducts(cart_list);
        /*double total = c.getTotalCartPrice(cart_list);
        request.setAttribute("total", total);*/
        request.setAttribute("cart_list", cart_list);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/includes/head.jsp"%>
    <title>E-Commerce Cart</title>
    <style type="text/css">

        .table tbody td{
            vertical-align: middle;
        }
        .btn-incre, .btn-decre{
            box-shadow: none;
            font-size: 25px;
        }
    </style>
</head>
<body>
<%@include file="/includes/navbar.jsp"%>

<div class="container my-3">
    <div class="d-flex py-3">
        <h3>Total Price: $452 </h3>
        <a class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a>
    </div>
        <table class="table table-light">
            <thead>
                 <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Category</th>
                    <th scope="col">Price</th>
                    <th scope="col">Buy Now</th>
                    <th scope="col">Cancel</th>
                 </tr>
            </thead>
            <tbody>
            <%
                if(cart_list != null){
                    for (Cart c: cartProduct){%>
                        <tr>
                            <td> <%=c.getName()%> </td>
                            <td> <%=c.getDescr()%> </td>
                            <td> $<%=c.getPrice()%> </td>
                            <td>
                                <form action="order-now" method="post" class="form-inline">
                                    <input type="hidden" name="id" value="<%=c.getId()%>" class="form-input">
                                    <div class="form-group d-flex justify-content-between">
                                        <a class="btn bnt-sm btn-incre" href=""><i class="fas fa-plus-square"></i></a>
                                        <input type="text" name="quantity" class="form-control"  value="1" readonly>
                                        <a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&id="><i class="fas fa-minus-square"></i></a>
                                    </div>
                                </form>
                            </td>
                            <td><a class="btn btn-sm btn-danger" href="">Remove</a></td>
                    <%}
                }
                %>

            </tr>
        </tbody>
    </table>
</div>

</body>
</html>