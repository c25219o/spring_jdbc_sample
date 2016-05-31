package jp.co.opst.spring.web.controller.cart;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CartParam {

	@NotEmpty(message="{cart.message.NotEmpty}")
//	@NotEmpty
	private String name;

//	@NotEmpty
	@NotNull
	@DecimalMin("1")
	//inclusiveをtrueにすると、value以下まで、falseにすると、value未満まで
	@DecimalMax(value = "100", inclusive = true, message="{cart.message.max}")
	private Integer value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
