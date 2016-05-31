package jp.co.opst.spring.web.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.opst.spring.web.db.dto.Goods;

@Repository
public class GoodsDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterTemplate;

	// 会員情報マッピング
	private class GoodsRowMapper extends BeanPropertyRowMapper<Goods> {
		@Override
		public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {
			Goods goods = new Goods();
			goods.setGoodsNum(rs.getString("GOODS_NUM"));
			goods.setName(rs.getString("GOODS_NAME"));
			goods.setPrice(rs.getInt("GOODS_PRICE"));
			goods.setMaker(rs.getString("MAKER"));
			goods.setExp(rs.getString("GOODS_EXP"));
			goods.setDate(rs.getDate("REG_DATE"));
			goods.setLastUpdateTime(rs.getTimestamp("LST_UPDATE_TIME"));
			return goods;
		}
	}

	// 全件検索
	public List<Goods> findAll() {
		String sql = "select * from MEMBER";
		List<Goods> goodsList = this.namedParameterTemplate.query(sql, new GoodsRowMapper());
		return goodsList;
	}

	// 一件追加
	public int insertGoods(Goods goods) {
		String sql = "insert into GOODS  (GOODS_NUM, GOODS_NAME, GOODS_PRICE, GOODS_EXP, MAKER, LST_UPDATE_TIME) values "
				+ "(:num, :name, :price, :exp, :maker, :lastUpdateTime)";
		MapSqlParameterSource paramMap = new MapSqlParameterSource().addValue("num", goods.getGoodsNum())
				.addValue("name", goods.getName()).addValue("price", goods.getPrice()).addValue("exp", goods.getExp()).addValue("maker", goods.getMaker())
				.addValue("lastUpdateTime", new java.sql.Timestamp(new GregorianCalendar().getTimeInMillis()));



		//return this.namedParameterTemplate.update(sql, paramMap);
		int count =  this.namedParameterTemplate.update(sql, paramMap);

		// わざとコケるSQLを発行する キーの重複でエラーになる
		// 一件目のデータが登録されてしまうのか、ロールバックして全部なかったことになるのか確認する
		//int count1=  this.namedParameterTemplate.update(sql, paramMap);
		//return count1;
		return count;
	}
}
