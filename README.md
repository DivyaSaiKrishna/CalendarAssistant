# CalendarAssistant
Inputs
#http://localhost:8080/appointment/setMeeting
{
    "EmpId" : "001",
    "Slots":{
        "7:00-7:30" : "Available",
        "7:30-8:00" : "Not Available"
    }
}

http://localhost:8080/appointment/setMeeting
{
    "EmpId" : "002”,
    "Slots":{
        "7:00-7:30" : "Available",
        "7:30-8:00" : "Not Available"
    }
}

http://localhost:8080/appointment/getAvailableSlots
{
   "empid1" : "001",
   "empid2" : "002"
}

http://localhost:8080/appointment/getConflits
'7:30-8:00'

<img width="890" alt="Screenshot 2021-06-23 at 11 03 11 PM" src="https://user-images.githubusercontent.com/51916483/123146691-cf5d5b80-d47b-11eb-915f-4ef95ef48519.png">
<img width="890" alt="Screenshot 2021-06-23 at 11 01 08 PM" src="https://user-images.githubusercontent.com/51916483/123146801-edc35700-d47b-11eb-95e8-f616e9cd662d.png">
<img width="889" alt="Screenshot 2021-06-23 at 10 54 49 PM" src="https://user-images.githubusercontent.com/51916483/123146822-f4ea6500-d47b-11eb-9508-54f4de92e774.png">
