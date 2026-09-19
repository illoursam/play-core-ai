# play-core-ai
Decentralized edge computing framework leveraging idle AndroidPlay-Core AI: Decentralized Edge Computing Framework for Android
📖 Overview
Play-Core AI is an experimental open-source framework designed to leverage the massive, untapped pool of global Android devices for decentralized edge computing. By turning idle, charging smartphones into lightweight micro-nodes during off-peak hours, Play-Core AI aims to reduce the world's reliance on power-hungry data centers while democratizing AI workloads.
🏗️ Technical Architecture
The core challenge of mobile edge computing is balancing computational throughput with device longevity, battery health, and thermal limits. Play-Core AI solves this through three core layers:
1. Idle & Power-State Detection Layer
To ensure zero friction for the end-user, the node agent operates strictly under strict system constraints:
Power State Hook: Triggers computation strictly when the device is connected to a power outlet (typically overnight).
Doze Mode Integration: Aligns with Android's native Doze and App Standby mechanisms to wake up only during maintenance windows or deep sleep cycles without draining the battery.
Thermal Monitoring: Continuously polls thermal sensors; halts execution immediately if device temperature exceeds safe thresholds.
2. Task Sharding & Micro-Distribution
Heavy AI inferences or data processing tasks are broken down into lightweight asynchronous payloads:
Workload Fragmentation: Large models or datasets are sharded into micro-tasks.
Local Execution Engine: Leverages on-device hardware acceleration (NPUs, GPUs) via lightweight runtimes (e.g., TensorFlow Lite / ONNX Runtime Mobile) to process local fragments securely.
Resilient Sync: Uses differential synchronization to send back only computed weights or results, minimizing bandwidth usage.
3. Security & Data Sovereignty
End-to-End Encryption: All sharded payloads are encrypted in transit and at rest.
Ephemeral Processing: Data is processed locally in isolated memory sandboxes and wiped immediately after transmission.
🛠️ Tech Stack & Requirements (Target)
Language: Kotlin / C++ (for native performance bindings)
Frameworks: Android SDK, WorkManager API, JobScheduler, TensorFlow Lite
Architecture: Peer-to-Peer (P2P) decentralized mesh network over lightweight protocols (MQTT / WebRTC). devices.
