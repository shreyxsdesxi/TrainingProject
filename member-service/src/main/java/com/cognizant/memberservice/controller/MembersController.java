package com.cognizant.memberservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cognizant.memberservice.model.MemberClaim;
import com.cognizant.memberservice.model.MemberPremium;
import com.cognizant.memberservice.model.Members;
import com.cognizant.memberservice.service.MembersServices;
import com.cognizant.memberservice.service.PremiumServices;

@RestController
public class MembersController {
	@Autowired
	MembersServices membersServices;
	@Autowired
	PremiumServices premiumServices;

	@GetMapping(value = "/viewBills/{policyId}/{MemberId}")
	public MemberPremium viewBills(@PathVariable int policyId, @PathVariable int MemberId) {
		Members members1 = membersServices.getMemberById(MemberId);
		MemberPremium memberPremium = premiumServices.premium(policyId, members1);
		System.out.println(memberPremium);
		return memberPremium;
	}

	@GetMapping(value = "/getClaimStatus/{policyId}/{memberId}/{claimNumber}")
	public MemberClaim getClaimStatus(@PathVariable String policyId, @PathVariable String memberId,
			@PathVariable String claimNumber) {
		RestTemplate rt = new RestTemplate();
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("policyId", policyId);
		uriVariables.put("memberId", memberId);
		uriVariables.put("claimNumber", claimNumber);

		ResponseEntity<MemberClaim> forEntity = rt.getForEntity(
				"http://localhost:8000/getClaimStatus/{policyId}/{memberId}/{claimNumber}", MemberClaim.class, uriVariables);
		MemberClaim result = forEntity.getBody();
		return result;
	}

	@PostMapping(value = "/submitClaim/{policyId}/{memberId}")
	public MemberClaim submitClaim(@PathVariable int policyId, @PathVariable int memberId, @RequestBody MemberClaim claim) {
		RestTemplate rt = new RestTemplate();
		HashMap<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("policyId", policyId);
		uriVariables.put("memberId", memberId);

		MemberClaim postForObject = rt.postForObject("http://localhost:8000/submitClaim/{policyId}/{memberId}", claim,
				MemberClaim.class, uriVariables);
		return postForObject;
	}
	
	@GetMapping(value = "/viewPremium/{memberId}")
	public List<MemberPremium> viewPremium(@PathVariable int memberId){
		Members members1 = membersServices.getMemberById(memberId);
		Set<MemberPremium> premiumSet = members1.getPremium();
		List<MemberPremium> premiumList = new ArrayList<>();
		for(MemberPremium m : premiumSet) {
			premiumList.add(m);
		}
		return premiumList;
	}
	
	@GetMapping(value = "/getClaims/{memberId}")
	public MemberClaim[] getAllClaims(@PathVariable int memberId){
		RestTemplate rt = new RestTemplate();
		HashMap<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("memberId", memberId);
		
		ResponseEntity<MemberClaim[]> forEntity = rt.getForEntity(
				"http://localhost:8000/getClaims/{memberId}", MemberClaim[].class, uriVariables);
		MemberClaim[] body = forEntity.getBody();
		return body;
	}

}
