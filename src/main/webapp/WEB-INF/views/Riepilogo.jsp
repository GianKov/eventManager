<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<section id="services">

    <div class="container-fluid">
        <c:if test="${!(Confirm==null)}"><div class="alert alert-success">${Confirm}</div></c:if>
        <div class="col-lg-8 col-lg-offset-2 text-center">
            <h1 class="section-heading">Riepilogo acquisto</h1>
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
            <th scope="col">QRCode</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${TicketsB}" var="tickets">
            <tr>
                <td>${tickets.eventName}</td>
                <td>${tickets.date}</td>
                <td>${tickets.place}</td>
                <td>${tickets.secName}</td>
                <td>${tickets.price}</td>
                <td><img id="profileImage" src="data:image/png;base64,${tickets.qrImage}"></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <center>
        <button class="btn btn-primary hidden-print" onclick="window.print()"><span class="glyphicon glyphicon-print" aria-hidden="true"></span> Stampa</button>
    </center>

</section>
