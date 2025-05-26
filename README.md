# Microservices Demo: Service Start Order & API Testing

## 🔁 Start Services in the Following Order:

1. `service-registry`
2. `config-server`
3. `cloud-gateway`
4. `product-service`
5. `order-service`
6. `payment-service`

---

## 📦 SERVICE: `product-service`

### ➕ POST `/products`

**URL:**
```
http://localhost:8080/products
```

**Request Body:**
```json
{
    "name": "IPhone",
    "price": 20000.0,
    "quantity": 20.0
}
```

**Response:**
```
201 Created
```

---

### 🔍 GET `/products/{id}`

**URL:**
```
http://localhost:8080/products/1
```

---

## 🧾 SERVICE: `order-service`

### 🛒 POST `/orders/placeOrder`

**URL:**
```
http://localhost:8082/orders/placeOrder
```

**Request Body:**
```json
{
    "productId": 1,
    "totalAmount": 1100,
    "quantity": 100,
    "paymentMode": "CASH"
}
```

---

## 📦 SERVICE: `product-service`

### 🔄 PUT `/products/reduceQuantity/{id}`

**Positive Case:**
```
http://localhost:8080/products/reduceQuantity/1
```

**Negative Case:**
```
http://localhost:8080/products/reduceQuantity/1?quantity=200
```

---

## 🧾 SERVICE: `order-service`

### 🔍 GET `/orders/{id}`

**URL:**
```
http://localhost:8082/orders/1
```

**Sample Response:**
```json
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
```

---

## 🌐 SERVICE: `cloud-gateway`

### 🔍 GET `/orders/{id}`

**URL:**
```
http://localhost:9090/orders/1
```

**Response:**
```json
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
```

---

## 🧪 Test Circuit Breaker

### ❌ Shutdown `order-service`, then retry:

**URL:**
```
http://localhost:9090/orders/1
```

**Response:**
```
Order Service is down!
```
