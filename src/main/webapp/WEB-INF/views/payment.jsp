<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<section id="services">
    <div class="container-fluid">
        <div class="col-lg-8 col-lg-offset-2 text-center">
            <h1 class="section-heading">Finalizza il pagamento!</h1>
        </div>
    </div>
<div class="container wrapper">
    <div class="row cart-head">
        <div class="container">
            <div class="row">
                <p></p>
            </div>
            <div class="row">
                <p></p>
            </div>
        </div>
    </div>
    <div class="row cart-body">
        <form class="form-horizontal" method="post" action="<c:url value="/payment/rng"/>">
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-md-push-6 col-sm-push-6">
                <!--REVIEW ORDER-->
                <div class="panel panel-info">
                    <div class="panel-heading">
                        Resoconto Carrello <div class="pull-right"><small><a class="afix-1" href="<c:url value="/cart/getCart"/>">Modifica Ordine</a></small></div>
                    </div>
                    <div class="panel-body">
                        <c:forEach items="${Summary}" var="summary">
                        <div class="form-group">
                            <div class="col-sm-6 col-xs-6">
                                <div class="col-xs-12">${summary.eventName}-${summary.secName}<br>${summary.place} ${summary.date} </div>
                            </div>
                            <div class="col-sm-3 col-xs-3 text-right">
                                <h6><span>$</span>${summary.price}</h6>
                            </div>

                        </div>
                        <div class="form-group"><hr /></div>
                        </c:forEach>
                        <div class="form-group">
                            <div class="col-xs-12">
                                <strong>Totale Ordine</strong>
                                <div class="pull-right">$<span></span><span>${Total}</span></div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--REVIEW ORDER END-->
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-md-pull-6 col-sm-pull-6">

                <!--SHIPPING METHOD END-->
                <!--CREDIT CART PAYMENT-->
                <div class="panel panel-info">
                    <div class="panel-heading"><span><i class="glyphicon glyphicon-lock"></i></span> Pagamento Sicuro</div>
                    <div class="panel-body">
                        <div class="form-group">
                            <div class="col-md-12"><strong>Tipo di carta:</strong></div>
                            <div class="col-md-12">
                                <select id="CreditCardType" name="CreditCardType" class="form-control" required>
                                    <option value="5">Visa</option>
                                    <option value="6">MasterCard</option>
                                    <option value="7">American Express</option>
                                    <option value="8">Discover</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12"><strong>Numero Carta di Credito</strong></div>
                            <div class="col-md-12"><input type="text" class="form-control" name="car_number" value="" required/></div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12"><strong>CVV Carta:</strong></div>
                            <div class="col-md-12"><input type="text" class="form-control" name="car_code" value="" required/></div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <strong>Scadenza</strong>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <select class="form-control" name="" required>
                                    <option value="">Mese</option>
                                    <option value="01">01</option>
                                    <option value="02">02</option>
                                    <option value="03">03</option>
                                    <option value="04">04</option>
                                    <option value="05">05</option>
                                    <option value="06">06</option>
                                    <option value="07">07</option>
                                    <option value="08">08</option>
                                    <option value="09">09</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                </select>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <select class="form-control" name="" required>
                                    <option value="">Anno</option>
                                    <option value="2015">2015</option>
                                    <option value="2016">2016</option>
                                    <option value="2017">2017</option>
                                    <option value="2018">2018</option>
                                    <option value="2019">2019</option>
                                    <option value="2020">2020</option>
                                    <option value="2021">2021</option>
                                    <option value="2022">2022</option>
                                    <option value="2023">2023</option>
                                    <option value="2024">2024</option>
                                    <option value="2025">2025</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <button type="submit" class="btn btn-primary btn-submit-fix">Compra</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!--CREDIT CART PAYMENT END-->
            </div>

        </form>
    </div>
    <div class="row cart-footer">

    </div>
</div>
</section>