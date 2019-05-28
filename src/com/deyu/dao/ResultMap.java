package com.deyu.dao;
import java.util.Map;
import org.apache.ibatis.annotations.MapKey;

public interface ResultMap {	
	@MapKey("id")
    public Map<Integer,Object> getMapById(Integer id);
}
