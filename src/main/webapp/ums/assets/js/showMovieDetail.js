/**
 * Created by Fantasy on 2017/2/12.
 */
$(function () {
    var bathPath = window.location.protocol + '//' + window.location.host;
    $("#film-childProtectionId").change(function () {
        var selectText = $("#film-childProtectionId option:selected").text();
        var proLevel = '';
        $('#film-childProtectionDisplayName').val(selectText);
        switch (selectText) {
            case '无年龄级别':
                proLevel = '-1';
                break;
            case 'G级':
                proLevel = '4';
                break;
            case 'PG级别':
                proLevel = '8';
                break;
            case 'PG-13级别':
                proLevel = '12';
                break;
            case 'R级别':
                proLevel = '16';
                break;
            default:
                proLevel = '18';
        }
        $('#film-childProtectionLevel').val(proLevel);
    });
    $('#film-parMovieId').change(function () {
        var selectText = $("#film-parMovieId option:selected").text();
        if (selectText === '子级') {
            $('.film-subMovieId').show();
            $('.film-curEpisode').show();
        } else {
            $('.film-subMovieId').hide();
            $('.film-curEpisode').hide();
        }
    });
    var domRadio = function (resp) {
        var $subBelong = $('#film-subBelong');
        var domStr = '';
        for (var i = 0; i < resp.length; i++) {
            var item = resp[i];
            domStr += '<input type="radio" class="am-radio-inline" name="subMovieId" value="' + item.movieId + '"/>' + item.title;
        }
        $subBelong.empty();
        $subBelong.append(domStr);
    };
    var keyUpTimer = null;

    $('#film-subMovieId').keyup(function () {
        var curInputVal = $(this).val();
        if (curInputVal === '') {
            return false
        }
        clearTimeout(keyUpTimer);
        keyUpTimer = setTimeout(function () {
            $.get(bathPath + '/Movie/getMovieByTitle', {movieTitle: curInputVal}).done(function (resp) {
                domRadio(JSON.parse(resp));
            });
        }, 1500);
    });
});