<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">


<body>

<%@include file="headerAfterLogin.jsp" %>

<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <%@include file="leftPanel.jsp" %>

        <div class="m-4 p-3 width-medium ">
            <div class="dashboard-content border-dashed p-3 m-4">
                <div class="row border-bottom border-3 p-1 m-1">
                    <div class="col noPadding">
                        <h3 class="color-header text-uppercase">SZCZEGÓŁY PLANU</h3>
                    </div>
                    <div class="col d-flex justify-content-end mb-2 noPadding">
                        <a href="list" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a>
                    </div>
                </div>

                <div class="schedules-content">
                    <div class="schedules-content-header">
                        <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    Nazwa planu
                                </span>
                            <div class="col-sm-10">
                                <p class="schedules-text">${namePlan}</p>
                            </div>
                        </div>
                        <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    Opis planu
                                </span>
                            <div class="col-sm-10">
                                <p class="schedules-text">
                                    ${planDescription}
                                </p>
                            </div>
                        </div>
                    </div>
                    <c:set var="day" value="poniedziałek"/>
                    <c:forEach items="${recipePlan}" var="recipe">
                        <c:if test="${day=='poniedziałek' && recipe.dayName=='poniedziałek'}">
                            <table class="table">
                                <thead>
                                <tr class="d-flex">
                                    <th class="col-2">Poniedziałek</th>
                                    <th class="col-7"></th>
                                    <th class="col-1"></th>
                                    <th class="col-2"></th>
                                </tr>
                                </thead>
                                <tbody class="text-color-lighter">
                                <c:forEach items="${recipePlan}" var="recipe1">
                                    <c:if test="${recipe1.dayName=='poniedziałek'}">
                                        <tr class="d-flex">
                                            <td class="col-2">${recipe1.mealName}</td>
                                            <td class="col-7">${recipe1.recipeName}</td>
                                            <td class="col-1 center">
                                                <a href="#" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                                            </td>
                                            <td class="col-2 center">
                                                <a href="/app/recipe/details?id=${recipe1.recipeId}"
                                                   class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>

                                </tbody>
                            </table>
                            <c:set var="day" value="wtorek" />
                        </c:if>

                        <c:if test="${day=='wtorek' && recipe.dayName=='wtorek'}">
                            <table class="table">
                                <thead>
                                <tr class="d-flex">
                                    <th class="col-2">Wtorek</th>
                                    <th class="col-7"></th>
                                    <th class="col-1"></th>
                                    <th class="col-2"></th>
                                </tr>
                                </thead>
                                <tbody class="text-color-lighter">
                                <c:forEach items="${recipePlan}" var="recipe1">
                                    <c:if test="${recipe1.dayName=='wtorek'}">
                                        <tr class="d-flex">
                                            <td class="col-2">${recipe1.mealName}</td>
                                            <td class="col-7">${recipe1.recipeName}</td>
                                            <td class="col-1 center">
                                                <a href="#" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                                            </td>
                                            <td class="col-2 center">
                                                <a href="/app/recipe/details?id=${recipe1.recipeId}"
                                                   class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>

                                </tbody>
                            </table>
                            <c:set var="day" value="środa" />
                        </c:if>

                        <c:if test="${day=='środa' && recipe.dayName=='środa'}">
                            <table class="table">
                                <thead>
                                <tr class="d-flex">
                                    <th class="col-2">Środa</th>
                                    <th class="col-7"></th>
                                    <th class="col-1"></th>
                                    <th class="col-2"></th>
                                </tr>
                                </thead>
                                <tbody class="text-color-lighter">
                                <c:forEach items="${recipePlan}" var="recipe1">
                                    <c:if test="${recipe1.dayName=='środa'}">
                                        <tr class="d-flex">
                                            <td class="col-2">${recipe1.mealName}</td>
                                            <td class="col-7">${recipe1.recipeName}</td>
                                            <td class="col-1 center">
                                                <a href="#" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                                            </td>
                                            <td class="col-2 center">
                                                <a href="/app/recipe/details?id=${recipe1.recipeId}"
                                                   class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>

                                </tbody>
                            </table>
                            <c:set var="day" value="czwartek" />
                        </c:if>

                        <c:if test="${day=='czwartek' && recipe.dayName=='czwartek'}">
                            <table class="table">
                                <thead>
                                <tr class="d-flex">
                                    <th class="col-2">Czwartek</th>
                                    <th class="col-7"></th>
                                    <th class="col-1"></th>
                                    <th class="col-2"></th>
                                </tr>
                                </thead>
                                <tbody class="text-color-lighter">
                                <c:forEach items="${recipePlan}" var="recipe1">
                                    <c:if test="${recipe1.dayName=='czwartek'}">
                                        <tr class="d-flex">
                                            <td class="col-2">${recipe1.mealName}</td>
                                            <td class="col-7">${recipe1.recipeName}</td>
                                            <td class="col-1 center">
                                                <a href="#" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                                            </td>
                                            <td class="col-2 center">
                                                <a href="/app/recipe/details?id=${recipe1.recipeId}"
                                                   class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>

                                </tbody>
                            </table>
                            <c:set var="day" value="piątek" />
                        </c:if>

                        <c:if test="${day=='piątek' && recipe.dayName=='piątek'}">
                            <table class="table">
                                <thead>
                                <tr class="d-flex">
                                    <th class="col-2">Piątek</th>
                                    <th class="col-7"></th>
                                    <th class="col-1"></th>
                                    <th class="col-2"></th>
                                </tr>
                                </thead>
                                <tbody class="text-color-lighter">
                                <c:forEach items="${recipePlan}" var="recipe1">
                                    <c:if test="${recipe1.dayName=='piątek'}">
                                        <tr class="d-flex">
                                            <td class="col-2">${recipe1.mealName}</td>
                                            <td class="col-7">${recipe1.recipeName}</td>
                                            <td class="col-1 center">
                                                <a href="#" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                                            </td>
                                            <td class="col-2 center">
                                                <a href="/app/recipe/details?id=${recipe1.recipeId}"
                                                   class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>

                                </tbody>
                            </table>
                            <c:set var="day" value="sobota" />
                        </c:if>

                        <c:if test="${day=='sobota' && recipe.dayName=='sobota'}">
                            <table class="table">
                                <thead>
                                <tr class="d-flex">
                                    <th class="col-2">Sobota</th>
                                    <th class="col-7"></th>
                                    <th class="col-1"></th>
                                    <th class="col-2"></th>
                                </tr>
                                </thead>
                                <tbody class="text-color-lighter">
                                <c:forEach items="${recipePlan}" var="recipe1">
                                    <c:if test="${recipe1.dayName=='sobota'}">
                                        <tr class="d-flex">
                                            <td class="col-2">${recipe1.mealName}</td>
                                            <td class="col-7">${recipe1.recipeName}</td>
                                            <td class="col-1 center">
                                                <a href="#" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                                            </td>
                                            <td class="col-2 center">
                                                <a href="/app/recipe/details?id=${recipe1.recipeId}"
                                                   class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>

                                </tbody>
                            </table>
                            <c:set var="day" value="niedziela" />
                        </c:if>

                        <c:if test="${day=='niedziela' && recipe.dayName=='niedziela'}">
                            <table class="table">
                                <thead>
                                <tr class="d-flex">
                                    <th class="col-2">Niedziela</th>
                                    <th class="col-7"></th>
                                    <th class="col-1"></th>
                                    <th class="col-2"></th>
                                </tr>
                                </thead>
                                <tbody class="text-color-lighter">
                                <c:forEach items="${recipePlan}" var="recipe1">
                                    <c:if test="${recipe1.dayName=='niedziela'}">
                                        <tr class="d-flex">
                                            <td class="col-2">${recipe1.mealName}</td>
                                            <td class="col-7">${recipe1.recipeName}</td>
                                            <td class="col-1 center">
                                                <a href="#" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                                            </td>
                                            <td class="col-2 center">
                                                <a href="/app/recipe/details?id=${recipe1.recipeId}"
                                                   class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>

                                </tbody>
                            </table>
                            <c:set var="day" value="" />
                        </c:if>

                    </c:forEach>



                </div>
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
<%@include file="footer.jsp" %>

</body>
</html>
