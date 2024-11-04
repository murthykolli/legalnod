(function($) {
    var winH = $(window).height();
    var winW = $(window).width();
    function extend(obj1, obj2) {
        var newobj = {};
        for (var i in obj1) {
            newobj[i] = obj1[i];
            if (obj2 && obj2[i] !== null) {
                newobj[i] = obj2[i];
            }
        }
        return newobj;
    }
    $['lz'] = {
        Alert: function(content, title, userSetting) {
            var defaults = {
                "type": "messageBox",
                "title": "",
                "content": "Custom dialog content",
                "noMask": false,
                "effect": "none",
                "formID":""
            };
            var settings = $.extend(defaults, userSetting);
            var $body = $("body");
            settings = $.extend(settings, arguments[0]);
            settings.content = settings.content ? settings.content : "";
            addLayer();
            this.autoMiddle(window, "#lz-alert");
            var $alert = $("#lz-alert");
            var $layer = $("#lz-layer");
            showEffect(settings.effect);
            bindEve();
            function showEffect(effect) {
                var subeffect = effect.split(",");
                if (subeffect[0] === "slideDown") {
                    $alert.slideDown();
                }
                if (subeffect[1] === "bigger") {
                    $alert.show().addClass("bigger");
                }
            }
            function addLayer() {
                var sureBtn = '<span class="lz-sure">Yes</span>';
                var cancelBtn = '<span class="lz-cancel">No</span>' + '</div>';
                var btns;
                if (!settings.noMask) {
                    var dom1 = settings.noMask ? '' : '<div id="lz-layer"></div>';
                    $body.append(dom1);
                }
                btns = sureBtn + cancelBtn;
                var dom2 = '<div id="lz-alert" style="display:none;">' + '<div class="lz-alert-title">' + settings.title + '</div>' + '<div class="lz-alert-con">' + settings.content + '</div>' + '<div class="lz-btns">' + btns + '</div>';
                $("#lz-layer").css({
                    "width": 2 * $(window).width(),
                    "height": 2 * $(window).height()
                });
                $body.append(dom2);
            }
            function layerRemove() {
                $layer.remove();
                $alert.remove();
            }
            function bindEve() {
                $alert.on("click", ".lz-sure", function() {
                    layerRemove();
                    document.forms[settings.formID].submit();
                });
                $alert.on("click", ".lz-cancel", function() {
                    layerRemove();
                });
            }
        },
        autoMiddle: function(faSelecter, sonSelecter) {
            if (faSelecter === window) {
                var sonH = $(sonSelecter).height();
                var sonW = $(sonSelecter).width();
                $(sonSelecter).css({
                    left: 0,
                    top: 0,
                    "margin-top": (winH - sonH) / 2,
                    "margin-left": (winW - sonW) / 2
                });
                return false;
            }
            $(faSelecter).each(function() {
                var thisH = $(this).height();
                var sonH = $(this).find(sonSelecter).height();
                $(this).find(sonSelecter).css("margin-top", (thisH - sonH) / 2);
            });
        }
    };
})($);