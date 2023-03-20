
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Подключаем jstl библиотеки из сайта https://java-online.ru/jsp-jstl.xhtml--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Описание страницы для поисковиков не более 160 символов">
  <meta name="keywords" content="ключевые слова или фразы для поисковых систем, пишутся через запятую">

  <!-- favicon 16x16 32x32 64x64 формат png -->
  <link rel="icon" type="image/png" href="../resources/images/favicon_easyUm.png">

  <!-- OG-метки (Open Graf) миниатюра сайта для соц сетей и мессенджеров, пример: https://auto.ru/cars/used/sale/ram/1500/1117314846-ddc10bf3/?from=searchline-->
  <meta property="og:title" content="EasyUm CRM">
  <meta property="og:description"
        content="Описание страницы слайда выпадающая в поисковых страницах не более 160 символов">
  <meta property="og:type" content="article">
  <meta property="og:image" content="https://it.easyum.ru/wp-content/uploads/2018/11/home_top_img.png">
  <meta property="og:site_name" content="EasyUm CRM">

  <title>Authorization</title>

  <!-- Подключение шрифтов -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">

  <!-- Подключаем CSS -->
  <link rel="stylesheet" href="../resources/css/main.css">
</head>
<body>
<header id="header" class="header">
  <div class="container">
    <nav class="nav">
      <!-- Вставляем логотип -->
      <img src="../resources/images/logo.png" alt="EasyUm IT курсы">

      <!-- Пункт меню -->
      <ul class="menu">
        <li>
          <a href="/" class="menu__item menu__item_active">На главную</a>
        </li>
        <li>
          <%-- <a href="/login" class="menu__item menu__item_active">Logout</a>--%>
        </li>
      </ul>
    </nav>
    <h1>
      Система управления студентами и их успеваемостью
    </h1>
     </div>
  <img src="../resources/images/square_pattern%201.png" class="background">
  <img src="../resources/images/square_blur%201.png" class="background1">

  <!-- Делаем кнопку -->
  <p class="text-center mt50">
    Выберите роль и введите ваш логин и пароль:
  </p>
  <div class="container">
    <form action="/login" method="post">
      <div class="container buttons fields mt30 btn-center">
        <div class="text">
          <select name="role" class="field">
            <c:forEach items="${allActiveRoles}" var="role">
              <option value="${role.id}">${role.role}</option>
            </c:forEach>
          </select>
        </div>
      </div>
      <div class="container buttons fields mt15 btn-center">
        <input type="text" class="field" placeholder="Логин" name="login">
      </div>
      <div class="container buttons fields mt15 btn-center">
        <input type="password" class="field" placeholder="Пароль" name="password">
      </div>
      <div class="container buttons btn-center">
        <%--        <a href="#" class="btn w300">--%>
        <%--            Создать--%>
        <%--        </a>--%>
        <input type="submit" class="btn w300" value="Войти">
      </div>
    </form>
    <p class = "error-text">(временный логин/пароль: admin/123)</p>
<%--    Сообщения об ошибке--%>
    <c:if test="${Error eq 1}">
      <p class = "error-text">Авторизация не пройдена!</p>
    </c:if>
    <c:if test="${Error eq 2}">
      <p class = "error-text">Заполните логин и пароль!</p>
    </c:if>
  </div>
</header>

<footer id="footer" class="footer">
  <div class="container">

  </div>
</footer>

</body>
</html>