package test.springmvc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.deyu.dao.ConnectionFactory;
@Controller
public class ControllerClass {
	
		@RequestMapping(value="login.do", method=RequestMethod.POST, produces={"application/json;charset=UTF-8"})
		@ResponseBody
		public String login(HttpServletRequest request) throws SQLException {
			ConnectionFactory con = new ConnectionFactory();
			JSONObject json = new JSONObject();
			String status ="";
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String pwd = "";
			ResultSet rs = con.executeQueryData("SELECT * FROM p_user where username = '"+username+"'");
					while(rs.next()){
		                 pwd = rs.getString("pwd");
		            }
					con.close();
			if(!("".equals(username))&&username!=null&&!("".equals(password))&&password!=null){
				if(username.equals(username)&&pwd.equals(password)) {
					status = "succeed";
				}else {
					status = "error";
				}
			}
			json.put("status", status);		
			String reslut = json.toString();
			return reslut;
		}
		
		@RequestMapping("home.do")
		public String home(){
		    return "home";
		}
		
}
