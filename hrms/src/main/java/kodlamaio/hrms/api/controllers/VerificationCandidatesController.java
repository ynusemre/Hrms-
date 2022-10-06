package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.verifications.abstracts.VerificationCodeCandidateService;

@RestController
@RequestMapping("/api/verificationCode")
public class VerificationCandidatesController {
	private VerificationCodeCandidateService verificationCodeCandidateService;

	@Autowired
	public VerificationCandidatesController(VerificationCodeCandidateService verificationCodeCandidateService) {
		this.verificationCodeCandidateService = verificationCodeCandidateService;
	}

	@PostMapping("/addCandidateCode")
	public Result save() {
		return verificationCodeCandidateService.save();
	}

}
