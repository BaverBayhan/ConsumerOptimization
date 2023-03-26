package com.GDSC.ConsumerOptimization.Service;

import com.GDSC.ConsumerOptimization.Entity.Post.*;
import com.GDSC.ConsumerOptimization.Entity.Post.Subcategories.*;
import com.GDSC.ConsumerOptimization.Entity.Post.Subcategories.FormContentIndexes.*;
import com.GDSC.ConsumerOptimization.Entity.User.UserInfo;
import com.GDSC.ConsumerOptimization.Repository.PostRepo;
import com.GDSC.ConsumerOptimization.Repository.UserinfoRepo;
import com.GDSC.ConsumerOptimization.Utils.HttpFormContentUtils;
import com.GDSC.ConsumerOptimization.Utils.URLPaths;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostRepo postRepo;

    @Autowired
    UserinfoRepo userinfoRepo;

    @Override
    public void savePost(Post post) {
        postRepo.save(post);
    }

    @Override
    public void deletePost(Long postId) {
        postRepo.delete(postRepo.getReferenceById(postId));
    }

    @Override
    public Post create_post(PostCategory category) {
        Post post = null;
        if(category.equals(PostCategory.DISHWASHER))
        {
            post = new DishWasherPost();
        }
        else if(category.equals(PostCategory.WASHING_MACHINE))
        {
            post = new WashingMachinePost();
        }
        else if(category.equals(PostCategory.ENERGY_CONSUMPTION))
        {
            post = new EnergyConsumptionPost();
        }
        else if(category.equals(PostCategory.KITCHEN))
        {
            post = new KitchenPost();
        }
        else if(category.equals(PostCategory.PERSONAL_HYGIENE))
        {
            post = new PersonalHygienePost();
        }
        else if(category.equals(PostCategory.RUBBISH))
        {
            post = new RubbishPost();
        }
        else if(category.equals(PostCategory.VACUUM_CLEANER))
        {
            post = new VacuumCleanerPost();
        }
        else if(category.equals(PostCategory.GENERIC))
        {
            post = new GenericTypePost();
        }
        return post;
    }

    @Override
    public Optional<List<Post>> getPostByUserInfo(UserInfo userInfo) {
        return postRepo.findByUserInfo(userInfo);
    }

    private String extractPathFromPostCategory(String category)
    {
        String path = null;
        if(category.equals(PostCategory.WASHING_MACHINE.getName()))
        {
            path= URLPaths.WASHINGMACHINE.getPath();
        }
        else if(category.equals(PostCategory.DISHWASHER.getName()))
        {
            path= URLPaths.DISHWASHER.getPath();
        }
        else if(category.equals(PostCategory.GENERIC.getName()))
        {
            path= URLPaths.GENERIC.getPath();
        }
        else if(category.equals(PostCategory.KITCHEN.getName()))
        {
            path= URLPaths.KITCHEN.getPath();
        }
        else if(category.equals(PostCategory.ENERGY_CONSUMPTION.getName()))
        {
            path= URLPaths.ENERGYCONSUMPTION.getPath();
        }
        else if(category.equals(PostCategory.RUBBISH.getName()))
        {
            path= URLPaths.RUBBISH.getPath();
        }
        else if(category.equals(PostCategory.VACUUM_CLEANER.getName()))
        {
            path= URLPaths.VACUUMCLEANER.getPath();
        }
        else if(category.equals(PostCategory.PERSONAL_HYGIENE.getName()))
        {
            path=URLPaths.PERSONALHYGIENE.getPath();
        }

        return path;
    }

    @Override
    public void injectCategoricalPostContent(@NotNull Post post, @NotNull List<String> postList) throws IOException, InterruptedException {

        String category = post.getCategory();
        String path = extractPathFromPostCategory(category);
        String responseString = HttpFormContentUtils.getUserDataFromSheetApi(path,post.getUserInfo().getUsername());
        List<String> response = HttpFormContentUtils.stringResponseToList(responseString);

        String username = post.getUserInfo().getUsername();
        if(post.getCategory().equals(PostCategory.WASHING_MACHINE.getName()))
        {
            WashingMachinePost washingMachinePost = (WashingMachinePost) post;
            washingMachinePost.setBrandOfWashingMachine(postList.get(WashingMachineIndexes.BRANDOFWASHINGMACHINE.getName()));
            washingMachinePost.setDegreeOfWash(postList.get(WashingMachineIndexes.DEGREEOFWASHING.getName()));
            washingMachinePost.setBrandOfDryingMachine(postList.get(WashingMachineIndexes.BRANDOFDRYINGMACHINE.getName()));
            washingMachinePost.setDryingMachineUsage(postList.get(WashingMachineIndexes.DRYINGMACHINEUSAGE.getName()));
            washingMachinePost.setDetergentConsumptionPerWash(postList.get(WashingMachineIndexes.MLOFDETERGENTPERLAUNDRY.getName()));
            washingMachinePost.setAvgLaundryPerWeek(postList.get(WashingMachineIndexes.DOINGLAUNDRYPERWEEK.getName()));
            washingMachinePost.setdryingMachineUsagePerWeek(postList.get(WashingMachineIndexes.DRYINGMACHINEUSAGEPERWEEK.getName()));
            washingMachinePost.setFabricSoftenerUsage(postList.get(WashingMachineIndexes.FABRICSOFTENERUSAGE.getName()));
            washingMachinePost.setMlOfFabricSoftenerUsage(postList.get(WashingMachineIndexes.AVERAGECONSUMPTOINOFFABRICSOFTENER.getName()));
            washingMachinePost.setFabricSoftenerBrand(postList.get(WashingMachineIndexes.BRANDOFFABRICSOFTENER.getName()));
            washingMachinePost.setTypeOfDetergent(postList.get(WashingMachineIndexes.TYPEOFDETERGENT.getName()));
            washingMachinePost.setDetergentBrand(postList.get(WashingMachineIndexes.BRANDOFDETERGENT.getName()));
            washingMachinePost.setByHandOrMachine(postList.get(WashingMachineIndexes.BYHANDORBYMACHINE.getName()));
            washingMachinePost.setSolidityRatio(postList.get(WashingMachineIndexes.SOLIDITYRATIO.getName()));

        }
        else if(post.getCategory().equals(PostCategory.DISHWASHER.getName()))
        {
            DishWasherPost dishWasherPost = (DishWasherPost) post;
            int real_index = 0;
            if(postList.get(DishWasherIndexes.AVERAGEDISHWASHPERWEEK1.getName()).equals("")){
                real_index=DishWasherIndexes.AVERAGEDISHWASHPERWEEK2.getName();
            }
            else {
                real_index=DishWasherIndexes.AVERAGEDISHWASHPERWEEK1.getName();
            }
            dishWasherPost.setByHandOrMachine(postList.get(DishWasherIndexes.BYHANDORBYMACHINE.getName()));
            dishWasherPost.setAveragePerWeek(postList.get(real_index));
            dishWasherPost.setSolidityRatio(postList.get(DishWasherIndexes.SOLIDITYRATIO.getName()));
            dishWasherPost.setDetergentBrand(postList.get((DishWasherIndexes.BRANDOFDISHWASHERDETERGENT.getName())));
            dishWasherPost.setDishWasherBrand(postList.get((DishWasherIndexes.BRANDOFDISHWASHER.getName())));
            dishWasherPost.setRinseAidUsage(postList.get((DishWasherIndexes.RINSEAIDUSAGE.getName())));
            dishWasherPost.setBrandOfRinseAid(postList.get(DishWasherIndexes.RINSEAIDBRAND.getName()));

        }
        else if(post.getCategory().equals(PostCategory.GENERIC.getName()))
        {
            GenericTypePost genericTypePost = (GenericTypePost) post;
            genericTypePost.setFormContent(response.get(2));
        }
        else if(post.getCategory().equals(PostCategory.VACUUM_CLEANER.getName()))
        {
            VacuumCleanerPost vacuumCleanerPost = (VacuumCleanerPost) post;
            System.err.println(postList);
            vacuumCleanerPost.setVacuumCleanerUsagePerWeek(postList.get(VacuumCleanerIndexes.VACUUMCLEANERUSAGEPERWEEK.getName()));
            vacuumCleanerPost.setSquareMeterVacuumed(postList.get(VacuumCleanerIndexes.SQUAREMETERVACUUM.getName()));
            vacuumCleanerPost.setRobotVacuumCleanerUsage(postList.get(VacuumCleanerIndexes.ROBOTVACUUMCLEANERUSAGE.getName()));
            vacuumCleanerPost.setVacuumCleanerBrand(postList.get(VacuumCleanerIndexes.BRANDOFVACUUMCLEANER.getName()));
            vacuumCleanerPost.setBrandOfRobotVacuumCleaner(postList.get(VacuumCleanerIndexes.BRANDOFROBOTVACUUMCLEANER.getName()));

        }
        else if(post.getCategory().equals(PostCategory.ENERGY_CONSUMPTION.getName()))
        {
            EnergyConsumptionPost energyConsumptionPost = (EnergyConsumptionPost) post;
            energyConsumptionPost.setElectricityUsageAmount(postList.get(EnergyConsumptionIndexes.ELECTRICITYUSAGE.getName()));
            energyConsumptionPost.setPublicTransport(postList.get(EnergyConsumptionIndexes.PUBLICTRANSPORT.getName()));
            energyConsumptionPost.setKilometersDrivePerMonth(postList.get(EnergyConsumptionIndexes.KMDRIVEPERMONTH.getName()));
            energyConsumptionPost.setNaturalGasUsageAmount(postList.get(EnergyConsumptionIndexes.NATURALGASUSAGE.getName()));
            energyConsumptionPost.setTypeOfFuel(postList.get(EnergyConsumptionIndexes.TYPEOFFUEL.getName()));
            energyConsumptionPost.setWaterUsageAmount(postList.get(EnergyConsumptionIndexes.WATERUSAGE.getName()));
            energyConsumptionPost.setPublicTransportOrOwnVehicle(postList.get(EnergyConsumptionIndexes.PUBLICTRANSPORTOROWNVEHICHLE.getName()));
            energyConsumptionPost.setPublicTransportUsageFrequency(postList.get(EnergyConsumptionIndexes.USAGEFREQUENCYOFPUBLICTRANSPORT.getName()));
        }
        else if(post.getCategory().equals(PostCategory.PERSONAL_HYGIENE.getName()))
        {
            PersonalHygienePost personalHygienePost = (PersonalHygienePost) post;
            personalHygienePost.setCareProductsUsagePerDay(postList.get(PersonalHygieneIndexes.CAREPRODUCTUSAGEPERDAY.getName()));
            personalHygienePost.setAverageShowerTimePerWeek(postList.get(PersonalHygieneIndexes.AVERAGESHOWERTIMEPERWEEK.getName()));
            personalHygienePost.setShampooConsumptionPerMonth(postList.get(PersonalHygieneIndexes.SHAMPOOCONSUMPTION.getName()));
            personalHygienePost.setShowerGelUsage(postList.get(PersonalHygieneIndexes.SHOWERGELCONSUMPTION.getName()));
            personalHygienePost.setTeethBrushPerDay(postList.get(PersonalHygieneIndexes.TEETHBRUSHPERDAY.getName()));

        }
        else if(post.getCategory().equals(PostCategory.KITCHEN.getName()))
        {
            KitchenPost kitchenPost = (KitchenPost) post;
            kitchenPost.setBrandOfOven(postList.get(KitchenIndexes.BRANDOFOVEN.getName()));
            kitchenPost.setBrandOfRefrigerator(postList.get(KitchenIndexes.BRANDOFREFRIGERATOR.getName()));
            kitchenPost.setCookAveragePerWeek(postList.get(KitchenIndexes.AVERAGECOOKPERWEEK.getName()));
            kitchenPost.setStoveUsagePerWeek(postList.get(KitchenIndexes.STOVEUSAGEPERWEEK.getName()));
            kitchenPost.setOvenUsagePerWeek(postList.get(KitchenIndexes.OVENUSAGEPERWEEK.getName()));
        }
        else if(post.getCategory().equals(PostCategory.RUBBISH.getName()))
        {
            RubbishPost rubbishPost = (RubbishPost) post;
            rubbishPost.setGarbageBagCountPerWeek(postList.get(RubbishIndexes.GARBAGEBAGCOUNTPERWEEK.getName()));
            rubbishPost.setRecyclingOrNot(postList.get(RubbishIndexes.RECYCLINGORNOT.getName()));
            rubbishPost.setRecyclingBagsAmountPerWeek(postList.get((RubbishIndexes.RECYCLINGBAGAMOUNTSPERWEEK.getName())));
        }

    }


}
