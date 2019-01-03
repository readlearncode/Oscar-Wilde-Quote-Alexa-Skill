package com.readlearncode.utils;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Slot;
import com.amazon.ask.model.services.directive.Header;
import com.amazon.ask.model.services.directive.SendDirectiveRequest;
import com.amazon.ask.model.services.directive.SpeakDirective;
import com.amazonaws.util.StringUtils;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class AlexaUtils {

    public static String getSlot(String slotName, HandlerInput handlerInput) {
        Intent intent = getIntentRequest(handlerInput).getIntent();
        Slot slotValue = intent.getSlots().get(slotName);
        return slotValue == null ? null : StringUtils.trim(slotValue.getValue());
    }

    public static IntentRequest getIntentRequest(HandlerInput handlerInput) {
        return (IntentRequest) handlerInput.getRequestEnvelope().getRequest();
    }

    public static String getAPIAccessToken(HandlerInput handlerInput) {
        return handlerInput.getRequestEnvelope().getContext().getSystem().getApiAccessToken();
    }

    public static String getRequestId(HandlerInput handlerInput) {
        return handlerInput.getRequestEnvelope().getRequest().getRequestId();
    }

    public static String getAPIEndpoint(HandlerInput handlerInput) {
        return handlerInput.getRequestEnvelope().getContext().getSystem().getApiEndpoint();
    }

    public static String getApplicationId(HandlerInput handlerInput) {
        return handlerInput.getRequestEnvelope().getContext().getSystem().getApplication().getApplicationId();
    }

    public static void sendProgressiveResponse(HandlerInput input, String speech) {
        SpeakDirective speakDirective = SpeakDirective.builder().withSpeech(speech).build();
        Header header = Header.builder().withRequestId(getRequestId(input)).build();
        SendDirectiveRequest sendDirectiveRequest = SendDirectiveRequest.builder().withHeader(header).withDirective(speakDirective).build();
        input.getServiceClientFactory().getDirectiveService().enqueue(sendDirectiveRequest);
    }
}