package com.bbarters.services

import bnp.Payment
import grails.transaction.Transactional
import org.grails.web.json.JSONObject

@Transactional
class PaymentService {

    public static Payment createPayment(String paymentType, Integer amt, JSONObject pinfo) {

        def instance = Class.forName("bnp." + paymentType+"Payment").newInstance()
        savePaymentDetails(instance,amt,pinfo)
        return instance
    }

    private static void savePaymentDetails(IPaymentInfo p, Integer amount, JSONObject pinfo)
    {
        p.savePaymentInfo(amount, pinfo)
    }
}
