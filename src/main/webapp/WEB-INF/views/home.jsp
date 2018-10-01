<%@include file="/WEB-INF/views/template/header.jsp"%>
<header>
    <div class="header-content">
        <div class="header-content-inner">
            <c:if test="${Error=='Login effettuato correttamente'}"><div class="alert alert-success">${Error}</div></c:if>
            <c:if test="${!(Err==null)}"><div class="alert alert-danger">${Err}</div></c:if>
            <h1 id="homeHeading">Benvenuti su EventManager!</h1>
            <hr>
            <p>EventManager e' uno dei migliori siti in Italia per acquistare biglietti per tutti i tipi di evento!</p>
            <form role="form" id="form-buscar" action="<c:url value="/event/research"/>" method="post">
                <div class="form-group">
                    <div class="input-group">
                        <input id="1" class="form-control" type="text" name="search" placeholder="Ricerca per nome o luogo dell'evento" required/>
                        <span class="input-group-btn">
                <button class="btn btn-success" type="submit" value="search">
                    <i class="glyphicon glyphicon-search" aria-hidden="true"></i> Ricerca
                </button>
                </span>
                    </div>
                </div>
            </form>
            <a href="#about" class="btn btn-primary btn-xl page-scroll sr-button">Vedi tutti gli eventi disponibili!</a>
        </div>

    </div>
</header>

<div class="panel panel-default">
    <div class="panel-body">
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Carousel indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- Wrapper for carousel items -->
    <div class="carousel-inner">
        <div class="item active">

            <img class="img-responsive center-block" src="<c:url value="/resources/img/eventImages/1.png" />" alt="First Slide">
            <div class="carousel-caption">

                <form action="<c:url value="/event/description"/>" method="POST">
                    <input type="hidden" id="id" name="id" value="2">
                    <input type="submit" value="PARTECIPA ORA!" class="btn btn-sm btn-primary"></a>
                </form>
            </div>


        </div>
        <div class="item">

            <img class="img-responsive center-block" src="<c:url value="/resources/img/eventImages/2.png" />" alt="Second Slide">
            <div class="carousel-caption">

            <form action="<c:url value="/event/description"/>" method="POST">
                <input type="hidden" id="id" name="id" value="2">
                <input type="submit" value="PARTECIPA ORA!" class="btn btn-sm btn-primary"></a>
            </form>
            </div>
        </div>
        <div class="item">

            <img class="img-responsive center-block" src="<c:url value="/resources/img/eventImages/3.png" />" alt="Third Slide">
            <div class="carousel-caption">
            <form action="<c:url value="/event/description"/>" method="POST">
                <input type="hidden" id="id" name="id" value="3">
                <input type="submit" value="PARTECIPA ORA!" class="btn btn-sm btn-primary"></a>
            </form>
        </div>
        </div>
    </div>
    <!-- Carousel controls -->
    <a class="carousel-control left" href="#myCarousel" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
    </a>
    <a class="carousel-control right" href="#myCarousel" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
</div>
    </div>
</div>


<%--<%@include file="/WEB-INF/views/template/eventsHome.jsp"%>--%>

<section class="bg-primary" id="about">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 text-center">
                <h2 class="section-heading">I migliori eventi d'Italia!</h2>
                <hr class="light">
                <p class="text-faded">Se non sai ancora a quale evento vuoi partecipare clicca su Vai agli eventi per visualizzare tutti gli eventi!
                Se stai avendo problemi tecnici o vuoi collaborare con noi non esitare a contattarci!</p>
                <p class="text-faded">


                </p>
                <a href="#contact" class="page-scroll btn btn-info btn-xl sr-button">Contattaci</a>
                <a href="<c:url value="/event/eventList"/>" class="page-scroll btn btn-default btn-xl sr-button">Vai agli eventi!</a>
            </div>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/views/template/footer.jsp"%>

