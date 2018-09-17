<%@include file="/WEB-INF/views/template/header.jsp"%>
<header>
    <div class="header-content">
        <div class="header-content-inner">
            <c:if test="${Error=='Login effettuato correttamente'}"><div class="alert alert-success">${Error}</div></c:if>
            <c:if test="${!(Err==null)}"><div class="alert alert-danger">${Err}</div></c:if>
            <h1 id="homeHeading">Benvenuti su EventManager!</h1>
            <hr>
            <p>EventManager è uno dei migliori siti in Italia per acquistare biglietti per tutti i tipi di evento!</p>
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

<%@include file="/WEB-INF/views/template/eventsHome.jsp"%>

<section class="bg-primary" id="about">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 text-center">
                <h2 class="section-heading">I migliori eventi d'Italia!</h2>
                <hr class="light">
                <p class="text-faded">Camarket is the Big Online Store for All kind of products. We also free delivery all kind of our products as your ordering! So we are always stay-connecting with all customers!</p>
                <p class="text-faded">


                </p>
                <a href="#contact" class="page-scroll btn btn-info btn-xl sr-button">Contattaci</a>
                <a href="<c:url value="/event/eventList"/>" class="page-scroll btn btn-default btn-xl sr-button">Vai agli eventi!</a>
            </div>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/views/template/footer.jsp"%>