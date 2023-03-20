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

    <title>DisciplinesList</title>

    <!-- подключение шрифтов -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">

    <!-- Подключаем css -->
    <link rel="stylesheet" href="../resources/css/DisciplinesList6.css">
</head>

<body>
<header id="header" class="header">

    <!--блок с названием, строкой и логотипом-->
    <div class="container">
        <nav class="nav">

            <!-- Вставляем логотип -->
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
        <!--    Печатаем строку над таблицей-->
        <h2 class="line1">
            Список дисциплин
        </h2>
    </div>

    <img src="../resources/images/square_pattern%201.png" class="background">
    <img src="../resources/images/square_blur%201.png" class="background1">

<div class="container">
    <!--блок с таблицей-->
    <table class="table" style="float: left;">

        <!-- Заголовочная строка таблицы-->
        <thead class="thead">
        <!--  tr - строка таблицы-->
        <tr>
            <!--  th- заголовок ячейки таблицы-->
            <th class="td"></th>
            <th class="td">Наименование дисциплины</th>
        </tr>
        </thead>

        <!--tbody - определяет тело таблицы-->
        <tbody class="tbody">
        <c:forEach items="${allActiveDisciplines}" var="discipline">
            <tr>
                <td class="td-ch">
                    <input type="checkbox" class="check__item" value="${discipline.id}" name="idDiscipline">
                </td>
                <td class="td">${discipline.discipline}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- Делаем кнопки -->
    <div class="buttons">
        <div style="float: right;">
            <a href="/disciplineCreating" class="btn">Создать дисциплину</a>
            <%--          <a href="/disciplinesModifying" class="btn">Модифицировать выбранную дисциплину</a>--%>
            <c:if test="${role eq 1}">
                <input type="submit" value="Модифицировать выбранную дисциплину" class="btn"
                       onclick="modifyDiscipline()">
                <%--        onclick="modifyStudent()" - атрибут функции, прописываемый в JS    --%>
            </c:if>
            <%--          <a href="#" class="btn">Удалить выбранную дисциплину </a>--%>
            <%--           настройка права доступа к кнопке --%>
            <c:if test="${role eq 1}">
                <input type="submit" value="Удалить выбранную дисциплину" class="btn"
                       onclick="deleteDiscipline()">
                <%--        onclick="deleteDiscipline()" - атрибут функции, прописываемый в JS    --%>
            </c:if>
        </div>
    </div>
</div>
</header>


<%--Форма для удаления дисциплин--%>
<form action="/disciplineDelete" method="post" id="formDelete">
    <input type="hidden" value="" name="hiddenDelete" id="hiddenDelete">
</form>

<%--Форма для модификации дисциплин--%>
<form action="/disciplinesModifying" method="get" id="formModify">
    <input type="hidden" value="" name="hiddenModify" id="hiddenModify">
</form>

</body>

<%--ПОДКЛЮЧАЕМ JAVA SCRIPT--%>
<script src="../resources/js/functions.js"></script>

</html>