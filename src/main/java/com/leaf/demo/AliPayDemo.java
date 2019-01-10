package com.leaf.demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;

import entity.AlipayConfig;
import entity.IdWorker;

@RestController
@RequestMapping("/pay")
public class AliPayDemo {
	/*
	 * @RequestMapping("/qrPay") public Map payDemo() { Map map1 = new HashMap<>();
	 * // 获得初始化的AlipayClient AlipayClient alipayClient = new
	 * DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
	 * AlipayConfig.merchant_private_key, "json", AlipayConfig.charset,
	 * AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
	 * AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
	 * 
	 * Map map = new HashMap<>(); IdWorker idWorker = new IdWorker();
	 * map.put("out_trade_no", idWorker.nextId() + ""); map.put("total_amount",
	 * "88.6"); map.put("subject", "Apple+" + idWorker.nextId()); String jsonString
	 * = JSON.toJSONString(map); request.setBizContent(jsonString); try {
	 * AlipayTradePrecreateResponse response = alipayClient.execute(request);
	 * boolean success = response.isSuccess(); System.out.println(success);
	 * System.out.println(JSON.toJSONString(response)); Map parseObject =
	 * JSON.parseObject(JSON.toJSONString(response),Map.class); for (Object obj :
	 * parseObject.keySet()) {
	 * System.out.println("key---:"+obj+"    value---:"+parseObject.get(obj)); }
	 * Object body = parseObject.get("body"); System.out.println(body); Map
	 * parseObject2 = JSON.parseObject(body+"",Map.class);
	 * System.out.println(parseObject2.get("alipay_trade_precreate_response")); Map
	 * parseObject3 =
	 * JSON.parseObject(parseObject2.get("alipay_trade_precreate_response")+"",
	 * Map.class); for (Object obj : parseObject3.keySet()) {
	 * System.out.println("key---:"+obj+"    value---:"+parseObject3.get(obj)); } }
	 * catch (AlipayApiException e) { e.printStackTrace(); } return map1; }
	 */

	@RequestMapping("/qrPay")
	public Map payDemo() {
		Map map1 = new HashMap<>();
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);
		AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();

		Map map = new HashMap<>();
		IdWorker idWorker = new IdWorker();
		map.put("out_trade_no", idWorker.nextId() + "");
		map.put("total_amount", "0.1");
		map.put("subject", "Apple " + idWorker.nextId());
		String jsonString = JSON.toJSONString(map);
		request.setBizContent(jsonString);
		try {
			AlipayTradePrecreateResponse response = alipayClient.execute(request);
			boolean success = response.isSuccess();
			Map responseMap = JSON.parseObject(JSON.toJSONString(response), Map.class);
			System.out.println(responseMap);
			Object params = responseMap.get("params");

			Map paramsMap = JSON.parseObject(params + "", Map.class);
			for (Object obj : paramsMap.keySet()) {
				if ("biz_content".equals(obj)) {
					Map biz_content_Map = JSON.parseObject(paramsMap.get(obj) + "", Map.class);
//					for (Object key : biz_content_Map.keySet()) {
//						map.put(key, biz_content_Map.get(key));
//					}
					map1.putAll(biz_content_Map);
				}

			}
			Object body = responseMap.get("body");
			
			Map bodyMap = JSON.parseObject(body + "", Map.class);
			Map alipay_trade_precreate_response_map = JSON
					.parseObject(bodyMap.get("alipay_trade_precreate_response") + "", Map.class);
//			for(Object key : alipay_trade_precreate_response_map.keySet()) {
//				 map1.put(key, alipay_trade_precreate_response_map.get(key));
//			}
			map1.putAll(alipay_trade_precreate_response_map);
			return map1;
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		return map1;
	}

