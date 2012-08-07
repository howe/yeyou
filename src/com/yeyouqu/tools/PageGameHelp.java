package com.yeyouqu.tools;

import org.nutz.json.Json;
import org.nutz.mvc.annotation.At;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Item;
import com.taobao.api.request.ItemGetRequest;
import com.taobao.api.response.ItemGetResponse;

/**
 * 页游工具
 * 
 * @author yangq(qi.yang.cn@gmail.com) 2012-7-31
 */
@At("/PageGameHelp")
public class PageGameHelp {

	@At
	/** 通过商品主键获取商品 */
	public static String queryGoodsById(Long id, String jsonpcallback) throws Exception {

		TaobaoClient client = new DefaultTaobaoClient(	"http://gw.api.taobao.com/router/rest",
														"12482076",
														"8cdd79bc1a6b340696512fb64d8f3a3f");
		ItemGetRequest req = new ItemGetRequest();
		req.setFields("detail_url,num_iid,title,nick,type,cid,seller_cids,props,input_pids,input_str,desc,pic_url,num,valid_thru,list_time,delist_time,stuff_status,location,price,post_fee,express_fee,ems_fee,has_discount,freight_payer,has_invoice,has_warranty,has_showcase,modified,increment,approve_status,postage_id,product_id,auction_point,property_alias,item_img,prop_img,sku,video,outer_id,is_virtual");
		req.setNumIid(id);
		ItemGetResponse response = client.execute(req);
		Item item = response.getItem();

		com.yeyouqu.bean.Item it = new com.yeyouqu.bean.Item();
		it.setName(item.getTitle());
		it.setNumber(item.getNum());
		it.setPrice(item.getPrice());
		it.setPicUrl(item.getPicUrl());

		// jsonpcallback
		StringBuilder strs = new StringBuilder();
		strs.append(jsonpcallback);
		strs.append("(");
		strs.append(Json.toJson(it));
		strs.append(")");

		System.out.println(strs);

		return strs.toString();

	}
}
