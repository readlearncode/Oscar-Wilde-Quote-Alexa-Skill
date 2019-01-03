package com.readlearncode.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;
import com.readlearncode.utils.AlexaUtils;
import com.readlearncode.utils.ServiceUtils;

import java.util.Optional;

public class QuoteIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("QuoteIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {

        AlexaUtils.sendProgressiveResponse(handlerInput, "Oscar said.");

        String subject = AlexaUtils.getSlot("subject", handlerInput);
        String quote = ServiceUtils.findQuoteAbout(subject);

        return handlerInput.getResponseBuilder()
                .withSpeech(quote)
                .withSimpleCard("Oscar Wilde", quote)
                .build();

    }

}