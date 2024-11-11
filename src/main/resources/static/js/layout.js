var newTr = "<tr><td><button id=''  onclick='deleteTr(this);'>删除</button></td><td>平台名：<input id='platformName' type='text' name='platformName' /></td><td>最大平台ID：<input type='text' name='platformId' /></td><td>最大方法ID：<input type='text' name='methodId' /></td><td>最大通道ID：<input type='text' name='channelId' /></td><td>最大算法模板ID：<input type='text' name='modelId' /></td><td>回调地址：<input id='callback' type='text' name='callback'/></td></tr>";

const myPlatformCode = document.querySelector('#myPlatformCode')

const searchWord = document.querySelector('.searchWord'); //中文
const payURL = document.querySelector('.payURL'); //下單地址
const strategy = document.querySelector('.strategy'); //下單地址
const zfEng = document.querySelector('.zfEng'); //英文
const checkURL = document.querySelector('.checkURL'); //查詢地址
const param1 = document.querySelector('.param1'); //查詢地址
const param2 = document.querySelector('.param2'); //查詢地址
const param3 = document.querySelector('.param3'); //查詢地址
const param4 = document.querySelector('.param4'); //查詢地址
const param5 = document.querySelector('.param5'); //查詢地址
let myObject = {} // 收集導出腳本的修改數據


function PlatformBO(platformName, platformId, methodId, channelId, modelId, callback ,
                    myPlatformName, myPlatformCode, myMerchantCode, mySuccessfulURL, myQueryURL, mySecretCode, myIP, myChannelCode) {
    this.platformName = platformName;
    this.platformId = platformId;
    this.methodId = methodId;
    this.channelId = channelId;
    this.modelId = modelId;

    this.myPlatformName = myPlatformName;
    this.myPlatformCode = myPlatformCode;
    this.myMerchantCode = myMerchantCode;
    this.mySuccessfulURL = mySuccessfulURL;
    this.myQueryURL = myQueryURL;
    this.mySecretCode = mySecretCode;
    this.myIP = myIP;

    this.myChannelCode = myChannelCode;

    this.callback = callback;
    return this;
}
// 這種寫法的完整形式是 $(document).ready(function () {})。
// 它的作用是等待整個 DOM 結構加載完畢後再執行指定的 JavaScript 函數。
// 這樣可以避免因為 DOM 尚未加載完全而導致的操作錯誤。


$(function () {
    // 當用戶點擊具有 id="add" 的按鈕時，將在 #exportTable 表格的最後一行後添加一個新的表格行。newTr 變量應包含要添加的行的 HTML 代碼
    $("#add").click(function () {
        var lastTr = $("#exportTable tr:last");
        lastTr.after(newTr);
    });


//測試收集數據
//         $('.myInput input').click(function (){
//             const myInputs = document.querySelectorAll('.myInput input')
//
//             myInputs.forEach( input =>{
//                 myObject[input.id] =input.value
//             })
//
//             console.log('myObject:')
//             console.log(myObject)
//
//         })



    // 導出按鈕點擊事件
    $("#submit").click(function () {

        const myInputs = document.querySelectorAll('.myInput input')

        myInputs.forEach( myInput =>{
            myObject[myInput.id] =myInput.value
        })
        console.log('myObject')
        console.log(myObject)





        var ids = new Array();
        var platforms = new Array();
        var check = $("table#mytab input[type=checkbox]:checked"); //在table中找input下类型为checkbox属性为选中状态的数据
        check.each(function () {//遍历
            var row = $(this).parent("td").parent("tr");//获取选中行

            console.log("row:")
            console.log(row)
            var id = $(row.find("td[data-platform-id]")).data("platform-id"); // 获取数据属性

            console.log("id:")
            console.log(id)
            ids[ids.length] = id;
        });

        if (1 > ids.length) {
            alert("请选择要导出的第三方平台");
            return;
        }
        var exportTrs = $("table#exportTable").find("tr");

        for (var i = 1; i < exportTrs.length; i++) {


            var tdArr = exportTrs.eq(i).find("td");
            // 這邊是使用js的function而非java對象
            var platform = new PlatformBO( // test4 17147 1016992063 1016992063 17147 http://pay.btest4wohjelay.com:5222/pay/api/callback
                $(tdArr[1]).find('input').val(),
                $(tdArr[2]).find('input').val(),
                $(tdArr[3]).find('input').val(),
                $(tdArr[4]).find('input').val(),
                $(tdArr[5]).find('input').val(),
                $(tdArr[6]).find('input').val(),
                myObject.myPlatformName,
                myObject.myPlatformCode,
                myObject.myMerchantCode,
                myObject.mySuccessfulURL,
                myObject.myQueryURL,
                myObject.mySecretCode,
                myObject.myIP,
                myObject.myChannelCode

            );
            console.log('platform:')
            console.log(platform)


            // if(i!=1){
            platforms.push(platform);
            // }
        }

        if (null == platforms || 1 > platforms.length) {
            alert("请输入导出平台");
        }
        var json = {
            "channels": ids,
            "platforms": platforms
        };

        console.log(`json.channels : `)
        console.log(json.channels)
        console.log(`json.platforms : `)
        console.log(json.platforms)
        // 導出
        $.ajax({
            type: "POST",
            url: "/pay-generate/generate/paySql",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(json),
            success: function (data) {
                if ("success" == data) {
                    alert("导出完成！");
                } else {
                    alert("导出失败！");
                }
            }
        });
    });
});



