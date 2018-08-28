
<%@include file="/WEB-INF/views/template/header.jsp"%>
<section id="services">
    <div class="container-fluid">
        <div class="col-lg-8 col-lg-offset-2 text-center">
            <h1 class="section-heading">Tutti gli eventi disponibili!</h1>
        </div>
    </div>
    <form role="form" id="form-buscar" action="<c:url value="/event/research"/>" method="post">
        <div class="form-group">
            <div class="input-group">
                <input id="1" class="form-control" type="text" name="search" placeholder="Search..." required/>
                <span class="input-group-btn">
                <button class="btn btn-success" type="submit" value="search">
                    <i class="glyphicon glyphicon-search" aria-hidden="true"></i> Search
                </button>
                </span>
            </div>
        </div>
    </form>
    <table class="table">
        <thead>
        <tr>

            <th scope="col">Nome</th>
            <th scope="col">Data</th>
            <th scope="col">Luogo</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${events}" var="events">
            <tr>
                <td>${events.eventName}</td>
                <td>${events.date}</td>
                <td>${events.place}</td>
                <td>
                    <form method="POST" action="<c:url value="/event/description"/>">
                        <input type="hidden" name="id" value="${events.idEvent}">
                        <input class="btn btn-danger btn-small" type="submit" value="Info">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</section>