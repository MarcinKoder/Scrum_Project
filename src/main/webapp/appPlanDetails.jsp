<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                        <a href="#" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a>
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

                        <c:if test="${recipePlan.getDayNameId} == 1">
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
                                <c:forEach items="${recipePlan.getDayNameId==1}" var="recipe">
                                    <tr class="d-flex">
                                        <td class="col-2">${recipe.getMealName}</td>
                                        <td class="col-7">${recipes.get(recipe.getId)}</td>
                                        <td class="col-1 center">
                                            <a href="#" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                                        </td>
                                        <td class="col-2 center">
                                            <a href="app-details-schedules.html"
                                               class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </c:if>
                    </c:forEach>

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
                        <tr class="d-flex">
                            <td class="col-2">śniadanie</td>
                            <td class="col-7">płatki owsiane z jagodami i komosą ryżową</td>
                            <td class="col-1 center">
                                <a href="#" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                            </td>
                            <td class="col-2 center">
                                <a href="app-details-schedules.html" class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                            </td>
                        </tr>
                        <tr class="d-flex">
                            <td class="col-2">śniadanie</td>
                            <td class="col-7">płatki owsiane z jagodami i komosą ryżową</td>
                            <td class="col-1 center">
                                <a href="#" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                            </td>
                            <td class="col-2 center">
                                <a href="app-details-schedules.html" class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                            </td>
                        </tr>
                        <tr class="d-flex">
                            <td class="col-2">śniadanie</td>
                            <td class="col-7">płatki owsiane z jagodami i komosą ryżową</td>
                            <td class="col-1 center">
                                <a href="#" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                            </td>
                            <td class="col-2 center">
                                <a href="app-details-schedules.html" class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>

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
