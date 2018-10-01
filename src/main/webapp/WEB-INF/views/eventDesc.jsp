<%@include file="/WEB-INF/views/template/header.jsp"%>

<section id="services">
    <div class="container-fluid">
        <div class="col-lg-8 col-lg-offset-2 text-center">
            <h1 class="section-heading">Acquista i biglietti!</h1>

        </div>
    </div>

    <div class="container" ng-app = "cartApp">
        <div class="col-md-6">
            <div class="row no-gutter popup-gallery">
                <a href="<c:url value="/resources/img/eventImages/${eventotr.idEvent}.png" />" class="portfolio-box">
                    <img src="<c:url value="/resources/img/eventImages/${eventotr.idEvent}.png" />" class="img-responsive" alt="">
                </a>
            </div>
        </div>

        <div class="col-md-5">
            <h3>${eventotr.eventName}</h3>
            <p>${eventotr.description}</p>
            <p>${eventotr.place}</p>
            <p>${eventotr.date}</p>
        </div>
    </div>
    <br />
    <br />
    <br />
<div class="tab-container">
<table class="table">
    <thead>
    <tr>
        <th scope="col">Nome</th>
        <th scope="col">Settore</th>
        <th scope="col">Prezzo</th>
        <th scope="col">Posti Disponibili</th>
        <th scope="col">Quantità</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sectors}" var="sectors">
        <tr>
            <td>${eventotr.eventName}</td>
            <td>${sectors.name}</td>
            <td>$ ${sectors.price}</td>
            <td>${sectors.seatsAvail}</td>
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
                </select>
                    <input type="hidden" name="idSec" value="${sectors.idSector}">
                    <input type="hidden" name="idEv" value="${eventotr.idEvent}">
                    <input type="submit" button type="button" class="btn btn-success" value="Aggiungi al carrello">

            </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</section>


