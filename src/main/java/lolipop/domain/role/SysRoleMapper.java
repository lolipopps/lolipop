package lolipop.domain.role;


import org.apache.ibatis.annotations.Param;

import lolipop.model.role.SysRole;
import lolipop.model.role.SysRoleExample;

import java.util.List;

public interface SysRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    long countByExample(SysRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    int deleteByExample(SysRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    int deleteByPrimaryKey(String roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    int insert(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    int insertSelective(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    List<SysRole> selectByExample(SysRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    SysRole selectByPrimaryKey(String roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_ROLE
     *
     * @mbg.generated Tue Sep 19 11:14:34 CST 2017
     */
    int updateByPrimaryKey(SysRole record);
}