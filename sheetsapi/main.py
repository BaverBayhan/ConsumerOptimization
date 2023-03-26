from fastapi import FastAPI
import SheetsAPI

app=FastAPI()

@app.get("/Dishwasher")
async def get_all_data_for_partyInvite():
    return SheetsAPI.get_all_data_from_sheet(SheetsAPI.sheetDict.get("DISHWASHER")[0],
                                             SheetsAPI.sheetDict.get("DISHWASHER")[1])
@app.get("/WashingMachine")
async def get_all_data_for_partyInvite():
    return SheetsAPI.get_all_data_from_sheet(SheetsAPI.sheetDict.get("WASHINGMACHINE")[0],
                                             SheetsAPI.sheetDict.get("WASHINGMACHINE")[1])
@app.get("/EnergyConsumption")
async def get_all_data_for_partyInvite():
    return SheetsAPI.get_all_data_from_sheet(SheetsAPI.sheetDict.get("ENERGYCONSUMPTION")[0],
                                             SheetsAPI.sheetDict.get("ENERGYCONSUMPTION")[1])
@app.get("/VacuumCleaner")
async def get_all_data_for_partyInvite():
    return SheetsAPI.get_all_data_from_sheet(SheetsAPI.sheetDict.get("VACUUMCLEANER")[0],
                                             SheetsAPI.sheetDict.get("VACUUMCLEANER")[1])
@app.get("/Rubbish")
async def get_all_data_for_partyInvite():
    return SheetsAPI.get_all_data_from_sheet(SheetsAPI.sheetDict.get("RUBBISH")[0],
                                             SheetsAPI.sheetDict.get("RUBBISH")[1])
@app.get("/PersonalHygiene")
async def get_all_data_for_partyInvite():
    return SheetsAPI.get_all_data_from_sheet(SheetsAPI.sheetDict.get("PERSONALHYGIENE")[0],
                                             SheetsAPI.sheetDict.get("PERSONALHYGIENE")[1])
@app.get("/Kitchen")
async def get_all_data_for_partyInvite():
    return SheetsAPI.get_all_data_from_sheet(SheetsAPI.sheetDict.get("KITCHEN")[0],
                                             SheetsAPI.sheetDict.get("KITCHEN")[1])
@app.get("/Generic")
async def get_all_data_for_partyInvite():
    return SheetsAPI.get_all_data_from_sheet(SheetsAPI.sheetDict.get("GENERIC")[0],
                                             SheetsAPI.sheetDict.get("GENERIC")[1])

# Username Specific API



@app.get("/Dishwasher/{username}")
async def get_all_data_for_partyInvite(username: str):
    return SheetsAPI.get_data_with_username(SheetsAPI.sheetDict.get("DISHWASHER")[0],
                                             SheetsAPI.sheetDict.get("DISHWASHER")[1],
                                             username)
@app.get("/WashingMachine/{username}")
async def get_all_data_for_partyInvite(username: str):
    return SheetsAPI.get_data_with_username(SheetsAPI.sheetDict.get("WASHINGMACHINE")[0],
                                             SheetsAPI.sheetDict.get("WASHINGMACHINE")[1],
                                             username)
@app.get("/EnergyConsumption/{username}")
async def get_all_data_for_partyInvite(username: str):
    return SheetsAPI.get_data_with_username(SheetsAPI.sheetDict.get("ENERGYCONSUMPTION")[0],
                                             SheetsAPI.sheetDict.get("ENERGYCONSUMPTION")[1],
                                             username)
@app.get("/VacuumCleaner/{username}")
async def get_all_data_for_partyInvite(username: str):
    return SheetsAPI.get_data_with_username(SheetsAPI.sheetDict.get("VACUUMCLEANER")[0],
                                             SheetsAPI.sheetDict.get("VACUUMCLEANER")[1],
                                             username)
@app.get("/Rubbish/{username}")
async def get_all_data_for_partyInvite(username: str):
    return SheetsAPI.get_data_with_username(SheetsAPI.sheetDict.get("RUBBISH")[0],
                                             SheetsAPI.sheetDict.get("RUBBISH")[1],
                                             username)
@app.get("/PersonalHygiene/{username}")
async def get_all_data_for_partyInvite(username: str):
    return SheetsAPI.get_data_with_username(SheetsAPI.sheetDict.get("PERSONALHYGIENE")[0],
                                             SheetsAPI.sheetDict.get("PERSONALHYGIENE")[1],
                                             username)
@app.get("/Kitchen/{username}")
async def get_all_data_for_partyInvite(username: str):
    return SheetsAPI.get_data_with_username(SheetsAPI.sheetDict.get("KITCHEN")[0],
                                             SheetsAPI.sheetDict.get("KITCHEN")[1],
                                             username)
@app.get("/Generic/{username}")
async def get_all_data_for_partyInvite(username: str):
    return SheetsAPI.get_data_with_username(SheetsAPI.sheetDict.get("GENERIC")[0],
                                             SheetsAPI.sheetDict.get("GENERIC")[1],
                                             username)
