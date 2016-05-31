package jp.co.opst.spring.web.controller.dbupdate;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.opst.spring.web.db.dto.Goods;
import jp.co.opst.spring.web.service.dbupdate.GoodsInsertService;

@Controller
@SessionAttributes("insertGoods")
public class InsertGoodsController {

    @Autowired
    private GoodsInsertService service;

    // 確認画面から登録処理をして登録完了ページへ
    @RequestMapping(value = "/commitInsertGoods", method = RequestMethod.POST)
    public String insertGoods(Model model, HttpSession session, RedirectAttributes attributes, SessionStatus status) {
        System.out.println("POST:InsertGoodsController#insertGoods()");
         Goods goods = (Goods)model.asMap().get("insertGoods");
        if (goods == null) {
            System.out.println("登録したくてもセッションにデータがない！");
            return "redirect:/insertError.html";
        }
        System.out.println(goods);
        System.out.println(goods.getGoodsNum());
        try {
            // DBに登録する
            int count = this.service.updateGoods(goods);
            attributes.addFlashAttribute("count", count);
            return "redirect:/insertComp.html";
        } catch (DataAccessException e) {
            e.printStackTrace();
            System.out.println("データの登録に失敗！");
            return "redirect:/insertError.html";
        } finally {
            // DBに登録したので入力したデータをセッションから削除
            status.setComplete();
            System.out.println(session.getAttribute("insertGoods"));
        }
    }

    @RequestMapping(value = "insertComp", method = RequestMethod.GET)
    public String comp() {
        return "insertGoodsResult";
    }

    @RequestMapping(value = "insertError", method = RequestMethod.GET)
    public String error() {
        return "insertGoodsError";
    }

    // 確認画面の表示(POST)
    @RequestMapping(value = "/executeInsertGoods", method = RequestMethod.POST)
    public String confirm(@ModelAttribute Goods goods, HttpSession session, RedirectAttributes attributes) {
        System.out.println("InsertGoodsController#confirm()");
        attributes.addFlashAttribute("insertGoods", goods);
        return "redirect:/executeInsertGoods.html";
    }

    // 確認画面の表示(GET)
    // 不正遷移のためのチェックを行う
    @RequestMapping(value = "/executeInsertGoods", method = RequestMethod.GET)
    public String confirmGet(Model model, HttpSession session) {
        System.out.println("InsertGoodsController#confirmGet()");

        Goods goods1 = (Goods) model.asMap().get("insertGoods");
        Goods goods2 = (Goods) session.getAttribute("insertGoods");

        System.out.println("sessionの中身-->" + goods2);
        System.out.println("flushの中身-->" + goods1);

        // RedirectAttributeを使う
        if (goods1 == null) {
//        if (goods2 == null) {
            return "error";
        }
        System.out.println("goods#getGoodsNum-->" + goods1.getGoodsNum());
        // 確認画面に表示したいのでModelにセットしておく
        return "insertGoodsConfirm";
    }

    // 入力画面の表示
    @RequestMapping(value = "/insertGoods")
    public String form() {
        System.out.println("InsertGoodsController#form()");
        return "insertGoods";
    }

}
