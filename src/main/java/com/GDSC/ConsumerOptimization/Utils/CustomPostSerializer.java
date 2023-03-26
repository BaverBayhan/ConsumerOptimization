package com.GDSC.ConsumerOptimization.Utils;

import com.GDSC.ConsumerOptimization.Entity.Post.Subcategories.*;
import com.GDSC.ConsumerOptimization.Entity.Post.Post;
import com.GDSC.ConsumerOptimization.Entity.Post.PostCategory;
import com.GDSC.ConsumerOptimization.Entity.Post.Subcategories.FormContentIndexes.EnergyConsumptionIndexes;
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
        jsonGenerator.writeStringField("explanation", post.getExplanation());
        jsonGenerator.writeStringField("category", post.getCategory());
        jsonGenerator.writeNumberField("likeCount",post.getLikeCount());
        LocalDateTime dateTime = post.getTime();
        String dateTimeString = dateTime.format(formatter);
        jsonGenerator.writeStringField("createdAt", dateTimeString);


        jsonGenerator.writeObjectFieldStart("content");
        if(post.getCategory().equals(PostCategory.WASHING_MACHINE.getName())){
            WashingMachinePost newPost = (WashingMachinePost) post;
            jsonGenerator.writeStringField("by hand or by machine", newPost.getByHandOrMachine());
            jsonGenerator.writeStringField("solidity ratio", newPost.getSolidityRatio());
            jsonGenerator.writeStringField("average laundry per week", newPost.getAvgLaundryPerWeek());
            jsonGenerator.writeStringField("type of detergent", newPost.getTypeOfDetergent());
            jsonGenerator.writeStringField("detergent consumption per laundry (ml)", newPost.getDetergentConsumptionPerWash());
            jsonGenerator.writeStringField("brand of detergent", newPost.getDetergentBrand());
            jsonGenerator.writeStringField("degree of washing", newPost.getDegreeOfWash());
            jsonGenerator.writeStringField("fabric softener usage", newPost.getFabricSoftenerUsage());
            jsonGenerator.writeStringField("fabric softener consumption per washing (ml)", newPost.getMlOfFabricSoftenerUsage());
            jsonGenerator.writeStringField("fabric softener brand", newPost.getFabricSoftenerBrand());
            jsonGenerator.writeStringField("washing machine brand", newPost.getBrandOfWashingMachine());
            jsonGenerator.writeStringField("drying machine usage", newPost.getDryingMachineUsage());
            jsonGenerator.writeStringField("drying machine usage frequency per week", newPost.getDryingMachineUsagePerWeek());
            jsonGenerator.writeStringField("brand of drying machine", newPost.getBrandOfDryingMachine());
        }
        else if(post.getCategory().equals(PostCategory.DISHWASHER.getName())){
            DishWasherPost newPost = (DishWasherPost) post;
            jsonGenerator.writeStringField("by hand or by machine", newPost.getByHandOrMachine());
            jsonGenerator.writeStringField("average per week" , newPost.getAveragePerWeek());
            jsonGenerator.writeStringField("solidity ratio", newPost.getSolidityRatio());
            jsonGenerator.writeStringField("detergent brand" , newPost.getDetergentBrand());
            jsonGenerator.writeStringField("dishwasher brand", newPost.getDishWasherBrand());
            jsonGenerator.writeStringField("rinse aid usage" , newPost.getRinseAidUsage());
            jsonGenerator.writeStringField("rinse aid brand" , newPost.getBrandOfRinseAid());
        }
        else if(post.getCategory().equals(PostCategory.ENERGY_CONSUMPTION.getName())){
            EnergyConsumptionPost newPost = (EnergyConsumptionPost) post;
            jsonGenerator.writeStringField("electricity usage amount", newPost.getElectricityUsageAmount());
            jsonGenerator.writeStringField("natural gas usage amount" , newPost.getNaturalGasUsageAmount());
            jsonGenerator.writeStringField("water usage amount", newPost.getWaterUsageAmount());
            jsonGenerator.writeStringField("public transport or own vehicle" , newPost.getPublicTransportOrOwnVehicle());
            jsonGenerator.writeStringField("kilometers drive per month", newPost.getKilometersDrivePerMonth());
            jsonGenerator.writeStringField("type of fuel" , newPost.getTypeOfFuel());
            jsonGenerator.writeStringField("used public transports" , newPost.getPublicTransport());
            jsonGenerator.writeStringField("public transport usage frequency" , newPost.getPublicTransportUsageFrequency());
        }
        else if(post.getCategory().equals(PostCategory.KITCHEN.getName()))
        {
            KitchenPost newPost = (KitchenPost) post;
            jsonGenerator.writeStringField("average cooking per week",newPost.getCookAveragePerWeek());
            jsonGenerator.writeStringField("oven usage per week",newPost.getOvenUsagePerWeek());
            jsonGenerator.writeStringField("stove usage per week",newPost.getStoveUsagePerWeek());
            jsonGenerator.writeStringField("brand of oven",newPost.getBrandOfOven());
            jsonGenerator.writeStringField("brand of refrigerator",newPost.getBrandOfRefrigerator());

        }
        else if(post.getCategory().equals(PostCategory.PERSONAL_HYGIENE.getName()))
        {
            PersonalHygienePost newPost = (PersonalHygienePost) post;
            jsonGenerator.writeStringField("shower time per week",newPost.getAverageShowerTimePerWeek());
            jsonGenerator.writeStringField("average time for consumption a 400 ml shampoo",newPost.getShampooConsumptionPerMonth());
            jsonGenerator.writeStringField("average time for consumption a 400 ml gel",newPost.getShowerGelUsage());
            jsonGenerator.writeStringField("teeth brush per day",newPost.getTeethBrushPerDay());
            jsonGenerator.writeStringField("care product usage per day",newPost.getCareProductsUsagePerDay());
        }
        else if(post.getCategory().equals(PostCategory.RUBBISH.getName()))
        {
            RubbishPost newPost = (RubbishPost) post;
            jsonGenerator.writeStringField("garbage bags taken out",newPost.getGarbageBagCountPerWeek());
            jsonGenerator.writeStringField("separate for recycling or not",newPost.getRecyclingOrNot());
            jsonGenerator.writeStringField("recycling bags amount per week",newPost.getRecyclingBagsAmountPerWeek());

        }
        else if(post.getCategory().equals(PostCategory.VACUUM_CLEANER.getName()))
        {
            VacuumCleanerPost newPost = (VacuumCleanerPost) post;
            jsonGenerator.writeStringField("average vacuum cleaner usage hours per week",newPost.getVacuumCleanerUsagePerWeek());
            jsonGenerator.writeStringField("total area vacuumed (m2) ",newPost.getSquareMeterVacuumed());
            jsonGenerator.writeStringField("brand of vacuum cleaner",newPost.getBrandOfRobotVacuumCleaner());
            jsonGenerator.writeStringField("robot vacuum cleaner usage",newPost.getRobotVacuumCleanerUsage());
            jsonGenerator.writeStringField("brand of robot vacuum cleaner",newPost.getBrandOfRobotVacuumCleaner());
        }

        jsonGenerator.writeEndObject();

        jsonGenerator.writeEndObject();
    }


}

