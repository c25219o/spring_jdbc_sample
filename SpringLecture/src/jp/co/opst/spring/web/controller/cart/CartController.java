package jp.co.opst.spring.web.controller.cart;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
//import org.springframework.web.servlet.ModelAndView;

//import jp.co.opst.spring.web.CartParam;
import jp.co.opst.spring.web.service.cart.Cart;

@Controller
//@SessionAttributes("scopedTarget.cart")
public class CartController {

    @Autowired
    private Cart cart;

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
////	public String addCart(@RequestParam String name, @RequestParam String value, Model model) {
////	public ModelAndView addCart(@RequestParam String name, @RequestParam String value) {
//    // @ModelAndView をつけたインスタンスのライフサイクルはリクエスト
//    public ModelAndView addCart(@Valid @ModelAttribute CartParam cartParam, BindingResult errors, Model model) {
//
//        System.out.println("CartController#addCart()");
//        String name = cartParam.getName();
//        Integer value = cartParam.getValue();
//        System.out.println("name=" + name);
//        System.out.println("value=" + value);
//
//        if (cart.getAllCartGoods().size() > 3) {
//            //第一引数はform(bean)のプロパティ名
//            //第二引数はmessage.propetiesの名前
//            errors.rejectValue("name", "cart.message.full");
//        }
//
//        if (errors.hasErrors()) {
//            model.addAttribute("errorMsg", "設定値がおかしい");
//        } else {
//            cart.addCart(name, value);
//        }
//
////		model.addAttribute("cart", cart);
////		return "addCart";
//        return new ModelAndView("addCart", "cart", cart);
//    }



    @RequestMapping(value = "/add", method = RequestMethod.POST)
    // public ModelAndView addCart(@RequestParam String name, @RequestParam String value) {
    public String addCart(Model model, @Valid @ModelAttribute CartParam cartParam, BindingResult errors) {
    //public String addCart(Model model, @Valid @ModelAttribute CartParam cartParam, BindingResult errors) {
        // @ModelAttributeアノテーションを付けたインスタンスは、自動的にリクエストスコープに設定
        System.out.println("POST:CartController#addCart()");
        if (errors.hasErrors()) {
            //errors.rejectValue("name", "cart.message.full");
            System.out.println("バリデーションに引っかかる");
            model.addAttribute("cart", cart);
            return "addCart";
        } else {
            cart.addCart(cartParam.getName(), cartParam.getValue());
        }
        model.addAttribute("cart", cart);
        return "redirect:/add.html";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddCart(Model model){
        System.out.println("GET:CartController#cart()");
        model.addAttribute("cart", cart);
        return "addCart";
    }

    @RequestMapping("/addCart")
    //public String cart(Model model) {
    public String cart(){
        //model.addAttribute("cart", cart);
        System.out.println("CartController#cart()");
        return "addCart";
    }

    @RequestMapping("/returnMenu")
    public String menu() {
        System.out.println("CartController#menu()");
        return "menu";

    }

    @RequestMapping("/clear")
    public String clear(Model model, SessionStatus sessionStatus){
        System.out.println("CartController#clear()");
        sessionStatus.setComplete();
        model.addAttribute("cart", cart);
        return "addCart";
    }


}
