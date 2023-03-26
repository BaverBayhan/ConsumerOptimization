import gspread

def get_all_data_from_sheet(name,description):

    client = gspread.service_account(filename="credentials.json")

    sheet=client.open(name)

    wks = sheet.worksheet(description)

    return wks.get_all_values()

def get_data_with_username(name,description,username):

    client = gspread.service_account(filename="credentials.json")

    sheet=client.open(name)

    wks = sheet.worksheet(description)

    cell = wks.find(username)

    row_value = wks.row_values(cell.row)    

    return row_value



sheetDict = {
    "DISHWASHER":["Dishwasher (Yanıtlar)","Form Yanıtları 1"],
    "WASHINGMACHINE":["Washing Machine (Responses)","Form Responses 1"],
    "KITCHEN":["Kitchen (Yanıtlar)","Form Yanıtları 1"],
    "ENERGYCONSUMPTION":["Energy Consumption (Yanıtlar)","Form Yanıtları 1"],
    "PERSONALHYGIENE":["Personal Hygiene (Yanıtlar)","Form Yanıtları 1"],
    "RUBBISH":["Rubbish (Yanıtlar)","Form Yanıtları 1"],
    "VACUUMCLEANER":["Vacuum Cleaner (Yanıtlar)","Form Yanıtları 1"],
    "GENERIC":["Generic (Responses)","Form Responses 1"]
}





