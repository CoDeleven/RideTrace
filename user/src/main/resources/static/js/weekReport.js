var firstDate = getFirstDate(new Date());
var lastDate = getLastDate(new Date());
var deviceWidth = document.documentElement.clientWidth;
var startX = 0,
    endX = 0;
var mountNodeObj = document.getElementById("mountNode");
const chart = new F2.Chart({
    id: 'mountNode', // 指定图表容器 ID
    width: deviceWidth - 10, // 指定图表宽度
    height: 400, // 指定图表高度
    padding: [10, 0, 50, 20],
    pixelRatio: window.devicePixelRatio
});
function init() {
    mountNodeObj.ontouchstart = function (event) {
        var touch = event.targetTouches[0];
        startX = touch.pageX;
    }
    mountNodeObj.ontouchmove = function (event) {
        var touch = event.targetTouches[0];
        endX = touch.pageX;
    }
    mountNodeObj.ontouchend = function (event) {
        var distanceX = endX - startX;
        if (startX != Math.abs(distanceX)) {
            chart.clear();
            var list;
            if (Math.abs(distanceX) > deviceWidth * 0.2 && distanceX < 0) {
                dateAfterwards();
                list = genDate();
                refreshGuide(chart, list);
            } else if (Math.abs(distanceX) > deviceWidth * 0.2 && distanceX > 0) {
                dateForwards()
                list = genDate();
                refreshGuide(chart, list)
            }

            chart.source(list)
            chart.interval().position('genre*sold').color('genre');
            chart.render();
        }
    }

    chart.animate({
        type: "scaley",
        duration: 500,
        easing: 'easeInOut',
        success: function() {
        }
    })

    var list = genDate();

    chart.axis("sold", {
        label: (text, index, total) => {
            const cfg = {
                fill: '#979797',
                font: '12px san-serif',
                offset: 6
            };
            // cfg.text 支持文本格式化处理
            // cfg.text = text + '%';
            return cfg;
        }
    })
    chart.axis("genre", {
        label: (text, index, total) => {
            const cfg = {
                fill: '#979797',
                font: '12px san-serif',
                offset: 6
            };
            // cfg.text 支持文本格式化处理
            // cfg.text = text + '%';
            return cfg;
        }
    })

    chart.source(list);

    // Step 3：创建图形语法，绘制柱状图，由 genre 和 sold 两个属性决定图形位置，genre 映射至 x 轴，sold 映射至 y 轴
    chart.interval().position('genre*sold').color('genre');

    refreshGuide(chart, list)

    // Step 4: 渲染图表
    chart.render();
}

function convertDate2Str(dateObj){
    return dateObj.getFullYear() + "-" + (dateObj.getMonth() + 1) + "-" + dateObj.getDate();
}

/**
 * 获取不属于自己的周日日期
 */
function getFirstDate(dateObj) {
    var weekNum = dateObj.getDay()
    if(weekNum == 0){
        weekNum = 7;
    }
    return getDateObj(dateObj, -weekNum)
}

function getLastDate(dateObj) {
    var weekNum = dateObj.getDay()
    if(weekNum == 0){
        weekNum = 7;
    }
    return getDateObj(dateObj, 8 - weekNum)
}

function getDateObj(dateObj, addDayCount) {
    dateObj.setDate(dateObj.getDate() + addDayCount); //获取AddDayCount天后的日期
    return dateObj;
}

Date.prototype.getChineseWeekNum = function () {
    switch (this.getDay()){
        case 0 : return "日";
        case 1 : return "一";
        case 2: return "二";
        case 3: return "三";
        case 4: return "四";
        case 5: return "五";
        case 6: return "六";
    }
}

function dateForwards() {
    console.log("向前")
    firstDate = getDateObj(firstDate, -7)
    lastDate = getDateObj(lastDate, -7)
}

function dateAfterwards() {
    console.log("向后")
    firstDate = getDateObj(firstDate, +7)
    lastDate = getDateObj(lastDate, +7)
}

function genDate(){
    var data = [];

    data.unshift({
        genre: convertDate2Str(lastDate).substring(5),
        sold: 0
    })

    for(var i = 1; i < 8; ++i) {
        var result = Math.random() * 20;
        data.unshift({
            genre: getDateObj(new Date(lastDate.getTime()), -i).getChineseWeekNum(),
            sold: result.toPrecision(1)
        })
    }

    data.unshift({
        genre: convertDate2Str(firstDate).substring(5),
        sold: 0
    })


    return data;
}

function refreshGuide(chart, data){
    data.forEach(function(obj, index) {
        // 文字部分
        const offsetY = obj.sold >= 0 ? -16 : 14;
        chart.guide().html([ obj.genre, obj.sold ], `<div style='color: #999999;'><span>${obj.sold}</span></div>`, {
            align: 'cc',
            offset: [ 0, offsetY + 5]
        });
        // 背景部分
        const offset = 0.25;
        chart.guide().rect([ index - offset, 'max' ], [ index + offset, 'min' ], { fill: '#f8f8f8' });
    });
}