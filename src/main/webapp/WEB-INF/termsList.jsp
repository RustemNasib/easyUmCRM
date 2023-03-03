<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--Подключаем jstl библиотеки из сайта https://java-online.ru/jsp-jstl.xhtml--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Описание страницы для поисковиков не более 160 символов">
    <meta name="keywords" content="ключевые слова или фразы для поисковых машин и систем, пишутся через запяую">

    <!--Устанавливаем фавикон - это ярлык возле названия страницы-->
    <!-- favicon 16x16 32x32 64x64 формат png -->
    <link rel="icon" type='image/png' href="../resources/images/favicon_easyUm.png">

    <!-- OG метки это (Open Graf) миниатюра сайта для соц сетей и мессенджеров,
    пример: https://auto.ru/cars/used/sale/ram/1500/1117314846-ddc10bf3/?from=searchline-->

    <meta property="og:title" content="EasyUm CRM">
    <meta property="og:description"
          content="Описание страницы слайда выпадающая в поисковых страницах не более 160 символов">
    <meta property="og:type" content="article">
    <meta property="og:image" content="https://it.easyum.ru/wp-content/uploads/2018/11/home_top_img.png">
    <meta property="og:site_name" content="EasyUm CRM">

    <title>TermsList</title>

    <!-- подключение шрифтов -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">

    <!-- Подключаем css -->
    <link rel="stylesheet" href="../resources/css/TermsList9.css">
</head>

<div>
    <header id="header" class="header">
        <!--блок с названием, строкой и логотипом-->
        <div class="container">
            <nav class="nav">
                <img src="../resources/images/logo.png" alt="EasyUm">

                <!-- Пункты меню -->
                <ul class="menu">
                    <li class="li1">
                        <!-- Превращаем в ссылку -->
                        <!-- # - указывается ссылка для перехода-->
                        <a href="/index.jsp" class="menu__item menu__item_active">На главную </a>
                    </li>
                    <li class="li2">  <!-- Делаем ссылку -->
                        <c:choose>
                            <c:when test="${isLogin eq true}">
                                <a href="/logout" class="menu__item menu__item_active">Logout </a>
                            </c:when>
                            <c:otherwise>
                                <a href="/login" class="menu__item menu__item_active">Login </a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                </ul>
            </nav>
            <!--Печатаем название-->
            <h1 class="table name">
                Система управления студентами и их успеваемостью
            </h1>
            <img src="../resources/images/square_pattern%201.png" class="background">
            <img src="../resources/images/square_blur%201.png" class="background1">

            <!-- Делаем блок -->
            <div class="but mt10 test">
                <form action="termsList" method="get">
                    <div class="bot df jcsb">
                        <div>
                            <select name="idSelectedTerm" class="field-select select">
                                <c:forEach items="${terms}" var="t">
                                    <c:choose>
                                        <c:when test="${t.id eq selectedTerm.id}">
                                            <option selected value="${t.id}">${t.term}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${t.id}">${t.term}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>

                            </select>
                            <p class="li6">Длительность семестра: ${selectedTerm.duration}</p>
                        </div>
                        <%--                    <a href="#" class="li3">Выбрать семестр</a>--%>
                        <%--                    <a href="#" class="text">ПРИМЕНИТЬ</a>--%>
                        <input type="submit" value="Выбрать семестр" class="btn buttons term text">

                    </div>
                </form>

            </div>

            <!--    Печатаем строку над таблицей-->
            <h2 class="line1">
                Список дисциплин семестра
            </h2>

            <!--блок с таблицей-->
            <table class="table" style="float: left;">
                <!-- Заголовочная строка таблицы-->
                <thead class="thead">
                <!--  tr - строка таблицы-->
                <tr>
                    <!--  th- заголовок ячейки таблицы-->
                    <th class="td">Наименование дисциплины</th>
                </tr>
                </thead>
                <!--tbody - определяет тело таблицы-->
                <tbody class="tbody">
                <!--  tr - создание строки таблицы-->
                <c:forEach items="${disciplines}" var="d">
                    <tr>
                        <td class="td">${d.discipline}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

            <!-- Делаем кнопки -->
            <div class="buttons">
                <div style="float: right;">
                    <a href="/termsCreating" methods="get" class="btn">Создать семестр...</a>
<%--                    <a href="/termsModifying" methods="get" class="btn">Модифицировать текущий семестр...</a>--%>
<%--                    <input type="submit" value="Модифицировать текущий семестр..." class="btn" onclick="modifyTerms()">--%>
                    <c:if test="${role eq 1}">
                        <input type="submit" value="Модифицировать выбранного студента" class="btn" onclick="modifyTerms()">
                        <%--        onclick="modifyStudent()" - атририбут функции, прописываемый в JS    --%>
                    </c:if>

                    <%--                    <a href="#" class="btn">Удалить текущий семестр...</a>--%>
                    <c:if test="${role eq 1}">
                        <input type="submit" value="Удалить текущий семестр" class="btn" onclick="deleteTerms()">
                        <%--        onclick="deleteStudents()" - атририбут функции, прописываемый в JS    --%>
                    </c:if>
                </div>
            </div>

        </div>
    </header>
</div>
<%--Форма для удаления семестра--%>
<form action="/termsDelete" method="post" id="formDelete">
    <input type="hidden" value="" name="hiddenDelete" id="hiddenDelete">
</form>

<%--Форма для модификации семестра--%>
<form action="/termsModifying" method="get" id="formModify">
    <input type="hidden" value="" name="hiddenModify" id="hiddenModify">
</form>

<%--ПОДКЛЮЧАЕМ JAVA SCRIPT--%>
<script src="../resources/js/functions.js"></script>

</html>
