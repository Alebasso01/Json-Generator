# Project Overview
This repository contains a microservice simulation that is part of a larger Structural Health Monitoring System (SHMS) developed in collaboration with RINA. The primary function of this microservice is to generate a JSON file containing the DAU (Data Acquisition Unit) parameter. This parameter is exposed via a specific port, allowing a secondary microservice to connect and retrieve the DAU data.

Once the DAU parameter has been extracted, it is stored in an InfluxDB instance, alongside other relevant parameters. The entire process is managed by a Spring Boot application, ensuring smooth operation and data handling.

