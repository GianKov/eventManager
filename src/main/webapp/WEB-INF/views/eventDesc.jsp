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
        <th scope="col">Quantita</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>${eventotr.eventName}</td>
            <td>${eventotr.date}</td>
            <td>${eventotr.place}</td>
            <td>
                <form method="POST" action="<c:url value="/cart/aggtoCart"/>">
                <select name="quantita">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                </select>
                    <input type="hidden" name="id" value="${eventotr.idEvent}">
                <input type="submit" value="Aggiungi al carrello">
            </form>
            </td>
        </tr>
    </tbody>
</table>
</section>

<%@include file="/WEB-INF/views/template/footer.jsp"%>
