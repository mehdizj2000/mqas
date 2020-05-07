package au.com.mqas.adapter.service.impl;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.mqas.adapter.service.TokenService;
import au.com.mqas.adapter.service.exception.TokenException;
import au.com.mqas.data.repo.VerificationTokenRepo;
import au.com.mqas.db.data.model.UserInfo;
import au.com.mqas.db.data.model.VerificationToken;

@Service
public class VerificationTokenService implements TokenService<VerificationToken> {

	private VerificationTokenRepo verificationTokenRepo;

	@Override
	public VerificationToken createToken(UserInfo userInfo) {

		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setUserInfo(userInfo);
		return verificationTokenRepo.save(verificationToken);

	}

	@Override
	public VerificationToken verifyToken(String token) {
		Optional<VerificationToken> vtOpt = verificationTokenRepo.findByToken(token);
		return vtOpt.filter(vt -> vt.getExpiry().isAfter(LocalTime.now(ZoneId.of("UTC"))))
//            .map(VerificationToken::getUserInfo)
				.orElseThrow(() -> new TokenException("The token is not found"));
	}

	@Override
	public void deleteToken(VerificationToken token) {
		verificationTokenRepo.delete(token);
	}

	public VerificationTokenRepo getVerificationTokenRepo() {
		return verificationTokenRepo;
	}

	@Autowired
	public void setVerificationTokenRepo(VerificationTokenRepo verificationTokenRepo) {
		this.verificationTokenRepo = verificationTokenRepo;
	}

}