/*點擊盤口按鈕的操作*/
function addNozzle(id) {
    var flag_01 = "appCode_" + id;
    var flag_02 = "appCallUrl_" + id;
    var flag_03 = "appDomain_" + id;

    var appCode = $("#" + flag_01).val();      //对应的编码
    var appCallUrl = $("#" + flag_02).val(); //对应的盘口返回地址
    var appDomain = $("#" + flag_03).val();   // 对应的盘口地址

    console.info("appCode:" + appCode);
    console.info("appCallUrl:" + appCallUrl);
    console.info("appDomain:" + appDomain);

    var d = {};
    d.appCode = appCode;
    d.appDomain = appDomain;

    if (id === 'test4') {
        document.querySelector('#test4').style.backgroundColor = "#2F589C";
        document.querySelector('#test4').style.color = "yellow";
    }

    // 查詢最大值
    $.ajax({
        type: "POST",
        url: "/pay-generate/payPlatform/getPlatformMaxInfo",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(d),
        success: function (data) {

            /*成功情况下*/
            var data = eval('(' + data + ')');
            console.info(data)

            var newTrDebug = "<tr id='tr_" + id + "'><td><button id=''  onclick=deleteTr('" + id + "')>删除</button></td>" +
                "<td>平台名：<input id='platformName_" + id + "'  type='text' name='platformName' /></td>" +
                "<td>最大平台ID：    <input type='text' id='platformId_" + id + "' name='platformId' /></td>" +
                "<td>最大方法ID：    <input type='text' id='methodId_" + id + "'  name='payMethodId' /></td>" +
                "<td>最大通道ID：    <input type='text'  id='channelId_" + id + "' name='payChannelId' /></td>" +
                "<td>最大算法模板ID：<input type='text' id='modelId_" + id + "' name='payModleId' />" +
                "</td><td>回调地址：<input id='callback_" + id + "' type='text' name='callback'/></td></tr>";


            /*1、请求盘口获取对应的最大值*/
            var payPlatformMaxId = data.platMaxInfo.platformId;//最大平台id
            var payRequestModelMaxId = data.platMaxInfo.payModleId;//最大算法模板id
            var payChannelMaxId = data.platMaxInfo.payChannelId;//最大支付渠道id
            var payMethodMaxId = data.platMaxInfo.payMethodId;//最大方法id

            /*2、进行添加页面输入框*/
            var lastTr = $("#exportTable tr:last");
            lastTr.after(newTrDebug);

            /*页面赋值*/
            $("#platformName_" + id).val(appCode);
            $("#platformId_" + id).val(payPlatformMaxId);
            $("#methodId_" + id).val(payMethodMaxId);
            $("#channelId_" + id).val(payChannelMaxId);
            $("#modelId_" + id).val(payRequestModelMaxId);
            $("#callback_" + id).val(appCallUrl);

            /*4、页面按钮设置不能点击*/
            $("#" + id).attr({"disabled": "disabled"});
            $("#" + id).attr({"disabled": "disabled"});
            $("#" + id).addClass("huiSe");
        }
    });

}


