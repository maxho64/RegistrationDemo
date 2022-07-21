<%--@elvariable id="message" type="java.lang.String"--%>
<%--@elvariable id="color" type="java.lang.String"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            rel="stylesheet"
    />
    <!-- Google Fonts -->
    <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
    />
    <!-- MDB -->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.2.0/mdb.min.css"
            rel="stylesheet"
    />
</head>
<body>


<div class="d-flex justify-content-center">
    <div>
        <!-- Pills navs -->
        <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
            <li class="nav-item" role="presentation">
                <a class="nav-link active" id="tab-login" data-mdb-toggle="pill" href="#pills-login" role="tab"
                   aria-controls="pills-login" aria-selected="true">Login</a>
            </li>
            <li class="nav-item" role="presentation">
                <a class="nav-link" id="tab-register" data-mdb-toggle="pill" href="#pills-register" role="tab"
                   aria-controls="pills-register" aria-selected="false">Register</a>
            </li>
        </ul>
        <!-- Pills navs -->

        <!-- Pills content -->
        <div class="tab-content">
            <div class="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="tab-login">
                <c:url var="login" value = "/login"/>
                <form:form action="${login}" modelAttribute="userLoginDto" method="post">
                    <div class="text-center mb-3">
                        <p>Sign in with:</p>
                        <button type="button" class="btn btn-link btn-floating mx-1">
                            <i class="fab fa-facebook-f"></i>
                        </button>

                        <button type="button" class="btn btn-link btn-floating mx-1">
                            <i class="fab fa-google"></i>
                        </button>

                        <button type="button" class="btn btn-link btn-floating mx-1">
                            <i class="fab fa-twitter"></i>
                        </button>

                        <button type="button" class="btn btn-link btn-floating mx-1">
                            <i class="fab fa-github"></i>
                        </button>
                    </div>

                    <p class="text-center">or:</p>

                    <!-- Email input -->
                    <div class="form-outline mb-4">
                        <form:input type="email" id="loginName" path="loginEmail" cssClass="form-control"/>
                        <form:label cssClass="form-label" path="loginEmail">Email or username</form:label>
                    </div>
                    <form:errors path="loginEmail" cssClass="text-danger"/>
                    <!-- Password input -->
                    <div class="form-outline mb-4">
                        <form:input type="password" id="loginPassword" path="loginPassword" cssClass="form-control"/>
                        <form:label cssClass="form-label" path="loginPassword">Password</form:label>
                    </div>
                    <form:errors path="loginPassword" cssClass="text-danger"/>
                    <!-- 2 column grid layout -->
                    <div class="row mb-4">
                        <div class="col-md-6 d-flex justify-content-center">
                            <!-- Checkbox -->
                            <div class="form-check mb-3 mb-md-0">
                                <input class="form-check-input" type="checkbox" value="" id="loginCheck" checked/>
                                <label class="form-check-label" for="loginCheck"> Remember me </label>
                            </div>
                        </div>

                        <div class="col-md-6 d-flex justify-content-center">
                            <!-- Simple link -->
                            <a href="#!">Forgot password?</a>
                        </div>
                    </div>

                    <!-- Submit button -->
                    <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>

                    <!-- Register buttons -->
                    <div class="text-center">
                        <p>Not a member? <a href="#!">Register</a></p>
                    </div>
                </form:form>
            </div>
            <div class="tab-pane fade" id="pills-register" role="tabpanel" aria-labelledby="tab-register">
                <c:url var="register" value = "/register"/>
                <form:form action="${register}" modelAttribute="userRegisterDto" method="post">
                    <div class="text-center mb-3">
                        <p>Sign up with:</p>
                        <button type="button" class="btn btn-link btn-floating mx-1">
                            <i class="fab fa-facebook-f"></i>
                        </button>

                        <button type="button" class="btn btn-link btn-floating mx-1">
                            <i class="fab fa-google"></i>
                        </button>

                        <button type="button" class="btn btn-link btn-floating mx-1">
                            <i class="fab fa-twitter"></i>
                        </button>

                        <button type="button" class="btn btn-link btn-floating mx-1">
                            <i class="fab fa-github"></i>
                        </button>
                    </div>

                    <p class="text-center">or:</p>

                    <!-- Name input -->
                    <div class="form-outline mb-4">
                        <form:input type="text" id="registerName" path="name"  cssClass="form-control"/>
                        <form:label cssClass="form-label" path="name">Name</form:label>
                    </div>
                    <form:errors path="name" cssClass="text-danger"/>
                    <!-- Username input -->
                    <div class="form-outline mb-4">
                        <form:input type="text" id="registerUsername" path="login" cssClass="form-control"/>
                        <form:label cssClass="form-label" path="login">Username</form:label>
                    </div>
                    <form:errors path="login" cssClass="text-danger"/>
                    <!-- Email input -->
                    <div class="form-outline mb-4">
                        <form:input type="email" id="registerEmail" path="email" cssClass="form-control"/>
                        <form:label cssClass="form-label" path="email">Email</form:label>
                    </div>
                    <form:errors path="email" cssClass="text-danger"/>
                    <!-- Password input -->
                    <div class="form-outline mb-4">
                        <form:input type="password" id="registerPassword" path="password" cssClass="form-control"/>
                        <form:label cssClass="form-label" path="password">Password</form:label>
                    </div>
                    <form:errors path="password" cssClass="text-danger"/>
                    <!-- Repeat Password input -->
                    <div class="form-outline mb-4">
                        <form:input type="password" id="registerRepeatPassword" path="repeatPassword"  class="form-control"/>
                        <form:label class="form-label" path="repeatPassword">Repeat password</form:label>
                    </div>
                    <form:errors path="repeatPassword" cssClass="text-danger"/>
                    <!-- Checkbox -->
                    <div class="form-check d-flex justify-content-center mb-4">
                        <input class="form-check-input me-2" type="checkbox" value="" id="registerCheck" checked
                               aria-describedby="registerCheckHelpText"/>
                        <label class="form-check-label" for="registerCheck">
                            I have read and agree to the terms
                        </label>
                    </div>

                    <!-- Submit button -->
                    <button type="submit" class="btn btn-primary btn-block mb-3">Sign in</button>
                </form:form>
            </div>
        </div>
        <strong style="color: ${color}">${message}</strong>
    </div></div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
<script
        type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.2.0/mdb.min.js"
></script>
</body>
</html>