	/*
	 * @RequestMapping("/qrPay") public Map payDemo() { Map map1 = new HashMap<>();
	 * // 获得初始化的AlipayClient AlipayClient alipayClient = new
	 * DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
	 * AlipayConfig.merchant_private_key, "json", AlipayConfig.charset,
	 * AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
	 * AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
	 * 
	 * Map map = new HashMap<>(); IdWorker idWorker = new IdWorker();
	 * map.put("out_trade_no", idWorker.nextId() + ""); map.put("total_amount",
	 * "0.1"); map.put("subject", "Apple+" + idWorker.nextId()); String jsonString =
	 * JSON.toJSONString(map); request.setBizContent(jsonString); try {
	 * AlipayTradePrecreateResponse response = alipayClient.execute(request);
	 * boolean success = response.isSuccess(); Map parseObject =
	 * JSON.parseObject(JSON.toJSONString(response),Map.class); //
	 * System.out.println(parseObject); Object object = parseObject.get("params");
	 * // System.out.println(object); Map obj1 =
	 * JSON.parseObject(object+"",Map.class); for (Object obj : obj1.keySet()) { //
	 * System.out.println("key--:"+obj+"   value---:"+obj1.get(obj));
	 * if("biz_content".equals(obj)) { Map parseObject2 =
	 * JSON.parseObject(obj1.get(obj)+"", Map.class); for (Object key :
	 * parseObject2.keySet()) { //
	 * System.out.println("key--:"+key+"   value---:"+parseObject2.get(key));
	 * map1.put(key, parseObject2.get(key)); } }
	 * 
	 * } Object body = parseObject.get("body"); Map parseObject2 =
	 * JSON.parseObject(body+"",Map.class); Map parseObject3 =
	 * JSON.parseObject(parseObject2.get("alipay_trade_precreate_response")+"",
	 * Map.class); for (Object obj : parseObject3.keySet()) { //
	 * System.out.println("key---:"+obj+"    value---:"+parseObject3.get(obj));
	 * map1.put(obj, parseObject3.get(obj)); } } catch (AlipayApiException e) {
	 * e.printStackTrace(); } return map1; }
	 */
	@Test
	public void demo() {
		Map map = payDemo();
		System.out.println(map);
	}
	
	@Test
	public void query() throws Exception {
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);
		AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
		
		Map map  = new HashMap<>();
		map.put("out_trade_no", "1083158253275299840");
		request.setBizContent(JSON.toJSONString(map));
		AlipayTradeQueryResponse response = alipayClient.execute(request);
		Map responseMap = JSON.parseObject(JSON.toJSONString(response), Map.class);
		System.out.println(responseMap.get("msg")+"    "+responseMap.get("code"));
		Object body = responseMap.get("body");
		Map bodyMap = JSON.parseObject(body+"", Map.class);
		System.out.println(bodyMap);
		Map alipay_trade_query_response_map = JSON.parseObject(bodyMap.get("alipay_trade_query_response") + "", Map.class);
		Object tradeStatus = alipay_trade_query_response_map.get("trade_status");
		System.out.println(tradeStatus);
	}
//	{alipay_trade_query_response={"msg":"Success","code":"10000","buyer_user_id":"2088102177300399","send_pay_date":"2019-01-10 08:54:01","invoice_amount":"0.10","fund_bill_list":[{"amount":"0.10","fund_channel":"ALIPAYACCOUNT"}],"out_trade_no":"1083158253275299840","total_amount":"0.10","buyer_user_type":"PRIVATE","trade_status":"TRADE_SUCCESS","trade_no":"2019011022001400390502884793","buyer_logon_id":"ysq***@sandbox.com","receipt_amount":"0.10","point_amount":"0.00","buyer_pay_amount":"0.10"}, sign=gOD1XPC5NxgofZUmZczW+7UPMum2ZwlgTr70vocACCQCrE/CSJOZoyiRB0OMGKS1uTMUitwAP7FGUcVfS+nBEzQICilYZox9g0+BC/qiXA5J5qT3jsffgdrJfN9NhiXxJqM2NUgYV1PYreOLwiCwUSR5PlBttXXaGkUIMJO8KbYc6gFPjWbRiwU718S1hTBLPLujVyqZZYR6YJqKUfFctpg8B3rJRj3UIrGXSOy5+XhrJOGK37k6bv+QgACxE6k4qPfimBkeKflGJ6Yh3d3TtayBty8DbbpVUlJtqPWoDNl5AODLTTVfrajYN/lW2v+xu081OoGAXfAHyGb4Iikl4w==}	
}
