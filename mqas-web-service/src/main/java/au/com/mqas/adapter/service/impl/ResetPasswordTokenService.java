package au.com.mqas.adapter.service.impl;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.mqas.adapter.service.TokenService;
import au.com.mqas.adapter.service.exception.TokenException;
import au.com.mqas.data.repo.ResetPasswordTokenRepo;
import au.com.mqas.db.data.model.ResetPasswordToken;
import au.com.mqas.db.data.model.UserInfo;

@Service
public class ResetPasswordTokenService implements TokenService<ResetPasswordToken> {

	private ResetPasswordTokenRepo resetPasswordTokenRepo;

	@Override
	public ResetPasswordToken createToken(UserInfo userInfo) {

		ResetPasswordToken resetPasswordToken = new ResetPasswordToken();
		resetPasswordToken.setUserInfo(userInfo);
		return resetPasswordTokenRepo.save(resetPasswordToken);

	}

	@Override
	public ResetPasswordToken verifyToken(String token) {
		Optional<ResetPasswordToken> vtOpt = resetPasswordTokenRepo.findByToken(token);
		return vtOpt.filter(vt -> vt.getExpiry().isAfter(LocalTime.now(ZoneId.of("UTC"))))/*
																							 * .map(VerificationToken::
																							 * getUserInfo)
																							 */
				.orElseThrow(() -> new TokenException("The token is not found"));
	}

	@Override
	public void deleteToken(ResetPasswordToken token) {
		resetPasswordTokenRepo.delete(token);
	}

	public ResetPasswordTokenRepo getResetPasswordTokenRepo() {
		return resetPasswordTokenRepo;
	}

	@Autowired
	public void setResetPasswordTokenRepo(ResetPasswordTokenRepo resetPasswordTokenRepo) {
		this.resetPasswordTokenRepo = resetPasswordTokenRepo;
	}

}
