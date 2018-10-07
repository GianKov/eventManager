<%--<div class="container">
    <div class="col-lg-8 col-lg-offset-2 text-center">
        <h1 class="section-heading">Gli ultimi eventi!</h1>
    </div>
    <br/><br/><br/>
    <div class="row">

        <div class="col-md-4">
            <figure class="card card-product">
                <div class="img-wrap"><img src="<c:url value="/resources/img/eventImages/1.png" />" class="img-responsive" alt=""></div>
                <figcaption class="info-wrap">
                    <h4 class="title">CREMONINI</h4>
                    <p class="desc">Some small description goes here</p>
                </figcaption>
                <div class="bottom-wrap">
                    <form action="<c:url value="/event/description"/>" method="POST">
                        <input type="hidden" id="id" name="id" value="1">
                        <input type="submit" value="PARTECIPA ORA!" class="btn btn-sm btn-primary float-right"></a>
                    </form>
                </div> <!-- bottom-wrap.// -->
            </figure>
        </div> <!-- col // -->

        <div class="col-md-4">
            <figure class="card card-product">
                <div class="img-wrap"><img src="<c:url value="/resources/img/eventImages/2.png" />" class="img-responsive" alt=""></div>
                <figcaption class="info-wrap">
                    <h4 class="title">EXPO</h4>
                    <p class="desc">La manifestazione mondiale più importante dell'anno!</p>
                </figcaption>
                <div class="bottom-wrap">
                    <form action="<c:url value="/event/description"/>" method="POST">
                        <input type="hidden" id="id" name="id" value="2">
                        <input type="submit" value="PARTECIPA ORA!" class="btn btn-sm btn-primary float-right"></a>
                    </form>
                </div> <!-- bottom-wrap.// -->
            </figure>
        </div> <!-- col // -->

        <div class="col-md-4">
            <figure class="card card-product">
                <div class="img-wrap"><img src="<c:url value="/resources/img/eventImages/3.png" />" class="img-responsive" alt=""></div>
                <figcaption class="info-wrap">
                    <h4 class="title">SERIE A NAPOLI-ROMA</h4>
                    <p class="desc">Una delle partite più importanti dell'anno!</p>
                </figcaption>
                <div class="bottom-wrap">
                    <form action="<c:url value="/event/description"/>" method="POST">
                        <input type="hidden" id="id" name="id" value="3">
                        <input type="submit" value="PARTECIPA ORA!" class="btn btn-sm btn-primary float-right"></a>
                    </form>
                </div> <!-- bottom-wrap.// -->
            </figure>
        </div> <!-- col // -->



    </div> <!-- row.// -->

</div>--%>


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
                            <input type="hidden" id="id" name="id" value="1">
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


<br/><br/><br/>
