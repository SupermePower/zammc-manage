var common = {
    ctx: '/zammc-manage',
    query_string: location.search.replace(/(\?|&)pageNum=.+/, '').substr(1),
    pageNum: parseInt($('.paging-bg').html()),
    getTable: function () {
        location.href = location.pathname + (this.query_string ? '?' + this.query_string + '&' : '?') + 'pageNum=' + this.pageNum
    },
    initTree: function ($obj, data, flag) {
        var setting = {
            view: {
                showIcon: true
            }
        }

        if (flag) {
            $.extend(setting, {
                callback: {
                    beforeClick: function () {
                        return false
                    }
                }
            })
        } else {
            $.extend(setting, {
                check: {
                    enable: true,
                    chkboxType: {
                        Y: 'ps',
                        N: 'ps'
                    }
                }
            })
        }

        $.fn.zTree.init($obj, setting, data)
    },
    options: {
        success: function (message) {
            //message = jQuery.parseJSON(message);
            if (message.status == 'SUCCESS') {
                common.alert(message, function () {
                    location.reload();
                });
            } else {
                common.alert(message, function () {
                });
            }
        }
    },
    alert: function (tip, callback) {//弹窗 警告窗
        if ($('#alertBox').length) {
            $('#alertContent').html(tip.message)
            $('#alertTitle').html(tip.title)
            $('#alertBox').show()
        } else {
            var html = '<div id="alertBox" data-modal class="commom-modal-content">'
                + '<div class="commom-modal-main">'
                + '<div class="common-modal">'
                + '<div class="common-modal-head">'
                + '<p id="alertTitle">' + tip.title + '</p>'
                + '<span><img data-modal-close src="' + common.ctx + '/img/close.png"/></span>'
                + '</div>'
                + '<div id="alertContent" class="common-modal-p1">' + tip.message + '</div>'
                + '<div class="common-modal-box">'
                + '<p class="common-modal-btn"><button id="alertOk" class="common-modal-button">确定</button></p>'
                + '</div>'
                + '</div>'
                + '</div>'
                + '</div>'
            $('body').append(html)
        }
        $('#alertOk').off('click').on('click', function () {
            $('#alertBox').hide()
            callback && callback()
        })
    },
    confirm: function (tip, callback, data) {//弹动态数据 tip 提示语 callback回调函数 data 数据
        if ($('#confirmBox').length) {
            $('#confirmContent').html(tip.message)
            $('#confirmTitle').html(tip.title)
            $('#confirmBox').show()
        } else {
            var html = '<div id="confirmBox" data-modal class="commom-modal-content">'
                + '<div class="commom-modal-main">'
                + '<div class="common-modal">'
                + '<div class="common-modal-head">'
                + '<p id="confirmTitle">' + tip.title + '</p>'
                + '<span><img data-modal-close src="' + common.ctx + '/img/close.png"/></span>'
                + '</div>'
                + '<div id="confirmContent" class="common-modal-p1">' + tip.message + '</div>'
                + '<div class="common-modal-box">'
                + '<p class="common-modal-btn"><button data-modal-close class="common-modal-button common-cancel">取消</button>'
                + '<button id="confirmOk" class="common-modal-button">确定</button></p>'
                + '</div>'
                + '</div>'
                + '</div>'
                + '</div>'
            $('body').append(html)
        }
        $('#confirmOk').off('click').on('click', function () {
            $('#confirmBox').hide()
            callback(data)
        })
    },
    confirm2: function (tip, callback, data) {  //基本没用
        var html = '<div class="commom-modal-main2">'
            + '<div class="common-modal2">'
            + '<div class="common-modal-head2">'
            + '<p id="confirmTitle2">' + tip.title + '</p>'
            + '<span><img data-modal-close2 src="' + common.ctx + '/img/close.png"/></span>'
            + '</div>'
            + '<div id="confirmContent2" class="common-modal-p1_2">' + tip.message + '</div>'
            + '<div class="common-modal-box2">'
            + '<p class="common-modal-btn2"><button data-modal-close2 class="common-modal-button2 common-cancel2">取消</button>'
            + '<button id="confirmOk2" class="common-modal-button2">确定</button></p>'
            + '</div>'
            + '</div>'
            + '</div>'
        $('.commom-modal-content').append(html)
        $('.common-modal-button2').off('click').on('click', function () {
            $('.commom-modal-main2').remove()
            callback(data)
        })
    },
    jumpPage: function (url) {//返回 传前一页url
        $.cookie('goback_url', location.href, {path: '/'})
        location.href = url
    }
}

