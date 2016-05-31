package jp.co.opst.spring.web.service.cart;

public class CartGoods {

	private String name;
	private Integer value;

	public CartGoods(String name, Integer value){
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Integer getValue() {
		return value;
	}

}
