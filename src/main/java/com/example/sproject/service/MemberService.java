package com.example.sproject.service;

import com.example.sproject.entity.Member;

import java.util.List;

public interface MemberService {

    List<Member> getAllMember();

    boolean insert(Member member);

    boolean update(Member member);

    boolean delete(Integer mid);

    Member getUserById(int mid);

    int getLastMid();
}
