# 🔐 Group String Encoder - TMF 2954

**Course:** TMF 2954 Java Programming (Semester 2, 2025/2026)  
**Group ID:** `G04/SE-G06` 

## 📖 Project Overview
This project is a Java Swing-based graphical application that generates an encoded version of a user-provided string. The encoding process uses a unique, hidden group-specific shift key derived dynamically from the group's registration ID. This ensures that the encoded output is distinct and traceable to our specific student group.

## 👥 Team Members & Contributions

| Name | Role | Core Contributions |
| :--- | :--- | :--- |
| **[Member 1: FERNANDEZ RUGU (104184) ]** | Backend Logic | Implemented `applyCipher()` shifting logic for letters and digits. |
| **[Member 2: BATRISYA QISTINA BINTI JUMRY (103516)]** | GUI Developer | Designed the Java Swing interface (`EncoderGUI.java`). |
| **[Member 3: ELISA PETRI ANAK EKSON (102534)]** | Validation & Hash | Implemented `checkStringValidity()`, `countCharacters()`, and `generateShift()`. |
| **[Member 4: KHIEW JUNG HUAT (104669)]** | Lead Integrator | Managed `Assignment.java`, wired action listeners, handled GitHub merging. |
| **[Member 5: AHMAD FAKHRURIZZUDIN BIN AHMAD FAIRUZ (103118)]** | Documentation | Managed code contributor tags, authored the 2-page technical report. |

## ✨ Features
*   **Java Swing GUI:** A user-friendly interface with input fields, action buttons, and a structured display area.
*   **Input Validation:** Ensures only lowercase alphanumeric characters (a-z, 0-9) and spaces are accepted.
*   **Custom Cipher:** 
    *   Calculates a `groupShift` value (1-10) using the `hashCode()` of the hidden Group ID.
    *   Final shift is determined by `groupShift` + total non-space characters.
    *   Wraps characters correctly using modulo arithmetic (`% 26` for letters, `% 10` for digits).
