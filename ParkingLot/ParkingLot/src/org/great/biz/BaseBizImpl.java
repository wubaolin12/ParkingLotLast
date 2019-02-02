package org.great.biz;
/**
 * 
 * 通用biz实现类，提供通用的业务方法，如增、删、改等操作
 * @author Yf
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.great.mapper.Mapper;
import org.springframework.stereotype.Service;
@Service("basebiz")
public class BaseBizImpl implements BaseBiz{
	@Resource
	private Mapper mapper;

	

	


	//生成查询sql语句的方法
	@Override
	public String creatSQL(String tb_name, Map map)
	{
		
		
		String sql="select * from "+tb_name;		
		//List collist=mm.getColname(tb_name);
		if(map!=null){
			Set set=map.keySet();
			List list=new ArrayList<>(set);
			if(list.size()>0){
				for(int i=0;i<list.size();i++){
					
					if(i==0) {
						sql=sql+" where  "+list.get(i)+" like '%"+map.get(list.get(i))+"%'";
					}else {
						sql=sql+" or "+list.get(i)+" like '%"+map.get(list.get(i))+"%'";
					}	
			
				}
			}
		
		}else{
			sql="select * from "+tb_name;
		}
		System.out.println("----BaseBizImpl:findListSql"+sql);
		return sql;
	}


	/**
	 * 插入数据的方法2.0
	 * @author ASUS yf
	 */
	@Override
	public int insertData(String tb_name, Map map,Map keymap) {
		// TODO Auto-generated method stub
		return mapper.insertData(map,keymap, tb_name);
	}

	/**
	 * 更新数据的方法2.0
	 * @author ASUS yf
	 */
	@Override
	public int updateData(String tb_name, Map map,String keykol,String id) {
		// TODO Auto-generated method stub
		return mapper.updateData(map, tb_name, keykol, id);
	}

	/**
	 *删除数据的方法2.0
	 * @author ASUS yf
	 */
	@Override
	public int delData(String tb_name, Map map) {
		// TODO Auto-generated method stub
		return mapper.delData(map, tb_name);
	}
	
	
}
