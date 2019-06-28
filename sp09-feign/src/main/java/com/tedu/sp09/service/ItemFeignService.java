package com.tedu.sp09.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tedu.sp01.pojo.Item;
import com.tedu.web.util.JsonResult;

//通过指定服务id可以知道向哪一台主机转发调用
//http://localhost:8001
//http://localhost:8002
@FeignClient(name = "item-service",fallback = ItemFeignServiceFB.class)
public interface ItemFeignService {
	/*
	 * 利用String MVC注解,反向生成访问路径
	 * 根据Mapping中指定的路径,在主机地址后面拼接路径
	 * 
	 * 根据@PathVariable配置,把参数数据..拼接到路径当中
	 * 假设参数是'123'
	 *http://localhost:8001/123 
	 * */
	@GetMapping("/{orderId}")
	JsonResult<List<Item>> getItems(@PathVariable String orderId);
	/*
	 * 根据配置,配置下面的路径,
	 * 
	 * */
	@PostMapping("/decreaseNumber")
	JsonResult decreaseNumber(@RequestBody List<Item> items);
}
