! function (e) {
    e.fn.UItoTop = function (n) {
        var o = {
                text: ""
                , min: 200
                , inDelay: 600
                , outDelay: 400
                , containerID: "toTop"
                , containerHoverID: "toTopHover"
                , scrollSpeed: 1200
                , easingType: "linear"
            }
            , t = e.extend(o, n)
            , i = "#" + t.containerID
            , a = "#" + t.containerHoverID;
        e("body").append('<a href="#" id="' + t.containerID + '">' + t.text + "</a>"), e(i).hide().on("click.UItoTop", function () {
            return e("html, body").animate({
                scrollTop: 0
            }, t.scrollSpeed, t.easingType), e("#" + t.containerHoverID, this).stop().animate({
                opacity: 0
            }, t.inDelay, t.easingType), !1
        }).prepend('<span id="' + t.containerHoverID + '"></span>').hover(function () {
            e(a, this).stop().animate({
                opacity: 1
            }, 600, "linear")
        }, function () {
            e(a, this).stop().animate({
                opacity: 0
            }, 700, "linear")
        }), e(window).scroll(function () {
            var n = e(window).scrollTop();
            void 0 === document.body.style.maxHeight && e(i).css({
                position: "absolute"
                , top: n + e(window).height() - 50
            }), n > t.min ? e(i).fadeIn(t.inDelay) : e(i).fadeOut(t.Outdelay)
        })
    }
}(jQuery), $(document).ready(function () {
    $().UItoTop({
        easingType: "easeOutQuart"
    })
});