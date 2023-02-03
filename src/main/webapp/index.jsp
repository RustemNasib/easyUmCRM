
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Описание страницы для поисковиков не более 160 символов">
    <meta name="keywords" content="ключевые слова или фразы для поисковых машин и систем, пишутся через запяую">

    <!--Устанавливаем фавикон - это ярлык возле названия страницы-->
    <!-- favicon 16x16 32x32 64x64 формат png -->
    <link rel="icon" type='image/png' href="resources/images/favicon_easyUm.png">

    <!-- OG метки это (Open Graf) миниатюра сайта для соц сетей и мессенджеров,
    пример: https://auto.ru/cars/used/sale/ram/1500/1117314846-ddc10bf3/?from=searchline-->

    <meta property="og:title" content="EasyUm CRM">
    <meta property="og:description"
          content="Описание страницы слайда выпадающая в поисковых страницах не более 160 символов">
    <meta property="og:type" content="article">
    <meta property="og:image" content="https://it.easyum.ru/wp-content/uploads/2018/11/home_top_img.png">
    <meta property="og:site_name" content="EasyUm CRM">

    <title>TitlePage</title>

    <!-- подключение шрифтов -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">

    <!-- Подключаем css -->
    <link rel="stylesheet" href="resources/css/TitlePage5.css">
</head>

<body>
<header id="header" class="header">
    <!--блок с названием, строкой и логотипом-->
    <div class="container">
        <nav class="nav">
            <img src="resources/images/logo.png" alt="EasyUm">
            <!-- Пункты меню -->
            <ul class="menu">
                <li class="li1">
                    <!-- Превращаем в ссылку -->
                    <!-- # - указывается ссылка для перехода-->
                    <a href="/index.jsp" class="menu__item menu__item_active">На главную </a>
                </li>
                <li class="li2">  <!-- Делаем ссылку -->
                    <a href="#" class="menu__item menu__item_active">Logout </a>
                </li>
            </ul>
        </nav>
        <!--Печатаем название-->
        <h1 class="table name">
            Система управления студентами и их успеваемостью
        </h1>
        <img src="resources/images/square_pattern%201.png" class="background">
        <img src="resources/images/square_blur%201.png" class="background1">


        <div class="container buttons">

            <a href="/studentsList" class="btn btn-mini">
                Студенты
            </a>
            <a href="/disciplinesList" class="btn btn-mini">
                Дисциплины
            </a>
            <a href="/termsList" class="btn btn-mini">
                Семестры
            </a>

        </div>

    </div>
</header>

</body>
</html>