/*删除行数*/
function deleteTr(nowTr) {
    $("#tr_" + nowTr).remove();
    var nozzleId = $(nowTr).attr('id');//获取id
    console.log("删除的id:" + nozzleId);
    //删除行数之后恢复对应的点击盘口按钮，使得再次可以进行添加盘口
    $("#" + nowTr).removeAttr("disabled");//将按钮可用
    $("#" + nowTr).removeClass("huiSe");
}

// 返回頂部
function topFunction() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}

const com = document.querySelector('.findCompany')
// 用 AppCode 搜尋盤口(暫寫死)  select * from 8bet.t_pay_app_type where app_code = 'test4';

// 進入頁面自動加載盤口
loadAppTpes(com)

// 模糊搜尋盤口
function loadAppTpes(com){
    $.getJSON("/pay-generate/payPlatform/queryAppTypeByAppCode",{
            com: com
        }
        , function (data) {
            // console.log(data.appType)
            const datas = data.appType
            let html = ''

            datas.forEach( appId =>{
                html += "<div class='appTypeList' id='appType_" + appId.appCode + "'>" +
                    " <input type='hidden' id='appCode_" + appId.appCode + "' value='" + appId.appCode + "'/>" +
                    " <input type='hidden' id='appCallUrl_" + appId.appCode + "' value='" + appId.appCallUrl + "'/>" +
                    "<input type='hidden' id='appDomain_" + appId.appCode + "' value='" + appId.appDomain + "'/>" +
                    " <button id='" + appId.appCode + "' class='buttonClass' onclick=addNozzle('" + appId.appCode + "')>" + appId.appName + "</button>" +
                    "</div>";
            })


            $('#addNozzleType').html(html);
            $('.comTotal').html(`共${datas.length}個盤口`)
        })
}

//盤口模糊搜尋-欄位enter事件
document.querySelector('.findCompany').addEventListener('keydown',function (e){
    console.log(e.code)

    if(e.code === 'Enter'){
        loadAppTpes(document.querySelector('.findCompany').value)

    }
})





// 將支付選擇按鈕註冊點擊搜尋
render(payURL, searchWord, zfEng, checkURL, param1, param2, param3, param4, param5, strategy)
// 支付-模糊搜尋
function render(...inputs) {

    // 遍歷所有參數
    inputs.forEach(input => {
        input.addEventListener('keydown', (e) => {

            if (e.key === 'Enter') {
                let platformName = searchWord.value
                let successUrl = payURL.value
                let platformCode = zfEng.value
                // let str = strategy.value
                let queryUrl = checkURL.value
                let requestParam1 = param1.value
                let requestParam2 = param2.value
                let requestParam3 = param3.value
                let requestParam4 = param4.value
                let requestParam5 = param5.value

                $("#dataList").html(searchWord.value)
                console.log(`platformName:'${platformName}',platformCode:'${platformCode}',successUrl:'${successUrl}',queryUrl:'${queryUrl}',requestParam1:'${requestParam1}'`)
                // 模糊查詢
                // platformName, platformCode, successUrl
                $.getJSON("/pay-generate/payPlatform/fuzzyQueryPlatformByPlatformName", {
                    platformName: platformName,
                    platformCode: platformCode,
                    successUrl: successUrl,
                    queryUrl: queryUrl,
                    requestParam1: requestParam1,
                    requestParam2: requestParam2,
                    requestParam3: requestParam3,
                    requestParam4: requestParam4,
                    requestParam5: requestParam5,

                }, function (data) {
                    console.log('模糊查詢...')
                    console.log(data)
                    const zf = data.platform


                    var html = '';
                    $.each(zf, function (commentIndex, comment) {
                        html +=
                            "<tr></tr>" +


                            "<td><input type='checkbox' name='platform'/></td> + " +
                            "<td data-platform-id='" + comment.payPlatformId + "'>" + comment.payPlatformId + "</td>" +
                            "<td>" + comment.platformName + "</td>" + //中
                            "<td>" + comment.platformCode + "</td>" +
                            // "<td>" + comment. + "</td>" +
                            "<td>" + comment.successUrl + "</td>" +
                            "<td>" + comment.queryUrl + "</td>" +
                            "<td>" + comment.requertValue + "</td>" +
                            "</td></tr>";
                    });
                    $('#dataList').html(html);
                })
            }
        });
    })
}
