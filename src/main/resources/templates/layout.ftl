<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>PayTools</title>
    <link rel="icon" href="/pic/pay.png" type="image/png">
    <link rel="stylesheet" type="text/css" href="/css/layout.css">
</head>

<body>

<!-- 盤口選擇 -->
<section class="panel-selection">
    <h3>盤口選擇</h3>
    <div class="search-panel">
        <label for="company-search">盤口模糊搜尋</label>
        <input id="company-search" class="find-company" type="text" value="test4">
    </div>
    <div class="com-total"></div>
    <div class="selection-title">
        <div class="nozzle-type-right" id="addNozzleType"></div>
    </div>

    <table id="exportTable">
        <thead>
        <tr>
            <td colspan="7">
                <button id="add">添加</button>
                <button id="submit" style="float: right;">导出</button>
            </td>
        </tr>
        </thead>
    </table>
</section>

<!-- 修改導出腳本內容 -->
<section class="script-modification">
    <h3>修改導出腳本內容</h3>
    <div class="input-group">
        <label for="platform-name">中文</label>
        <input type="text" id="platform-name" value="中文">
    </div>
    <div class="input-group">
        <label for="platform-code">英文</label>
        <input type="text" id="platform-code" value="英文">
    </div>
    <div class="input-group">
        <label for="merchant-code">商戶號</label>
        <input type="text" id="merchant-code" value="商戶號">
    </div>
    <div class="input-group">
        <label for="secret-code">密鑰</label>
        <input type="text" id="secret-code" class="long-input" value="密鑰">
    </div>
    <div class="input-group">
        <label for="ip-address">IP</label>
        <input type="text" id="ip-address" value="IP">
    </div>
    <div class="input-group">
        <label for="successful-url">下單地址</label>
        <input type="text" id="successful-url" class="long-input" value="下單地址">
    </div>
    <div class="input-group">
        <label for="query-url">查詢地址</label>
        <input type="text" id="query-url" class="long-input" value="查詢地址">
    </div>
    <div class="input-group">
        <label for="channel-code">通道编码</label>
        <input type="text" id="channel-code" value="通道编码">
    </div>
</section>

<!-- 支付選擇 -->
<section class="payment-selection">
    <h3>支付選擇</h3>
    <table width="100%" id="mytab" border="1" class="payment-table">
        <thead>
        <tr>
            <th width="2%">選擇</th>
            <th class="pick-id">ID</th>
            <th class="find-chinese">中文 PLATFORM_NAME<input class="search-word" type="text"></th>
            <th class="find-english">英文 PLATFORM_CODE<input class="zf-eng" type="text"></th>
            <th class="find-pay-url">下單地址 SUCCESS_URL<input class="pay-url" type="text" value="/pay/order"></th>
            <th class="find-query-url">查詢地址 QUERY_URL<input class="check-url" type="text"></th>
            <th class="find-params">請求參數 t_pay_request_model-REQUERT_VALUE<br>
                <label>一<input class="param1" type="text"></label>
                <label>二<input class="param2" type="text"></label>
                <label>三<input class="param3" type="text"></label>
                <label>四<input class="param4" type="text"></label>
                <label>五<input class="param5" type="text"></label>
            </th>
        </tr>
        </thead>
        <tbody id="dataList">
        <!-- 這裡會動態插入資料 -->
        </tbody>
    </table>
</section>

<!-- 返回頂部按鈕 -->
<button onclick="topFunction()" id="movetop" title="回到頂部">
    &#10548;
</button>

<!-- 外部 JavaScript -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="/js/layout.js"></script>

</body>
</html>
