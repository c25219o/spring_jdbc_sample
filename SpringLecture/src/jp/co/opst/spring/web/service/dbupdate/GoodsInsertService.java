package jp.co.opst.spring.web.service.dbupdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.opst.spring.web.db.dao.GoodsDao;
import jp.co.opst.spring.web.db.dto.Goods;

@Service
public class GoodsInsertService {

	@Autowired
	private GoodsDao goodsDao;

//	public GoodsDao getGoodsDao() {
//		return goodsDao;
//	}
//
//	public void setGoodsDao(GoodsDao goodsDao) {
//		this.goodsDao = goodsDao;
//	}
	// トランザクション対象としたい
	@Transactional
	public int updateGoods(Goods goods){
		return goodsDao.insertGoods(goods);
	}

}
