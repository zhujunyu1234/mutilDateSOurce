package com.example.demo.map;

import com.example.demo.BossRole;
import com.example.demo.BossRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BossRoleMapper {
    long countByExample(BossRoleExample example);

    int deleteByExample(BossRoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(BossRole record);

    int insertSelective(BossRole record);

    List<BossRole> selectByExample(BossRoleExample example);

    BossRole selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") BossRole record, @Param("example") BossRoleExample example);

    int updateByExample(@Param("record") BossRole record, @Param("example") BossRoleExample example);

    int updateByPrimaryKeySelective(BossRole record);

    int updateByPrimaryKey(BossRole record);
}