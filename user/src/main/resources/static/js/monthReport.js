const deviceWidth = document.documentElement.clientWidth;
const chart = new F2.Chart({
    id: 'mountNode',
    pixelRatio: window.devicePixelRatio,
    width: deviceWidth,
    height: 400,
    padding: [10, 10, 30, 30],
    forceFit: true
});

function convertDate2Str(dateObj) {
    return dateObj.getFullYear() + "-" + (dateObj.getMonth() + 1) + "-" + dateObj.getDate();
}

const data = [
    {time: '2016-08-01 ', tem: 10},
    {time: '2016-08-02 ', tem: 22},
    {time: '2016-08-03 ', tem: 150},
    {time: '2016-08-04 ', tem: 26},
    {time: '2016-08-05 ', tem: 20},
    {time: '2016-08-06 ', tem: 26},
    {time: '2016-08-07 ', tem: 28},
    {time: '2016-08-08 ', tem: 20},
    {time: '2016-08-09 ', tem: 28},
    {time: '2016-08-10', tem: 8.6},
    {time: '2016-08-11', tem: 3.3},
    {time: '2016-08-12', tem: 1.5},
    {time: '2016-08-13', tem: 8.7},
    {time: '2016-08-14', tem: 4.5},
    {time: '2016-08-15', tem: 1.88},
    {time: '2016-08-16', tem: 0.31},
    {time: '2016-08-17', tem: 4.},
    {time: '2016-08-18', tem: 7},
    {time: '2016-08-19', tem: 9},
    {time: '2016-08-20', tem: 0.7},
    {time: '2016-08-21', tem: 2.},
    {time: '2016-08-22', tem: 5.},
    {time: '2016-08-23', tem: 9.},
    {time: '2016-08-24', tem: 0.5},
    {time: '2016-08-25', tem: 5.5},
    {time: '2016-08-26', tem: 0.1},
    {time: '2016-08-27', tem: 9.2},
    {time: '2016-08-28', tem: 5.4},
    {time: '2016-08-29', tem: 0.8},
    {time: '2016-08-30', tem: 5.6},
    {time: '2016-08-31', tem: 8.6}
];

function init() {
    chart.source(data, {
        time: {
            tickCount: 6,
            formatter(item) {
                return convertDate2Str(new Date(item)).substring(7)
            },
            range: [0.05, 0.95]
        },
        tem: {
            tickCount: 3,
            formatter(item) {
                return item;
            }
        }
    });
    chart.axis("time", {
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
    chart.axis("tem", {
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
    chart.line().position('time*tem').shape('smooth');
    chart.render();
}