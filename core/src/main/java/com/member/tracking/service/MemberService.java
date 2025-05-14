package com.member.tracking.service;

import com.member.tracking.model.entity.Member;
import com.member.tracking.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Member create(Member member) {
        return repository.save(member);
    }

    public List<Member> getAll() {
        return repository.findAll();
    }

    public Member getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Member update(String id, Member member) {
        member.setId(id);
        return repository.save(member);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
