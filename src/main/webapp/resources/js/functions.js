function deleteStudents() {
    //Получаем массив input со всеми вложенными атрибутами которые у нас checked(с галочкой)
    var checkedCheckBoxes = document.querySelectorAll("input[name=idStudent]:checked");

// Проверка на наличие галочек
    if (checkedCheckBoxes.length == 0) {
        alert("Please select students.");
        return;
    }

    //Формируем переменную String в которой перечисляем id через пробел: String = (5 6 7 8 )
    var ids = "";
    for (var i = 0; i < checkedCheckBoxes.length; i++) {
        ids = ids + checkedCheckBoxes[i].value + " ";
    }

//Заполним value = "" у input formDelete
    document.getElementById("hiddenDelete").value = ids;
    //Нажать кнопку программно, что бы отправить форму на сервер
    document.getElementById("formDelete").submit();
}

function modifyStudent() {
    //Получаем массив input со всеми вложенными атрибутами которые у нас checked(с галочкой)
    var checkedCheckBoxes = document.querySelectorAll("input[name=idStudent]:checked");

    // Проверка на наличие галочек
    if (checkedCheckBoxes.length == 0) {
        alert("Please select student.");
        return;
    }

    //Проверка не более одной галочки
    if (checkedCheckBoxes.length > 1) {
        alert("Please select only one student.");
        return;
    }

    //Заполним value = "" у input formModify
    document.getElementById("hiddenModify").value = checkedCheckBoxes[0].value;
    //Нажать кнопку программно, что бы отправить форму на сервер
    document.getElementById("formModify").submit();
}

function modifyDiscipline() {
    //Получаем массив input со всеми вложенными атрибутами которые у нас checked(с галочкой)
    var checkedCheckBoxes = document.querySelectorAll("input[name=idDiscipline]:checked");

    // Проверка на наличие галочек
    if (checkedCheckBoxes.length == 0) {
        alert("Please select discipline.");
        return;
    }

    //Проверка не более одной галочки
    if (checkedCheckBoxes.length > 1) {
        alert("Please select only one discipline.");
        return;
    }

    //Заполним value = "" у input formModify
    document.getElementById("hiddenModify").value = checkedCheckBoxes[0].value;
    //Нажать кнопку программно, что бы отправить форму на сервер
    document.getElementById("formModify").submit();
}

function deleteDiscipline() {
    //Получаем массив input со всеми вложенными атрибутами которые у нас checked(с галочкой)
    var checkedCheckBoxes = document.querySelectorAll("input[name=idDiscipline]:checked");

    // Проверка на наличие галочек
    if (checkedCheckBoxes.length == 0) {
        alert("Please select discipline.");
        return;
    }

    //Формируем переменную String в которой перечисляем id через пробел: String = (5 6 7 8 )
    var ids = "";
    for (var i = 0; i < checkedCheckBoxes.length; i++) {
        ids = ids + checkedCheckBoxes[i].value + " ";
    }

    //Заполним value = "" у input formDelete
    document.getElementById("hiddenDelete").value = ids;
    //Нажать кнопку программно, что бы отправить форму на сервер
    document.getElementById("formDelete").submit();
}

function deleteTerms() {
    //Получаем массив input со всеми вложенными атрибутами которые у нас checked(с галочкой)
    var checkedCheckBoxes = document.querySelectorAll("input[name=idTerms]:checked");

// // Проверка на наличие галочек
//     if (checkedCheckBoxes.length == 0) {
//         alert("Please select term.");
//         return;
//     }

    //Формируем переменную String в которой перечисляем id через пробел: String = (5 6 7 8 )
    // var ids = "";
    // for (var i = 0; i < checkedCheckBoxes.length; i++) {
    //     ids = ids + checkedCheckBoxes[i].value + " ";
    // }

//Заполним value = "" у input formDelete
    document.getElementById("hiddenDelete").value = checkedCheckBoxes.value;
    //Нажать кнопку программно, что бы отправить форму на сервер
    document.getElementById("formDelete").submit();
}

function modifyTerms() {
    // Получаем значение id из страницы где нажали кнопку с функцией js
    var idSelectedterm =document.querySelector("option[selected]");

    // заполним value у input formModify
    document.getElementById("hiddenModifyTerm").value = idSelectedterm.value;

    //Нажать кнопку программно, что бы отправить форму на сервер
    document.getElementById("formModifyTerm").submit();




}