package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.verifications.abstracts.VerificationCodeEmployerService;

@RestController
@RequestMapping("/api/verificationCode")
public class VerificationEmployersController {
	private VerificationCodeEmployerService verificationCodeEmployerService;

	@Autowired
	public VerificationEmployersController(VerificationCodeEmployerService verificationCodeEmployerService) {
		this.verificationCodeEmployerService = verificationCodeEmployerService;
	}

	@PostMapping("/addEmployerCode")
	public Result save() {
		return verificationCodeEmployerService.save();
	}
}
