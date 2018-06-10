package com.zammc.repository;

import com.zammc.domain.user.AdminUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUserEntity, Long> {

    /**
     * 获取用户数
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Query(value = "select count(user) from AdminUserEntity user where user.userName = :#{#request.userName}")
    int queryUserCount(@Param("request") AdminUserEntity request) throws Exception;

    /**
     * 查询用户信息
     *
     * @param userName
     * @param passWord
     * @return
     * @throws Exception
     */
    AdminUserEntity findByUserNameAndPassWord(String userName, String passWord) throws Exception;
}
