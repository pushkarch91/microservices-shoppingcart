Start services in below order:
service-registry
config-server
cloud-gateway
product-service
order-service
payment-service

SERVICE: product-service
POST:
http://localhost:8080/products

Body:
{
    "name":"IPhone",
    "price":20000.0,
    "quantity":20.0
}

Response:
201 Created

------------------------------------------------------------
SERVICE: product-service
GET:
http://localhost:8080/products/1
------------------------------------------------------------
SERVICE: order-service
POST:
http://localhost:8082/orders/placeOrder

{
    "productId":1,
    "totalAmount":1100,
    "quantity":100,
    "paymentMode":"CASH"
}
------------------------------------------------------------
SERVICE: product-service
PUT:
Positive:
http://localhost:8080/products/reduceQuantity/1
Negative:
http://localhost:8080/products/reduceQuantity/1?quantity=200
------------------------------------------------------------
SERVICE: order-service
GET:
http://localhost:8082/orders/1

RESPONSE:
{
    "orderId": 1,
    "orderDate": "2025-05-26T11:13:30.325950Z",
    "orderStatus": "PLACED",
    "amount": 1100,
    "productDetails": {
        "productName": "IPhone",
        "productId": 3,
        "quantity": 0,
        "price": 0
    },
    "paymentDetails": {
        "paymentId": 1,
        "paymentMode": "CASH",
        "paymentStatus": "SUCCESS",
        "paymentDate": "2025-05-26T11:13:30.455845Z"
    }
}
------------------------------------------------------------
SERVICE: cloud-gateway
GET:
http://localhost:9090/orders/1
{
    "orderId": 1,
    "orderDate": "2025-05-26T11:13:30.325950Z",
    "orderStatus": "PLACED",
    "amount": 1100,
    "productDetails": {
        "productName": "IPhone",
        "productId": 3,
        "quantity": 0,
        "price": 0
    },
    "paymentDetails": {
        "paymentId": 1,
        "paymentMode": "CASH",
        "paymentStatus": "SUCCESS",
        "paymentDate": "2025-05-26T11:13:30.455845Z"
    }
}

Now shutdown order service and hit again in insomnia

SERVICE: cloud-gateway
GET:
http://localhost:9090/orders/1
Response:
Order Service is down!