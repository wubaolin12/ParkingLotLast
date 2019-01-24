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
	/**
	 * 通用插入记录方法，输入表名参数,以及mapper，springmvc框架下，可以直接获得一个map
	 * 键为表单名，值为表单值，所以表单名与字段名相同，即可实现生成sql语句
	 * @param tb_name
	 * @param map
	 * @return
	 */
	public int insertObject(String tb_name,Map map) {
		// TODO Auto-generated method stub
		String sql="insert into "+tb_name+" (";
		String sql2=" values ('";
		int num=0;
		if(map !=null) {
			Set set=map.keySet();
			List list=new ArrayList<>(set);
			for(int i = 0; i < list.size(); i++) {
				if(map.get(list.get(i))==null||map.get(list.get(i))=="") {
					list.remove(list.get(i));
				}
			}
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					if (i != list.size() - 1) {
						
							sql=sql+list.get(i)+",";
							sql2=sql2+map.get(list.get(i))+"','";
						
					} else {
						
							sql=sql+list.get(i)+")";
							sql2=sql2+map.get(list.get(i))+"')";
						
					}
				}
				String sql3=sql+sql2;
				System.out.println("------insert sql="+sql3);
				num=mapper.interObject(sql3);
				System.out.println("biznum"+num);
				
			}

		}
		
		return num;
	}
	
	/**
	 * 通用更新数据库方法，map为从handler传来的map，map的键为字段名，值为要更新到库里的数据，key为作为条件的
	 * 字段，如u_id，keyid就是相应的id，方法会进行拼接字符串，生成sql语句传到mapper再通过xml文件对数据
	 * 库进行操作
	 * @author yuFAN
	 * @param tb_name=表名（必须大写）
	 * @param map从前端传入的map
	 * @param key为作为条件的字段，如u_id，
	 * @param keyid就是相应的id
	 * @return 插入成功返回1
	 */
	
	public int updateObject(String tb_name, Map map, String key, int keyid)
	{
		// TODO Auto-generated method stub
		int num=0;
		String sql="update  "+tb_name+" set ";		
		if(map !=null) {
			Set set=map.keySet();
			List list=new ArrayList<>(set);
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					if (i != list.size() - 1) {
						if(map.get(list.get(i))!=null&&map.get(list.get(i))!=""){
							sql=sql+list.get(i)+"='"+map.get(list.get(i))+"',";
						}
						
					} else {
						if(map.get(list.get(i))!=null&&map.get(list.get(i))!=""){
							sql=sql+list.get(i)+"='"+map.get(list.get(i))+"'";						
						}
					}
				}
				String sql3=sql+" where "+key+"='"+keyid+"'";
				System.out.println("------update sql="+sql3);
				num=mapper.updateObject(sql3);
				System.out.println("biznum"+num);
				
				
				
			}
		}
		
		return num;
	}
	
	
	/**
	 * 
	 * 通用型删除方法sql="delete from "+tb_name+" where "+colname+" ='"+id+"'" 
	 * @param tb_name 
	 * @param colname 作为条件的列名
	 * @param id 
	 * @return 删除成功返回1
	 */

	public int delObject(String tb_name,String colname,int id) {
		int num=0;
		
		String sql="delete from "+tb_name+" where "+colname+" ='"+id+"'" ;
		num=mapper.delObject(sql);
		System.out.println("---delsql="+sql);
		return num;
	}

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
	
	@Override
	public int getCordnum(String sql) {
		// TODO Auto-generated method stub
		
		String getcSQL="select count(*) from ("+sql+") a";
		
		System.out.println("getCordnumSQL---"+getcSQL);
		int num =mapper.getCordnum(getcSQL);
		return num;
	}

	@Override
	public int insertData(String tb_name, Map map,Map keymap) {
		// TODO Auto-generated method stub
		return mapper.insertData(map,keymap, tb_name);
	}

	@Override
	public int updateData(String tb_name, Map map,String keykol,String id) {
		// TODO Auto-generated method stub
		return mapper.updateData(map, tb_name, keykol, id);
	}

	@Override
	public int delData(String tb_name, Map map) {
		// TODO Auto-generated method stub
		return mapper.delData(map, tb_name);
	}
	
	
}
