package com.member.tracking.repository;

import com.member.tracking.model.entity.MemberSigninLog;
import com.member.tracking.query.FindMemberSigninLogQuery;
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
public class MongoMemberSigninLogRepository {
    private final MongoTemplate mongoTemplate;
    private static final String collectionName = "member_signin_logs";

        /*
    public Page<MemberSigninLog> findBy(FindMemberSigninLogQuery qy) { // Pageable pageable)
        Query query = new Query();

        List<Criteria> criteriaList = new ArrayList<>();

        if (qy.getSiteType() != null && !qy.getSiteType().isEmpty()) {
            criteriaList.add(Criteria.where("siteType").is(qy.getSiteType()));
        }
        if (qy.getMemberKey() != null) {
            criteriaList.add(Criteria.where("memberKey").is(qy.getMemberKey()));
        }
        if (qy.getResult() != null && !qy.getResult().isEmpty()) {
            criteriaList.add(Criteria.where("result").is(qy.getResult()));
        }
        if (qy.getIpAddress() != null && !qy.getIpAddress().isEmpty()) {
            criteriaList.add(Criteria.where("ipAddress").is(qy.getIpAddress()));
        }

        //if (qy.getHistoryDateLte() != null && qy.getHistoryDateGte() != null) {
        //    criteriaList.add(Criteria.where("timestamp").gte(qy.getHistoryDateLte()).lte(qy.getHistoryDateGte()));
        //} else if (qy.getHistoryDateLte() != null) {
        //    criteriaList.add(Criteria.where("timestamp").gte(qy.getHistoryDateLte()));
        //} else if (qy.getHistoryDateGte() != null) {
        //    criteriaList.add(Criteria.where("timestamp").lte(qy.getHistoryDateGte()));
        //}

        if (!criteriaList.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0])));
        }

        query.with(Sort.by(Sort.Direction.ASC, "_id"));
        query.with(qy.getPageable());

        List<MemberSigninLog> results =  mongoTemplate.find(query, MemberSigninLog.class);

        long total = mongoTemplate.count(query.skip(0).limit(0), MemberSigninLog.class, collectionName);

        return new PageImpl<>(results, qy.getPageable(), total); // results.size()
    }
*/


    public Page<MemberSigninLog> findBy(FindMemberSigninLogQuery request) { // Pageable pageable)
        Query query = new Query();
        List<Criteria> criteriaList = new ArrayList<>();

        if (StringUtils.hasText(request.getSiteType())) {
            criteriaList.add(Criteria.where("siteType").is(request.getSiteType()));
        }
        if (request.getMemberKey() != null) {
            criteriaList.add(Criteria.where("memberKey").is(request.getMemberKey()));
        }
        if (StringUtils.hasText(request.getResult())) {
            criteriaList.add(Criteria.where("result").is(request.getResult()));
        }
        if (StringUtils.hasText(request.getIpAddress())) {
            criteriaList.add(Criteria.where("ipAddress").is(request.getIpAddress()));
        }

        //if (request.getFrom() != null || request.getTo() != null) {
        //    Criteria dateCriteria = Criteria.where("timestamp");
        //    if (request.getFrom() != null) {
        //        dateCriteria = dateCriteria.gte(request.getFrom());
        //    }
        //    if (request.getTo() != null) {
        //        dateCriteria = dateCriteria.lte(request.getTo());
        //    }
        //    criteriaList.add(dateCriteria);
       // }

        if (!criteriaList.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteriaList));
        }

        // 페이징, 정렬
        Pageable pageable = PageRequest.of(request.getPageable().getPageNumber(), request.getPageable().getPageSize(), Sort.by(Sort.Direction.ASC, "_id"));
        query.with(pageable);

        List<MemberSigninLog> results = mongoTemplate.find(query, MemberSigninLog.class);
        long total = mongoTemplate.count(Query.of(query).limit(-1).skip(-1), MemberSigninLog.class);

        return new PageImpl<>(results, pageable, total);
    }


}
