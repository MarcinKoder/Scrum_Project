<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Zaplanuj Jedzonko</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">  <%--ikonki budzika, ptaszka, facebooka etc.--%>
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">                                                                                                                                                                                 <%--Czcionka ikonki Zaplanuj jedzonka--%>
</head>
<body>
<header class="page-header">
    <nav class="navbar navbar-expand-lg justify-content-between">
        <a href="/HomeServlet" class="navbar-brand main-logo main-logo-smaller">
            Zaplanuj <span>Jedzonko</span>
        </a>
        <div class="d-flex justify-content-around">
            <h4 class="text-light mr-3"><c:out value="${sessionScope.firstName}"/></h4>
            <%--<div class="circle-div text-center"><i class="fas fa-user icon-user"></i></div>--%>
            <a class="circle-div text-center" href="/logout" title="Wyloguj się"><i class="fas fa-user icon-user"></i></a>
        </div>
    </nav>
</header>
</body>
</html>
