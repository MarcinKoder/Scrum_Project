<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Dashboard</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="<c:url value="css/style.css"/>" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <%--ikonki budzika, ptaszka, facebooka etc.--%>
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
</head>
<body>
<%@include file="headerAfterLogin.jsp" %>

<section class="dashboard-section">
    <div class="row dashboard-nowrap">
      <jsp:include page="leftPanel.jsp"/>
        <div class="m-4 p-4 width-medium">
            <div class="dashboard-header m-4">
                <div class="dashboard-menu">
                    <div class="menu-item border-dashed">
                        <a href="/app/recipe/add">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">dodaj przepis</span>
                        </a>
                    </div>
                    <div class="menu-item border-dashed">
                        <a href="/app/plan/add">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">dodaj plan</span>
                        </a>
                    </div>
                    <div class="menu-item border-dashed">
                        <a href="/app/recipe/plan/add">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">dodaj przepis do planu</span>
                        </a>
                    </div>
                </div>
                <div class="dashboard-alerts">
                    <div class="alert-item alert-info">
                        <i class="fas icon-circle fa-info-circle"></i>
                        <span class="font-weight-bold">Liczba dodanych przepisów: <c:out
                                value="${sessionScope.recipes}"/></span>
                    </div>
                    <div class="alert-item alert-light">
                        <i class="far icon-calendar fa-calendar-alt"></i>
                        <span class="font-weight-bold">Liczba dodanych planów: <c:out
                                value="${sessionScope.plans}"/></span>
                    </div>
                </div>
            </div>
            <div class="m-4 p-4 border-dashed">
                <h2 class="dashboard-content-title">
                    <span>Ostatnio dodany plan:</span> ${sessionScope.lastAddedPlanName}
                </h2>
                <c:forEach var="plan" items="${sessionScope.recipePlans}" varStatus="loop">
                    <table class="table">
                        <c:choose>
                            <c:when test="${loop.first}">
                                <thead>
                                <tr class="d-flex">
                                    <th class="col-2">${fn:toUpperCase(fn:substring(plan.dayName.name, 0, 1))}${fn:toLowerCase(fn:substring(plan.dayName.name, 1,fn:length(plan.dayName.name)))}</th>
                                    <th class="col-8"></th>
                                    <th class="col-2"></th>
                                </tr>
                                </thead>
                            </c:when>
                            <c:otherwise>
                                <c:if test="${sessionScope.recipePlans[loop.index-1].dayName.id != plan.dayName.id}">
                                    <thead>
                                    <tr class="d-flex">
                                        <th class="col-2">${fn:toUpperCase(fn:substring(plan.dayName.name, 0, 1))}${fn:toLowerCase(fn:substring(plan.dayName.name, 1,fn:length(plan.dayName.name)))}</th>
                                        <th class="col-8"></th>
                                        <th class="col-2"></th>
                                    </tr>
                                    </thead>
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                        <tbody>
                        <tr class="d-flex">
                            <td class="col-2">${plan.mealName}</td>
                            <td class="col-8">${plan.recipe.name}</td>
                            <td class="col-2">
                                <a href="/recipe/details?id=${plan.recipe.id}"
                                   class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </c:forEach>
            </div>
        </div>
    </div>
</section>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>
