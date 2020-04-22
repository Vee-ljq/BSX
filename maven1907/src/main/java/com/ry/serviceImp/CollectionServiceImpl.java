package com.ry.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.dto.CollectionDto;
import com.ry.mapper.BCollectionMapper;
import com.ry.pojo.BCollection;
import com.ry.service.CollectionService;
@Service("collectionService")
public class CollectionServiceImpl implements CollectionService {
	
	@Autowired
	private BCollectionMapper mapper;

	@Override
	public List<CollectionDto> selectAllCollection(Integer id) {
		 List<CollectionDto> bclist = mapper.selectAllCollection(id);
		return bclist;
	}

	@Override
	public boolean insertShoucang(BCollection collection) {
		int insertSelective = mapper.insertSelective(collection);
		if(insertSelective==1){
			return true;
		}else{
			return false;
		}
	}

}
