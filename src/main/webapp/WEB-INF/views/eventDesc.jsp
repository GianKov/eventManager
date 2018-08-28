<%--
  Created by IntelliJ IDEA.
  User: Gianmarco
  Date: 23/08/2018
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<section id="services">
    <div class="container-fluid">
        <div class="col-lg-8 col-lg-offset-2 text-center">
            <h1 class="section-heading">Descrizione</h1>
        </div>
    </div>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Nome</th>
        <th scope="col">Data</th>
        <th scope="col">Luogo</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>${eventotr.eventName}</td>
            <td>${eventotr.date}</td>
            <td>${eventotr.place}</td>
        </tr>
    </tbody>
</table>
</section>

<%@include file="/WEB-INF/views/template/footer.jsp"%>
