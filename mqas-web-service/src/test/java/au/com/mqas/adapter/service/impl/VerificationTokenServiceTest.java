package au.com.mqas.adapter.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import au.com.mqas.adapter.service.exception.TokenException;
import au.com.mqas.data.repo.VerificationTokenRepo;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest
class VerificationTokenServiceTest {

	@Mock
	private VerificationTokenRepo verificationTokenRepo;

	@InjectMocks
	private VerificationTokenService verificationTokenService;

	@Test
	void test() {

		when(verificationTokenRepo.findByToken(ArgumentMatchers.any(String.class))).thenReturn(Optional.empty());

		assertThrows(TokenException.class, () -> verificationTokenService.verifyToken("hggsdfhgshdgfhsd"));

		verify(verificationTokenRepo).findByToken(ArgumentMatchers.any(String.class));

	}

}
