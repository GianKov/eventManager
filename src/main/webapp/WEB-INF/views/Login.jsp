<%@include file="/WEB-INF/views/template/header.jsp"%>
<html>

<body id="LoginForm">
<div class="container">
    <h1 class="form-heading">login Form</h1>
    <div class="login-form">
        <div class="main-div">
            <div class="panel">
                <h2>Login</h2>
                <p>Please enter your email and password</p>
            </div>
            <form id="Login">

                <div class="form-group">


                    <input type="email" class="form-control" id="inputEmail" placeholder="Email Address">

                </div>

                <div class="form-group">

                    <input type="password" class="form-control" id="inputPassword" placeholder="Password">

                </div>
                <div class="forgot">
                    <a href="<c:url value="/register"/>">Clicca qui se non sei registrato.</a>
                </div>
                <button type="submit" class="btn btn-primary">Login</button>

            </form>
        </div>
    </div></div></div>


</body>
</html>
