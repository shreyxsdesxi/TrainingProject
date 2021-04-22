package com.cognizant.memberPortal.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.cognizant.memberPortal.model.MemberClaim;
import com.cognizant.memberPortal.model.MemberPremium;

@Controller
public class MemberPortalController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberPortalController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value = "/viewBills/{policyId}")
	public String viewBills(@PathVariable int policyId, ModelMap map, HttpSession session) {
		
		String username = (String) session.getAttribute("username");
		int memberId = Integer.parseInt(username);
		
		HashMap<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("policyId", policyId);
		uriVariables.put("MemberId", memberId);
		
		ResponseEntity<MemberPremium> forEntity = restTemplate.getForEntity("http://localhost:8001/viewBills/{policyId}/{MemberId}", MemberPremium.class, uriVariables);
		MemberPremium result = forEntity.getBody();
		map.put("result", result);
		LOGGER.info("List of Bills: {}", result);
		
		return "viewBills";
		
	}
	
	@GetMapping(value = "/viewPremium")
	public String viewPremiums(ModelMap map, HttpSession session) {
		
		String username = (String) session.getAttribute("username");
		int memberId = Integer.parseInt(username);
		
		LOGGER.info("MemberID: {}", memberId);
		
		HashMap<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("memberId", memberId);
		
		ResponseEntity<MemberPremium[]> forEntity = restTemplate.getForEntity("http://localhost:8001/viewPremium/{memberId}", MemberPremium[].class, uriVariables);
		MemberPremium[] result = forEntity.getBody();
		
		LOGGER.info("result: {}", result);
		
		map.put("result", result);
		//return result;
		return "viewPremium";
		
	}
	
	@GetMapping(value = "/submitClaim")
	public String submitClaim(ModelMap map, HttpSession session) {
		
		String username = (String) session.getAttribute("username");
		int memberId = Integer.parseInt(username);
		
		HashMap<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("memberId", memberId);
		
		ResponseEntity<MemberPremium[]> forEntity = restTemplate.getForEntity("http://localhost:8001/viewPremium/{memberId}", MemberPremium[].class, uriVariables);
		MemberPremium[] result = forEntity.getBody();
		
		LOGGER.info("result: {}", result);
		
		map.put("policy", result);
		
		return "submitClaim";
	}
	
	@PostMapping(value = "/submitClaim")
	public String submitClaimPost(@RequestParam int amount,@RequestParam int hospitalId,@RequestParam int policyId, ModelMap map) {
		
		MemberClaim claim = new MemberClaim();
		claim.setHospitalId(hospitalId);
		claim.setAmountClaimed(amount);
		
		HashMap<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("memberId", 1);
		uriVariables.put("policyId", policyId);
		
		MemberClaim postForObject = restTemplate.postForObject("http://localhost:8001/submitClaim/{policyId}/{memberId}", claim, MemberClaim.class, uriVariables);
		
		map.put("result", postForObject);
		
		return "submitClaimStatus";
	}
	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@PostMapping(value = "/login")
	public String successfulLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
		if(password.equals("password")) {
			session.setAttribute("username", username);
			return "redirect:/viewPremium";
		}
		else {
			return "login";
		}
	}
	
	@GetMapping(value = "/viewAllClaims")
	public String viewAllClaims(ModelMap map, HttpSession session){
		
		String username = (String) session.getAttribute("username");
		int memberId = Integer.parseInt(username);
		
		HashMap<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("memberId", memberId);
		
		ResponseEntity<MemberClaim[]> forEntity = restTemplate.getForEntity("http://localhost:8001/getClaims/{memberId}", MemberClaim[].class, uriVariables);
		MemberClaim[] result = forEntity.getBody();
		
		map.put("claims", result);
		
		return "viewClaims";
	}
	
	@GetMapping(value = "/getClaimStatus/{policyNumber}/{claimNumber}")
	public String getClaimStatus(ModelMap map, HttpSession session, @PathVariable int policyNumber, @PathVariable int claimNumber) {
		
		String username = (String) session.getAttribute("username");
		int memberId = Integer.parseInt(username);
		
		HashMap<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("memberId", memberId);
		uriVariables.put("policyId", policyNumber);
		uriVariables.put("claimNumber", claimNumber);
		
		ResponseEntity<MemberClaim> forEntity = restTemplate.getForEntity("http://localhost:8001/getClaimStatus/{policyId}/{memberId}/{claimNumber}", MemberClaim.class, uriVariables);
		MemberClaim result = forEntity.getBody();
		
		map.put("claims", result);
		
		return "viewClaimsDetails";
	}
	
	@GetMapping(value = "/logout")
	public String test(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
}
