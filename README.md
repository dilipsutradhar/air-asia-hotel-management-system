There are two different API to which needs to be cloned and build to run the Air-Asia-Hotel-Management-Syatem Application

  1. air-asia-hotel-management-system  : https://github.com/dilipsutradhar/air-asia-hotel-management-system.git
  2. air-asia-hotel-management-system1 : https://github.com/dilipsutradhar/air-asia-hotel-management-system1.git
  
--> Clone these two project in your local and import from Existing Git as a general Project
--> install MongoDb locally
     Reference to install MongoDb locally: https://medium.com/@LondonAppBrewery/how-to-download-install-mongodb-on-windows-4ee4b3493514
     
--> MongoDb configuration for 
      1. air-asia-hotel-management-system
            spring.data.mongodb.host=localhost
            spring.data.mongodb.port=27017
            spring.data.mongodb.database=air-asia-db
            
      2. air-asia-hotel-management-system1
            spring.data.mongodb.database=air-asia-booking-db
            
--> both these api are communicating using "Feight Client" with below feight configuration
            feign.name=restclient
            feign.url=http://localhost:8080/
            
--> About the the two Module:
             1. air-asia-hotel-management-system  : 
                      This API is handling only Hotel Admin related operations :-
                              1. Onboarding/Registering New Hotel to the Air Asia HMS Syatem
                              2. Removing a Hotel Contract with Air Asia
                              3. Getting Hotel Current Status if its full or still receiving Guests
                              4. Keeping information like How many rooms are available to this hotel and what are the Types of Room currently available 
                                 like how many Standard rooms are available and How many Premium Rooms are in service for a pertticular Hotel.
             2. air-asia-hotel-management-system1 : 
                      This API is handling all the Booking related operations :-
                              1. Check Available Hotels 
                              2. Book a Hotel Room
                              3. get Booking Details using Customer name.
                              4. Update Checkin Date
                              5. Update Checkout Date
                              6. Cancel a Booking
                              7. Check Available Hotels 
                              
--> Used Global Exception Handling and input Validation in the project
                              
--> Running the Application:

         1. air-asia-hotel-management-system1 : port 8090 , This is calling the second API internally for Hotel related Queries using Feight CLient connection
         2. air-asia-hotel-management-system  : port 8080
         
Operations:
  A i am instructed to use Single Responsibility Principle i made sure to provide single responsibility to each class
  hence i have two Distinct Interface one for HotelAdminController and another for HotelsBookingController used by its respective service class.
        
      A. HotelAdminController only does operation to manage different Hotel infos in the system
        1.  To register a New Hotel into Air Asia HMS System
                http://localhost:8090/app1/admin/service/RegisteraNewHotel  //POST
         
                ResponseBody:
                              {
                                 "id":"88",
                                 "hotelName":"USAInn",
                                 "rooms":{
                                    "roomCount":300,
                                    "occupiedRooms":50,
                                    "freeRooms":250,
                                    "freeStandardRooms":150,
                                    "freeBusinessRooms":50,
                                    "freePremiumRooms":50
                                 },
                                 "hotelAddress":"105-Banjara Hills ,West Texas',309",
                                 "status":"MAINTAINANCE"
                              }

             
             
             2. Get all registered Hotels Under Air Asia
                    http://localhost:8090/app1/admin/service/getAllRegisteredHotelsInfo   //GET
                    
              
              3. Get Hotel Detail By HotelName
                    http://localhost:8090/app1/admin/service/show/hotelInfoByName?hotelName=USAInn  //GET
                    
                    
              4. Get available Hotel Info By Its Current Status. like RECEIVING, FULL, MAINTAINANCE;
                    http://localhost:8090/app1/admin/service/show/hotelInfoByStatus?status=RECEIVING //GET
                    
              5. Get Available Hotel By Room Type like STANDARD Room, BUSINESS Room, PREMIUM Room.
                    http://localhost:8090/app1/admin/service/show/HotelInfoRoomType?roomType=PREMIUM  //GET
                    --> this will give all the available hotel info which has specified Room Types currently Unocupied.
                    
              6. De-Register or cancel the Service of any Hotel from Air Asia Syatem
                    http://localhost:8090/app1/admin/service/deRegisteredHotel?hotelName=HolidayInn //DELETE
            
            
    B. HotelBookingController is responsible for all the booking related operations
          
          1. Get all the available Bookings
                http://localhost:8090/app1/booking/getAllAvailableBookings  //GET
                
          2. Create a new booking  
                http://localhost:8090/app1/booking/createBooking  //POST
                    RequestBody:
                                {
                                  "id": 27,
                                  "roomDetails": {
                                      "roomNo": 207,
                                      "roomName": "",
                                      "roomType": "STANDARD"
                                  },
                                  "guestCount": 5,
                                  "custName": "Dilip Sutradhar",
                                  "emailId": "dilip.sutradhar7@gmail.com",
                                  "phoneNo": 8007947748,
                                  "address": "202-Pan Bazar, West Garo Hills ,Tura, Meghalaya,794001",
                                  "checkInDate": "1985-10-25T18:30:00.000+00:00",
                                  "checkOutDate": "1985-10-25T18:30:00.000+00:00",
                                  "status": "CONFIRMED",
                                  "hotelname": "NatrajINN"
                              }
             3.  Get the gooing detail using CUstomerName   
                    http://localhost:8090/app1/booking/getBookingInfoByCustomerName?customerName=Shweta Malhotra //GET
                        O/P
                            {
                              "id": 2,
                              "roomDetails": {
                                  "roomNo": 101,
                                  "roomName": "",
                                  "roomType": "STANDARD"
                              },
                              "guestCount": 5,
                              "custName": "Shweta Malhotra",
                              "emailId": "sweta.malhotra7@gmail.com",
                              "phoneNo": 9007947748,
                              "address": "202-Pan Bazar, West Garo Hills ,Tura, Meghalaya,794001",
                              "checkInDate": "1985-10-25T18:30:00.000+00:00",
                              "checkOutDate": "1985-10-25T18:30:00.000+00:00",
                              "status": "CONFIRMED",
                              "hotelname": "Natraj"
                          }
                          
              4. Delete an existing Booking
                      http://localhost:8090/app1/deleteBookingByCustomerNameOrBookingId?customerName=Rahul Malhotra  //DELETE
                      
              5. Updating Checkin Date and Checkout Date Can be added in the future.
                      
            
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
    
