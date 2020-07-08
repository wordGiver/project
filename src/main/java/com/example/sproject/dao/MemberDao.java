package com.example.sproject.dao;


import com.example.sproject.entity.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MemberDao extends JpaRepository<Member,Integer>{
    @Query(nativeQuery = true, value = "SELECT Max(mid) FROM Member ")
    Integer getLastMid();
}