//关闭修改密码弹窗
$(document).on('click', '#cancle_reset', function () {
    $('.reset_paswd_div').remove();
})

//退出
$('.logout').click(function () {
    common.confirm({'title': '提示', 'message': '确认退出登录？'}, function () {
        location.href = common.ctx + '/login/logout.do';
    })
})

$.ajaxSetup({cache: false, dataType: 'json'})
$(document).ajaxStart(function () {
    $('#focus').focus()
    var html = '';
    html += '<div class="commom-modal-content cover">';
    html += '	<div class="commom-modal-main">';
    html += '		<p class="common-img"><img style="width:47px;height:47px;" src="' + common.ctx + '/img/upload.gif" /></p>';
    html += '	</div>';
    html += '</div>';
    $('body').append(html)
})
$(document).ajaxStop(function () {
    if ($('.cover').length) {
        $('.cover').remove();
    }
})
$('#focus').keydown(function (e) {
    e.keyCode == 13 && ($('#alertBox').is(':visible') ? $('#alertOk').click() : $('#confirmBox').is(':visible') ? $('#confirmOk').click() : 0)
})

$('#showMenu').click(function () {
    var $p = $(this).parent(),
        w = 230 - $p.width()
    $p.animate({width: w}, 300).next().animate({marginLeft: w}, 300)
    setTimeout(function () {
        $p.toggleClass('fold')
    }, 150)
})

$('.showMenu').click(function () {
    var $t = $(this)
    $p = $t.parent()
    $p.animate({marginLeft: 180 - parseFloat($p.css('marginLeft'))})
    setTimeout(function () {
        $t.hide().siblings('span').show()
    }, 200)
})

$('#menuList').on('click', 'li', function () {
    $(this).siblings().removeClass('indexMain-img').find('.indexMain-second').slideUp(200).end().end().toggleClass('indexMain-img').find('.indexMain-second').slideToggle(200)
}).on('click', '.indexMain-second', function (e) {
    e.stopPropagation()
})

$('.paging-list').on('click', 'li', function () {
    var $this = $(this),
        totalpage = parseInt($('.page:last').html())
    if (common.pageNum > 1) {
        $this.is('#firstpage') && (common.pageNum = 1) && common.getTable()
        $this.is('#prevpage') && common.pageNum-- && common.getTable()
    }
    if (common.pageNum < totalpage) {
        $this.is('#nextpage') && common.pageNum++ && common.getTable()
        $this.is('#lastpage') && (common.pageNum = totalpage) && common.getTable()
    }
    $this.is('.page') && (common.pageNum = parseInt($this.html())) && common.getTable()
})

$('#gopage').click(function () {
    var p = parseInt($('#pageNum').val()),
        totalpage = parseInt($('.page:last').html())
    p >= 1 && p <= totalpage && common.pageNum != p && (common.pageNum = p) && common.getTable()
})
$('#pageNum').keydown(function (event) {
    event.keyCode == 13 && $('#gopage').click()
})

$(document).on('click', '[data-modal-close]', function () {
    $(this).parents('[data-modal]').hide()
})

$(document).on('click', 'img', function () {
    if ($(this).parents('#zoomImg').length || $(this).attr('src').search(common.ctx + '/img') != -1) return
    $('#zoomImg').show().find('img').attr('src', $(this).attr('src'))
    $('body').css('overflow', 'hidden')
})
$('#zoomImg').click(function () {
    $(this).children().scrollTop(0)
    $(this).hide()
    $('body').removeAttr('style')
})
$('.jump_page').click(function (e) {
    e.preventDefault()
    common.jumpPage($(this).attr('url'))
})

$('.jump_question').click(function (e) {
    e.preventDefault()
    common.alert({title: '提示', message: '请先设置活动信息'});
})

$('.go-back').click(function () {
    location.href = $.cookie('goback_url')
})
