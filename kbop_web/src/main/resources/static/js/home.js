/**
 * Created by TWJ on 2016-10-7.
 */

$(function () {

    //第一次载入页面请求
    getbooklist(1);

    function getbooklist(pageNum) {
        $.getJSON('/booklist?pageNum=' + pageNum, function (data) {
            var jsondata = data.data;
            if (jsondata != null) {

                $("#jumbotron-p").empty();

                $("#jumbotron-p").text('当前共有' + jsondata.totalBookCount + '本书');

                $("#pagination").text(jsondata.pageNum + '/' + Math.floor(jsondata.totalBookCount / jsondata.pageSize));

                $("#pagination").data("pageNum", jsondata.pageNum);
                $("#pagination").data("pageSize", jsondata.pageSize);
                $("#pagination").data("totalBookCount", jsondata.totalBookCount);

                var booklist = $("#booklist-tbody");

                //清理全部子节点
                booklist.empty();

                for (i = 0; i < jsondata.list.length; i++) {

                    var line = '<tr>' +
                        '<td>' + jsondata.list[i].bookName + '</td>' +
                        '<td>' + jsondata.list[i].author + '</td>' +
                        '<td>' + jsondata.list[i].size + '</td><td>' +
                        '<div class="btn-group"><button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">操作<span class="caret"></span></button>' +
                        '<ul class="dropdown-menu" role="menu">' +
                        '<li><a href="/download?bookId=' + jsondata.list[i].id + '">下载</a></li>' +
                        '<li><a class="asend" data-bookid="' + jsondata.list[i].id + '">发送到Kindle</a></li>' +
                        '</ul></div></td></tr>';
                    booklist.append(line);
                }
            }
        });
    }

    //分页请求
    $("#submit").click(function () {
        var pageNum = $('#pageNum').val();
        getbooklist(pageNum);
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
        //post请求
        $.post('/search',
            {
                q: $('#search').val(),
                pageNum: 1
            }
            , function (data) {
                var jsondata = data.data;
                if (jsondata != null) {

                    $("#jumbotron-p").empty();

                    $("#jumbotron-p").text('当前共有' + jsondata.totalBookCount + '本书');

                    $("#pagination").text(jsondata.pageNum + '/' + Math.floor(jsondata.totalBookCount / jsondata.pageSize));

                    $("#pagination").data("pageNum", jsondata.pageNum);
                    $("#pagination").data("pageSize", jsondata.pageSize);
                    $("#pagination").data("totalBookCount", jsondata.totalBookCount);

                    var booklist = $("#booklist-tbody");

                    //清理全部子节点
                    booklist.empty();

                    for (i = 0; i < jsondata.list.length; i++) {

                        var line = '<tr>' +
                            '<td>' + jsondata.list[i].bookName + '</td>' +
                            '<td>' + jsondata.list[i].author + '</td>' +
                            '<td>' + jsondata.list[i].size + '</td><td>' +
                            '<div class="btn-group"><button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">操作<span class="caret"></span></button>' +
                            '<ul class="dropdown-menu" role="menu">' +
                            '<li><a href="/download?bookId=' + jsondata.list[i].id + '">下载</a></li>' +
                            '<li><a class="asend" data-bookid="' + jsondata.list[i].id + '">发送到Kindle</a></li>' +
                            '</ul></div></td></tr>';
                        booklist.append(line);
                    }
                }
            });
    });
});
