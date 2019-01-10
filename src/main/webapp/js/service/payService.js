//服务层
app.service('payService',function($http){
	this.qrPay=function(){
		return $http.get("../pay/qrPay.do");
	}
});
