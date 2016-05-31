package jp.co.opst.spring.web.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.opst.spring.web.db.dto.Member;

@Repository
public class MemberDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterTemplate;

	// 会員情報マッピング
	private class MemberRowMapper extends BeanPropertyRowMapper<Member> {
		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			Member mem = new Member();
			mem.setMemNum(rs.getString("MEM_NUM"));
			mem.setFstName(rs.getString("FST_NAME"));
			mem.setLstName(rs.getString("LST_NAME"));
			return mem;
		}
	}

	private BeanPropertyRowMapper<Member> mapper = new BeanPropertyRowMapper<Member>() {
		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			Member mem = new Member();
			mem.setMemNum(rs.getString("MEM_NUM"));
			mem.setFstName(rs.getString("FST_NAME"));
			mem.setLstName(rs.getString("LST_NAME"));
			return mem;
		}
	};

	// 全件検索
	public List<Member> findAll() {
		String sql = "select * from MEMBER";
		List<Member> memberList = this.namedParameterTemplate.query(sql, new MemberRowMapper());
		return memberList;
	}

	// 会員番号による一件引き
	public List<Member> findBymemberNumber(String number) {
		String sql = "select * from MEMBER where MEM_NUM = :number";
		MapSqlParameterSource param = new MapSqlParameterSource().addValue("number", number);
		return this.namedParameterTemplate.query(sql, param, new MemberRowMapper());
	}

}
