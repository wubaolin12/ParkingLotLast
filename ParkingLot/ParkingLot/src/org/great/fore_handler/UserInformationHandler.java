package org.great.fore_handler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.bean.Cust;
import org.great.bean.Menu;
import org.great.bean.User;
import org.great.biz.BaseBiz;
import org.great.biz.CustBiz;
import org.great.util.BaseUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import sun.misc.BASE64Decoder;

/**
 * 前端个人信息显示
 * @author ASUS yf
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/userinformation")
public class UserInformationHandler {
	
	@Resource
	private BaseBiz bbiz;
	
	@Resource
	public CustBiz cbiz;  
	
	@Value("tb_cust")
	private String tb_name;
	
	private String result;
	
	
	/**
	 * 刷新主页面
	 */

	@RequestMapping("/reToforMain.do")
	public String reToforMain(HttpServletRequest request) {
		Cust cust=(Cust)request.getSession().getAttribute("ForeUser");
		
		cust=cbiz.FindByID(cust);
		System.out.println("++---------reToforMain:"+cust.toString());
		request.setAttribute("ForeUser", cust);
		return "Fore/foreMain";
	}
	
	
	/**
	 * 跳转显示用户个人信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/toUserInformation.do")
	public String toUserInformation(HttpServletRequest request) 
	{
		Cust cust=(Cust)request.getSession().getAttribute("ForeUser");
		
		cust=cbiz.FindByID(cust);
		System.out.println("++---------toUserInformation:"+cust.toString());
		request.setAttribute("ForeUser", cust);
		result="Fore/user-information";
		return result;
		
	}
	
	/**
	 * 跳转修改用户个人信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/toUpdateUserInformation.do")
	public String toUpdateUserInformation(HttpServletRequest request) 
	{
		System.out.println("--------toUpdateUserInformation");
		Cust cust=(Cust)request.getSession().getAttribute("ForeUser");
		
		request.setAttribute("ForeUser", cust);
		result="Fore/user-update";
		return result;
		
	}
	
	/**
	 * 跳转修改用户个人信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/toUpdateUserPWD.do")
	public String toUpdateUserPWD(HttpServletRequest request) 
	{
		System.out.println("------------toUpdateUserPWD");
		Cust cust=(Cust)request.getSession().getAttribute("ForeUser");
		
		request.setAttribute("FuserInf", cust);
		result="Fore/user-updatePWD";
		return result;
		
	}
	
	/**
	 * 跳转修改用户个人设置
	 * @param request
	 * @return
	 */
	@RequestMapping("/toUserSetting.do")
	public String toUserSetting(HttpServletRequest request) 
	{
		System.out.println("------------toUserSetting");

		result="Fore/user-setting";
		return result;
		
	}
	
	/**
	 * 修改用户个人信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/UpdateUserInformation.do")
	public String UpdateUserInformation(HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		System.out.println("--------UpdateUserInformation");
		System.out.println("--------MAp"+map.toString());

		Cust cust=(Cust)request.getSession().getAttribute("ForeUser");
		
		if(cust!=null){
			int num=bbiz.updateData(tb_name, map, "cust_id",""+ cust.getCust_id());

			if(num>0) {
				
				Cust newcust=cbiz.FindByID(cust);
				request.setAttribute("FuserInf", newcust);
				result="Fore/user-information";

			}
		}else {
			System.out.println("用户过期");
		}
		
		
		
		return result;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/UpdateFUserPWD.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String UpdateFUserPWD(HttpServletRequest request) 
	{
		System.out.println("--------UpdateUserInformation");
		

		Cust cust=(Cust)request.getSession().getAttribute("ForeUser");
		Map map=new HashMap<>();
		String newpwd=request.getParameter("cust_pwd");
		map.put("cust_pwd", BaseUtil.getStrrMD5(newpwd));
		System.out.println("--------newpwd"+newpwd);
		
		if(cust!=null){
			int num=bbiz.updateData(tb_name, map, "cust_id",""+ cust.getCust_id());

			if(num>0) {
				result="修改成功，请重新登录";

			}else {
				result="修改失败";

			}
		}else {
			System.out.println("用户过期");
		}
		
		
		
		return result;
		
	}
	
	/**
	 * 验证旧密码
	 * @param response
	 * @param request
	 * @return
	 * @author ASUS yf
	 */
	@ResponseBody
	@RequestMapping(value = "/FuserPWDcheckAjax.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String FuserPWDcheckAjax(HttpServletResponse response,HttpServletRequest request) 
	{
		String oldpwd=request.getParameter("checkpwd");
		System.out.println("--------FuserPWDcheckAjax："+oldpwd);
		
		HttpSession session = request.getSession();
		Cust cust=(Cust)session.getAttribute("ForeUser");
		System.out.println("--------"+cust.toString());
		if(cust!=null) {
			System.out.println("++++---------cust"+cust.toString());
			// 转换MD5密码
			Cust user=new Cust();
			user.setCust_pwd(BaseUtil.getStrrMD5(oldpwd));
			//user.setCust_pwd(oldpwd);
	
			user.setCust_phone(cust.getCust_phone());
			Cust users = (Cust) cbiz.checkUser(user);
			System.out.println("找到的用户=" + users);
	
			//如果用户不存在输入的旧密码不正确
			if (users == null) {
				result = "旧密码不正确";
				System.out.println("错误");
			}else {
				result ="旧密码正确";
			}
		
		}else {
			result = "用户过期";
		}
		return result;
		
	}
	
	/**
	 * 验证呢称唯一性
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/FuserNamecheckAjax.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String FuserNamecheckAjax(HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		String cust_acc=request.getParameter("cust_acc");
		System.out.println("--------FuserNamecheckAjax："+map.toString());
/*		Cust cust=(Cust)request.getSession().getAttribute("ForeUser");
*/		List<Cust>list=cbiz.checkCust(map);
		if(list.size()>1) {
			
			result="该昵称已存在";
		}else {
			result="该昵称可以使用";
		}
		return result;
		
	}
	
	/**
	 * 验证电话唯一性
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/FuserPhonecheckAjax.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String FuserPhonecheckAjax(HttpServletRequest request,@RequestParam Map<String,String> map) 
	{
		String cust_acc=request.getParameter("cust_acc");
		System.out.println("--------FuserNamecheckAjax："+map.toString());
/*		Cust cust=(Cust)request.getSession().getAttribute("ForeUser");
*/		List<Cust>list=cbiz.checkCust(map);
		if(list.size()>1) {
			
			result="该号码已存在";
		}else {
			result="该号码可以使用";
		}
		return result;
		
	}
	
    @RequestMapping("headUpload.do")
    public String  headUpload(@RequestParam("headfile") CommonsMultipartFile file) throws IOException {
         long  startTime=System.currentTimeMillis();
        System.out.println("------------headUpload");
        System.out.println("-----------fileName："+file.getOriginalFilename());
        String path="F:/测试文件夹/"+file.getOriginalFilename();
         
        File newFile=new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);
        long  endTime=System.currentTimeMillis();
        System.out.println("方法二的运行时间："+String.valueOf(endTime-startTime)+"ms");
        
       
        
        return "/success"; 
    }
    
    /**
     * 头像上传
     * @param request
     * @return
     */
	@ResponseBody
	@RequestMapping(value = "/headUploadAjax.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String headUploadAjax(HttpServletRequest request) 
	{
		System.out.println("+++------headUploadAjax");
		String base64Pic=request.getParameter("imgStr");
		System.out.println("+++----headUploadAjax"+base64Pic);
		BASE64Decoder decoder = new BASE64Decoder();
		// String path="F:/测试文件夹/11.jpg";
		
		String fileName = System.currentTimeMillis()+".jpg";
//		String basePath = request.getSession().getServletContext().getRealPath("/cust_head");
		// 图片存放路径
		String path = "D:\\file_file\\test\\upload" ;
//		String path = "/home/wbl/upload/picture/"+orgFilename;
		
		String headname = path+"\\"+fileName;
		
		System.out.println("用户头像地址路径=" + headname);

		File file = new File(headname);
		
		/**
		 * 判断路径是否存在，如果不存在就创建一个
		 */
		if (!file.getParentFile().exists()) {

			file.getParentFile().mkdirs();
		}


		try {
			String baseValue = base64Pic.replaceAll(" ", "+");//前台在用Ajax传base64值的时候会把base64中的+换成空格，所以需要替换回来。
			byte[] b = decoder.decodeBuffer(baseValue.replace("data:image/jpeg;base64,", ""));//去除base64中无用的部分
			 base64Pic = base64Pic.replace("base64,", "");
			//byte[] b = decoder.decodeBuffer(imgStr);
				for (int i = 0; i < b.length; ++i) {
					if (b[i] < 0) {
						b[i] += 256;
					}
				}
		OutputStream out = new FileOutputStream(headname);
		out.write(b);
		out.flush();
		out.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//路径写入数据库
		Map map=new HashMap<>();
		map.put("head_path", fileName);
		Cust cust=(Cust)request.getSession().getAttribute("ForeUser");
		if(cust!=null) {
			System.out.println("-----------++++"+cust.toString());
			bbiz.updateData("tb_cust", map, "cust_id", ""+cust.getCust_id());
		}
		result="用户头像已保存";
		
			
		
		return result;
		
	}
}
