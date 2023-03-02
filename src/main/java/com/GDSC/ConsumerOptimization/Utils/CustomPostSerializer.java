package com.GDSC.ConsumerOptimization.Utils;

import com.GDSC.ConsumerOptimization.Entity.DishWasherPost;
import com.GDSC.ConsumerOptimization.Entity.Post;
import com.GDSC.ConsumerOptimization.Entity.PostCategory;
import com.GDSC.ConsumerOptimization.Entity.WashingMachinePost;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomPostSerializer extends StdSerializer<Post> {

    public CustomPostSerializer() {
        this(null);
    }

    public CustomPostSerializer(Class<Post> t) {
        super(t);
    }
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    @Override
    public void serialize(Post post, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", post.getId());
        jsonGenerator.writeStringField("description", post.getDescription());
        jsonGenerator.writeStringField("explanation", post.getExplanation());
        jsonGenerator.writeStringField("userToken", post.getUserToken());
        jsonGenerator.writeStringField("category", post.getCategory());
        LocalDateTime dateTime = post.getTime();
        String dateTimeString = dateTime.format(formatter);
        jsonGenerator.writeStringField("createdAt", dateTimeString);


        jsonGenerator.writeObjectFieldStart("content");
        if(post.getCategory().equals(PostCategory.WASHING_MACHINE.getName())){
            WashingMachinePost newPost = (WashingMachinePost) post;
            jsonGenerator.writeNumberField("pieceNumberPerWashing", newPost.getPieceNumberPerWashing());
            jsonGenerator.writeNumberField("degree", newPost.getDegree());
            jsonGenerator.writeNumberField("weeklyFrequency", newPost.getWeeklyFrequency());
            jsonGenerator.writeStringField("detergentType", newPost.getDetergentType());
            jsonGenerator.writeStringField("avgDetergentMl", newPost.getAvgDetergentMl());
            jsonGenerator.writeStringField("detergentBrand", newPost.getDetergentBrand());
            jsonGenerator.writeStringField("fabricSoftenerUsage", newPost.getFabricSoftenerUsage());
            jsonGenerator.writeStringField("fabricSoftenerMl", newPost.getFabricSoftenerMl());
            jsonGenerator.writeStringField("washingMachineBrand", newPost.getWashingMachineBrand());
        }
        else if(post.getCategory().equals(PostCategory.DISHWASHER.getName())){
            DishWasherPost newPost = (DishWasherPost) post;
            jsonGenerator.writeStringField("dishWasherBrand", newPost.getDishWasherBrand());
            jsonGenerator.writeStringField("dishSoapBrand", newPost.getDishSoapBrand());
            jsonGenerator.writeNumberField("timesPerWeek", newPost.getTimesPerWeek());
        }
        jsonGenerator.writeEndObject();

        jsonGenerator.writeEndObject();
    }


}

