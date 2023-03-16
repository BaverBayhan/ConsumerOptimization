from fastapi import FastAPI
import SheetsAPI

app=FastAPI()

@app.get("/Dishwasher")
async def get_all_data_for_partyInvite():
    return SheetsAPI.get_all_data_from_sheet(SheetsAPI.name,SheetsAPI.description)

@app.get("/Generic/{username}")
async def get_all_data_for_partyInvite(username: str):
    return SheetsAPI.get_data_with_username(SheetsAPI.name,SheetsAPI.description,username)