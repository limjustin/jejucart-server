package dev.goormthon.jejucart.domain.policy;

import dev.goormthon.jejucart.domain.policy.converter.PolicyConverter;
import dev.goormthon.jejucart.domain.policy.dto.PolicyResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PolicyService {

    private final PolicyRepository policyRepository;

//    public List<PolicyResponse.RecommendPolicyDto> recommend() {
//        // 1. 레포지토리에서 target 검색어로 검색
//        // 2. 가져온 정책 리스트의 댓글에 대해 GPT 응답 생성
//        // 3. 리스트에 dto 담아서 반환
//    }

    public List<PolicyResponse.PoliciesDetailDto> findAllPolicy() {
        List<Policy> policies = policyRepository.findAll();
        return PolicyConverter.toPoliciesDetailDtoList(policies);
    }

    public PolicyResponse.PolicyDetailDto findPolicyById(Long id) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        return PolicyConverter.toPolicyDetailDto(policy);
    }
}