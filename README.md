# cowin-report-service

This is the dashboard report that we get from the cowin official website.We upload the data to elastic search and expose APIs. This application is event driven in nature. The message object will be passed to a sync event which is done with Spring Events and listener will get the message and store in elastic server.

## Pre-requisites -
There should be local instance of elastic search and Kibana running.

## Key Features -
- Login to cowin website and download the report.
- Upload the JSON report via postman collection and inserts the data in elastic search.
- Fetch the arrays of report from the elastic search based on the criteria.

```
curl --location 'http://localhost:8888/api/v1/upload' \
--form 'file=@"/C:/Users/tenzin-PC/Downloads/dashboard_export.json"'

```


```
curl --location 'http://localhost:8888/api/v1/fetchAll'

```

```
curl --location 'http://localhost:8888/api/v1/fetchAll/last30DaysAefiReported'

```
