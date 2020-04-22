package com.ry.serviceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.dto.LeftListDto;
import com.ry.dto.TreeNodeDto;
import com.ry.mapper.SResourceMapper;
import com.ry.pojo.SResource;
import com.ry.pojo.SResourceExample;
import com.ry.pojo.SResourceExample.Criteria;
import com.ry.pojo.TreeNode;
import com.ry.service.ResourceService;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;
@Service("resourceService")
public class ResourceServiceImp implements ResourceService {

	@Autowired
	private SResourceMapper mapper;
	
	/**
	 * 将主菜单循环遍历，name，open，children
	 * 然后在遍历子菜单 name
	 */
	public List<SResource> selectAllResource() {
		List list = new ArrayList<SResource>();
		
		List<SResource> selectParentResource = selectParentResource();
		for (SResource sResource : selectParentResource) {
			//每次循环获取到的父级菜单的相关信息
			Map map = new HashMap();
			map.put("name", sResource.getResourcename());
			map.put("open", true);
			map.put("children", selectChildByPid(sResource.getId()));
			list.add(map);
		}
		return list;
	}
	/**
	 * 根据pid返回ztree需要的属性的集合
	 * @param id
	 * @return
	 */
	private List<SResource> selectChildByPid(Integer id) {
		List list = new ArrayList();
		//查询所有的父级信息，然后遍历
		SResourceExample example = new SResourceExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andPidEqualTo(id);
		List<SResource> selectByExample = mapper.selectByExample(example);
		for (SResource sResource : selectByExample) {
			Map map = new HashMap();
			map.put("name", sResource.getResourcename());
			list.add(map);
		}
		return list;
	}

	public List<SResource> selectParentResource(){
		SResourceExample example = new SResourceExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andPidEqualTo(0);
		List<SResource> selectByExample = mapper.selectByExample(example);
		return selectByExample;
	}
	/**
	 * 直接用sql语句实现了主菜单与子菜单
	 */
	public List<TreeNodeDto> selectByTree() {
		List<TreeNodeDto> selectByTree = mapper.selectByTree();
		return selectByTree;
	}
	public List<TreeNode> selectResource(Integer id) {
		List<TreeNode> selectResource = mapper.selectResource(id);
		return selectResource;
	}
	
	public void saveOrDelete(Integer roleId, Integer resourceId) {
		Map map = new HashMap();
		map.put("roleId", roleId);
		map.put("resourceId", resourceId);
		//查询s_resource表中根据roleid和resourceid。看是否存在该资源，有就删，没有就插入
		if(mapper.selectByRoleIdAndResourceId(map)>0){
			//删除
			//如果当前节点是父节点，应该父+子
			if(isParentNode(resourceId)){
				//删除子+父
				mapper.deleteParentAndChild(map);
			}else{
				//如果当前节点是子节点，应该判断是父节点下唯一的子节点，如果是，则删除子+父，否则删除本身
				//查询当前子节点的父节点
				Integer pid = selectByPid(resourceId);
				//查找父节点下还有没有其他的子节点
				Integer child_count = selectChildCount(roleId,pid);
				if(child_count==1){
					//删除子+父
					map.put("resourceId", pid);
					mapper.deleteParentAndChild(map);
				}else{
					mapper.deleteByRoleIdAndResourceId(map);
				}
			}
		}else{
			if(isParentNode(resourceId)){
				//如果是父节点，那么添加子+父
				mapper.insertParentAndChild(map);
				
			}else{
				//如果是子节点，就判断子节点的父节点是否存在，存在就插入本身，没有就插入子+父
				if(hasParentId(roleId,resourceId)){
					//保存自己
					mapper.insertSroleResource(map);
				}else{
					//保存自己
					mapper.insertSroleResource(map);
					//保存父节点
					Integer pid = selectByPid(resourceId);
					map.put("resourceId", pid);
					mapper.insertSroleResource(map);
				}
			}
		}
		
	}
	/**
	 * 查看当前子节点是否有父节点
	 * @param roleId
	 * @param resourceId
	 * @return
	 */
	private boolean hasParentId(Integer roleId, Integer resourceId) {
		boolean flag = false;
		Map map = new HashMap();
		map.put("roleId", roleId);
		map.put("resourceId", resourceId);
		int hasParendPid = mapper.hasParendPid(map);
		if(hasParendPid==1){
			flag = true;
		}
		return flag;
	}
	/**
	 * 通过父节点以及角色id来查询有多少子节点
	 * @param roleId
	 * @param pid
	 * @return
	 */
	private Integer selectChildCount(Integer roleId, Integer pid) {
		Map map = new HashMap();
		map.put("roleId", roleId);
		map.put("resourceId", pid);
		int selectChildCount = mapper.selectChildCount(map);
		return selectChildCount;
	}
	/**
	 * 查找子节点的父节点
	 * @param resourceId
	 * @return
	 */
	private Integer selectByPid(Integer resourceId) {
		SResource selectByPrimaryKey = mapper.selectByPrimaryKey(resourceId);
		return selectByPrimaryKey.getPid();
	}
	/**
	 * 查找当前节点是否是父节点
	 * @param resourceId
	 * @return
	 */
	private boolean isParentNode(Integer resourceId) {
		boolean flag = false;
		SResource selectByPrimaryKey = mapper.selectByPrimaryKey(resourceId);
		if(selectByPrimaryKey.getPid()==0){
			flag = true;
		}
		return flag;
	}
	/**
	 * 左侧列表根据角色的拥有的权限所展示
	 */
	public List<Map> selectResourceByRoleId(Integer roleid) {
		List<Map> list = new ArrayList<Map>();
		//查询该角色所拥有的一级菜单
		List<SResource> list1 = mapper.selectFirstMenu(roleid);
		for (SResource sResource : list1) {
			Map map = new HashMap();
			map.put("title", sResource.getResourcename());
			map.put("href", sResource.getUrl());
			map.put("icon", sResource.getIcon());
			map.put("spread", false);
			List childList = new ArrayList();
			Map map2 = new HashMap();
			map2.put("roleId", roleid);
			map2.put("pId", sResource.getPid());
			List<SResource> childMenu = mapper.selectChildMenusPid(map);
			for (SResource sResource2 : childMenu) {
				Map map3 = new HashMap();
				map3.put("title", sResource.getResourcename());
				map3.put("href", sResource.getUrl());
				map3.put("icon", sResource.getIcon());
				map3.put("spread", false);
				childList.add(map3);
			}
			if(childList.size()>0){
				map.put("children", childList);
			}
			list.add(map);
		}
		return list;
	}
	public List<LeftListDto> selectByLeftList(Integer roleId) {
		
		return mapper.selectByLeftList(roleId);
	}
	
	
	

}
