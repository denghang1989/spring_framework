
/// 增减日期
/// addDays 增减天数
Date.prototype.addDate = function (addDays) {
    var date = this.valueOf()
    date = date + addDays * 24 * 60 * 60 * 1000
    date = new Date(date)
    return date;
}

// 格式化日期
/// fmt 格式化格式 （"YYYY-MM-DD"）或 ("YYYY/MM/DD")
Date.prototype.Format = function (fmt) { //author: meizz 
    fmt = fmt.replace("YYYY", "yyyy").replace("DD", "dd");
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

/// 获取两个日期相差天数
/// startDate  endDate  字符串日期格式 "2019-01-01"
function GetDateDiff(startDate, endDate) {
    var startTime = new Date(Date.parse(startDate.replace(/-/g, "/"))).getTime();
    var endTime = new Date(Date.parse(endDate.replace(/-/g, "/"))).getTime();
    var dates = Math.abs((startTime - endTime)) / (1000 * 60 * 60 * 24);
    return dates;
}

function dateAdd(date, strInterval, Number) {  //参数分别为日期对象，增加的类型，增加的数量 
    var dtTmp = date;
    switch (strInterval) {
        case 'second':
        case 's':
            return new Date(Date.parse(dtTmp) + (1000 * Number));
        case 'minute':
        case 'n':
            return new Date(Date.parse(dtTmp) + (60000 * Number));
        case 'hour':
        case 'h':
            return new Date(Date.parse(dtTmp) + (3600000 * Number));
        case 'day':
        case 'd':
            return new Date(Date.parse(dtTmp) + (86400000 * Number));
        case 'week':
        case 'w':
            return new Date(Date.parse(dtTmp) + ((86400000 * 7) * Number));
        case 'month':
        case 'm':
            return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
        case 'year':
        case 'y':
            return new Date((dtTmp.getFullYear() + Number), dtTmp.getMonth(), dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
    }
}

var getDays = function (year, month) {
    return new Date(year, month, 0).getDate()
}

/// 获取当月第一天
Date.prototype.GetMonthFirstDay = function()
{
    var firstDate = new Date(this.getTime());
    firstDate.setDate(1);
    return firstDate;
}

/// 获取当月最后一天
Date.prototype.GetMonthLastDay = function ()
{
    var endDate = new Date(this.getTime());
    
    //endDate.setMonth(endDate.getMonth()+1);
    //endDate = dateAdd(endDate, "m", 1);
    //endDate.setDate(getDays(endDate.getFullYear(), endDate.getMonth()));
    endDate = dateAdd(new Date(endDate.getFullYear(), endDate.getMonth() + 1, 1),"day",-1);
    //endDate = endDate.addDate(-1);
    return endDate;
}

Date.prototype.GetDateTheFirst = function()
{
    var date = this.getDay()-1;
    return new Date().addDate(date / -1);
}
Date.prototype.GetDateTheLast = function () {
    var date = this.getDay();
    return new Date().addDate(date / -1).addDate(7);
}


function addatePicker(id) {
    laydate({
        elem: '#' + id,
        istoday: true,
        choose: function (data) {
            if (data) {
                $('#' + id).blur();
            }
        }
    });
}

GetJson = function(url,data,callback,async)
{
    async = async == null ? true : async;
    var _index = null;
    if (layer) {
        //_index = layer.load();
    }
    $.ajax({
        url:url,
        data: data,
        type: 'GET',
        dataType:'json',
        success:function(data)
        {
            if (layer) {
                //layer.closeAll('loading');
            }
            if (data && data.type && data.type == "autoAuthResult") {
                layer.msg(data.msg, { time: 2000, icon: 2 });
                loginDialog();
                return;
            }
            if(callback)                
                callback(data);
        },
        async:async
    })
}

toParams = function (json)
{
    var str = "";
    $.each(json, function (k, v) {
        str += k + "=" + v + "&";
    })
    if (str && str.length>0)
        str = str.substring(0, str.length - 1);
    return str;
}

mergeJsonObject = function (jsonbject1, jsonbject2) {
    var resultJsonObject = {};
    for (var attr in jsonbject1) {
        resultJsonObject[attr] = jsonbject1[attr];
    }
    for (var attr in jsonbject2) {
        resultJsonObject[attr] = jsonbject2[attr];
    }

    return resultJsonObject;
};

/// 格式化日期 直接格式成 yyyy-MM-dd 
/// date 日期类型
Date.prototype.formatDate=function(date){			//格局化日期：yyyy-MM-dd   
    var myyear = date.getFullYear();   
    var mymonth = date.getMonth()+1;   
    var myweekday = date.getDate();  
    
    if(mymonth < 10){   
        mymonth = "0" + mymonth;   
    }   
    if(myweekday < 10){   
        myweekday = "0" + myweekday;   
    }   
    return (myyear+"-"+mymonth + "-" + myweekday);   
}  

/// 获取当前日期 当前周的第一天
/// 返回 字符串日期格式("YYYY-MM-DD")
Date.prototype.GetWeekFirstDay = function()
{
	 var now = new Date(this.getTime()); 				//当前日期   
	 this.nowDayOfWeek = now.getDay(); 					//今天本周的第几天  
	 this.nowYear = now.getYear(); 						//当前年   
	 this.nowMonth = now.getMonth(); 					//月   
	 this.nowDay = now.getDate(); 						//日 
	 this.nowYear += (this.nowYear < 2000) ? 1900 : 0;
	 var weekStartDate = new Date(this.nowYear, this.nowMonth, this.nowDay - this.nowDayOfWeek+1);  
	 return this.formatDate(weekStartDate);   
	 
}

/// 获取当前日期 当前周的最后一天
/// 返回 字符串日期格式("YYYY-MM-DD")
Date.prototype.GetWeekLastDay = function()
{
	 var now = new Date(this.getTime()); 				//当前日期   
	 this.nowDayOfWeek = now.getDay(); 					//今天本周的第几天  
	 this.nowYear = now.getYear(); 						//当前年   
	 this.nowMonth = now.getMonth(); 					//月   
	 this.nowDay = now.getDate(); 						//日 
	 this.nowYear += (this.nowYear < 2000) ? 1900 : 0;
	 var weekEndDate = new Date(this.nowYear, this.nowMonth, this.nowDay + (6 - this.nowDayOfWeek+1));  
	 return this.formatDate(weekEndDate); 
	 
}

/// 获取日期属于星期几
/// dayValue=“2019-01-01”
function getWeekByDay(dayValue){ 													//dayValue=“2019-01-01”
	 var day = new Date(Date.parse(dayValue.replace(/-/g, '/'))); 					//将日期值格式化 
	 var today = new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六"); 			//创建星期数组
	 return today[day.getDay()]; 													 //返一个星期中的某一天，其中0为星期日 
}

/// 字符串日期格式直接增减
/// dayValue=“2019-01-01”
/// addDays 增减天数
/// 返回 字符串日期格式("YYYY-MM-DD")
function addFormatDate(dayValue,addDays) {							// dayValue=“2019-01-01”
    var date = new Date(Date.parse(dayValue.replace(/-/g, '/'))); 		//将日期值格式化 
    var addDate = date.addDate(addDays);
    return addDate.formatDate(addDate);
}