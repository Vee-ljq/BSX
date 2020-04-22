package com.ry.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.jsqlparser.util.AddAliasesVisitor;

import org.aspectj.apache.bcel.generic.ReturnaddressType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ry.dto.CommentDto;
import com.ry.dto.OrdersDto;
import com.ry.dto.OrgDto;
import com.ry.pojo.BComment;
import com.ry.pojo.BCustomer;
import com.ry.pojo.BOrdermain;
import com.ry.service.BCommentService;
import com.ry.service.WebOrdersService;
import com.ry.utils.LhPage;


@Controller
@RequestMapping("web")
public class CommentController {
	
	@Autowired
	private BCommentService commentService;
	@Autowired
    private WebOrdersService webOrdersService;
	@RequestMapping("data")
	public ModelAndView todata(BComment comment,@RequestParam(required=true,defaultValue="1")Integer pageNum,@RequestParam(required=true,defaultValue="2")Integer pageSize){
	ModelAndView mav = new ModelAndView("comment/data");
	PageInfo<CommentDto> selectByPage = commentService.selectCommentByPage(comment, pageNum, pageSize);
	LhPage page = new LhPage(selectByPage);
	mav.addObject("page",page);
	mav.addObject("comment", comment);
	return mav;
}
	@RequestMapping("delete")
	public String deleteCommentById(Integer id){
		commentService.deleteCommentById(id);
		return "redirect:data.action";
	}
	@RequestMapping("deletes")
	public String deleteCommentByIds(Integer[] ids){
		commentService.deleteCommentByIds(ids);
		return "redirect:data.action";
	}
	
	@RequestMapping("commitComment")
	public String commitComment(CommentDto dto,String orderno1, HttpSession session,Integer ordermainid){
		BOrdermain bOrdermain = new BOrdermain();
		BCustomer bCustomer = (BCustomer)session.getAttribute("customer");
		List<BComment> commentlist = dto.getCommentlist();
		  Date nowdate = new Date();
		  //设置要获取到什么样的时间
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        //获取String类型的时间
	        String createdate = sdf.format(nowdate);
	        boolean bl=true;
	        //循环插入数据
		for (BComment bComment : commentlist) {
			dto.setComment(bComment.getComment());
			dto.setCreatedate(createdate);
			dto.setCusid(bCustomer.getId());
			dto.setGoodsid(bComment.getGoodsid());
			dto.setLevel(bComment.getLevel());
			bl = commentService.insertcomment(dto);
		}
		//更新订单状态
		if (bl) {
			bOrdermain.setStatus(4);
			bOrdermain.setOrderno(orderno1);
			bOrdermain.setId(ordermainid);
			webOrdersService.updateOrderStatus(bOrdermain);
		}
	
		return "redirect:comment.action";
	}
}
