package com.readlearncode.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

public class LaunchRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Welcome to the Oscar Wilde Quote Skill. To request a quote just say 'give me a quote'";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Oscar Wilde", speechText)
                .withReprompt(speechText)
                .build();
    }

}