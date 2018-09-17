<%--
  Created by IntelliJ IDEA.
  User: Gianmarco
  Date: 01/09/2018
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<section id="services">

    <div class="container-fluid">
        <c:if test="${!(TickRemoved==null)}"><div class="alert alert-success">${TickRemoved}</div></c:if>
        <c:if test="${!(TickNotRemoved==null)}"><div class="alert alert-danger">${TickNotRemoved}</div></c:if>
        <c:if test="${!(Error==null)}"><div class="alert alert-danger">${Error}</div></c:if>
        <div class="col-lg-8 col-lg-offset-2 text-center">
            <h1 class="section-heading">Il tuo carrello</h1>
        </div>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Nome</th>
            <th scope="col">Data</th>
            <th scope="col">Luogo</th>
            <th scope="col">Settore</th>
            <th scope="col">Prezzo</th>
            <th scope="col">Rimuovi</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tickets}" var="tickets">
            <tr>
                <td>${tickets.eventName}</td>
                <td>${tickets.date}</td>
                <td>${tickets.place}</td>
                <td>${tickets.secName}</td>
                <td>${tickets.price}</td>
                <td>
                    <form method="POST" action="<c:url value="/cart/delTicket"/>">
                        <input type="hidden" name="idTick" value="${tickets.id}">
                        <input class="btn btn-danger btn-small" type="submit" value="Rimuovi">
                    </form>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>



    <div class="container-fluid">
        <a href="<c:url value="/payment/view"/>" class="btn btn-info btn-lg pull-right" role="button">Procedi all'acquisto!</a>
    </div>

</section>
