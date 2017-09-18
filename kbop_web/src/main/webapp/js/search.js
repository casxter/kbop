/**
 * Created by TWJ on 2016-10-16.
 */
$(function () {

    //分页跳转
    $("#submit").click(function () {
        window.location.href = '/search?q=' + $('#search').attr('data-q') + '&start=' + $('#page').val();
    });

    $(".asend").click(function () {
        console.log(".asend");
        console.log("bookid:" + $(this).attr("data-bookid"));
        $('#email').data('bookid', $(this).attr("data-bookid"));
        $('#emailModal').modal('show');
    });

    $('#send').click(function () {
        var email = $('#email').val();
        var bookId = $('#email').data('bookid');

        console.log('send email:' + email + ' bookid:' + bookId);

        var json = '{"email":"' + email + '", "bookId":"' + bookId + '"}';
        console.log(json);

        //post请求
        $.post('/email', json, function (data) {
            var jsonobj = $.parseJSON(data);
            if (jsonobj.code == 0)
                alert("发送成功");
            else
                alert("发送失败");
        }).error(function () {
            alert("发送失败");
        });
    });

    $('#searchbtn').click(function () {
        window.location.href = '/search?q=' + $('#search').val();
    });
});