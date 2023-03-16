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

name="Generic (Responses)"
description="Form Responses 1"



print(get_data_with_username(name,description,"baver1234"))