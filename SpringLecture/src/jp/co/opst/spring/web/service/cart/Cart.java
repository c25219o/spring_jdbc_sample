package jp.co.opst.spring.web.service.cart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
	private List<CartGoods> goodsList = new ArrayList<>();


	public void addCart(String name, Integer value) {
		goodsList.add(new CartGoods(name, value));
		System.out.println(goodsList.size());
	}

	public List<CartGoods> getAllCartGoods() {
		return goodsList;
	}

}
