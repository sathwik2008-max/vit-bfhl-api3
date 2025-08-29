# BFHL REST API

A Spring Boot REST API that processes arrays of data and returns categorized results.

## Features

- **POST /bfhl** - Main endpoint that processes input data arrays
- **GET /** - Form-based web interface for data processing
- Comprehensive error handling
- Input validation
- Cross-origin support
- User-friendly form interface
- Real-time data processing with visual feedback
- Interactive examples for testing

## API Endpoint

### POST /bfhl

Processes an array of data and returns categorized results.

**Request Body:**
```json
{
  "data": ["a", "1", "334", "4", "R", "$"],
  "fullName": "Vishal Madineni",
  "email": "madinenivishal@gmail.com",
  "rollNumber": "22BCE7757"
}
```

**Response:**
```json
{
  "is_success": true,
  "user_id": "vishal_madineni_29082025",
  "email": "madinenivishal@gmail.com",
  "roll_number": "22BCE7757",
  "odd_numbers": ["1"],
  "even_numbers": ["334", "4"],
  "alphabets": ["A", "R"],
  "special_characters": ["$"],
  "sum": "339",
  "concat_string": "Ra"
}
```

## Response Fields

1. **is_success**: Boolean indicating operation status
2. **user_id**: Generated in format `{full_name_ddmmyyyy}`
3. **email**: User email address
4. **roll_number**: College roll number
5. **odd_numbers**: Array of odd numbers (as strings)
6. **even_numbers**: Array of even numbers (as strings)
7. **alphabets**: Array of alphabets converted to uppercase
8. **special_characters**: Array of special characters
9. **sum**: Sum of all numbers (as string)
10. **concat_string**: Concatenated alphabets in reverse order with alternating caps

## Technology Stack

- **Java 17**
- **Spring Boot 3.2.0**
- **Maven**
- **Spring Web**
- **Spring Validation**

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## Local Development Setup

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd bfhl-api
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the API:**
   - Main endpoint: `http://localhost:8080/bfhl`
   - Web interface: `http://localhost:8080/`

## Web Interface

The project includes a user-friendly form interface for data processing:

### Features:
- 📝 **Form-based Interface**: Collects user details and data array
- ⚡ **Real-time Processing**: Instant data processing with visual feedback
- 🎯 **Input Validation**: Validates all required fields
- 📱 **Mobile Responsive**: Works perfectly on all devices
- 🔄 **Live Status**: Real-time status indicators and loading animations
- 📋 **Interactive Examples**: Pre-loaded test cases from the exam

### Form Fields:
- **Full Name**: User's complete name
- **Email Address**: User's email for contact
- **College Roll Number**: Student's roll number
- **Data Array**: JSON array for processing

### Access:
- **Main Interface**: `http://localhost:8080/`

## Testing the API

### Web Interface Testing:
1. Visit `http://localhost:8080/`
2. Fill in your personal details (name, email, roll number)
3. Enter or select a data array for processing
4. Click "Process Data" to submit
5. View the processing results

### Command Line Testing:
```bash
curl -X POST http://localhost:8080/bfhl \
  -H "Content-Type: application/json" \
  -d '{"data": ["a", "1", "334", "4", "R", "$"], "fullName": "Vishal Madineni", "email": "madinenivishal@gmail.com", "rollNumber": "22BCE7757"}'
```

### Example 2:
```bash
curl -X POST http://localhost:8080/bfhl \
  -H "Content-Type: application/json" \
  -d '{"data": ["2", "a", "y", "4", "&", "-", "*", "5", "92", "b"], "fullName": "Vishal Madineni", "email": "madinenivishal@gmail.com", "rollNumber": "22BCE7757"}'
```

### Example 3:
```bash
curl -X POST http://localhost:8080/bfhl \
  -H "Content-Type: application/json" \
  -d '{"data": ["A", "ABcD", "DOE"], "fullName": "Vishal Madineni", "email": "madinenivishal@gmail.com", "rollNumber": "22BCE7757"}'
```

## Deployment

### Railway Deployment

1. Create a Railway account
2. Connect your GitHub repository
3. Railway will automatically detect the Spring Boot application
4. Deploy and get your live URL

### Vercel Deployment

1. Create a `vercel.json` file in the root directory
2. Connect your GitHub repository to Vercel
3. Deploy the application

### Render Deployment

1. Create a Render account
2. Connect your GitHub repository
3. Set build command: `mvn clean install`
4. Set start command: `java -jar target/bfhl-api-1.0.0.jar`
5. Deploy the application

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── bfhlapi/
│   │               ├── BfhlApiApplication.java
│   │               ├── controller/
│   │               │   └── BfhlController.java
│   │               ├── dto/
│   │               │   ├── DataRequest.java
│   │               │   └── DataResponse.java
│   │               ├── service/
│   │               │   └── DataProcessingService.java
│   │               └── exception/
│   │                   └── GlobalExceptionHandler.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/
            └── example/
                └── bfhlapi/
                    └── BfhlApiApplicationTests.java
```

## Error Handling

The API includes comprehensive error handling:
- Input validation errors (400 Bad Request)
- Internal server errors (500 Internal Server Error)
- All errors return the same response structure with `is_success: false`

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## License

This project is open source and available under the MIT License.
