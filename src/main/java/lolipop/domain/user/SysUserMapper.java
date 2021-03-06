package lolipop.domain.user;


import org.apache.ibatis.annotations.Param;

import lolipop.model.user.SysUser;
import lolipop.model.user.SysUserExample;
import lolipop.model.user.SysUserKey;

import java.util.List;

public interface SysUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_USER
     *
     * @mbg.generated Thu Sep 14 18:04:32 CST 2017
     */
    long countByExample(SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_USER
     *
     * @mbg.generated Thu Sep 14 18:04:32 CST 2017
     */
    int deleteByExample(SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_USER
     *
     * @mbg.generated Thu Sep 14 18:04:32 CST 2017
     */
    int deleteByPrimaryKey(SysUserKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_USER
     *
     * @mbg.generated Thu Sep 14 18:04:32 CST 2017
     */
    int insert(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_USER
     *
     * @mbg.generated Thu Sep 14 18:04:32 CST 2017
     */
    int insertSelective(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_USER
     *
     * @mbg.generated Thu Sep 14 18:04:32 CST 2017
     */
    List<SysUser> selectByExample(SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_USER
     *
     * @mbg.generated Thu Sep 14 18:04:32 CST 2017
     */
    SysUser selectByPrimaryKey(SysUserKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_USER
     *
     * @mbg.generated Thu Sep 14 18:04:32 CST 2017
     */
    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_USER
     *
     * @mbg.generated Thu Sep 14 18:04:32 CST 2017
     */
    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_USER
     *
     * @mbg.generated Thu Sep 14 18:04:32 CST 2017
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS_USER
     *
     * @mbg.generated Thu Sep 14 18:04:32 CST 2017
     */
    int updateByPrimaryKey(SysUser record);
}