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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.opst.spring.web.db.dto.Goods;
import jp.co.opst.spring.web.service.dbupdate.GoodsInsertService;

@Controller
@SessionAttributes("insertGoods")
public class InsertGoodsController {

    @Autowired
    private GoodsInsertService service;

//    public GoodsInsertService getService() {
//        return service;
//    }
//
//    public void setService(GoodsInsertService service) {
//        this.service = service;
//    }

    // 確認画面から登録処理をして登録完了ページへ
    @RequestMapping(value = "/commitInsertGoods", method = RequestMethod.POST)
    public String insertGoods(Model model, HttpSession session, RedirectAttributes attributes) {
        System.out.println("POST:InsertGoodsController#insertGoods()");
        Goods goods = (Goods)session.getAttribute("insertGoods");
//        Goods goods = (Goods)model.asMap().get("insertGoods");
        if(goods == null){
            System.out.println("登録したくてもセッションにデータがない！");
            return "redirect:/insertError.html";
        }
        try{
            // DBに登録する
            int count = this.service.updateGoods(goods);
//            model.addAttribute("count", count);
            attributes.addFlashAttribute("count", count);
            session.removeAttribute("insertGoods");
            session.invalidate();
            return "redirect:/insertComp.html";
        } catch(DataAccessException e){
            e.printStackTrace();
            System.out.println("データの登録に失敗！");
            session.removeAttribute("insertGoods");
            session.invalidate();
            return "redirect:/insertError.html";
        } finally {
            //DBに登録したので入力したデータをセッションから削除
//            System.out.println("remove from session");
//            session.removeAttribute("insertGoods");
//            model.addAttribute("insertGoods", null);
//            model = null;
        }
    }

    @RequestMapping(value="insertComp", method=RequestMethod.GET)
    public String comp() {
        return "insertGoodsResult";
    }


    @RequestMapping(value="insertError", method=RequestMethod.GET)
    public String error() {
        return "insertGoodsError";
    }



    // 確認画面の表示(POST)
    @RequestMapping(value = "/executeInsertGoods", method = RequestMethod.POST)
    public String confirm(@ModelAttribute Goods goods, HttpSession session, /*Model model, HttpServletRequest request, */RedirectAttributes attributes){
        System.out.println("InsertGoodsController#confirm()");


        // System.out.println(goods);
        // 登録時に入力されたデータを使うのでセッションに保存
        //	まだ画面に描画しないのでModelに何もつけてない
//        System.out.println(session.getAttribute("insertGoods"));
//        model.addAttribute("insertGoods", goods);
        session.setAttribute("insertGoods", goods);


        attributes.addFlashAttribute("insertGoods", goods);
        return "redirect:/executeInsertGoods.html";
    }

    // 確認画面の表示(GET)
    // 不正遷移のためのチェックを行う
    @RequestMapping(value = "/executeInsertGoods", method = RequestMethod.GET)
    public String confirmGet(Model model, RedirectAttributes attributes, HttpSession session){
        System.out.println("InsertGoodsController#confirmGet()");
//        System.out.println(session);
//        Goods goods = (Goods)session.getAttribute("insertGoods");
//        Map<String, ?> map = attributes.getFlashAttributes();
//        System.out.println("map.size():" + map.size());
//        boolean found = false;
//        for (String key : map.keySet()) {
//            System.out.println(key);
//            if ("insertGoods".equals(key)) {
//                found = true;
//            }
//        }
//        if (!found) {
//        if (!attributes.containsAttribute("insertGoods")) {
        Goods goods1 = (Goods)model.asMap().get("insertGoods");
        Goods goods2 = (Goods)session.getAttribute("insertGoods");

        System.out.println("sessionの中身-->" + goods2);
        System.out.println("flushの中身-->" + goods1);

//        Set<Entry<String, Object>> entrySet = model.asMap().entrySet();
//        for (Entry<String, Object> entry : entrySet) {
//            System.out.println("entry.getKey() + entry.getValue().toString()-->"+entry.getKey() + entry.getValue().toString());
//        }
        if(goods1 == null){
            return "error";
        }
        attributes.addFlashAttribute("insertGoods", goods1);
//        session.removeAttribute("insertGoods");
//        session.setAttribute("insertGoods", goods);
        System.out.println("goods-->" + goods1);
        System.out.println("goods#getGoodsNum-->" + goods1.getGoodsNum());
        // 確認画面に表示したいのでModelにセットしておく
//        model.addAttribute("insertGoods", goods);
        return "insertGoodsConfirm";
    }

    // 入力画面の表示
    @RequestMapping(value="/insertGoods")
    public String form() {
        System.out.println("InsertGoodsController#form()");
        return "insertGoods";
    }

}
