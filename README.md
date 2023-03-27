# cowin-report-service

This is the dashboard report that we get from the cowin official website.

## Pre-requisites -
There should be local instance of elastic search and Kibana running.

## Key Features -
- Login to cowin website and download the report.
- Upload the JSON report via postman collection and inserts the data in elastic search.
- Fetch the arrays of report from the elastic search based on the criteria.

```
curl --location 'http://localhost:8888/api/v1/upload' \
--header 'Content-Type: application/vnd.ms-excel' \
--form 'file=@"/C:/Users/320086435/Downloads/dashboard_export.json"'

```


```
curl --location 'http://localhost:8888/api/v1/fetchAll'

```
