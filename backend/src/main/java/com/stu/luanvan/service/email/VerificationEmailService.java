package com.stu.luanvan.service.email;

import com.stu.luanvan.model.verification.VerificationModel;
import com.stu.luanvan.repository.VerificationEmailReponsitory;
import com.stu.luanvan.repository.VerificationEmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationEmailService implements VerificationEmailServiceImpl {
    @Autowired
    VerificationEmailReponsitory verificationEmailReponsitory;
    @Override
    public VerificationModel getVerificationToken(String token) {

        try {
            VerificationModel a = verificationEmailReponsitory.findOneByConfirmationToken(token);
            return a;
        }catch(Exception ex)
        {
            return null;
        }

    }
}
