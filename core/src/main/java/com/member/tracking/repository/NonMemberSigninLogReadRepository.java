package com.member.tracking.repository;

import com.member.tracking.model.entity.NonMemberSigninLog;
import com.member.tracking.mongo.query.FindNonMemberSigninLogQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class NonMemberSigninLogReadRepository {
    private final MongoTemplate mongoTemplate;
    private static final String collectionName = "nonmember_signin_logs";

    public Page<NonMemberSigninLog> findBy(FindNonMemberSigninLogQuery request) { // Pageable pageable)
        Query query = new Query();
        List<Criteria> criteriaList = new ArrayList<>();

        // 필수
        if (StringUtils.hasText(request.getSiteType())) {
            criteriaList.add(Criteria.where("siteType").is(request.getSiteType()));
        }

        // 주문자
        if (StringUtils.hasText(request.getName())) {
            criteriaList.add(Criteria.where("name").is(request.getName()));
        }
        // 휴대폰
        if (StringUtils.hasText(request.getMobileNo())) {
            criteriaList.add(Criteria.where("mobileNo").is(request.getMobileNo()));
        }

        if (StringUtils.hasText(request.getResult())) {
            criteriaList.add(Criteria.where("result").is(request.getResult()));
        }

        if (StringUtils.hasText(request.getIpAddress())) {
            criteriaList.add(Criteria.where("ipAddress").is(request.getIpAddress()));
        }

        if (request.getFrom() != null || request.getTo() != null) {
            Criteria dateCriteria = Criteria.where("timestamp");
            if (request.getFrom() != null) {
                dateCriteria = dateCriteria.gte(request.getFrom());
            }
            if (request.getTo() != null) {
                dateCriteria = dateCriteria.lte(request.getTo());
            }
            criteriaList.add(dateCriteria);
        }

        if (!criteriaList.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteriaList));
        }

        // 페이징, 정렬
        Pageable pageable = PageRequest.of(request.getPageable().getPageNumber(), request.getPageable().getPageSize(), Sort.by(Sort.Direction.DESC, "_id"));
        query.with(pageable);

        List<NonMemberSigninLog> results = mongoTemplate.find(query, NonMemberSigninLog.class);
        long total = mongoTemplate.count(Query.of(query).limit(-1).skip(-1), NonMemberSigninLog.class);

        return new PageImpl<>(results, pageable, total);
    }
}
