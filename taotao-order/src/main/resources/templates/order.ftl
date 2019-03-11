<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <div align="context">
    <h1>订单中心</h1>
    <span>订单编号${order.orderNum} --------></span><span>购买时间:${order.createTime?string('yyyy-MM-dd HH:mm:ss')}</span>
   <p></p> <span>订单商品名称${order.productName}</span>
    <p></p><span  style="color: red">订单价格${order.money}</span><p></p>
    <a href="/order/PayOrder?orderNum=${order.orderNum}">支付</a>
    </div>
</body>
</html>