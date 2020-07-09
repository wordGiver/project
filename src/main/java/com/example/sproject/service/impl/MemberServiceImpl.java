package com.example.sproject.service.impl;

import com.example.sproject.dao.MemberDao;
import com.example.sproject.entity.Member;
import com.example.sproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public List<Member> getAllMember() {
        return memberDao.findAll();
    }

    @Override
    public boolean insert(Member member) {
        if(member == null)
        {
            System.out.println("null");
            return false;
        }
        if(memberDao.findById(member.getMid()).isPresent())
        {
            System.out.println("member is exist");
            return false;
        }
        memberDao.save(member);
        return true;
    }

    @Override
    public boolean update(Member member) {
        if(member == null)
            return false;
        if(memberDao.findById(member.getMid()).isPresent()) {
            memberDao.save(member);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer mid) {
        if(!memberDao.findById(mid).isPresent())
            return false;
        else
        {
            memberDao.delete(memberDao.findById(mid).orElse(null));
            return true;
        }
    }

    @Override
    public Member getUserById(int mid) {
        if(memberDao.findById(mid).isPresent())
            return memberDao.findById(mid).orElse(null);
        else
            return null;
    }

    @Override
    public int getLastMid()
    {
        return memberDao.getLastMid();
    }
}
