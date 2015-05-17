Crime Analysis Engine(CMPE 272 Project) (Project Team 1)
=========================================================

-------------------------
Crime Analysis Engine 
-------------------------   

Short Description
------------------
Everyday when we travel to places, how often do we know the area around us? Safety is a major concern for everyone. Hence, we need an engine that will aid us to understand how safe a particular area is at any given time. Our Crime Analysis engine provides analysis, visualization and information of the criminal data related to the crimes happening in the area. It will allow the user to see crime hotspots, isolate crimes by type, and identify the days when a particular crime occurs as well as the time.

Cities Covered
---------------
1. San Francisco
2. Atlanta
3. Chicago
4. Sacramento
5. San Deigo
6. Oakland
7. Salt Lake
8. N.charlotte


Introduction
------------
Education is the best defense against crime. Hence, we provide the crime analysis engine to provide an analysis about the neighborhood of our interest.
Crime Analysis Engine is a mobile application aimed towards providing a tool to check the safety for any area. The primary goal of the application is to provide relevant and accurate statistical analysis of the crime in any particular area. We have done graphical representations and provided a crime map to highlight the crimes occurring in the area of interest. We have analyzed the data and provided a graphical representation about the crime types, frequency of occurrence, etc. Public can analyze a particular neighborhood to know the crime rate can use the application.
This paper aims at giving you a detailed description of our work along with various functionalities implemented in this application.  

Analysis
---------

We have been through various websites and applications doing crime analysis and generating crime map. However, they do not cater to all requirements. Also, many of those miss a graphical representation. When seen from an end user point, these sites and applications are not so easy to use. Also, the data used by them is irrelevant and unstructured. Hence, we decided to analyze the crime data of various top cities in the United States and develop a mobile application which will be have graphical representation of the data along with a crime map to depict the crime in the area entered by the user. We have provided statistical analysis of the data in following categories:

A. Crime Map
We gathered data from various government databases and other websites, which provide datasets about crimes in various cities of the United states. We transformed the unstructured data to a structured format. We then represent it graphically to show the overall rating of the area.

B. Crime By Day
Using the data used in A, we have represented the crime by each day of the week for a particular area. Consider a city, which has more crimes happening on weekends than weekdays. Hence, filter it and display it by day.

C. Crime By Time
In order to make the application even detailed for the user, we further filter the data and provide the crime occurrence by type in a graphical format. Thus, the user can view which crime has occurred the most by a particular time in this section. 

D. Crime By Type
We display the crimes by type for a particular area, which the user has inserted. Thus, the user can view the occurrence of crime by its type.

#Architecture
--------------
![ScreenShot](https://cloud.githubusercontent.com/assets/3395564/5386400/7d84981a-8080-11e4-9538-505b9e32f6d0.png)

How it Works
------------
1. Application takes either current location or the desired location for the analysis.
2. For that purpose it makes use of Googles Geo-Coding. From the address application take the latitude and longitude.
3. This data is then sent to the amazon aws java module.
4. This java module then does the analysis as per the user request and generates the output json data from the MySQL database.
5. This json data is consumed by the google charts and google maps to visualize the data.

Sample JSON outputs
-------------------
CrimeByDay
----------
```

?(
[
    {
        dayOfWeek: "Friday",
        totalCount: 5800
    },
    {
        dayOfWeek: "Monday",
        totalCount: 5199
    },
    {
        dayOfWeek: "Saturday",
        totalCount: 6242
    },
    {
        dayOfWeek: "Sunday",
        totalCount: 4743
    },
    {
        dayOfWeek: "Thursday",
        totalCount: 5755
    },
    {
        dayOfWeek: "Tuesday",
        totalCount: 5898
    },
    {
        dayOfWeek: "Wednesday",
        totalCount: 5762
    }
]
)
```
![ScreenShot](https://cloud.githubusercontent.com/assets/3395564/5386418/9188d63c-8080-11e4-885a-863452910d23.png)

CrimeByTime
-------------
```
?(
[
    {
        crimeTime: "00:00 - 01:00",
        totalCount: 2698
    },
    {
        crimeTime: "01:00 - 02:00",
        totalCount: 1071
    },
    {
        crimeTime: "02:00 - 03:00",
        totalCount: 815
    },
    {
        crimeTime: "03:00 - 04:00",
        totalCount: 666
    },
   .
   .
   .
    {
        crimeTime: "20:00 - 21:00",
        totalCount: 1989
    },
    {
        crimeTime: "21:00 - 23:00",
        totalCount: 2401
    },
    {
        crimeTime: "22:00 - 23:00",
        totalCount: 2012
    }
]
)
```
![ScreenShot](https://cloud.githubusercontent.com/assets/3395564/5386416/9184e9fa-8080-11e4-85e5-dc6a0035359d.png)

CrimeByType
-----------
```
?(
[
    {
        crimeType: "Arrest",
        totalCount: 3185
    },
    {
        crimeType: "Arson",
        totalCount: 69
    },
    {
        crimeType: "Assault",
        totalCount: 2308
    },
    {
        crimeType: "Burglary",
        totalCount: 750
    },
    {
        crimeType: "Other",
        totalCount: 25540
    },
    {
        crimeType: "Robbery",
        totalCount: 353
    },
    {
        crimeType: "Shooting",
        totalCount: 4
    },
    {
        crimeType: "Theft",
        totalCount: 6287
    },
    {
        crimeType: "Vandalism",
        totalCount: 903
    }
]
)
```
![ScreenShot](https://cloud.githubusercontent.com/assets/3395564/5386417/91868bac-8080-11e4-8d4a-96ad819e16fc.png)
CrimeMap
--------
```
?(
[
    {
        crimeType: "Burglary",
        lat: "40.7311897",
        lon: "-111.8150119",
        timeStamp: "2014-01-01 01:26:00"
    },
    {
        crimeType: "Arrest",
        lat: "40.7126884",
        lon: "-111.8579227",
        timeStamp: "2014-01-01 01:30:00"
    },
    {
        crimeType: "Other",
        lat: "40.7694452",
        lon: "-111.9396383",
        timeStamp: "2014-01-01 01:40:00"
    },
    {
        crimeType: "Arrest",
        lat: "40.7483082",
        lon: "-111.930809",
        timeStamp: "2014-01-01 02:09:00"
    },
    {
        crimeType: "Other",
        lat: "40.6572086",
        lon: "-111.9057385",
        timeStamp: "2014-01-01 02:10:00"
    },
    .
    .
    .
    .
]
)
```
![ScreenShot](https://cloud.githubusercontent.com/assets/3395564/5386412/9174f6d0-8080-11e4-8817-a25f673d4cc8.png)



Technology Used
----------------

1. J2EE
2. Jersey REST Framework
3. Jackson Framework
4. Mysql
5. HTML5
6. Jquery
7. CSS
8. Apache Cordova

Team Members
-------------
1. Omkar Gudekar
2. Larkins Carvalho
3. Nielet Dmello
4. Sagar Bendale
