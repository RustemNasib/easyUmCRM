<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--Подключаем jstl библиотеки из сайта https://java-online.ru/jsp-jstl.xhtml--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
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


    <title>StudentList</title>

    <!-- подключение шрифтов -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <!-- Подключаем css -->
    <link rel="stylesheet" href="../resources/css/StudentsList1.css">

</head>

<body>
<header id="header" class="header">
    <div class="container">
        <nav class="nav">
            <!-- Вставляем логотип -->
            <img src="../resources/images/logo.png" alt="EasyUm">

            <!-- Пункты меню -->
            <ul class="menu">
                <li>
                    <a href="/index.jsp" class="menu__item menu__item_active">На главную </a>
                </li>
                <li>
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
        <h1>
            Система управления студентами и их успеваемостью
        </h1>
    </div>

    <img src="../resources/images/square_pattern%201.png" class="background">
    <img src="../resources/images/square_blur%201.png" class="background1">

    <!-- Делаем кнопки -->
    <div class="container buttons">
        <div>
<%--            <a href="/studentProgress" class="btn">Просмотреть успеваемость выбранного студента </a>--%>
    <input type="submit" value="Просмотреть успеваемость выбранного студента" class="btn" onclick="idProgressStudent()">
            <%--            <a href="/studentModifying" class="btn">Модифицировать выбранного студента...</a>--%>
            <%--           настройка права доступа к кнопке --%>
            <c:if test="${role eq 1}">
                <input type="submit" value="Модифицировать выбранного студента" class="btn" onclick="modifyStudent()">
                <%--        onclick="modifyStudent()" - атририбут функции, прописываемый в JS    --%>
            </c:if>
        </div>
        <div>
            <%--           настройка права доступа к кнопке --%>
            <c:if test="${role eq 1}">
                <a href="/studentCreating" class="btn">Создать студента... </a>
                <%--            <a href="#" class="btn">Удалить выбранных студентов</a>--%>
            </c:if>
            <%--           настройка права доступа к кнопке --%>
            <c:if test="${role eq 1}">
                <input type="submit" value="Удалить выбранных студентов" class="btn" onclick="deleteStudents()">
                <%--        onclick="deleteStudents()" - атририбут функции, прописываемый в JS    --%>
            </c:if>
        </div>
    </div>
</header>

<section id="section" class="section">
    <div class="container">
        <h2>Список студентов</h2>

        <table class="table">

            <thead>

            <tr>
                <!--  th- заголовок ячейки таблицы-->
                <th class="td"></th>
                <th class="td">Фамилия</th>
                <th class="td">Имя</th>
                <th class="td">Группа</th>
                <th class="td">Дата поступления</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${allActiveStudents}" var="student">
                <tr>
                    <td class="td-ch">
                        <input type="checkbox" class="check__item" value="${student.id}" name="idStudent">
                    </td>
                    <td class="td">${student.surname}</td>
                    <td class="td">${student.name}</td>
                    <td class="td">${student.group}</td>
                        <%--Изменили формат вводимой даты на клиента--%>
                    <td class="td"><f:formatDate value="${student.date}" pattern="dd/MM/yyyy"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>

<%--Форма для удаления студентов--%>
<%--/studentDelete urlPattern в контроллере--%>
<form action="/studentDelete" method="post" id="formDelete">
    <input type="hidden" value="" name="hiddenDelete" id="hiddenDelete">
</form>

<%--Форма для модификации студента--%>
<form action="/studentModifying" method="get" id="formModify">
    <input type="hidden" value="" name="hiddenModify" id="hiddenModify">
</form>

<%--Форма для передачи id студента на страницу прогресса студентов--%>
<form action="/studentProgress" method="get" id="formProgressStudent">
    <input type="hidden" value="" name="hiddenProgressStudent" id="hiddenProgressStudent">
</form>

</body>
<%--ПОДКЛЮЧАЕМ JAVA SCRIPT--%>
<script src="../resources/js/functions.js"></script>

</html>
