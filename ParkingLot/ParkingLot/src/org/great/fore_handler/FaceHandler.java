package org.great.fore_handler;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.Cust;
import org.great.bean.Msg;
import org.great.bean.MsgSearch;
import org.great.bean.SearchUser;
import org.great.biz.CustBiz;
import org.great.face.FaceAdd;
import org.great.face.FaceSearch;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sun.misc.BASE64Decoder;

import com.google.gson.Gson;

@Controller
@RequestMapping("/faceServlte")
public class FaceHandler {
	
	
	@Resource
	public CustBiz custBiz; // 用户dao接口

	/**
	 * 保存照片
	 * @param imgStr
	 * @param imgFilePath
	 * 孔大帅
	 * @return
	 */
	public static boolean GenerateImage(String imgStr, String imgFilePath) {
		if (imgStr == null) 
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] bytes = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {
					bytes[i] += 256;
				}
			}
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(bytes);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@RequestMapping("/face.do")
	protected void FaceAction(HttpServletRequest request, HttpServletResponse response,String img,String username,String tag)
			throws ServletException, IOException {
		//设置编码格式
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
//		//获取ajax传过来的值
//		String img = request.getParameter("img");
//		String username = request.getParameter("username"); 
//		
//		//判断请求
//		String tag = request.getParameter("tag");
        PrintWriter out=response.getWriter();
        //注册请求
		if(tag.equals("reg")){
			System.out.println("a");
			String fileName = System.currentTimeMillis()+".jpg";
			String basePath = request.getSession().getServletContext().getRealPath("picture");
			
			GenerateImage(img,basePath +"\\"+ fileName);
			System.out.println(basePath + "\\" + fileName);
			String image=basePath + "\\" + fileName;
		        Gson g = new Gson();
		    	Msg msg = g.fromJson(FaceAdd.add(image,username,"描述"), Msg.class);
		    	System.out.println("注册的唯一标识"+msg.log_id);
		    	int result=msg.error_code;
		    	if(result==0){
		    		out.print("注册成功");
		    	}
		    	else{
		    		out.print("注册失败,请稍后重试");
		    	}
		}
		//登陆请求
		else if(tag.equals("login")){
			
			String fileName = System.currentTimeMillis()+".jpg";
			String basePath = request.getSession().getServletContext().getRealPath("picture");
			GenerateImage(img,basePath +"\\"+ fileName);
			
			System.out.println(basePath + "\\" + fileName);
			String image=basePath + "\\" + fileName;
			
		    Gson g = new Gson();
    		MsgSearch msg = g.fromJson(FaceSearch.search(image), MsgSearch.class);
        	System.out.println("返回码:"+msg.error_code+msg.error_msg+"唯一标识"+msg.result.user_list);
        	
        	String Phone = "";
        	
        	//获得用户手机号
        	for(SearchUser su:msg.result.user_list) {
        		
        		Phone = su.user_id;
        		System.out.println("该用户的电话号码是"+Phone);
        	}
        	
        	int result=msg.error_code;
        	System.out.println("对比分值"+msg.showScore());
	    	if(result==0){
	    		if(msg.showScore()>90){
	    			out.print("登陆成功");
	    			//把用户存进session中
	    			Cust cust = custBiz.FindByPhone(Phone);
	    			HttpSession session = request.getSession();
	    			session.setAttribute("ForeUser", cust);
	    		}else{
	    			out.print("");	
	    		}
	    	
	    	}else{
	    		out.print("");
	    	}	
		}
		
	}

}
