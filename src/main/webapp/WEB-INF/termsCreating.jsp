
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--Подключаем jstl библиотеки из сайта https://java-online.ru/jsp-jstl.xhtml--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Описание страницы для поисковиков не более 160 символов">
    <meta name="keywords" content="ключевые слова или фразы для поисковых машин и систем, пишутся через запятую">

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

    <title>TermsCreating</title>

    <!-- подключение шрифтов -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">

    <!-- Подключаем css -->
    <link rel="stylesheet" href="../resources/css/TermsCreating10.css">
</head>

<body>
<div class="container">
    <nav class="nav">
        <img src="../resources/images/logo.png" alt="EasyUm">

        <!-- Пункты меню -->
        <ul class="menu">
            <li>
                <!-- Превращаем в ссылку -->
                <!-- # - указывается ссылка для перехода-->
                <a href="/index.jsp" class="menu__item menu__item_active a">На главную </a>
            </li>
            <li>
                <a href="/termsList" class="menu__item menu__item_active b">Назад </a>
            </li>
        </ul>
        <ul class="menu1">
            <li>  <!-- Делаем ссылку -->
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
    <h1 class="name">
        Система управления студентами и их успеваемостью
    </h1>
    <!--    Печатаем строку над таблицей-->
    <h2 class="line">
        Для создания семестра заполните следующие данные и нажмите кнопу "Создать"
    </h2>
</div>
<img src="../resources/images/square_pattern%201.png" class="background">
<img src="../resources/images/square_blur%201.png" class="background1">

<div class="container">
    <ul class="bot">
        <li class="li1">
            <a>Длительность (в неделях)</a>
        </li>
        <li>
            <a class="b1" href="#">24</a>
        </li>
    </ul>
</div>
</div>
<div class="container">

    <ul class="bot">
        <li class="li2">
            <a>Дисциплины в семестре</a>
        </li>


        <div  class="li3 text">
            <a href="#"><p>Информатика</p></a>
            <a href="#"><p>Политология</p></a>
            <a href="#"><p>Социология</p></a>
            <a href="#"><p>Высшая Математика</p></a>
            <a href="#"><p>Теория Алгоритмизации</p></a>
            <a href="#"><p>Теория Игр</p></a>
            <a href="#"><p>Булева Алгебра</p></a>
            <a href="#"><p>Системный анализ</p></a>
        </div>

<%--        <tbody class="tbody">--%>
<%--        <div  class="li3 text">--%>
<%--        <c:forEach items="${disciplines}" var="d">--%>
<%--            <tr>--%>
<%--                <td class="td">${d.discipline}</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--        </div>--%>
<%--        </tbody>--%>


    </ul>


    <div class="li5">
        <a href="#" class="b2">СОЗДАТЬ</a>
    </div>
</div>

</body>
</html>
