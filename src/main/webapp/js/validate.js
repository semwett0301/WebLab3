// Поиск значения

afterAjaxSuccess = function (data) {
    if (data.status == "success") {
        checkClick();
        console.log("success");
    }
}

checkClick = function () {


    $('#svg_area').on('click', function (e) {
        let scope = $('select').val();
        let x_coord = ((e.pageX - $(this).offset().left - 150) / 99.5) * scope;
        let y_coord = (-(e.pageY - $(this).offset().top - 150) / 99.5) * scope;

        if (clickValidate(x_coord, y_coord, scope)) {
            console.log("do_this")
            $('.hidden_x').val(x_coord.toFixed(2))
            $('#parent_y').children('input').val(y_coord.toFixed(2))
            $('#submit').children('input').click()
        } else {
            if (!clickX(x_coord)) set_and_remove_error_X("Значение выходит за границы диапазона")
            if (!clickY(y_coord)) set_and_remove_error_Y("Значение выходит за границы диапазона")
        }
    })
}

checkClick();

function putValueX() {
    let radios = document.querySelector("input[type=radio]:checked").value;
    $('#parent_x').children('.hidden_x').val(radios);
    console.log(radios);
}

function clickValidate(x, y, r) {
    return !!(clickX(x) && clickY(y) && clickR(r));

}

function clickX(x) {
    return x >= -3 && x <= 5;
}

function clickY(y) {
    return y > -5 && y < 3;
}

function clickR(r) {
    return r >= 1 && r <= 5;
}

function validate() {
    let x_coordinate = check_and_return_X();
    let y_coordinate = check_and_return_Y();
    let r_coordinate = check_and_return_R();

    set_and_remove_error_X(x_coordinate);
    set_and_remove_error_Y(y_coordinate);
    set_and_remove_error_R(r_coordinate);

    console.log("Zal")
    return !isNaN(x_coordinate) && !isNaN(y_coordinate) && !isNaN(r_coordinate);

}

function check_and_return_X() {
    let x_coordinate_h = $('#parent_x').find('input.hidden_x').val();
    if (!isNaN(x_coordinate_h)) {
        if (x_coordinate_h >= -3 && x_coordinate_h <= 5) return x_coordinate_h
        else return "Введите число в правильном диапазоне"
    } else return "Введите число"

}

function check_and_return_Y() {
    let y_coordinate = document.getElementById('parent_y').children[1].value;
    if (y_coordinate.includes(',')) {
        let x_parts = y_coordinate.split(',', 2);
        if (!isNaN(x_parts[0]) && !isNaN(x_parts[1])) {
            y_coordinate = x_parts[0] + "." + x_parts[1]
            parseFloat(y_coordinate);
        }
    }
    if (!isNaN(y_coordinate) && !y_coordinate == '') {
        if (y_coordinate != '-0') {

            if (y_coordinate > -5 && y_coordinate < 3) {
                return y_coordinate
            } else {
                return "Введите число в правильном диапазоне"
            }
        } else {
            return "Введите корректное число"
        }
    }
    return "Введите число"
}

function check_and_return_R() {
    let value = document.getElementById('parent_r').children[1].value;
    if (!isNaN(value)) {
        if (value >= 1 && value <= 5) {
            return value
        } else {
            return "Введите число в верном диапазоне"
        }
    } else {
        return "Введите число"
    }
}

function set_and_remove_error_X(x_coordinate) {
    if (!isNaN(x_coordinate)) {
        $('#parent_x .x_error_mes').html("");
    } else {
        $('#parent_x .x_error_mes').html(x_coordinate);
    }
}

function set_and_remove_error_Y(y_coordinate) {

    if (!isNaN(y_coordinate)) {
        $('#parent_y .y_error_mes').html("");
    } else {
        $('#parent_y .y_error_mes').html(y_coordinate);
    }
}

function set_and_remove_error_R(r_coordinate) {
    if (!isNaN(r_coordinate)) {
        $('#parent_r .r_error_mes').html("");
    } else {
        $('#parent_r .r_error_mes').html(r_coordinate);
    }
}