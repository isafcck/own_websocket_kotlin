Here’s the README for your WebSocket client project:

---

# Kotlin WebSocket Client

This is a simple WebSocket client built in Kotlin using the **Ktor** framework. It connects to a WebSocket server, sends messages, and receives real-time responses.

## Features
- Establishes a WebSocket connection.
- Sends messages to a WebSocket server.
- Receives messages asynchronously.
- Handles graceful disconnection.

---

## Folder Structure

```
websocket-client/
├── src/                      # Source code
│   ├── main/                 # Main application code
│   │   ├── kotlin/           # Kotlin source files
│   │   │   ├── client/       # WebSocket client logic
│   │   │   ├── utils/        # Helper utilities
│   ├── test/                 # Unit tests
├── build.gradle.kts          # Build script for Kotlin
├── settings.gradle.kts       # Gradle settings
├── README.md                 # Project documentation
├── .gitignore                # Git ignore rules
```

---

## Prerequisites
- **Kotlin** 1.9+
- **Gradle** 7.0+
- **JDK** 11+

---

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/isafcck/own_websocket_kotlin.git
   cd websocket-client
   ```

2. Build the project:
   ```bash
   ./gradlew build
   ```

3. Run the application:
   ```bash
   ./gradlew run
   ```

---

## Testing
To run the unit tests:
```bash
./gradlew test
```

---

## Contributing
Feel free to submit issues or pull requests to improve the functionality.

---

## License
This project is licensed under the MIT License.

--- 

Let me know if you want this customized further!
