
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
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
                    <!-- Превращаем в ссылку -->
                    <!-- # - указывается ссылка для перехода-->
                    <a href="/index.jsp" class="menu__item menu__item_active">На главную </a>
                </li>
                <li>  <!-- Делаем ссылку -->
                    <a href="#" class="menu__item menu__item_active">Logout </a>
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
            <a href="/studentProgress" class="btn">Просмотреть успеваемость выбранных студентов </a>
            <a href="/studentModifying" class="btn">Модифицировать выбранного студента</a>
        </div>
        <div>
            <a href="#" class="btn">Создать студента </a>
            <a href="#" class="btn">Удалить студента</a>
        </div>
    </div>
</header>

<section id="section" class="section">
    <div  class="container">
        <h2>Список студентов</h2>

        <!-- Таблица-->
        <table class="table">

            <!-- Заголовочная строка таблицы-->
            <thead>
            <!--  tr - строка таблицы-->
            <tr>
                <!--  th- заголовок ячейки таблицы-->
                <th class="td"></th>
                <th class="td">Фамилия</th>
                <th class="td">Имя</th>
                <th class="td">Группа</th>
                <th class="td">Дата поступления</th>
            </tr>
            </thead>
            <!--tbody - определяет тело таблицы-->
            <tbody>
            <!--  tr - создание строки таблицы-->
            <tr>
                <!--  td- ячейка таблицы-->
                <!--  chekbox - кубик с возможностью ставить галочку-->
                <td
                        class="td-ch"><input type="checkbox" class="check__item">
                </td>
                <td class="td">Сидоров</td>
                <td class="td">Сидор</td>
                <td class="td">КТ-21</td>
                <td class="td">1/09/2021</td>
            </tr>
            <tr>
                <td
                        class="td-ch"><input type="checkbox" class="check__item">
                </td>
                <td class="td">Петров</td>
                <td class="td">Петр</td>
                <td class="td">КТ-21</td>
                <td class="td">1/09/2021</td>
            </tr>
            <tr>
                <td
                        class="td-ch"><input type="checkbox" class="check__item">
                </td>
                <td class="td">Иванов</td>
                <td class="td">Иван</td>
                <td class="td">КТ-21</td>
                <td class="td">1/09/2021</td>
            </tr>
            <tr>
                <td
                        class="td-ch"><input type="checkbox" class="check__item">
                </td>
                <td class="td">Макаревич</td>
                <td class="td">Андрей</td>
                <td class="td">КТ-21</td>
                <td class="td">1/09/2021</td>
            </tr>
            <tr>
                <td
                        class="td-ch"><input type="checkbox" class="check__item">
                </td>
                <td class="td">Бельгиец</td>
                <td class="td">Василий</td>
                <td class="td">КТ-21</td>
                <td class="td">1/09/2021</td>
            </tr>

            </tbody>
        </table>
    </div>
</section>

<footer id="footer" class="footer">
    <div class="container">

    </div>
</footer>

</body>
</html>
