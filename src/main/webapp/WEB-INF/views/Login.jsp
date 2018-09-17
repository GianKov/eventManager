<%@include file="/WEB-INF/views/template/header.jsp"%>



<section id="services">
    <div class="container-fluid">
        <div class="col-lg-8 col-lg-offset-2 text-center">
            <h1 class="section-heading">Login</h1>
        </div>
    </div>



    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
        <c:if test="${!(Conferma==null)}"><div class="alert alert-success">${Conferma}</div></c:if>
        <form role="form" action="Log" method=post>
            <hr class="colorgraph">
            <div class="form-group">
                <input type="email" name="inputEmail" id="inputEmail" class="form-control input-lg" placeholder="E-mail" tabindex="3" required>
            </div>
            <div class="form-group">
                <input type="password" name="inputPassword" id="inputPassword" class="form-control input-lg" placeholder="Password" tabindex="4" required>
            </div>
            <div class="forgot">
                <a href="<c:url value="/registrazione"/>">Clicca qui se non sei registrato.</a>
            </div>
            <c:if test="${!(Error==null)}"><div class="alert alert-danger">${Error}</div></c:if>

            <hr class="colorgraph">
            <div class="row">
                <div class="col-md-6 mx-auto"><input type="submit" value="Login" class="btn btn-primary btn-block btn-lg " ></div>
            </div>
        </form>
    </div>
</section>
