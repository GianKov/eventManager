
<%@include file="/WEB-INF/views/template/header.jsp"%>

<section id="services">
    <div class="container">
        <c:if test="${!(Successo==null)}"><div class="alert alert-success">${Successo}</div></c:if>
        <c:if test="${!(Failure==null)}"><div class="alert alert-danger">${Failure}</div></c:if>
        <div class="col-lg-8 col-lg-offset-2 text-center">
            <h1 class="section-heading">Tutti gli eventi disponibili!</h1>
        </div>
    </div>

    <div class="container-fluid">
        <div class="table-responsive">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Nome</th>
            <th scope="col">Data</th>
            <th scope="col">Luogo</th>
            <th scope="col">Prezzi a partire da</th>
            <th scope="col">Posti disponibili</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${events}" var="events">
            <tr>
                <td>${events.eventName}</td>
                <td>${events.date}</td>
                <td>${events.place}</td>
                <td>${events.price}</td>
                <td>${events.seats}</td>
                <td>
                    <form method="POST" action="<c:url value="/event/description"/>">
                        <input type="hidden" name="id" value="${events.idEvent}">
                        <input class="btn btn-danger btn-small" type="submit" value="COMPRA I BIGLIETTI">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
    </div>

    <div class="container">

    <form role="form" id="form-buscar" action="<c:url value="/event/research"/>" method="post">
        <div class="form-group">
            <div class="input-group">
                <input id="1" class="form-control" type="text" name="search" placeholder="Effettua una nuova ricerca!" required/>
                <span class="input-group-btn">
                <button class="btn btn-success" type="submit" value="search">
                    <i class="glyphicon glyphicon-search" aria-hidden="true"></i> Search
                </button>
                </span>
            </div>
        </div>
    </form>
    </div>

</section>
