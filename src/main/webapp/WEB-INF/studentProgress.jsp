<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Подключаем jstl библиотеки из сайта https://java-online.ru/jsp-jstl.xhtml--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

    <title>StudentProgress</title>

    <!-- подключение шрифтов -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">

    <!-- Подключаем css -->
    <link rel="stylesheet" href="../resources/css/StudentProgress4.css">
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
            <!--    Печатаем строку над таблицей-->
            <h2 class="line1">
                Отображена успеваемость для следующего студента:
            </h2>
        </div>

        <img src="../resources/images/square_pattern%201.png" class="background">
        <img src="../resources/images/square_blur%201.png" class="background1">
        <!--блок с таблицей1-->
        <div class="container">
            <table class="table1">
                <!-- Заголовочная строка таблицы-->
                <thead class="thead1">
                <!--  tr - строка таблицы-->
                <tr>
                    <!--  th- заголовок ячейки таблицы-->
                    <th class="td td1">Фамилия</th>
                    <th class="td td2">Имя</th>
                    <th class="td td3">Группа</th>
                    <th class="td td4">Дата поступления</th>
                </tr>
                </thead>
                <!--tbody - определяет тело таблицы-->
                <tbody class="tbody1">
                <!--  tr - создание строки таблицы-->
                <tr>
                    <!--  td- ячейка таблицы-->
                    <td class="td">${student.surname}</td>
                    <td class="td">${student.name}</td>
                    <td class="td">${student.group}</td>
                    <td class="td"><f:formatDate value="${student.date}" pattern="dd/MM/yyyy"/></td>
                </tr>
                </tbody>
            </table>
        </div>

        <!-- левый блок с таблицей2-->
        <div class="container">
            <table class="table" style="float: left;">
                <!-- Заголовочная строка таблицы-->
                <thead class="thead">
                <!--  tr - строка таблицы-->
                <tr>
                    <!--  th- заголовок ячейки таблицы-->
                    <th class="td">Дисциплина</th>
                    <th class="td">Оценка</th>
                </tr>
                </thead>
                <!--tbody - определяет тело таблицы-->
                <tbody class="tbody">
                <!--  tr - создание строки таблицы-->
                <c:forEach items="${marks}" var="m">
                    <tr>
                        <td class="td">${m.discipline.discipline}</td>
                        <td class="td">${m.mark}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

            <!-- Делаем правый блок -->
            <div class="but" style="float: right;">
                <div class="bot">
                    <p href="#" class="li3">Выбор семестра</p>
                    <form action="/studentProgress" method="get">
                        <input type="hidden" name="hiddenProgressStudent" value="${student.id}">
                        <select name="idSelectTerm" class="li4">
                            <c:forEach items="${terms}" var="t">
                                <c:choose>
                                    <c:when test="${t.id eq selectedTerm.id}">
                                        <option class="check__item txt" value="${t.id}">${t.term}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option class="check__item txt" value="${t.id}">${t.term}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                        <input type="submit" value="Выбрать" class="text">
                    </form>
                </div>
                <p class="li6">Средняя оценка за семестр: ${res} балла</p>
            </div>
        </div>
    </header>
</div>

<%--ПОДКЛЮЧАЕМ JAVA SCRIPT--%>
<script src="../resources/js/functions.js"></script>

</html>
